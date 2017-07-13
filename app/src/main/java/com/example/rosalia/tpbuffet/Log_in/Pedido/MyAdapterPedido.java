package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rosalia.tpbuffet.Log_in.Menu.MyOnItemClick;
import com.example.rosalia.tpbuffet.Log_in.MyHiloLo_gin;
import com.example.rosalia.tpbuffet.R;

import java.util.List;

/**
 * Created by Jona on 06/05/2017.
 */
public class MyAdapterPedido extends RecyclerView.Adapter<MyViewHolderPedido> implements Handler.Callback {
    Handler myHandler= new Handler(this);
    private List<ModeloPedido> listaPedido;
    private MyOnItemClick listener;
    private int opcion=1;

    public MyAdapterPedido(List<ModeloPedido> listaPedido, MyOnItemClick listener){
        this.listaPedido =listaPedido;
        this.listener=listener;
    }
    public List<ModeloPedido> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(List<ModeloPedido> listaPedido) {
        this.listaPedido = listaPedido;
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
        for (int i =0; i<listaPedido.size();i++) {
            if(pedido.getImagen()== null){
                String url = listaPedido.get(position).getUrlImagen();
                MyHiloLo_gin miHilo= new MyHiloLo_gin(url,myHandler,opcion);
                Thread hilo = new Thread(miHilo);
                hilo.start();
            }else{
                holder.imagen.setImageBitmap(pedido.getImagen());
            }
        }
        holder.setPosition(position);

    }

    @Override
    public int getItemCount() {
        return listaPedido.size();
    }

    @Override
    public boolean handleMessage(Message message) {
        byte [] bytes= (byte[]) message.obj;
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        listaPedido.get(message.arg1).setImagen(bitmap);
        this.notifyDataSetChanged();
        return false;
    }
}
