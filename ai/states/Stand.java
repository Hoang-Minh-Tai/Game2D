package ai.states;

import ai.AITransition;
import entity.NPC;
import game.states.State;
import utils.Time;

public class Stand extends AIState {
    private int updateAlive;

    @Override
    protected AITransition initializeTransition() {
        return new AITransition("wander", (((state, currentNPC) -> updateAlive >= Time.getUpdatesFromSeconds(3))));
    }

    @Override
    public void update(State state, NPC currentNPC) {
        updateAlive++;
    }
}
