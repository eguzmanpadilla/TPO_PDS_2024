package org.example.model;

public class TarjetaCredito extends MedioDePago{



    public TarjetaCredito(String tipo, short cantidadCuotas) {
        super(tipo, cantidadCuotas);
    }

    @Override
    public double calcularMontoFinal(double total) {

        if(super.getCantidadCuotas() == 1) {
            return total;
        } else if(super.getCantidadCuotas()==2) {
            return total*1.06;
        } else if (super.getCantidadCuotas() == 3) {
            return total*1.12;
        } else if (super.getCantidadCuotas() == 6) {
            return total*1.2;
        }
        return -1; //error

    }
}
