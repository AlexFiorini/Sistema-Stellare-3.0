package com.sistemastellare.objects;

public class Moon {
    private final double distance;
    private int x, y;
    private int planetx, planety;
    private int angle;

    public Moon(double distance, int angle, int planetx, int planety) {
        this.distance = distance;
        this.angle = angle;
        this.x = (int) (distance * Math.cos(angle));
        this.y = (int) (distance * Math.sin(angle));
        this.planetx = planetx;
        this.planety = planety;
    }

    public void setPlanetX(int planetx) {
        x = planetx;
    }

    public void setPlanetY(int planety) {
        y = planety;
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
        x = (int) (planetx + distance * Math.cos(radians));
        y = (int) (planety + distance * Math.sin(radians));
    }
}
