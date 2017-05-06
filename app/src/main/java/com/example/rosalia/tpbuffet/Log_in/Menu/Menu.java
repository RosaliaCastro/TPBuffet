package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.rosalia.tpbuffet.Log_in.MyOnItemClick;
import com.example.rosalia.tpbuffet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jona on 01/05/2017.
 */
public class Menu extends ActionBarActivity implements MyOnItemClick {

    @Override
    public boolean onCreateOptionMenu(android.view.Menu menu_layout) {
        getMenuInflater().inflate(R.menu.menu_layout, menu_layout);
        return true;
    }

    @Override
    public boolean onOptionItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuPedido) {
            Log.d("Menu", "menuPedido");
            //me envia a la layaout pedido
            return true;
        } else if (id == R.id.menuSalir) {
            Log.d("Menu", "menuSalir");
            finish();
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
        lista.add(new ModeloMenu("porcion de pizza", 15.50));
        lista.add(new ModeloMenu("porcion de pizza", 15.50));
        lista.add(new ModeloMenu("porcion de pizza", 15.50));
        lista.add(new ModeloMenu("porcion de pizza", 15.50));
        lista.add(new ModeloMenu("porcion de pizza", 15.50));
        lista.add(new ModeloMenu("porcion de pizza", 15.50));
        lista.add(new ModeloMenu("porcion de pizza", 15.50));
        lista.add(new ModeloMenu("porcion de pizza", 15.50));
        lista.add(new ModeloMenu("porcion de pizza", 15.50));

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(lista, this);
        list.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

    }

}
