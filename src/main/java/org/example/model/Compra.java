package org.example.model;

import java.util.List;

public class Compra {

    private List<Entrada> entradas;

    public Compra(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public double calcularTotal() {
        double total = 0;
        for (Entrada entrada : entradas) {
            double base = entrada.funcion().getPrecioXFuncion() + entrada.asiento().getPrecio();
            double modif = entrada.medioDePago().calcularMontoFinal(base);
            total = total + modif;
        }
        return total;
    }

}
