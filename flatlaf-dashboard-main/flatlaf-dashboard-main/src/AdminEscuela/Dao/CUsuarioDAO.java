package AdminEscuela.Dao;

import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Conexion.UserSession;
import AdminEscuela.Modelo.ModelUsuario;
//import javax.swing.JOptionPane;
import java.sql.*;
/**
 * @author Wilson
 */
public class CUsuarioDAO {
            
    public ModelUsuario autenticarUsuario(String nombreUsuario, String contraseña) {
        CConexion objc = new CConexion();
        String query = "SELECT u.UsuarioID, u.NombreUsuario, u.Contraseña, u.RolID, u.Foto," +
                       "CASE WHEN u.EstudianteID IS NOT NULL THEN " +
                       "  (SELECT CONCAT(e.Nombre, ' ', e.Apellido) FROM Estudiantes e WHERE e.EstudianteID = u.EstudianteID) " +
                       "WHEN u.ProfesorID IS NOT NULL THEN " +
                       "  (SELECT CONCAT(p.Nombre, ' ', p.Apellido) FROM Profesores p WHERE p.ProfesorID = u.ProfesorID) " +
                       "ELSE 'Usuario General' END AS NombreCompleto " +
                       "FROM Usuarios u WHERE u.NombreUsuario = ? AND u.Contraseña = ?";
        try (PreparedStatement ps = objc.EstablecerConexion().prepareStatement(query)) {
            ps.setString(1, nombreUsuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();

            
            if (rs.next()) {
                ModelUsuario usuario = new ModelUsuario();
                UserSession.setUsuarioID(rs.getInt("UsuarioID"));
                UserSession.setNombreUsuario(rs.getString("NombreUsuario"));
                System.out.println("NombreUsuario " + UserSession.getNombreUsuario());
                UserSession.setRolId(rs.getInt("RolID"));
                UserSession.setFoto(rs.getBytes("Foto")); // Cargar la foto
                UserSession.setNombreCompleto(rs.getString("NombreCompleto")); // Cargar el nombre completo
                return usuario;
            }
               
        } catch (SQLException e) {
            e.printStackTrace(); // Usar un logger es mejor
        }
        return null; // Usuario no encontrado
    }
}


