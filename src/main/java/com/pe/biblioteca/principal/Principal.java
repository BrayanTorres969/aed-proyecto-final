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
    static Libro arreglo[] ;
    public static void main(String[] args) {
        int seguir;

        RegistrarLibros();

        do {
            System.out.println("*****************************");
            Menu();

            System.out.println("1 regresara a menu \n2 Salir");
            seguir= sc.nextInt();

        } while (seguir!=2);
    }

    public static void RegistrarLibros(){
        int cont=0;
        String nombre;
        double precio;
        System.out.print("Ingrse cantidad de libros a registrar: ");
        cantLibros = sc.nextInt();
        arreglo = new Libro[cantLibros];

        while (cont <= cantLibros-1) {

            System.out.print("Ingrese nombre del libro "+(cont+1)+": ");
            nombre = sc.next();sc.nextLine();
            System.out.print("Ingrese precio del libro "+(cont+1)+": ");
            precio = sc.nextDouble();
            arreglo[cont]= new Libro(nombre, precio);
            cont++;
        }
    }
    //menu General
    public static void Menu(){
        System.out.println("Bienvenido a la Biblioteca Secreta ");
        System.out.println("¿Que desea Realizar? \n1 Ordenar todos los libros \n2 buscar libro");
        eleccion =sc.nextInt();
        switch (eleccion) {
            case 1:
                OrdenarLibro();
                break;
            case 2:
                BuscarLibro();
                break;
            default:
                throw new AssertionError();
        }
    }
    public static void OrdenarLibro(){
        System.out.println("Por que metodo desea ordenar los libros? \n1 Metodo Burbuja \n2 Metodo QuikSort");
        int op = sc.nextInt();
        if (op==1) {
            sdo.ordenarPorPrecio(arreglo);
            MostrarDatos();
        }else if (op==2) {
            System.out.println("Codigo de Niki Nicol");
        }

    }

    public static void BuscarLibro(){

        System.out.println("Por que metodo desea buscar los libros? \n1 Metodo Secuencial \n2 Metodo Binario");
        int op = sc.nextInt();
        if (op==1) {
            System.out.println("Ingrese precio del libro a buscar");
            double pres=sc.nextDouble();
            int result = sb.busquedaSecuencial(arreglo, pres);
            if (result==-1) {
                System.out.println("El libro con el precio "+ pres +" no esta en el arreglo");
            }else{
                System.out.println("El Libro que buscas con el precio "+ pres + " esta en la posicion "+ (result+1) );
            }
        }else if (op==2) {
            System.out.println("Ingrese precio del libro a buscar");
            double pres=sc.nextDouble();
            int result = sb.busquedaBinaria(arreglo, pres);
            if (result==-1) {
                System.out.println("El libro con el precio "+ pres +" no esta en el arreglo");
            }else{
                System.out.println("El Libro que buscas con el precio "+ pres + " esta en la posicion "+ (result+1) );
            }
        }

    }

    public static void MostrarDatos(){
        for (Libro libro : arreglo) {
            System.out.println("Nombre: " + libro.getNombre() + "\nPrecio: " + libro.getPrecio());
            System.out.println("--------------");
        }
    }
}
