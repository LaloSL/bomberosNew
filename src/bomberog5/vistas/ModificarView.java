package bomberog5.vistas;

import bomberog5.accesoDatos.BomberoData;
import bomberog5.accesoDatos.BrigadaData;
import bomberog5.accesoDatos.Conexion;
import bomberog5.accesoDatos.CuartelData;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ModificarView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel(); //tabla cuartel
    private DefaultTableModel modelo1 = new DefaultTableModel(); //tabla brigada
    private DefaultTableModel modelo2 = new DefaultTableModel(); //tabla bombero
    private CuartelData cua = new CuartelData();
    private BrigadaData briga = new BrigadaData();
    private BomberoData bomb = new BomberoData();
    private Connection con = null;
    private int filaSeleccionada = -1;
    private int filaSeleccionadaBrigada = -1;
    private int filaSeleccionadaBombero = -1;

    public ModificarView() {
        initComponents();
//        inicio();
        cabeceraCuartel();
        cabeceraBrigadal();
        cabeceraBombero();
        con = Conexion.getConexion();
        //---------------cuartel-------------------------------------------------------------
        jTCuartel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                filaSeleccionada = jTCuartel.getSelectedRow();
                if (filaSeleccionada != -1) {
                    llenarCampos();
                    jTCuartel.setEnabled(false);
                }
            }
        });
        //-------------------------------------------------------

        //--------------------------brigada-------------------------------
        jTBrigada.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                filaSeleccionadaBrigada = jTBrigada.getSelectedRow();
                if (filaSeleccionadaBrigada != -1) {
                    llenarCamposBrigada();
                    jTBrigada.setEnabled(false);
                }
            }
        });

        //---------------------------------------------------------------
        //-----------------------bombero--------------------------------
        jTBombero.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                filaSeleccionadaBombero = jTBombero.getSelectedRow();
                if (filaSeleccionadaBombero != -1) {
                    llenarCamposBombero();
                    jTBombero.setEnabled(false);
                }
            }
        });
        //--------------------------------------------------------------
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRBCuartel = new javax.swing.JRadioButton();
        jRBBrigada = new javax.swing.JRadioButton();
        jRBBombero = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCuartel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBrigada = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTBombero = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBModifiBomb = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jBModifiCua = new javax.swing.JButton();
        jBModifiBri = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jTNombreCua = new javax.swing.JTextField();
        jTDireccion = new javax.swing.JTextField();
        jTLongitud = new javax.swing.JTextField();
        jTLatitud = new javax.swing.JTextField();
        jTTelefono = new javax.swing.JTextField();
        jTNacTabla = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTCorreo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTDNI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTNombreBom = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTGrupoSan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTNombreBri = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTCelular1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();

        jRBCuartel.setText("Cuartel");
        jRBCuartel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBCuartelActionPerformed(evt);
            }
        });

        jRBBrigada.setText("Brigada");
        jRBBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBBrigadaActionPerformed(evt);
            }
        });

        jRBBombero.setText("Bombero");
        jRBBombero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBBomberoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Formulario Modificar");

        jTCuartel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTCuartel);

        jTBrigada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTBrigada);

        jTBombero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTBombero);

        jLabel2.setText("Nombre");

        jLabel3.setText("Direccion");

        jLabel4.setText("Longitud");

        jLabel5.setText("Latitud");

        jLabel6.setText("Telefono");

        jLabel7.setText("Celular");

        jBModifiBomb.setText("Modificar Bombero");
        jBModifiBomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModifiBombActionPerformed(evt);
            }
        });

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jBModifiCua.setText("Modificar Cuartel");
        jBModifiCua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModifiCuaActionPerformed(evt);
            }
        });

        jBModifiBri.setText("Modificar Brigada");
        jBModifiBri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModifiBriActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLabel8.setText("Correo");

        jLabel9.setText("DNI");

        jLabel10.setText("Nombre y Apellido");

        jLabel11.setText("Grupo Sanguineo");

        jLabel12.setText("Fecha de Nacimineto");

        jLabel14.setText("Especialidad");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Nombre");

        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Tabla Cuartel");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Tabla Brigada");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("Tabla Bombero");

        jLabel18.setText("Fecha de nacimiento");

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel19.setText("Tilde el circulo si desea cambiar la fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBModifiCua)
                        .addGap(18, 18, 18)
                        .addComponent(jBModifiBri)
                        .addGap(18, 18, 18)
                        .addComponent(jBModifiBomb)
                        .addGap(18, 18, 18)
                        .addComponent(jBLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(jBSalir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTLatitud, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(jTTelefono)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jTLongitud)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jTCorreo)
                                    .addComponent(jTNombreCua)
                                    .addComponent(jTDireccion))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTNombreBri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jTDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTNombreBom, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jTGrupoSan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTNacTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jLabel12)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(78, 78, 78))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addGap(111, 720, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(142, 142, 142)
                                        .addComponent(jRBBrigada))
                                    .addComponent(jRBCuartel))
                                .addGap(93, 93, 93)
                                .addComponent(jRBBombero)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBCuartel)
                    .addComponent(jRBBrigada)
                    .addComponent(jRBBombero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNombreCua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3)
                                .addGap(0, 0, 0)
                                .addComponent(jTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(jTLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addComponent(jTLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel8))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBModifiCua)
                            .addComponent(jBModifiBri)
                            .addComponent(jBModifiBomb)
                            .addComponent(jBLimpiar)
                            .addComponent(jBSalir)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNombreBom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNombreBri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel14)
                                .addGap(0, 0, 0)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTGrupoSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNacTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBCuartelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBCuartelActionPerformed

        mostrarDatosCuartel();
        radioButtonCuartel();


    }//GEN-LAST:event_jRBCuartelActionPerformed
