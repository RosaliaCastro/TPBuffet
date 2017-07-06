package com.example.rosalia.tpbuffet.Log_in.Menu;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Jona on 01/05/2017.
 */
public class ModeloMenu {
    private String nombre;
    private Double precio;
    private String tipo;
    private Double importe;
    private int elementos;
    String urlImagen;
    private Bitmap imagen;
    List<ModeloMenu>Lista;

    public List<ModeloMenu> getListaMenu(){
        return Lista;
    }
    public void setListaMenu(List<ModeloMenu> Lista){
        this.Lista=Lista;
    }

    public ModeloMenu (Double importe, int elementos){
        this.importe=importe;
        this.elementos=elementos;
    }

    public ModeloMenu(String tipo, String nombre, Double precio, String urlImagen){
        this.nombre= nombre;
        this.precio=precio;
        this.tipo=tipo;
        this.urlImagen=urlImagen;
    }
    public ModeloMenu(){}

    public Double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getImporte() {
        return importe;
    }

    public Integer getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getUrlImagen() {return urlImagen;}

    public void setUrlImagen(String urlImagen) {this.urlImagen = urlImagen;}

    public Bitmap getImagen() {return imagen;}

    public void setImagen(Bitmap imagen) {this.imagen = imagen;}
}
