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
        this.x = (int) (centerx + distance * Math.cos(angle));
        this.y = (int) (centery + distance * Math.sin(angle));
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

    /**
     * @return Angle of the planet in the orbit.
     */
    public int getAngle() {
        return angle;
    }

    public void Move(int centerX, int centerY) {
        if(angle >= 360) {
            angle -= 360;
        }
        angle++;
        double radians = Math.toRadians(getAngle());
        x = (int) (centerX + distance * Math.cos(radians) - 15);
        y = (int) (centerY + distance * Math.sin(radians) - 15);
        for(Moon moon : moons) {
            moon.setPlanetX(x);
            moon.setPlanetY(y);
            moon.Move();
        }
    }
}
