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
}
