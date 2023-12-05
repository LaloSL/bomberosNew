/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 *
 * @author Asus
 */
public class SiniestroData {
     private Connection con = null;
    
    //------------------------GUARDAR SINIESTRO-----------------------------
    public void insertarSiniestro(String tipo, LocalDateTime fechaHoraSiniestro, int coordx, int coordy, String detalles) throws SQLException {
    String consulta = "INSERT INTO siniestro (tipo, fechaSiniestro, coordx, coordy, detalles) "
            + "VALUES (?, ?, ?, ?, ?)"; 

    try (PreparedStatement statement = con.prepareStatement(consulta)) {
        statement.setString(1, tipo);
        statement.setTimestamp(2, Timestamp.valueOf(fechaHoraSiniestro));
        statement.setInt(3, coordx);
        statement.setInt(4, coordy);
        statement.setString(5, detalles);
        

        int filasAfectadas = statement.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Siniestro registrado con éxito.");
        } else {
            System.out.println("No se registró ningún siniestro.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al insertar el siniestro en la base de datos.");
    }
}
}
