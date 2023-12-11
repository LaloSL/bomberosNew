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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class EliminarNew extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel(); //tabla cuartel
    private DefaultTableModel modelo1 = new DefaultTableModel(); //tabla brigada
    private DefaultTableModel modelo2 = new DefaultTableModel(); //tabla bombero
    private CuartelData cua = new CuartelData();
    private BrigadaData briga = new BrigadaData();
    private BomberoData bomb = new BomberoData();
    private Connection con = null;
    private int filaSeleccionadaBombero = -1;
    private int filaSeleccionadaBrigada = -1;
    private int filaSeleccionada = -1;

    public EliminarNew() {
        initComponents();
        inicio();
        cabeceraCuartel();
        cabeceraBrigadal();
        cabeceraBombero();
        con = Conexion.getConexion();
        //-----------------------bombero--------------------------------
        jTBombero.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                filaSeleccionadaBombero = jTBombero.getSelectedRow();
                if (filaSeleccionadaBombero != -1) {
                    jTBombero.setEnabled(false);
                }
            }
        });
        //--------------------------brigada-------------------------------
        jTBrigada.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Manejar el evento de selección de la tabla aquí
                filaSeleccionadaBrigada = jTBrigada.getSelectedRow();
                if (filaSeleccionadaBrigada != -1) {
                    jTBrigada.setEnabled(false);
                }
            }
        });

        //---------------------------------------------------------------
        //---------------cuartel-------------------------------------------------------------
        jTCuartel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Manejar el evento de selección de la tabla aquí
                filaSeleccionada = jTCuartel.getSelectedRow();
                if (filaSeleccionada != -1) {
                    jTCuartel.setEnabled(false);
                }
            }
        });
        //-------------------------------------------------------
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jRadioButtonCuartel = new javax.swing.JRadioButton();
        jRadioButtonBrigada = new javax.swing.JRadioButton();
        jRadioButtonBombero = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCuartel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBrigada = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTBombero = new javax.swing.JTable();
        jBEliminarCua = new javax.swing.JButton();
        jBEliminarBrig = new javax.swing.JButton();
        jBEliminarBomb = new javax.swing.JButton();
        jSalir = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 102));
        jLabel2.setText("Formulario Eliminar");

        jRadioButtonCuartel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCuartelActionPerformed(evt);
            }
        });

        jRadioButtonBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBrigadaActionPerformed(evt);
            }
        });

        jRadioButtonBombero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBomberoActionPerformed(evt);
            }
        });

        jLabel1.setText("Cuartel");

        jLabel3.setText("Brigada");

        jLabel4.setText("Bombero");

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
        jScrollPane3.setViewportView(jTBombero);

        jBEliminarCua.setText("Eliminar Cuartel");
        jBEliminarCua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarCuaActionPerformed(evt);
            }
        });

        jBEliminarBrig.setText("Eliminar Brigada");
        jBEliminarBrig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarBrigActionPerformed(evt);
            }
        });

        jBEliminarBomb.setText("Eliminar Bombero");
        jBEliminarBomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarBombActionPerformed(evt);
            }
        });

        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(449, 449, 449))
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBEliminarCua)
                        .addGap(89, 89, 89)
                        .addComponent(jBEliminarBrig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBEliminarBomb)
                        .addGap(56, 56, 56)
                        .addComponent(jSalir))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonCuartel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(218, 218, 218)
                        .addComponent(jRadioButtonBrigada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(215, 215, 215)
                        .addComponent(jRadioButtonBombero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addContainerGap(302, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonCuartel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButtonBombero)
                            .addComponent(jRadioButtonBrigada, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel4))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminarCua)
                    .addComponent(jBEliminarBrig)
                    .addComponent(jBEliminarBomb)
                    .addComponent(jSalir))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//------------------------------------------------------ELIMINAR BOMBERO----------------------------------------
    private void jRadioButtonBomberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBomberoActionPerformed
        mostrarDatosBomberos();
        mostrarDatosCuartel();
        mostrarDatosBrigada();
        radioButtonBombero();
        desCuartel();
        desBrigada();
    }//GEN-LAST:event_jRadioButtonBomberoActionPerformed

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jSalirActionPerformed
//---------------------boton eliminar bombero
    private void jBEliminarBombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarBombActionPerformed
        int idBombero = obtenerIdBomberoDesdeFilaSeleccionada();

        if (idBombero != -1) {
            bomb.cambiarEstadoBombero(idBombero);
            mostrarDatosBomberos();
            desBomberi();
        }

    }//GEN-LAST:event_jBEliminarBombActionPerformed
