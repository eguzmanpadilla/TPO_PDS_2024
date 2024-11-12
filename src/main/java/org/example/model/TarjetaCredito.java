package org.example.model;

public class TarjetaCredito extends MedioDePago{

    private int cantidadCuotas;

    public TarjetaCredito(String tipo, int cantidadCuotas) {
        super(tipo);
        this.cantidadCuotas = cantidadCuotas;
    }

    @Override
    public double calcularMontoFinal(double total) {
      double cargo = 0.05 * cantidadCuotas;
      return total * (1 + cargo);
    }
}
