package com.pe.biblioteca.daoimpl;

import com.pe.biblioteca.dao.ClienteDao;
import com.pe.biblioteca.db.Conexion;
import com.pe.biblioteca.modelo.Cliente;

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
public class ClienteDaoImpl implements ClienteDao {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {

            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDni(rs.getString("dni"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDireccion(rs.getString("direccion"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return clientes;
    }

    @Override
    public Cliente findById(int id) {
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM cliente WHERE id=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDni(rs.getString("dni"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return cliente;
    }

    @Override
    public void save(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre,dni,celular,direccion)VALUES(?,?,?,?)";

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDni());
            ps.setString(3, cliente.getCelular());
            ps.setString(4, cliente.getDireccion());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre = ?,dni = ?,celular=?,direccion=? WHERE id =?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDni());
            ps.setString(3, cliente.getCelular());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM cliente WHERE id =?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public List<Cliente> findAllByNombre(String nombre) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE LOWER(nombre) LIKE '%" + nombre + "%'";
        try {

            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDni(rs.getString("dni"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDireccion(rs.getString("direccion"));
                clientes.add(cliente);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return clientes;
    }

    @Override
    public Cliente searchClientByDNI(int dni) {
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM cliente WHERE dni::integer=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDni(rs.getString("dni"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDireccion(rs.getString("direccion"));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            Conexion.cerrar();
        }
        return cliente;
    }

}
