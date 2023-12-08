/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.vistas;

import bomberog5.accesoDatos.BomberoData;
import bomberog5.accesoDatos.BrigadaData;
import bomberog5.accesoDatos.Conexion;
import bomberog5.accesoDatos.CuartelData;
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
public class BomberosBrigadaView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo1 = new DefaultTableModel(); //tabla brigada
    private DefaultTableModel modelo2 = new DefaultTableModel(); //tabla bombero
    private Connection con = null;
    private BrigadaData briga = new BrigadaData();
    private BomberoData bomb = new BomberoData();
    private CuartelData cua = new CuartelData();
    private int filaSeleccionadaBrigada = -1;

    public BomberosBrigadaView() {
        initComponents();
        cabeceraBrigadal();
        cabeceraBombero();
        con = Conexion.getConexion();
        mostrarDatosBrigada();
        //--------------------------brigada-------------------------------
        jTBrigada.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Manejar el evento de selección de la tabla aquí
                filaSeleccionadaBrigada = jTBrigada.getSelectedRow();
                if (filaSeleccionadaBrigada != -1) {
//                    llenarCamposBrigada();
                    jTBrigada.setEnabled(false);
                }
            }
        });
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
        jTBrigada = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBombero = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTBrigada);

        jTBombero.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTBombero);

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Limpiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(317, 317, 317)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(188, 188, 188)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int idBrigadaSeleccionada = obtenerIdBrigadaSeleccionado();
        BrigadaIna();
        List<String> nombresBomberos = bomb.mostrarOpcionesBomberosPorBrigada(idBrigadaSeleccionada);

        mostrarBomberosEnTabla(nombresBomberos);
   
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTBombero;
    private javax.swing.JTable jTBrigada;
    // End of variables declaration//GEN-END:variables

//----------------------------------------------cabecera tabla brigada------------------------------------------------
    private void cabeceraBrigadal() {
        modelo1.addColumn("IdBrigada");
        modelo1.addColumn("Nombre de la brigada");
        modelo1.addColumn("Especialidad");
        modelo1.addColumn("Libre/Ocupada");
        modelo1.addColumn("IdCuartel");
        jTBrigada.setModel(modelo1);
    }

//----------------------------------------------fin cabecera tabla brigada------------------------------------------------ 
//----------------------------------------------cabecera tabla bombero------------------------------------------------
    private void cabeceraBombero() {
        modelo2.addColumn("IdBombero");
        modelo2.addColumn("Nombre y Apellido");
         modelo2.addColumn("DNI");
        jTBombero.setModel(modelo2);
    }

//----------------------------------------------fin cabecera tabla bombero------------------------------------------------   
//-------------------LLena la tabla Jbrigada-----------------------
    public void mostrarDatosBrigada() {
        DefaultTableModel tbrigad = new DefaultTableModel();
        tbrigad.addColumn("IdBrigada");
        tbrigad.addColumn("Nombre de la brigada");
        tbrigad.addColumn("Especialidad");
        tbrigad.addColumn("Libre/Ocupada");
        tbrigad.addColumn("IdCuartel");
        jTBrigada.setModel(tbrigad);

        try {
            // Suponiendo que 'con' es tu conexión a la base de datos
            String consulta = "SELECT `idBrigada`, `nombreBrig`, `especialidad`, `libre`, `idCuartel`FROM `brigada` WHERE `estadoBr`=1";
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idBrigada"),
                    rs.getString("nombreBrig"),
                    rs.getString("especialidad"),
                    rs.getInt("libre"), // Cambié a double ya que podría ser un valor decimal
                    rs.getInt("idCuartel"), // Cambié a double
                };
                tbrigad.addRow(fila);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    //-------------------Fin LLena la tabla Jbrigada ------------------------   
    //----------------devuelve idBrigada seleccionada---------------------------------
    public int obtenerIdBrigadaSeleccionado() {
        int selectedRow = jTBrigada.getSelectedRow();
        if (selectedRow != -1) {
            return (int) jTBrigada.getValueAt(selectedRow, 0);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila.");
            return -1; //No hay fila seleccionada
        }
    }

    //--------------- fin devuelve idBrigada seleccionado-----------------------------
    //--------------inhabilita la tabla brigada-------------------------------
    private void BrigadaIna() {
        jTBrigada.setEnabled(false);

    }
    //--------------Fin inhabilita la tabla brigada-------------------------------  

    private void mostrarBomberosEnTabla(List<String> nombresBomberos) {
    modelo2.setRowCount(0);

    for (String nombreBombero : nombresBomberos) {
        String[] datosBombero = nombreBombero.split(" - DNI: "); // Dividir por " - DNI: "

        if (datosBombero.length == 2) {
            String[] datosNombre = datosBombero[0].split("\\. "); // Dividir por ". "
            
            if (datosNombre.length == 2) {
                String idBombero = datosNombre[0];
                String nombreApellido = datosNombre[1];
                String dni = datosBombero[1];

                modelo2.addRow(new Object[]{idBombero, nombreApellido, dni, ""});
            }
        }
    }

    jTBombero.repaint();
}


}