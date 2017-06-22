package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.ListUpdateCallback;
import android.util.Log;
import android.widget.TextView;

import com.example.rosalia.tpbuffet.Log_in.Menu.VistaMenu;
import com.example.rosalia.tpbuffet.Log_in.Registro.ControladorRegistro;
import com.example.rosalia.tpbuffet.R;

import java.util.ArrayList;
import java.util.List;

public class Log_in extends AppCompatActivity implements Handler.Callback {
private Handler myHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        myHandler= new Handler(this);
        MyHiloLo_gin myHiloLo_gin = new MyHiloLo_gin("http://192.168.1.36:3000",myHandler);

        SharedPreferences miPerferencia = getSharedPreferences("miConfig", Context.MODE_PRIVATE);
        ModeloLog_in modeloLog_in = new ModeloLog_in();
        ControladorLog_in controladorLog_in = new ControladorLog_in(modeloLog_in,this,miPerferencia,myHiloLo_gin);
        VistaLog_in vistaLog_in = new VistaLog_in(modeloLog_in, controladorLog_in,this);
        controladorLog_in.setControladorVista(vistaLog_in);
        controladorLog_in.chequearRecordarme(miPerferencia);
    }

    @Override
    public boolean handleMessage(Message message) {
        String resultado;

        switch (message.arg1){
            case 1:
                resultado= (String) message.obj;
                JsonPar jsonPar=new JsonPar();
                jsonPar.parcear(resultado);

                break;
            case 2:
                resultado=(String)message.obj;
                break;
        }

        return true;
    }
}
