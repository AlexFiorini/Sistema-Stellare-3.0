package com.sistemastellare.objects;

/**
 * Create a new Star. Extends OrbitalSystem.
 */
public class Star extends OrbitalSystem {
    private final Planet[] planets;
    private final double mass;

    /**
     * @param planets: Array of planets.
     * @param mass: Mass of the star.
     */
    public Star(Planet[] planets, double mass) {
        super();
        this.mass = mass;
        this.planets = planets;
    }

    /**
     * @return Array of planets.
     */
    public Planet[] getPlanets() {
        return planets;
    }
    /**
     * @return Mass of the Star.
     */
    public double getMass() {
        return mass;
    }
}
