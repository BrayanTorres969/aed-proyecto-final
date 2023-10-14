package com.pe.biblioteca.modelo;

public class Cliente {
    private int id;
    private String nombre;
    private String dni;
    private String celular;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String dni, String celular, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", nombre:'" + nombre +
                ", dni: " + dni +
                ", telefono: " + celular +
                ", direccion: " + direccion ;
    }
}
