package model.problem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloatGeneTest {
    FloatGene gene;

    @Before
    public void init(){
        gene = new FloatGene(5.0f);
    }

    @Test
    public void getValue() {
        assertEquals(gene.getValue(), 5.0, 0.1);
    }

    @Test
    public void setValue() {
        gene.setValue(1.0f);
        assertEquals(gene.getValue(), 1.0, 0.1);
    }

    @Test
    public void testToString() {
        assertEquals("(" +gene.getValue()+ ")",gene.toString() );
    }

    @Test
    public void testHashAndEquals(){
        FloatGene gene1 = new FloatGene(1);
        FloatGene gene2 = new FloatGene(1);
        FloatGene geneDiff = new FloatGene(3);


        assertEquals(gene1,gene2);
        assertNotEquals(gene1,geneDiff);
        assertEquals(gene1.hashCode(),gene2.hashCode());
        assertNotEquals(gene1.hashCode(),geneDiff.hashCode());
    }
}