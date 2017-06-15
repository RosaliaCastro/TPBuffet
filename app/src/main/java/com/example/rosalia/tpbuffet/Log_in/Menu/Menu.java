package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;


import com.example.rosalia.tpbuffet.Log_in.Pedido.Pedido;
import com.example.rosalia.tpbuffet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 01/05/2017.
 */
public class Menu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu_layout){
        getMenuInflater().inflate(R.menu.menu_layout,menu_layout);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuPedido) {
            Log.d("Menu", "menuPedido");
            Intent miPedido = new Intent(this,Pedido.class);
            this.startActivity(miPedido);
            //me envia a la layaout pedido
            return true;
        } else if (id == R.id.menuSalir) {
            Log.d("Menu", "menuSalir");
            finishAffinity();
            //cierra la sesion
            return true;
        }
        return onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ModeloMenu modeloMenu1 = new ModeloMenu();
        ControladorMenu controladorMenu = new ControladorMenu(modeloMenu1, this);
        VistaMenu vistaMenu = new VistaMenu(modeloMenu1, controladorMenu, this);
        controladorMenu.setVistaMenu(vistaMenu);

        List<ModeloMenu> lista = new ArrayList<ModeloMenu>();
        lista.add(new ModeloMenu("porcion de pizza", 15.50));
        lista.add(new ModeloMenu("porcion de tarta", 15.50));
        lista.add(new ModeloMenu("Sandwith de miga", 15.50));
        lista.add(new ModeloMenu("Porcion de tortilla", 15.50));
        lista.add(new ModeloMenu("porcion de torta", 15.50));
        lista.add(new ModeloMenu("Sandwith de milanesa", 15.50));
        lista.add(new ModeloMenu("Tostado", 15.50));
        lista.add(new ModeloMenu("Medialuna", 15.50));
        modeloMenu1.setListaMenu(lista);

        RecyclerView list = (RecyclerView)findViewById(R.id.list);
        controladorMenu.cargarRecycler(list, lista);

    }

}
