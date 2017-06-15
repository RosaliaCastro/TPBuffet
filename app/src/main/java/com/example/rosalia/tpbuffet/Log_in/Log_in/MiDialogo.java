package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 06/05/2017.
 */
public class MiDialogo extends DialogFragment {
    private String mensaje;

    @Override
    public Dialog onCreateDialog(Bundle savedIntanceState ){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Alerta!!!");
        builder.setMessage(mensaje);
        ListenerAlert uno = new ListenerAlert();
        builder.setPositiveButton("Aceptar", uno);

        AlertDialog ad = builder.create();
        return ad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
