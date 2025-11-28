package com.bazar.stands.domain;

public class Stand {
    private String id;
    private String numero;
    private String tamano;
    private double precio;
    private String ubicacion;
    private boolean disponible;

    public Stand() {
    }

    public Stand(String id, String numero, String tamano, double precio, String ubicacion, boolean disponible) {
        this.id = id;
        this.numero = numero;
        this.tamano = tamano;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.disponible = disponible;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getTamano() { return tamano; }
    public void setTamano(String tamano) { this.tamano = tamano; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return id + " | Stand " + numero + " | " + tamano + " | $" + precio + " | " +
                (disponible ? "DISPONIBLE" : "NO DISPONIBLE");
    }
}
