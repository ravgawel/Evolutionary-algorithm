package model.initializer;

import model.AntLogic.AntBoard;
import model.problem.AntGene;
import model.problem.Chromosome;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AntInitStrategyTest {
    AntBoard board;
    AntInitStrategy initor;

    @Before
    public void init(){
        board = new AntBoard(10, 10);
        initor = new AntInitStrategy(board);
    }


    @Test
    public void initChromosomes() {
        List<Chromosome<AntGene>> chromosomes = initor.initChromosomes(10, 2);
        assertNotNull(chromosomes);
    }

    @Test
    public void initGenes() {
        List<AntGene> antGenes = initor.initGenes(10);
        assertNotNull(antGenes);
    }
}