package model.mutator;

import model.AntLogic.AntBoard;
import model.AntLogic.AntBoardField;
import model.problem.AntChromosome;
import model.problem.AntGene;
import model.problem.AntMove;
import model.problem.Chromosome;
import net.bytebuddy.implementation.bytecode.Throw;
import utils.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AntMutateStrategy implements IMutateStrategy<AntGene>{
    AntBoard antBoard;
    static Random random = new Random();
    private static final int VALUE_CAP_FOR_MUTATION = 100;

    public AntMutateStrategy(AntBoard antBoard) {
        this.antBoard = antBoard;
    }

    @Override
    public List<Chromosome<AntGene>> mutateChromosomes(List<Chromosome<AntGene>> chromosomes) {
        List<Chromosome<AntGene>> chromosomesAfterMutation = new ArrayList<>(chromosomes);
        for(int i = 0; i < chromosomes.size(); i ++){
            boolean mutationMade = false;
            AntChromosome currentChromosome = (AntChromosome) chromosomesAfterMutation.get(i);
            List<AntGene> genes = chromosomesAfterMutation.get(i).getGenes();
            for(int j = 0; j < genes.size() && !mutationMade; j++) {
                AntGene antGene = genes.get(j);
                int mutationVariable = random.nextInt(VALUE_CAP_FOR_MUTATION);
                if (mutationVariable < getMutationChanceForField(antGene.getAntBoardField().getLocation())) {
                    mutationMade = true;
                    mutateFromPoint(antGene.getAntBoardField().getLocation(), currentChromosome);
                }
            }
        }
        return chromosomesAfterMutation;
    }

    private void mutateFromPoint(Point mutationPoint, AntChromosome toMutate){
        int numberInOrder = mutationPoint.getxLocation() + mutationPoint.getyLocation();
        //System.out.println("Before Mutation \n");
        //System.out.println(toMutate.toString());
        List<AntGene> unmutatedGenes = toMutate.getGenes().subList(0, numberInOrder);
        List<AntGene> toBeMutatedGenes = toMutate.getGenes().subList(numberInOrder, toMutate.getGenes().size());
        AntGene firstMutated = toBeMutatedGenes.get(0); // mutation here changes next fields
        AntMove currentAntMove = firstMutated.getAntMove();
        AntBoardField currentAntField = firstMutated.getAntBoardField();
        /*We must create new connector gene to lose reference*/;
        AntGene newMutatedConnector = new AntGene(currentAntField, currentAntMove);
        AntMove newAntMove;
        if(!this.antBoard.isOnExitEdge(firstMutated.getAntBoardField().getLocation())) {
            newAntMove = getMutatedDirection(currentAntMove);
            newMutatedConnector.setAntMove(newAntMove);
        }

        List<AntGene> pathFromFirstMutatedToExit = generatePathToExit(newMutatedConnector);
        List<AntGene> pathAfterMutation = unmutatedGenes;
        pathAfterMutation.addAll(pathFromFirstMutatedToExit);
        toMutate.setGenes(pathAfterMutation);
        //System.out.println("After Mutation \n");
        //System.out.println(toMutate.toString());
    }

    private AntMove getMutatedDirection(AntMove currentAntMove) {
        if(currentAntMove == AntMove.RIGHT)
            return AntMove.DOWN;
        else
            return AntMove.RIGHT;
    }

    private int getMutationChanceForField(Point location){
        return this.antBoard.getField(location.getxLocation(), location.getyLocation()).getPheromoneStrength();
    }

    private List<AntGene> generatePathToExit(AntGene firstMutated){
        List<AntGene> pathToExit = new ArrayList<>();
        Point location = firstMutated.getAntBoardField().getLocation();
        int xSize = this.antBoard.getxSize();
        int ySize = this.antBoard.getySize();
        int stepsMade = location.getxLocation() + location.getyLocation();
        int stepsToReachExit = xSize + ySize - 2;
        AntGene previousGene = firstMutated;
        pathToExit.add(firstMutated);
        while(stepsMade < stepsToReachExit){
            stepsMade++;
            int nextFieldxLocation;
            int nextFieldyLocation;
            if(previousGene.getAntMove() == AntMove.RIGHT) {
                nextFieldxLocation = previousGene.getAntBoardField().getLocation().getxLocation() + 1;
                nextFieldyLocation = previousGene.getAntBoardField().getLocation().getyLocation();
            }
            else{
                nextFieldxLocation = previousGene.getAntBoardField().getLocation().getxLocation();
                nextFieldyLocation = previousGene.getAntBoardField().getLocation().getyLocation() + 1;
            }
            AntMove nextAntMove = AntMove.getRandomMove();
            if(nextFieldxLocation == xSize - 1)
                nextAntMove = AntMove.DOWN;
            else if(nextFieldyLocation == ySize - 1)
                nextAntMove = AntMove.RIGHT;

            AntBoardField nextField = this.antBoard.getField(nextFieldxLocation, nextFieldyLocation);
            AntGene antGene = new AntGene(nextField, nextAntMove);
            previousGene = antGene;
            pathToExit.add(antGene);
        }
        return pathToExit;
    }

    @Override
    public float getMutationChance() {
        throw new UnsupportedOperationException("getMutationChance operation is not supported");

    }

    @Override
    public void setMutationChance(float mutationChance) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setMutationChance operation is not supported");
    }
}
