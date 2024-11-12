package org.example.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Funcion {

    private String titulo;
    private Date fecha;
    private int duracionMin;
    private Grupo grupo;
    private List<Asiento> asientos;

    public Funcion(String titulo, Date fecha, int duracionMin, Grupo grupo, List<Asiento> asientos) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.duracionMin = duracionMin;
        this.grupo = grupo;
        this.asientos = asientos;
    }

    public double getPrecioFuncion() {

    }

    public boolean isDisponible() {}
    public void reservarLugar(Zona zona, int cantidad) {}


    public String getTitulo() {
        return titulo;
    }

    public Date getFecha() {
        return fecha;
    }
}



}
