package com.pe.biblioteca.service.Pilas;

import com.pe.biblioteca.modelo.Libro;
import java.util.Stack;

public class PilaLibros {

    private Stack<Libro> libros;

    public PilaLibros() {
        this.libros = new Stack<>();
    }

    //getter
    public Stack<Libro> getLibros() {
        return libros;
    }

    //Métodos
    public void apilarLibro(Libro libro) {
        libros.push(libro);
        System.out.println("Libro apilado: " + libro.getTitulo());
    }

    public void desapilarLibro() {
        if (!libros.isEmpty()) {
            Libro libroDesapilado = libros.pop();
            System.out.println("Libro desapilado: " + libroDesapilado.getTitulo());
        } else {
            System.out.println("La pila de libros está vacía.");
        }
    }

    public void elminarLibro(int id) {
        Stack<Libro> tempPila = new Stack<>();

        while (!libros.isEmpty()) {
            Libro libro = libros.pop();
            if (libro.getId() != id) {
                tempPila.push(libro);
            }
        }

        while (!tempPila.isEmpty()) {
            libros.push(tempPila.pop());
        }
    }

}
