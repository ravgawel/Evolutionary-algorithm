package model.mutator;

import model.problem.Chromosome;
import model.problem.FloatGene;

import java.util.List;
import java.util.Random;

public class FloatMutateStrategy implements IMutateStrategy<FloatGene> {

    private float mutationChance;
    private float mutationMaxDelta;
    private Random random;

    public FloatMutateStrategy(float mutationChance, float mutationMaxDelta) {
        this.mutationChance = mutationChance;
        this.mutationMaxDelta = mutationMaxDelta;
        this.random = new Random();
    }

    public List<Chromosome<FloatGene>> mutateChromosomes(List<Chromosome<FloatGene>> chromosomes) {
        for (Chromosome<FloatGene> chromosome : chromosomes) {
            if (random.nextFloat() <= getMutationChance()) {
                for (FloatGene gene : chromosome.getGenes()) {
                    gene.setValue(gene.getValue() + getDelta());
                }
            }
        }
        return chromosomes;
    }

    private float getDelta() {
        return random.nextFloat() * (2 * mutationMaxDelta) - mutationMaxDelta;
    }

    public float getMutationChance() {
        return this.mutationChance;
    }

    public void setMutationChance(float mutationChance) {
        this.mutationChance = mutationChance;
    }
}
