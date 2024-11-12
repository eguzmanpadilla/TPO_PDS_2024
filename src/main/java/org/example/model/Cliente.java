package org.example.model;

import org.example.request.DataRequest;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private int hashPassword;
    private List<Compra> compras;

    public Cliente(String nombre, String apellido, String email, List<Compra> compras) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.compras = new ArrayList<>();
    }

    public void registrar() { // ver como implementar el registro
      System.out.println("Cliente registrado: " + nombre + " " + apellido);
    }

    public void login() {
      System.out.println("Cliente logueado: " + nombre + " " + apellido);
    }

    public void realizarCompra(List <DataFuncion> funciones, List<LugarSeleccionado> lugares, MedioDePago medioDePago) {
      Compra compra = new Compra(funciones, lugares, medioDePago);
      compras.add(compra);
      System.out.println("Compra realizada por: " + nombre + " " + apellido);
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

  public List<Compra> getCompras() {
      return List.copyOf(compras);
  }
}
