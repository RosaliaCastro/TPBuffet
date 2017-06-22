package com.example.rosalia.tpbuffet.Log_in.Log_in;

import java.util.List;

/**
 * Created by Jona on 30/04/2017.
 */
public class ModeloLog_in {
    private String mail;
    private String clave;
    private Integer codigo;

    public ModeloLog_in(){

    }

    public ModeloLog_in(String mail, String clave){
        this.mail=mail;
        this.clave=clave;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMail() {
        return mail;
    }
    public String getClave() {
        return clave;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
}
