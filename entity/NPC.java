package entity;

import ai.AIManager;
import controller.NPCController;
import core.Position;
import game.states.State;
import gfx.AnimationManager;
import gfx.SpriteLibrary;
import map.GameMap;

public class NPC extends MovingEntity{
    private AIManager aiManager;

    public NPC(SpriteLibrary spriteLibrary) {
        super(spriteLibrary);
        controller = new NPCController();
        animationManager = new AnimationManager(spriteLibrary.getUnit("dave"));
        aiManager = new AIManager();
        position = GameMap.getRandomPosition();
    }

    @Override
    public void update(State state) {
        super.update(state);
        aiManager.update(state,this);
    }
}
