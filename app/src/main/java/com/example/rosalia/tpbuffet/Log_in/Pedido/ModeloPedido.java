package com.example.rosalia.tpbuffet.Log_in.Pedido;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Jona on 06/05/2017.
 */
public class ModeloPedido {
    private String tipo;
    private String descripcionPedido;
    private Double precioPedido;
    private Double importePedido;
    private int elementos;
    List<ModeloPedido> ListaPedido;
    String urlImagen;
    Bitmap imagen;
    private String mensaje;

    public ModeloPedido(){}

    public ModeloPedido(String tipo, String descripcion, Double precio, String urlImagen){
        this.tipo=tipo;
        this.descripcionPedido= descripcion;
        this.precioPedido=precio;
        this.urlImagen=urlImagen;
    }
    public ModeloPedido(Double importe, int elementos){
        this.importePedido=importe;
        this.elementos=elementos;
    }

    public List<ModeloPedido> getListaPedido() {
        return ListaPedido;
    }

    public void setListaPedido(List<ModeloPedido> listaPedido) {
        ListaPedido = listaPedido;
    }

    public Double getPrecioPedido() {
        return precioPedido;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(String descripcion) {
        this.descripcionPedido = descripcion;
    }

    public void setPrecioPedido(Double precio) {
        this.precioPedido = precio;
    }

    public Double getImportePedido() {
        return importePedido;
    }

    public int getElementos() {
      return elementos;
    }

    public void setElementos(int elementos) {
      this.elementos = elementos;
    }

    public void setImportePedido (Double importe) {this.importePedido = importe;}

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        urlImagen = urlImagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
