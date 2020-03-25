package model.initializer;

import model.AntLogic.AntBoard;
import model.problem.*;
import utils.Point;

import java.util.ArrayList;
import java.util.List;

public class AntInitStrategy implements IInitStrategy<AntGene> {
    public static final int AMOUNT_OF_MOVES = 2;
    AntBoard antBoard;

    public AntInitStrategy(AntBoard antBoard) {
        this.antBoard = antBoard;
    }



    @Override
    public List<Chromosome<AntGene>> initChromosomes(int chromosomesAmount, int chromosomeSize) {
        List<Chromosome<AntGene>> chromosomes = new ArrayList<>();
        for(int i = 0; i < chromosomesAmount; i++){
            AntChromosome antChromosome = new AntChromosome(initGenes
                    (antBoard.getxSize() + antBoard.getySize() - 1));
            chromosomes.add(antChromosome);
            //printAll(antChromosome);
        }
        return chromosomes;
    }

    public void printAll(Chromosome<AntGene> chromosome){
        StringBuilder megaBuilder = new StringBuilder();
            List<AntGene> genes = chromosome.getGenes();
            for(AntGene gene: genes) {
                megaBuilder.append("I am " + gene.getAntBoardField().getLocation().getxLocation() +
                        gene.getAntBoardField().getLocation().getyLocation() + " and I move " + gene.getAntMove().toString() + " ");
            }
            megaBuilder.append("\n");
        System.out.println(megaBuilder.toString());
    }

    @Override
    public List<AntGene> initGenes(int genesAmount) {
        List<AntGene> genes = new ArrayList<>();
        AntGene previousGene = new AntGene(this.antBoard.getField(0, 0), AntMove.getRandomMove());
        for(int i = 0; i < genesAmount; i++){
            if(i == 0) {
                genes.add(previousGene);
            }
            else{
                AntMove previousFieldMove = previousGene.getAntMove();
                Point previousFieldPosition = previousGene.getAntBoardField().getLocation();
                int xLocation, yLocation;
                if(previousFieldMove == AntMove.RIGHT){
                    xLocation = previousFieldPosition.getxLocation() + 1;
                    yLocation = previousFieldPosition.getyLocation();
                }
                else{
                    xLocation = previousFieldPosition.getxLocation();
                    yLocation = previousFieldPosition.getyLocation() + 1;
                }
                AntMove currentMove = AntMove.getRandomMove();
                if(xLocation == this.antBoard.getxSize() - 1)
                    currentMove = AntMove.DOWN;
                else if(yLocation == this.antBoard.getySize() - 1)
                    currentMove = AntMove.RIGHT;

                AntGene currentGene = new AntGene(this.antBoard.getField(xLocation, yLocation), currentMove);
                genes.add(currentGene);
                previousGene = currentGene;
            }
        }
        return genes;
    }
}
