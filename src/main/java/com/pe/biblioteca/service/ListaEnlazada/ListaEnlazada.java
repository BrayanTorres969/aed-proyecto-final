package com.pe.biblioteca.service.ListaEnlazada;

import com.pe.biblioteca.modelo.Cliente;

public class ListaEnlazada {

    private Nodo inicio, fin;
    private int cont = 0;

    public ListaEnlazada() {
        inicio = null;
        fin = null;
    }

    //Getters y Setters
    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    //Métodos
    public void agregarAlInicio(Cliente dato) {
        cont++;
        if (estaVacia()) {
            inicio = new Nodo(dato, inicio);
            fin = inicio;
        } else {
            inicio = new Nodo(dato, inicio);
        }
    }

    public void agregarAlFinal(Cliente dato) {
        cont++;
        if (estaVacia()) {
            inicio = new Nodo(dato);
            fin = inicio;
        } else {
            fin.siguiente = new Nodo(dato);
            fin = fin.siguiente;
        }
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int cantidadNodos() {
        return cont;
    }

    public void eliminarNodo(int id) {
        Nodo aux = inicio;
        Nodo anterior = null;

        while (aux != null) {
            Cliente cliente = aux.getDato();

            if (cliente.getId() == id) {
                if (anterior != null) {
                    anterior.setSiguiente(aux.getSiguiente());
                } else {
                    setInicio(aux.getSiguiente());
                }
                break; // Elemento encontrado y eliminado, sal del bucle
            }

            anterior = aux;
            aux = aux.getSiguiente();
        }
    }
}
