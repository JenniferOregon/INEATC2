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
       
public class DatosAsesor {
    private String RFC;
    private String Nombre;
    private String Apellido;
    private String Domicilio;
    private String Telefono;
    private String Correo;
    
    public DatosAsesor(String RFC,String Nombre,String Apellido,String Domicilio,String Telefono,String Correo){
    this.RFC=RFC;
    this.Nombre=Nombre;
    this.Apellido=Apellido;
    this.Domicilio=Domicilio;
    this.Telefono=Telefono;
    this.Correo=Correo;
     }
    
      public DatosAsesor(){}

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    
    
      
}
