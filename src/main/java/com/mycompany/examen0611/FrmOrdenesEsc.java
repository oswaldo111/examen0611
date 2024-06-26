/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.examen0611;

import Accesodatos.OrdenesDAL;
import Accesodatos.ServiciosDAL;
import entidades.Ordenes;
import entidades.Servicios;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import utilerias.OpcionesCRUD;
import static utilerias.OpcionesCRUD.CREAR;
import static utilerias.OpcionesCRUD.ELIMINAR;
import static utilerias.OpcionesCRUD.MODIFICAR;

/**
 *
 * @author R5 8500G
 */
public class FrmOrdenesEsc extends javax.swing.JFrame {

    public FrmOrdenesEsc() {
         initComponents();
}

    /**
     * Creates new form FrmOrdenes
     */
    private OpcionesCRUD opcionCRUD;
    private Ordenes OrdenActual = new Ordenes();
    private HashMap<Integer, Servicios> mapServicios = new HashMap<Integer, Servicios>();

    /**
     * Creates new form FrmProductosEsc
     * @param opcion
     * @param ordenes
     */
    public FrmOrdenesEsc(OpcionesCRUD opcion, Ordenes ordenes) {
        this.opcionCRUD = opcion;
        initComponents();
        ArrayList<Servicios> servicioss = ServiciosDAL.obtenerTodos();
        DefaultComboBoxModel<Servicios> modelCombox = new DefaultComboBoxModel(servicioss.toArray());
        for (Servicios ser : servicioss) {
            mapServicios.put(ser.getServiciosID(), ser);
        }
        jComboservicios.setModel(modelCombox);
        if (opcion != OpcionesCRUD.CREAR) {
            asingarDatos(ordenes);
            OrdenActual = ordenes;
        }

    }
    private Ordenes obtenerDatos() {
        Ordenes ordenes = new Ordenes();

        Servicios servicio = (Servicios) jComboservicios.getSelectedItem();
        ordenes.setServiciosID(servicio.getServiciosID());
        ordenes.setOrderID(OrdenActual.getOrderID());

        String fechaString = jTextFecha.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formatter);
        ordenes.setFecha(fecha);

        ordenes.setMonto(Double.parseDouble(jTextMonto.getText()));

        return ordenes;
    }

    private void asingarDatos(Ordenes ordenes) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        jTextFecha.setText(ordenes.getFecha().format(formatter));
        jTextMonto.setText(Double.toString(ordenes.getMonto()));

        Servicios ser = mapServicios.get(ordenes.getOrderID());
        jComboservicios.setSelectedItem(ser);
    }
    
     private void crearReg() {
        try {
            Ordenes orden = obtenerDatos();
            int result = OrdenesDAL.crear(orden);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "la Orden fue registrada existosamente", "CREAR Orden",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al crear la orden", "ERROR Orden",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERROR ORDEN",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void modificarReg() {
        try {
            Ordenes orden = obtenerDatos();
            int result = OrdenesDAL.modificar(orden);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "la Orden fue modificado existosamente", "MODIFICAR ORDEN",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al modificar la Orden", "ERROR ORDEN",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERROR ORDEN",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    
        private void eliminarReg() {
        try {
            Ordenes orden = obtenerDatos();
            int result = OrdenesDAL.eliminar(orden);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "La orden fue eliminado existosamente", "ELIMINAR Orden",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al eliminar el producto", "ERROR Orden",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERROR Orden",
                    JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jComboservicios = new javax.swing.JComboBox<>();
        jTextFecha = new javax.swing.JTextField();
        jTextMonto = new javax.swing.JTextField();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextPane1.setText("Fecha");
        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setText("Monto");
        jScrollPane2.setViewportView(jTextPane2);

        jTextPane3.setText("Servicio");
        jScrollPane3.setViewportView(jTextPane3);

        jBtnGuardar.setText("Guardar");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jBtnGuardar)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnCancelar)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboservicios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardar)
                    .addComponent(jBtnCancelar))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("mantenimiento ordenes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
           if (null != opcionCRUD) // TODO add your handling code here:
            switch (opcionCRUD) {
                case CREAR:
                    crearReg();
                    this.setVisible(false);
                    break;
                case MODIFICAR:
                    modificarReg();
                    this.setVisible(false);
                    break;
                case ELIMINAR:
                    eliminarReg();
                    this.setVisible(false);
                    break;
                default:
                    break;
            }
    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
               this.setVisible(false);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmOrdenesEsc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesEsc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesEsc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesEsc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmOrdenesEsc().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JComboBox<Servicios> jComboservicios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFecha;
    private javax.swing.JTextField jTextMonto;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    // End of variables declaration//GEN-END:variables
}
