package com.pe.biblioteca.daoimpl;

import com.pe.biblioteca.dao.LibroDao;
import com.pe.biblioteca.db.Conexion;
import com.pe.biblioteca.modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class LibroDaoImpl implements LibroDao {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Libro> findAll() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libro ORDER BY id ASC";
        try {

            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setCategoria(rs.getString("categoria"));
                libro.setAnhoPublicacion(rs.getInt("anho_publicacion"));
                libro.setStock(rs.getInt("stock"));
                libros.add(libro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return libros;
    }

    @Override
    public void save(Libro libro) {
        String sql = "INSERT INTO libro (titulo,autor,categoria,anho_publicacion,stock)VALUES(?,?,?,?,?)";

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getCategoria());
            ps.setInt(4, libro.getAnhoPublicacion());
            ps.setInt(5, libro.getStock());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
    }

    @Override
    public Libro searchById(int id) {
        Libro libro = null;
        String sql = "SELECT * FROM libro WHERE id = ?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setCategoria(rs.getString("categoria"));
                libro.setAnhoPublicacion(rs.getInt("anho_publicacion"));
                libro.setStock(rs.getInt("stock"));
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return libro;
    }

    @Override
    public void update(Libro libroActualizado) {
        String sql = "UPDATE libro SET titulo = ?,autor = ?,categoria=?,anho_publicacion=?,stock=? WHERE id =?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, libroActualizado.getTitulo());
            ps.setString(2, libroActualizado.getAutor());
            ps.setString(3, libroActualizado.getCategoria());
            ps.setInt(4, libroActualizado.getAnhoPublicacion());
            ps.setInt(5, libroActualizado.getStock());
            ps.setInt(6, libroActualizado.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM libro WHERE id =?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
    }

    @Override
    public List<Libro> findAllByTitle(String titulo) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libro WHERE LOWER(titulo) LIKE '%" + titulo + "%'";
        try {

            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setCategoria(rs.getString("categoria"));
                libro.setAnhoPublicacion(rs.getInt("anho_publicacion"));
                libro.setStock(rs.getInt("stock"));
                libros.add(libro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return libros;
    }

}
