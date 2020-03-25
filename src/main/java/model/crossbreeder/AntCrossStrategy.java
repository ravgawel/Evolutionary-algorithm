package model.crossbreeder;

import model.AntLogic.AntBoard;
import model.problem.AntChromosome;
import model.problem.AntGene;
import model.problem.AntMove;
import model.problem.Chromosome;
import utils.Point;

import java.util.ArrayList;
import java.util.List;

public class AntCrossStrategy implements ICrossStrategy<AntGene> {
    AntBoard antBoard;

    public AntCrossStrategy(AntBoard antBoard) {
        this.antBoard = antBoard;
    }

    @Override
    public List<Chromosome<AntGene>> crossChromosomes(List<Chromosome<AntGene>> chromosomes) {
        List<Chromosome<AntGene>> chromosomesAfterCrossing = new ArrayList<>(chromosomes);
        for(int i = 0; i < chromosomes.size(); i++){
            boolean madeCross = false;
            for(int j = 0; j < chromosomes.size() & !madeCross; j++){
                if(i != j) {
                    List<Point> crossingPoints = findCrossingPointsBetweenChromosomes(chromosomes.get(i), chromosomes.get(j));
                    if (crossingPoints.size() > 2) {
                        AntChromosome newBornChromosome = crossTwoPaths(chromosomes.get(i), chromosomes.get(j),
                                crossingPoints.get(crossingPoints.size() - 1), i < j);
                        chromosomesAfterCrossing.add(newBornChromosome);
                        //System.out.println(newBornChromosome.toString());
                        madeCross = true;
                    }
                }
            }
        }
        return chromosomesAfterCrossing;
    }
    private List<Point> findCrossingPointsBetweenChromosomes(Chromosome<AntGene> firstChromosome, Chromosome<AntGene> secondChromosome){
        int genesAmount = firstChromosome.getGenes().size();
        List<AntGene> firstChromosomeGenes = firstChromosome.getGenes();
        List<AntGene> secondChromosomeGenes = secondChromosome.getGenes();
        AntGene firstGene;
        AntGene secondGene;
        Point firstGenePoint;
        Point secondGenePoint;
        List<Point> crossingPoints = new ArrayList<>();
        for(int i = 0; i < genesAmount; i ++){
            firstGene = firstChromosomeGenes.get(i);
            secondGene = secondChromosomeGenes.get(i);
            firstGenePoint = firstGene.getAntBoardField().getLocation();
            secondGenePoint = secondGene.getAntBoardField().getLocation();
            if(firstGenePoint.equals(secondGenePoint) && !this.antBoard.isOnExitEdge(firstGenePoint))
                crossingPoints.add(firstGenePoint);
        }
        return crossingPoints;
    }

    private AntChromosome crossTwoPaths(Chromosome<AntGene> firstChromosome, Chromosome<AntGene> secondChromosome,
                               Point cross, boolean beginsWithFirst){
        int xLocation = cross.getxLocation();
        int yLocation = cross.getyLocation();
        //System.out.println(firstChromosome.toString());
        //System.out.println(secondChromosome.toString());
        int positionInOrder = xLocation + yLocation;
        List<AntGene> newChromosomeGenes = new ArrayList<>();
        List<AntGene> newChromosomeGenesTail = new ArrayList<>();
        AntGene connectingGene;
        if(beginsWithFirst) {
            newChromosomeGenes.addAll(firstChromosome.getGenes().subList(0, positionInOrder));
            connectingGene = new AntGene(firstChromosome.getGenes().get(positionInOrder).getAntBoardField(),
                    firstChromosome.getGenes().get(positionInOrder).getAntMove());
            newChromosomeGenesTail.addAll(secondChromosome.getGenes().subList(positionInOrder + 1, secondChromosome.getGenes().size()));
        }
        else{
            newChromosomeGenes.addAll(secondChromosome.getGenes().subList(0, positionInOrder));
            connectingGene = new AntGene(secondChromosome.getGenes().get(positionInOrder).getAntBoardField(),
                    secondChromosome.getGenes().get(positionInOrder).getAntMove());
            newChromosomeGenesTail.addAll(firstChromosome.getGenes().subList(positionInOrder + 1, firstChromosome.getGenes().size()));
        }
        connectingGene = setConnectingPointCorrectDirection(connectingGene, newChromosomeGenesTail.get(0));
        newChromosomeGenes.add(connectingGene);
        newChromosomeGenes.addAll(newChromosomeGenesTail);
        return new AntChromosome(newChromosomeGenes);
    }
    private AntGene setConnectingPointCorrectDirection(AntGene connectingGene, AntGene nextGene){
        if(antBoard.areFieldsOnSameY(connectingGene.getAntBoardField(), nextGene.getAntBoardField()))
            connectingGene.setAntMove(AntMove.RIGHT);
        else
            connectingGene.setAntMove(AntMove.DOWN);
        return connectingGene;
    }

}
