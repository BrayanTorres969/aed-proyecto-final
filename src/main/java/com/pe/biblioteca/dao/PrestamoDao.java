package com.pe.biblioteca.dao;

import com.pe.biblioteca.modelo.Detalle;
import com.pe.biblioteca.modelo.Prestamo;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Brayan
 */
public interface PrestamoDao {

    public List<HashMap<String, Object>> findAll();

    public int save(Prestamo prestamo);

    public void registerBorrowedDetail(Detalle detalle);

    public boolean updateState(int id_prestamo);

    public List<HashMap<String, Object>> findBooksBorrowedByCliente(int idCliente);

    public void updateStock(int cant, int id);

    public int getIdBorrowedByClientId(int idCliente);

    public int getCantidadPrestamosByClientId(int idCliente);

    public int getIdNewBorrowed();

}
