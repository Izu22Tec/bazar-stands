package com.bazar.stands.ui;

import com.bazar.stands.service.*;
import java.util.Scanner;

public class ConsolaMenu {

    private final AuthService authService;
    private final VendedorService vendedorService;
    private final StandService standService;
    private final ReservacionService reservacionService;
    private final PagoService pagoService;
    private final ReporteService reporteService;

    private final Scanner scanner = new Scanner(System.in);

    public ConsolaMenu() {
        this.authService = new AuthService();
        this.vendedorService = new VendedorService();
        this.standService = new StandService();
        this.reservacionService = new ReservacionService(vendedorService, standService);
        this.pagoService = new PagoService();
        this.reporteService = new ReporteService();

        this.reporteService.configurarServicios(reservacionService, pagoService);
    }

    public void iniciar() {
        // luego conectamos con CSV, por ahora solo en memoria
        authService.cargarAdmins();
        vendedorService.cargar();
        standService.cargar();
        reservacionService.cargar();
        pagoService.cargar();

        if (!authService.login(scanner)) {
            System.out.println("Saliendo del sistema.");
            return;
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Sistema de Stands de Bazar ===");
            System.out.println("1) Vendedores");
            System.out.println("2) Stands");
            System.out.println("3) Reservaciones");
            System.out.println("4) Pagos");
            System.out.println("5) Reportes");
            System.out.println("6) Salir (sin guardar por ahora)");
            System.out.print("Opción: ");
            int op = leerEntero();

            switch (op) {
                case 1 -> menuVendedores();
                case 2 -> menuStands();
                case 3 -> menuReservas();
                case 4 -> menuPagos();
                case 5 -> menuReportes();
                case 6 -> {
                    System.out.println("Adiós.");
                    salir = true;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void menuVendedores() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Vendedores ---");
            System.out.println("1) Alta");
            System.out.println("2) Listar");
            System.out.println("3) Editar");
            System.out.println("4) Eliminar");
            System.out.println("5) Volver");
            System.out.print("Opción: ");
            int op = leerEntero();
            switch (op) {
                case 1 -> vendedorService.alta(scanner);
                case 2 -> vendedorService.listar();
                case 3 -> vendedorService.editar(scanner);
                case 4 -> vendedorService.eliminar(scanner);
                case 5 -> back = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void menuStands() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Stands ---");
            System.out.println("1) Alta");
            System.out.println("2) Listar");
            System.out.println("3) Editar");
            System.out.println("4) Cambiar disponibilidad");
            System.out.println("5) Volver");
            System.out.print("Opción: ");
            int op = leerEntero();
            switch (op) {
                case 1 -> standService.alta(scanner);
                case 2 -> standService.listar();
                case 3 -> standService.editar(scanner);
                case 4 -> standService.cambiarDisponibilidad(scanner);
                case 5 -> back = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void menuReservas() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Reservaciones ---");
            System.out.println("1) Crear reservación");
            System.out.println("2) Listar reservaciones");
            System.out.println("3) Cancelar reservación");
            System.out.println("4) Volver");
            System.out.print("Opción: ");
            int op = leerEntero();
            switch (op) {
                case 1 -> reservacionService.crear(scanner);
                case 2 -> reservacionService.listar();
                case 3 -> reservacionService.cancelar(scanner);
                case 4 -> back = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void menuPagos() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Pagos ---");
            System.out.println("1) Registrar pago");
            System.out.println("2) Listar pagos");
            System.out.println("3) Volver");
            System.out.print("Opción: ");
            int op = leerEntero();
            switch (op) {
                case 1 -> pagoService.registrar(scanner);
                case 2 -> pagoService.listar();
                case 3 -> back = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void menuReportes() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Reportes ---");
            System.out.println("1) Reservas por vendedor");
            System.out.println("2) Ingresos totales");
            System.out.println("3) Volver");
            System.out.print("Opción: ");
            int op = leerEntero();
            switch (op) {
                case 1 -> reporteService.reservasPorVendedor();
                case 2 -> reporteService.ingresosTotales();
                case 3 -> back = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
