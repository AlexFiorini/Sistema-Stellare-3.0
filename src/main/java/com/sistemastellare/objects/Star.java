package com.sistemastellare.objects;

/**
 * Create a new Star. Extends OrbitalSystem.
 */
public class Star extends OrbitalSystem {
    private final Planet[] planets;

    /**
     * @param planets: Array of planets.
     */
    public Star(Planet[] planets) {
        super();
        this.planets = planets;
    }

    /**
     * @return Array of planets.
     */
    public Planet[] getPlanets() {
        return planets;
    }
}