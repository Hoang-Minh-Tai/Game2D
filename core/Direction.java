package core;

public enum Direction {
    S(0),
    SW(1),
    W(2),
    NW(3),
    N(4),
    NE(5),
    E(6),
    SE(7)
    ;
    private int animationRow;

    Direction(int animationRow) {
        this.animationRow = animationRow;
    }

    public static Direction getDirection(Movement movement) {
        Vector2D vector = movement.getVector2D();
        double x = vector.getX();
        double y = vector.getY();
        if (x == 0 && y > 0) return S;
        if (x < 0 && y > 0) return SW;
        if (x < 0 && y == 0) return W;
        if (x < 0 && y < 0) return NW;
        if (x == 0 && y < 0) return N;
        if (x > 0 && y < 0) return NE;
        if (x > 0 && y == 0) return E;
        if (x > 0 && y > 0) return SE;
        return S;
    }

    public int getAnimationRow() {
        return animationRow;
    }
}
