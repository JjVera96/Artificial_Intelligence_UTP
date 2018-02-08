/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldcaldas;

import grph.Grph;

/**
 *
 * @author utp
 */

public class Grafo {
    Grph g;
    int cantNodos;
    
    public Grafo (int n) {
        g = new Grph();
        g.addNVertices(n);
        cantNodos = n;
    }
    public void display () {
        g.display();
    }
            
    public void addEgdeString(String initial, String Final, double ilong, double ilat, double flong, double flat) {
        int intInitial = 0, intFinal = 0;
        for(int i = 0; i < cantNodos; i++){
            if(g.getVertexLabelProperty().getValue(i).equals(initial)) {intInitial = i; break;}
        }
        for(int j = 0; j < cantNodos; j++){
            if(g.getVertexLabelProperty().getValue(j).equals(Final)) {intFinal = j;break;}
        }
        addEdge(intInitial, intFinal, ilong, ilat, flong, flat);
    }
    
    public void addEdge (int nodeInitial, int nodeFinal, double ilong, double ilat, double flong, double flat) {
        int egde = g.addSimpleEdge(nodeInitial, nodeFinal, false);
        double peso = weight(ilong, ilat, flong, flat);   
        g.getEdgeWeightProperty().setValue(egde, (int) peso);
        g.getEdgeLabelProperty().setValue(egde, Double.toString((int)peso));
    }
    
    public void setLabel (int node, String name) {
        g.getVertexLabelProperty().setValue(node, name);
    }
    
    public double weight(double ilong, double ilat, double flong, double flat) {
        double lat = ilat - flat;
        double lon = ilong - flong;
        double R = 6378, a, c;
        lat = lat*Math.PI/180;
        lon = lon*Math.PI/180;
        a = Math.sin(lat/2) + Math.cos(ilat) * Math.cos(flat) * Math.sin(lon/2);
        c = 2 * Math.atan(a);
        return Math.abs(R*c);
    }
}
