package com.example.rosalia.tpbuffet;

import android.app.Activity;
import android.view.View;

/**
 * Created by Jona on 30/04/2017.
 */
public class ControladorLog_in implements View.OnClickListener {
    private ModeloLog_in modeloLog_in;
    private Activity myActivity;
    private VistaLog_in vistaLog_in;

    public ControladorLog_in(ModeloLog_in modeloLog_in, Activity myActivity){
        this.modeloLog_in= modeloLog_in;
        this.myActivity=myActivity;
    }

    public void setControladorVista(VistaLog_in vistaLog_in)
    {
        this.vistaLog_in=vistaLog_in;
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
    public Boolean validarCampo(String mail, String clave){
        Boolean res=false;
        if (mail!= "" && clave != "")
        {
            res= true;
        }
        return  res;

    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btnIngresar){
            String mail = vistaLog_in.mail.getText().toString();
            String clave= vistaLog_in.clave.getText().toString();
            if (validarCampo(mail, clave)){
                if (validarMail(mail)){
                    vistaLog_in.limpiar();
                }
                }
            }
        }

    }

