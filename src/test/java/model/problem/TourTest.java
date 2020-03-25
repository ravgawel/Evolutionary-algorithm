package model.problem;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TourTest {
    ArrayList<City> cities;
    Tour tour;
    @Before
    public void setUp() throws Exception {
        cities = new ArrayList<>();
        City city = new City(60, 200);
        cities.add(city);
        City city2 = new City(180, 200);
        cities.add(city2);

        tour = new Tour(cities);
    }

    @Test
    public void tourSize() {
        assertEquals(2, tour.tourSize());
    }

    @Test
    public void getCity() {
        assertEquals(60, tour.getCity(0).getX());
        assertEquals(200, tour.getCity(0).getY());
        assertEquals(180, tour.getCity(1).getX());
        assertEquals(200, tour.getCity(1).getY());
    }

    @Test
    public void testToString() {
        assertEquals("[(60, 200), (180, 200)]", tour.toString());
    }
}