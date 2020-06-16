/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Jenni
 */
       
public class DatosLibro {
    private String Clave;
    private  String Nombre;
    private int Unidades;
    
    public DatosLibro(String Clave,String Nombre,int Unidades ){
    this.Clave=Clave;
    this.Nombre=Nombre;
    this.Unidades=Unidades;
     }
    
      public DatosLibro(){}

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getUnidades() {
        return Unidades;
    }

    public void setUnidades(int Unidades) {
        this.Unidades = Unidades;
    }
      
}
