package model.problem;

import model.initializer.AntInitStrategy;

import java.util.Random;

public enum AntMove {
    RIGHT,
    DOWN;

    public static AntMove getRandomMove(){
        Random rand = new Random();
        int randomizedMove = rand.nextInt(AntInitStrategy.AMOUNT_OF_MOVES);
        if(randomizedMove == 0)
            return RIGHT;
        else
            return DOWN;
    }
}
