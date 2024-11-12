package org.example.model;

import java.util.Objects;

public record Actor(String nombre, String apellido) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(nombre, actor.nombre) && Objects.equals(apellido, actor.apellido);
    }
}
