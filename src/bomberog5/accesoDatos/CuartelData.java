/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.accesoDatos;

import bomberog5.entidades.Cuartel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class CuartelData {

    private Connection con = null;

    public CuartelData() {
        con = Conexion.getConexion();
    }
//---------------------------------------------------AGREGAR--------------------------------------------------

//----------------------- método guardar cuartel----------------------------------------------------
    public void guardarCuartel(Cuartel cuartel) {

        String sql = "INSERT INTO cuartel (nombreCuartel,direccion,longitud,latitud,telefono,correo,estadoC)"
                + "VALUE(?, ? ,? ,? ,? ,? ,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, cuartel.getNombreCuartel());
            ps.setString(2, cuartel.getDireccion());
            ps.setDouble(3, cuartel.getLongitud());
            ps.setDouble(4, cuartel.getLatitud());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
            ps.setBoolean(7, cuartel.isEstadoC());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cuartel.setIdCuartel(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cuartel Agregado Exitosamente ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cuartel ");
        }

    }
//----------------------- fin método guardar cuartel----------------------------------------------------  
        

//---------------------------------------------------FIN AGREGAR--------------------------------------------------
    
    
}
