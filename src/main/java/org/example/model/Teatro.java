package org.example.model;

import org.example.request.ActorRequest;
import org.example.request.FuncionRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Teatro {
    private String nombre;
    private String direccion;

    private List<Grupo> grupos;
    private List<Funcion> funciones;
    private List<Cliente> clientes;

    public Teatro() {
        this.nombre = "Colonial";
        this.direccion = "Av. Bartolomé Mitre 141, Avellaneda, Provincia de Buenos Aires";
        this.funciones = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }

    public boolean cargarFuncion(String titulo, Date fecha, int duracionMin, Grupo grupo) {
        for(Funcion funcion : funciones) {
            if(funcion.getTitulo() != titulo && !funcion.getFecha().equals(fecha)) {
                return false;
            }
        }
        funciones.add(new Funcion(titulo, fecha, duracionMin, grupo, ))

    }

    public boolean cargarGrupo(Grupo grupoCandidato ) {
        for(Grupo grupo : grupos ) {
            if(Objects.equals(grupo.getNombre(), grupoCandidato.getNombre())) {
                return false;
            }
        }
        this.grupos.add(grupoCandidato);
        return true;
    }

    public void registrarCliente(Cliente cliente) {

    }
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }
}
