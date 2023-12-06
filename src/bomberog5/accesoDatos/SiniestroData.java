/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.accesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 *
 * @author Asus
 */
public class SiniestroData {

    private Connection con = null;

    public SiniestroData() {
        con = Conexion.getConexion();
    }

    //------------------------GUARDAR SINIESTRO-----------------------------
    public void insertarSiniestro(String tipo, Date fechaSiniestro, String horaSiniestro, String minutos, int latitud, int longitud, String detalles) throws SQLException {
        String consulta = "INSERT INTO siniestro (tipo, fechaSiniestro, horaSiniestro, coordx, coordy, detalles, estadoS) "
                + "VALUES (?, ?, ?, ?, ?, ?, 1)";

        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, tipo);
            ps.setDate(2, fechaSiniestro);
            ps.setString(3, horaSiniestro);
            ps.setInt(4, latitud);
            ps.setInt(5, longitud);
            ps.setString(6, detalles);
            //ps.setBoolean(7, true);

          

            int filasAfectadas = ps.executeUpdate();

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

//    public Date unirHoraMin(String hora, String minutos) throws ParseException {
//    SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
//    Time time = new Time(formato.parse(hora + ":" + minutos).getTime());
//    return new Date(time.getTime());
//}
    
    
    public void actualizarSiniestro(Date fechaResol, String horaSiniestro, String minutos, int puntuacion) throws SQLException {
        
        String consulta = "UPDATE siniestro SET fechaReso = ?, horaSiniestro = ?, minutos = ?, puntuacion = ?, estadoS = 0 WEHERE id = ?";
                

        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            LocalDate localDate = fechaResol.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            ps.setDate(1, java.sql.Date.valueOf(localDate));
            LocalTime localTime = LocalTime.parse(horaSiniestro + ":" + minutos);
            ps.setTime(2, Time.valueOf(localTime));
            ps.setInt(3, puntuacion);
            

            int filasAfectadas = ps.executeUpdate();

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
    
    public String[] Puntuacion() {
        return new String[] {
            "1",
            "2",
            "3",
            "4",
            "5"
            
        };
    }
    
    
    
    
    
}

