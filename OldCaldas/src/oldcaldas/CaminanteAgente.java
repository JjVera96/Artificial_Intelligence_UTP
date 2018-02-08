/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldcaldas;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.Percept;
import cnrs.grph.set.IntSet;
import grph.Grph;
import grph.algo.AdjacencyMatrix;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vera
 */
public class CaminanteAgente implements Agent{
    boolean alive;
    int infinite = 2147483647;
    
    @Override
    public Action execute(Percept prcpt) {
         throw new UnsupportedOperationException("Not supported yet.");//To change body of generated methods, choose Tools | Templates.
    }
    
    public void execute(String modo, Grafo g, String a, String b) {        
        if(modo.equals("BFS")) BFS(g, a, b);
        if(modo.equals("DFS")) DFS(g, a, b);
        
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public void BFS (Grafo g, String initial, String Final){
        Grph ga = g.g;
        int intInitial = 0, intFinal = 0;
        for(int i = 0; i < g.cantNodos; i++){
            if(ga.getVertexLabelProperty().getValue(i).equals(initial)) {intInitial = i; break;}
        }
        for(int j = 0; j < g.cantNodos; j++){
            if(ga.getVertexLabelProperty().getValue(j).equals(Final)) {intFinal = j;break;}
        }
        BFS(ga, intInitial, intFinal);
    }
    
    /*
    0 - White
    1 - Gray
    2 - Black
    -1 - null
    */
    public void BFS (Grph g, int a, int b) {
        List queue = new ArrayList();
        IntSet vertex = g.getVertices();
        int[] color = new int[vertex.size()];
        int[] padre = new int[vertex.size()];
        int[] distancia = new int[vertex.size()];
        boolean bandera = true;
        int u;
        for (int i = 0; i < vertex.size(); i++ ) {
            if(i != a){
                color[i] = 0;
                padre[i] = -1;
                distancia[i] = infinite;
            }
        }
        AdjacencyMatrix matriz = g.getAdjacencyMatrix();
        color[a] = 1;
        distancia[a] = 0;
        padre[a] = -1;
        queue.add(a);
        while(!queue.isEmpty()){
            u = (int) queue.get(0);
            System.out.println("Agente: Estoy en " + g.getVertexLabelProperty().getValueAsString(u));
            queue.remove(0);  
            if(u == b) {
                bandera = false;
                break;
            }
            for(int v = 0; v < 53; v++){
                int i = matriz.get(u, v);
                if(i != 0){
                    if(color[v] == 0){
                        color[v] = 1;
                        distancia[v] = distancia[u] + 1;
                        padre[v] = u;
                        queue.add(v);
                    }
                }
            }
            color[u] = 2;
        }
        if(bandera) {
            System.out.println("La ciudad destino no existe o es imposible alcanzarla");
        }
        else{
            System.out.println("Camino a seguir:");
            int x = padre[b];
            List camino = new ArrayList();
            camino.add(b);
            while(x != -1) {
                camino.add(x);
                x = padre[x];
            }
            for(int i = camino.size()-1; i >= 0; i--){
                int y = (int) camino.get(i);
                System.out.println(g.getVertexLabelProperty().getValueAsString(y));
            }
        }
    }        
    
    public void DFS (Grafo g, String initial, String Final){
        Grph ga = g.g;
        int intInitial = 0, intFinal = 0;
        for(int i = 0; i < g.cantNodos; i++){
            if(ga.getVertexLabelProperty().getValue(i).equals(initial)) {intInitial = i; break;}
        }
        for(int j = 0; j < g.cantNodos; j++){
            if(ga.getVertexLabelProperty().getValue(j).equals(Final)) {intFinal = j;break;}
        }
        DFS(ga, intInitial, intFinal);
    }
    
    
    /*
    0 - White
    1 - Gray
    2 - Black
    -1 - null
    */
    public void DFS(Grph g, int a, int b) {
        IntSet vertex = g.getVertices();
        int[] color = new int[vertex.size()];
        int[] padre  = new int[vertex.size()];
        int[] distancia = new int[vertex.size()];
        AdjacencyMatrix matriz = g.getAdjacencyMatrix();
        int time;
        for (int i = 0; i < vertex.size(); i++ ) {
                color[i] = 0;
                padre[i] = -1;
        }
        time = 0;
        for (int u = 0; u < vertex.size(); u++ ) {
            if(color[u] == 0) DFS_VISIT(matriz, u, time, color, padre, distancia);
        }
    }
    
    private void DFS_VISIT(AdjacencyMatrix matriz, int u, int time, int[] color, int[] padre, int[] distancia) {
        color[u] = 1;
        time++;
        distancia[u] = time;
        for(int v = 0; v < 53; v++){
            int i = matriz.get(u, v);
            if(i != 0){
                if(color[v] == 0){
                    padre[v] = u;
                    DFS_VISIT(matriz, v, time, color, padre, distancia);
                }
            }
        }
        color[u] = 2;
        
    }
    
}
