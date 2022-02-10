package ai;

import entity.NPC;
import game.states.State;

public class AITransition {
    private String nextState;
    private AICondition condition;

    public AITransition(String nextState, AICondition condition) {
        this.nextState = nextState;
        this.condition = condition;
    }

    public boolean shouldTransition(State state, NPC currentNPC) {
        return condition.isMet(state,currentNPC);
    }

    public String getNextState() {
        return nextState;
    }
}
