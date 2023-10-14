package com.pe.biblioteca.service.ListaEnlazada;
import com.pe.biblioteca.modelo.Cliente;
public class Lista {
    Nodo inicio, fin;
    int cont = 0;

    public Lista() {
        inicio = null;
        fin = null;
    }

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

    public void mostrarLista() {
        Nodo aux = inicio;
        while (aux != null) {
            System.out.print("[" + aux.dato + "] \n");
            aux = aux.siguiente;
        }
    }

    public int cantidadNodos() {
        return cont;
    }
}
