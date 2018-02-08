package tareai;

import aima.core.agent.Action;
import aima.core.agent.AgentProgram;
import aima.core.agent.Percept;
import aima.core.agent.impl.DynamicAction;

public class ProgramBlindDog implements AgentProgram {     
    public static final Action ACTION_MOVE_DOWN = new DynamicAction("move down");
    public static final Action ACTION_EAT = new DynamicAction("eat");
    public static final Action ACTION_DRINK = new DynamicAction("drink");
    
    @Override
    public Action execute(Percept prcpt) {
        if (prcpt instanceof Food)
            return ACTION_EAT;
        if (prcpt instanceof Water)
            return ACTION_DRINK;
        return ACTION_MOVE_DOWN;
    }
}
