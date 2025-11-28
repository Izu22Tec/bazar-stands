package com.bazar.stands.service;

import com.bazar.stands.domain.Pago;

import java.util.*;

public class PagoService {

    private final List<Pago> pagos = new ArrayList<>();

    public void cargar() {
        // luego CSV
    }

    public void guardar() {
        // luego CSV
    }

    public void registrar(Scanner sc) {
        System.out.print("ID reservación: ");
        String rid = sc.nextLine();
        System.out.print("Monto: ");
        double monto;
        try {
            monto = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Monto inválido.");
            return;
        }
        System.out.print("Método de pago: ");
        String metodo = sc.nextLine();

        Pago p = new Pago(
                UUID.randomUUID().toString(),
                rid,
                monto,
                metodo,
                new Date().toString()
        );
        pagos.add(p);
        System.out.println("Pago registrado: " + p.getId());
    }

    public void listar() {
        if (pagos.isEmpty()) {
            System.out.println("No hay pagos registrados.");
            return;
        }
        pagos.forEach(System.out::println);
    }

    public List<Pago> getPagos() {
        return pagos;
    }
}
