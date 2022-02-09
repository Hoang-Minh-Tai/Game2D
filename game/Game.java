package game;

import display.Renderer;
import entity.*;
import gfx.SpriteLibrary;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;


public class Game {
    public final static int SPRITE_SIZE = 64;

    private static Game game = null;
    private static Canvas canvas = null;
    private static Renderer renderer;
    private ArrayList<GameObject> gameObjectList;
    private SpriteLibrary spriteLibrary;

    public Game() {
        spriteLibrary = new SpriteLibrary();
        gameObjectList = new ArrayList<>();
        gameObjectList.add(new Player(spriteLibrary));
        renderer = new Renderer();
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
        renderer.render(game,graphics);

        graphics.dispose();
        bufferStrategy.show();
    }

    public void update() {
        gameObjectList.forEach(gameObject -> gameObject.update());

    }

    public ArrayList<GameObject> getGameObjectList() {
        return gameObjectList;
    }
}
