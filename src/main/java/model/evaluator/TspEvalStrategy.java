package model.evaluator;

import model.problem.*;

import java.util.Collections;
import java.util.List;

public class TspEvalStrategy implements  IEvalStrategy<City> {
    @Override
    public List<Chromosome<City>> evaluateChromosomes(List<Chromosome<City>> chromosomes) {
        for(Chromosome chromosome:chromosomes){
            chromosome.setChromosomeFitnessValue(evaluateFitnessValue((Tour) chromosome));
        }
        return chromosomes;
    }

    public float evaluateFitnessValue(Tour chromosome){
        int tourDistance = 0;
        for (int cityIndex=0; cityIndex < chromosome.getGenes().size(); cityIndex++) {
            City fromCity = chromosome.getGenes().get(cityIndex);
            City destinationCity;
            if(cityIndex+1 < chromosome.getGenes().size()){
                destinationCity = chromosome.getGenes().get(cityIndex+1);
            }
            else{
                destinationCity = chromosome.getGenes().get((0));
            }
            tourDistance += fromCity.distanceTo(destinationCity);
        }

        return tourDistance;
    }
}
