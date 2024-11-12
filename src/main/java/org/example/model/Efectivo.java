package org.example.model;

public class Efectivo extends MedioDePago{

    public Efectivo(String tipo) {
        super(tipo);
    }

    @Override
    public double calcularMontoFinal(double total) {
      return total * 0.90;
    }
}
