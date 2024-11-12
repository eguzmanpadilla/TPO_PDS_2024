package org.example.model;

public class TarjetaDebito extends MedioDePago {

    @Override
    public double calcularMontoFinal(double total) {
        return total*0.9;
    }
}
