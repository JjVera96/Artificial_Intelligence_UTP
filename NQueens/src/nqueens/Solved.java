/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueens;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Vera
 */
public class Solved {
    int [][] matrix;
    Board tablero, solucion;
    int n;
    int veces;
    Queue Q;
    PriorityQueue PQ;
    
    public Solved(int n){
        this.n = n;
        matrix = new int[n][n];
        veces = 0;
    }
    
    public void llenarMatrix() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = 0;
        for(int i = 0; i < tablero.contador; i++ ){
            int j = tablero.lugar[i];
            matrix[i][j] = 1;
        }
    }   
    
    public void llenarMatrix(Board tablerito){
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = 0;
        for(int i = 0; i < tablerito.contador; i++ ){
            int j = tablerito.lugar[i];
            matrix[i][j] = 1;
        }
    }
    
    public void BFS(){
        veces = 0;
        Q = new LinkedList();
        tablero = new Board(n);
        tablero = BFS_Algorithm(tablero);
        llenarMatrix();
    }
    
    public Board BFS_Algorithm(Board tablero){
        Q.add(tablero);
        while(!Q.isEmpty()){
            veces++;
            System.out.println("BFS");
            System.out.println("Repeticion #" + veces);
            System.out.println(this);
            time();
            tablero = (Board)Q.element();
            Q.remove();
            if(tablero.isGoal()){
                System.out.println("Solucion Encontrada");
                System.out.println("Cantidad de veces ejecutado el algoritmo " + veces);
                return tablero;
            }
            else{
                for(int i = 0; i < n; i++){
                    Board hijo = tablero.copyBoard();
                    llenarMatrix(hijo);
                    if(hijo.isSafe(i)){
                        hijo.Place(i);
                        Q.add(hijo);
                    }
                }
            }
        }
        return null;
    }
    
    public void DFS(){
        veces = 0;
        tablero = new Board(n);
        solucion = DFS_Algorithm(tablero);
        llenarMatrix();
    }
     
    public Board DFS_Algorithm(Board tablero){
        veces++;
        System.out.println("DFS");
        llenarMatrix();
        System.out.println("Repeticion #" + veces);
        System.out.println(this);
        time();
        if(tablero.isGoal()){
            System.out.println("Solucion Encontrada");
            System.out.println("Cantidad de veces ejecutado el algoritmo " + veces);
            return tablero;
        }
        else{
            for(int i = 0; i < tablero.n; i++){
                if(tablero.isSafe(i)){
                    tablero.Place(i);
                    Board sol = DFS_Algorithm(tablero);
                    if(sol != null){
                        return sol;
                    }
                    tablero.unPlace();
                }
            }
        }
        return null;
    }
    
    public void UC(){
        veces = 0;
        CostComparator comparador = new CostComparator();
        PQ = new PriorityQueue<>(1, comparador);
        tablero = new Board(n);
        tablero = UC_Algorithm(tablero);
        llenarMatrix();
    }
    
    public Board UC_Algorithm(Board tablero){
        PQ.add(tablero);
        while(!PQ.isEmpty()){
            veces++;
            System.out.println("UC");
            System.out.println("Repeticion #" + veces);
            System.out.println(this);
            time();
            tablero = (Board)PQ.element();
            PQ.remove();
            if(tablero.isGoal()){
                System.out.println("Solucion Encontrada");
                System.out.println("Cantidad de veces ejecutado el algoritmo " + veces);
                return tablero;
            }
            else{
                for(int i = 0; i < n; i++){
                    Board hijo = tablero.copyBoard();
                    llenarMatrix(hijo);
                    if(hijo.isSafe(i)){
                        hijo.Place(i);
                        PQ.add(hijo);
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < n; i++){
            str += "|";
            for(int j = 0; j < n; j++){
                str += String.format(" %d |", matrix[i][j]);
            }
            str += "\n";
        }
        return  str;
    }
    
    public static void time()
    {
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }
    }
}