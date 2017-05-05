package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.app.Activity;
import android.view.View;

/**
 * Created by Jona on 01/05/2017.
 */
public class ControladorMenu implements View.OnClickListener {
    ModeloMenu modeloMenu;
    Activity myActivity;
    VistaMenu vistaMenu;

    public ControladorMenu(ModeloMenu modeloMenu, Activity myActivity){
        this.modeloMenu= modeloMenu;
        this.myActivity= myActivity;
    }
    public void setVistaMenu(VistaMenu vistaMenu){
        this.vistaMenu=vistaMenu;
    }

    @Override
    public void onClick(View view) {

    }
}
