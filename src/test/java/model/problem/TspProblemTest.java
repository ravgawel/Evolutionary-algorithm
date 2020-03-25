package model.problem;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(TspProblem.class)
public class TspProblemTest {
    ArrayList<City> cities;
    TspProblem tspProblem;

    @Before
    public void setUp() throws Exception {
        cities = new ArrayList<>();
        City city = new City(60, 200);
        cities.add(city);
        City city2 = new City(180, 200);
        cities.add(city2);

        tspProblem = new TspProblem(cities);
    }

    @Test
    public void chromosomesGettersAndSetters() {
        List<Chromosome<City>> list = new ArrayList<>();
        cities = new ArrayList<>();
        for (int i = 0; i < 20; i++) cities.add(new City());
        Tour tour1 = new Tour(cities);
        Tour tour2 = new Tour(cities);
        list.add(tour1);
        list.add(tour2);
        tspProblem.setChromosomes(list);

        assertNotNull(tspProblem.getChromosomes());
        assertNotNull(tspProblem.getChromosomes().get(0).getGenes());
        assertNotNull(tspProblem.getChromosomes().get(1).getGenes());
        assertEquals(2, tspProblem.getChromosomes().size());
        assertEquals(20, tspProblem.getChromosomes().get(0).getGenes().size());
        assertEquals(20, tspProblem.getChromosomes().get(1).getGenes().size());
        assertNotNull(tspProblem.getChromosomes().get(0).getGenes().get(0));
        assertNotNull(tspProblem.getChromosomes().get(0).getGenes().get(19));
        assertNotNull(tspProblem.getChromosomes().get(1).getGenes().get(0));
        assertNotNull(tspProblem.getChromosomes().get(1).getGenes().get(19));
    }

    @Test
    public void getCities() {
        List<City> cities = tspProblem.getCities();

        assertEquals(2, cities.size());
        assertEquals(60, cities.get(0).getX());
        assertEquals(200, cities.get(0).getY());
        assertEquals(180, cities.get(1).getX());
        assertEquals(200, cities.get(1).getY());
    }
}