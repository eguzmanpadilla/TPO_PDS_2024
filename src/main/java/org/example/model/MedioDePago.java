package org.example.model;

public abstract class MedioDePago {
    private String tipo;
    private short cantidadCuotas;

    public MedioDePago(String tipo, short cantidadCuotas) {
        this.tipo = tipo;
        this.cantidadCuotas = cantidadCuotas;
    }

    public String getTipo() {
        return tipo;
    }

    public short getCantidadCuotas() {
        return cantidadCuotas;
    }

    public abstract double calcularMontoFinal(double total);
    
}
