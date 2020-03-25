package model.AntLogic;

import org.junit.Before;
import org.junit.Test;
import utils.Point;

import static org.junit.Assert.*;

public class AntBoardFieldTest {

    AntBoardField field;

    @Before
    public void init(){
         field = new AntBoardField(3,3,4,4);
    }


    @Test
    public void setFoodPoints() {
        field.setFoodPoints(1);
        assertEquals(1,field.getFoodPoints());
    }

    @Test
    public void setPheromoneStrength() {
        field.setPheromoneStrength(1);
        assertEquals(1,field.getPheromoneStrength());
    }

    @Test
    public void setLocation() {
        field.setLocation(new Point(1,1));
        assertEquals(new Point(1,1),field.getLocation());
    }
}