package com.pe.biblioteca.daoimpl;

import com.pe.biblioteca.dao.LoginDao;
import com.pe.biblioteca.db.Conexion;
import com.pe.biblioteca.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Brayan
 */

public class UsuarioDaoImpl implements LoginDao {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public Usuario iniciarSesion(String correo, String contrasena) {
        Usuario user = new Usuario();
        String sql = "SELECT * FROM usuario WHERE email = ? AND contrasena=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setEmail(rs.getString("email"));
                user.setContrasena(rs.getString("contrasena"));
                return user;

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

}
