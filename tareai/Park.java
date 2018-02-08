package tareai;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractEnvironment;
import aima.core.agent.impl.DynamicAction;
import aima.core.agent.EnvironmentObject;
import aima.core.agent.impl.DynamicPercept;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alirio
 */
public class Park extends AbstractEnvironment {
    public static final Action ACTION_MOVE_DOWN = new DynamicAction("move down");
    public static final Action ACTION_EAT = new DynamicAction("eat");
    public static final Action ACTION_DRINK = new DynamicAction("drink");
    public List<EnvironmentObject> eObjects = new ArrayList<> ();
            
    @Override
    public void executeAction(Agent agent, Action action) {
        if (ACTION_MOVE_DOWN == action) System.out.println("Seguir Derecho");
        if (ACTION_EAT == action) System.out.println("Comer");
        if (ACTION_DRINK == action) System.out.println("Beber");
    }
    
    public void addAgents(Agent agent, int location){
        addEnvironmentObject(agent, location);
    }
    
    public void addEnvironmentObject(EnvironmentObject eo, int location) {
        eObjects.add(location, eo);
        if (eo instanceof Water) ((Water) eo).location = location;
        if (eo instanceof Food) ((Food) eo).location = location;
        if (eo instanceof Agent) {
            Agent a = (Agent) eo;
            if (!agents.contains(a)) {
                agents.add(a);
                this.notifyEnvironmentViews(a);
            }
        }
    }

    @Override
    public Percept getPerceptSeenBy(Agent agent) {
        return new DynamicPercept();
    }
}
