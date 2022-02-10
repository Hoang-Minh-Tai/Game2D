package ai;

import entity.NPC;
import game.states.State;

public interface AICondition {
    boolean isMet(State state, NPC currentNPC);
}
