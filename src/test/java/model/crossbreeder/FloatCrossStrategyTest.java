package model.crossbreeder;

import model.problem.Chromosome;
import model.problem.Gene;
import model.problem.FloatChromosome;
import model.problem.FloatGene;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FloatCrossStrategyTest {
    ICrossStrategy<FloatGene> cross = new FloatCrossStrategy(3);
    List<Chromosome<FloatGene>> list;
    List<FloatGene> genes1;
    List<FloatGene> genes2;

    @Before
    public void init() {
        FloatGene gene1 = new FloatGene(1);
        genes1 = new ArrayList<>();
        genes1.add(gene1);

        FloatGene gene2 = new FloatGene(5);
        genes2 = new ArrayList<>();
        genes2.add(gene2);

        Chromosome<FloatGene> chromosome1 = new FloatChromosome(genes1);
        Chromosome<FloatGene> chromosome2 = new FloatChromosome(genes2);

        list = new ArrayList<>();
        list.add(chromosome1);
        list.add(chromosome2);
    }

    @Test
    public void crossChromosomes() {
        List crossed = cross.crossChromosomes(list);
        assertEquals(crossed.size(), 3);

        Chromosome chromosome = (Chromosome) crossed.get(2);
        FloatGene fg = (FloatGene)(chromosome.getGenes().get(0));
        assertEquals(fg.getValue(), 3.0, 0.1);
    }
}