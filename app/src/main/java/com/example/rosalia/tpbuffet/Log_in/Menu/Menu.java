package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
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
        RecyclerView list = (RecyclerView)findViewById(R.id.list);
        ModeloMenu modeloMenu1 = new ModeloMenu();
        ControladorMenu controladorMenu = new ControladorMenu(modeloMenu1, this);
        VistaMenu vistaMenu = new VistaMenu(modeloMenu1, controladorMenu, this);
        controladorMenu.setVistaMenu(vistaMenu);
        controladorMenu.cargarRecycler(list);
    }

}
