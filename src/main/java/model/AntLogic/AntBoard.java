package model.AntLogic;


import model.AntLogic.AntBoardField;
import model.problem.AntChromosome;
import model.problem.AntGene;
import model.problem.AntMove;
import model.problem.Chromosome;
import utils.Point;

import java.util.Random;

public class AntBoard {
    AntBoardField[][] antBoard;
    final int xSize;
    final int ySize;
    static final int FIELD_VALUE_LIMIT = 10;
    Random rand = new Random();

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public AntBoard(int xSize, int ySize) {
        this.antBoard = new AntBoardField[xSize][ySize]; //rows, columns
        this.xSize = xSize;
        this.ySize = ySize;
        fillAntBoard();
    }

    private void fillAntBoard(){
        for(int i = 0; i < this.xSize; i ++){ // rows
            for(int j = 0; j < this.ySize; j ++){ // columns
                this.antBoard[i][j] = new AntBoardField
                        (generateValueForAntField(), generatePheromoneStrength(i, j), i, j);
            }
        }
    }

    private int generatePheromoneStrength(int xLocation, int yLocation) {
        int neededMoves = xSize + ySize - 2;
        int movesMade = xLocation + yLocation;
        double neededMovesDouble = (double) neededMoves;
        double movesMadeDouble = (double) (movesMade + 1);

        int pheromoneStrength = (int) Math.ceil((movesMadeDouble * 3 / neededMovesDouble)) ;
        return pheromoneStrength;
    }

    private int generateValueForAntField(){
        return rand.nextInt(FIELD_VALUE_LIMIT);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\n");
        builder.append(" ");
        for(int k = 0; k < xSize; k++){
            builder.append(" -------");

        }
        builder.append("\n");
        for(int i = 0; i < ySize; i ++){
            builder.append(" |   ");
            for(int j = 0; j < xSize; j++){
                builder.append(getFieldFood(j, i)).append("   |   ");
            }
            builder.append("\n");
            builder.append(" ");
            for(int k = 0; k < xSize; k++){
                builder.append(" -------");

            }

            builder.append("\n");
        }
        return builder.toString();
    }

    public String ChromosomePathAndResultToString(Chromosome<AntGene> printedChromosome){
        int printedGenes = 0;
        StringBuilder builder = new StringBuilder("\n");
        builder.append("Result : " + printedChromosome.getChromosomeFitnessValue() + " \n");
        builder.append(" ");
        for(int k = 0; k < xSize; k++){
            builder.append(" -------");

        }
        builder.append("\n");
        for(int i = 0; i < ySize; i ++){
            builder.append(" |  ");
            for(int j = 0; j < xSize; j++){
                AntGene printedGene = printedChromosome.getGenes().get(printedGenes);
                if(isGeneOnThisLocation(printedGene, j, i)){
                    printedGenes++;
                    builder.append(getSimbolForMove(printedGene.getAntMove()));
                }
                else
                    builder.append("   ");
                builder.append("  |  ");
            }
            builder.append("\n");
            builder.append(" ");
            for(int k = 0; k < xSize; k++){
                builder.append(" -------");

            }

            builder.append("\n");
        }
        return builder.toString();
    }

    private boolean isGeneOnThisLocation(AntGene antGene, int xLocation, int yLocation){
        return antGene.getAntBoardField().getLocation().getyLocation() == yLocation
                && antGene.getAntBoardField().getLocation().getxLocation() == xLocation;
    }

    private String getSimbolForMove(AntMove move){
        if(move == AntMove.RIGHT)
            return "-->";
        else
            return "\\|/";

    }

    private int getFieldFood(int xLocation, int yLocation){
        if(xLocation > this.xSize || yLocation > this.ySize){
            throw new IllegalArgumentException("Out of Ant board!");
        }
        return this.antBoard[xLocation][yLocation].getFoodPoints();
    }

    public AntBoardField getField(int xLocation, int yLocation){//this
        if(xLocation > this.xSize - 1 || yLocation > this.ySize - 1){
            throw new IllegalArgumentException("Out of Ant board!");
        }
        return this.antBoard[xLocation][yLocation];
    }

    public boolean isOnExitEdge(Point point){
        int xLocation = point.getxLocation();
        int yLocation = point.getyLocation();
        if(xLocation > this.xSize - 1 || yLocation > this.ySize - 1){
            throw new IllegalArgumentException("Out of Ant board!");
        }
        if(xLocation == this.xSize - 1 || yLocation == this.ySize - 1){
            return true;
        }
        else
            return false;
    }

    public boolean areFieldsOnSameY(AntBoardField firstField, AntBoardField secondField){//this
        return firstField.getLocation().getyLocation() == secondField.getLocation().getyLocation();
    }
}
