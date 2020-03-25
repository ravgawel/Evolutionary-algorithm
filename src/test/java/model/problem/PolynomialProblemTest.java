package model.problem;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PolynomialProblemTest {
    PolynomialProblem problem;
    float[] polynomial = new float[]{1,2,3};


    @Before
    public void init(){
        problem = new PolynomialProblem(polynomial, 1.0f, 10.0f, true);
    }

    @Test
    public void getMinAndMax() {
        assertEquals(problem.getMaxX(), 10.0f, 0.1);
        assertEquals(problem.getMinX(), 1.0f, 0.1);
        assertEquals(problem.isSearchingForMax(), true);
    }

    @Test
    public void setAndGetChromosomes() {
        List<Chromosome<FloatGene>> list = new ArrayList<>();
        List<FloatGene> genes1;
        FloatGene gene1 = new FloatGene(1);
        genes1 = new ArrayList<>();
        genes1.add(gene1);

        FloatChromosome chromosome1 = new FloatChromosome(genes1);
        list.add(chromosome1);

        problem.setChromosomes(list);
        FloatGene gene = (FloatGene) problem.getChromosomes().get(0).getGenes().get(0);
        assertEquals(1, gene.getValue(), 0.1);
    }


    @Test
    public void getPolynomial() {
        assertEquals(new int[]{1,2,3}.length, problem.getPolynomial().length);
        assertEquals(1, problem.getPolynomial()[0], 0.1);
        assertEquals(2, problem.getPolynomial()[1], 0.1);
        assertEquals(3, problem.getPolynomial()[2], 0.1);
    }

    @Test
    public void testDefaultConstructor() {
        PolynomialProblem problem2 = new PolynomialProblem(polynomial);

        assertEquals(problem2.getMaxX(), 10.0f, 0.1);
        assertEquals(problem2.getMinX(), -10.0f, 0.1);
        assertEquals(problem2.isSearchingForMax(), true);
    }

}