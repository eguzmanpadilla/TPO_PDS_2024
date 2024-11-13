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

    private AccountService accountService;
    private List<Grupo> grupos;
    private List<Funcion> funciones;
    private List<Asiento> asientos;

    public Teatro() {
        this.nombre = "Colonial";
        this.direccion = "Av. Bartolomé Mitre 141, Avellaneda, Provincia de Buenos Aires";
        this.accountService = new AccountService();
        this.funciones = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.asientos = new ArrayList<>();
    }

    public boolean cargarFuncion(String titulo, Date fecha, int duracionMin, Grupo grupo) {
        for(Funcion funcion : funciones) {
            if(funcion.getTitulo() == titulo || funcion.getFecha().equals(fecha)) {
                return false;
            }
        }
        funciones.add(new Funcion(titulo, fecha, duracionMin, grupo));
        return true;
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

    public AccountService getAccountService() {
        return this.accountService;
    }

    public Funcion getFuncionXTitulo(String titulo) {
        for(Funcion funcion : funciones) {
            if (funcion.getTitulo() == titulo) {
                return funcion;
            }
        }
        return null;
    }




    public List<Cliente> getClientes() {
        return  this.accountService.getClientes();
    }
}
