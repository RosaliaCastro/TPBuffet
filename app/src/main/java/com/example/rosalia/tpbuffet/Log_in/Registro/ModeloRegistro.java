package com.example.rosalia.tpbuffet.Log_in.Registro;

import java.util.List;

/**
 * Created by Jona on 11/05/2017.
 */
public class ModeloRegistro {
    private String nombre;
    private String apellido;
    private String dni;
    private String mail;
    private String clave;
    private String reingrese;
    private String mensaje;
    private Integer codigo;

    public ModeloRegistro(){}

    public ModeloRegistro(String nombre, String apellido,String dni, String mail, String clave, String reingrese){
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.mail=mail;
        this.clave= clave;
        this.reingrese=reingrese;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDni() {
        return dni;
    }
    public String getMail() {
        return mail;
    }
    public String getClave() {
        return clave;
    }
    public String getReingrese() {
        return reingrese;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setReingrese(String reingrese) {
        this.reingrese = reingrese;
    }
}
