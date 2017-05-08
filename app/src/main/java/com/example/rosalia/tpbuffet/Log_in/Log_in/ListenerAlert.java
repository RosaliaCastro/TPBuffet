package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

/**
 * Created by Jona on 06/05/2017.
 */
public class ListenerAlert implements DialogInterface.OnClickListener{

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Log.d("dialog", "Click!");

    }
}
