/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.vistas;

import bomberog5.accesoDatos.BrigadaData;
import bomberog5.accesoDatos.SiniestroData;
import bomberog5.accesoDatos.Conexion;
import bomberog5.accesoDatos.CuartelData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joaco
 */
public class SiniestroView extends javax.swing.JInternalFrame {

    private BrigadaData briga = new BrigadaData();
    private SiniestroData sin = new SiniestroData();
    private CuartelData cua = new CuartelData();
    private Connection con = null;
    private DefaultTableModel SinAct = new DefaultTableModel();
    private DefaultTableModel tbrigad = new DefaultTableModel();

    /**
     * Creates new form Siniestro
     */
    public SiniestroView() {
        initComponents();
        llenarComboEspecialidades();

        con = Conexion.getConexion();
        llenarTablaSiniestrosActivos();
        cabeceraBrigadaDisponibles();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTLatitud = new javax.swing.JTextField();
        jTDetalles = new javax.swing.JTextField();
        jDFechaSiniestro = new com.toedter.calendar.JDateChooser();
        jTHora = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jBGuardarSiniestro = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTSinAct = new javax.swing.JTable();
        jCTipo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBrigada = new javax.swing.JTable();
        jBAsignarBrigada = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jTMinutos = new javax.swing.JTextField();
        jTLongitud = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Agregar Siniestro");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Fecha");

        jLabel4.setText("Hora");

        jLabel5.setText("Latitud");

        jLabel7.setText("Longitud");

        jLabel8.setText("Detalles");

