package org.example.request;

import org.example.model.Asiento;
import org.example.model.Funcion;
import org.example.model.MedioDePago;

public record EntradaRequest(Funcion funcion,
                             Asiento asiento,
                             MedioDePago medioDePago) {



}

