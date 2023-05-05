package com.sistemasolare.objects;

import java.awt.*;

public class Planet {
    private final double distance;
    private final Moon[] moons;
    private final Color color;
    private final double mass;
    private String Name;
    private int x, y;
    private int angle;

    /**
     * @param moons: Array of moons.
     * @param distance: Distance from the star.
     * @param mass: Mass of the planet.
     */
    public Planet(Moon[] moons, double distance, double mass) {
        this.distance = distance;
        this.moons = moons;
        this.color = new Color((int)(Math.random() * 0x1000000));
        this.angle = (int) (Math.random()%360);
        this.mass = mass;
    }

    /**
     * @return Distance from the star.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @return Mass of the planet.
     */
    public double getMass() {
        return mass;
    }

    /**
     * @return Array of moons.
     */
    public Moon[] getMoons() {
        return moons;
    }

    /**
     * @return Name of the planet.
     */
    public String getName() {
        return Name;
    }

    /**
     * @return X coordinate of the planet.
     */
    public int getX() {
        return x;
    }

    /**
     * @param x: X coordinate of the planet.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return Y coordinate of the planet.
     */
    public int getY() {
        return y;
    }

    /**
     * @param y: Y coordinate of the planet.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return Color of the planet.
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return Angle of the planet in the orbit.
     */
    public int getAngle() {
        return angle;
    }

    /**
     * @param angle: Angle of the planet.
     */
    public void setAngle(int angle) {
        this.angle = angle;
    }
}
