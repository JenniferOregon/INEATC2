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
       
public class DatosDependencia {
    private int idDependencia;
    private String Nombre;
    private String Dependencia;
    private String Cordinacion_de_zona;
    private String Direccion;
    private String Telefono;
    
    public DatosDependencia(int idDependencia,String Nombre,String Dependencia,String Cordinacion_de_zona,String Direccion,String Telefono){
    this.idDependencia=idDependencia;
    this.Nombre=Nombre;
    this.Dependencia=Dependencia;
    this.Cordinacion_de_zona=Cordinacion_de_zona;
    this.Direccion=Direccion;
    this.Telefono=Telefono;
     }
    
     public DatosDependencia(){}

    public int getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(int idDependencia) {
        this.idDependencia = idDependencia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDependencia() {
        return Dependencia;
    }

    public void setDependencia(String Dependencia) {
        this.Dependencia = Dependencia;
    }

    public String getCordinacion_de_zona() {
        return Cordinacion_de_zona;
    }

    public void setCordinacion_de_zona(String Cordinacion_de_zona) {
        this.Cordinacion_de_zona = Cordinacion_de_zona;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
     
    
      
}
