package org.example.request;

import org.example.model.Asiento;
import org.example.model.Funcion;
import org.example.model.MedioDePago;

import java.util.Date;

public record EntradaRequest(String funcion, String date, AsientoRequest asientoRequest) {


}

