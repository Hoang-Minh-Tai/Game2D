import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;

    public GameObject() {
        position = new Position(50,50);
        size = new Size(50,50);
    }
    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}

class Position {
    int x,y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Size {
    int width;
    int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}