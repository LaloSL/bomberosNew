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
import java.time.LocalDateTime;

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
}
