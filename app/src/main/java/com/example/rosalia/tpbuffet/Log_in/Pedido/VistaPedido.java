package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 06/05/2017.
 */
public class VistaPedido {
    ModeloPedido modeloPedido;
    TextView importe;
    Button enviarPedido;


    public VistaPedido(ModeloPedido modeloPedido, ControladorPedido controladorPedido, Activity myActivity){
        this.modeloPedido=modeloPedido;
        importe=(TextView)myActivity.findViewById(R.id.txtImportePedido);
        enviarPedido=(Button)myActivity.findViewById(R.id.btnIngresar);
        enviarPedido.setOnClickListener(controladorPedido);
    }
}
