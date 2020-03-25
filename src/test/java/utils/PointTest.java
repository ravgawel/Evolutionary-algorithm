package utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    Point point;

    @Before
    public void init(){
        point = new Point(0,0);
    }

    @Test
    public void setxLocation() {
        point.setxLocation(2);

        assertEquals(2,point.getxLocation());
    }

    @Test
    public void setyLocation() {

        point.setyLocation(2);

        assertEquals(2,point.getyLocation());
    }

    @Test
    public void equals1() {

        assertEquals(new Point(0,0),point);
    }

    @Test
    public void hashCode1() {

        assertEquals(new Point(0,0).hashCode(),point.hashCode());
    }
}