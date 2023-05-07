package com.sistemastellare.objects;

import java.awt.*;

public class Planet {
    private final double distance;
    private final Moon[] moons;
    private final Color color;
    private final double mass;
    private final String Name;
    private int x, y;
    private int angle;

    /**
     * @param moons: Array of moons.
     * @param distance: Distance from the star.
     * @param mass: Mass of the planet.
     */
    public Planet(Moon[] moons, double distance, int angle, double mass, String Name, int centerx, int centery) {
        this.distance = distance;
        this.moons = moons;
        this.color = new Color((int)(Math.random() * 0x1000000));
        this.angle = angle;
        this.mass = mass;
        this.Name = Name;
        this.x = (int)(centerx + distance * Math.cos(angle));
        this.y = (int)(centery + distance * Math.sin(angle));
    }

    /**
     * @return Array of moons.
     */
    public Moon[] getMoons() {
        return moons;
    }

    /**
     * @return X coordinate of the planet.
     */
    public int getX() {
        return x;
    }

    /**
     * @return Y coordinate of the planet.
     */
    public int getY() {
        return y;
    }

    /**
     * @return Color of the planet.
     */
    public Color getColor() {
        return color;
    }

    public String getName() {
        return Name;
    }

    public double getDistance() {
        return distance;
    }

    public double getMass() {
        return mass;
    }

    public int getAngle() {
        return angle;
    }

    /**
     * Allows the planet to move around the star.
     * @param centerX: X coordinate of the star.
     * @param centerY: Y coordinate of the star.
     */
    public void Move(int centerX, int centerY) {
        angle++;
        double radians = Math.toRadians(angle);
        x = (int)(centerX + distance * Math.cos(radians) - 15);
        y = (int)(centerY + distance * Math.sin(radians) - 15);
        for (Moon moon: moons) {
            moon.Move(x, y);
        }
    }
}