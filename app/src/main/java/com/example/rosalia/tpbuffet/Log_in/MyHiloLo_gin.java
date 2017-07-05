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

/**
 * Created by Jona on 20/06/2017.
 */
public class MyHiloLo_gin implements Runnable {
    private String ruta;
    private Handler myHandler;
    private int opcion=0;
    private Uri.Builder parametro;
    private Activity myActivity;

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
    public MyHiloLo_gin (String ruta, Handler myHandler, int opcion, Activity myActivity){
        this.ruta=ruta;
        this.myHandler=myHandler;
        this.opcion=opcion;
        this.myActivity=myActivity;
    }

    @Override
    public void run() {
        Message mensaje = new Message();
        byte[] informacion= null;
        Bitmap dato= null;
        MyConexion myConexion = new MyConexion();
        try{
            switch (opcion){
                case 1:
                    informacion=myConexion.getBytesDateByGET(ruta);
                    Log.d("se ejecuto","la conexion");
                    mensaje.arg1=1;
                    mensaje.obj=informacion;
                    break;
                case 2:
                    informacion=myConexion.posBytes(ruta, parametro);
                    Log.d("se ejecuto", "la conexion");
                    mensaje.arg1=2;
                    mensaje.obj=informacion;
                    break;
                case 3:
                    //Nos conectamos a internet para descargar las imagenes.
                    if(ContextCompat.checkSelfPermission(myActivity, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED ){
                    dato=myConexion.traerImagen(ruta);

                    }


            }

                myHandler.sendMessage(mensaje);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
