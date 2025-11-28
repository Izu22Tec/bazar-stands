package com.bazar.stands.service;

import com.bazar.stands.domain.Pago;

import java.util.List;

public class ReporteService {

    private ReservacionService reservacionService;
    private PagoService pagoService;

    public ReporteService() {
    }

    // Llama a este método desde ConsolaMenu para inyectar servicios
    public void configurarServicios(ReservacionService reservacionService, PagoService pagoService) {
        this.reservacionService = reservacionService;
        this.pagoService = pagoService;
    }

    public void reservasPorVendedor() {
        if (reservacionService == null) {
            System.out.println("Servicios de reporte no configurados.");
            return;
        }
        // Por ahora, solo usamos el listar general de reservaciones
        reservacionService.listar();
    }

    public void ingresosTotales() {
        if (pagoService == null) {
            System.out.println("Servicios de reporte no configurados.");
            return;
        }
        List<Pago> pagos = pagoService.getPagos();
        double total = 0.0;
        for (Pago p : pagos) {
            total += p.getMonto();
        }
        System.out.println("Ingresos totales: $" + total);
    }
}
