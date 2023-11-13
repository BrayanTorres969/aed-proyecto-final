package com.pe.biblioteca.modelo;

import java.util.Date;

/**
 *
 * @author Brayan
 */
public class Prestamo {

    private int id;
    private int id_cliente;
    private Date fecha_prestamo;
    private Date fecha_entrega;

    public Prestamo() {
    }

    public Prestamo(int id, int id_cliente, Date fecha_prestamo, Date fecha_entrega) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_entrega = fecha_entrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

}
