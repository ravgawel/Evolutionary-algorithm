package model.problem;

import model.evaluator.IEvalStrategy;
import model.evaluator.PolynomialEvalStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ChromosomeTest {
    PolynomialProblem problem;
    IEvalStrategy<FloatGene> eval;
    float[] polynomial = new float[]{1,2,3};
    List<Chromosome<FloatGene>> list;
    List<FloatGene> genes1;
    List<FloatGene> genes2;
    Chromosome<FloatGene> chromosome1;
    Chromosome<FloatGene> chromosome2;
    @Before
    public void init(){
        problem = new PolynomialProblem(polynomial, -10.0f, 10.0f, true);
        eval = new PolynomialEvalStrategy(problem);


        FloatGene gene1 = new FloatGene(-5);
        genes1 = new ArrayList<>();
        genes1.add(gene1);

        FloatGene gene2 = new FloatGene(5);
        genes2 = new ArrayList<>();
        genes2.add(gene2);

        chromosome1 = new FloatChromosome(genes1);
        chromosome2 = new FloatChromosome(genes2);

        list = new ArrayList<>();
        list.add(chromosome1);
        list.add(chromosome2);
    }

    @Test
    public void compareTo() {
        List evaluated = eval.evaluateChromosomes(list);

        assertTrue(chromosome1.compareTo(chromosome2)<0);
    }

    @Test
    public void testToString() {
        assertEquals("[(" + chromosome1.genes.get(0).getValue() + ")]",chromosome1.toString());
    }

    @Test
    public void testGettersAndSettersFitnessValue(){
    }

    @Test
    public void testEqualsAndHashCode(){
        Chromosome<City> chrom1 = new Tour();
        Chromosome<City> chrom2 = new Tour();
        Chromosome<City> chromDiff = new Tour();
        chrom1.getGenes().add(new City(5, 3));
        chrom2.getGenes().add(new City(5, 3));
        chromDiff.getGenes().add(new City(2, 2));

        assertTrue(chrom1.equals(chrom2));
        assertFalse(chrom1.equals(chromDiff));
        assertFalse(chrom2.equals(chromDiff));
        assertEquals(chrom1.hashCode(),chrom2.hashCode());
        assertNotEquals(chrom1.hashCode(),chromDiff.hashCode());
    }
}