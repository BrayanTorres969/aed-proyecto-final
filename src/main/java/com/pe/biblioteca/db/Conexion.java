package com.pe.biblioteca.db;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Brayan
 */

public class Conexion {

    static Dotenv dotenv = Dotenv.load();

    private static final String URL = dotenv.get("URL");
    private static final String DRIVER = dotenv.get("DRIVER");
    private static final String USER = dotenv.get("USER");
    private static final String PASSWORD = dotenv.get("PASSWORD");
    //Patrón de diseño Singleton
    // El campo para almacenar la instancia singleton debe
    // declararse estático.
    private static Connection con = null;

    // El constructor del singleton siempre debe ser privado
    // para evitar llamadas de construcción directas con el
    // operador `new`.
    private Conexion() {

    }

    //Para obtener la instancia unicamente por este metodo
    //La palabra reservada static hace posibler el acceso mediante Class.metodo
    public static Connection conectar() {
        try {
            Class.forName(DRIVER);
            if (con == null) {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error" + e);
        }
        return con;
    }

    public static void cerrar() {
        try {
            if (con != null) {
                con.close();
                con = null; // Establecer a null para que la próxima llamada a getConnection() cree una nueva conexión
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e);
        }
    }

}
