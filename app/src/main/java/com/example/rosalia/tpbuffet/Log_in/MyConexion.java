package com.example.rosalia.tpbuffet.Log_in;

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
}
