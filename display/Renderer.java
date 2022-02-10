package display;

import entity.GameObject;
import game.Game;
import game.states.State;
import map.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Renderer {
    public void render(State state, Graphics graphics) {
        renderMap(state, graphics);
        renderObjects(state, graphics);
    }

    private void renderObjects(State state, Graphics graphics) {
        Camera camera = state.getCamera();
        sortObjectsByPosY(state.getGameObjectList());

        state.getGameObjectList().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().intX() - camera.getPosition().intX()-gameObject.getSize().getWidth()/2,
                gameObject.getPosition().intY() - camera.getPosition().intY()-gameObject.getSize().getHeight()/2
                , null));
    }

    private void sortObjectsByPosY(ArrayList<GameObject> gameObjectList) {
        gameObjectList.sort(Comparator.comparing(object -> object.getPosition().getY()));
    }

    private void renderMap(State state, Graphics graphics) {
        Camera camera = state.getCamera();
        Tile[][] tiles = state.getGameMap().getTiles();
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                graphics.drawImage(
                        tiles[x][y].getSprite(),
                        x * Game.SPRITE_SIZE - camera.getPosition().intX(),
                        y * Game.SPRITE_SIZE - camera.getPosition().intY(),
                        null
                );
            }
        }
    }
}
