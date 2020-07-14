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
public class DatosDetalleEntrada {
    private int idDetalle_Entrada;
    private  String idLibro;
    private int Cantidad;
    private int idEntrada;
   
    
    public DatosDetalleEntrada(int idDetalle_Entrada, String idLibro,int Cantidad,int idEntrada ){
    this.idDetalle_Entrada=idDetalle_Entrada;
    this.idLibro=idLibro;
    this.Cantidad=Cantidad;
    this.idEntrada=idEntrada;
    }
    
    public DatosDetalleEntrada(){}

    public int getIdDetalle_Entrada() {
        return idDetalle_Entrada;
    }

    public void setIdDetalle_Entrada(int idDetalle_Entrada) {
        this.idDetalle_Entrada = idDetalle_Entrada;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    
    
    
    
}
