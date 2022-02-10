package core;

public class Position {
    public static final int PROXIMATE_RANGE = 5;
    private double x;
    private double y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int intX() {
        return (int) Math.round(x);
    }

    public int intY() {
        return (int) Math.round(y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void apply(Movement movement) {
        Vector2D vector = movement.getVector2D();
        x += vector.getX();
        y += vector.getY();
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isInRangeOf(Position target) {
        return Math.abs(x - target.getX()) < PROXIMATE_RANGE && Math.abs(y - target.getY()) < PROXIMATE_RANGE;
    }
}
