package model.crossbreeder;

import model.problem.Chromosome;
import model.problem.City;
import model.problem.Tour;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TspCrossStrategyTest {
    TspCrossStrategy tspCrossStrategy = new TspCrossStrategy();
    List<Chromosome<City>> list;
    ArrayList<City> cities;
    @Before
    public void setUp() throws Exception {
        cities = new ArrayList<>();
        for (int i = 0; i < 20; i++) cities.add(new City());
        Tour tour1 = new Tour(cities);
        Tour tour2 = new Tour(cities);
        list = new ArrayList<>();
        list.add(tour1);
        list.add(tour2);
    }

    @Test
    public void crossChromosomes() {
        List<Chromosome<City>> result = tspCrossStrategy.crossChromosomes(list);

        assertEquals(3, result.size());
        assertNotNull(result);
        assertNotNull(result.get(0));
        assertNotNull(result.get(1));
        assertNotNull(result.get(2));
        assertEquals(20, result.get(2).getGenes().size());
    }

    @Test
    public void crossover() {
        Tour parent1 = (Tour) list.get(0);
        Tour parent2 = (Tour) list.get(1);
        Tour child = tspCrossStrategy.crossover(parent1, parent2);

        assertNotNull(child);
        assertNotNull(child.getGenes());
        assertEquals(20, child.getGenes().size());
    }
}