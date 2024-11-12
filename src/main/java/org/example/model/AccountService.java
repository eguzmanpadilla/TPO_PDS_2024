package org.example.model;

import java.util.List;

public class AccountService {

    String ADMIN_USERNAME = "Admin123";
    String ADMIN_PASSWORD = "1234";

    private List<Cliente> clientes;

    public boolean registrar(String nombre, String apellido, String email, String contraseña) {
        return true;
    }

    public boolean iniciarSesion(String email, String contraseña) {
        return true;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
