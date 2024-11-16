package AdminEscuela.Dao;

import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Modelo.ModelEstudiante;
import AdminEscuela.Modelo.ModelUsuario;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;


/**
 * @author Wilson
 */
public class CEstudianteDAO {

    public void SeleccionarEstudiante(JTable tabla, JTextField txtCodEst, JTextField txtNomEst, JTextField txtApellidosEst, JDateChooser jFechaNa, 
                                      JTextField txtDNIEst, JComboBox <String> jComboBoxSemeEst, JTextField txtDireccionEst, JTextField txtTelefonoEst,
                                      JTextField txtCorreoEst, JLabel lblMostrarFoto,JTextField ruta) {
                                      
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodEst.setText(tabla.getValueAt(fila, 0).toString());
                txtNomEst.setText(tabla.getValueAt(fila, 1).toString());
                txtApellidosEst.setText(tabla.getValueAt(fila, 2).toString());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Object fechaEntregaObj = tabla.getValueAt(fila, 3);
                if (fechaEntregaObj != null) {
                    java.util.Date fechanacstr = dateFormat.parse(fechaEntregaObj.toString());
                    jFechaNa.setDate(fechanacstr);
                } else {
                    jFechaNa.setDate(null);
                }
                txtDNIEst.setText(tabla.getValueAt(fila, 4).toString());
                String grado = (tabla.getValueAt(fila, 5) != null) ? tabla.getValueAt(fila, 5).toString() : "";
                if (!grado.isEmpty()) {
                    jComboBoxSemeEst.setSelectedItem(grado);
                } else {
                    jComboBoxSemeEst.setSelectedIndex(0);
                }
                
                txtDireccionEst.setText(tabla.getValueAt(fila, 6).toString());
                txtTelefonoEst.setText(tabla.getValueAt(fila, 7).toString());
                txtCorreoEst.setText(tabla.getValueAt(fila, 8).toString());

                // Cargar la foto del estudiante si está disponible
                byte[] fotoBytes = (byte[]) tabla.getValueAt(fila, 10);
                if (fotoBytes != null) {
                    ImageIcon imageIcon = new ImageIcon(fotoBytes);
                    Image image = imageIcon.getImage().getScaledInstance(lblMostrarFoto.getWidth(), lblMostrarFoto.getHeight(), Image.SCALE_SMOOTH);
                    lblMostrarFoto.setIcon(new ImageIcon(image));
                } else {
                    ImageIcon icono = new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
                    lblMostrarFoto.setIcon(icono);
                }
                if (ruta.getText().isEmpty()) {
                    ruta.setText("");
//                    JOptionPane.showMessageDialog(null, "Seleccione una imagen.");
                    return;
                }
//                String rutaFoto = ruta.getText().trim();
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar el Estudiante: " + e.toString());
        }
    }

    public void MostrarTablaEstudiante(JTable tabla) {
        CConexion objCon = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha_Nac");    
        modelo.addColumn("Dni");    
        modelo.addColumn("Semestre");    
        modelo.addColumn("Dirección");    
        modelo.addColumn("Teléfono");    
        modelo.addColumn("Email");    
        modelo.addColumn("Fecha Reg");    
        modelo.addColumn("Foto");    
        modelo.addColumn("Ruta");    
        modelo.addColumn("CodUser");    
        modelo.addColumn("PassUser");    
        tabla.setModel(modelo);

        // Consulta SQL corregida
        String sql = "SELECT e.EstudianteID, e.Nombre, e.Apellido, e.FechaNacimiento, e.Dni, e.Grado, e.Direccion, "
                   + "e.Telefono, e.Email, e.FechaRegistro, e.Foto, u.RutaFot, u.NombreUsuario, u.Contraseña "
                   + "FROM Estudiantes e "
                   + "LEFT JOIN Usuarios u ON e.EstudianteID = u.EstudianteID";

        Object[] datos = new Object[14]; // Cambiado a tamaño 14

        try (Connection conn = objCon.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getString("EstudianteID");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Apellido");
                datos[3] = rs.getString("FechaNacimiento");
                datos[4] = rs.getString("Dni");
                datos[5] = rs.getString("Grado");
                datos[6] = rs.getString("Direccion");
                datos[7] = rs.getString("Telefono");
                datos[8] = rs.getString("Email");
                datos[9] = rs.getString("FechaRegistro");
                datos[10] = rs.getBytes("Foto");         // Imagen en formato byte[]
                datos[11] = rs.getString("RutaFot");    // Ruta de la foto
                datos[12] = rs.getString("NombreUsuario");
                datos[13] = rs.getString("Contraseña");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        } 
    }

    public boolean InsertarEstudianteYUsuario(ModelEstudiante estudiante, ModelUsuario usuario) {
        CConexion objCon = new CConexion();
        String sqlEstudiante = "INSERT INTO Estudiantes (Nombre, Apellido, FechaNacimiento, Dni, Grado, Direccion, Telefono, Email, FechaRegistro, Foto) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), ?)";
        String sqlUsuario = "INSERT INTO Usuarios (NombreUsuario, Contraseña, RolID, EstudianteID, Foto, RutaFot) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = objCon.EstablecerConexion()) {
            conn.setAutoCommit(false);

            // Insertar en Estudiantes
            try (PreparedStatement pstEst = conn.prepareStatement(sqlEstudiante, Statement.RETURN_GENERATED_KEYS)) {
                pstEst.setString(1, estudiante.getNombre());
                pstEst.setString(2, estudiante.getApellido());
                pstEst.setDate(3, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
                pstEst.setString(4, estudiante.getDni());
                pstEst.setString(5, estudiante.getGrado());
                pstEst.setString(6, estudiante.getDireccion());
                pstEst.setString(7, estudiante.getTelefono());
                pstEst.setString(8, estudiante.getEmail());
                pstEst.setBytes(9, estudiante.getFoto());
                pstEst.executeUpdate();

                // Obtener el ID del Estudiante
                ResultSet rsEst = pstEst.getGeneratedKeys();
                int estudianteID = 0;
                if (rsEst.next()) {
                    estudianteID = rsEst.getInt(1);
                }

                // Insertar en Usuarios
                try (PreparedStatement pstUsu = conn.prepareStatement(sqlUsuario)) {
                    pstUsu.setString(1, usuario.getNombreUsuario());
                    pstUsu.setString(2, usuario.getContraseña());
                    pstUsu.setInt(3, usuario.getRolID());
                    pstUsu.setInt(4, estudianteID);
                    pstUsu.setBytes(5, usuario.getFoto());
                    pstUsu.setString(6, usuario.getRuta());
                    pstUsu.executeUpdate();
                }

                // Confirmar la transacción
                conn.commit();
                return true;
            } catch (SQLException ex) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al insertar estudiante y usuario: " + ex.getMessage());
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar: " + e.toString());
            return false;
        }
    }

    
