package game;

import display.Renderer;
import game.states.GameState;
import game.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game {
    public final static int SPRITE_SIZE = 64;

    private static Game game = null;
    private static Canvas canvas = null;
    private static Renderer renderer;
    private State state;


    public Game() {
        renderer = new Renderer();
        state = new GameState();
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
        renderer.render(state,graphics);

        graphics.dispose();
        bufferStrategy.show();
    }

    public void update() {
        state.update();
    }
}
