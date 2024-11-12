package org.example.model;

import java.util.List;

public class AccountService {

    String ADMIN_USERNAME = "Admin123";
    String ADMIN_PASSWORD = "1234";

    private List<Cliente> clientes;

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
      for (Cliente cliente : clientes) {
          if (cliente.getEmail().equals(email) && cliente.getContraseña().equals(contraseña)) {
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
}
