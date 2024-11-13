package org.example.model;

public class Asiento {
    private int id_asiento;
    private Zona zona;

    public Asiento(int id_asiento,
                   Zona zona) {
        this.id_asiento = id_asiento;
        this.zona = zona;
    }

    public int getId_asiento() {
        return id_asiento;
    }

    public double getPrecio() {
        return this.zona.getPrecio();
    }

    public Zona getZona() {
        return this.zona;
    }
}
