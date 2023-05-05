package com.sistemasolare.objects;

public class Star extends OrbitalSystem {
    private Planet[] planets;
    private double mass;

    public Star(Planet[] planets, double mass) {
        super();
        this.mass = mass;
        this.planets = planets;
    }

    public Star() {
        super();
        this.mass = 0;
        this.planets = new Planet[0];
    }

    public Planet[] getPlanets() {
        return planets;
    }
    public double getMass() {
        return mass;
    }
}
