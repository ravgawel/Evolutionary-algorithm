package model.problem;

import model.evaluator.PolynomialEvalStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CityTest {
    City city1;
    City city2;

    @Before
    public void init(){
        city1 = new City(1, 3);
        city2 = new City(1, 7);
    }
    @Test
    public void getX() {
        assertEquals(1, city1.getX());
        assertEquals(1, city2.getX());
    }

    @Test
    public void getY() {
        assertEquals(3, city1.getY());
        assertEquals(7, city2.getY());
    }

    @Test
    public void distanceTo() {
        assertEquals(4.0, city1.distanceTo(city2), 0.1);
        assertEquals(4.0, city2.distanceTo(city1), 0.1);
        assertEquals(city1.distanceTo(city2), city2.distanceTo(city1), 0.1);
    }

    @Test
    public void testToString() {
       assertEquals("(1, 3)", city1.toString());
       assertEquals("(1, 7)", city2.toString());
    }
}