//    public void InsertarEstudiante(ModelEstudiante estudiante) {
//        CConexion objCon = new CConexion(); 
//        String sql = "INSERT INTO Estudiantes(Nombre, Apellido, FechaNacimiento, Dni, Grado, Direccion, Telefono, Email, Foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        
//        try (Connection con = objCon.EstablecerConexion(); // Obtener conexión
//             PreparedStatement pst = con.prepareStatement(sql)) {
//             
//            // Asignar los valores del objeto ModelEstudiante al PreparedStatement
//            pst.setString(1, estudiante.getNombre());
//            pst.setString(2, estudiante.getApellido());
//            pst.setDate(3, new java.sql.Date(estudiante.getFechaNacimiento().getTime())); // Convertir java.util.Date a java.sql.Date
//            pst.setString(4, estudiante.getDni());
//            pst.setString(5, estudiante.getGrado());
//            pst.setString(6, estudiante.getDireccion());
//            pst.setString(7, estudiante.getTelefono());
//            pst.setString(8, estudiante.getEmail());
//            
//            // Manejar la imagen del estudiante (puede ser null)
//            if (estudiante.getFoto() != null) {
//                pst.setBytes(9, estudiante.getFoto());
//            } else {
//                pst.setNull(9, java.sql.Types.BLOB); // Si no hay imagen, insertar null
//            }            
//            // Ejecutar la consulta
//            int filasInsertadas = pst.executeUpdate();
//            
//            if (filasInsertadas > 0) {
//                JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente.");
//            }            
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al insertar estudiante: " + e.getMessage());
//        }
//    }    
}
