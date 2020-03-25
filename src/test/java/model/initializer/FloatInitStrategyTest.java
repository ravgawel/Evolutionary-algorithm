package model.initializer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloatInitStrategyTest {
    FloatInitStrategy init;

    @Before
    public void init() {
        init = new FloatInitStrategy();
    }


    @Test
    public void initChromosomes() {
        assertEquals(init.initChromosomes(10,1).size(), 10);
        assertEquals(init.initChromosomes(10, 1, 1.0f, 10.0f).size(), 10);
    }

    @Test
    public void initGenes() {
        assertEquals(init.initGenes(1).size(), 1);
    }
}