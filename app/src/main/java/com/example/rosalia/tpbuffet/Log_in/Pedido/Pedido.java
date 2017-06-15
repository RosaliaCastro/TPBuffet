package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.rosalia.tpbuffet.R;
import com.example.rosalia.tpbuffet.Log_in.Menu.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 14/06/2017.
 */
public class Pedido extends AppCompatActivity {

    ControladorPedido controladorPedido1;

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
            controladorPedido1.mostrarMensaje();
            return true;
        } else if (id == R.id.menuLimpiar) {
            Log.d("Menu", "menuLimpiar");
            controladorPedido1.finalizar();
            return true;
        } else if (id == R.id.menuSalirPedido) {
            Log.d("Menu", "menuSalir");
            finishAffinity();
            return true;
        }
        return onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        ModeloPedido modeloPedido = new ModeloPedido();
        ControladorPedido controladorPedido = new ControladorPedido(modeloPedido, this);
        VistaPedido vistaPedido = new VistaPedido(modeloPedido, controladorPedido, this);
        controladorPedido.setVistaPedido(vistaPedido);
        controladorPedido1=controladorPedido;

        List<ModeloPedido> listaPedido = new ArrayList<ModeloPedido>();
        listaPedido.add(new ModeloPedido("porcion de pizza", 15.50));
        listaPedido.add(new ModeloPedido("porcion de tarta", 15.50));
        listaPedido.add(new ModeloPedido("Sandwith de miga", 15.50));
        listaPedido.add(new ModeloPedido("Porcion de tortilla", 15.50));
        listaPedido.add(new ModeloPedido("porcion de torta", 15.50));
        listaPedido.add(new ModeloPedido("Sandwith de milanesa", 15.50));
        modeloPedido.setListaPedido(listaPedido);

        RecyclerView list2 = (RecyclerView) findViewById(R.id.list2);
        controladorPedido.cargarRecycler(list2, listaPedido);
        controladorPedido.cargar();

    }
}
