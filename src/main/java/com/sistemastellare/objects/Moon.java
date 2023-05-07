package com.sistemastellare.objects;

public class Moon {
    private final double distance;
    private int x, y;
    private int angle;

    /**
     * @param distance: Distance from the planet.
     * @param angle: Angle of the moon.
     */
    public Moon(double distance, int angle) {
        this.distance = distance;
        this.angle = angle;
        this.x = 0;
        this.y = 0;
    }

    /**
     * @return X coordinate of moon.
     */
    public int getX() {
        return x;
    }

    /**
     * @return Y coordinate of moon.
     */
    public int getY() {
        return y;
    }

    /**
     * @deprecated Allows the moon to move around the star.
     * @param planetx: X coordinate of the planet.
     * @param planety: Y coordinate of the planet.
     */
    public void Move(int planetx, int planety) {
        angle++;
        double radians = Math.toRadians(angle);
        x = (int)(planetx + distance * Math.cos(radians));
        y = (int)(planety + distance * Math.sin(radians));
    }


}