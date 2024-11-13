package org.example.model;

import java.util.List;

public class Grupo {
    private final String nombre;
    private List<Actor> actores;

    public Grupo(String nombre, List<Actor> actores) {
        this.nombre = nombre;
        this.actores = actores;
        setGrupoForActores();
    }

    private void setGrupoForActores() {
      if (actores != null) {
        for (Actor actor : actores) {
            actor.setGrupo(this);
        }
      }
    }

    public String getNombre() { return nombre; }

    public List<Actor> getActores() { return List.copyOf(actores); }

    public List<Funcion> getFunciones() {
      throw new UnsupportedOperationException("No implementado");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Actor> getActores() {
        return List.copyOf(actores);
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public void addActor(String nombre, String apellido) {
        this.actores.add(new Actor(nombre, apellido));
    }
    public void deleteActor(String nombre, String apellido) {
        Actor searched = new Actor(nombre, apellido);
        for(Actor actor : actores) {
            if(actor.equals(searched)) {
                this.actores.remove(actor);
                return;
            }
        }

    }
}
