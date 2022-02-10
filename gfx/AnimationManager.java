package gfx;

import core.Direction;
import core.Movement;
import game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    private SpriteSet spriteSet;
    private BufferedImage  currentAnimationSheet;
    private int updatePerFrame;
    private int currentFrameTime;
    private int frameIndex;
    private int directionIndex;

    public AnimationManager(SpriteSet spriteSet) {
        this.spriteSet = spriteSet;
        updatePerFrame = 20;
        currentFrameTime = 0;
        frameIndex = 0;
        playAnimation("stand");
    }

    private void playAnimation(String name) {
        this.currentAnimationSheet = (BufferedImage) spriteSet.get(name);
    }

    public Image getSprite() {
        return currentAnimationSheet.getSubimage(
                frameIndex * Game.SPRITE_SIZE,
                directionIndex*Game.SPRITE_SIZE,
                Game.SPRITE_SIZE,Game.SPRITE_SIZE
        );
    }

    public void update(Movement movement) {
        currentFrameTime++;
        if (movement.isMoving()) {
            playAnimation("walk");
            directionIndex = Direction.getDirection(movement).getAnimationRow();
        }
        else playAnimation("stand");

        if (currentFrameTime >= updatePerFrame) {
            frameIndex++;
            currentFrameTime = 0;
            if (frameIndex > (currentAnimationSheet.getWidth() / Game.SPRITE_SIZE - 1) ) {
                frameIndex = 0;
            }
        }
    }
}
