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
            limpiarPantalla();
            mostrarBanner();
            mostrarHub();

            System.out.println();
            System.out.println("  MENÚ PRINCIPAL");
            System.out.println("  ──────────────");
            System.out.println("  1) Vendedores");
            System.out.println("  2) Stands");
            System.out.println("  3) Reservaciones");
            System.out.println("  4) Pagos");
            System.out.println("  5) Reportes");
            System.out.println("  6) Salir");
            System.out.print("\n  Elige una opción: ");

            int op = leerEntero();

            switch (op) {
                case 1 -> menuVendedores();
                case 2 -> menuStands();
                case 3 -> menuReservas();
                case 4 -> menuPagos();
                case 5 -> menuReportes();
                case 6 -> {
                    System.out.println("\nGracias por usar el sistema. ¡Hasta luego!");
                    salir = true;
                }
                default -> {
                    System.out.println("Opción inválida. Presiona ENTER para continuar...");
                    scanner.nextLine();
                }
            }
        }
    }

    // ─────────────────────────────────────────────
    //  HUB / PRESENTACIÓN
    // ─────────────────────────────────────────────

    private void mostrarBanner() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║      SISTEMA DE ADMINISTRACIÓN DE STANDS     ║");
        System.out.println("║                \"Bazar Luckys\"               ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    private void mostrarHub() {
        System.out.println();
        System.out.println("  Resumen rápido del sistema");
        System.out.println("  ──────────────────────────");
        System.out.println("  - Gestión de vendedores");
        System.out.println("  - Administración de stands");
        System.out.println("  - Reservaciones por fecha");
        System.out.println("  - Registro de pagos");
        System.out.println("  - Reportes básicos de operación");
    }

    // Intenta limpiar la pantalla (no es perfecto en todas las consolas, pero ayuda)
    private void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ignored) {
        }
    }

    // ─────────────────────────────────────────────
    //  UTILIDAD
    // ─────────────────────────────────────────────

    private int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    // ─────────────────────────────────────────────
    //  MENÚS
    // ─────────────────────────────────────────────

    private void menuVendedores() {
        boolean back = false;
        while (!back) {
            limpiarPantalla();
            System.out.println("=== Módulo de Vendedores ===");
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
            if (!back) {
                System.out.println("\nPresiona ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    private void menuStands() {
        boolean back = false;
        while (!back) {
            limpiarPantalla();
            System.out.println("=== Módulo de Stands ===");
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
            if (!back) {
                System.out.println("\nPresiona ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    private void menuReservas() {
        boolean back = false;
        while (!back) {
            limpiarPantalla();
            System.out.println("=== Módulo de Reservaciones ===");
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
            if (!back) {
                System.out.println("\nPresiona ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    private void menuPagos() {
        boolean back = false;
        while (!back) {
            limpiarPantalla();
            System.out.println("=== Módulo de Pagos ===");
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
            if (!back) {
                System.out.println("\nPresiona ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    private void menuReportes() {
        boolean back = false;
        while (!back) {
            limpiarPantalla();
            System.out.println("=== Módulo de Reportes ===");
            System.out.println("1) Reservas por vendedor (vista básica)");
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
            if (!back) {
                System.out.println("\nPresiona ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }
}

