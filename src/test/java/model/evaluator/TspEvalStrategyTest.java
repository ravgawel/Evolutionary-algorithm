package model.evaluator;

import model.problem.Chromosome;
import model.problem.City;
import model.problem.Tour;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TspEvalStrategyTest {
    List<Chromosome<City>> list;
    ArrayList<City> cities1;
    ArrayList<City> cities2;
    TspEvalStrategy tspEvalStrategy;
    Tour tour1;
    Tour tour2;

    @Before
    public void setUp() throws Exception {
        cities1 = new ArrayList<>();
        City city = new City(100, 200);
        cities1.add(city);
        City city2 = new City(200, 200);
        cities1.add(city2);
        City city3 = new City(200, 100);
        cities1.add(city3);
        City city4= new City(100, 100);
        cities1.add(city4);
        tour1 = new Tour(cities1);

        cities2 = new ArrayList<>();
        cities2.add(city);
        cities2.add(city3);
        cities2.add(city2);
        cities2.add(city4);
        tour2 = new Tour(cities2);

        list = new ArrayList<>();
        list.add(tour1);
        list.add(tour2);

        tspEvalStrategy = new TspEvalStrategy();
    }

    @Test
    public void evaluateChromosomes() {
        List<Chromosome<City>> result = tspEvalStrategy.evaluateChromosomes(list);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(400.0f, result.get(0).getChromosomeFitnessValue(), 0.1);
        assertEquals(482.0f, result.get(1).getChromosomeFitnessValue(), 0.1);
    }

    @Test
    public void evaluateFitnessValue() {
        assertEquals(400.0f, tspEvalStrategy.evaluateFitnessValue(tour1), 0.1);
        assertEquals(482.0f, tspEvalStrategy.evaluateFitnessValue(tour2), 0.1);
    }
}