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
<<<<<<< HEAD
=======
import android.support.v7.util.ListUpdateCallback;
>>>>>>> 19076b02545f5379a4dda5f092b21849957261c0
import android.util.Log;
import android.widget.TextView;

import com.example.rosalia.tpbuffet.Log_in.Menu.VistaMenu;
import com.example.rosalia.tpbuffet.Log_in.Registro.ControladorRegistro;
import com.example.rosalia.tpbuffet.R;

import java.util.ArrayList;
import java.util.List;

public class Log_in extends AppCompatActivity {

private Handler myHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        SharedPreferences miPerferencia = getSharedPreferences("miConfig", Context.MODE_PRIVATE);
        ModeloLog_in modeloLog_in = new ModeloLog_in();
        ControladorLog_in controladorLog_in = new ControladorLog_in(modeloLog_in,this,miPerferencia);
        VistaLog_in vistaLog_in = new VistaLog_in(modeloLog_in, controladorLog_in,this);
        controladorLog_in.setControladorVista(vistaLog_in);
        controladorLog_in.chequearRecordarme(miPerferencia);
    }
}
