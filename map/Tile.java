package map;

import gfx.SpriteLibrary;

import java.awt.*;

public class Tile {
    Image sprite;

    public Tile(SpriteLibrary spriteLibrary) {
        this.sprite = spriteLibrary.getTile("grass");
    }

    public Image getSprite() {
        return sprite;
    }
}
