package entity;

import controller.PlayerController;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

public class Player extends MovingEntity {

    public Player(SpriteLibrary spriteLibrary) {
        super(spriteLibrary);
        controller = new PlayerController();
        animationManager = new AnimationManager(spriteLibrary.getUnit("matt"));
    }

    @Override
    public void update() {
        super.update();
    }

}
