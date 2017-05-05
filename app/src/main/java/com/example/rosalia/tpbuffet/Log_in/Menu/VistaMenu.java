package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 01/05/2017.
 */
public class VistaMenu {
    ModeloMenu modeloMenu;
    Button btnEnviar;
    EditText txtImporte;
    EditText txtElementos;

    public VistaMenu(ModeloMenu modeloMenu, ControladorMenu controladorMenu, Activity myActivuty){
        this.modeloMenu=modeloMenu;
        txtElementos=(EditText)myActivuty.findViewById(R.id.txtElemt);
        txtImporte=(EditText)myActivuty.findViewById(R.id.txtImporte);
        btnEnviar=(Button)myActivuty.findViewById(R.id.btnEnviarP);
        btnEnviar.setOnClickListener(controladorMenu);
    }
}
