package com.pe.biblioteca.dao;

import com.pe.biblioteca.modelo.Usuario;

/**
 *
 * @author Brayan
 */
public interface LoginDao {

    Usuario iniciarSesion(String correo, String contrasena);

}
