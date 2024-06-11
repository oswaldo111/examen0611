/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.examen0611;

import Accesodatos.OrdenesDAL;
import entidades.Ordenes;
import entidades.Servicios;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilerias.OpcionesCRUD;

/**
 *
 * @author R5 8500G
 */
public class FrmOrdenesLec extends javax.swing.JFrame {

    private OpcionesCRUD OpcionCRUD;

    /**
     * Creates new form FrmOrdenesLec
     */
    public FrmOrdenesLec() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMonto = new javax.swing.JTextField();
        jBTNBuscar = new javax.swing.JButton();
        jBTNCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaOrdenes = new javax.swing.JTable();
        jBTNEditar = new javax.swing.JButton();
        jBTNEliminar = new javax.swing.JButton();
        jBTNCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMonto.setText("0");
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        jBTNBuscar.setText("Buscar");
        jBTNBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNBuscarActionPerformed(evt);
            }
        });

        jBTNCrear.setText("Crear");
        jBTNCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNCrearActionPerformed(evt);
            }
        });

        jTablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaOrdenes);

        jBTNEditar.setText("Editar");
        jBTNEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNEditarActionPerformed(evt);
            }
        });

        jBTNEliminar.setText("Eliminar");
        jBTNEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNEliminarActionPerformed(evt);
            }
        });

        jBTNCancelar.setText("Cancelar");
        jBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBTNBuscar)
                        .addGap(28, 28, 28)
                        .addComponent(jBTNCrear))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBTNEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBTNEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jBTNCancelar)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTNBuscar)
                    .addComponent(jBTNCrear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTNEditar)
                    .addComponent(jBTNEliminar)
                    .addComponent(jBTNCancelar))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void jBTNCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNCrearActionPerformed
        // TODO add your handling code here:
        OpcionCRUD = OpcionesCRUD.CREAR;
        FrmOrdenesEsc frmProductosEsc = new FrmOrdenesEsc(OpcionCRUD, new Ordenes());
        frmProductosEsc.setTitle("Crear Orden");
        frmProductosEsc.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jBTNCrearActionPerformed

    private void jBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNCancelarActionPerformed
        // TODO add your handling code here:
           this.setVisible(false);
    }//GEN-LAST:event_jBTNCancelarActionPerformed

    private void jBTNEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNEditarActionPerformed
        // TODO add your handling code here: 
        int row = jTablaOrdenes.getSelectedRow();
        if (row != -1) {
            OpcionCRUD = OpcionesCRUD.MODIFICAR;
            FrmOrdenesEsc frmOrdenesEsc = new FrmOrdenesEsc(OpcionCRUD, obtenerDatos());
            frmOrdenesEsc.setTitle("Modificar Orden");
            frmOrdenesEsc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccionar una fila", "Orden",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBTNEditarActionPerformed

    private void jBTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNEliminarActionPerformed
        // TODO add your handling code here:
           int row = jTablaOrdenes.getSelectedRow();
        if (row != -1) {
            OpcionCRUD = OpcionesCRUD.ELIMINAR;
            FrmOrdenesEsc frmProductosEsc = new FrmOrdenesEsc(OpcionCRUD, obtenerDatos());
            frmProductosEsc.setTitle("Eliminar Orden");
            frmProductosEsc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccionar una fila", "Orden",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBTNEliminarActionPerformed

    private void jBTNBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNBuscarActionPerformed
        // TODO add your handling code here:
           Ordenes orden = new Ordenes();
        orden.setMonto(Double.parseDouble(txtMonto.getText()));
        ArrayList<Ordenes> ordens = OrdenesDAL.buscar(orden);
        String[] columnas = {"ID Orden", "Fecha", "Monto","ServicioID", "Servicio"};
        Object[][] datos = new Object[ordens.size()][6];
        for (int i = 0; i < ordens.size(); i++) {
            Ordenes item = ordens.get(i);
            datos[i][0] = item.getOrderID();
            datos[i][1] = item.getFecha();
            datos[i][2] = item.getMonto();
            datos[i][3] = item.getServiciosID();
             datos[i][4] = item.getServicios().getNombre();
        }
        DefaultTableModel modelTable = new DefaultTableModel(datos, columnas);
        jTablaOrdenes.setModel(modelTable);
    }//GEN-LAST:event_jBTNBuscarActionPerformed

    private Ordenes obtenerDatos() {
        Ordenes orden = new Ordenes();
        int row = jTablaOrdenes.getSelectedRow();
        orden.setOrderID((int) jTablaOrdenes.getValueAt(row, 0));

        String fechaString = jTablaOrdenes.getValueAt(row, 1).toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formatter);
        orden.setFecha(fecha);
        orden.setMonto((double) jTablaOrdenes.getValueAt(row, 3));
        orden.setServiciosID((int) jTablaOrdenes.getValueAt(row, 4));

        Servicios servicio = new Servicios();
        servicio.setNombre(jTablaOrdenes.getValueAt(row, 5).toString());
        servicio.setServiciosID((int) jTablaOrdenes.getValueAt(row, 4));
        orden.setServicios(servicio);
        return orden;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesLec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesLec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesLec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesLec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOrdenesLec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTNBuscar;
    private javax.swing.JButton jBTNCancelar;
    private javax.swing.JButton jBTNCrear;
    private javax.swing.JButton jBTNEditar;
    private javax.swing.JButton jBTNEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaOrdenes;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
