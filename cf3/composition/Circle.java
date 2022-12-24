package gr.aueb.cf.ch11.composition;

import gr.aueb.cf.ch11.immutableproject.Point;

public class Circle {
    private Point center;
    private int radius;

    public Circle() {
    }

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String convertToString() {
        return "Center: " + center.pointToString() + ", " + radius;
    }
}
