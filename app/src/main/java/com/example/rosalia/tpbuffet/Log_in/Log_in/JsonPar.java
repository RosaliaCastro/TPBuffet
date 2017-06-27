package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by Jona on 21/06/2017.
 */
public class JsonPar {
    ModeloLog_in modeloLog_in= new ModeloLog_in();
    public void parcear(String str){
        try{
            JSONObject jsonObject = new JSONObject(str);
            String mensaje = jsonObject.getString("mensaje");
            Integer cod = jsonObject.getInt("codigo");
            modeloLog_in.setCodigo(cod);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
