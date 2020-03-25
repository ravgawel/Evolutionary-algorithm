package model.AntLogic;

import utils.Point;

public class AntBoardField {
    private int foodPoints;
    private int pheromoneStrength; // percentage value of chance to mutate
    private Point location;

    public AntBoardField(int foodPoints, int pheromoneStrength, int xLocation, int yLocation) {
        this.foodPoints = foodPoints;
        this.pheromoneStrength = pheromoneStrength;
        this.location = new Point(xLocation, yLocation);
    }

    public int getFoodPoints() {
        return foodPoints;
    }

    public void setFoodPoints(int foodPoints) {
        this.foodPoints = foodPoints;
    }

    public int getPheromoneStrength() {
        return pheromoneStrength;
    }

    public void setPheromoneStrength(int pheromoneStrength) {
        this.pheromoneStrength = pheromoneStrength;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
