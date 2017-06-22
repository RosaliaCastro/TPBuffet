package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.net.Uri;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.Message;
import android.widget.Switch;

import java.io.IOException;

/**
 * Created by Jona on 20/06/2017.
 */
public class MyHiloLo_gin implements Runnable {
    private String ruta;
    private Handler myHandler;
    int opcion=0;

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
            switch(opcion) {
            case 1:
                informacion=myConexion.getBytesDateByGET(ruta);
                mensaje.arg1=1;
                mensaje.obj=informacion;
                break;
                case 2:
                    informacion=myConexion.getBytesDateByGET(ruta);
                    mensaje.arg1=2;
                    mensaje.obj=informacion;
                    break;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            Thread.sleep(1000);

            myHandler.sendMessage(mensaje);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
