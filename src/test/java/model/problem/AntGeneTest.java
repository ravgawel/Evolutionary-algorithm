package model.problem;

import model.AntLogic.AntBoard;
import model.AntLogic.AntBoardField;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AntGeneTest {
    AntBoard board;
    AntBoardField downEdge;
    AntBoardField rightEdge;
    AntBoardField outOfBoard;
    AntGene gene1;
    AntGene gene2;
    AntGene gene3;

    @Before
    public void init(){
         board = new AntBoard(10, 10);
         downEdge = new AntBoardField(3, 3, 3, 9);
         rightEdge = new AntBoardField(3, 3, 9, 3);
         outOfBoard = new AntBoardField(0, 0, 12, 10);
         gene1 = new AntGene(downEdge, AntMove.RIGHT);
         gene2 = new AntGene(rightEdge, AntMove.DOWN);
         gene3 = new AntGene(outOfBoard, AntMove.DOWN);
    }

    @Test
    public void getAntBoardField() {
        init();
        AntBoardField field = new AntBoardField(3, 3, 3, 10);
        assertNotEquals(field, rightEdge);
        gene1.setAntBoardField(field);
        assertEquals(field , gene1.getAntBoardField());
    }

    @Test
    public void setAntBoardField() {
        AntGene createdGene = new AntGene(rightEdge, AntMove.RIGHT);
        AntBoardField createdField = new AntBoardField(0, 0, 0, 0);
        createdGene.setAntBoardField(createdField);
        assertEquals(createdField, createdGene.getAntBoardField());
    }

    @Test
    public void getAntMove() {
        assertEquals(AntMove.RIGHT, gene1.getAntMove());
        assertNotEquals(AntMove.DOWN, gene1.getAntMove());
        assertEquals(AntMove.DOWN, gene2.getAntMove());
        assertNotEquals(AntMove.RIGHT, gene2.getAntMove());
        assertEquals(AntMove.DOWN, gene3.getAntMove());
        assertNotEquals(AntMove.RIGHT, gene3.getAntMove());
    }

    @Test
    public void setAntMove() {
        gene1.setAntMove(AntMove.DOWN);
        assertEquals(AntMove.DOWN, gene1.getAntMove());
        assertNotEquals(AntMove.RIGHT, gene1.getAntMove());
        assertNotEquals(null, gene1.getAntMove());
    }
}