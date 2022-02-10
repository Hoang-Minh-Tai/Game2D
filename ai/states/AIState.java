package ai.states;

import ai.AITransition;
import entity.NPC;
import game.states.State;

public abstract class AIState {
    private AITransition transition;

    public AIState() {
        this.transition = initializeTransition();
    }

    protected abstract AITransition initializeTransition();
    public abstract void update(State state,NPC currentNPC);

    public boolean shouldTransition(State state, NPC currentNPC) {
        return transition.shouldTransition(state,currentNPC);
    }

    public String getNextState() {
        return transition.getNextState();
    }
}
