package org.example.model;

public class TarjetaDebito extends MedioDePago {

    public TarjetaDebito(String tipo) {
        super(tipo);
    }

    @Override
    public double calcularMontoFinal(double total) {
        return total*0.9;
    }
}
