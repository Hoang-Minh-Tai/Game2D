package core;

public class Vector2D {
    private double x;
    private double y;
    private double speed;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        x *= speed;
        y *= speed;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        x = x == 0 ? 0 : x / length();
        y = y == 0 ? 0 : y / length();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
