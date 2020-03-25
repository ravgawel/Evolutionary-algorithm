package model.problem;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;


public class FloatChromosomeTest {
    @Test
    public void properConstructors(){
        Chromosome chromosome1 = new FloatChromosome();
        Chromosome chromosome2 = new FloatChromosome(Arrays.asList(new FloatGene(1)));

        assertEquals(0,chromosome1.getGenes().size());
        assertEquals(1,chromosome2.getGenes().size());
    }
}