//----------------------modificar brigada-------------------------------------
    private void jBModifiBriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModifiBriActionPerformed
        if (filaSeleccionadaBrigada == -1) {
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar una brigada");
            inicio1();
        } else {
            actualizarBrigada();
            mostrarDatosBrigada();
            limpiarCampos();
            inicio1();
        }


    }//GEN-LAST:event_jBModifiBriActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBModifiCuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModifiCuaActionPerformed
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar un cuartel");
            inicio1();
        } else {
            actualizarCuartel();
            mostrarDatosCuartel();
            limpiarCampos();
            inicio1();
        }
    }//GEN-LAST:event_jBModifiCuaActionPerformed
//-----------------------Radio Button brigada-------------------
    private void jRBBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBBrigadaActionPerformed
        llenarComboEspecialidades();
        mostrarDatosCuartel();
        desCuartel();
        mostrarDatosBrigada();
        radioButtonBrigada();


    }//GEN-LAST:event_jRBBrigadaActionPerformed

    //----------------------radio Button Bombero----------------------------------------
    private void jRBBomberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBBomberoActionPerformed
        mostrarDatosBomberos();
        mostrarDatosCuartel();
        desCuartel();
        mostrarDatosBrigada();
        desBrigada();
        radioButtonBombero();
    }//GEN-LAST:event_jRBBomberoActionPerformed

    //------------------------boton modificar bomberos--------------------------------
    private void jBModifiBombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModifiBombActionPerformed
        if (filaSeleccionadaBombero == -1) {
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar un bombero");
            inicio1();
        } else {
            actualizarBomberoConOpcionFecha();
            mostrarDatosBomberos();
            limpiarCampos();
            inicio1();
        }
    }//GEN-LAST:event_jBModifiBombActionPerformed

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked

    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        habiFecha();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiarCampos();
        inicio1();
    }//GEN-LAST:event_jBLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBModifiBomb;
    private javax.swing.JButton jBModifiBri;
    private javax.swing.JButton jBModifiCua;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRBBombero;
    private javax.swing.JRadioButton jRBBrigada;
    private javax.swing.JRadioButton jRBCuartel;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTBombero;
    private javax.swing.JTable jTBrigada;
    private javax.swing.JTextField jTCelular1;
    private javax.swing.JTextField jTCorreo;
    private javax.swing.JTable jTCuartel;
    private javax.swing.JTextField jTDNI;
    private javax.swing.JTextField jTDireccion;
    private javax.swing.JTextField jTGrupoSan;
    private javax.swing.JTextField jTLatitud;
    private javax.swing.JTextField jTLongitud;
    private javax.swing.JTextField jTNacTabla;
    private javax.swing.JTextField jTNombreBom;
    private javax.swing.JTextField jTNombreBri;
    private javax.swing.JTextField jTNombreCua;
    private javax.swing.JTextField jTTelefono;
    // End of variables declaration//GEN-END:variables
