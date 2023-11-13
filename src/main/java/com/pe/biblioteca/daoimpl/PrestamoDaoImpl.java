package com.pe.biblioteca.daoimpl;

import com.pe.biblioteca.dao.PrestamoDao;
import com.pe.biblioteca.db.Conexion;
import com.pe.biblioteca.modelo.Detalle;
import com.pe.biblioteca.modelo.Prestamo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class PrestamoDaoImpl implements PrestamoDao {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int r;

    @Override
    public List<HashMap<String, Object>> findAll() {
        String sql = "SELECT p.id,c.nombre as cliente ,p.fecha_prestamo,p.fecha_entrega\n"
                + "FROM prestamo as p\n"
                + "JOIN cliente as c ON p.id_cliente = c.id;";

        List<HashMap<String, Object>> lista = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                HashMap<String, Object> map = new HashMap<>();

                map.put("id", rs.getInt(1));
                map.put("cliente", rs.getString(2));
                map.put("fecha_prestamo", rs.getString(3));
                map.put("fecha_entrega", rs.getString(4));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return lista;

    }

    @Override
    public int save(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo (id_cliente) VALUES (?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, prestamo.getId_cliente());
            r = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return r;
    }

    @Override
    public void registerBorrowedDetail(Detalle detalle) {
        String sql = "INSERT INTO detalle_prestamo (id_prestamo,id_libro,cantidad) VALUES (?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getId_prestamo());
            ps.setInt(2, detalle.getId_libro());
            ps.setInt(3, detalle.getCantidad());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
    }

    @Override
    public int getIdNewBorrowed() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM prestamo";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return id;

    }

    @Override
    public void updateStock(int cant, int id) {
        String sql = "UPDATE libro SET stock = ? WHERE id = ?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
    }

    @Override
    public List<HashMap<String, Object>> findBooksBorrowedByCliente(int idCliente) {
        String sql = "SELECT d.id_libro,l.titulo,d.cantidad\n"
                + "FROM prestamo p\n"
                + "INNER JOIN detalle_prestamo d ON p.id = d.id_prestamo\n"
                + "INNER JOIN libro l ON d.id_libro = l.id\n"
                + "WHERE p.id_cliente = ? AND p.estado=0";
        List<HashMap<String, Object>> lista = new ArrayList<>();

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            while (rs.next()) {

                HashMap<String, Object> map = new HashMap<>();

                map.put("id_libro", rs.getInt(1));
                map.put("titulo", rs.getString(2));
                map.put("cantidad", rs.getString(3));
                lista.add(map);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Conexion.cerrar();
        }

        return lista;
    }

    @Override
    public int getIdBorrowedByClientId(int idCliente) {
        int id = 0;
        String sql = "SELECT id FROM prestamo WHERE id_cliente =?";

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return id;

    }

    public int getCantidadPrestamosByClientId(int idCliente) {
        int cantidad = 0;
        String sql = "SELECT COUNT(*) FROM prestamo WHERE id_cliente = ? AND estado=0";

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            if (rs.next()) {
                cantidad = rs.getInt(1);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }

        return cantidad;
    }

    @Override
    public boolean updateState(int id_prestamo) {

        String sql = "UPDATE prestamo SET estado = 1,fecha_entrega=NOW() WHERE id=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_prestamo);
            int rowsAffected = ps.executeUpdate(); // Usar executeUpdate() para obtener la cantidad de filas afectadas
            return rowsAffected > 0; // Devolver true si se actualizaron filas
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }

        return false;

    }

}
