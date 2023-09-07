package com.pe.biblioteca.service;

import com.pe.biblioteca.modelo.Libro;

public class ServicioDeBusqueda {

    public int busquedaSecuencial(Libro[] datos, double precioLibro) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].getPrecio() == precioLibro) {
                return i; //retorna el indice del libro encontrado
            }
        }
        return -1;//retorno cuando no se encuentra el elmento
    }

    public int busquedaBinaria(Libro[] datos, double precioLibro) {
        int izquierda = 0;
        int derecha = datos.length - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            //si el precio esta en el medio
            if (datos[medio].getPrecio() == precioLibro) {
                return medio;
            }
            //Si el precio es mayor, ignoramos la mitad izquierda
            if (datos[medio].getPrecio() < precioLibro) {
                izquierda = medio + 1;
                //si el precio es menor, ignoramos la mitad derecha
            } else {
                derecha = medio - 1;
            }
        }
        //si no se encontro el precio
        return -1;
    }
}
