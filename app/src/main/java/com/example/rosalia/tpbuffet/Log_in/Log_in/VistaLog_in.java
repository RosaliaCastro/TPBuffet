package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.rosalia.tpbuffet.Log_in.Log_in.Log_in;
import com.example.rosalia.tpbuffet.Log_in.Log_in.ModeloLog_in;
import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 30/04/2017.
 */
public class VistaLog_in {
    private ModeloLog_in modeloLog_in;
    EditText mail;
    EditText clave;
    Button ingresar;
    Button registrarme;
    CheckBox recordarme;

    public VistaLog_in (ModeloLog_in modeloLog_in,ControladorLog_in controladorLog_in, Activity myActivity){
        this.modeloLog_in=modeloLog_in;
        mail= (EditText)myActivity.findViewById(R.id.txtMail);
        clave= (EditText)myActivity.findViewById(R.id.txtClave);
        ingresar=(Button)myActivity.findViewById(R.id.btnIngresar);
        registrarme=(Button)myActivity.findViewById(R.id.btnRegistrarme);
        recordarme=(CheckBox)myActivity.findViewById(R.id.cbxRecordarme);
        ingresar.setOnClickListener(controladorLog_in);
        registrarme.setOnClickListener(controladorLog_in);
    }

   // public String traerMail(){
    //return mail.getText().toString();
//}
  //  public String traerClavel(){
    //    return clave.getText().toString();
    //}

    public void limpiar(){
        mail.setText("");
        clave.setText("");
    }

}
