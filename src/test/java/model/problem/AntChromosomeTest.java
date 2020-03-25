package model.problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class AntChromosomeTest {

    @Test
    public void testToString() {
        AntChromosome chromosome = new AntChromosome();
        String isGeneratingBoard = chromosome.toString();
        assertNotEquals(null, isGeneratingBoard);
    }
}