//-----------------------------------INICIO---------------------------------------

    private void inicio() {

        jComboBox1.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jTCuartel.setEnabled(false);
        jTBrigada.setEnabled(false);
        jTBombero.setEnabled(false);
        jTNombreCua.setEnabled(false);
        jTGrupoSan.setEnabled(false);
        jTNombreBri.setEnabled(false);
        jTDireccion.setEnabled(false);
        jTLongitud.setEnabled(false);
        jTLatitud.setEnabled(false);
        jTTelefono.setEnabled(false);
        jTNacTabla.setEnabled(false);
        jTCorreo.setEnabled(false);
        jTDNI.setEnabled(false);
        jTNombreBom.setEnabled(false);
        jBModifiBomb.setEnabled(false);
        jBLimpiar.setEnabled(false);
        jBModifiCua.setEnabled(false);
        jBModifiBri.setEnabled(false);
        jBSalir.setEnabled(false);

        jRBCuartel.setEnabled(true);
        jRBBrigada.setEnabled(true);
        jRBBombero.setEnabled(true);
        jRBCuartel.setSelected(false);
        jRBBrigada.setSelected(false);
        jRBBombero.setSelected(false);
    }

    private void inicio1() {

        jComboBox1.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jTCuartel.setEnabled(false);
        jTBrigada.setEnabled(false);
        jTBombero.setEnabled(false);
        jTNombreCua.setEnabled(false);
        jTGrupoSan.setEnabled(false);
        jTNombreBri.setEnabled(false);
        jTDireccion.setEnabled(false);
        jTLongitud.setEnabled(false);
        jTLatitud.setEnabled(false);
        jTTelefono.setEnabled(false);
        jTNacTabla.setEnabled(false);
        jTCorreo.setEnabled(false);
        jTDNI.setEnabled(false);
        jTCelular1.setEnabled(false);
        jTNombreBom.setEnabled(false);
        jBModifiBomb.setEnabled(false);
        jBLimpiar.setEnabled(false);
        jBModifiCua.setEnabled(false);
        jBModifiBri.setEnabled(false);
        jBSalir.setEnabled(true);

        jRBCuartel.setEnabled(true);
        jRBBrigada.setEnabled(true);
        jRBBombero.setEnabled(true);
        jRBCuartel.setSelected(false);
        jRBBrigada.setSelected(false);
        jRBBombero.setSelected(false);
        borrarContenidoTabla(jTBombero);
        borrarContenidoTabla(jTBrigada);
        borrarContenidoTabla(jTCuartel);
    }

    public static void borrarContenidoTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
    }
//-----------------------------------FIN INICIO---------------------------------------

//--------------------------------------------------------------------------------------------------CUARTEL----------------------------------------------
    private void radioButtonCuartel() {

        // Deshabilita todos los componentes
        jComboBox1.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jTCuartel.setEnabled(true);
        jTBrigada.setEnabled(false);
        jTBombero.setEnabled(false);
        jTNombreCua.setEnabled(true);
        jTGrupoSan.setEnabled(false);
        jTNombreBri.setEnabled(false);
        jTDireccion.setEnabled(true);
        jTLongitud.setEnabled(true);
        jTLatitud.setEnabled(true);
        jTTelefono.setEnabled(true);
        jTNacTabla.setEnabled(false);
        jTCorreo.setEnabled(true);
        jTDNI.setEnabled(false);
        jTNombreBom.setEnabled(false);
        jBModifiBomb.setEnabled(false);
        jBLimpiar.setEnabled(true);
        jBModifiCua.setEnabled(true);
        jBModifiBri.setEnabled(false);
        jBSalir.setEnabled(true);
        jTCuartel.setEnabled(true);

        limpiarCampos();

        jRBCuartel.setEnabled(true);
        jRBBrigada.setEnabled(false);
        jRBBombero.setEnabled(false);
    }

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
                    rs.getDouble("longitud"),
                    rs.getDouble("latitud"),
                    rs.getString("telefono"),
                    rs.getString("correo")
                };
                tcuar.addRow(fila);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-------------------Fin LLena la tabla JCuartel ------------------------
    //------------------------limpia campos-----------------------------------
    private void limpiarCampos() {
        jTNombreCua.setText("");
        jTDireccion.setText("");
        jTLongitud.setText("");
        jTLatitud.setText("");
        jTTelefono.setText("");
        jTCorreo.setText("");
        jTNombreBri.setText("");
        jTDNI.setText("");
        jTNombreBom.setText("");
        jTGrupoSan.setText("");
        jTNacTabla.setText("");
        jTCelular1.setText("");
    }
    //------------------------fin limpia campos-----------------------------------

