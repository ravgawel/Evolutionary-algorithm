package model.mutator;

import model.crossbreeder.ICrossStrategy;
import model.problem.Chromosome;
import model.problem.FloatGene;
import model.problem.Gene;
import model.problem.FloatChromosome;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FloatMutateStrategyTest {
    IMutateStrategy<FloatGene> mutator = new FloatMutateStrategy(1, 0);
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

        FloatChromosome chromosome1 = new FloatChromosome(genes1);
        FloatChromosome chromosome2 = new FloatChromosome(genes2);

        list = new ArrayList<>();
        list.add(chromosome1);
        list.add(chromosome2);
    }

    @Test
    public void mutateChromosomes() {
        List<Chromosome<FloatGene>> result = mutator.mutateChromosomes(list);
        mutator.setMutationChance(0.5f);

        assertEquals(list.size() , result.size());
        assertEquals(mutator.getMutationChance(), 0.5, 0.1);
    }
}