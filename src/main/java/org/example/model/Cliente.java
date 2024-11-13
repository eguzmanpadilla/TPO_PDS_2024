package org.example.model;

import org.example.request.DataRequest;
import org.example.request.MedioDePagoRequest;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private List<Compra> compras;

    public Cliente(String nombre, String apellido, String email, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.compras = new ArrayList<>();
    }

    public void registrar() { // ver como implementar el registro
      System.out.println("Cliente registrado: " + nombre + " " + apellido);
    }

    public void login() {
      System.out.println("Cliente logueado: " + nombre + " " + apellido);
    }

    public double realizarCompra(List<Entrada> entradas, MedioDePago medioDePago) {
      Compra compra = new Compra(entradas, medioDePago);
      compras.add(compra);
      System.out.println("Compra realizada por: " + nombre + " " + apellido);
      return medioDePago.calcularMontoFinal(compra.calcularTotal());
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public List<Compra> getCompras() {
        return List.copyOf(compras);
    }
}
