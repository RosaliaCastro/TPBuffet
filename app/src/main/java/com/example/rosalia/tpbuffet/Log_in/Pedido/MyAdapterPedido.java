package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rosalia.tpbuffet.Log_in.Menu.ModeloMenu;
import com.example.rosalia.tpbuffet.Log_in.Menu.MyAdapter;
import com.example.rosalia.tpbuffet.Log_in.Menu.MyViewHolder;
import com.example.rosalia.tpbuffet.Log_in.MyOnItemClick;
import com.example.rosalia.tpbuffet.R;

import java.util.List;

/**
 * Created by Jona on 06/05/2017.
 */
public class MyAdapterPedido extends RecyclerView.Adapter<MyViewHolderPedido> {
    private List<ModeloPedido> listaPedido;
    private MyOnItemClick listener;

    public MyAdapterPedido(List<ModeloPedido>listaPedido,MyOnItemClick listener){
        this.listaPedido =listaPedido;
        this.listener=listener;
    }
    @Override
    public MyViewHolderPedido onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layaout_pedido,parent,false);
        MyViewHolderPedido myViewHolderPedido = new MyViewHolderPedido(v, listener);
        return myViewHolderPedido;
    }

    @Override
    public void onBindViewHolder(MyViewHolderPedido holder, int position) {
        ModeloPedido pedido=listaPedido.get(position);
        holder.txtDescripcionPedido.setText(pedido.getDescripcionPedido());
        holder.txtPrecioPedido.setText(pedido.getPrecioPedido().toString());
        holder.setPosition(position);

    }

    @Override
    public int getItemCount() {
        return listaPedido.size();
    }
}
