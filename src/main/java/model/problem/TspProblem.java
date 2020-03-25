package model.problem;

import java.util.ArrayList;
import java.util.List;

public class TspProblem implements IProblem<City> {
    private static ArrayList<City> cities;
    private List<Chromosome<City>> chromosomes;

    public TspProblem(ArrayList<City> cities) {
        this.cities = cities;
    }

    @Override
    public void setChromosomes(List<Chromosome<City>> chromosomes) {
        this.chromosomes = chromosomes;
    }

    @Override
    public List<Chromosome<City>> getChromosomes() {
        return chromosomes;
    }


    public ArrayList<City> getCities(){
        return cities;
    }

}
