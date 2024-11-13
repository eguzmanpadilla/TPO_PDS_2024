package org.example;

import org.example.controller.Controlador;
import org.example.model.*;
import org.example.request.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controlador controlador = new Controlador();

        // Registrar un usuario
        System.out.println("=== Registro de Usuario ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        if (controlador.registrar(nombre, apellido, email, contraseña)) {
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("Error al registrar el usuario.");
        }

        // Iniciar sesión
        System.out.println("=== Iniciar Sesión ===");
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Contraseña: ");
        contraseña = scanner.nextLine();

        if (controlador.iniciarSesion(email, contraseña)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + controlador.getUsuarioActual());
        } else {
            System.out.println("Email o contraseña incorrectos.");
        }

        // Crear un grupo y cargarlo
        System.out.println("=== Crear y Cargar Grupo ===");
        System.out.print("Nombre del grupo: ");
        String nombreGrupo = scanner.nextLine();

        List<ActorRequest> actores = new ArrayList<>();
        System.out.print("Número de actores en el grupo: ");
        int numActores = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numActores; i++) {
            System.out.print("Nombre del actor " + (i + 1) + ": ");
            String nombreActor = scanner.nextLine();
            System.out.print("Apellido del actor " + (i + 1) + ": ");
            String apellidoActor = scanner.nextLine();
            actores.add(new ActorRequest(nombreActor, apellidoActor));
        }

        if (controlador.cargarGrupo(nombreGrupo, actores)) {
            System.out.println("Grupo cargado exitosamente.");
        } else {
            System.out.println("Error al cargar el grupo.");
        }

        // Cargar una función
        System.out.println("=== Cargar Función ===");
        System.out.print("Título de la función: ");
        String tituloFuncion = scanner.nextLine();
        System.out.println("Ingresa la fecha: ");
        String fechaFuncion = scanner.nextLine();
        System.out.print("Duración en minutos: ");
        int duracionFuncion = Integer.parseInt(scanner.nextLine());

        FuncionRequest funcionRequest = new FuncionRequest(tituloFuncion, fechaFuncion, duracionFuncion, nombreGrupo);
        if (controlador.cargarFuncion(funcionRequest)) {
            System.out.println("Función cargada exitosamente.");
        } else {
            System.out.println("Error al cargar la función.");
        }

        // Comprar entradas
        System.out.println("=== Comprar Entradas ===");
        List<EntradaRequest> entradas = new ArrayList<>();

        System.out.print("Número de entradas a comprar: ");
        int numEntradas = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numEntradas; i++) {
            System.out.print("ID del asiento " + (i + 1) + ": ");
            int idAsiento = Integer.parseInt(scanner.nextLine());
            System.out.print("Zona del asiento (PLATEA, PALCO_ALTO, PALCO_BAJO, CAZUELA, TERTULIA): ");
            String zona = scanner.nextLine();

            System.out.println("Ingresa la fecha: ");
            String fechaEntrada = scanner.nextLine();

            AsientoRequest asientoRequest = new AsientoRequest(idAsiento, zona);
            EntradaRequest entradaRequest = new EntradaRequest(tituloFuncion, fechaEntrada, asientoRequest);
            entradas.add(entradaRequest);
        }

        System.out.print("Método de pago (Credito, Debito, Efectivo): ");
        String tipoPago = scanner.nextLine();
        System.out.print("Número de cuotas (1 si es Efectivo o Débito): ");
        short cuotas = scanner.nextShort();
        MedioDePagoRequest medioDePago = new MedioDePagoRequest(tipoPago, cuotas);

        double totalCompra = controlador.compra(entradas, medioDePago);
        System.out.println("Compra realizada. Total: $" + totalCompra);

        scanner.close();
    }
}