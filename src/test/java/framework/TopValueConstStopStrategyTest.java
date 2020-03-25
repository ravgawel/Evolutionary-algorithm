package framework;

import framework.stopstrategy.TopValueConstStopStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopValueConstStopStrategyTest {
    TopValueConstStopStrategy topValueConstStopStrategy = new TopValueConstStopStrategy();
    @Test
    public void isAlgorithmWorking() {
        boolean stoppedWorking = false;
        assertEquals(stoppedWorking, topValueConstStopStrategy.isAlgorithmWorking());
    }
}