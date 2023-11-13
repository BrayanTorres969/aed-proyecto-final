package com.pe.biblioteca.modelo;

/**
 *
 * @author Brayan
 */
public class Detalle {

    private int id;
    private int id_prestamo;
    private int id_libro;
    private int cantidad;

    public Detalle() {
    }

    public Detalle(int id, int id_prestamo, int id_libro, int cantidad) {
        this.id = id;
        this.id_prestamo = id_prestamo;
        this.id_libro = id_libro;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
