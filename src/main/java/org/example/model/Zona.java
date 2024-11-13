package org.example.model;

public class Zona {

    private String nombre;
    private double precio;
    private int capacidadMaxima;
    private int asientosOcupados;

    public Zona(String nombre, double precio, int capacidadMaxima, int asientosOcupados) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadMaxima = 0;
        this.asientosOcupados = 0;
    }

    public boolean isDisponible(Funcion funcion) {
        return asientosOcupados < capacidadMaxima;
    }

    public void getDisponibleActual(Funcion funcion) {
      int disponibles = capacidadMaxima - asientosOcupados;
      if (disponibles > 0) {
          System.out.println("Quedan " + disponibles + " lugares disponibles en la zona " + nombre);
      } else {
          System.out.println("No quedan lugares disponibles en la zona " + nombre);
      }
    }

    public void reservarLugares(Funcion funcion, int cantidad) {
      if (asientosOcupados + cantidad <= capacidadMaxima) {
          asientosOcupados += cantidad;
          System.out.println(cantidad + " lugares reservados en la zona " + nombre);
      } else {
          System.out.println("No hay suficientes lugares disponibles para reservar " + cantidad + " asientos en la zona " + nombre);
      }
    }
    
    public int getCapacidadMaxima() {
      return capacidadMaxima;
  }

    public void setCapacidadMaxima(int capacidadMaxima) {
      this.capacidadMaxima = capacidadMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
