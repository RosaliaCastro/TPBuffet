package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.example.rosalia.tpbuffet.Log_in.Menu.ControladorMenu;
import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 06/05/2017.
 */
public class VistaPedido {
    ModeloPedido modeloPedido;
    ControladorPedido controladorPedido;
    TextView txtImportePedido;
    TextView txtElementoPedido;
    Button btnEnviarPedido;

    public VistaPedido(ModeloPedido modeloPedido, ControladorPedido controladorPedido, Activity myActivity){
        this.modeloPedido=modeloPedido;
        this.controladorPedido=controladorPedido;

        txtImportePedido=(TextView)myActivity.findViewById(R.id.txtImportePedido);
        txtElementoPedido=(TextView)myActivity.findViewById(R.id.txtElementoPedido);
        btnEnviarPedido=(Button)myActivity.findViewById(R.id.btnEnviarPedido);
        btnEnviarPedido.setOnClickListener(controladorPedido);


    }
    public void mostrar(){
        txtImportePedido.setText(String.valueOf(modeloPedido.getImportePedido()));
        txtElementoPedido.setText(String.valueOf(modeloPedido.getElementos()));
    }
}
