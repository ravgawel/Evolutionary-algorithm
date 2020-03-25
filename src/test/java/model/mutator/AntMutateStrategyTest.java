package model.mutator;

import model.AntLogic.AntBoard;
import model.initializer.AntInitStrategy;
import model.problem.AntChromosome;
import model.problem.AntGene;
import model.problem.AntMove;
import model.problem.Chromosome;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AntMutateStrategyTest {
    AntBoard board;
    List<Chromosome<AntGene>> chromosomes;
    AntChromosome chromosome1;
    AntChromosome chromosome2;
    AntMutateStrategy mutator;
    AntInitStrategy initor;
    @Before
    public void init(){
        board = new AntBoard( 10, 10);
        chromosomes = new ArrayList<>();
        chromosomes.add(chromosome1);
        chromosomes.add(chromosome2);
        chromosome1 = new AntChromosome();
        chromosome2 = new AntChromosome();
        mutator = new AntMutateStrategy(board);
        initor = new AntInitStrategy(board);

    }

    @Test(expected = NullPointerException.class)
    public void mutateChromosomesUnInitiated() {
        mutator.mutateChromosomes(chromosomes);
    }

    @Test
    public void mutateChromosomes() {
        List<AntGene> genes1 = initor.initGenes(10);
        List<AntGene> genes2 = initor.initGenes(10);
        AntChromosome chromosome3 = new AntChromosome(genes1);
        AntChromosome chromosome4 = new AntChromosome(genes2);
        List<Chromosome<AntGene>> chrom = new ArrayList<>();
        chrom.add(chromosome3);
        chrom.add(chromosome4);
        assertNotNull(mutator.mutateChromosomes(chrom));
    }


    @Test(expected = UnsupportedOperationException.class)
    public void getMutationChanceTest() {
        mutator.setMutationChance(0.5f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setMutationChanceTest() {
        mutator.getMutationChance();
    }

}