package org.example.model;

public class Zona {

    private String nombre;
    private double precio;
    private int capacidadMaxima;

    public Zona(String nombre, double precio, int capacidadMaxima) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean isDisponible(Funcion funcion, int cantSolicitada) {
        return true;
    }

    public void getDisponibleActual(Funcion funcion) {
        //todavia falta definir logica
    }

    public void reservarLugares(Funcion funcion, int cantidad) {
        //falta definir logica

    }
    public void liberarLugares(Funcion funcion, int cantidad) {
        //falte definir logica

    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
