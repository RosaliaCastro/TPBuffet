package com.example.rosalia.tpbuffet.Log_in;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Jona on 20/06/2017.
 */
public class MyHiloLo_gin implements Runnable {
    private String ruta;
    private Handler myHandler;

    public MyHiloLo_gin (String ruta,Handler myHandler){
        this.ruta=ruta;
        this.myHandler=myHandler;
    }

    @Override
    public void run() {
        Message mensaje = new Message();
        byte[] informacion= null;
        MyConexion myConexion = new MyConexion();
        try{
                informacion=myConexion.getBytesDateByGET(ruta);
                Log.d("se ejecuto","la conexion");
                mensaje.obj=informacion;
                myHandler.sendMessage(mensaje);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