//--------------------------llena los jtextfiel con la info de la tabla cuartel---------------------------------------------    
    private void llenarCampos() {
        filaSeleccionada = jTCuartel.getSelectedRow();

        // Llena los JTextField con los datos de la fila seleccionada
        jTNombreCua.setText(jTCuartel.getValueAt(filaSeleccionada, 1).toString());
        jTDireccion.setText(jTCuartel.getValueAt(filaSeleccionada, 2).toString());
        jTLongitud.setText(jTCuartel.getValueAt(filaSeleccionada, 3).toString());
        jTLatitud.setText(jTCuartel.getValueAt(filaSeleccionada, 4).toString());
        jTTelefono.setText(jTCuartel.getValueAt(filaSeleccionada, 5).toString());
        jTCorreo.setText(jTCuartel.getValueAt(filaSeleccionada, 6).toString());
    }
//--------------------------fin llena los jtextfiel con la info de la tabla cuartel---------------------------------------------    

//--------------------------actualiza los datos de la tabla con el boton modificar-------------------------------    
    private void actualizarCuartel() {
        double nuevaLongitud = 0.0;
        double nuevaLatitud = 0.0;
        boolean hayErrores = false;
        try {
            int idCuartel = (int) jTCuartel.getValueAt(filaSeleccionada, 0);

            String nuevoNombre = jTNombreCua.getText();
            String nuevaDireccion = jTDireccion.getText();
            String textoLongitud = jTLongitud.getText();
            String textoLatitud = jTLatitud.getText();
            String nuevoTelefono = jTTelefono.getText();
            String nuevoCorreo = jTCorreo.getText();

            if (!textoLongitud.isEmpty()) {
                try {
                    nuevaLongitud = Double.parseDouble(textoLongitud);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una longitud válida.");
                    jTLongitud.setText("");
                    hayErrores = true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una longitud.");
                hayErrores = true;
            }

            if (!textoLatitud.isEmpty()) {
                try {
                    nuevaLatitud = Double.parseDouble(textoLatitud);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una latitud válida.");
                    jTLatitud.setText("");
                    hayErrores = true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una latitud.");
                hayErrores = true;
            }

            if (nuevoNombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo vacío. Por favor, ingrese un nombre al cuartel.");
                jTNombreCua.setText("");
                hayErrores = true;
            } else if (!contieneLetras(nuevoNombre)) {
                JOptionPane.showMessageDialog(null, "El nombre debe contener al menos una letra.");
                jTNombreCua.setText("");
                hayErrores = true;
            }

            if (nuevaDireccion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo vacío. Por favor, ingrese una dirección al cuartel.");
                jTDireccion.setText("");
                hayErrores = true;
            } else if (!contieneLetras(nuevaDireccion)) {
                JOptionPane.showMessageDialog(null, "La dirección debe contener al menos una letra.");
                jTDireccion.setText("");
                hayErrores = true;
            }

            if (nuevoTelefono.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo vacío. Por favor, ingrese un número de teléfono.");
                jTTelefono.setText("");
                hayErrores = true;
            } else if (!esNumeroValido(nuevoTelefono)) {
                JOptionPane.showMessageDialog(null, "El número de teléfono no puede contener letras ni caracteres especiales.");
                jTTelefono.setText("");
                hayErrores = true;
            }

            if (nuevoCorreo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo vacío. Por favor, ingrese una dirección de correo.");
                jTCorreo.setText("");
                hayErrores = true;
            } else if (!nuevoCorreo.contains("@")) {
                JOptionPane.showMessageDialog(null, "La dirección de correo no es válida. Debe contener el carácter '@'.");
                jTCorreo.setText("");
                hayErrores = true;
            }

            if (hayErrores) {
                JOptionPane.showMessageDialog(null, "Algun campo no cumple con los requisitos, vuelva a empezar");
                inicio1();
            } else {

                String updateQuery = "UPDATE cuartel SET nombreCuartel=?, direccion=?, longitud=?, latitud=?, telefono=?, correo=? WHERE idCuartel=?";
                try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
                    ps.setString(1, nuevoNombre);
                    ps.setString(2, nuevaDireccion);
                    ps.setDouble(3, nuevaLongitud);
                    ps.setDouble(4, nuevaLatitud);
                    ps.setString(5, nuevoTelefono);
                    ps.setString(6, nuevoCorreo);
                    ps.setInt(7, idCuartel);

                    int filasAfectadas = ps.executeUpdate();
                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar la fila");
                    }
                } catch (SQLException e) {

                }

            }

        } catch (NumberFormatException e) {

        }
    }

