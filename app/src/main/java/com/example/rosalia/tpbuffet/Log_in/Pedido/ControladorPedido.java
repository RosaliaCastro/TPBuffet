package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.example.rosalia.tpbuffet.Log_in.Log_in.MiDialogo;
import com.example.rosalia.tpbuffet.Log_in.Menu.Menu;
import com.example.rosalia.tpbuffet.Log_in.Menu.MyOnItemClick;
import com.example.rosalia.tpbuffet.R;

import java.util.List;

/**
 * Created by Jona on 06/05/2017.
 */
public class ControladorPedido implements View.OnClickListener, MyOnItemClick {
    ModeloPedido modeloPedido;
    Activity myActivity;
    VistaPedido vistaPedido;
    List<ModeloPedido> listaPedido;
    Double importe=00.0;
    int contador=0;
    RecyclerView list2;

    public ControladorPedido(){}

    public ControladorPedido(ModeloPedido modeloPedido, Activity myActivity){
        this.modeloPedido=modeloPedido;
        this.myActivity=myActivity;
    }

    public void setVistaPedido(VistaPedido vistaPedido){
        this.vistaPedido=vistaPedido;

    }

    public void cargarRecycler(RecyclerView list2, List<ModeloPedido> listaPedido) {
        this.list2=list2;
        this.listaPedido=listaPedido;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(myActivity);
        list2.setLayoutManager(linearLayoutManager);
        MyAdapterPedido myAdapter = new MyAdapterPedido(listaPedido, vistaPedido.controladorPedido);
        list2.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }
    public void cargar(){
        Double precio;
        listaPedido=modeloPedido.getListaPedido();
        contador=listaPedido.size()+1;
        for (int i=0; i<listaPedido.size();i++){
            precio=listaPedido.get(i).getPrecioPedido();
            importe=importe+precio;
        }
        modeloPedido.setImportePedido(importe);
        modeloPedido.setElementos(contador);
        vistaPedido.mostrar();
    }
    public void cargarVista(Double precio){
        importe = importe - precio;
        contador=listaPedido.size()+1;
        contador--;
        modeloPedido.setImportePedido(importe);
        modeloPedido.setElementos(contador);
        vistaPedido.mostrar();

    }


    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btnEnviarPedido){
           mostrarMensaje();
        }
    }

    @Override
    public void onItemClick(int position) {
        Double precio;
        listaPedido=modeloPedido.getListaPedido();
        precio=listaPedido.get(position).getPrecioPedido();
        listaPedido.remove(position);
        cargarVista(precio);

    }
    public void finalizar(){
        this.listaPedido=modeloPedido.getListaPedido();
        for (int i=0; i<listaPedido.size(); i++){
            listaPedido.remove(i);
        }

        Intent volver = new Intent(myActivity, Menu.class);
        myActivity.startActivity(volver);
    }
    public void mostrarMensaje(){
        Dialogo dialogo=new Dialogo();
        dialogo.controladorPedido=vistaPedido.controladorPedido;
        dialogo.show(myActivity.getFragmentManager(), "mensajeFinal");
        dialogo.setMensaje(myActivity.getResources().getString(R.string.MensajeFinal));
    }
}
