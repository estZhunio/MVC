package mvc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Zhunio
 */
public class Conexion {
    Connection con;
    
    String cadenaConexion = "jdbc:postgresql://localhost:5432/MVC";
    String usuarioPG = "postgres";
    String contraPG = "2024";
    
    public Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver OK");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(cadenaConexion, usuarioPG, contraPG);
            System.out.println("Conexion OK");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Metodos genericos 
    public ResultSet consultaBD(String sql) {
        
        try {
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    // Metodo para hacer cualquier accion
    public boolean accionBD(String sql) {
        
        try {
            Statement st = con.createStatement();
            st.execute(sql);
            // con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            // Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
}
