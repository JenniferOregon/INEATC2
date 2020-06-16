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
public class DatosEntrada {
    private int idEntrada;
    private  String Fecha;
    private String Hora;
    private int idusuario;
    
    public DatosEntrada(int idEntrada, String Fecha,String Hora,int idusuario){
    this.idEntrada=idEntrada;
    this.Fecha=Fecha;
    this.Hora=Hora;
    this.idusuario=idusuario;
    
    }
    
    public DatosEntrada(){}

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
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

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    

    
    
    
    
}
