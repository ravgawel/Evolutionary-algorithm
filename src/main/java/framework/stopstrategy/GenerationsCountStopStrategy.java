package framework.stopstrategy;

public class GenerationsCountStopStrategy implements IStopStrategy {

    public GenerationsCountStopStrategy(int maxGenerationsNumber ){
        this.maxGenerationsNumber=maxGenerationsNumber;
        this.currentGenerationNumber=0;
    }
    private int currentGenerationNumber;
    private int maxGenerationsNumber;

    public int getCurrentGenerationNumber() {
        return currentGenerationNumber;
    }

    public void setCurrentGenerationNumber(int currentGenerationNumber) {
        this.currentGenerationNumber = currentGenerationNumber;
    }

    public int getMaxGenerationsNumber() {
        return maxGenerationsNumber;
    }

    public void setMaxGenerationsNumber(int maxGenerationsNumber) {
        this.maxGenerationsNumber = maxGenerationsNumber;
    }

    public boolean isAlgorithmWorking() {
        return currentGenerationNumber++<maxGenerationsNumber;
    }


}
