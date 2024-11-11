package org.example.model;

import java.util.List;

public class Compra {

    private List<Funcion> funciones;
    private List<Asiento> lugaresSeleccionados;
    private MedioDePago medioDePago;

    public Compra(List<Funcion> funciones,
                  List<Asiento> lugaresSeleccionados,
                  MedioDePago medioDePago) {
        this.funciones = funciones;
        this.lugaresSeleccionados = lugaresSeleccionados;
        this.medioDePago = medioDePago;
    }

    public double calcularTotal() {

    }

}
