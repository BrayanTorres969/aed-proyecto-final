package com.pe.biblioteca.components;

import com.pe.biblioteca.dao.ClienteDao;
import com.pe.biblioteca.daoimpl.ClienteDaoImpl;
import com.pe.biblioteca.modelo.Cliente;
import com.pe.biblioteca.utils.Evento;
import com.pe.biblioteca.vista.Sistema;
import javax.swing.JOptionPane;

/**
 *
 * @author Brayan
 */
public class ClientesForm extends javax.swing.JPanel {

    ClienteDao clienteDao = new ClienteDaoImpl();
    boolean esEditar = false;
    Cliente clienteEditar;

    private Evento evento = new Evento();

    public ClientesForm() {
        initComponents();
        InitStyles();
        txtIdCliente.setVisible(false);

    }

    public ClientesForm(Cliente cliente) {
        initComponents();
        esEditar = true;
        clienteEditar = cliente;
        InitStyles();
    }

    public void InitStyles() {

        if (esEditar) {
            titulo.setText("Editar Cliente");
            txtIdCliente.setVisible(false);

            if (clienteEditar != null) {
                txtIdCliente.setText(String.valueOf(clienteEditar.getId()));
                txtNombreCliente.setText(clienteEditar.getNombre());
                txtDniCliente.setText(clienteEditar.getDni());
                txtCelCliente.setText(clienteEditar.getCelular());
                txtDireccionCliente.setText(clienteEditar.getDireccion());
            }

        }

    }

    public void limpiarForm() {
        txtIdCliente.setText("");
        txtNombreCliente.setText("");
        txtDniCliente.setText("");
        txtCelCliente.setText("");
        txtDireccionCliente.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        btnRegistrarCliente = new javax.swing.JButton();
        btnRegresarPanelCliente = new javax.swing.JButton();
        txtNombreCliente = new javax.swing.JTextField();
        titleLbl = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCelCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDireccionCliente = new javax.swing.JTextField();

        bg.setBackground(new java.awt.Color(249, 245, 235));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        titulo.setForeground(new java.awt.Color(96, 126, 170));
        titulo.setText("Registrar un nuevo cliente");

        btnRegistrarCliente.setBackground(new java.awt.Color(28, 56, 121));
        btnRegistrarCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCliente.setText("Guardar");
        btnRegistrarCliente.setBorderPainted(false);
        btnRegistrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnRegresarPanelCliente.setBackground(new java.awt.Color(28, 56, 121));
        btnRegresarPanelCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresarPanelCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresarPanelCliente.setText("Regresar");
        btnRegresarPanelCliente.setBorderPainted(false);
        btnRegresarPanelCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarPanelCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPanelClienteActionPerformed(evt);
            }
        });

        titleLbl.setForeground(new java.awt.Color(96, 126, 170));
        titleLbl.setText("Nombre Completo: ");

        jLabel2.setForeground(new java.awt.Color(96, 126, 170));
        jLabel2.setText("DNI:");

        txtDniCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniClienteKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(96, 126, 170));
        jLabel3.setText("Celular:");

        txtCelCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelClienteKeyTyped(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(96, 126, 170));
        jLabel1.setText("Dirección:");

        txtDireccionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(titleLbl)
                        .addGap(426, 426, 426)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222)
                        .addComponent(txtCelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel2)
                        .addGap(509, 509, 509)
                        .addComponent(jLabel1))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(btnRegresarPanelCliente)
                        .addGap(16, 16, 16)
                        .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(222, 222, 222)
                        .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(titulo)
                .addGap(91, 91, 91)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)))
                .addGap(1, 1, 1)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresarPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        // Validaciones para los campos
        if ("".equals(txtNombreCliente.getText()) || "".equals(txtDniCliente.getText()) || "".equals(txtCelCliente.getText()) || "".equals(txtDireccionCliente.getText())) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos. \n", "AVISO", JOptionPane.ERROR_MESSAGE);
            txtNombreCliente.requestFocus();
            return;
        }
        String nombre = txtNombreCliente.getText();
        String dni = txtDniCliente.getText();
        String celular = txtCelCliente.getText();
        String direccion = txtDireccionCliente.getText();

        Cliente cliente = esEditar ? clienteEditar : new Cliente();
        cliente.setNombre(nombre);
        cliente.setDni(dni);
        cliente.setCelular(celular);
        cliente.setDireccion(direccion);
        try {

            if (!esEditar) {
                clienteDao.save(cliente);
            } else {
                cliente.setId(Integer.parseInt(txtIdCliente.getText()));
                clienteDao.update(cliente);
            }

            String successMsg = esEditar ? "modificado" : "registrado";

            JOptionPane.showMessageDialog(this, "Cliente " + successMsg + " exitosamente.\n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            if (!esEditar) {
                limpiarForm();
            }
        } catch (Exception e) {
            String errorMsg = esEditar ? "modificar" : "registrar";
            JOptionPane.showMessageDialog(this, "Ocurrió un error al " + errorMsg + " el cliente. \n", "AVISO", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnRegresarPanelClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPanelClienteActionPerformed
        // TODO add your handling code here:
        Sistema.ShowJPanel(new Clientes());
    }//GEN-LAST:event_btnRegresarPanelClienteActionPerformed

    private void txtDireccionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionClienteActionPerformed

    private void txtCelClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelClienteKeyTyped
        // TODO add your handling code here:
        evento.numberKeyPress(evt);
    }//GEN-LAST:event_txtCelClienteKeyTyped

    private void txtDniClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteKeyTyped
        // TODO add your handling code here:
        evento.numberKeyPress(evt);
    }//GEN-LAST:event_txtDniClienteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegresarPanelCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtCelCliente;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
