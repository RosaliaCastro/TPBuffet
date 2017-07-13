package com.example.rosalia.tpbuffet.Log_in;

/**
 * Created by Jona on 12/07/2017.
 */
public class Servicios {
    private String rutaLogin="http://192.168.1.34:3000/usuarios/";
    private String rutaRegistrar="http://192.168.1.34:3000/usuarios/nuevo";
    private String rutaMenu="http://192.168.1.34:3000/productos";
    private String rutaPedido="http://192.168.1.34:3000/pedidos/nuevo";
    private String rutaTraerPedido="http://192.168.1.34:3000/pedidos";

    public Servicios(){}

    public String getRutaLogin() {
        return rutaLogin;
    }

    public String getRutaMenu() {
        return rutaMenu;
    }

    public String getRutaPedido() {
        return rutaPedido;
    }

    public String getRutaRegistrar() {
        return rutaRegistrar;
    }

    public String getRutaTraerPedido() {
        return rutaTraerPedido;
    }
}
