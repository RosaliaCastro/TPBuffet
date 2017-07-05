package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rosalia.tpbuffet.Log_in.Log_in.MiDialogo;
import com.example.rosalia.tpbuffet.Log_in.Log_in.ModeloLog_in;
import com.example.rosalia.tpbuffet.Log_in.MyHiloLo_gin;
import com.example.rosalia.tpbuffet.Log_in.Pedido.ModeloPedido;
import com.example.rosalia.tpbuffet.Log_in.Pedido.Pedido;

import com.example.rosalia.tpbuffet.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 01/05/2017.
 */
public class ControladorMenu implements View.OnClickListener, MyOnItemClick, Handler.Callback {
    private String servicioLista="http://192.168.1.40:3000/usuarios/productos";
    private int opcion=1;
    Handler myHandler = new Handler(this);
    ModeloMenu modeloMenu;
    Activity myActivity;
    VistaMenu vistaMenu;
    List<ModeloMenu>ListaMenu;

    List<ModeloPedido>ListaPedido = new ArrayList<>();
    Double importe=0.00;
    int contador=0;
    RecyclerView list;


    public ControladorMenu(ModeloMenu modeloMenu, Activity myActivity){
        this.modeloMenu= modeloMenu;
        this.myActivity= myActivity;
    }
    public void setVistaMenu(VistaMenu vistaMenu){
        this.vistaMenu=vistaMenu;
    }

    public void cargarRecycler(RecyclerView list){
        this.list=list;
        MyHiloLo_gin myHiloLo_gin= new MyHiloLo_gin(servicioLista, myHandler, opcion);
        Thread hilo= new Thread(myHiloLo_gin);
        hilo.start();
    }
    public void cargarAdapter(List<ModeloMenu>Productos){
        this.ListaMenu=Productos;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(myActivity);
        list.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(ListaMenu,vistaMenu.controladorMenu,myActivity);
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
            txtDescripcion= ListaMenu.get(position).getNombre();
            txtPrecio = ListaMenu.get(position).getPrecio();
            ListaPedido.add(new ModeloPedido(txtDescripcion,txtPrecio));
            cargarVista(txtPrecio);
    }
    public void parcear(String mensaje){
        List<ModeloMenu> ListProductos = null;
        try {
            JSONObject jsonObject= new JSONObject();
            JSONArray productos= jsonObject.getJSONArray(String.valueOf(mensaje));
            for (int i =0; i<productos.length();i++){
                JSONObject producto = productos.getJSONObject(i);
                modeloMenu.setTipo(producto.getString("tipoMenu"));
                modeloMenu.setNombre(producto.getString("nombre"));
                modeloMenu.setPrecio(producto.getDouble("precio"));
                modeloMenu.setImagen(producto.getString("imagen"));

                ListProductos.add(modeloMenu);
            }
            cargarAdapter(ListProductos);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean handleMessage(Message message) {
        //recibo la Lista por GET
        String mensaje= null;
        if (message.arg1==1){
            byte[] byts = (byte[])message.obj;
            try {
                mensaje= new String (byts, "UTF-8");
                parcear(mensaje);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