        jBGuardarSiniestro.setText("Guardar Siniestro");
        jBGuardarSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarSiniestroActionPerformed(evt);
            }
        });

        jLabel9.setText("Brigadas Disponibles");

        jTSinAct.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTSinAct);

        jCTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTipoActionPerformed(evt);
            }
        });

        jLabel10.setText("Siniestros Activos");

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

        jBAsignarBrigada.setText("Asignar Brigada");
        jBAsignarBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAsignarBrigadaActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jTLongitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTLongitudActionPerformed(evt);
            }
        });

        jLabel6.setText(":");

        jButton1.setText("Calcular Distancia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBAsignarBrigada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBSalir))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(212, 212, 212))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jCTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(128, 128, 128)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTLatitud)
                                        .addGap(128, 128, 128))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jTHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jBGuardarSiniestro))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel9)))
                        .addGap(368, 368, 368))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jDFechaSiniestro, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addGap(642, 642, 642))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDFechaSiniestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jBGuardarSiniestro))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAsignarBrigada)
                            .addComponent(jBSalir)
                            .addComponent(jButton1))))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTipoActionPerformed

    }//GEN-LAST:event_jCTipoActionPerformed

    private void jBGuardarSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarSiniestroActionPerformed

        String tipo = (String) jCTipo.getSelectedItem();
        //Date fechaSiniestro = jDFechaSiniestro.getDate();
        String hs = jTHora.getText();
        String min = jTMinutos.getText();
        String hora = hs + ":" + min;
        int latitud = Integer.parseInt(jTLatitud.getText());
        int longitud = Integer.parseInt(jTLongitud.getText());
        String detalle = jTDetalles.getText();
        java.util.Date utilDate = jDFechaSiniestro.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        try {
            sin.insertarSiniestro(tipo, sqlDate, hora, min, latitud, longitud, detalle);
        } catch (SQLException ex) {
            Logger.getLogger(SiniestroView.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(
                null, "Siniestro registrado correctamente.");

        llenarTablaSiniestrosActivos();


    }//GEN-LAST:event_jBGuardarSiniestroActionPerformed

    private void jTLongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTLongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTLongitudActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        double latitudSiniestro = Double.parseDouble(jTLatitud.getText());
        double longitudSiniestro = Double.parseDouble(jTLongitud.getText());

        cua.obtenerDatosIdLongitudLatitud(latitudSiniestro, longitudSiniestro);
        int cuaCer = cua.obtenerIdCuartelMasCercano(latitudSiniestro, longitudSiniestro);
        mostrarBrigadasPorIdCuartel(cuaCer);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBAsignarBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAsignarBrigadaActionPerformed
     
    }//GEN-LAST:event_jBAsignarBrigadaActionPerformed
    private void llenarComboEspecialidades() {
        String[] especialidades = briga.Especialidades();
        jCTipo.setModel(new javax.swing.DefaultComboBoxModel<>(especialidades));
    }

    public void llenarTablaSiniestrosActivos() {
        DefaultTableModel tSin = new DefaultTableModel();
        tSin.addColumn("ID");
        tSin.addColumn("Tipo");
        tSin.addColumn("Fecha");
        tSin.addColumn("Hora");
        tSin.addColumn("CoordX");
        tSin.addColumn("CoordY");
        tSin.addColumn("Detalles");
        jTSinAct.setModel(tSin);

        try {

            String consulta = "SELECT idCodigo, tipo, fechaSiniestro, horaSiniestro, coordx, coordy, detalles FROM siniestro WHERE estadoS=1";
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idCodigo"),
                    rs.getString("tipo"),
                    fecha.format(rs.getDate("fechaSiniestro")),
                    rs.getTime("horaSiniestro"),
                    rs.getInt("coordx"),
                    rs.getInt("coordY"),
                    rs.getString("detalles")

                };
                tSin.addRow(fila);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

//----------------------------------------------cabecera tabla cuartel------------------------------------------------
//  
    private void cabeceraBrigadaDisponibles() {
        DefaultTableModel tbrigad = new DefaultTableModel();
        tbrigad.addColumn("IdBrigada");
        tbrigad.addColumn("Nombre de la brigada");
        tbrigad.addColumn("Especialidad");
//        tbrigad.addColumn("Libre/Ocupada");
//        tbrigad.addColumn("IdCuartel");
        jTBrigada.setModel(tbrigad);

    }
//        modelo.addColumn("IdCuartel");
//        modelo.addColumn("Nombre del cuartel");
//        modelo.addColumn("Direccion");
//        modelo.addColumn("Longitud");
//        modelo.addColumn("Latitud");
//        modelo.addColumn("Telefono");
//        modelo.addColumn("Correo");
//        jTCuartel.setModel(modelo);
//    }

//----------------------------------------------fin cabecera tabla cuartel------------------------------------------------ 
    //-------------------LLena la tabla JCuartel-----------------------
//    public void mostrarDatosCuartel() {
//        DefaultTableModel tcuar = new DefaultTableModel();
//        tcuar.addColumn("IdCuartel");
//        tcuar.addColumn("Nombre del cuartel");
//        tcuar.addColumn("Direccion");
//        tcuar.addColumn("Longitud");
//        tcuar.addColumn("Latitud");
//        tcuar.addColumn("Telefono");
//        tcuar.addColumn("Correo");
//        jTCuartel.setModel(tcuar);
//
//        try {
//            // Suponiendo que 'con' es tu conexión a la base de datos
//            String consulta = "SELECT idCuartel, nombreCuartel, direccion, longitud, latitud, telefono, correo FROM cuartel WHERE estadoC = 1";
//            PreparedStatement ps = con.prepareStatement(consulta);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Object[] fila = {
//                    rs.getInt("idCuartel"),
//                    rs.getString("nombreCuartel"),
//                    rs.getString("direccion"),
//                    rs.getDouble("longitud"), // Cambié a double ya que podría ser un valor decimal
//                    rs.getDouble("latitud"), // Cambié a double
//                    rs.getString("telefono"),
//                    rs.getString("correo")
//                };
//                tcuar.addRow(fila);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Manejar la excepción según tus necesidades
//        }
//    }
    //-------lista brigada o brigadas segun el idcurtel
    public void mostrarBrigadasPorIdCuartel(int idCuartel) {
        DefaultTableModel tbrigad = new DefaultTableModel();
        tbrigad.addColumn("IdBrigada");
        tbrigad.addColumn("Nombre de la brigada");
        tbrigad.addColumn("Especialidad");
//        tbrigad.addColumn("Libre/Ocupada");
//        tbrigad.addColumn("IdCuartel");
        jTBrigada.setModel(tbrigad);

        try {
            String consulta = "SELECT idBrigada, nombreBrig, especialidad, idCuartel FROM brigada WHERE estadoBr = 1 AND idCuartel = ?";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, idCuartel);
            ResultSet rs = ps.executeQuery();

            boolean hayBrigadas = false;

            while (rs.next()) {
                hayBrigadas = true;
                Object[] fila = {
                    rs.getInt("idBrigada"),
                    rs.getString("nombreBrig"),
                    rs.getString("especialidad"),
                    //                    rs.getInt("libre"),
                    rs.getInt("idCuartel")
                };
                tbrigad.addRow(fila);
            }

            if (!hayBrigadas) {
                JOptionPane.showMessageDialog(null, "El cuartel más cercano no tiene brigadas.", "Sin Brigadas", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    public void asignarBrigada(int idCodigo, int idBrigada) throws SQLException {
        String query = "UPDATE siniestro SET idbrigada = ? WHERE idCodigo = ?; "
                + "UPDATE brigada SET estado = 0 WHERE idbrigada = ?;";
       
      
        int idCodigoSelec = 0;
        idCodigo = (int) jTSinAct.getValueAt(jTSinAct.getSelectedRow(), idCodigoSelec);
        int idBrigadaSelec = 0;
       idBrigada = (int) jTBrigada.getValueAt(jTBrigada.getSelectedRow(), idBrigadaSelec);

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, idBrigada);
        ps.setInt(2, idCodigo);
        ps.setInt(3, idBrigada);

        ps.executeUpdate();

        

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAsignarBrigada;
    private javax.swing.JButton jBGuardarSiniestro;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCTipo;
    private com.toedter.calendar.JDateChooser jDFechaSiniestro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTBrigada;
    private javax.swing.JTextField jTDetalles;
    private javax.swing.JTextField jTHora;
    private javax.swing.JTextField jTLatitud;
    private javax.swing.JTextField jTLongitud;
    private javax.swing.JTextField jTMinutos;
    private javax.swing.JTable jTSinAct;
    // End of variables declaration//GEN-END:variables
}
