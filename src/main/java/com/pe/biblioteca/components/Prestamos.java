package com.pe.biblioteca.components;

import com.pe.biblioteca.dao.ClienteDao;
import com.pe.biblioteca.dao.LibroDao;
import com.pe.biblioteca.dao.PrestamoDao;
import com.pe.biblioteca.daoimpl.ClienteDaoImpl;
import com.pe.biblioteca.daoimpl.LibroDaoImpl;
import com.pe.biblioteca.daoimpl.PrestamoDaoImpl;
import com.pe.biblioteca.modelo.Cliente;
import com.pe.biblioteca.modelo.Detalle;
import com.pe.biblioteca.modelo.Libro;
import com.pe.biblioteca.modelo.Prestamo;
import com.pe.biblioteca.utils.Evento;

import com.pe.biblioteca.vista.Sistema;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brayan
 */
public class Prestamos extends javax.swing.JPanel {

    LibroDao libroDao = new LibroDaoImpl();
    ClienteDao clienteDao = new ClienteDaoImpl();
    PrestamoDao prestamoDao = new PrestamoDaoImpl();

    Libro libro = new Libro();
    Cliente cliente = new Cliente();
    Prestamo prestamo = new Prestamo();
    Detalle detalle = new Detalle();

    Evento eventos = new Evento();
    int item;

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();

    public Prestamos() {
        initComponents();
        InitStyles();
        lblIdClientePrestamo.setVisible(false);
    }

    public void InitStyles() {
        tablaPrestamos.setRowSelectionAllowed(true);
    }

    private void limpiarForm() {
        txtIdLibroPrestamo.setText("");
        txtTituloLibroPrestamo.setText("");
        lblStock.setText("");
    }

    private void limpiarClientePrestamo() {
        txtDniClientePrestamo.setText("");
        lblNombreClientePrestamo.setText("");
        lblIdClientePrestamo.setText("");
    }

    private void limpiarTablaPrestamo() {
        tmp = (DefaultTableModel) tablaPrestamos.getModel();
        int fila = tablaPrestamos.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }

