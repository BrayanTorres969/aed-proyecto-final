package com.pe.biblioteca.service;

import com.pe.biblioteca.modelo.Libro;

public class ServicioDeOrdenamiento {


    //ordenamiento burbuja por precio
    public static void ordenarPorPrecio(Libro[] lb) {
        int n = lb.length;
        for (int i = 0; i < lb.length - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lb[j].getPrecio() > lb[j + 1].getPrecio()) {
                    Libro temp = lb[j];
                    lb[j] = lb[j + 1];
                    lb[j + 1] = temp;
                }
            }
        }
    }


}
