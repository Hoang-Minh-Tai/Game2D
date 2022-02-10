package game.states;

import core.Size;
import display.Camera;
import display.Window;
import entity.GameObject;
import entity.Player;
import gfx.SpriteLibrary;
import map.GameMap;

import java.util.ArrayList;

public abstract class State {
    protected GameMap gameMap;
    protected ArrayList<GameObject> gameObjectList;
    protected SpriteLibrary spriteLibrary;
    protected Camera camera;

    public State() {
        spriteLibrary = new SpriteLibrary();
        gameObjectList = new ArrayList<>();
        camera = new Camera(new Size(Window.WIDTH,Window.HEIGHT));
    }

    public void update() {
        gameObjectList.forEach(gameObject -> gameObject.update());
        camera.update(this);
    }

    public ArrayList<GameObject> getGameObjectList() {
        return gameObjectList;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Camera getCamera() {
        return camera;
    }
}
