package org.example.model;

import java.util.Objects;
public class Actor {
    private final String nombre;
    private final String apellido;
    private Grupo grupo;

    public Actor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombreCompleto() {
		return nombre + " " + apellido;
	}


  public record Actor(String nombre, String apellido) {

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Actor actor = (Actor) o;
          return Objects.equals(nombre, actor.nombre) && Objects.equals(apellido, actor.apellido);
      }
  }
}
