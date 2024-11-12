package org.example.controller;

import org.example.model.Actor;
import org.example.model.Grupo;
import org.example.model.Teatro;
import org.example.request.ActorRequest;
import org.example.request.FuncionRequest;

import java.util.ArrayList;
import java.util.List;

public class Controlador {

    private Teatro teatro;

    public Controlador() {
        this.teatro = new Teatro();
    }

    public boolean cargarFuncion(FuncionRequest funcionRequest) {
        return this.teatro.cargarFuncion(funcionRequest.titulo(), funcionRequest.fecha(), funcionRequest.duracionMin(), funcionRequest.grupo());
    }

    public boolean cargarGrupo(String nombreGrupo, List<ActorRequest> actorRequestList) {
        return this.teatro.cargarGrupo(mapGrupo(nombreGrupo, actorRequestList));
    }



    private Grupo mapGrupo(String nombreGrupo, List<ActorRequest> actorRequestList) {
        List<Actor> actoresCandidatos = new ArrayList<>();
        for(ActorRequest actorRequest : actorRequestList) {
            actoresCandidatos.add(new Actor(actorRequest.nombre(), actorRequest.apellido()));
        }
        return new Grupo(nombreGrupo, actoresCandidatos);
    }



}
