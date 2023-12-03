/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import bomberog5.entidades.Brigada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class BrigadaData {
  private Connection con = null;
    public BrigadaData() {
       con=Conexion.getConexion();
    }   
    
//------------------epecialidades brigada-------------------------

public String[] Especialidades() {
        return new String[] {
            "Incendios viviendas e Industrias",
            "Salvamento en derrumbes",
            "Rescates de montaña",
            "Rescate en accidente de tránsito",
            "Rescate en inundaciones",
            "Operativos prevención"
        };
    }
//----------------- fin especialidades brigada----------------------   

//----------------- hay cupo para nueva brigada-------------------

 public boolean hayCupoParaNuevaBrigada(int numeroCuartel) {
        int cantidadBrigadas = contarBrigadasPorCuartel(numeroCuartel);
        int capacidadMaxima = 3; // Cambia esto según la capacidad máxima de brigadas por cuartel que desees

        return cantidadBrigadas < capacidadMaxima;
    }
//-----------------fin hay cupo para nueva brigada---------------
 
 //------------------cuenta las brigadas por cuartel-------------
  public int contarBrigadasPorCuartel(int numeroCuartel) {
        int cantidadBrigadas = 0;

        try {
            String sql = "SELECT COUNT(*) AS cantidad FROM brigada WHERE idCuartel = ? AND estadoBr = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numeroCuartel);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cantidadBrigadas = rs.getInt("cantidad");
            }

            ps.close();
        } catch (SQLException ex) {
            // Manejar excepciones, por ejemplo, imprimir el error
            ex.printStackTrace();
        }
        //System.out.println("cant " + cantidadBrigadas);
        return cantidadBrigadas;
    }
 
 //------------------fin cuenta las brigadas por cuartel----------
  
 //------------------- brigada con el mismo nombre----------------
  
  public boolean existeBrigadaConNombreEnCuartel(String nombreBrigada, int idCuartel) {
        String sql = "SELECT COUNT(*) FROM brigada WHERE nombreBrig = ? AND idCuartel = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreBrigada);
            ps.setInt(2, idCuartel);
            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Ya existe una brigada con el mismo nombre en el cuartel especificado
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de la brigada en el cuartel.");
        }
        return false; // No existe una brigada con el mismo nombre en el cuartel especificado
    }
 //------------------ fin brigada con el mismo nombre------------ 
  
//-------------guardar brigada-----------------------------------

    public void guardarBrigada(Brigada brigada) {
        String sql = "INSERT INTO brigada (nombreBrig, especialidad, libre, idCuartel, estadoBr) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, brigada.getNombreBrig());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3, brigada.isLibre());
            ps.setInt(4, brigada.getIdCuartel());
            ps.setBoolean(5, brigada.isEstadoBr());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    brigada.setIdBrigada(rs.getInt(1));
                    //JOptionPane.showMessageDialog(null, "Brigada Agregada Exitosamente");
                }
                ps.close();
            } else {
                JOptionPane.showMessageDialog(null, "La ID de brigada ya existe en la base de datos. No se pudo agregar la brigada.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla brigada: " + ex.getMessage());
        }
    }

//------------------fin guardar brigada---------------------------  
    
//----------------------------------------------ELIMINAR BRIGADA------------------------------------

//--------------eliminar brigada cambiando el estado------------------------------------------
    public void cambiarEstadoBrigada(int idBrigada) {
        String sql = "UPDATE brigada SET estadoBr = 0 WHERE idBrigada = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBrigada);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Brigada eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la brigada.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado de la brigada: " + ex.getMessage());
        }
    }

//---------------------------FIN eliminar brigada cambiando el estado--------------------------------------------    

//----------------------------------------------FIN ELIMINAR BRIGADA------------------------------------    
    
    
//-------------------------------------ELIMINAR CUARTEL-----------------------------------------------
//------------------obtengo idBrigada teniendo idCuartel------------------------------------
    public List<Integer> obtenerIdsBrigadasPorIdCuartel(int idCuartel) {
        List<Integer> idsBrigadas = new ArrayList<>();

        String sql = "SELECT idBrigada FROM brigada WHERE idCuartel = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCuartel);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idBrigada = rs.getInt("idBrigada");
                idsBrigadas.add(idBrigada);
            }

            ps.close();
        } catch (SQLException ex) {
            // Manejar excepciones, por ejemplo, imprimir el error
            ex.printStackTrace();
        }

        return idsBrigadas;
    }

//-----------------------------------------------------------------------------------------
    
//----------------------cambiar estado de brigadasss--------------------------------------
    public void cambiarEstadoBrigadas(List<Integer> idsBrigadas) {
        for (Integer idBrigada : idsBrigadas) {
            cambiarEstadoBrigada(idBrigada);
        }

        JOptionPane.showMessageDialog(null, "Brigadas eliminadas exitosamente.");
    }

//---------------------------------------------------------------------------------------    

//-----------------------------------FIN ELIMINAR CUARTEL---------------------------------------------    
    
}
