package gr.aueb.cf.ch11.composition;

import gr.aueb.cf.ch11.immutableproject.ImmutablePoint;

public final class ImmutableCircle2 {
    private final ImmutablePoint center;
    private final int radius;

    public ImmutableCircle2() {
        center = new ImmutablePoint();
        radius = 0;
    }

    public ImmutableCircle2(ImmutablePoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public ImmutablePoint getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }
}
