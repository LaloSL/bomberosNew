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
import java.util.ArrayList;
import java.util.List;
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
//-------------------------------------ELIMINAR CUARTEL------------------------------------------------------
//---------------------cambiar estado de cuartel---------------------------------------
    public void cambiarEstadoCuartel(int idCuartel) {
        String sql = "UPDATE cuartel SET estadoC = 0 WHERE idCuartel = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCuartel);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cuartel eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el cuartel.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado del cuartel: " + ex.getMessage());
        }
    }

//---------------------------------------------------------------------------------
    //distancias de cuerteles-------------- calculadora de distancias
    public List<String> obtenerDatosIdLongitudLatitud(double latitudSiniestro, double longitudSiniestro) {
        List<String> listaDistanciasCuartel = new ArrayList<>();

        try {
            String consulta = "SELECT idCuartel, longitud, latitud FROM cuartel WHERE estadoC = 1";
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCuartel = rs.getInt("idCuartel");
                double longitudCuartel = rs.getDouble("longitud");
                double latitudCuartel = rs.getDouble("latitud");

                // Calcular distancia usando la fórmula d = √((x2 - x1)² + (y2 - y1)²)
                double distancia = Math.sqrt(Math.pow((longitudCuartel - longitudSiniestro), 2)
                        + Math.pow((latitudCuartel - latitudSiniestro), 2));

                String datosCuartel = "IdCuartel: " + idCuartel + ", Distancia: " + distancia;
                listaDistanciasCuartel.add(datosCuartel);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }

        for (String datosCuartel : listaDistanciasCuartel) {
            System.out.println(datosCuartel);
        }

        return listaDistanciasCuartel;
    }

//calcula distancia y retorna id cuartel del cuartel mas cercano
    public int obtenerIdCuartelMasCercano(double latitudSiniestro, double longitudSiniestro) {
        int idCuartelMasCercano = -1; // Inicializa con un valor que no sea un id válido
        double distanciaMinima = Double.MAX_VALUE; // Inicializa con un valor muy grande

        try {
            String consulta = "SELECT idCuartel, longitud, latitud FROM cuartel WHERE estadoC = 1";
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCuartel = rs.getInt("idCuartel");
                double longitudCuartel = rs.getDouble("longitud");
                double latitudCuartel = rs.getDouble("latitud");

                // Calcular distancia usando la fórmula d = √((x2 - x1)² + (y2 - y1)²)
                double distancia = Math.sqrt(Math.pow((longitudCuartel - longitudSiniestro), 2)
                        + Math.pow((latitudCuartel - latitudSiniestro), 2));

                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    idCuartelMasCercano = idCuartel;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }

        System.out.println("IdCuartel más cercano: " + idCuartelMasCercano + ", Distancia mínima: " + distanciaMinima);
        return idCuartelMasCercano;
    }

//------------------------------------FIN ELIMINAR CUARTEL-----------------------------------------------    
}
