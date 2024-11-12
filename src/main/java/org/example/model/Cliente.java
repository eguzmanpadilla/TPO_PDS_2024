package org.example.model;

import org.example.request.DataRequest;

import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private int hashPassword;
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

    public void realizarCompra(List <DataRequest> funciones, List<Asiento> lugares, MedioDePago medioDePago) {

    }

}
