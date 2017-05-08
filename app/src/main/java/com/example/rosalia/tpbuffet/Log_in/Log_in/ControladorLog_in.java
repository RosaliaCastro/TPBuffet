package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.view.View;
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
    List<ModeloLog_in> ListaUsuarios;

    public ControladorLog_in(){}
    public ControladorLog_in(ModeloLog_in modeloLog_in, Activity myActivity, List<ModeloLog_in> listaUsuarios) {
        this.modeloLog_in = modeloLog_in;
        this.myActivity = myActivity;
        this.ListaUsuarios = listaUsuarios;
    }

    public void setControladorVista(VistaLog_in vistaLog_in) {
        this.vistaLog_in = vistaLog_in;
    }

    public boolean validarMail(String mail) {
        boolean res = false;
        int cant = mail.length();
        for (int i = 0; i < cant; i++) {
            Character letra = mail.charAt(i);
            if (letra == '@') {
                res = true;
            }
        }
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

    public boolean validarUsuario(ModeloLog_in usuario) {
        boolean res = false;

        for (int i = 0; i < ListaUsuarios.size(); i++) {
            if ((usuario.getMail().equals(ListaUsuarios.get(i).getMail())) && (usuario.getClave().equals(ListaUsuarios.get(i).getClave()))) {
                res = true;
            }
        }
        return res;
    }

    public void agregarNuevo(){
        String dato1 = myActivity.getIntent().getExtras().getString("mail");
        String dato2 = myActivity.getIntent().getExtras().getString("clave");
        ModeloLog_in nuevo = new ModeloLog_in(dato1,dato2);
        ListaUsuarios.add(nuevo);
    }


    private void startActivity(Intent intent) {
        myActivity.startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnIngresar) {
            MiDialogo dialogo1 = new MiDialogo();
            MiDialogo dialogo2 = new MiDialogo();
            MiDialogo dialogo3 = new MiDialogo();

            String mail = vistaLog_in.mail.getText().toString();
            String clave = vistaLog_in.clave.getText().toString();

            if (validarCampo(mail, clave)) {
                if (validarMail(mail)) {
                    ModeloLog_in usuario = new ModeloLog_in(mail, clave);
                    if (validarUsuario(usuario)) {
                        Intent intentMenu = new Intent(myActivity, Menu.class);
                        myActivity.startActivity(intentMenu);
                    } else{
                      dialogo3.show(myActivity.getFragmentManager(),"Alerta3");
                      dialogo3.setMensaje("El usuario no existe.");}
                } else{
                   dialogo2.show(myActivity.getFragmentManager(), "Alerta2");
                   dialogo2.setMensaje("Ingrese un Mail correcto.");}
            } else{
               dialogo1.show(myActivity.getFragmentManager(), "Alerta1");
               dialogo1.setMensaje("Complete los campos.");}

            vistaLog_in.limpiar();

        } else if (view.getId() == R.id.btnRegistrarme) {
            Intent intent2 = new Intent(myActivity, Registro.class);
            myActivity.startActivity(intent2);
        }
    }


}






