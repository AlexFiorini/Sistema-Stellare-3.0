package com.sistemasolare.objects;

public class Moon {
    private double distance;
    private int x, y;
    private int angle;

    public Moon(double distance, int angle) {
        this.distance = distance;
        this.angle = angle;
        x = (int) (distance * Math.cos(angle));
        y = (int) (distance * Math.sin(angle));
    }

    public double getDistance() {
        return distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAngle() {
        return angle;
    }

    public void Move() {
        if(angle >= 360) {
            angle -= 360;
        }
        angle++;
        double radians = Math.toRadians(getAngle());
        x = (int) (distance * Math.cos(radians));
        y = (int) (distance * Math.sin(radians));
    }
}
