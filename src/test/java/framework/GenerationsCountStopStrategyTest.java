package framework;

import framework.stopstrategy.GenerationsCountStopStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerationsCountStopStrategyTest {
    GenerationsCountStopStrategy stopStrategy = new GenerationsCountStopStrategy(1);

    @Test
    public void getCurrentGenerationNumber() {
        assertEquals(stopStrategy.getCurrentGenerationNumber(), 0);
        stopStrategy.setCurrentGenerationNumber(1);
        assertEquals(stopStrategy.getCurrentGenerationNumber(), 1);
    }

    @Test
    public void getMaxGenerationsNumber() {
        stopStrategy.setMaxGenerationsNumber(3);
        assertEquals(stopStrategy.getMaxGenerationsNumber(), 3);
    }

    @Test
    public void isAlgorithmWorking() {
        assertEquals(stopStrategy.isAlgorithmWorking(), true);
        stopStrategy.setCurrentGenerationNumber(3);
        assertEquals(stopStrategy.isAlgorithmWorking(), false);
    }
}