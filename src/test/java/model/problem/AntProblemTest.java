package model.problem;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AntProblemTest {
    AntProblem problem;
    AntChromosome chromosome1;
    AntChromosome chromosome2;
    List<Chromosome<AntGene>> chromosomes;

    @Before
    public void init(){
         problem = new AntProblem();
         chromosome1 = new AntChromosome();
         chromosome2 = new AntChromosome();
         chromosomes = new ArrayList<>();
    }

    @Test
    public void setChromosomes() {
        init();
        chromosomes.add(chromosome1);
        chromosomes.add(chromosome2);
        problem.setChromosomes(chromosomes);
        assertEquals(chromosomes, problem.getChromosomes());
        assertNotEquals(null, problem.getChromosomes());
    }

    @Test
    public void getChromosomes() {
        init();
        chromosomes.add(chromosome2);
        chromosomes.add(chromosome1);
        problem.setChromosomes(chromosomes);
        assertEquals(chromosomes, problem.getChromosomes());
        assertNotEquals(null, problem.getChromosomes());
    }
}