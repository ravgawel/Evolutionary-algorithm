package model.crossbreeder;

import model.problem.Chromosome;
import model.problem.City;
import model.problem.Tour;

import java.util.ArrayList;
import java.util.List;

public class TspCrossStrategy implements ICrossStrategy<City> {
    @Override
    public List<Chromosome<City>> crossChromosomes(List<Chromosome<City>> chromosomes) {
        int n = chromosomes.size();
        for (int i = 0; i + 1 < n; i+=2){
            Tour parent1 = (Tour) chromosomes.get(i);
            Tour parent2 = (Tour) chromosomes.get(i+1);
            Tour child = crossover(parent1, parent2);
            chromosomes.add(child);
        }
        return chromosomes;
    }

    public Tour crossover(Tour parent1, Tour parent2) {
        Tour child = new Tour();

        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());

        int size = parent1.tourSize();
        ArrayList<City> cities = new ArrayList<>(size);
        for (int i = 0; i < size; i++) cities.add(new City(-1, -1));


        for (int i = 0; i < size; i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                cities.set(i, parent1.getCity(i));
            }
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    cities.set(i, parent1.getCity(i));
                }
            }
        }

        for (int i = 0; i < parent2.tourSize(); i++) {
            if (!cities.contains(parent2.getCity(i))) {
                for (int ii = 0; ii < size; ii++) {
                    if (cities.get(ii).getX() == -1 && cities.get(ii).getY() == -1) {
                        cities.set(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }

        child.setGenes(cities);
        return child;
    }
}
