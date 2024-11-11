package org.example.model;

import java.util.List;

public class Grupo {
    private String nombre;
    private List<Actor> actores;



    public List<Actor> getActores() { return List.copyOf(actores); }
    public List<Funcion> getFunciones() {}
}
