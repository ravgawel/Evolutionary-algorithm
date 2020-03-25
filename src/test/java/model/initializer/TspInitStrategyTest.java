package model.initializer;

import model.problem.Chromosome;
import model.problem.City;
import model.problem.TspProblem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class TspInitStrategyTest {
    ArrayList<City> cities;
    TspInitStrategy tspInitStrategy;
    @Before
    public void setUp() throws Exception {
        cities = new ArrayList<>();
        City city = new City(60, 200);
        cities.add(city);
        City city2 = new City(180, 200);
        cities.add(city2);

        TspProblem tspProblem = mock(TspProblem.class);
        when(tspProblem.getCities()).thenReturn(cities);
        tspInitStrategy = new TspInitStrategy(tspProblem);
    }

    @Test
    public void initChromosomes() {
        List<Chromosome<City>> outp = tspInitStrategy.initChromosomes(2, 2);

        assertEquals(2, outp.size());

        List<City> cities = outp.get(0).getGenes();
        assertEquals(60, cities.get(0).getX());
        assertEquals(200, cities.get(0).getY());
        assertEquals(180, cities.get(1).getX());
        assertEquals(200, cities.get(1).getY());

        cities = outp.get(1).getGenes();
        assertEquals(60, cities.get(0).getX());
        assertEquals(200, cities.get(0).getY());
        assertEquals(180, cities.get(1).getX());
        assertEquals(200, cities.get(1).getY());
    }

    @Test
    public void initGenes() {
        List<City> cities = tspInitStrategy.initGenes(2);

        assertEquals(2, cities.size());
        assertEquals(60, cities.get(0).getX());
        assertEquals(200, cities.get(0).getY());
        assertEquals(180, cities.get(1).getX());
        assertEquals(200, cities.get(1).getY());
    }
}