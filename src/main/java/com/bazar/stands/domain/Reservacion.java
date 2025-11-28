package com.bazar.stands.domain;

public class Reservacion {
    private String id;
    private String vendedorId;
    private String standId;
    private String fechaEvento; // "YYYY-MM-DD"
    private String estado; // ACTIVA/CANCELADA/REPROGRAMADA

    public Reservacion() {
    }

    public Reservacion(String id, String vendedorId, String standId, String fechaEvento, String estado) {
        this.id = id;
        this.vendedorId = vendedorId;
        this.standId = standId;
        this.fechaEvento = fechaEvento;
        this.estado = estado;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getVendedorId() { return vendedorId; }
    public void setVendedorId(String vendedorId) { this.vendedorId = vendedorId; }

    public String getStandId() { return standId; }
    public void setStandId(String standId) { this.standId = standId; }

    public String getFechaEvento() { return fechaEvento; }
    public void setFechaEvento(String fechaEvento) { this.fechaEvento = fechaEvento; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return id + " | Vendedor: " + vendedorId +
                " | Stand: " + standId +
                " | Fecha: " + fechaEvento +
                " | Estado: " + estado;
    }
}
