package model.evaluator;

import model.AntLogic.AntBoard;
import model.initializer.AntInitStrategy;
import model.mutator.AntMutateStrategy;
import model.problem.AntChromosome;
import model.problem.AntGene;
import model.problem.AntProblem;
import model.problem.Chromosome;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AntEvalStrategyTest {
    AntBoard board;
    AntMutateStrategy mutator;
    AntInitStrategy initor;
    AntEvalStrategy evaluator;
    List<Chromosome<AntGene>> chromosomes;
    AntProblem problem;
    @Before
    public void init(){
        board = new AntBoard( 10, 10);
        problem = new AntProblem();
        mutator = new AntMutateStrategy(board);
        initor = new AntInitStrategy(board);
        evaluator = new AntEvalStrategy(problem);
        chromosomes = initor.initChromosomes(10, 1);
    }

    @Test
    public void evaluateChromosomes() {
        List<Chromosome<AntGene>> evaluated = evaluator.evaluateChromosomes(chromosomes);
        for(Chromosome chromosome: evaluated){
            assertNotNull(chromosome.getChromosomeFitnessValue());
        }
    }
}