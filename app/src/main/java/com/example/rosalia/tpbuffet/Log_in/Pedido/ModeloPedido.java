package com.example.rosalia.tpbuffet.Log_in.Pedido;

import java.util.List;

/**
 * Created by Jona on 06/05/2017.
 */
public class ModeloPedido {
    private String descripcionPedido;
    private Double precioPedido;
    private Double importePedido;
    private int elementos;
    List<ModeloPedido> ListaPedido;

    public ModeloPedido(){}

    public ModeloPedido(String descripcion, Double precio){
        this.descripcionPedido= descripcion;
        this.precioPedido=precio;
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
}
