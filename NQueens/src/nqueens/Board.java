/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueens;

/**
 *
 * @author Vera
 */
public class Board {
    public int n;
    public int [] lugar;
    public int contador;
    public int cost;
    public int totalCost;
    
    public Board(int n){
        this.n = n;
        lugar = new int[n];
        for(int i = 0; i < n; i++)
            lugar[i] = 0;
        contador = 0;
        cost = 0;
        totalCost = 0;
    }
    
    public boolean isGoal(){
        return contador == n;
    }
    
    public boolean isSafe(int Col){
        for(int i = 0; i < contador; i++){
            if(lugar[i] == Col || Math.abs(Col-lugar[i]) == (contador - i))
                return false;
        }
        return true;
    }
    
    public void Place(int Col){
        if(Col >= 0 && Col < n){
            lugar[contador] = Col;
            contador++;
        }
        else System.out.println("Mala Columna");
    }
    
    public void unPlace(){
        if(contador > 0) contador--;
    }
    
    public Board copyBoard(){
        Board nuevo = new Board(n);
        nuevo.contador = this.contador;
        System.arraycopy(this.lugar, 0, nuevo.lugar, 0, n);
        return nuevo;
    }

}
