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

    public void addActor(Actor actor) {
      if (actor != null) {
        actores.add(actor);
        actor.setGrupo(this);
      }
    }
    public String getNombre() { return nombre; }

    public List<Actor> getActores() { return List.copyOf(actores); }

    public List<Funcion> getFunciones() {
      throw new UnsupportedOperationException("No implementado");
    }
}
