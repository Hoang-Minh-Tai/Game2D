package ai;

import ai.states.AIState;
import ai.states.Stand;
import ai.states.Wander;
import entity.NPC;
import game.states.State;

public class AIManager {
    private AIState currentAIState;

    public AIManager() {
        transitionTo("stand");
    }

    public void update(State state, NPC currentNPC) {
        currentAIState.update(state, currentNPC);
        if (currentAIState.shouldTransition(state, currentNPC)) {
            transitionTo(currentAIState.getNextState());
        }
    }

    private void transitionTo(String nextState) {
        System.out.println("Transitioning to: "+nextState);
        switch (nextState) {
            case "wander":
                currentAIState = new Wander();
                break;
            case "stand":
                currentAIState = new Stand();
                break;
            default:
                currentAIState = new Stand();
        }
    }
}
