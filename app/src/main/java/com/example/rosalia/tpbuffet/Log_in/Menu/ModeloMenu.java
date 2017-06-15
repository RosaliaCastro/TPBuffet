package com.example.rosalia.tpbuffet.Log_in.Menu;

import java.util.List;

/**
 * Created by Jona on 01/05/2017.
 */
public class ModeloMenu {
    private String descripcion;
    private Double precio;
    private Double importe;
    private int elementos;
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

    public ModeloMenu(String descripcion, Double precio){
        this.descripcion= descripcion;
        this.precio=precio;
    }
    public ModeloMenu(){}

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
