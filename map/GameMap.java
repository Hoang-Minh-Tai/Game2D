package map;

import core.Position;
import core.Size;
import game.Game;
import gfx.SpriteLibrary;

import java.util.Arrays;

public class GameMap {
    private static Tile[][] tiles;

    public GameMap(Size size, SpriteLibrary spriteLibrary) {
        tiles = new Tile[size.getWidth()][size.getHeight()];
        initializeTiles(spriteLibrary);
    }

    private void initializeTiles(SpriteLibrary spriteLibrary) {
        for (Tile[] row : tiles) {
            Arrays.fill(row,new Tile(spriteLibrary));
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public static int getWidth() {
        return tiles.length * Game.SPRITE_SIZE;
    }

    public static int getHeight() {
        return tiles[0].length * Game.SPRITE_SIZE;
    }

    public static Position getRandomPosition() {
        double x = Math.random()*getWidth();
        double y = Math.random()*getHeight();
        return new Position(x,y);
    }
}
