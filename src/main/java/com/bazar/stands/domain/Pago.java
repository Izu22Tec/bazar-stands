package com.bazar.stands.domain;

public class Pago {

    private String id;
    private String reservacionId;
    private double monto;
    private String metodoPago;
    private String fechaPago;

    public Pago() {
    }

    public Pago(String id, String reservacionId, double monto, String metodoPago, String fechaPago) {
        this.id = id;
        this.reservacionId = reservacionId;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReservacionId() {
        return reservacionId;
    }

    public void setReservacionId(String reservacionId) {
        this.reservacionId = reservacionId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return id + " | Reservación: " + reservacionId +
                " | Monto: $" + monto +
                " | Método: " + metodoPago +
                " | Fecha: " + fechaPago;
    }
}
