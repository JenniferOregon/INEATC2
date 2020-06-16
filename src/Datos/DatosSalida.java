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
       
public class DatosSalida {
     private int idSalida ;
    private  String Fecha;
    private String Hora;
    private String RFC;
    private int idusuario;
    
    public DatosSalida(int idSalida,String Fecha,String Hora, String RFC,int idusuario){
    this.idSalida=idSalida;
    this.Fecha=Fecha;
    this.Hora=Hora;
    this.RFC=RFC;
    this.idusuario=idusuario;
     }
    
      public DatosSalida(){}

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    
      
}
