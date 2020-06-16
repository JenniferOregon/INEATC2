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
public class DatosDetalleSalida {
    private int idDetalle_Salida;
    private  String clave;
    private int Cantidad;
    private int idsalida;
    
    
    public DatosDetalleSalida(int idDetalle_Salida, String clave,int Cantidad,int idsalida){
    this.idDetalle_Salida=idDetalle_Salida;
    this.clave=clave;
    this.Cantidad=Cantidad;
    this.idsalida=idsalida;
   
    }
    
    public DatosDetalleSalida(){}

    public int getIdDetalle_Salida() {
        return idDetalle_Salida;
    }

    public void setIdDetalle_Salida(int idDetalle_Salida) {
        this.idDetalle_Salida = idDetalle_Salida;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getIdsalida() {
        return idsalida;
    }

    public void setIdsalida(int idsalida) {
        this.idsalida = idsalida;
    }

    
    }

    
    
    
    

