package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService {

  private Optional<Cliente> clienteActual;

    String ADMIN_EMAIL = "admin123@gmail.com";
    String ADMIN_PASSWORD = "1234";

    private List<Cliente> clientes;

    public AccountService() {
        this.clienteActual = Optional.empty();
        this.clientes = new ArrayList<>();
    }

    public boolean registrarCliente(String nombre, String apellido, String email, String contraseña) {
      for (Cliente cliente : clientes) {
          if (cliente.getEmail().equals(email)) {
              System.out.println("El cliente ya está registrado con ese email.");
              return false;
          }
      }

      Cliente nuevoCliente = new Cliente(nombre, apellido, email, contraseña);
      clientes.add(nuevoCliente);
      System.out.println("Cliente registrado exitosamente: " + nombre + " " + apellido);
      return true;
  }

  public boolean iniciarSesion(String email, String contraseña) {
      Optional<Cliente> clienteActual = Optional.empty();
      for (Cliente cliente : clientes) {
          if (cliente.getEmail().equals(email) && cliente.getContraseña().equals(contraseña)) {
              this.clienteActual = Optional.of(cliente);
              System.out.println("Inicio de sesión exitoso para: " + cliente.getNombre() + " " + cliente.getApellido());
              return true;
          }
      }
      System.out.println("Email o contraseña incorrectos.");
      return false;
  }

  public List<Cliente> getClientes() {
      return List.copyOf(clientes);
  }
    public Cliente getClienteActual() {
        return this.clienteActual.get();
    }
}
