package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 14/06/2017.
 */
public class Dialogo extends DialogFragment {
    private String mensaje;
    TextView importe;
    TextView cantidad;
    ControladorPedido controladorPedido;

    @Override
    public Dialog onCreateDialog(Bundle savedIntanceState ){
        LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
        View viewAlert = layoutInflater.inflate(R.layout.layout_dialogo, null);
        importe=(TextView)viewAlert.findViewById(R.id.txtImporteTotal);
        cantidad=(TextView)viewAlert.findViewById(R.id.txtCantElem);
        importe.setText(String.valueOf(controladorPedido.importe));
        cantidad.setText(String.valueOf(controladorPedido.contador));
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Atencion!!!");
        builder.setMessage(mensaje);
        builder.setView(viewAlert);
        Alerta uno = new Alerta();
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                controladorPedido.finalizar();

            }
        });


        AlertDialog ad = builder.create();
        return ad;
    }


    public String getMensaje(String string) {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
