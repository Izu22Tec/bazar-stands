package com.bazar.stands.service;

import com.bazar.stands.domain.Reservacion;
import com.bazar.stands.domain.Stand;

import java.util.*;

public class ReservacionService {

    private final VendedorService vendedorService;
    private final StandService standService;
    private final List<Reservacion> reservaciones = new ArrayList<>();

    public ReservacionService(VendedorService vendedorService, StandService standService) {
        this.vendedorService = vendedorService;
        this.standService = standService;
    }

    public void cargar() {
        // luego CSV
    }

    public void guardar() {
        // luego CSV
    }

    public void crear(Scanner sc) {
        System.out.print("ID vendedor: ");
        String vid = sc.nextLine();
        if (vendedorService.buscarPorId(vid) == null) {
            System.out.println("Vendedor no encontrado.");
            return;
        }

        System.out.print("ID stand: ");
        String sid = sc.nextLine();
        Stand stand = standService.buscarPorId(sid);
        if (stand == null) {
            System.out.println("Stand no encontrado.");
            return;
        }

        System.out.print("Fecha del evento (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        boolean ocupado = reservaciones.stream()
                .anyMatch(r -> r.getStandId().equals(sid)
                        && r.getFechaEvento().equals(fecha)
                        && r.getEstado().equals("ACTIVA"));
        if (ocupado) {
            System.out.println("El stand ya está reservado en esa fecha.");
            return;
        }

        Reservacion r = new Reservacion(
                UUID.randomUUID().toString(),
                vid,
                sid,
                fecha,
                "ACTIVA"
        );
        reservaciones.add(r);
        System.out.println("Reservación creada: " + r.getId());
    }

    public void listar() {
        if (reservaciones.isEmpty()) {
            System.out.println("No hay reservaciones.");
            return;
        }
        reservaciones.forEach(System.out::println);
    }

    public void cancelar(Scanner sc) {
        System.out.print("ID reservación: ");
        String id = sc.nextLine();
        Optional<Reservacion> opt = reservaciones.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
        if (opt.isEmpty()) {
            System.out.println("No encontrada.");
            return;
        }
        Reservacion r = opt.get();
        r.setEstado("CANCELADA");
        System.out.println("Reservación cancelada.");
    }

    public List<Reservacion> getReservaciones() {
        return reservaciones;
    }
}
