package org.example.model;

public class Zona {

    private String nombre;
    private double precio;
    private int capacidadMaxima = 30;
    private int[] lugares = new int[capacidadMaxima];

    public Zona(String nombre, double precio, int capacidadMaxima) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean isDisponible(Funcion funcion, int cantSolicitada) {
        return true;
    }

    public void getDisponibleActual(Funcion funcion) {
        if (capacidadMaxima > 0) {
            System.out.println("Quedan " + capacidadMaxima + " lugares disponibles en la zona " + nombre);
        } else {
            System.out.println("No quedan lugares disponibles en la zona " + nombre);
        }
    }

    public void reservarLugares(Funcion funcion, int cantidad) {
        if (capacidadMaxima >= cantidad) {
            capacidadMaxima -= cantidad;
            System.out.println("Reserva exitosa de " + cantidad + " lugares en la zona " + nombre);
        } else {
            System.out.println("No hay suficientes lugares disponibles en la zona " + nombre);
        }

    }
    public void liberarLugares(Funcion funcion, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("No se puede liberar una cantidad menor o igual a 0");
        } else {
            capacidadMaxima += cantidad;
            System.out.println("Se han liberado " + cantidad + " lugares en la zona " + nombre);
        }
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