//---------------------------------brigada---------------------------------------
    private void jRadioButtonBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBrigadaActionPerformed

        mostrarDatosBomberos();
        mostrarDatosCuartel();
        mostrarDatosBrigada();
        radiobuttonBrigada();
        desCuartel();
        desBomberi();

    }//GEN-LAST:event_jRadioButtonBrigadaActionPerformed

    //-----------------eliminar brigada---------------------------------
    private void jBEliminarBrigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarBrigActionPerformed
        int idBrigada = obtenerIdBrigadaDesdeFilaSeleccionada();

        if (idBrigada != -1) {
            List<Integer> idsBomberosAEliminar = bomb.obtenerIDsBomberosPorBrigada(idBrigada);
            bomb.cambiarEstadoBomberosPorBrigada(idBrigada);
            briga.cambiarEstadoBrigada(idBrigada);
            mostrarDatosBomberos();
            mostrarDatosBrigada();
            desBrigada();
            desBotonBrigada();
        }

    }//GEN-LAST:event_jBEliminarBrigActionPerformed
//--------------------------jradiobutton Cuartel--------------------------
    private void jRadioButtonCuartelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCuartelActionPerformed
        mostrarDatosBomberos();
        mostrarDatosCuartel();
        mostrarDatosBrigada();
        radiobuttonCuartel();
        desBomberi();
        desBrigada();
    }//GEN-LAST:event_jRadioButtonCuartelActionPerformed
//----------------------------------jbutton Eliminar cuartel-------------------
    private void jBEliminarCuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarCuaActionPerformed
        int idCuartel = obtenerIdCuartel();

        if (idCuartel != -1) {
            List<Integer> idsBrigadas = briga.obtenerIdsBrigadasPorIdCuartel(idCuartel);
            bomb.eliminarBomberosPorIdsBrigadas(idsBrigadas);
            briga.cambiarEstadoBrigadas(idsBrigadas);
            cua.cambiarEstadoCuartel(idCuartel);
            mostrarDatosBomberos();
            mostrarDatosBrigada();
            mostrarDatosCuartel();
            desBrigada();
            desBotonBrigada();
            desCuartel();
        }

    }//GEN-LAST:event_jBEliminarCuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminarBomb;
    private javax.swing.JButton jBEliminarBrig;
    private javax.swing.JButton jBEliminarCua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButtonBombero;
    private javax.swing.JRadioButton jRadioButtonBrigada;
    private javax.swing.JRadioButton jRadioButtonCuartel;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTBombero;
    private javax.swing.JTable jTBrigada;
    private javax.swing.JTable jTCuartel;
    // End of variables declaration//GEN-END:variables

//--------------------------------------------------------------METODOS--------------------------------------------------------
    public void inicio() {
        jRadioButtonCuartel.setEnabled(true);
        jRadioButtonBrigada.setEnabled(true);
        jRadioButtonBombero.setEnabled(true);
        jSalir.setEnabled(true); // Asumiendo que este es el botón 'Salir'

        jBEliminarCua.setEnabled(false);
        jBEliminarBrig.setEnabled(false);
        jBEliminarBomb.setEnabled(false);
        jLabel1.setEnabled(false);
        jLabel2.setEnabled(false);
        jLabel3.setEnabled(false);
        jLabel4.setEnabled(false);
        jScrollPane1.setEnabled(false);
        jScrollPane2.setEnabled(false);
        jScrollPane3.setEnabled(false);
        jTBombero.setEnabled(false);
        jTBrigada.setEnabled(false);
        jTCuartel.setEnabled(false);
    }
