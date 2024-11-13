package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService {

    private Optional<Cliente> clienteActual;
    String ADMIN_USERNAME = "Admin123";
    String ADMIN_PASSWORD = "1234";
    private List<Cliente> clientes;
    public AccountService() {
        this.clienteActual = Optional.empty();
        this.clientes = new ArrayList<>();
    }

    public boolean registrar(String nombre, String apellido, String email, String contraseña) {
        return true;
    }

    public boolean iniciarSesion(String email, String contraseña) {



        this.clienteActual = Optional.of(actualCliente);
        return true;
    }

    public Cliente getClienteActual() {
        return this.clienteActual.get();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
