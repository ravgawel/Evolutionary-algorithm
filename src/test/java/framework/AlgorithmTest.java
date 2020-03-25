package framework;

import framework.stopstrategy.GenerationsCountStopStrategy;
import framework.stopstrategy.IStopStrategy;
import model.crossbreeder.FloatCrossStrategy;
import model.evaluator.PolynomialEvalStrategy;
import model.initializer.FloatInitStrategy;
import model.mutator.FloatMutateStrategy;
import model.problem.PolynomialProblem;
import model.selector.SelectTopNStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmTest {
    Algorithm algorithm;
    IStopStrategy stopStrategy = new GenerationsCountStopStrategy(2);
    PolynomialProblem problem;
    float[] polynomial = new float[]{1,2,3};

    @Before
    public void init() {
        problem = new PolynomialProblem(polynomial);


        algorithm = new Algorithm.AlgorithmBuilder(stopStrategy, problem)
                .initStrategy(new FloatInitStrategy())
                .crossStrategy(new FloatCrossStrategy(2))
                .mutateStrategy(new FloatMutateStrategy(1, 1))
                .evalStrategy(new PolynomialEvalStrategy(problem))
                .selectStrategy(new SelectTopNStrategy(2))
                .name("Polynomial").build();

    }

    @Test
    public void setProblemChromosomes() {
    }

    @Test
    public void getName() {
        assertEquals(algorithm.getName(), "Polynomial");
    }

    @Test
    public void getStopStrategy() {
        assertNotNull(algorithm.getStopStrategy());
    }

    @Test
    public void getProblem() {
        assertNotNull(algorithm.getProblem());
    }

    @Test
    public void getCrossStrategy() {
        assertNotNull(algorithm.getCrossStrategy());
    }

    @Test
    public void getInitStrategy() {
        assertNotNull(algorithm.getInitStrategy());
    }

    @Test
    public void getMutateStrategy() {
        assertNotNull(algorithm.getMutateStrategy());
    }

    @Test
    public void getEvalStrategy() {
        assertNotNull(algorithm.getEvalStrategy());
    }

    @Test
    public void getSelectStrategy() {
        assertNotNull(algorithm.getSelectStrategy());
    }

    @Test
    public void run() {
        algorithm.run();
    }
}