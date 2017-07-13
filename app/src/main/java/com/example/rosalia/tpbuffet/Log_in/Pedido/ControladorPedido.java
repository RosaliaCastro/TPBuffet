package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.example.rosalia.tpbuffet.Log_in.Log_in.MiDialogo;
import com.example.rosalia.tpbuffet.Log_in.Menu.Menu;
import com.example.rosalia.tpbuffet.Log_in.Menu.MyOnItemClick;
import com.example.rosalia.tpbuffet.Log_in.MyHiloLo_gin;
import com.example.rosalia.tpbuffet.Log_in.Servicios;
import com.example.rosalia.tpbuffet.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 06/05/2017.
 */
public class ControladorPedido implements View.OnClickListener, MyOnItemClick, Handler.Callback {
    Servicios rutaPedido = new Servicios();
    Handler myHandler=new Handler(this);
    ModeloPedido modeloPedido;
    Activity myActivity;
    VistaPedido vistaPedido;
    List<ModeloPedido> listaPedido;
    Double importe=00.0;
    int contador=0;
    RecyclerView list2;
    MyAdapterPedido myAdapterPedido;
    Dialogo dialogo=new Dialogo();

    public ControladorPedido(){}

    public ControladorPedido(ModeloPedido modeloPedido, Activity myActivity){
        this.modeloPedido=modeloPedido;
        this.myActivity=myActivity;
    }

    public void setVistaPedido(VistaPedido vistaPedido){
        this.vistaPedido=vistaPedido;
    }

    public void cargarRecycler(RecyclerView list2) {
        this.list2=list2;
        List<ModeloPedido>lista=new ArrayList<>();
        lista.add(new ModeloPedido("","", 0.00,""));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(myActivity);
        list2.setLayoutManager(linearLayoutManager);
        myAdapterPedido= new MyAdapterPedido(lista,vistaPedido.controladorPedido);
        list2.setAdapter(myAdapterPedido);
        MyHiloLo_gin myHiloLo_gin= new MyHiloLo_gin(rutaPedido.getRutaTraerPedido(), myHandler, 1);
        Thread hilo= new Thread(myHiloLo_gin);
        hilo.start();
    }
    public void cargarAdapter(List<ModeloPedido>Pedido){
        myAdapterPedido.setListaPedido(Pedido);
        myAdapterPedido.notifyDataSetChanged();
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
            if(listaPedido.size()>0){
                Uri.Builder datos = new Uri.Builder();
                Uri.Builder pedido = new Uri.Builder();
                for (int i= 0; i<listaPedido.size(); i++){
                    pedido.appendQueryParameter("tipo",listaPedido.get(i).getTipo());
                    pedido.appendQueryParameter("nombre", listaPedido.get(i).getDescripcionPedido());
                    pedido.appendQueryParameter("precio", listaPedido.get(i).getPrecioPedido().toString());
                    pedido.appendQueryParameter("imagen", listaPedido.get(i).getUrlImagen());
                }
                datos.appendQueryParameter("usuario", "");
                datos.appendQueryParameter("pedido", String.valueOf(pedido));
                MyHiloLo_gin hilo2=new MyHiloLo_gin(rutaPedido.getRutaPedido(),myHandler,datos,2);
                Thread miHilo = new Thread(hilo2);
                miHilo.start();
            }else{
                dialogo.show(myActivity.getFragmentManager(),"alerta6");
                dialogo.setMensaje(myActivity.getResources().getString(R.string.Mensaje6));
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        Double precio;
        precio=myAdapterPedido.getListaPedido().get(position).getPrecioPedido();
        myAdapterPedido.getListaPedido().remove(position);
        cargarVista(precio);
        myAdapterPedido.notifyDataSetChanged();
    }

    public void finalizar(){
        for (int i=0; i<myAdapterPedido.getListaPedido().size(); i++){
            listaPedido.remove(i);
        }
        Intent volver = new Intent(myActivity, Menu.class);
        myActivity.startActivity(volver);
    }

    public void enviarPedido(){
        if(modeloPedido.getMensaje()=="Se inserto correctamente"){
            dialogo.show(myActivity.getFragmentManager(),"alerta");
            dialogo.setMensaje(modeloPedido.getMensaje());

            Intent volver= new Intent(myActivity,Menu.class);
            myActivity.startActivity(volver);
        }else{
            dialogo.show(myActivity.getFragmentManager(),"alerta2");
            dialogo.setMensaje(myActivity.getResources().getString(R.string.Mensaje7));
        }
    }

    public void mostrarMensaje(){
        dialogo.controladorPedido=vistaPedido.controladorPedido;
        dialogo.show(myActivity.getFragmentManager(), "mensajeFinal");
        dialogo.setMensaje(myActivity.getResources().getString(R.string.MensajeFinal));
    }
    public void parcear(String str) throws JSONException {
        JSONObject jsonObject = new JSONObject(str);
        try{
            String mensaje = jsonObject.getString("mensaje");
            modeloPedido.setMensaje(mensaje);
            Log.d("Mensaje","parceado");
            enviarPedido();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        String mensaje= null;
        if (message.arg1==2){
            mensaje= String.valueOf(message.obj);
            try {
                parcear(mensaje);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else
            dialogo.show(myActivity.getFragmentManager(),"alerta");
            dialogo.getMensaje(myActivity.getResources().getString(R.string.Mensaje7));

        return false;
    }
}
