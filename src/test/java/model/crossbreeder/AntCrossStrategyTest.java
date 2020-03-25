package model.crossbreeder;

import model.AntLogic.AntBoard;
import model.evaluator.AntEvalStrategy;
import model.initializer.AntInitStrategy;
import model.mutator.AntMutateStrategy;
import model.problem.AntGene;
import model.problem.AntProblem;
import model.problem.Chromosome;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AntCrossStrategyTest {
    AntBoard board;
    AntInitStrategy initor;
    AntEvalStrategy evaluator;
    AntCrossStrategy crosser;
    List<Chromosome<AntGene>> chromosomes;
    AntProblem problem;
    @Before
    public void init(){
        board = new AntBoard( 10, 10);
        problem = new AntProblem();
        initor = new AntInitStrategy(board);
        evaluator = new AntEvalStrategy(problem);
        crosser = new AntCrossStrategy(board);
        chromosomes = initor.initChromosomes(10, 1);
    }

    @Test
    public void crossChromosomes() {
        assertNotNull(crosser.crossChromosomes(chromosomes));
    }
}