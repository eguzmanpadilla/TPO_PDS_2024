package org.example.model;

public class Efectivo extends MedioDePago{

    public Efectivo(String tipo, short cantidadCuotas) {
        super(tipo, cantidadCuotas);
    }

    @Override
    public double calcularMontoFinal(double total) {
      return total * 0.90;
    }
}
