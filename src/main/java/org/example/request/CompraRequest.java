package org.example.request;

import org.example.model.Cliente;

import java.util.List;

public record CompraRequest(List<EntradaRequest> entradas, MedioDePagoRequest medioDePagoRequest ) {
}
