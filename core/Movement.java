package core;

import controller.Controller;

public class Movement {
    private Vector2D vector2D;
    private double speed;

    public Movement(double speed) {
        this.speed = speed;
        this.vector2D = new Vector2D(0,0);
    }

    public void update(Controller controller) {
        int dX = 0;
        int dY = 0;
        if (controller.isRequestingUp()) dY--;
        if (controller.isRequestingDown()) dY++;
        if (controller.isRequestingLeft()) dX--;
        if (controller.isRequestingRight()) dX++;
        vector2D = new Vector2D(dX,dY);
        vector2D.normalize();
        vector2D.setSpeed(speed);
    }

    public Vector2D getVector2D() {
        return vector2D;
    }

    public boolean isMoving() {
        return vector2D.length() > 0;
    }
}
