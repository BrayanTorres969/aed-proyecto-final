package com.pe.biblioteca.components;


import com.pe.biblioteca.vista.Sistema;
import javax.swing.JOptionPane;


/**
 *
 * @author Brayan
 */
public class Libros extends javax.swing.JPanel {


    public Libros() {
        initComponents();
        InitStyles();
        this.btnEditarLibro.setVisible(false);
        cargarLibros();
    }

    public void InitStyles() {
        txtBuscarLibro.putClientProperty("JTextField.placeholderText", "Ingrese el título del libro a buscar.");
        tablaLibros.setRowSelectionAllowed(true);
    }

    private void cargarLibros() {
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
        txtBuscarLibro = new javax.swing.JTextField();
        btnBuscarLibro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        btnEliminarLIbro = new javax.swing.JButton();
        btnEditarLibro = new javax.swing.JButton();
        btnNuevoLibro = new javax.swing.JButton();

        bg.setBackground(new java.awt.Color(249, 245, 235));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        titulo.setText("Libros");

        txtBuscarLibro.setBorder(null);

        btnBuscarLibro.setBackground(new java.awt.Color(28, 56, 121));
        btnBuscarLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscarLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarLibro.setText("Buscar");
        btnBuscarLibro.setBorderPainted(false);
        btnBuscarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Autor/es", "Categoria", "Publicación", "Disponibles"
            }
        ));
        tablaLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaLibros.setFocusable(false);
        jScrollPane1.setViewportView(tablaLibros);
        if (tablaLibros.getColumnModel().getColumnCount() > 0) {
            tablaLibros.getColumnModel().getColumn(0).setMinWidth(35);
            tablaLibros.getColumnModel().getColumn(0).setPreferredWidth(35);
            tablaLibros.getColumnModel().getColumn(0).setMaxWidth(35);
            tablaLibros.getColumnModel().getColumn(3).setMinWidth(120);
            tablaLibros.getColumnModel().getColumn(3).setPreferredWidth(120);
            tablaLibros.getColumnModel().getColumn(3).setMaxWidth(120);
            tablaLibros.getColumnModel().getColumn(4).setMinWidth(100);
            tablaLibros.getColumnModel().getColumn(4).setPreferredWidth(100);
            tablaLibros.getColumnModel().getColumn(4).setMaxWidth(100);
            tablaLibros.getColumnModel().getColumn(5).setMinWidth(100);
            tablaLibros.getColumnModel().getColumn(5).setPreferredWidth(100);
            tablaLibros.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        btnEliminarLIbro.setBackground(new java.awt.Color(28, 56, 121));
        btnEliminarLIbro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminarLIbro.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarLIbro.setText("Borrar");
        btnEliminarLIbro.setBorderPainted(false);
        btnEliminarLIbro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarLIbro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLIbroActionPerformed(evt);
            }
        });

        btnEditarLibro.setBackground(new java.awt.Color(28, 56, 121));
        btnEditarLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditarLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarLibro.setText("Editar");
        btnEditarLibro.setBorderPainted(false);
        btnEditarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarLibroActionPerformed(evt);
            }
        });

        btnNuevoLibro.setBackground(new java.awt.Color(28, 56, 121));
        btnNuevoLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNuevoLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoLibro.setText("Nuevo");
        btnNuevoLibro.setBorderPainted(false);
        btnNuevoLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnNuevoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarLIbro, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(txtBuscarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                                        .addGap(140, 140, 140)
                                        .addComponent(btnBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(27, 27, 27))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarLIbro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
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

    private void btnEliminarLIbroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLIbroActionPerformed

    }//GEN-LAST:event_btnEliminarLIbroActionPerformed

    private void btnEditarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarLibroActionPerformed

    }//GEN-LAST:event_btnEditarLibroActionPerformed

    private void btnNuevoLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLibroActionPerformed
        // TODO add your handling code here:
        Sistema.ShowJPanel(new LibrosForm());
    }//GEN-LAST:event_btnNuevoLibroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnEditarLibro;
    private javax.swing.JButton btnEliminarLIbro;
    private javax.swing.JButton btnNuevoLibro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtBuscarLibro;
    // End of variables declaration//GEN-END:variables
}
