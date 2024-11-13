package org.example.view;

import java.util.stream.Stream;

public enum Accion {

    CARGAR_FUNCION((short) 1),
    CARGAR_GRUPO((short) 2),
    COMPRAR((short) 3),
    REGISTRAR((short) 4),
    INICIAR_SESION((short) 5),
    VOLVER_ATRAS((short) -1);
    private final short id;

    Accion(short id) {
        this.id = id;
    }

    public static Accion getById(short id, short tipo) {
        if(tipo == 1) { //admin
            return Stream.of(Accion.values())
                    .filter(action -> action.id == id && (action.id == -1 || action.id == 1 || action.id == 2) )
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No existe una película con este id"));
        } else { //usuario
            return Stream.of(Accion.values())
                    .filter(action -> action.id == id && (action.id == -1 || action.id == 3) )
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No existe una película con este id"));
        }
    }
}
