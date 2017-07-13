package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.rosalia.tpbuffet.Log_in.Log_in.MiDialogo;
import com.example.rosalia.tpbuffet.Log_in.Log_in.ModeloLog_in;
import com.example.rosalia.tpbuffet.Log_in.MyHiloLo_gin;
import com.example.rosalia.tpbuffet.Log_in.Pedido.ModeloPedido;
import com.example.rosalia.tpbuffet.Log_in.Pedido.Pedido;

import com.example.rosalia.tpbuffet.Log_in.Servicios;
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
    Servicios rutaMenu = new Servicios();
    private  final static int opcion=3;
    Handler myHandler = new Handler(this);
    ModeloMenu modeloMenu;
    Activity myActivity;
    VistaMenu vistaMenu;
    List<ModeloMenu>ListaMenu;
    MyAdapter myAdapter;
    List<ModeloPedido>ListaPedido = new ArrayList<>();
    Double importe=0.00;
    int contador=0;
    RecyclerView list;
    ModeloLog_in modeloLog_in = new ModeloLog_in();
    MiDialogo dialogo = new MiDialogo();


    public ControladorMenu(ModeloMenu modeloMenu, Activity myActivity){
        this.modeloMenu= modeloMenu;
        this.myActivity= myActivity;
    }
    public void setVistaMenu(VistaMenu vistaMenu){
        this.vistaMenu=vistaMenu;
    }

    public void cargarRecycler(RecyclerView list){
        this.list=list;
        List<ModeloMenu>lista=new ArrayList<>();
        lista.add(new ModeloMenu("","",0.00,""));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(myActivity);
        list.setLayoutManager(linearLayoutManager);

         myAdapter= new MyAdapter(lista,vistaMenu.controladorMenu);
        list.setAdapter(myAdapter);
        MyHiloLo_gin myHiloLo_gin= new MyHiloLo_gin(rutaMenu.getRutaMenu(), myHandler, opcion);
        Thread hilo= new Thread(myHiloLo_gin);
        hilo.start();
    }
    public void cargarAdapter(List<ModeloMenu>Productos){
        myAdapter.setLista(Productos);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnEnviarP){
            //List<Uri.Builder> miPedido= new ArrayList<>();
            if(ListaPedido.size()>0){
                Uri.Builder datos = new Uri.Builder();
                Uri.Builder pedido = new Uri.Builder();
                for (int i= 0; i<ListaPedido.size(); i++){
                    pedido.appendQueryParameter("tipo",ListaPedido.get(i).getTipo());
                    pedido.appendQueryParameter("nombre", ListaPedido.get(i).getDescripcionPedido());
                    pedido.appendQueryParameter("precio", ListaPedido.get(i).getPrecioPedido().toString());
                    pedido.appendQueryParameter("imagen", ListaPedido.get(i).getUrlImagen());
                }
                datos.appendQueryParameter("usuario", "a@a.com");
                datos.appendQueryParameter("pedido", String.valueOf(pedido));
                MyHiloLo_gin hilo2=new MyHiloLo_gin(rutaMenu.getRutaPedido(),myHandler,datos,2);
                Thread miHilo = new Thread(hilo2);
                miHilo.start();
            }else{
                dialogo.show(myActivity.getFragmentManager(),"alerta6");
                dialogo.setMensaje(myActivity.getResources().getString(R.string.Mensaje6));
            }
        }

    }
    public void enviarPedido(){
        if(modeloMenu.getMensaje()=="Se inserto correctamente"){
            dialogo.show(myActivity.getFragmentManager(),"alerta");
            dialogo.setMensaje(modeloMenu.getMensaje());
            Intent enviar= new Intent(myActivity,Pedido.class);
            myActivity.startActivity(enviar);
        }else{
            dialogo.show(myActivity.getFragmentManager(),"alerta2");
            dialogo.setMensaje(myActivity.getResources().getString(R.string.Mensaje7));
        }
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
        String txtTipo;
        String txtDescripcion;
        Double txtPrecio;
        String txtUrlImagen;
            txtTipo=myAdapter.getLista().get(position).getTipo();
            txtDescripcion= myAdapter.getLista().get(position).getNombre();
            txtPrecio = myAdapter.getLista().get(position).getPrecio();
            txtUrlImagen=myAdapter.getLista().get(position).getUrlImagen();

            ListaPedido.add(new ModeloPedido(txtTipo,txtDescripcion,txtPrecio,txtUrlImagen));
            cargarVista(txtPrecio);
    }
    public void parcearLista(String mensaje){
        List<ModeloMenu> ListProductos = new ArrayList<>();
        try {

            JSONArray productos= new JSONArray(mensaje);
            for (int i =0; i<productos.length();i++){
                JSONObject producto = productos.getJSONObject(i);
                modeloMenu.setTipo(producto.getString("tipoMenu"));
                modeloMenu.setNombre(producto.getString("nombre"));
                modeloMenu.setPrecio(producto.getDouble("precio"));
                modeloMenu.setUrlImagen(producto.getString("imagen"));
                ListProductos.add(modeloMenu);
            }
            cargarAdapter(ListProductos);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void parcear(String str) throws JSONException {
        JSONObject jsonObject = new JSONObject(str);
        try{
            String mensaje = jsonObject.getString("mensaje");
            modeloMenu.setMensaje(mensaje);
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
        //recibo la Lista por GET
        String mensaje= null;
        if (message.arg1==1){
           mensaje= String.valueOf(message.obj);
           parcearLista(mensaje);
        }else if(message.arg1==2){
            mensaje=String.valueOf(message.obj);

        }

        return false;
    }
}
