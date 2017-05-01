package com.example.rosalia.tpbuffet.Log_in.Log_in;

/**
 * Created by Jona on 30/04/2017.
 */
public class ModeloLog_in {
    private String mail;
    private String clave;

    public ModeloLog_in(){}

    public ModeloLog_in(String mail, String clave){
        this.mail=mail;
        this.clave=clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public String getMail() {
        return mail;
    }
}
