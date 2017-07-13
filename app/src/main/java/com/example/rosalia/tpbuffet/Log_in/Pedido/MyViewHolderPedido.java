package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rosalia.tpbuffet.Log_in.Menu.MyOnItemClick;
import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 06/05/2017.
 */
public class MyViewHolderPedido extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView txtDescripcionPedido;
    TextView txtPrecioPedido;
    ImageView imagen;
    private MyOnItemClick listener;
    private int position;

    public MyViewHolderPedido(View itemView, MyOnItemClick listener) {
        super(itemView);
        txtDescripcionPedido=(TextView)itemView.findViewById(R.id.txtDescripcionPedido);
        txtPrecioPedido=(TextView)itemView.findViewById(R.id.txtPrecioPedido);
        imagen=(ImageView)itemView.findViewById(R.id.imagenPedido);
        itemView.setOnClickListener(this);
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (view.getId()!= R.id.fbEliminar){

        }
        listener.onItemClick(position);
    }
    public void setPosition(int position){
        this.position=position;
    }
}
