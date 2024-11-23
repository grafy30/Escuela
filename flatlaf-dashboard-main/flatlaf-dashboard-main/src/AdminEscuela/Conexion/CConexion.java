package AdminEscuela.Conexion;

import AdminEscuela.Modelo.ModelUsuario;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.sql.*;
//import java.sql.Statement;

//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;


public class CConexion {
     Connection conectar=null;
    
    String puerto="1433";
    String bd="GestionEscuela";
    String usuario="admin1";
    String password="1234";
    String ip="localhost";
    
    public Connection EstablecerConexion()    
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String cadena="jdbc:sqlserver://"+ip+":"+puerto+";"+"databaseName="+bd+";"+
                       "encrypt=true;trustServerCertificate=true";
            conectar=DriverManager.getConnection(cadena,usuario,password);
//            JOptionPane.showMessageDialog(null, "Conexion exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro la conexion"+e);
        }
        return conectar;
    }       
    
    public HashMap<String, ModelUsuario> obtenerUsuarios() {
        HashMap<String, ModelUsuario> usuarios = new HashMap<>();
        Connection con = EstablecerConexion(); // Asegúrate de que este método devuelva una conexión válida.

        String query = "SELECT UsuarioID, NombreUsuario, Contraseña, RolID, EstudianteID, ProfesorID, Foto, " +
                       "CASE WHEN EstudianteID IS NOT NULL THEN " +
                       "  (SELECT CONCAT(e.Nombre, ' ', e.Apellido) FROM Estudiantes e WHERE e.EstudianteID = Usuarios.EstudianteID) " +
                       "WHEN ProfesorID IS NOT NULL THEN " +
                       "  (SELECT CONCAT(p.Nombre, ' ', p.Apellido) FROM Profesores p WHERE p.ProfesorID = Usuarios.ProfesorID) " +
                       "ELSE 'Usuario General' END AS NombreCompleto " +
                       "FROM Usuarios";

        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Construir el objeto ModelUsuario
                ModelUsuario usuario = new ModelUsuario(
                    rs.getInt("UsuarioID"),
                    rs.getString("NombreUsuario"),
                    rs.getString("Contraseña"),
                    rs.getInt("RolID"),
                    rs.getBytes("Foto"),
                    rs.getInt("EstudianteID"),
                    rs.getInt("ProfesorID"),
//                    rs.getObject("EstudianteID") != null ? rs.getInt("EstudianteID") : 0,
//                    rs.getObject("ProfesorID") != null ? rs.getInt("ProfesorID") : 0,
                    rs.getString("NombreCompleto")
                );
                usuarios.put(usuario.getNombreUsuario(), usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Mejor: utiliza un logger
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return usuarios;
    }
}
