package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rosalia.tpbuffet.Log_in.MyHiloLo_gin;
import com.example.rosalia.tpbuffet.Log_in.Servicios;
import com.example.rosalia.tpbuffet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 02/05/2017.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements Handler.Callback {
    private List<ModeloMenu> lista;
    private MyOnItemClick listener;
    Handler myHandler = new Handler(this);
    int opcion=1;

    public List<ModeloMenu> getLista() {
        return lista;
    }

    public void setLista(List<ModeloMenu> lista){
        this.lista=lista;
    }


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
        holder.txtDescripcion.setText(menu.getNombre());
        holder.txtPrecio.setText(menu.getPrecio().toString());
        holder.imagen.setImageBitmap(menu.getImagen());
        traerImagen(lista.get(position).getUrlImagen());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    @Override
    public boolean handleMessage(Message message) {
        byte [] bytes= (byte[]) message.obj;
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        lista.get(message.arg1).setImagen(bitmap);
        this.notifyDataSetChanged();
        return false;
    }
    public void traerImagen(String url){
        MyHiloLo_gin miHilo= new MyHiloLo_gin(url,myHandler,opcion);
        Thread hilo = new Thread(miHilo);
        hilo.start();
    }

}
