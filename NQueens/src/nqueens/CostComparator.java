/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueens;

import java.util.Comparator;

/**
 *
 * @author Vera
 */
public class CostComparator implements Comparator<Board>{
    @Override
    public int compare(Board x, Board y){
        if(x.totalCost < y.totalCost) return -1;
        if(x.totalCost > y.totalCost) return 1;
        return 0;
    }
}
