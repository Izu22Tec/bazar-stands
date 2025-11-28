package com.bazar.stands.domain;

public class Vendedor {
    private String id;
    private String nombre;
    private String giro;
    private String telefono;
    private String redesSociales;

    public Vendedor() {
    }

    public Vendedor(String id, String nombre, String giro, String telefono, String redesSociales) {
        this.id = id;
        this.nombre = nombre;
        this.giro = giro;
        this.telefono = telefono;
        this.redesSociales = redesSociales;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGiro() { return giro; }
    public void setGiro(String giro) { this.giro = giro; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getRedesSociales() { return redesSociales; }
    public void setRedesSociales(String redesSociales) { this.redesSociales = redesSociales; }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + giro + " | " + telefono;
    }
}
