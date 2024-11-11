package org.example.model;

public class Asiento {
    private int asiento;
    private Zona zona;
    private Funcion funcion;
    private int cantidadEntradas;

    public Asiento(int asiento,
                   Zona zona,
                   Funcion funcion,
                   int cantidadEntradas) {
        this.asiento = asiento;
        this.zona = zona;
        this.funcion = funcion;
        this.cantidadEntradas = cantidadEntradas;
    }

    public double getPrecio(Zona zona) {

    }
}
