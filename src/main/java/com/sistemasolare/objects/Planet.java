package com.sistemasolare.objects;

public class Planet {
    private double x;
    private double y;
    private double distance;
    private double mass;
    private Moon[] moons;
    private String Name;

    public Planet(double x, double y, double distance, Moon[] moons) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.moons = moons;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance() {
        return distance;
    }

    public double getMass() {
        return mass;
    }

    public Moon[] getMoons() {
        return moons;
    }

    public String getName() {
        return Name;
    }
}
