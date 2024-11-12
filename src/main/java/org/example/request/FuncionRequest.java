package org.example.request;

import org.example.model.Grupo;

import java.util.Date;

public record FuncionRequest(String titulo, Date fecha, int duracionMin, Grupo grupo) {



}
