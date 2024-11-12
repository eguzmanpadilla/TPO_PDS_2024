package org.example.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Funcion {

    private String titulo;
    private Date fecha;
    private int duracionMin;
    private Grupo grupo;


    public Funcion(String titulo, Date fecha, int duracionMin, Grupo grupo) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.duracionMin = duracionMin;
        this.grupo = grupo;
    }

    public double getPrecioXFuncion() {
        return duracionMin*140;
    }
    public void reservarLugar(Zona zona, int cantidad) {
        //falta definir logica
    }


    public String getTitulo() {
        return titulo;
    }

    public Date getFecha() {
        return fecha;
    }
}




