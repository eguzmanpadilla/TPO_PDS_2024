package org.example.model;

public class TarjetaCredito extends MedioDePago{

    private int cantidadCuotas;


    @Override
    public double calcularMontoFinal(double total) {

        if(this.cantidadCuotas==2) {
            return total*1.06;
        } else if (this.cantidadCuotas == 3) {
            return total*1.12;
        } else if (this.cantidadCuotas == 6) {
            return total*1.2;
        }
        return -1; //error

    }
}