    private void registrarPrestamo() {
        int cliente = Integer.parseInt(lblIdClientePrestamo.getText());
        prestamo.setId_cliente(cliente);
        int respuesta = prestamoDao.save(prestamo);
        if (respuesta != 1) {
            JOptionPane.showMessageDialog(null, "Error al registrar préstamo",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Préstamo registrado");
    }

    private void registrarDetalle() {
        int id_prestamo = prestamoDao.getIdNewBorrowed();

        for (int i = 0; i < tablaPrestamos.getRowCount(); i++) {
            int id_libro = Integer.parseInt(tablaPrestamos.getValueAt(i, 0).toString());
            int cant = Integer.parseInt(tablaPrestamos.getValueAt(i, 3).toString());

            detalle.setId_libro(id_libro);
            detalle.setCantidad(cant);
            detalle.setId_prestamo(id_prestamo);
            //cambiar esta parte si el metodo cambio de nombre
            prestamoDao.registerBorrowedDetail(detalle);
        }
    }

    private void actualizarStock() {
        for (int i = 0; i < tablaPrestamos.getRowCount(); i++) {
            int id = Integer.parseInt(tablaPrestamos.getValueAt(i, 0).toString());
            int cant = Integer.parseInt(tablaPrestamos.getValueAt(i, 3).toString());
            int stockAnt = libroDao.searchById(id).getStock();
            int stockActual = stockAnt - cant;
            prestamoDao.updateStock(stockActual, id);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        txtIdLibroPrestamo = new javax.swing.JTextField();
        btnAgregarLibro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();
        btnRegistrarPrestamo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTituloLibroPrestamo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDniClientePrestamo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblNombreClientePrestamo = new javax.swing.JLabel();
        lblIdClientePrestamo = new javax.swing.JLabel();
        btnEliminarFila = new javax.swing.JButton();

        bg.setBackground(new java.awt.Color(249, 245, 235));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        titulo.setForeground(new java.awt.Color(96, 126, 170));
        titulo.setText("Registros de préstamos");

        txtIdLibroPrestamo.setBorder(null);
        txtIdLibroPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdLibroPrestamoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdLibroPrestamoKeyTyped(evt);
            }
        });

        btnAgregarLibro.setBackground(new java.awt.Color(28, 56, 121));
        btnAgregarLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregarLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarLibro.setText("Agregar");
        btnAgregarLibro.setBorderPainted(false);
        btnAgregarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroActionPerformed(evt);
            }
        });

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Autor", "Unidad"
            }
        ));
        tablaPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaPrestamos.setFocusable(false);
        tablaPrestamos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaPrestamos);
        if (tablaPrestamos.getColumnModel().getColumnCount() > 0) {
            tablaPrestamos.getColumnModel().getColumn(0).setMinWidth(35);
            tablaPrestamos.getColumnModel().getColumn(0).setPreferredWidth(35);
            tablaPrestamos.getColumnModel().getColumn(0).setMaxWidth(35);
            tablaPrestamos.getColumnModel().getColumn(3).setMinWidth(100);
            tablaPrestamos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablaPrestamos.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        btnRegistrarPrestamo.setBackground(new java.awt.Color(28, 56, 121));
        btnRegistrarPrestamo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrarPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarPrestamo.setText("Registrar");
        btnRegistrarPrestamo.setBorderPainted(false);
        btnRegistrarPrestamo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPrestamoActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(96, 126, 170));
        jLabel1.setText("ID:");

        jLabel2.setForeground(new java.awt.Color(96, 126, 170));
        jLabel2.setText("Título");

        txtTituloLibroPrestamo.setBorder(null);

        jLabel3.setForeground(new java.awt.Color(96, 126, 170));
        jLabel3.setText("Stock disponible: ");

        lblStock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel4.setForeground(new java.awt.Color(96, 126, 170));
        jLabel4.setText("DNI:");

        txtDniClientePrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniClientePrestamoActionPerformed(evt);
            }
        });
        txtDniClientePrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniClientePrestamoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniClientePrestamoKeyTyped(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(96, 126, 170));
        jLabel5.setText("Nombre: ");

        lblNombreClientePrestamo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnEliminarFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/borrar.png"))); // NOI18N
        btnEliminarFila.setBorderPainted(false);
        btnEliminarFila.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFilaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(txtDniClientePrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreClientePrestamo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIdClientePrestamo)
                        .addGap(155, 155, 155)
                        .addComponent(btnRegistrarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bgLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblStock))
                        .addGroup(bgLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(67, 67, 67)
                            .addComponent(jLabel5))
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtIdLibroPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(txtTituloLibroPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAgregarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminarFila))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(325, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdLibroPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarLibro)
                    .addComponent(txtTituloLibroPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarFila))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblStock))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDniClientePrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreClientePrestamo)
                    .addComponent(btnRegistrarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdClientePrestamo))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPrestamoActionPerformed
        // TODO add your handling code here:
        if (tablaPrestamos.getRowCount() > 0) {
            if (!"".equals(lblNombreClientePrestamo.getText())) {
                int id_cliente = Integer.parseInt(lblIdClientePrestamo.getText());
                int cantidad = prestamoDao.getCantidadPrestamosByClientId(id_cliente);
                if (cantidad == 0) {
                    registrarPrestamo();
                    registrarDetalle();
                    actualizarStock();
                    limpiarTablaPrestamo();
                    limpiarClientePrestamo();

                } else {
                    JOptionPane.showMessageDialog(null, "Tiene préstamo pendiente");
                    limpiarTablaPrestamo();
                    limpiarClientePrestamo();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Debes buscar un cliente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros");
        }
    }//GEN-LAST:event_btnRegistrarPrestamoActionPerformed

    private void btnAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroActionPerformed

        if (!"".equals(txtTituloLibroPrestamo.getText())) {
            int id_libro = Integer.parseInt(txtIdLibroPrestamo.getText());
            libro = libroDao.searchById(id_libro);
            String titulo = libro.getTitulo();
            String autor = libro.getAutor();
            int cant = 1;
            int stock = Integer.parseInt(lblStock.getText());
            if (stock >= cant) {
                item = item + 1;
                tmp = (DefaultTableModel) tablaPrestamos.getModel();
                for (int i = 0; i < tablaPrestamos.getRowCount(); i++) {
                    if (tablaPrestamos.getValueAt(i, 1).equals(txtTituloLibroPrestamo.getText())) {
                        JOptionPane.showMessageDialog(null, "El libro ya esta registrado");
                        limpiarForm();
                        txtIdLibroPrestamo.requestFocus();
                        return;
                    }
                }
                ArrayList lista = new ArrayList();
                lista.add(item);
                lista.add(id_libro);
                lista.add(titulo);
                lista.add(autor);
                lista.add(cant);

                Object[] O = new Object[4];
                O[0] = lista.get(1);
                O[1] = lista.get(2);
                O[2] = lista.get(3);
                O[3] = lista.get(4);
                tmp.addRow(O);
                tablaPrestamos.setModel(tmp);
                limpiarForm();
                txtIdLibroPrestamo.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Stock no disponible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un libro valido");
        }
    }//GEN-LAST:event_btnAgregarLibroActionPerformed

    private void txtIdLibroPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdLibroPrestamoKeyTyped
        // TODO add your handling code here:
        eventos.numberKeyPress(evt);
    }//GEN-LAST:event_txtIdLibroPrestamoKeyTyped

    private void txtIdLibroPrestamoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdLibroPrestamoKeyPressed
        // TODO add your handling code here:
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (!"".equals(txtIdLibroPrestamo.getText())) {
                    int id = Integer.parseInt(txtIdLibroPrestamo.getText());
                    libro = libroDao.searchById(id);
                    if (libro != null) {
                        txtTituloLibroPrestamo.setText("" + libro.getTitulo());
                        lblStock.setText("" + libro.getStock());
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe libro con ese id");
                        limpiarForm();
                        txtIdLibroPrestamo.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese el id del libro");
                    txtIdLibroPrestamo.requestFocus();
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_txtIdLibroPrestamoKeyPressed

    private void txtDniClientePrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniClientePrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniClientePrestamoActionPerformed

    private void btnEliminarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFilaActionPerformed
        // TODO add your handling code here:
        if (tablaPrestamos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
            return;
        }
        modelo = (DefaultTableModel) tablaPrestamos.getModel();
        modelo.removeRow(tablaPrestamos.getSelectedRow());
        txtIdLibroPrestamo.requestFocus();
    }//GEN-LAST:event_btnEliminarFilaActionPerformed

    private void txtDniClientePrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClientePrestamoKeyTyped
        // TODO add your handling code here:
        eventos.numberKeyPress(evt);
    }//GEN-LAST:event_txtDniClientePrestamoKeyTyped

    private void txtDniClientePrestamoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClientePrestamoKeyPressed
        // TODO add your handling code here:
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (!"".equals(txtDniClientePrestamo.getText())) {
                    int dni = Integer.parseInt(txtDniClientePrestamo.getText());
                    cliente = clienteDao.searchClientByDNI(dni);
                    if (cliente.getNombre() != null) {
                        lblNombreClientePrestamo.setText("" + cliente.getNombre());
                        lblIdClientePrestamo.setText("" + cliente.getId());
                    } else {
                        limpiarClientePrestamo();
                        JOptionPane.showMessageDialog(null, "El cliente no existe");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_txtDniClientePrestamoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAgregarLibro;
    private javax.swing.JButton btnEliminarFila;
    private javax.swing.JButton btnRegistrarPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdClientePrestamo;
    private javax.swing.JLabel lblNombreClientePrestamo;
    private javax.swing.JLabel lblStock;
    private javax.swing.JTable tablaPrestamos;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtDniClientePrestamo;
    private javax.swing.JTextField txtIdLibroPrestamo;
    private javax.swing.JTextField txtTituloLibroPrestamo;
    // End of variables declaration//GEN-END:variables
}
