package framework.stopstrategy;

public class TimeElapsedStopStrategy implements IStopStrategy {

    private long algorithmEndTime;

    public long getAlgorithmEndTime() {
        return algorithmEndTime;
    }

    public void setAlgorithmEndTime(long algorithmEndTime) {
        this.algorithmEndTime = algorithmEndTime;
    }

    public TimeElapsedStopStrategy(long algorithmTime){
       this.algorithmEndTime=algorithmTime + System.currentTimeMillis();
   }

    public boolean isAlgorithmWorking() {
        return ( System.currentTimeMillis() < algorithmEndTime );
    }
}
