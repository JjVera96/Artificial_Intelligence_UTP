/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldcaldas;

/**
 *
 * @author Vera
 */
public class Ciudad {
    private String nombre;
    private double longitud;
    private double latitud;
    
    public Ciudad(String nombre, double longitud, double latitud){
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
    }
    
    public String getNombre () {
        return nombre;
    }
    
    public double getLatitud () {
        return latitud;
    }
    
    public double getLongitud () {
        return longitud;
    }
}
