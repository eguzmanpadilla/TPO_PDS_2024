package org.example.model;

public class TarjetaDebito extends MedioDePago {

    public TarjetaDebito(String tipo, short cantidadCuotas) {
        super(tipo, cantidadCuotas);
    }

    @Override
    public double calcularMontoFinal(double total) {
        return total*0.9;
    }
}
