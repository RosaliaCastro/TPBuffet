package com.example.rosalia.tpbuffet.Log_in.Registro;

import android.app.Activity;
import android.view.View;

import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 30/04/2017.
 */
public class ControladorRegistro implements View.OnClickListener {
    ModeloRegistro modeloRegistro;
    Activity myActivity;
    VistaRegistro vistaRegistro;

    public ControladorRegistro (ModeloRegistro modeloRegistro, Activity myActivity){
        this.modeloRegistro=modeloRegistro;
        this.myActivity=myActivity;
    }

    public void setControladorVista(VistaRegistro vistaRegistro){
        this.vistaRegistro=vistaRegistro;
    }
    public Boolean validarMail(String mail)
    {
        Boolean res=false;
        int cant = mail.length();
        for (int i=0; i < cant; i++){
            Character letra = mail.charAt(i);
            if (letra == '@'){
                res = true;
            }
        }
        return  res;
    }
    public Boolean validarClave(String clave, String reingrese){
        Boolean res=false;
        if (clave.equals(reingrese))
        {
            res= true;
        }
        return  res;
    }

    public Boolean validarCampo(String mail, String clave, String reingrese){
        Boolean res=false;
        if (mail!= "" && clave != "" && reingrese != "")
        {
            res= true;
        }
        return  res;

    }


    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btnRegistrarme2){
            String mail = vistaRegistro.mail.getText().toString();
            String clave= vistaRegistro.clave.getText().toString();
            String reingrese=vistaRegistro.reingrese.getText().toString();
            if (validarCampo(mail, clave, reingrese)){
                if (validarMail(mail)){
                    if (validarClave(clave,reingrese)){
                        vistaRegistro.limpiar();
                    }
                }
            }
        }
    }

    }

