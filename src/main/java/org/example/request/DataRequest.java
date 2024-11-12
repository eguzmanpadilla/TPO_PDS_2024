package org.example.request;

import org.example.model.Asiento;
import org.example.model.Grupo;

import java.util.Date;
import java.util.List;

public record DataRequest(
        Date fecha,
        int duracionMin,
        Grupo grupo,
        List<Asiento> asientos) {


}
