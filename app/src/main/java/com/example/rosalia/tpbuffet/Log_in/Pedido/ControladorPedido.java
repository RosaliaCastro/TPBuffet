package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.app.Activity;
import android.view.View;

/**
 * Created by Jona on 06/05/2017.
 */
public class ControladorPedido implements View.OnClickListener {
    ModeloPedido modeloPedido;
    Activity myActivity;
    VistaPedido vistaPedido;

    public ControladorPedido(ModeloPedido modeloPedido, Activity myActivity){
        this.modeloPedido=modeloPedido;
        this.myActivity=myActivity;
    }

    public void setVistaPedido(VistaPedido vistaPedido){
        this.vistaPedido=vistaPedido;
    }

    @Override
    public void onClick(View view) {

    }
}
