package model.crossbreeder;

import model.problem.*;

import java.util.ArrayList;
import java.util.List;

public class FloatCrossStrategy implements  ICrossStrategy<FloatGene> {

    private int chromosomesListTargetSize;

    public FloatCrossStrategy(int chromosomesListTargetSize){
        this.chromosomesListTargetSize=chromosomesListTargetSize;
    }

    public List<Chromosome<FloatGene>> crossChromosomes(List<Chromosome<FloatGene>> chromosomes) {

        int i=0;
        while(chromosomes.size()!= chromosomesListTargetSize && i+1<chromosomes.size()){
            chromosomes.add(crossMeanValue(chromosomes.get(i++), chromosomes.get(i++)));
        }

        return chromosomes;

    }

    private Chromosome<FloatGene> crossMeanValue(Chromosome<FloatGene> firstChromosome, Chromosome<FloatGene> secondChromosome){
        List<FloatGene> tmp = new ArrayList<>();
        tmp.add(crossMeanValue ( (firstChromosome.getGenes().get(0))
                , secondChromosome.getGenes().get(0)));
        return new FloatChromosome(tmp);
    }

    private FloatGene crossMeanValue(FloatGene firstGene, FloatGene secondGene){
        return new FloatGene((firstGene.getValue() + secondGene.getValue()) /2);
    }
}
