package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.support.design.widget.FloatingActionButton;
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
    TextView txtImporte;
    TextView txtElementos;
    ControladorMenu controladorMenu;
    //FloatingActionButton fbAgregar;

    public VistaMenu(ModeloMenu modeloMenu, ControladorMenu controladorMenu, Activity myActivuty){
        this.modeloMenu=modeloMenu;
        this.controladorMenu=controladorMenu;
        txtElementos=(TextView) myActivuty.findViewById(R.id.txtElemt);
        txtImporte=(TextView)myActivuty.findViewById(R.id.txtValor);
        btnEnviar=(Button)myActivuty.findViewById(R.id.btnEnviarP);
        btnEnviar.setOnClickListener(controladorMenu);
        //fbAgregar=(FloatingActionButton) myActivuty.findViewById(R.id.fbAgregar);
       // fbAgregar.setOnClickListener(controladorMenu);
    }
    public void mostrar (){

        txtImporte.setText(String.valueOf(modeloMenu.getImporte()));
        txtElementos.setText(String.valueOf(modeloMenu.getElementos()));

    }
}