//--------------------------fin actualiza los datos de la tabla con el boton modificar-------------------------------   
//--------------------dehabilita jcuartel------------------------------
    private void desCuartel() {
        jTCuartel.setEnabled(false);
    }

//--------------------fin dehabilita jcuartel--------------------------    
//------------------------------------------------------------------------------------------FIN CUARTEL----------------------------------------------
    //------------------------------------------------------------------------------------------BRIGADA-------------------------------------------------   
    private void radioButtonBrigada() {

        // Deshabilita todos los componentes
        jComboBox1.setEnabled(true);
        jDateChooser1.setEnabled(false);
        jTCuartel.setEnabled(true);
        jTBrigada.setEnabled(true);
        jTBombero.setEnabled(false);
        jTNombreCua.setEnabled(false);
        jTGrupoSan.setEnabled(false);
        jTNombreBri.setEnabled(true);
        jTDireccion.setEnabled(false);
        jTLongitud.setEnabled(false);
        jTLatitud.setEnabled(false);
        jTTelefono.setEnabled(false);
        jTNacTabla.setEnabled(false);
        jTCorreo.setEnabled(false);
        jTDNI.setEnabled(false);
        jTNombreBom.setEnabled(false);
        jBModifiBomb.setEnabled(false);
        jBLimpiar.setEnabled(true);
        jBModifiCua.setEnabled(false);
        jBModifiBri.setEnabled(true);
        jBSalir.setEnabled(true);

        limpiarCampos();

        jRBCuartel.setEnabled(false);
        jRBBrigada.setEnabled(false);
        jRBBombero.setEnabled(false);
    }

    //-----------------------agregar especialidades brigadas-------------------------------------------
    private void llenarComboEspecialidades() {
        String[] especialidades = briga.Especialidades();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(especialidades));
    }

    //-----------------------fin agregar especialidades brigadas-------------------------------------------
    //-----------------llena campo de nombre y especialidades de brigada----------------------------------
    private void llenarCamposBrigada() {
        // Obtiene el índice de la fila seleccionada
        filaSeleccionadaBrigada = jTBrigada.getSelectedRow();

        // Llena los JTextField y JComboBox con los datos de la fila seleccionada
        jTNombreBri.setText(jTBrigada.getValueAt(filaSeleccionadaBrigada, 1).toString());
        jComboBox1.setSelectedItem(jTBrigada.getValueAt(filaSeleccionadaBrigada, 2).toString());
    }
