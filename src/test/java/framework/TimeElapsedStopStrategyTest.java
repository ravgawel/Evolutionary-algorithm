package framework;

import framework.stopstrategy.TimeElapsedStopStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeElapsedStopStrategyTest {
    @Test
    public void getTimeElapsed() {
        TimeElapsedStopStrategy timeElapsedStop1000s = new TimeElapsedStopStrategy(1000000);
        TimeElapsedStopStrategy timeElapsedStopNullTime = new TimeElapsedStopStrategy(0);
        assertNotSame(timeElapsedStopNullTime.getAlgorithmEndTime(), System.currentTimeMillis());
        assertNotSame(timeElapsedStop1000s.getAlgorithmEndTime(), System.currentTimeMillis() + 1000000);
    }
    @Test
    public void getAlgorithmEndTime() throws InterruptedException {
        long time = System.currentTimeMillis();
        long timeGet = 1000;
        TimeElapsedStopStrategy timeE = new TimeElapsedStopStrategy(timeGet);

        assertNotEquals(timeE.getAlgorithmEndTime(), time+timeGet);
    }
    @Test
    public void setAlgorithmEndTIme(){
        long timeSet = 1000;
        TimeElapsedStopStrategy timeE = new TimeElapsedStopStrategy(0);
        timeE.setAlgorithmEndTime(1000);
        assertEquals(timeE.getAlgorithmEndTime(), timeSet);
    }

    @Test
    public void isAlgorithmWorking() {
        TimeElapsedStopStrategy stop = new TimeElapsedStopStrategy(1000000);
        assertEquals(true, stop.isAlgorithmWorking());
    }

}
