import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    private PlayerController controller;
    public Player() {
        controller = new PlayerController();
    }

    @Override
    public void update() {
        int dX = 0;
        int dY = 0;
        if (controller.isRequestingUp()) dY--;
        if (controller.isRequestingDown()) dY++;
        if (controller.isRequestingLeft()) dX--;
        if (controller.isRequestingRight()) dX++;
        position = new Position(position.getX()+dX, position.getY() + dY);
    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0, size.getWidth(), size.getHeight());

        graphics.dispose();
        return image;
    }
}
