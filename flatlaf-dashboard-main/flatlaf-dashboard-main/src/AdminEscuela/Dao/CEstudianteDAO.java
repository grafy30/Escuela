
package AdminEscuela.Dao;

import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Modelo.ModelEstudiante;
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
 *
 * @author Wilson
 */
public class CEstudianteDAO {

    public void SeleccionarEstudiante(JTable tabla, JTextField txtCodEst, JTextField txtNomEst, JTextField txtApellidosEst, JDateChooser jFechaNa, 
                                      JTextField txtDNIEst, JComboBox <String> jComboBoxEst, JTextField txtDireccionEst, JTextField txtTelefonoEst,
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
                
//                jFechaNa.setDate((Date) tabla.getValueAt(fila, 3));
                
                
                txtDNIEst.setText(tabla.getValueAt(fila, 4).toString());
                String grado = tabla.getValueAt(fila, 5).toString();
                if (grado!=null) {
                    
                    jComboBoxEst.setSelectedItem(grado);  // Ajuste el JComboBox según el grado
                }
                else
                    jComboBoxEst.setSelectedIndex(0);
                
                txtDireccionEst.setText(tabla.getValueAt(fila, 6).toString());
                txtTelefonoEst.setText(tabla.getValueAt(fila, 7).toString());
                txtCorreoEst.setText(tabla.getValueAt(fila, 8).toString());

                // Cargar la foto del estudiante si está disponible
                byte[] fotoBytes = (byte[]) tabla.getValueAt(fila, 9);
                if (fotoBytes != null) {
                    ImageIcon imageIcon = new ImageIcon(fotoBytes);
                    Image image = imageIcon.getImage().getScaledInstance(lblMostrarFoto.getWidth(), lblMostrarFoto.getHeight(), Image.SCALE_SMOOTH);
                    lblMostrarFoto.setIcon(new ImageIcon(image));
                } else {
                    lblMostrarFoto.setIcon(null);
                }
                ruta.setText(tabla.getValueAt(fila, 10).toString());
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor selecciona una fila.");
            }
                
//                byte[] fotoEstudiante = obtenerFotoEstudiante(codEst);  // Método que obtiene la foto del estudiante desde la base de datos
//                if (fotoEstudiante != null) {
//                    ImageIcon fotoIcono = new ImageIcon(fotoEstudiante);
//                    lblMostrarFoto.setIcon(new ImageIcon(fotoIcono.getImage().getScaledInstance(lblMostrarFoto.getWidth(), lblMostrarFoto.getHeight(), Image.SCALE_DEFAULT)));
//                } else {
//                    // Si no tiene foto, poner una imagen predeterminada
//                    ImageIcon icono = new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
//                    lblMostrarFoto.setIcon(icono);
//                }
            }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar el Estudiante: " + e.toString());
        }
    }

    public void MostrarTablaDoctor(JTable tabla) {
        CConexion objCon = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha Nacim");    
        modelo.addColumn("Dni");    
        modelo.addColumn("Semestre");    
        modelo.addColumn("Dirección");    
        modelo.addColumn("Teléfono");    
        modelo.addColumn("Email");    
        modelo.addColumn("Fecha Reg");    
        modelo.addColumn("Foto");    

        tabla.setModel(modelo);
        String sql = "SELECT EstudianteID, Nombre, Apellido, FechaNacimiento, Dni, Grado, Direccion, Telefono, Email, FechaRegistro, Foto FROM Estudiantes";
        Object[] datos = new Object[11]; // Cambiado a Object[]
        byte[] pic;

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
                datos[10] = rs.getBytes("Foto");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        } 
    }
    
    public void InsertarEstudiante(ModelEstudiante estudiante) {
        CConexion objCon = new CConexion(); 
        String sql = "INSERT INTO Estudiantes(Nombre, Apellido, FechaNacimiento, Dni, Grado, Direccion, Telefono, Email, Foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = objCon.EstablecerConexion(); // Obtener conexión
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            // Asignar los valores del objeto ModelEstudiante al PreparedStatement
            pst.setString(1, estudiante.getNombre());
            pst.setString(2, estudiante.getApellido());
            pst.setDate(3, new java.sql.Date(estudiante.getFechaNacimiento().getTime())); // Convertir java.util.Date a java.sql.Date
            pst.setString(4, estudiante.getDni());
            pst.setString(5, estudiante.getGrado());
            pst.setString(6, estudiante.getDireccion());
            pst.setString(7, estudiante.getTelefono());
            pst.setString(8, estudiante.getEmail());
            
            // Manejar la imagen del estudiante (puede ser null)
            if (estudiante.getFoto() != null) {
                pst.setBytes(9, estudiante.getFoto());
            } else {
                pst.setNull(9, java.sql.Types.BLOB); // Si no hay imagen, insertar null
            }
            
            // Ejecutar la consulta
            int filasInsertadas = pst.executeUpdate();
            
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente.");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar estudiante: " + e.getMessage());
        }
    }
    
}
