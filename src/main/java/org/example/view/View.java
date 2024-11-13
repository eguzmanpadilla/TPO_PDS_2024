package org.example.view;

import org.example.controller.Controlador;
import org.example.request.ActorRequest;
import org.example.request.FuncionRequest;

import java.util.*;

public class View {

    private final Controlador controlador;
    private final Scanner scanner;

    public View() {
        this.controlador = new Controlador();
        this.scanner = new Scanner(System.in);
    }


    public void start() {
        boolean ok = inicioSesion();
        if(!ok) {return;}
        if(this.controlador.getUsuarioActual().equals("admin123@gmail.com")) {
            boolean keep = true;
            while(keep) {
                keep = useMenuAdmin();
            }

        } else {
            boolean keep = true;
            while(keep) {
                keep = useMenuCliente();
            }

        }


        while (true) {

        }
    }

    private boolean inicioSesion() {
        System.out.println("Inicio de sesión");
        System.out.println("Ingrese su email");
        String email = this.scanner.next();
        System.out.println("Ingrese la contraseña");
        String contrasenia = this.scanner.next();

        boolean inicio = this.controlador.iniciarSesion(email, contrasenia);
        System.out.println(inicio ? "Inicio de sesión correcto" : "Acceso prohibido");
        return inicio;
    }



    private boolean useMenuAdmin() {
        Accion accionActual = menuAdmin();
        if(Accion.CARGAR_FUNCION.equals(accionActual)) {
            cargarFuncion();
            return true;
        } else if (Accion.CARGAR_GRUPO.equals(accionActual)) {
            cargarGrupo();
            return true;
        } else {
            return false;
        }
    }

    private Accion menuAdmin() {
        System.out.println("""
                Seleccione una opción:
                1. Cargar una nueva funcion
                2. Cargar grupos
                
                -1. Volver atras
                """);

        while (true) {
            try {
                short opcion = this.scanner.nextShort();
                return Accion.getById(opcion, (short) 1);
            } catch (Exception e) {
                System.out.println("Valor no permitido. Ingrese otro valor.");
                this.scanner.next();
            }
        }
    }

    private boolean useMenuCliente() {
        Accion accionActual = menuCliente();
        if(Accion.COMPRAR.equals(accionActual)) {
            comprar();
            return true;
        } else {
            return false;
        }
    }


    private Accion menuCliente() {
        System.out.println("""
                Seleccione una opción:
                3. Comprar entradas
                
                -1. Volver atras
                """);

        while (true) {
            try {
                short opcion = this.scanner.nextShort();
                return Accion.getById(opcion, (short) 2);
            } catch (Exception e) {
                System.out.println("Valor no permitido. Ingrese otro valor.");
                this.scanner.next();
            }
        }
    }

    public void cargarGrupo() {
        System.out.println();
        System.out.println("Nombre del grupo");
        String nombre = this.scanner.next();

        System.out.println();
        System.out.println("Ingresa a los actores");
        List<ActorRequest> actorRequests = new ArrayList<>();
        String nombreActor;
        String apellidoActor;
        String num;
        do {
            System.out.println("Ingresa el nombre");
            nombreActor = this.scanner.next();
            System.out.println("Ingresa el apellido");
            apellidoActor = this.scanner.next();

            actorRequests.add(new ActorRequest(nombreActor, apellidoActor));

            System.out.println("Continuar? (SI/NO)");
            num = this.scanner.next();

            if(num.equalsIgnoreCase("NO")) {
                break;
            }else if(num.equalsIgnoreCase("SI")) {
                System.out.println();
            }
        } while(true);
        this.controlador.cargarGrupo(nombre, actorRequests);
    }




    private void cargarFuncion() {
        System.out.println();
        System.out.println("Ingrese un título");
        String titulo = this.scanner.next();

        System.out.println("Ingrese la duracion en minutos");
        int duracionMin = this.scanner.nextInt();

        String grupo = seleccionarGrupo();

        System.out.println("Ingrese la fecha de la funcion");

        System.out.println("Mes?");
        short mes;
        do {
            mes = this.scanner.nextShort();
            if(mes < 1 && mes > 12) {
                System.out.println("Vuelva a ingresar el mes");
            } else {
                break;
            }
        } while(true);

        System.out.println("Dia?");
        short dia;
        do {
            dia = this.scanner.nextShort();
            if(dia < 1 && dia > 31) {
                System.out.println("Vuelva a ingresar el dia");
            } else {
                break;
            }
        } while(true);


        System.out.println("Hora?");
        short hora;
        do {
            hora = this.scanner.nextShort();
            if(hora < 9 && hora > 22) {
                System.out.println("Vuelva a ingresar la hora");
            } else {
                break;
            }
        } while(true);


        System.out.println("Minuto?");
        short minuto;
        do {
            minuto = this.scanner.nextShort();
            if(minuto < 1 && minuto > 60) {
                System.out.println("Vuelva a ingresar el minuto");
            } else {
                break;
            }
        } while(true);
        StringBuilder fecha = new StringBuilder();
        fecha.append(dia).append("/").append(mes).append("/").append("24").append(" ").
                append(hora).append(":").append(minuto);
        this.controlador.cargarFuncion(new FuncionRequest(titulo, fecha.toString(), duracionMin, grupo));
    }

    private String seleccionarGrupo() {
        List<String> nombres = this.controlador.getGrupos();
        short nombreIndice;
        do {
            for (int i = 0; i < nombres.size(); i++) {
                System.out.println((i + 1) + ". " + nombres.get(i));
            }
            nombreIndice = this.scanner.nextShort();
            if(nombreIndice < 1 || nombreIndice > nombres.size()){
                System.out.println("El valor ingresado no es valido");
            } else {
                break;
            }
        } while(true);
        return nombres.get(nombreIndice - 1);
    }

    private void comprar() {
        System.out.println();
        System.out.println("Seleccione metodo de pago");
        System.out.println("""
                1. Tarjeta de Credito
                2. Tarjeta de Debito
                3. Efectivo""" );
        short opcion;
        do {
            opcion = this.scanner.nextShort();
            if(opcion < 1 || opcion > 3) {
                System.out.println("El valor ingresado no es valido");
            } else {
                break;
            }
        } while(true);




        // public double compra(List<EntradaRequest> entradas, MedioDePagoRequest medioDePago)
        this.controlador.compra();
    }





}
