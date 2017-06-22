package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;

import com.example.rosalia.tpbuffet.*;
import com.example.rosalia.tpbuffet.Log_in.Menu.Menu;
import com.example.rosalia.tpbuffet.Log_in.Registro.Registro;
import com.example.rosalia.tpbuffet.R;
import com.example.rosalia.tpbuffet.Log_in.Log_in.MiDialogo;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Jona on 30/04/2017.
 */
public class ControladorLog_in implements View.OnClickListener {
    private ModeloLog_in modeloLog_in;
    private Activity myActivity;
    private VistaLog_in vistaLog_in;
    private Integer codigo;

    SharedPreferences myPreferencia;
    MyHiloLo_gin myHiloLo_gin;

    public ControladorLog_in() {
    }

    public ControladorLog_in(ModeloLog_in modeloLog_in, Activity myActivity, SharedPreferences myPreferencia,MyHiloLo_gin hilo) {
        this.modeloLog_in = modeloLog_in;
        this.myActivity = myActivity;
        this.myPreferencia=myPreferencia;
        this.myHiloLo_gin=hilo;
    }

    public void setControladorVista(VistaLog_in vistaLog_in) {
        this.vistaLog_in = vistaLog_in;
    }

    public void chequearRecordarme(SharedPreferences myPreferencia){
    String Mail = myPreferencia.getString("Mail","");
    String Clave = myPreferencia.getString("Clave","");
    vistaLog_in.mail.setText(Mail);
    vistaLog_in.clave.setText(Clave);
    if (Mail != "" && Clave != ""){
        Intent myIntent = new Intent(myActivity, Menu.class);
        myActivity.startActivity(myIntent);

    }
    }

    public void recordarme(){
        CheckBox check = vistaLog_in.recordarme;
        if (check.isChecked()){
            String mail = vistaLog_in.mail.getText().toString();
            String clave = vistaLog_in.clave.getText().toString();
            SharedPreferences.Editor editor =myPreferencia.edit();
            editor.putString("Mail",mail);
            editor.putString("Clave",clave);
            editor.commit();
        }
    }

    private void startActivity(Intent intent) {
        myActivity.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnIngresar) {

            MiDialogo dialogo1 = new MiDialogo();
            String mail = vistaLog_in.mail.getText().toString();
            String clave = vistaLog_in.clave.getText().toString();

            if (validarCampo(mail, clave)) { //valida que no esten vacios
                if (validarMail(mail)) {
                    validarUsuario(mail, clave);
                    if (modeloLog_in.getCodigo() == 200) {
                        recordarme();
                        Intent intentMenu = new Intent(myActivity, Menu.class);
                        myActivity.startActivity(intentMenu);
                    } else { if(modeloLog_in.getCodigo() == 400 || modeloLog_in.getCodigo() ==500){
                        dialogo1.show(myActivity.getFragmentManager(), "Alerta3");
                        dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje3));
                    }
                    }
                } else {
                    dialogo1.show(myActivity.getFragmentManager(), "Alerta2");
                    dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje2));
                }
            } else {
                dialogo1.show(myActivity.getFragmentManager(), "Alerta1");
                dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje1));
            }
            vistaLog_in.limpiar();
        } else if (view.getId() == R.id.btnRegistrarme) {
            Intent intent2 = new Intent(myActivity, Registro.class);
            myActivity.startActivity(intent2);
        }

    }

    public boolean validarMail(String mail) {
        boolean res = false;
        myHiloLo_gin.opcion=1;
        Thread hiloUno = new Thread(myHiloLo_gin);
        hiloUno.start();
        hiloUno.run();


        return res;
    }

    public boolean validarCampo(String mail, String clave) {
        boolean res = true;
        int cant1 = mail.length();
        int cant2 = clave.length();
        if (cant1 == 0 && cant2 == 0 || cant1 == 0 || cant2 == 0) {
            res = false;
        }
        return res;
    }

    public void validarUsuario(String mail, String clave) {
        myHiloLo_gin.opcion=2;
        Thread hiloDos = new Thread(myHiloLo_gin);
        hiloDos.start();
    }
}







