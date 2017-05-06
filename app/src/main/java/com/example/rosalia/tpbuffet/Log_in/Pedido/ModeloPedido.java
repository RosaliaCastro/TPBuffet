package com.example.rosalia.tpbuffet.Log_in.Pedido;

/**
 * Created by Jona on 06/05/2017.
 */
public class ModeloPedido {
    private String descripcionPedido;
    private Double precioPedido;
    private Double importePedido;
   // private Integer elementos;

    public ModeloPedido(String descripcion, Double precio){
        this.descripcionPedido= descripcion;
        this.precioPedido=precio;
    }
    public ModeloPedido(){}

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

    //public Integer getElementos() {
    //    return elementos;
    //}

    //public void setElementos(Integer elementos) {
      //  this.elementos = elementos;
    //}

    public void setImportePedido
            (Double importe) {
        this.importePedido = importe;
    }
}
