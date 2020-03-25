package utils;

import java.util.Objects;

public class Point {
    int xLocation;
    int yLocation;

    public Point(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return getxLocation() == point.getxLocation() &&
                getyLocation() == point.getyLocation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getxLocation(), getyLocation());
    }
}