//-----------------fin llena campo de nombre y especialidades de brigada----------------------------------

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
            String consulta = "SELECT `idBrigada`, `nombreBrig`, `especialidad`, `libre`, `idCuartel`FROM `brigada` WHERE `estadoBr`=1";
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idBrigada"),
                    rs.getString("nombreBrig"),
                    rs.getString("especialidad"),
                    rs.getInt("libre"),
                    rs.getInt("idCuartel"),};
                tbrigad.addRow(fila);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-------------------Fin LLena la tabla Jbrigada ------------------------  
    //-------------------------actualiza los datos de la brigada-----------------------------------------
    private void actualizarBrigada() {
        try {
            int idBrigada = (int) jTBrigada.getValueAt(filaSeleccionadaBrigada, 0);
            String nuevoNombre = jTNombreBri.getText();
            boolean hayErrores = false;
gg
            //-------------------validar nombre-------------------------------      
            if (nuevoNombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo vacío. Por favor, ingrese un nombre a la brigada.");
                jTNombreBri.setText("");
                hayErrores = true;
            }

            // Validar que no contenga solo números
            if (!contieneLetras(nuevoNombre)) {
                JOptionPane.showMessageDialog(null, "El nombre debe contener al menos una letra.");
                jTNombreBri.setText("");
                hayErrores = true;
            }

            //-------------------fin validar nombre-------------------------------     
            String nuevaEspecialidad = jComboBox1.getSelectedItem().toString();

            if (hayErrores) {
                JOptionPane.showMessageDialog(null, "Algun campo no cumple con los requisitos, vuelva a empezar");
                inicio1();
            } else {
                String updateQuery = "UPDATE brigada SET nombreBrig=?, especialidad=? WHERE idBrigada=?";
                try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
                    ps.setString(1, nuevoNombre);
                    ps.setString(2, nuevaEspecialidad);
                    ps.setInt(3, idBrigada);

                    int filasAfectadas = ps.executeUpdate();
                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "Datos de la brigada actualizados correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar la fila de la brigada");
                    }
                } catch (SQLException | NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

//-------------------------------------actualiza los datos de la brigada-----------------------------------------
//--------------------dehabilita jbrigada------------------------------
    private void desBrigada() {
        jTBrigada.setEnabled(false);
    }

//--------------------fin dehabilita jcuartel--------------------------     
    //----------------------------------------------------------------------------------------FIN BRIGADA-------------------------------------------------     
    //------------------------------------------------------BOMBERO------------------------------------------------------------------------------------------
    private void radioButtonBombero() {

        // Deshabilita todos los componentes
        jComboBox1.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jTCuartel.setEnabled(false);
        jTBrigada.setEnabled(false);
        jTBombero.setEnabled(true);
        jTNombreCua.setEnabled(false);
        jTGrupoSan.setEnabled(true);
        jTNombreBri.setEnabled(false);
        jTDireccion.setEnabled(false);
        jTLongitud.setEnabled(false);
        jTLatitud.setEnabled(false);
        jTTelefono.setEnabled(false);
        jTNacTabla.setEnabled(true);
        jTCorreo.setEnabled(false);
        jTDNI.setEnabled(true);
        jTNombreBom.setEnabled(true);
        jBModifiBomb.setEnabled(true);
        jBLimpiar.setEnabled(true);
        jBModifiCua.setEnabled(false);
        jBModifiBri.setEnabled(false);
        jBSalir.setEnabled(true);
        jRadioButton1.setEnabled(true);

        limpiarCampos();

        jRBCuartel.setEnabled(false);
        jRBBrigada.setEnabled(false);
        jRBBombero.setEnabled(true);
    }

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
                // Obtener la fecha de nacimiento como un objeto Date
                Date fechaNacimiento = rs.getDate("fechaNac");

                // Formatear la fecha de nacimiento a una cadena (puedes ajustar el formato según tus necesidades)
                String fechaNacFormateada = "";
                if (fechaNacimiento != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    fechaNacFormateada = dateFormat.format(fechaNacimiento);
                }

                // Configurar el formato de fecha en el jDateChooser1
                jDateChooser1.setDateFormatString("yyyy-MM-dd");

                // Configurar la fecha en el jDateChooser1
                jDateChooser1.setDate(fechaNacimiento);

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
        }
    }

    //-------------------Fin LLena la tabla Jbombero------------------------ 
    //--------------llena los jtextFiel con los datos de la tabla bombero-----------------------------
    private void llenarCamposBombero() {
        filaSeleccionadaBombero = jTBombero.getSelectedRow();

        // Verificar que haya una fila seleccionada
        if (filaSeleccionadaBombero != -1) {
            // Obtener los valores de las columnas correspondientes de la fila seleccionada
            String dni = jTBombero.getValueAt(filaSeleccionadaBombero, 1).toString();
            String nombreApellido = jTBombero.getValueAt(filaSeleccionadaBombero, 2).toString();
            String grupoSanguineo = jTBombero.getValueAt(filaSeleccionadaBombero, 3).toString();
            String fechaNacimientoStr = jTBombero.getValueAt(filaSeleccionadaBombero, 4).toString();
            String celular = jTBombero.getValueAt(filaSeleccionadaBombero, 5).toString();

            jTDNI.setText(dni);
            jTNombreBom.setText(nombreApellido);
            jTGrupoSan.setText(grupoSanguineo);
            jTCelular1.setText(celular);

            try {
                Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoStr);

                if (fechaNacimiento != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String fechaNacFormateada = dateFormat.format(fechaNacimiento);

                    jTNacTabla.setText(fechaNacFormateada);
                } else {
                    jTNacTabla.setText("");
                }
                System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

//--------------fin llena los jtextFiel con los datos de la tabla bombero-----------------------------
//-----------------------------------actualiza los datos bomberos------------------------------------
private void actualizarBomberoConOpcionFecha() {
    String nuevoDNI = jTDNI.getText();
    String nuevoNombre = jTNombreBom.getText();
    String nuevoGrupoSanguineo = jTGrupoSan.getText();
    String nuevoCelular = jTCelular1.getText();
    boolean hayErrores = false;

    //--------------------------validar campos---------------------------
    if (!esDniValido(nuevoDNI)) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un DNI válido.");
        jTDNI.setText("");
        hayErrores = true;
    }

    // Validar nombre
    if (nuevoNombre.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre válido.");
        jTNombreBom.setText("");
        hayErrores = true;
    }

    // Validar grupo sanguíneo
    if (nuevoGrupoSanguineo.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un grupo sanguíneo válido.");
        jTGrupoSan.setText("");
        hayErrores = true;
    }

    if (nuevoCelular.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Campo vacío. Por favor, ingrese un número de celular.");
        jTCelular1.setText("");
        hayErrores = true;
    }

    // Validar que el campo contenga solo números
    if (!esNumeroValido(nuevoCelular)) {
        JOptionPane.showMessageDialog(null, "El número de celular no puede contener letras ni caracteres especiales.");
        jTCelular1.setText("");
        hayErrores = true;
    }

    if (hayErrores) {
        JOptionPane.showMessageDialog(null, "Algun campo no cumple con los requisitos, vuelva a empezar");
        inicio1();
    } else {
        //--------------------------fin validar campos---------------------------
        // Validar si el JRadioButton está habilitado
        if (jRadioButton1.isSelected()) {
            // El JRadioButton está habilitado, tomar la fecha de nacimiento del JDateChooser
            Date nuevaFechaNacimiento = jDateChooser1.getDate();

            // Realizar la actualización en la base de datos con todos los datos
            try {
                String consulta = "UPDATE bombero SET dni=?, nombreApellido=?, grupoSanguineo=?, fechaNac=?, celular=? WHERE idBombero=?";
                PreparedStatement ps = con.prepareStatement(consulta);

                ps.setString(1, nuevoDNI);
                ps.setString(2, nuevoNombre);
                ps.setString(3, nuevoGrupoSanguineo);
                ps.setDate(4, new java.sql.Date(nuevaFechaNacimiento.getTime()));
                ps.setString(5, nuevoCelular);

                int idBombero = (int) jTBombero.getValueAt(filaSeleccionadaBombero, 0);
                ps.setInt(6, idBombero);

                int filasActualizadas = ps.executeUpdate();

                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(this, "Bombero actualizado correctamente");
                    mostrarDatosBomberos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el bombero. Verifica el idBombero.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            // El JRadioButton no está habilitado, realizar la actualización sin la fecha de nacimiento
            try {
                String consulta = "UPDATE bombero SET dni=?, nombreApellido=?, grupoSanguineo=?, celular=? WHERE idBombero=?";
                PreparedStatement ps = con.prepareStatement(consulta);

                ps.setString(1, nuevoDNI);
                ps.setString(2, nuevoNombre);
                ps.setString(3, nuevoGrupoSanguineo);
                ps.setString(4, nuevoCelular);

                int idBombero = (int) jTBombero.getValueAt(filaSeleccionadaBombero, 0);
                ps.setInt(5, idBombero);

                int filasActualizadas = ps.executeUpdate();

                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(this, "Bombero actualizado correctamente");
                    mostrarDatosBomberos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el bombero. Verifica el idBombero.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

//-----------------------------------fin actualiza los datos bomberos------------------------------------
    private void habiFecha() {
        jRadioButton1.setEnabled(false);
        jDateChooser1.setEnabled(true);
    }

    private void actualizarFechaNacimiento() {
        Date fechaNacimiento = jDateChooser1.getDate();

        if (fechaNacimiento != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = dateFormat.format(fechaNacimiento);

            jTNacTabla.setText(fechaFormateada);
        } else {
            jTNacTabla.setText("");
        }
    }

    //------------------------------------------------------FIN BOMBERO------------------------------------------------------------------------------------------
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
    private boolean contieneLetras(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean esNumeroValido(String input) {
        return input.matches("\\d+");
    }

    private boolean esDniValido(String dniText) {
        try {
            int dni = Integer.parseInt(dniText);
            return dni > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
