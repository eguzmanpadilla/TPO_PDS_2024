package org.example.model;

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
}