//--------------------------------------------------------------------BOMBERO-----------------------------------------------------------
//-------------------------------------jradiobutton bombero---------------------

    private void radioButtonBombero() {
        jTBombero.setEnabled(true);
        jTCuartel.setEnabled(true);
        jTBrigada.setEnabled(true);
        jBEliminarCua.setEnabled(false);
        jBEliminarBrig.setEnabled(false);
        jBEliminarBomb.setEnabled(true);
        jSalir.setEnabled(true);
    }
//-------------------------------------jradiobutton bombero---------------------
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
    //--------------------dehabilita jcuartel------------------------------
    private void desCuartel() {
        jTCuartel.setEnabled(false);
    }

//--------------------fin dehabilita jcuartel--------------------------    
    //--------------------dehabilita jbrigada------------------------------
    private void desBrigada() {
        jTBrigada.setEnabled(false);
    }

//--------------------fin dehabilita jcuartel--------------------------  
    //--------------------dehabilita jcuartel------------------------------
    private void desBomberi() {
        jTBombero.setEnabled(false);
    }

//--------------------fin dehabilita jcuartel--------------------------  
//-------------------LLena la tabla Jbombero-----------------------
    public void mostrarDatosBomberos() {
        DefaultTableModel tbomber = new DefaultTableModel();
        tbomber.addColumn("IdBombero");
        tbomber.addColumn("DNI");
        tbomber.addColumn("Nombre y Apellido");
        tbomber.addColumn("Grupo Sanguineo");
        tbomber.addColumn("Fecha Nacimiento");
        tbomber.addColumn("Celular");
        tbomber.addColumn("IdBrigada");
        jTBombero.setModel(tbomber);

        try {
            String consulta = "SELECT `idBombero`, `dni`, `nombreApellido`, `grupoSanguineo`, `fechaNac`, `celular`, `idBrigada` FROM `bombero` WHERE `estadoB`=1";
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Formatear la fecha de nacimiento
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaNacFormateada = dateFormat.format(rs.getDate("fechaNac"));

                // Agregar la fila a la tabla
                Object[] fila = {
                    rs.getInt("idBombero"),
                    rs.getString("dni"),
                    rs.getString("nombreApellido"),
                    rs.getString("grupoSanguineo"),
                    fechaNacFormateada,
                    rs.getString("celular"),
                    rs.getInt("idBrigada")
                };
                tbomber.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    //-------------------Fin LLena la tabla Jbombero------------------------ 
    //-----------------idBombero de la fila seleccionada------------------
    private int obtenerIdBomberoDesdeFilaSeleccionada() {
        int idBombero = -1;

        if (jTBombero != null && filaSeleccionadaBombero != -1 && jTBombero.getColumnCount() > 0) {
            Object idBomberoObj = jTBombero.getValueAt(filaSeleccionadaBombero, 0);

            if (idBomberoObj instanceof Integer) {
                idBombero = (int) idBomberoObj;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para el bombero.");
        }

        return idBombero;

        //-----------------idBombero de la
    }

    //-----------------idBombero de la fila seleccionada------------------
//--------------------------------------------------------------------FIN BOMBERO-----------------------------------------------------------    
//---------------------------------------------------------------------BRIGADA------------------------------------------------------------
    public void radiobuttonBrigada() {
        jRadioButtonCuartel.setEnabled(false);
        jRadioButtonBrigada.setEnabled(true);
        jRadioButtonBombero.setEnabled(false);
        jSalir.setEnabled(true);

        jBEliminarCua.setEnabled(false);
        jBEliminarBrig.setEnabled(true);
        jBEliminarBomb.setEnabled(false);
        jLabel1.setEnabled(false);
        jLabel2.setEnabled(false);
        jLabel3.setEnabled(false);
        jLabel4.setEnabled(false);
        jScrollPane1.setEnabled(false);
        jScrollPane2.setEnabled(false);
        jScrollPane3.setEnabled(false);
        jTBombero.setEnabled(true);
        jTBrigada.setEnabled(true);
        jTCuartel.setEnabled(true);
    }

    //--------------------------idBrigada de la fila seleccionada---------------------------  
    private int obtenerIdBrigadaDesdeFilaSeleccionada() {
        int idBrigada = -1;

        if (jTBrigada != null && filaSeleccionadaBrigada != -1 && jTBrigada.getColumnCount() > 0) {
            Object idBrigadaObj = jTBrigada.getValueAt(filaSeleccionadaBrigada, 0);

            if (idBrigadaObj instanceof Integer) {
                idBrigada = (int) idBrigadaObj;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para la brigada");
        }

        return idBrigada;
    }

    //--------------------------fin idBrigada de la fila seleccionada---------------------------  
    //--------------------dehabilita jbuttonEliminar Brigada------------------------------
    private void desBotonBrigada() {
        jBEliminarBrig.setEnabled(false);
    }

//--------------------fin dehabilita jcuartel--------------------------   
//--------------------------------------------------------------------FIN BRIGADA----------------------------------------------------------    
//-----------------------------------------------------------------CUARTEL--------------------------------------------------
    public void radiobuttonCuartel() {
        jRadioButtonCuartel.setEnabled(true);
        jRadioButtonBrigada.setEnabled(false);
        jRadioButtonBombero.setEnabled(false);
        jSalir.setEnabled(true);

        jBEliminarCua.setEnabled(true);
        jBEliminarBrig.setEnabled(false);
        jBEliminarBomb.setEnabled(false);
        jLabel1.setEnabled(false);
        jLabel2.setEnabled(false);
        jLabel3.setEnabled(false);
        jLabel4.setEnabled(false);
        jScrollPane1.setEnabled(false);
        jScrollPane2.setEnabled(false);
        jScrollPane3.setEnabled(false);
        jTBombero.setEnabled(true);
        jTBrigada.setEnabled(true);
        jTCuartel.setEnabled(true);
    }
//--------------------------------obtiene idCuartel de la fila seleccionada-----------------------------------------------

    private int obtenerIdCuartel() {
        int idCuartel = -1;

        if (jTCuartel != null && filaSeleccionada != -1 && jTCuartel.getColumnCount() > 0) {
            Object idCuartelObj = jTCuartel.getValueAt(filaSeleccionada, 0);

            if (idCuartelObj instanceof Integer) {
                idCuartel = (int) idCuartelObj;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila");
        }

        return idCuartel;
    }

//----------------------------------------------------------------FIN CUARTEL------------------------------------------------    
//-------------------------------------------------------------------------------------------------------------------------------    
//--------------------------CABECERAS--------------------------------------------
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
        modelo1.addColumn("Libre/Ocupada");
        modelo1.addColumn("IdCuartel");
        jTBrigada.setModel(modelo1);
    }

//----------------------------------------------fin cabecera tabla brigada------------------------------------------------ 
//----------------------------------------------cabecera tabla bombero------------------------------------------------
    private void cabeceraBombero() {
        modelo2.addColumn("IdBombero");
        modelo2.addColumn("DNI");
        modelo2.addColumn("Nombre y Apellido");
        modelo2.addColumn("Grupo Sanguineo");
        modelo2.addColumn("Fecha Nacimiento");
        modelo2.addColumn("Celular");
        modelo2.addColumn("IdBrigada");
        jTBombero.setModel(modelo2);
    }

//----------------------------------------------fin cabecera tabla bombero------------------------------------------------     
//-----------------------------FIN CABECERA--------------------------------------   
}
