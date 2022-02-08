package game;

import entity.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;


public class Game {
    private static Game game = null;
    private static Canvas canvas = null;
    private ArrayList<GameObject> gameObjectList;

    public Game() {
        gameObjectList = new ArrayList<>();
        gameObjectList.add(new Player());
    }

    public static Game get() {
        if (game == null) game = new Game();
        return Game.game;
    }

    public static Canvas getCanvas() {
        if (canvas == null) canvas = new Canvas();
        return canvas;
    }

    public void render() {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        gameObjectList.forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().getX(),
                gameObject.getPosition().getY(),null));

        graphics.dispose();
        bufferStrategy.show();
    }

    public void update() {
        gameObjectList.forEach(gameObject -> gameObject.update());

    }
}
