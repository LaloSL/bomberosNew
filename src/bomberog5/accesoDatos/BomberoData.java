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
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class BomberoData {
    private Connection con = null;
    public BomberoData() {
       con=Conexion.getConexion();
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
    
    
    
    
}
