/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.vistas;

import bomberog5.accesoDatos.BrigadaData;
import bomberog5.accesoDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class BrigadasCuartelView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel(); //tabla cuartel
    private DefaultTableModel modelo1 = new DefaultTableModel(); //tabla brigada
    private Connection con = null;
    private int filaSeleccionada = -1;
    private BrigadaData briga = new BrigadaData();

    public BrigadasCuartelView() {
        initComponents();
        cabeceraCuartel();
        cabeceraBrigadal();
        con = Conexion.getConexion();
        mostrarDatosCuartel();
        //---------------cuartel-------------------------------------------------------------
        //actualiza los datos en los jtextfiel segun la fila seleccionada en cuartel
        jTCuartel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Manejar el evento de selección de la tabla aquí
                filaSeleccionada = jTCuartel.getSelectedRow();
                if (filaSeleccionada != -1) {
                     limpiarTabla(modelo1);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTCuartel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBrigada = new javax.swing.JTable();
        jBConsultar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTCuartel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTCuartel);

        jTBrigada.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTBrigada);

        jBConsultar.setText("Consultar");
        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Tabla Cuartel");

        jLabel2.setText("Tabla Brigadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBConsultar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBSalir))
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBConsultar)
                    .addComponent(jBSalir))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar un cuartel");
            dispose();
        } else {
            int idCuartelSeleccionada = obtenerIdCuartelSeleccionado();
//            cuartelIna();
            List<String> nombresBrigadas = briga.mostrarBrigadasPorCuartel(idCuartelSeleccionada);
            mostrarBrigadasEnTabla(nombresBrigadas);
            //brigadaIna();
        }
    }//GEN-LAST:event_jBConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTBrigada;
    private javax.swing.JTable jTCuartel;
    // End of variables declaration//GEN-END:variables
//----------------------------------------------cabecera tabla cuartel------------------------------------------------
    private void cabeceraCuartel() {
        modelo.addColumn("IdCuartel");
        modelo.addColumn("Nombre del cuartel");
        modelo.addColumn("Direccion");
        modelo.addColumn("Longitud");
        modelo.addColumn("Latitud");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        jTCuartel.setModel(modelo);
    }

//----------------------------------------------fin cabecera tabla cuartel------------------------------------------------ 
//----------------------------------------------cabecera tabla brigada------------------------------------------------
    private void cabeceraBrigadal() {
        modelo1.addColumn("IdBrigada");
        modelo1.addColumn("Nombre de la brigada");
        modelo1.addColumn("Especialidad");
        jTBrigada.setModel(modelo1);
    }

//----------------------------------------------fin cabecera tabla brigada------------------------------------------------ 
    //-------------------LLena la tabla JCuartel-----------------------
    public void mostrarDatosCuartel() {
        DefaultTableModel tcuar = new DefaultTableModel();
        tcuar.addColumn("IdCuartel");
        tcuar.addColumn("Nombre del cuartel");
        tcuar.addColumn("Direccion");
        tcuar.addColumn("Longitud");
        tcuar.addColumn("Latitud");
        tcuar.addColumn("Telefono");
        tcuar.addColumn("Correo");
        jTCuartel.setModel(tcuar);

        try {
            // Suponiendo que 'con' es tu conexión a la base de datos
            String consulta = "SELECT `idCuartel`, `nombreCuartel`, `direccion`, `longitud`, `latitud`, `telefono`, `correo` FROM `cuartel` WHERE `estadoC` = 1";
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idCuartel"),
                    rs.getString("nombreCuartel"),
                    rs.getString("direccion"),
                    rs.getDouble("longitud"), // Cambié a double ya que podría ser un valor decimal
                    rs.getDouble("latitud"), // Cambié a double
                    rs.getString("telefono"),
                    rs.getString("correo")
                };
                tcuar.addRow(fila);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    //-------------------Fin LLena la tabla JCuartel ------------------------
    //----------------devuelve idCuartel seleccionada---------------------------------
    public int obtenerIdCuartelSeleccionado() {
        int selectedRow = jTCuartel.getSelectedRow();
        if (selectedRow != -1) {
            return (int) jTCuartel.getValueAt(selectedRow, 0);
        } else {
            return -1;
        }
    }

    //--------------- fin devuelve idCuartel seleccionado----------------------------
    //--------------inhabilita la tabla cuartel-------------------------------
    private void cuartelIna() {
        jTCuartel.setEnabled(false);

    }
    //--------------Fin inhabilita la tabla cuartel-------------------------------  
    
   private void mostrarBrigadasEnTabla(List<String> nombresBrigadas) {
    modelo1.setRowCount(0);

    for (String nombreBrigada : nombresBrigadas) {
        String[] datosBrigada = nombreBrigada.split(" - Especialidad: "); 

        if (datosBrigada.length == 2) {
            String[] datosNombre = datosBrigada[0].split("\\. "); 

            if (datosNombre.length == 2) {
                String idBrigada = datosNombre[0];
                String nombre = datosNombre[1];
                String especialidad = datosBrigada[1];

                modelo1.addRow(new Object[]{idBrigada, nombre, especialidad, "", ""});
            }
        }
    }

    jTBrigada.repaint();
}


//--------------inhabilita la tabla brigada-------------------------------
    private void brigadaIna() {
        jTBrigada.setEnabled(false);
        jBConsultar.setEnabled(false);

    }
    //--------------Fin inhabilita la tabla brigada-------------------------------  
private void limpiarTabla(DefaultTableModel modelo) {
    modelo.setRowCount(0);
}
}
