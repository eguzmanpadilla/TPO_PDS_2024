package org.example.model;

import org.example.model.dataModel.DataFuncion;

import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private List<Compra> compras;

    public Cliente(String nombre,
                   String apellido,
                   String email,
                   List<Compra> compras) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.compras = compras;
    }

    public boolean registrar() {

    }

    public boolean login() {

    }

    public void realizarCompra(List <DataFuncion> funciones, List<LugarSeleccionado> lugares, MedioDePago medioDePago) {

    }

}
