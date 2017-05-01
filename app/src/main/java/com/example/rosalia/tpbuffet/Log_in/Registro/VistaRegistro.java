package com.example.rosalia.tpbuffet.Log_in.Registro;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 30/04/2017.
 */
public class VistaRegistro {
    ModeloRegistro modeloRegistro;
    EditText nombre;
    EditText apellido;
    EditText dni;
    EditText mail;
    EditText clave;
    EditText reingrese;
    Button registrarme;

    public VistaRegistro(ModeloRegistro modeloRegistro, ControladorRegistro controladorRegistro, Activity myActivity){
        this.modeloRegistro= modeloRegistro;
        nombre = (EditText)myActivity.findViewById(R.id.txtNombre);
        apellido= (EditText)myActivity.findViewById(R.id.txtApellido);
        dni= (EditText)myActivity.findViewById(R.id.txtDni);
        mail=(EditText)myActivity.findViewById(R.id.txtMail2);
        clave=(EditText)myActivity.findViewById(R.id.txtClave2);
        reingrese=(EditText)myActivity.findViewById(R.id.txtReingrese);
        registrarme=(Button)myActivity.findViewById(R.id.btnRegistrarme2);
        registrarme.setOnClickListener(controladorRegistro);
    }

    public void limpiar(){
        nombre.setText("");
        apellido.setText("");
        dni.setText("");
        mail.setText("");
        clave.setText("");
        reingrese.setText("");
    }
}
