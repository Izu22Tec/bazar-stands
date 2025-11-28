package com.bazar.stands.service;

import com.bazar.stands.domain.Vendedor;

import java.util.*;

public class VendedorService {

    private final List<Vendedor> vendedores = new ArrayList<>();

    public void cargar() {
        // Por ahora: sin persistencia, lista vacía
        // Después aquí lees CSV
    }

    public void guardar() {
        // Después escribes CSV aquí
    }

    public void alta(Scanner sc) {
        Vendedor v = new Vendedor();
        v.setId(UUID.randomUUID().toString());
        System.out.print("Nombre: ");
        v.setNombre(sc.nextLine());
        System.out.print("Giro: ");
        v.setGiro(sc.nextLine());
        System.out.print("Teléfono: ");
        v.setTelefono(sc.nextLine());
        System.out.print("Redes sociales: ");
        v.setRedesSociales(sc.nextLine());
        vendedores.add(v);
        System.out.println("Vendedor creado con ID: " + v.getId());
    }

    public void listar() {
        if (vendedores.isEmpty()) {
            System.out.println("No hay vendedores.");
            return;
        }
        vendedores.forEach(System.out::println);
    }

    public void editar(Scanner sc) {
        System.out.print("ID vendedor a editar: ");
        String id = sc.nextLine();
        Optional<Vendedor> opt = vendedores.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
        if (opt.isEmpty()) {
            System.out.println("No encontrado.");
            return;
        }
        Vendedor v = opt.get();
        System.out.print("Nuevo nombre (enter mantiene '" + v.getNombre() + "'): ");
        String nuevo = sc.nextLine();
        if (!nuevo.isBlank()) v.setNombre(nuevo);
        System.out.println("Actualizado.");
    }

    public void eliminar(Scanner sc) {
        System.out.print("ID vendedor a eliminar: ");
        String id = sc.nextLine();
        boolean removed = vendedores.removeIf(v -> v.getId().equals(id));
        System.out.println(removed ? "Eliminado." : "No encontrado.");
    }

    public Vendedor buscarPorId(String id) {
        return vendedores.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
