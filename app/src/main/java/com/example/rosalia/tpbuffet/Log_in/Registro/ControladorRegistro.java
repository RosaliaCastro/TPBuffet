package com.example.rosalia.tpbuffet.Log_in.Registro;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;

import com.example.rosalia.tpbuffet.Log_in.Log_in.ControladorLog_in;
import com.example.rosalia.tpbuffet.Log_in.Log_in.Log_in;
import com.example.rosalia.tpbuffet.Log_in.Log_in.MiDialogo;
import com.example.rosalia.tpbuffet.Log_in.Log_in.ModeloLog_in;
import com.example.rosalia.tpbuffet.Log_in.MyHiloLo_gin;
import com.example.rosalia.tpbuffet.Log_in.Pedido.Dialogo;
import com.example.rosalia.tpbuffet.Log_in.Servicios;
import com.example.rosalia.tpbuffet.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 30/04/2017.
 */
public class ControladorRegistro implements View.OnClickListener, Handler.Callback {
    Servicios ruta = new Servicios();
    ModeloRegistro modeloRegistro;
    Activity myActivity;
    VistaRegistro vistaRegistro;
    MyHiloLo_gin miHilo;
    Handler myHandler= new Handler(this);
    MiDialogo dialogo1 = new MiDialogo();

    public ControladorRegistro (ModeloRegistro modeloRegistro, Activity myActivity){
        this.modeloRegistro=modeloRegistro;
        this.myActivity=myActivity;
    }

    public void setControladorVista(VistaRegistro vistaRegistro){
        this.vistaRegistro=vistaRegistro;
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
            String nombre = vistaRegistro.nombre.getText().toString();
            String apellido = vistaRegistro.apellido.getText().toString();
            String dni=vistaRegistro.dni.getText().toString();
            String mail = vistaRegistro.mail.getText().toString();
            String clave= vistaRegistro.clave.getText().toString();
            String reingrese=vistaRegistro.reingrese.getText().toString();

            if (validarCampo(nombre,apellido,dni,mail, clave, reingrese))//valida campos vacios
            {
                if (validarClave(clave,reingrese)){ //valida que sean iguales

                    String servicioValidarC=ruta.getRutaLogin()+mail+"/"+clave;
                    miHilo = new MyHiloLo_gin(servicioValidarC, myHandler,1);
                    Thread hiloUnoR = new Thread(miHilo);
                    hiloUnoR.start();
                }else{
                        dialogo1.show(myActivity.getFragmentManager(),"alerta4");
                        dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje4));
                    }
            }else{
                dialogo1.show(myActivity.getFragmentManager(),"alerta1");
                dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje1));
            }

        }
    }
    public void validarUsuario() {

        if (modeloRegistro.getCodigo() == 200) {
            dialogo1.show(myActivity.getFragmentManager(),"alerta2");
            dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje5));
            vistaRegistro.limpiar();
        } else { if(modeloRegistro.getCodigo() == 400 || modeloRegistro.getCodigo() ==500){
            Uri.Builder parametro = new Uri.Builder();
            parametro.appendQueryParameter("nombre", vistaRegistro.nombre.getText().toString());
            parametro.appendQueryParameter("apellido", vistaRegistro.apellido.getText().toString());
            parametro.appendQueryParameter("dni", vistaRegistro.dni.getText().toString());
            parametro.appendQueryParameter("mail", vistaRegistro.mail.getText().toString());
            parametro.appendQueryParameter("clave", vistaRegistro.clave.getText().toString());
            miHilo = new MyHiloLo_gin(ruta.getRutaRegistrar(), myHandler,parametro,2);
            Thread hiloDosR = new Thread(miHilo);
            hiloDosR.start();
            }
        }
    }

    public void parcearNuevo(String resultado){
        try {
           JSONObject js = new JSONObject(resultado);
            String mensaje= js.getString("mensaje");
            modeloRegistro.setMensaje(mensaje);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(modeloRegistro.getMensaje()=="se inserto correctamente"){
            dialogo1.show(myActivity.getFragmentManager(),"alerta");
            dialogo1.setMensaje(modeloRegistro.getMensaje());

            Intent logearse = new Intent(myActivity, Log_in.class);
            myActivity.startActivity(logearse);
        }else {
            dialogo1.show(myActivity.getFragmentManager(),"alerta");
            dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje7));
            Intent logearse = new Intent(myActivity, Log_in.class);
            myActivity.startActivity(logearse);
        }
    }
    public void parcear(String str){
        try{
            JSONObject jsonObject = new JSONObject(str);
            String mensaje = jsonObject.getString("mensaje");
            Integer cod = jsonObject.getInt("codigo");
            modeloRegistro.setCodigo(cod);
            modeloRegistro.setMensaje(mensaje);
            Log.d("Mensaje","parceado");
            validarUsuario();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        String resultado=null;
        Log.d("Recibendo","Mensaje");
        byte [] byts= (byte[]) message.obj;
        if (message.arg1==1){
            try {
                resultado= new String(byts, "UTF-8");
                parcear(resultado);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else if(message.arg1==2) {
            try {
                resultado = new String(byts, "UTF-8");
                parcearNuevo(resultado);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else
        dialogo1.show(myActivity.getFragmentManager(),"alerta3");
        dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje7));

        return false;
    }
}

