package com.pe.biblioteca.principal;

import com.pe.biblioteca.modelo.Libro;
import com.pe.biblioteca.modelo.Servicios;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int eleccion;
        Libro lb1 = new Libro("Cien años de Soledad", 45.50);
        Libro lb2 = new Libro( "Dragon Ball", 10.5);
        Libro lb3 = new Libro("Sin nombre", 30.2);
        Libro[] arreglo ={lb1,lb2,lb3};
        //menu
        System.out.println("Bienbenido a la Biblioteca ");
        System.out.println("Elega una ordenar los libros");
        System.out.println("1= burbuja");
        eleccion =sc.nextInt();
        switch (eleccion){
            case 1:
                Servicios.ordenarPorPrecio(arreglo);
            case 2:;
            case 3:;
            default:;
        }
        //mostrar datos
        for (Libro libro : arreglo) {
            System.out.println("Nombre: " + libro.getNombre() + "\nPrecio: " + libro.getPrecio());
            System.out.println("--------------");
        }
    }
}
