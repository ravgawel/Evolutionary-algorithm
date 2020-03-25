package model.initializer;

import model.problem.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FloatInitStrategy implements IInitStrategy<FloatGene> {

    private float minChromValue=-10;
    private float maxChromValue=10;
    private Random rand = new Random();

    public List<Chromosome<FloatGene>> initChromosomes(int  chromosomesAmount, int chromosomeSize) {
         List<Chromosome<FloatGene>> outp = new ArrayList<>();

         for(int i=0;i<chromosomesAmount;i++){
             outp.add(new FloatChromosome(initGenes(chromosomeSize)));
         }

         return outp;
    }

    public List<Chromosome<FloatGene>> initChromosomes(int  chromosomesAmount, int chromosomeSize, float minChromValue, float maxChromValue) {
        this.maxChromValue=maxChromValue;
        this.minChromValue=minChromValue;

        return initChromosomes(chromosomesAmount,chromosomeSize);
    }

    private float generateNewFloatValue(){

        return rand.nextFloat()*(maxChromValue-minChromValue)+minChromValue;
    }


    public List<FloatGene> initGenes(int genesAmount) {

        List<FloatGene> outp = new ArrayList<>();

        for(int i=0;i<genesAmount;i++){
            outp.add(new FloatGene(generateNewFloatValue()));
        }
        return outp;
    }
}
