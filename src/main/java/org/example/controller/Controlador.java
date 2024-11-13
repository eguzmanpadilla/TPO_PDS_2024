package org.example.controller;

import org.example.model.*;
import org.example.request.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controlador {

    private Teatro teatro;

    public Controlador() {
        this.teatro = new Teatro();
    }

    public boolean cargarFuncion(FuncionRequest funcionRequest) {
        return this.teatro.cargarFuncion(
                funcionRequest.titulo(),
                funcionRequest.fecha(),
                funcionRequest.duracionMin(),
                getGrupo(funcionRequest.grupo())
        );
    }

    public boolean cargarGrupo(String nombreGrupo, List<ActorRequest> actorRequestList) {
        return this.teatro.cargarGrupo(mapGrupo(nombreGrupo, actorRequestList));
    }

    public double compra(List<EntradaRequest> entradas, MedioDePagoRequest medioDePago) {
        MedioDePago pago = null;
        if(Objects.equals(medioDePago.tipo(), "Credito")) {
            pago = new TarjetaCredito(medioDePago.tipo(), medioDePago.cuotas());
        } else if (Objects.equals(medioDePago.tipo(), "Debito")) {
            pago = new TarjetaDebito(medioDePago.tipo(), medioDePago.cuotas());
        } else {
            pago = new Efectivo(medioDePago.tipo(), medioDePago.cuotas());
        }
        return this.teatro.getAccountService().getClienteActual().realizarCompra(mapEntradas(entradas), pago);
    }

    public CompraRequest getCompra() {
        Compra compra = this.teatro.getAccountService().getClienteActual().getCompras().getLast();
        return mapCompra(compra);
    }


    public boolean registrar(String nombre,String apellido, String email, String contraseña) {
        return this.teatro.getAccountService().registrarCliente(nombre, apellido, email, contraseña);
    }

    public boolean iniciarSesion(String email, String contraseña) {
        return this.teatro.getAccountService().iniciarSesion(email, contraseña);

    }

    public String getUsuarioActual() {
        return this.teatro.getAccountService().getClienteActual().getEmail();
    }

    public Funcion getFuncion(String titulo) {
        return this.teatro.getFuncionXTitulo(titulo);
    }
    public Grupo getGrupo(String grupo) {return this.teatro.getGrupo(grupo);}
    public List<String> getGrupos() {
        return this.teatro.getNombreGrupos();
    }

    private Grupo mapGrupo(String nombreGrupo, List<ActorRequest> actorRequestList) {
        List<Actor> actoresCandidatos = new ArrayList<>();
        for(ActorRequest actorRequest : actorRequestList) {
            actoresCandidatos.add(new Actor(actorRequest.nombre(), actorRequest.apellido()));
        }
        return new Grupo(nombreGrupo, actoresCandidatos);
    }

    private List<Entrada> mapEntradas(List<EntradaRequest> entradaRequestList) {
        List<Entrada> listaFinal = new ArrayList<>();
        for(EntradaRequest entradaRequest : entradaRequestList) {
            listaFinal.add(new Entrada(
                    getFuncion(entradaRequest.funcion()),
                    entradaRequest.date(),
                    mapAsiento(entradaRequest.asientoRequest())
                    ));
        }
        return listaFinal;
    }

    private Asiento mapAsiento(AsientoRequest asientoRequest) {
        ZonaPrecio zona = null;
        if(ZonaPrecio.PLATEA.toString().equals(asientoRequest.zona())) {
            zona = ZonaPrecio.PLATEA;
        } else if(ZonaPrecio.PALCO_ALTO.toString().equals(asientoRequest.zona())) {
            zona = ZonaPrecio.PALCO_ALTO;
        } else if(ZonaPrecio.PALCO_BAJO.toString().equals(asientoRequest.zona())) {
            zona = ZonaPrecio.PALCO_BAJO;
        } else if(ZonaPrecio.CAZUELA.toString().equals(asientoRequest.zona())) {
            zona = ZonaPrecio.CAZUELA;
        } else if (ZonaPrecio.TERTULIA.toString().equals(asientoRequest.zona())) {
            zona = ZonaPrecio.TERTULIA;
        } else if(ZonaPrecio.TERTULIA.toString().equals(asientoRequest.zona())) {
            zona = ZonaPrecio.TERTULIA;
        }
        return new Asiento(asientoRequest.id_asiento(), new Zona(zona));
    }


    private CompraRequest mapCompra(Compra compra) {
        List<EntradaRequest> entradaRequestList = new ArrayList<>();
        for(Entrada entrada : compra.getEntradas()) {
            entradaRequestList.add(
                    new EntradaRequest(
                            entrada.funcion().getTitulo(),
                            entrada.fecha(),
                            new AsientoRequest(
                                    entrada.asiento().getId_asiento(),
                                    entrada.asiento().getZona().getNombre().toString()
                            )
                    )
            );
        }
        return new CompraRequest(
                entradaRequestList,
                new MedioDePagoRequest(
                        compra.getMedioDePago().getTipo(),
                        compra.getMedioDePago().getCantidadCuotas()
                )
        );

    }





}
