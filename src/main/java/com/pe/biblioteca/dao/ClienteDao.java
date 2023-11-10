package com.pe.biblioteca.dao;

import com.pe.biblioteca.modelo.Cliente;
import java.util.List;

/**
 *
 * @author Brayan
 */
public interface ClienteDao {

    public List<Cliente> findAll();

    public List<Cliente> findAllByNombre(String nombre);

    public Cliente findById(int id);

    public void save(Cliente cliente);

    public void update(Cliente cliente);

    public void delete(int id);

    public Cliente searchClientByDNI(int dni);

}
