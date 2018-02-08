package tareai;

import aima.core.agent.impl.AbstractAgent;

public class BlindDog extends AbstractAgent{
    
    public BlindDog(){
        super(new ProgramBlindDog());
    }
    
    public void eat(Food comida){    
        System.out.println("Perro: comió en " + comida.location);
    }
    
    public void drink(Water bebida){
        System.out.println("Perro: bebió en " + bebida.location);
    }
}
