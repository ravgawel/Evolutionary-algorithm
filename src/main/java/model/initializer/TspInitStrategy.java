package model.initializer;

import model.problem.Chromosome;
import model.problem.City;
import model.problem.Tour;
import model.problem.TspProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TspInitStrategy implements IInitStrategy<City> {
    TspProblem tspProblem;

    public TspInitStrategy(TspProblem tspProblem) {
        this.tspProblem = tspProblem;
    }

    @Override
    public List<Chromosome<City>> initChromosomes(int chromosomesAmount, int chromosomeSize) {
        List<Chromosome<City>> outp = new ArrayList<>();

        for (int i = 0; i < chromosomesAmount; i++) {
            outp.add(new Tour(initGenes(chromosomeSize)));
        }
        return outp;
    }

    @Override
    public List<City> initGenes(int genesAmount) {
        ArrayList<City> cities = tspProblem.getCities();
        return cities;
    }
}
