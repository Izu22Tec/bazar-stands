package com.bazar.stands.service;

import com.bazar.stands.domain.Stand;

import java.util.*;

public class StandService {

    private final List<Stand> stands = new ArrayList<>();

    public void cargar() {
        // luego CSV
    }

    public void guardar() {
        // luego CSV
    }

    public void alta(Scanner sc) {
        Stand s = new Stand();
        s.setId(UUID.randomUUID().toString());
        System.out.print("Número de stand: ");
        s.setNumero(sc.nextLine());
        System.out.print("Tamaño: ");
        s.setTamano(sc.nextLine());
        System.out.print("Precio: ");
        try {
            s.setPrecio(Double.parseDouble(sc.nextLine()));
        } catch (NumberFormatException e) {
            s.setPrecio(0.0);
        }
        System.out.print("Ubicación: ");
        s.setUbicacion(sc.nextLine());
        s.setDisponible(true);
        stands.add(s);
        System.out.println("Stand creado con ID: " + s.getId());
    }

    public void listar() {
        if (stands.isEmpty()) {
            System.out.println("No hay stands registrados.");
            return;
        }
        stands.forEach(System.out::println);
    }

    public void editar(Scanner sc) {
        System.out.print("ID del stand a editar: ");
        String id = sc.nextLine();
        Optional<Stand> opt = stands.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
        if (opt.isEmpty()) {
            System.out.println("Stand no encontrado.");
            return;
        }
        Stand s = opt.get();
        System.out.print("Nuevo precio (enter mantiene " + s.getPrecio() + "): ");
        String precioStr = sc.nextLine();
        if (!precioStr.isBlank()) {
            try {
                s.setPrecio(Double.parseDouble(precioStr));
            } catch (NumberFormatException ignored) { }
        }
        System.out.println("Stand actualizado.");
    }

    public void cambiarDisponibilidad(Scanner sc) {
        System.out.print("ID del stand: ");
        String id = sc.nextLine();
        Optional<Stand> opt = stands.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
        if (opt.isEmpty()) {
            System.out.println("Stand no encontrado.");
            return;
        }
        Stand s = opt.get();
        s.setDisponible(!s.isDisponible());
        System.out.println("Nueva disponibilidad: " + (s.isDisponible() ? "DISPONIBLE" : "NO DISPONIBLE"));
    }

    public Stand buscarPorId(String id) {
        return stands.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
