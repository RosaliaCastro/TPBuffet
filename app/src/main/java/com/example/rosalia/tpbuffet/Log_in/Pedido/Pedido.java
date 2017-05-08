package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.rosalia.tpbuffet.R;
import com.example.rosalia.tpbuffet.Log_in.Menu.MyOnItemClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 06/05/2017.
 */
public class Pedido extends AppCompatActivity implements MyOnItemClick {

    @Override
    public boolean onCreateOptionsMenu(Menu menu_pedido) {
        getMenuInflater().inflate(R.menu.menu_pedido, menu_pedido);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuEnviar) {
            Log.d("Menu", "menuEnviar");
            //envia el pedido
            return true;
        } else if (id == R.id.menuLimpiar) {
            Log.d("Menu", "menuLimpiar");
            //borra todos loe elementos de la lista
            return true;
        } else if (id == R.id.menuSalirPedido) {
            Log.d("Menu", "menuSalir");
            finish();
            //cierra la sesion
            return true;
        }
        return onOptionsItemSelected(item);
    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pedido);

            ModeloPedido modeloPedido =new ModeloPedido();
            ControladorPedido controladorPedido = new ControladorPedido(modeloPedido, this);
            VistaPedido vistaPedido= new VistaPedido(modeloPedido, controladorPedido,this);
            controladorPedido.setVistaPedido(vistaPedido);

            List<ModeloPedido> listaPedido = new ArrayList<ModeloPedido>();
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
            listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));

            RecyclerView list2 = (RecyclerView) findViewById(R.id.list2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            list2.setLayoutManager(linearLayoutManager);
            MyAdapterPedido myAdapter = new MyAdapterPedido(listaPedido, this);
            list2.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();

        }

    @Override
    public void onItemClick(int position) {

    }
}
