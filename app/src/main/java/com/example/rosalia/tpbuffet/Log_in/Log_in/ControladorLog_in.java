package com.example.rosalia.tpbuffet.Log_in.Log_in;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import android.view.View;
import android.widget.CheckBox;

import com.example.rosalia.tpbuffet.Log_in.Menu.Menu;
import com.example.rosalia.tpbuffet.Log_in.MyHiloLo_gin;
import com.example.rosalia.tpbuffet.Log_in.Registro.Registro;
import com.example.rosalia.tpbuffet.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by Jona on 30/04/2017.
 */
public class ControladorLog_in implements View.OnClickListener, Handler.Callback {
    private ModeloLog_in modeloLog_in;
    private Activity myActivity;
    private VistaLog_in vistaLog_in;
    SharedPreferences myPreferencia;
    Handler myHandler = new Handler(this);

    MyHiloLo_gin myHiloLo_gin;

    public ControladorLog_in() {}

    public ControladorLog_in(ModeloLog_in modeloLog_in, Activity myActivity, SharedPreferences myPreferencia) {

        this.modeloLog_in = modeloLog_in;
        this.myActivity = myActivity;
        this.myPreferencia=myPreferencia;
    }

    public void setControladorVista(VistaLog_in vistaLog_in) {
        this.vistaLog_in = vistaLog_in;
    }

    public void chequearRecordarme(SharedPreferences myPreferencia) {
        String Mail = myPreferencia.getString("Mail", "");
        String Clave = myPreferencia.getString("Clave", "");
        vistaLog_in.mail.setText(Mail);
        vistaLog_in.clave.setText(Clave);
        if (Mail != "" && Clave != "") {
            Intent myIntent = new Intent(myActivity, Menu.class);
            myActivity.startActivity(myIntent);
        }
    }

    public void recordarme(){
        CheckBox check = vistaLog_in.recordarme;
        if (check.isChecked()){
            String mail = vistaLog_in.mail.getText().toString();
            String clave = vistaLog_in.clave.getText().toString();
            SharedPreferences.Editor editor =myPreferencia.edit();
            editor.putString("Mail",mail);
            editor.putString("Clave",clave);
            editor.commit();
        }
    }

    private void startActivity(Intent intent) {
        myActivity.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        MiDialogo dialogo1 = new MiDialogo();
        if (view.getId() == R.id.btnIngresar) {

            String mail = vistaLog_in.mail.getText().toString();
            String clave = vistaLog_in.clave.getText().toString();

            if (validarCampo(mail, clave))
            { //valida que no esten vacios
                String servicioValidarF="http://192.168.2.95:3000/usuarios/"+mail+"/"+clave;
                String servicioValidarC="http://192.168.1.39:3000/usuarios/"+mail+"/"+clave;
                myHiloLo_gin = new MyHiloLo_gin(servicioValidarC, myHandler);
                Thread hiloDos = new Thread(myHiloLo_gin);
                hiloDos.start();

            } else  {
                dialogo1.show(myActivity.getFragmentManager(), "Alerta1");
                dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje1));
                vistaLog_in.limpiar();
                    }

        } else if (view.getId() == R.id.btnRegistrarme) {
            Intent intent2 = new Intent(myActivity, Registro.class);
            myActivity.startActivity(intent2);
        }
    }

    public boolean validarCampo(String mail, String clave) {
        boolean res = true;
        int cant1 = mail.length();
        int cant2 = clave.length();
        if (cant1 == 0 && cant2 == 0 || cant1 == 0 || cant2 == 0) {
            res = false;
        }
        return res;
    }

    public void validarUsuario() {
        MiDialogo dialogo1 = new MiDialogo();
        if (modeloLog_in.getCodigo() == 200) {
            recordarme();
            dialogo1.show(myActivity.getFragmentManager(),"Alerta2");
            dialogo1.setMensaje(modeloLog_in.getMensaje());
            Intent intentMenu = new Intent(myActivity, Menu.class);
            myActivity.startActivity(intentMenu);
        } else { if(modeloLog_in.getCodigo() == 400 || modeloLog_in.getCodigo() ==500){
            dialogo1.show(myActivity.getFragmentManager(), "Alerta3");
            //dialogo1.setMensaje(myActivity.getResources().getString(R.string.Mensaje3));
            dialogo1.setMensaje(modeloLog_in.getMensaje());
            }
        }
    }
    public void parcear(String str) throws JSONException {

        JSONObject jsonObject = new JSONObject(str); //sale el error Cannot evaluate org.json.JSONObject.toString()
        try{
            Integer cod = jsonObject.getInt("codigo");
            String mensaje = jsonObject.getString("mensaje");
            modeloLog_in.setCodigo(cod);
            modeloLog_in.setMensaje(mensaje);
            Log.d("Mensaje","parceado");
            validarUsuario();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        String resultado=null;
        Log.d("Recibendo","Mensaje");
        byte [] byts = (byte[]) message.obj;
        try {
            resultado= new String (byts,"UTF-8");
            parcear(resultado);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

}







