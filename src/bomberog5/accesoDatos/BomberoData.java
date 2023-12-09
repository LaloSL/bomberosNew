/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.accesoDatos;

import bomberog5.entidades.Bombero;
import bomberog5.entidades.Brigada;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class BomberoData {

    private Connection con = null;

    public BomberoData() {
        con = Conexion.getConexion();
    }
//---------------------------------------Agregar Bombero---------------------------------

//----------------cuenta bombero segun idBrigada  y cupo de bomberos------------
    public int contarBomberosPorBrigada(int idBrigada) {
        int cantidadBomberos = 0;

        try {
            String sql = "SELECT COUNT(*) AS cantidad FROM bombero WHERE idBrigada = ? AND estadoB = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBrigada);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cantidadBomberos = rs.getInt("cantidad");
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("cant: " + cantidadBomberos);
        return cantidadBomberos;
    }

    public boolean hayCupoParaNuevoBombero(int idBrigada) {
        int cantidadBbomberos = contarBomberosPorBrigada(idBrigada);
        int capacidadMaxima = 3; // CAPACIDAD BRIGADA

        return cantidadBbomberos < capacidadMaxima;
    }
//-----------------------------------------------------------------------    

//-------------------------Bombero con el mismo nombre----------------------------------------------------
    public boolean existeBomberoConNombre(String nombreApellido, int dni) {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM bombero WHERE nombreApellido = ? AND dni = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreApellido);
            ps.setInt(2, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    existe = true;
                }
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {

        }

        return existe;
    }

    //------------------------- Fin Bombero con el mismo nombre----------------------------------------------------
    //-------------------GUARDAR BOMBERO---------------------------------------------------------
    public void guardarBombero(Bombero bombero) {
        String sql = "INSERT INTO bombero (dni, nombreApellido, grupoSanguineo, fechaNac, celular, estadoB, idBrigada) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, bombero.getDni());
            ps.setString(2, bombero.getNombreApellido());
            ps.setString(3, bombero.getGrupoSanguineo());
            ps.setDate(4, Date.valueOf(bombero.getFechaNac()));
            ps.setString(5, bombero.getCelular());
            ps.setBoolean(6, bombero.isEstadoB());
            ps.setInt(7, bombero.getIdBrigada());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int idBombero = rs.getInt(1);
                JOptionPane.showMessageDialog(null, "Bombero Agregado Exitosamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla bombero: " + ex.getMessage());
        }
    }

//-------------------Fin GUARDAR BOMBERO--------------------------------------------------------- 
//---------------------------------------Fin Agregar Bombero---------------------------------    
//---------------------------------------ELIMINAR BOMBERO------------------------------------
    public void cambiarEstadoBombero(int idBombero) {
        String sql = "UPDATE bombero SET estadoB = 0 WHERE idBombero = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBombero);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Bombero eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar al bombero.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado del bombero: " + ex.getMessage());
        }
    }

//---------------------------------------FIN ELIMINAR BOMBERO------------------------------------    
//----------------------------ELIMINAR BRIGADA---------------------------------------------
    //-------------averiguo bomberos que pertenecen a una misma brigada -----------------------
    public List<Integer> obtenerIDsBomberosPorBrigada(int idBrigada) {
        List<Integer> idsBomberos = new ArrayList<>();

        String sql = "SELECT idBombero FROM bombero WHERE idBrigada = ? AND estadoB = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBrigada);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idBombero = rs.getInt("idBombero");
                idsBomberos.add(idBombero);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los IDs de los bomberos de la brigada: " + ex.getMessage());
        }

        return idsBomberos;
    }
//------------- fin averiguo bomberos que pertenecen a una misma brigada -----------------------

//------------Borrado logico de bomberos que pertenecen a un brigada--------------
    public void cambiarEstadoBomberosPorBrigada(int idBrigada) {
        // Obtener la lista de IDs de bomberos que pertenecen a la brigada
        List<Integer> idsBomberosAEliminar = obtenerIDsBomberosPorBrigada(idBrigada);

        for (Integer idBombero : idsBomberosAEliminar) {
            cambiarEstadoBombero(idBombero);
        }
    }
//------------ fin Borrado logico de bomberos que pertenecen a un brigada--------------

//----------------------------FIN ELIMINAR BRIGADA---------------------------------------------
//------------------------ELIMINAR CUARTEL---------------------------------
//-----------------------lista los bomberos que pertenecen a las brigadas de un cuartel--------------    
    public void eliminarBomberosPorIdsBrigadas(List<Integer> idsBrigadas) {
        // Iterar sobre la lista de IDs de brigadas
        for (Integer idBrigada : idsBrigadas) {
            // Lógica para obtener los IDs de bomberos asociados a la brigada
            List<Integer> idsBomberos = obtenerIDsBomberosPorBrigada(idBrigada);

            // Lógica para cambiar el estado de los bomberos
            cambiarEstadoBomberosPorIds(idsBomberos);
        }
    }

    public void cambiarEstadoBomberosPorIds(List<Integer> idsBomberos) {
        String sql = "UPDATE bombero SET estadoB = 0 WHERE idBombero = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            for (Integer idBombero : idsBomberos) {
                ps.setInt(1, idBombero);
                ps.executeUpdate();
            }

            ps.close();

            JOptionPane.showMessageDialog(null, "Bomberos eliminados exitosamente", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado de los bomberos: " + ex.getMessage());
        }
    }

//------------------------FIN ELIMINAR CUARTEL------------------------------  
//--------------------------------------CONSULTAS-------------------------------------
//---------------------- Muestra nombre de bomberos de la misma brigada-----------------------
    public List<String> mostrarOpcionesBomberosPorBrigada(int idBrigada) {
        List<String> nombresBomberos = new ArrayList<>();

        String sql = "SELECT idBombero, dni, nombreApellido FROM bombero WHERE idBrigada = ? AND estadoB = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBrigada);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idBombero = rs.getInt("idBombero");
                String nombreBombero = rs.getString("nombreApellido");
                int dni = rs.getInt("dni");

                nombresBomberos.add(idBombero + ". " + nombreBombero + " - DNI: " + dni);
            }

            ps.close();

            if (nombresBomberos.size() == 1) {
                JOptionPane.showMessageDialog(null, "La brigada seleccionada contiene un solo bombero");
            } else if (nombresBomberos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La brigada seleccionada no tiene bomberos");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de bomberos: " + ex.getMessage());
        }

        return nombresBomberos;
    }

    //----------------------Fin Muestra nombre de bomberos de la misma brigada-----------------------    
}
