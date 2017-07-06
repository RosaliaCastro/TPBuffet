package com.example.rosalia.tpbuffet.Log_in;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Jona on 20/06/2017.
 */
public class MyConexion {

    public byte[] getBytesDateByGET(String strUrl) throws IOException{

        URL url = new URL(strUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();
        int response = urlConnection.getResponseCode();
        if(response == 200)
        {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int lenght = 0;
            while((lenght = is.read(buffer)) != -1)
            {
                baos.write(buffer,0,lenght);
            }
            is.close();
            return baos.toByteArray();

        }else{
            throw new IOException();
        }
    }
    public boolean posBytes(String strUrl, Uri.Builder parametros) throws IOException{
        boolean res;
        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            String query = parametros.build().getEncodedQuery();
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            res=true;
            }catch (IOException ex){
            ex.printStackTrace();
            res=false;
        }
        return res;

    }
    public Bitmap traerImagen(String url){
        URL imagUrl=null;
        Bitmap imagen=null;
        try {
            imagUrl=new URL(url);
            HttpURLConnection conn = (HttpURLConnection)imagUrl.openConnection();
            conn.connect();
            imagen= BitmapFactory.decodeStream(conn.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagen;
    }
    public String getListado(String strUrl) throws IOException{

        URL url = new URL(strUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();
        int response = urlConnection.getResponseCode();
        if(response == 200)
        {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int lenght = 0;
            while((lenght = is.read(buffer)) != -1)
            {
                baos.write(buffer,0,lenght);
            }
            is.close();
            return new String(baos.toByteArray());

        }else{
            throw new IOException();
        }
    }
}
