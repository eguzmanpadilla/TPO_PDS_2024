package org.example.model;

public abstract class MedioDePago {

    private String tipo;

    public abstract double calcularMontoFinal(double total);



}
