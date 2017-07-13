package com.example.rosalia.tpbuffet.Log_in;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jona on 20/06/2017.
 */
public class MyHiloLo_gin implements Runnable {
    private String ruta;
    private Handler myHandler;
    private int opcion=0;
    private Uri.Builder parametro;
    private List<Uri.Builder> pedido;

    public MyHiloLo_gin (String ruta,Handler myHandler, int opcion){
        this.ruta=ruta;
        this.myHandler=myHandler;
        this.opcion=opcion;
    }
    public MyHiloLo_gin(String ruta, Handler myHandler, Uri.Builder paramatro,int opcion){
        this.ruta=ruta;
        this.myHandler=myHandler;
        this.parametro=paramatro;
        this.opcion=opcion;
    }
    //public MyHiloLo_gin(String ruta, Handler myHandler, List<Uri.Builder> pedido, int opcion){
      //  this.ruta=ruta;
        //this.myHandler=myHandler;
        //this.pedido=pedido;
        //this.opcion=opcion;
    //}


    @Override
    public void run() {
        Message mensaje = new Message();
        byte[] informacion= null;
        String listado=null;
        MyConexion myConexion = new MyConexion();
        try{
            switch (opcion){
                case 1:
                        informacion=myConexion.traerDatos(ruta);
                        Log.d("se ejecuto","la conexion");
                        mensaje.arg1=1;
                        mensaje.obj=informacion;
                    break;
                case 2:
                        informacion=myConexion.posBytes(ruta, parametro);
                        mensaje.arg1=2;
                        mensaje.obj=informacion;
                    break;
                case 3:
                        listado=myConexion.getListado(ruta);
                        mensaje.arg1=1;
                        mensaje.obj=listado;
                    break;
            }

                myHandler.sendMessage(mensaje);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
