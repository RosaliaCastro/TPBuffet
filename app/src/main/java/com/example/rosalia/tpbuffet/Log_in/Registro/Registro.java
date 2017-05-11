package com.example.rosalia.tpbuffet.Log_in.Registro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rosalia.tpbuffet.Log_in.Log_in.ModeloLog_in;
import com.example.rosalia.tpbuffet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 30/04/2017.
 */
public class Registro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        List<ModeloRegistro> ListaRegistrados = new ArrayList<>();
        ListaRegistrados.add(new ModeloRegistro("pepe","diaz", "11111111","pepe@gmail","2222","2222"));
        ListaRegistrados.add(new ModeloRegistro("juan","perez","22222222","juan@gmail.com","1234","1234"));
        ListaRegistrados.add(new ModeloRegistro("rosa","sosa","33333333","rosa@gmail.com","5678","5678"));
        ListaRegistrados.add(new ModeloRegistro("soledad","ruiz","44444444","sole@gmail.com","5555","5555"));

        ModeloRegistro modeloRegistro = new ModeloRegistro();
        modeloRegistro.setListaRegistrados(ListaRegistrados);
        ControladorRegistro controladorRegistro = new ControladorRegistro(modeloRegistro,this);
        VistaRegistro vistaRegistro = new VistaRegistro(modeloRegistro, controladorRegistro,this);
        controladorRegistro.setControladorVista(vistaRegistro);

    }
}
