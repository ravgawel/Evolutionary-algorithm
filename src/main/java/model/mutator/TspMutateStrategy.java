package model.mutator;

import model.problem.Chromosome;
import model.problem.City;

import java.util.List;

public class TspMutateStrategy implements IMutateStrategy<City> {
    private float mutationChance;

    public TspMutateStrategy(float mutationChance) {
        this.mutationChance = mutationChance;
    }

    @Override
    public List<Chromosome<City>> mutateChromosomes(List<Chromosome<City>> chromosomes) {
        for (Chromosome<City> chromosome : chromosomes) {
            List<City> cities = chromosome.getGenes();
            for (int tourPos1 = 0; tourPos1 < cities.size(); tourPos1++) {
                if (Math.random() < mutationChance) {
                    int tourPos2 = (int) (cities.size() * Math.random());

                    City city1 = cities.get(tourPos1);
                    City city2 = cities.get(tourPos2);

                    cities.set(tourPos2, city1);
                    cities.set(tourPos1, city2);

                    chromosome.setGenes(cities);
                }
            }
        }
        return chromosomes;
    }

    @Override
    public float getMutationChance() {
        return this.mutationChance;
    }

    @Override
    public void setMutationChance(float mutationChance) {
        this.mutationChance = mutationChance;
    }
}
