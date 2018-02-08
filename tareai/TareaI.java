package tareai;

import aima.core.agent.EnvironmentView;
import aima.core.agent.impl.SimpleEnvironmentView;

public class TareaI {
       
    public static void main(String[] args) {
        Park parque  = new Park();;
        Food comida = new Food();;
        Water agua = new Water();
        BlindDog perro = new BlindDog();
        EnvironmentView view = new SimpleEnvironmentView();
        parque.addEnvironmentView(view);
        
        parque.addAgent(perro);
        parque.addEnvironmentObject(comida);
        parque.addEnvironmentObject(agua);
        parque.step(10);
        
    }
}
