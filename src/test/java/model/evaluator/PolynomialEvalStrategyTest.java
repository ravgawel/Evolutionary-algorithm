package model.evaluator;

import model.problem.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PolynomialEvalStrategyTest {
    PolynomialProblem problem;
    PolynomialProblem problemMin;
    IEvalStrategy<FloatGene> strategy;
    IEvalStrategy<FloatGene> strategyMin;
    float[] polynomial = new float[]{1,2,3};
    List<Chromosome<FloatGene>> list;
    List<Chromosome<FloatGene>> listMin;
    List<FloatGene> genes1;
    List<FloatGene> genes2;
    List<FloatGene> genesMin1;
    List<FloatGene> genesMin2;

    @Before
    public void init(){
        problem = new PolynomialProblem(polynomial, -10.0f, 10.0f, true);
        problemMin = new PolynomialProblem(polynomial, -10.0f, 10.0f, false);
        strategy = new PolynomialEvalStrategy(problem);
        strategyMin = new PolynomialEvalStrategy(problemMin);

        FloatGene gene1 = new FloatGene(-5);
        genes1 = new ArrayList<>();
        genes1.add(gene1);

        FloatGene gene2 = new FloatGene(5);
        genes2 = new ArrayList<>();
        genes2.add(gene2);

        Gene geneMin1 = new FloatGene(3);
        genesMin1 = new ArrayList<>();
        genesMin1.add(gene1);

        Gene geneMin2 = new FloatGene(7);
        genesMin2 = new ArrayList<>();
        genesMin2.add(gene2);

        FloatChromosome chromosome1 = new FloatChromosome(genes1);
        FloatChromosome chromosome2 = new FloatChromosome(genes2);

        FloatChromosome chromosomeMin1 = new FloatChromosome(genesMin1);
        FloatChromosome chromosomeMin2 = new FloatChromosome(genesMin2);

        listMin = new ArrayList<>();
        listMin.add(chromosomeMin1);
        listMin.add(chromosomeMin2);

        list = new ArrayList<>();
        list.add(chromosome1);
        list.add(chromosome2);
    }

    @Test
    public void evaluateChromosomes() {
        List evaluated = strategy.evaluateChromosomes(list);
        Chromosome c1 = (Chromosome) evaluated.get(0);
        Chromosome c2 = (Chromosome) evaluated.get(1);

        assertEquals(c1.getChromosomeFitnessValue(), 66.0, 0.1);
        assertEquals(c2.getChromosomeFitnessValue(), 86.0, 0.1);

        List evaluatedMin = strategyMin.evaluateChromosomes(listMin);
        Chromosome cMin1 = (Chromosome) evaluated.get(0);
        Chromosome cMin2 = (Chromosome) evaluated.get(1);

        assertEquals(cMin1.getChromosomeFitnessValue(), 66.0, 0.1);
        assertEquals(cMin2.getChromosomeFitnessValue(), 86.0, 0.1);
    }
}