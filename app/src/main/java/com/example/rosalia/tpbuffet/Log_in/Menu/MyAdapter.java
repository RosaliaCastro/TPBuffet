package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rosalia.tpbuffet.Log_in.MyOnItemClick;
import com.example.rosalia.tpbuffet.R;

import java.util.List;

/**
 * Created by Jona on 02/05/2017.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<ModeloMenu> lista;
    private MyOnItemClick listener;

    public MyAdapter (List<ModeloMenu> lista, MyOnItemClick listener){
            this.lista=lista;
        this.listener=listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyViewHolder myViewHolder= new MyViewHolder(v, listener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ModeloMenu menu=lista.get(position);
        holder.txtDescripcion.setText(menu.getDescripcion());
        holder.txtPrecio.setText(menu.getPrecio().toString());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
