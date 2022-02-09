package entity;

import controller.PlayerController;
import gfx.SpriteLibrary;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends MovingEntity {

    public Player(SpriteLibrary spriteLibrary) {
        super(spriteLibrary);
        controller = new PlayerController();
    }

    @Override
    public void update() {
        super.update();
    }

}
