package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rosalia.tpbuffet.R;

public class Log_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        ModeloLog_in modeloLog_in = new ModeloLog_in();
        ControladorLog_in controladorLog_in = new ControladorLog_in(modeloLog_in,this);
        VistaLog_in vistaLog_in = new VistaLog_in(modeloLog_in, controladorLog_in,this);
        controladorLog_in.setControladorVista(vistaLog_in);

    }
}
