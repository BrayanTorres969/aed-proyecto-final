package com.pe.biblioteca.principal;

import com.pe.biblioteca.modelo.Libro;
import com.pe.biblioteca.service.ServicioDeOrdenamiento;
import com.pe.biblioteca.service.ServicioDeBusqueda;


import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    static int eleccion, cantLibros;
    static ServicioDeBusqueda sb = new ServicioDeBusqueda();
    static ServicioDeOrdenamiento sdo = new ServicioDeOrdenamiento();
    static Libro arreglo[];
    /*
    public static void main(String[] args) {
        int seguir;

        RegistrarLibros();

        do {
            Menu();
            System.out.println("----------------------------");
            System.out.println("1 Menú principal \n2 Salir");
            seguir = sc.nextInt();

        } while (seguir != 2);
    }

    public static void RegistrarLibros() {
        int cont = 0;
        String nombre;
        double precio;
        do {
            System.out.print("Ingrese la cantidad de libros a registrar: ");
            cantLibros = sc.nextInt();
            sc.nextLine();// Consume el carácter de salto de línea pendiente
            if (cantLibros <= 0) {
                System.out.println("La cantidad de libros debe ser un número positivo mayor a 0");
            }
        } while (cantLibros <= 0);

        arreglo = new Libro[cantLibros];

        while (cont <= cantLibros - 1) {

            System.out.print("Ingrese nombre del libro " + (cont + 1) + ": ");
            nombre = sc.nextLine();
            System.out.print("Ingrese precio del libro " + (cont + 1) + ": ");
            precio = sc.nextDouble(); // Consume el carácter de salto de línea pendiente después de nextDouble()
            sc.nextLine();
            arreglo[cont] = new Libro(nombre, precio);
            cont++;
        }
    }

    //menu General
    public static void Menu() {
        System.out.println("   ,   ,\n" +
                "  /////| \n" +
                " ///// |  ___  _ ____ _  _ _  _ ____ _  _ _ ___  ____    ____    _    ____                \t\t  \n" +
                "|~~~|  |  |__] | |___ |\\ | |  | |___ |\\ | | |  \\ |  |    |__|    |    |__|\n" +
                "|===|  |  |__] | |___ | \\|  \\/  |___ | \\| | |__/ |__|    |  |    |___ |  |\t\n" +
                "|P  |  |  ___  _ ___  _    _ ____ ___ ____ ____ ____    ____ ____ ____ ____ ____ ___ ____ \t \t\n" +
                "| R |  |  |__] | |__] |    | |  |  |  |___ |    |__|    [__  |___ |    |__/ |___  |  |__|\n" +
                "|  T| /   |__] | |__] |___ | |__|  |  |___ |___ |  |    ___] |___ |___ |  \\ |___  |  |  | \n" +
                "|===|/\n" +
                "'---'\t");
        System.out.println("\n¿Qué desea Realizar? \n1 Ordenar todos los libros \n2 Buscar libro \n3 Regresar");
        eleccion = sc.nextInt();
        switch (eleccion) {
            case 1:
                OrdenarLibro();
                break;
            case 2:
                BuscarLibro();
                break;
            case 3:
                break;
            default:
                System.out.println("Por favor ingrese una opción válida.");
                Menu(); // Vuelve a mostrar el menú en caso de opción inválida
                break;
        }
    }

    public static void OrdenarLibro() {
        System.out.println("¿Qué método desea utilizar para ordenar los libros? \n1 Método Burbuja \n2 Método " +
                "QuikSort");
        int op = sc.nextInt();
        if (op == 1) {
            sdo.ordenarPorPrecio(arreglo);
            MostrarDatos();
        } else if (op == 2) {
          sdo.ordenarPorPrecio2(arreglo);
          MostrarDatos();
        }

    }

    public static void BuscarLibro() {

        System.out.println("¿Por qué método desea buscar los libros? \n1 Método Secuencial \n2 Método Binario");
        int op = sc.nextInt();
        if (op == 1) {
            System.out.println("Ingrese el precio del libro a buscar");
            double precioBuscar = sc.nextDouble();
            int result = sb.busquedaSecuencial(arreglo, precioBuscar);
            if (result == -1) {
                System.out.println("El libro con el precio " + precioBuscar + " no esta en el arreglo");
            } else {
                System.out.println("El libro que buscas con el precio " + precioBuscar + " esta en la posicion " + (result + 1));
            }
        } else if (op == 2) {
            System.out.println("Ingrese precio del libro a buscar");

            double precioBuscar = sc.nextDouble();
            sdo.ordenarPorPrecio(arreglo);
            int result = sb.busquedaBinaria(arreglo, precioBuscar);
            if (result == -1) {
                System.out.println("El libro con el precio " + precioBuscar + " no esta en el arreglo");
            } else {
                System.out.println("El Libro que buscas con el precio " + precioBuscar + " esta en la posicion " + (result + 1));
            }
        }

    }

    public static void MostrarDatos() {
        for (Libro libro : arreglo) {
            System.out.println("Nombre: " + libro.getNombre() + "\nPrecio: " + libro.getPrecio());
            System.out.println("--------------");
        }
    }
*/
}
