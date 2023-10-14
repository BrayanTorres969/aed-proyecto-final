package com.pe.biblioteca.service.ListaEnlazada;
import com.pe.biblioteca.modelo.Cliente;
public class Nodo {
    Cliente dato;
    Nodo siguiente;

    public Nodo(Cliente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Nodo(Cliente dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
}
