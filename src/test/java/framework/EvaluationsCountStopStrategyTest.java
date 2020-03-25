package framework;

import framework.stopstrategy.EvaluationsCountStopStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluationsCountStopStrategyTest {

    @Test
    public void isAlgorithmWorking() {
        EvaluationsCountStopStrategy evaluationsCountStopStrategy = new EvaluationsCountStopStrategy();
        boolean stoppedWorking = false;
        int evalCount = 100;
        //TODO put eval count in stop
        assertEquals(evaluationsCountStopStrategy.isAlgorithmWorking(), false);

    }
}