package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rosalia.tpbuffet.Log_in.Log_in.MiDialogo;
import com.example.rosalia.tpbuffet.Log_in.Pedido.ModeloPedido;
import com.example.rosalia.tpbuffet.Log_in.Pedido.Pedido;

import com.example.rosalia.tpbuffet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 01/05/2017.
 */
public class ControladorMenu implements View.OnClickListener, MyOnItemClick {
    ModeloMenu modeloMenu;
    Activity myActivity;
    VistaMenu vistaMenu;
    List<ModeloMenu>ListaMenu;
    List<ModeloPedido>ListaPedido = new ArrayList<>();
    Double importe=0.00;
    int contador=0;
    RecyclerView list;

    public ControladorMenu(){}

    public ControladorMenu(ModeloMenu modeloMenu, Activity myActivity){
        this.modeloMenu= modeloMenu;
        this.myActivity= myActivity;

    }
    public void setVistaMenu(VistaMenu vistaMenu){
        this.vistaMenu=vistaMenu;
    }

    public void cargarRecycler(RecyclerView list, List<ModeloMenu> miLista){
        this.list=list;
        this.ListaMenu=miLista;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(myActivity);
        list.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(ListaMenu,vistaMenu.controladorMenu);
        list.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        MiDialogo dialogo = new MiDialogo();
        if (view.getId() == R.id.btnEnviarP){
            if(ListaPedido.size()>0){
                Intent enviar= new Intent(myActivity,Pedido.class);
                myActivity.startActivity(enviar);
            }else{
                dialogo.show(myActivity.getFragmentManager(),"slerta6");
                dialogo.setMensaje(myActivity.getResources().getString(R.string.Mensaje6));
            }
        }

    }
    public List<ModeloPedido> getLista(){
        return ListaPedido;
    }
    public void cargarVista(Double precio){
        importe = importe + precio;
        contador++;
        modeloMenu.setElementos(contador);
        modeloMenu.setImporte(importe);
        vistaMenu.mostrar();
    }

    @Override
    public void onItemClick(int position) {
        String txtDescripcion;
        Double txtPrecio;
        ListaMenu=modeloMenu.getListaMenu();
            txtDescripcion= ListaMenu.get(position).getDescripcion();
            txtPrecio = ListaMenu.get(position).getPrecio();
            ListaPedido.add(new ModeloPedido(txtDescripcion,txtPrecio));
            cargarVista(txtPrecio);
    }
}
