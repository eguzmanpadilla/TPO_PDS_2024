package org.example.model;

public abstract class MedioDePago {
    private String tipo;

    public MedioDePago(String tipo) {
        this.tipo = tipo;
    }

    public abstract double calcularMontoFinal(double total);
    
}
