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
public class NQueens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 4;
        Solved nqueens = new Solved(n);
        nqueens.BFS();
        System.out.println(nqueens);
        nqueens.DFS();
        System.out.println(nqueens);
        nqueens.UC();
        System.out.println(nqueens);
    }
    
}
