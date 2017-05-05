package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rosalia.tpbuffet.R;

/**
 * Created by Jona on 02/05/2017.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView txtDescripcion;
    TextView txtPrecio;
    private MyOnItemClick listener;
    private int position;

    public MyViewHolder(View itemView, MyOnItemClick listener) {
        super(itemView);
        txtDescripcion=(TextView)itemView.findViewById(R.id.txtDescripcion);
        txtPrecio=(TextView)itemView.findViewById(R.id.txtPrecio);
        itemView.setOnClickListener(this);
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        listener.onItemClick(position);
    }
    public void setPosition(int position){
        this.position=position;
    }
}
