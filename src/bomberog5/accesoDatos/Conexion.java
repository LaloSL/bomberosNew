/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.accesoDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="bomberog5";
    private static final String USUARIO="root";
    private static final String PASWORD="";
    private static Connection connection;
    
    private Conexion (){}
    
    public static Connection getConexion(){
        if (connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");//cargamos el driver
                connection = DriverManager.getConnection(URL+DB,USUARIO,PASWORD);//conectamos el driver
                //JOptionPane.showMessageDialog(null, "Conectado Exitosamente");
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los Driver ");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion con la BD ");
            }
        }
        return connection;
    }
    
    
}
