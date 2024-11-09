package AdminEscuela.Conexion;

import AdminEscuela.Modelo.ModelUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.HashMap;

import java.sql.Statement;


public class CConexion {
     Connection conectar=null;
    
    String puerto="1433";
    String bd="Hospital";
    String usuario="admin";
    String password="1234";
    String ip="localhost";
    
    public Connection EstablecerConexion()    
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String cadena="jdbc:sqlserver://"+ip+":"+puerto+";"+"databaseName="+bd+";"+
                       "encrypt=true;trustServerCertificate=true";
            conectar=DriverManager.getConnection(cadena,usuario,password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro la conexion"+e);
        }
        return conectar;
    }       
    public HashMap<String, ModelUsuario> obtenerUsuarios() {
        HashMap<String, ModelUsuario> usuarios = new HashMap<>();
        Connection con = EstablecerConexion();
        try {
            String query = "SELECT * FROM Usuarios";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ModelUsuario usuario = new ModelUsuario(
                    rs.getInt("Id_Usuario"),
                    rs.getString("Nombre_Usuario"),                    
                    rs.getString("Email"),
                    rs.getString("Contraseña"),
                    rs.getInt("Id_Rol")
                );
                usuarios.put(usuario.getNombres_Usuario(), usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
}
