package com.pe.biblioteca.dao;

import com.pe.biblioteca.modelo.Libro;
import java.util.List;

/**
 *
 * @author Brayan
 */
public interface LibroDao {

    public List<Libro> findAll();

    public List<Libro> findAllByTitle(String titulo);

    public Libro searchById(int id);

    public void save(Libro libro);

    public void update(Libro libro);

    public void delete(int id);
}
