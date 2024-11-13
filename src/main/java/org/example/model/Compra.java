package org.example.model;

import java.util.List;

public class Compra {

    private List<Entrada> entradas;
    private MedioDePago medioDePago;

    public Compra(List<Entrada> entradas, MedioDePago medioDePago) {
        this.entradas = entradas;
        this.medioDePago = medioDePago;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public double calcularTotal() {
        double total = 0;
        for (Entrada entrada : entradas) {
            double base = entrada.funcion().getPrecioXFuncion() + entrada.asiento().getPrecio();
            total = total + base;
        }
        return total;
    }

}
