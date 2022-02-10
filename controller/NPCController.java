package controller;

import core.Position;

public class NPCController implements Controller {
    private boolean up, right, left, down;

    @Override
    public boolean isRequestingUp() {
        return up;
    }

    @Override
    public boolean isRequestingDown() {
        return down;
    }

    @Override
    public boolean isRequestingRight() {
        return right;
    }

    @Override
    public boolean isRequestingLeft() {
        return left;
    }

    public void moveToTarget(Position current, Position target) {
        double dX = target.getX() - current.getX();
        double dY = target.getY() - current.getY();

        up = dY < 0 && Math.abs(dY) > Position.PROXIMATE_RANGE;
        right = dX > 0 && Math.abs(dX) > Position.PROXIMATE_RANGE;
        down = dY > 0 && Math.abs(dY) > Position.PROXIMATE_RANGE;
        left = dX < 0 && Math.abs(dX) > Position.PROXIMATE_RANGE;
    }

    public void stop() {
        up = false;
        down = false;
        right = false;
        left = false;
    }
}
