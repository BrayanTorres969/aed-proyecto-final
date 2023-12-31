package com.pe.biblioteca.components;


import com.pe.biblioteca.dao.ClienteDao;
import com.pe.biblioteca.dao.LibroDao;
import com.pe.biblioteca.dao.PrestamoDao;
import com.pe.biblioteca.daoimpl.ClienteDaoImpl;
import com.pe.biblioteca.daoimpl.LibroDaoImpl;
import com.pe.biblioteca.daoimpl.PrestamoDaoImpl;
import com.pe.biblioteca.modelo.Cliente;
import com.pe.biblioteca.utils.Evento;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brayan
 */
public class Devoluciones extends javax.swing.JPanel {

    ClienteDao clienteDao = new ClienteDaoImpl();
    LibroDao libroDao = new LibroDaoImpl();
    PrestamoDao prestamoDao = new PrestamoDaoImpl();

    Cliente cliente = new Cliente();

    Evento evento = new Evento();

    public Devoluciones() {
        initComponents();
        InitStyles();
        lblIdCliente.setVisible(false);
        //btnDevolver.setVisible(false);

    }

    public void InitStyles() {

    }

    private void limpiarDatos() {
        txtDniDevol.setText("");
        lblIdCliente.setText("");
        lblNombre.setText("");
        txtDniDevol.requestFocus();

    }

    private void llenarTabla(int id) {
        DefaultTableModel model = (DefaultTableModel) tblDevolver.getModel();
        List<HashMap<String, Object>> lista = prestamoDao.findBooksBorrowedByCliente(id);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No tiene préstamos pendientes.\n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            limpiarDatos();
            return;
        }

        for (Map<String, Object> map : lista) {
            Object[] datos = new Object[3];
            datos[0] = map.get("id_libro");
            datos[1] = map.get("titulo");
            datos[2] = map.get("cantidad");
            model.addRow(datos); // Agregar una fila al modelo de la tabla
        }
    }

    private void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) tblDevolver.getModel();
        model.setRowCount(0);
    }

    private boolean todasLasFilasSeleccionadas() {
        int rowCount = tblDevolver.getRowCount();

        // Comprueba si todas las filas están seleccionadas
        for (int i = 0; i < rowCount; i++) {
            if (!tblDevolver.isRowSelected(i)) {
                return false; // Si una fila no está seleccionada, retorna false inmediatamente
            }
        }

        return true; // Si todas las filas están seleccionadas, retorna true
    }

    private void sumarStock() {
        for (int i = 0; i < tblDevolver.getRowCount(); i++) {
            int id = Integer.parseInt(tblDevolver.getValueAt(i, 0).toString());
            int cant = Integer.parseInt(tblDevolver.getValueAt(i, 2).toString());
            int stockAnt = libroDao.searchById(id).getStock();
            int stockActual = stockAnt + cant;
            prestamoDao.updateStock(stockActual, id);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        btnDevolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDniDevol = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDevolver = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblIdCliente = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(249, 245, 235));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        titulo.setForeground(new java.awt.Color(96, 126, 170));
        titulo.setText("Devolución de libros");

        btnDevolver.setBackground(new java.awt.Color(28, 56, 121));
        btnDevolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDevolver.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolver.setText("Devolver");
        btnDevolver.setBorderPainted(false);
        btnDevolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(96, 126, 170));
        jLabel2.setText("DNI cliente:");

        txtDniDevol.setBorder(null);
        txtDniDevol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniDevolKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniDevolKeyTyped(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/return.png"))); // NOI18N

        tblDevolver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TÍTULO", "UNIDAD"
            }
        ));
        tblDevolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDevolver.setFocusable(false);
        jScrollPane2.setViewportView(tblDevolver);
        if (tblDevolver.getColumnModel().getColumnCount() > 0) {
            tblDevolver.getColumnModel().getColumn(0).setMinWidth(35);
            tblDevolver.getColumnModel().getColumn(0).setPreferredWidth(35);
            tblDevolver.getColumnModel().getColumn(0).setMaxWidth(35);
            tblDevolver.getColumnModel().getColumn(2).setMinWidth(80);
            tblDevolver.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblDevolver.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setForeground(new java.awt.Color(96, 126, 170));
        jLabel1.setText("Cliente:");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnDevolver)
                        .addGap(57, 57, 57)
                        .addComponent(lblIdCliente))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(112, 112, 112)
                                .addComponent(jLabel1))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(txtDniDevol, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombre))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(titulo)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDniDevol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdCliente))
                .addGap(46, 46, 46))
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

    private void txtDniDevolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniDevolKeyTyped
        // TODO add your handling code here:
        evento.numberKeyPress(evt);
    }//GEN-LAST:event_txtDniDevolKeyTyped

    private void txtDniDevolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniDevolKeyPressed
        // TODO add your handling code here:

        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (!"".equals(txtDniDevol.getText())) {
                    int dni = Integer.parseInt(txtDniDevol.getText());
                    cliente = clienteDao.searchClientByDNI(dni);
                    if (cliente.getNombre() != null) {
                        lblNombre.setText(cliente.getNombre());
                        lblIdCliente.setText(String.valueOf(cliente.getId()));
                        int id_cliente = cliente.getId();

                        llenarTabla(id_cliente);

                    } else {

                        JOptionPane.showMessageDialog(this, "cliente no encontrado.\n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                        txtDniDevol.setText("");
                        txtDniDevol.requestFocus();
                        return;

                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }//GEN-LAST:event_txtDniDevolKeyPressed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        // TODO add your handling code here:
        if (todasLasFilasSeleccionadas()) {
            //Actualizar estado
            int id_prestamo = prestamoDao.getIdBorrowedByClientId(Integer.parseInt(lblIdCliente.getText()));
            if (prestamoDao.updateState(id_prestamo)) {
                //Sumar las unidades al stock de libros
                sumarStock();
                JOptionPane.showMessageDialog(this, "Préstamo devuelto con exito.\n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                //Todo salio bien
                limpiarTabla();
                txtDniDevol.setText("");
                lblNombre.setText("");
                lblIdCliente.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error al devolver.\n", "AVISO", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar todos los libros");
        }
    }//GEN-LAST:event_btnDevolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblDevolver;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtDniDevol;
    // End of variables declaration//GEN-END:variables
}
