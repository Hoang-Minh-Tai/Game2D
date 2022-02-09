package entity;

import controller.Controller;
import controller.PlayerController;
import core.Movement;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.awt.*;

public class MovingEntity extends GameObject{
    Controller controller;
    private Movement movement;
    AnimationManager animationManager;

    public MovingEntity(SpriteLibrary spriteLibrary) {
        this.controller = new PlayerController();
        this.movement = new Movement(2);
        animationManager = new AnimationManager(spriteLibrary.getUnit("dave"));
    }

    @Override
    public void update() {
        movement.update(controller);
        position.apply(movement);
        animationManager.update();
    }

    @Override
    public Image getSprite() {
        return animationManager.getSprite();
    }
}
