package ai.states;

import ai.AITransition;
import controller.NPCController;
import core.Position;
import entity.NPC;
import game.states.State;

import java.util.ArrayList;
import java.util.List;

public class Wander extends AIState{
    private List<Position> targets;

    public Wander() {
        targets = new ArrayList<>();
    }

    @Override
    protected AITransition initializeTransition() {
        return new AITransition("stand",(((state, currentNPC) -> targetArrived(currentNPC))));
    }

    private boolean targetArrived(NPC currentNPC) {
        return currentNPC.getPosition().isInRangeOf(targets.get(0));
    }

    @Override
    public void update(State state, NPC currentNPC) {
        if (targets.isEmpty()) {
            targets.add(state.getRandomPosition());
        }
        NPCController controller = (NPCController) currentNPC.getController();
        controller.moveToTarget(currentNPC.getPosition(),targets.get(0));

        if (targetArrived(currentNPC)) {
            controller.stop();
        }
    }
}
