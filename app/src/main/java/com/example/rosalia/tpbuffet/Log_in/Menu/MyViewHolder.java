package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.app.Dialog;
import android.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rosalia.tpbuffet.Log_in.Log_in.ControladorLog_in;
import com.example.rosalia.tpbuffet.Log_in.Log_in.MiDialogo;
import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 02/05/2017.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView txtDescripcion;
    TextView txtPrecio;
    ImageView imagen;
    private MyOnItemClick listener;
    private int position;

    public MyViewHolder(View itemView, MyOnItemClick listener) {
        super(itemView);
        txtDescripcion=(TextView)itemView.findViewById(R.id.txtDescripcion);
        txtPrecio=(TextView)itemView.findViewById(R.id.txtPrecio);
        imagen=(ImageView)itemView.findViewById(R.id.imagen);
        itemView.setOnClickListener(this);
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {

        if(view.getId()!= R.id.fbAgregar){

    }
        listener.onItemClick(position);

    }
    public void setPosition(int position){
        this.position=position;
    }
}
