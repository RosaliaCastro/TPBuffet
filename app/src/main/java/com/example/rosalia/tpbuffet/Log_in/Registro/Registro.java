package com.example.rosalia.tpbuffet.Log_in.Registro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 30/04/2017.
 */
public class Registro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        ModeloRegistro modeloRegistro = new ModeloRegistro();
        ControladorRegistro controladorRegistro = new ControladorRegistro(modeloRegistro,this);
        VistaRegistro vistaRegistro = new VistaRegistro(modeloRegistro, controladorRegistro,this);
        controladorRegistro.setControladorVista(vistaRegistro);

    }
}
