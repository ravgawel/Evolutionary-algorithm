package model.mutator;

import model.problem.Chromosome;
import model.problem.City;
import model.problem.Tour;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TspMutateStrategyTest {
    TspMutateStrategy tspMutateStrategy;
    List<Chromosome<City>> list;
    ArrayList<City> cities;
    @Before
    public void setUp() throws Exception {
        tspMutateStrategy = new TspMutateStrategy(0.9f);
        cities = new ArrayList<>();
        for (int i = 0; i < 20; i++) cities.add(new City());
        Tour tour1 = new Tour(cities);
        Tour tour2 = new Tour(cities);
        list = new ArrayList<>();
        list.add(tour1);
        list.add(tour2);
    }

    @Test
    public void mutateChromosomes() {
        List<Chromosome<City>> result = tspMutateStrategy.mutateChromosomes(list);

        assertEquals(list.size(), result.size());
        assertNotNull(result);
        assertNotNull(result.get(0));
        assertNotNull(result.get(1));

        for (int i = 0; i < 20; i++){
            assertNotNull(result.get(0).getGenes().get(i));
            assertNotNull(result.get(1).getGenes().get(i));
        }
    }

    @Test
    public void getMutationChance() {
        assertEquals(0.9f, tspMutateStrategy.getMutationChance(), 0.1);
    }

    @Test
    public void setMutationChance() {
        tspMutateStrategy.setMutationChance(0.025f);

        assertEquals(0.020f, tspMutateStrategy.getMutationChance(), 0.1);
    }
}