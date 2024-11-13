package org.example.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Funcion {

    private String titulo;
    private String fecha;
    private int duracionMin;
    private Grupo grupo;


    public Funcion(String titulo, String fecha, int duracionMin, Grupo grupo) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.duracionMin = duracionMin;
        this.grupo = grupo;
    }

    public double getPrecioXFuncion() {
        return duracionMin*140;
    }
    public void reservarLugar(Zona zona, int cantidad) {
        if (zona.isDisponible(this) && cantidad <= (zona.getCapacidadMaxima() - zona.getAsientosOcupados())) {
            zona.reservarLugares(this, cantidad);
        } else {
            System.out.println("No hay suficientes lugares disponibles en la zona " + zona.getNombre());
        }
    }


    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }
}




