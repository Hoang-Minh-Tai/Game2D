package entity;

import controller.Controller;
import controller.NPCController;
import controller.PlayerController;
import core.Movement;
import game.states.State;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.awt.*;

public class MovingEntity extends GameObject{
    Controller controller;
    private Movement movement;
    AnimationManager animationManager;

    public MovingEntity(SpriteLibrary spriteLibrary) {
        this.movement = new Movement(2);
    }

    @Override
    public void update(State state) {
        movement.update(controller);
        position.apply(movement);
        animationManager.update(movement);
    }

    @Override
    public Image getSprite() {
        return animationManager.getSprite();
    }

    public Controller getController() {
        return this.controller;
    }
}
