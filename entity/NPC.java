package entity;

import controller.NPCController;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

public class NPC extends MovingEntity{

    public NPC(SpriteLibrary spriteLibrary) {
        super(spriteLibrary);
        controller = new NPCController();
        animationManager = new AnimationManager(spriteLibrary.getUnit("dave"));
    }
}
