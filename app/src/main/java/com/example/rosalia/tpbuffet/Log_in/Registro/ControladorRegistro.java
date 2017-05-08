package com.example.rosalia.tpbuffet.Log_in.Registro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.example.rosalia.tpbuffet.Log_in.Log_in.ControladorLog_in;
import com.example.rosalia.tpbuffet.Log_in.Log_in.Log_in;
import com.example.rosalia.tpbuffet.Log_in.Log_in.MiDialogo;
import com.example.rosalia.tpbuffet.Log_in.Log_in.ModeloLog_in;
import com.example.rosalia.tpbuffet.R;

import java.util.ArrayList;
import java.util.List;

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

    public Boolean validarCampo(String nombre,String apellido, String dni, String mail, String clave, String reingrese){
        boolean res = true;
        if (nombre.equals("") || apellido.equals("") || dni.equals("") || mail.equals("") || clave.equals("") ||reingrese.equals("") ){
            res=false;
        }

        return res;

    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btnRegistrarme2){

            MiDialogo dialogo = new MiDialogo();
            MiDialogo dialogo1 = new MiDialogo();
            MiDialogo dialogo2 = new MiDialogo();

            String nombre = vistaRegistro.nombre.getText().toString();
            String apellido = vistaRegistro.apellido.getText().toString();
            String dni=vistaRegistro.dni.getText().toString();
            String mail = vistaRegistro.mail.getText().toString();
            String clave= vistaRegistro.clave.getText().toString();
            String reingrese=vistaRegistro.reingrese.getText().toString();

            if (validarCampo(nombre,apellido,dni,mail, clave, reingrese)){
                if (validarMail(mail)){
                    if (validarClave(clave,reingrese)){
                        ModeloRegistro nuevo = new ModeloRegistro(nombre,apellido,dni,mail,clave,reingrese);
                        Intent logearse = new Intent(myActivity, Log_in.class);
                        logearse.putExtra("mail",mail);
                        logearse.putExtra("clave",clave);
                        myActivity.startActivity(logearse);

                    }else{
                        dialogo2.show(myActivity.getFragmentManager(),"alertaTres");
                        dialogo2.setMensaje("Ambas claves deben ser iguales");
                    }
                }else{
                    dialogo1.show(myActivity.getFragmentManager(),"alertaDos");
                    dialogo1.setMensaje("Ingrese un Mail correcto.");
                }
            }else{
                dialogo.show(myActivity.getFragmentManager(),"alertaUno");
                dialogo.setMensaje("Completar todos los campos.");

            }

            vistaRegistro.limpiar();
            vistaRegistro.nombre.findViewById(R.id.txtNombre).setFocusable(false);

        }
    }

    }

