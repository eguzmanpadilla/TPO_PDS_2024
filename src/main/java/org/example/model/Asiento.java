package org.example.model;

public class Asiento {
    private int id_asiento;
    private Zona zona;
    private int cantidadEntradas;

    public Asiento(int id_asiento,
                   Zona zona,
                   int cantidadEntradas) {
        this.id_asiento = id_asiento;
        this.zona = zona;
        this.cantidadEntradas = cantidadEntradas;
    }

    public double getPrecio() {
        return this.zona.getPrecio();
    }
}
