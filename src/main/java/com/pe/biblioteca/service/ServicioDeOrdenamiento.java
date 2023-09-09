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

    public static void ordenarPorPrecio2(Libro[] lb) {
        quickSortPorPrecio(lb, 0, lb.length - 1);
    }

    private static void quickSortPorPrecio(Libro[] lb, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivot = particionPorPrecio(lb, inicio, fin);

            quickSortPorPrecio(lb, inicio, indicePivot - 1);
            quickSortPorPrecio(lb, indicePivot + 1, fin);
        }
    }

    private static int particionPorPrecio(Libro[] lb, int inicio, int fin) {
        double pivot = lb[fin].getPrecio();
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lb[j].getPrecio() <= pivot) {
                i++;
                swap(lb, i, j);
            }
        }

        swap(lb, i + 1, fin);

        return i + 1;
    }

    private static void swap(Libro[] lb, int i, int j) {
        Libro temp = lb[i];
        lb[i] = lb[j];
        lb[j] = temp;
    }
}

