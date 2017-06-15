package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.ListUpdateCallback;

import com.example.rosalia.tpbuffet.Log_in.Menu.VistaMenu;
import com.example.rosalia.tpbuffet.Log_in.Registro.ControladorRegistro;
import com.example.rosalia.tpbuffet.R;

import java.util.ArrayList;
import java.util.List;

public class Log_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        List<ModeloLog_in>ListaUsuarios = new ArrayList<>();
        ListaUsuarios.add(new ModeloLog_in("pepe@gmail","2222"));
        ListaUsuarios.add(new ModeloLog_in("juan@gmail.com","1234"));
        SharedPreferences miPerferencia = getSharedPreferences("miConfig", Context.MODE_PRIVATE);
        ModeloLog_in modeloLog_in = new ModeloLog_in();
        modeloLog_in.setListaUsuarios(ListaUsuarios);
        ControladorLog_in controladorLog_in = new ControladorLog_in(modeloLog_in,this,ListaUsuarios,miPerferencia);
        VistaLog_in vistaLog_in = new VistaLog_in(modeloLog_in, controladorLog_in,this);
        controladorLog_in.setControladorVista(vistaLog_in);
        controladorLog_in.chequearRecordarme(miPerferencia);
    }


}
