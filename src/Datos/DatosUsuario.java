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
public class DatosUsuario {
    private int idusuario;
    private  String Nombre;
    private String Apellido;
    private String Telefono;
    private String Correo;
    private String nick;
    private String Contrasena;
    private String Rol;
    
    public DatosUsuario(int idusuario, String Nombre,String Apellido,String Telefono,String Correo,String nick,String Contrasena,String Rol){
    this.idusuario=idusuario;
    this.Nombre=Nombre;
    this.Apellido=Apellido;
    this.Telefono=Telefono;
    this.Correo=Correo;
    this.nick=nick;
    this.Contrasena=Contrasena;
    this.Rol=Rol;
    }
    
    public DatosUsuario(){}

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    
    
    
    
}
