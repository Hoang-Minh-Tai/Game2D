package display;

import game.Game;
import game.GameLoop;
import input.Input;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 600;

    private static Window window = null;
    private static Canvas canvas = Game.getCanvas();
    private static Input input = new Input();

    Window() {

    }

    public static Window get() {
        if (window == null) window = new Window();
        return Window.window;
    }


    public static Input getInput() {
        return input;
    }

    public void run() {
        // Config
        window.setVisible(true);
        window.setTitle("My 2D game");
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocation(400,50);

        init();
        loop();
    }

    private void init() {
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(false);

        window.add(canvas);
        window.pack();
        window.addKeyListener(input);

        canvas.createBufferStrategy(3);
    }

    private void loop() {
        new Thread(new GameLoop()).start();
    }
}
