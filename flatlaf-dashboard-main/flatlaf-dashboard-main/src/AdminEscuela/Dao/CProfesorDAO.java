package AdminEscuela.Dao;

import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Modelo.ModelProfesor;
import AdminEscuela.Modelo.ModelUsuario;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Wilson
 */
public class CProfesorDAO {

    public void MostrarTablaProfesor(JTable JTablaMostrarProfesor) {
        CConexion objCon = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha_Nac");    
        modelo.addColumn("Dni");    
        modelo.addColumn("Especialidad");    
        modelo.addColumn("Dirección");    
        modelo.addColumn("Teléfono");    
        modelo.addColumn("Email");    
        modelo.addColumn("Fecha Reg");    
        modelo.addColumn("Foto");    
        modelo.addColumn("Ruta");    
        modelo.addColumn("CodUser");    
        modelo.addColumn("PassUser");    
        JTablaMostrarProfesor.setModel(modelo);

        // Consulta SQL corregida
        String sql = "SELECT p.ProfesorID, p.Nombre, p.Apellido, p.FechaNacimiento, p.Dni, p.Especialidad , p.Direccion, "
                   + "p.Telefono, p.Email, p.FechaRegistro, p.Foto, p.RutaFot, u.NombreUsuario, u.Contraseña "
                   + "FROM Profesores p "
                   + "LEFT JOIN Usuarios u ON p.ProfesorID = u.ProfesorID";

        Object[] datos = new Object[14]; // Cambiado a tamaño 14

        try (Connection conn = objCon.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getString("ProfesorID");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Apellido");
                datos[3] = rs.getString("FechaNacimiento");
                datos[4] = rs.getString("Dni");
                datos[5] = rs.getString("Especialidad");
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
            JTablaMostrarProfesor.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        } 
    }    

    public boolean InsertarProfesorYUsuario(ModelProfesor profesor, ModelUsuario usuario) {
       CConexion objCon = new CConexion();
        String sqlProfesor = "INSERT INTO Profesores (Nombre, Apellido, FechaNacimiento, Dni, Especialidad, Direccion, Telefono, Email, FechaRegistro, Foto, RutaFot)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), ?, ?)";
        String sqlUsuario = "INSERT INTO Usuarios (NombreUsuario, Contraseña, RolID, ProfesorID, Foto) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = objCon.EstablecerConexion()) {
            conn.setAutoCommit(false);

            // Insertar en Estudiantes
            try (PreparedStatement pstEst = conn.prepareStatement(sqlProfesor, Statement.RETURN_GENERATED_KEYS)) {
                pstEst.setString(1, profesor.getNombre());
                pstEst.setString(2, profesor.getApellido());
                pstEst.setDate(3, new java.sql.Date(profesor.getFechaNacimiento().getTime()));
                pstEst.setString(4, profesor.getDni());
                pstEst.setString(5, profesor.getEspecialidad());
                pstEst.setString(6, profesor.getDireccion());
                pstEst.setString(7, profesor.getTelefono());
                pstEst.setString(8, profesor.getEmail());
                pstEst.setBytes(9, profesor.getFoto());
                pstEst.setString(10, profesor.getRutfo());
                pstEst.executeUpdate();

                // Obtener el ID del Estudiante
                ResultSet rs = pstEst.getGeneratedKeys();
                int ProfesorID = 0;
                if (rs.next()) {
                    ProfesorID = rs.getInt(1);
                }

                // Insertar en Usuarios
                try (PreparedStatement pstUsu = conn.prepareStatement(sqlUsuario)) {
                    pstUsu.setString(1, usuario.getNombreUsuario());
                    pstUsu.setString(2, usuario.getContraseña());
                    pstUsu.setInt(3, usuario.getRolID());
                    pstUsu.setInt(4, ProfesorID);
                    pstUsu.setBytes(5, usuario.getFoto());                    
                    pstUsu.executeUpdate();
                }

                // Confirmar la transacción
                conn.commit();
                return true;
            } catch (SQLException ex) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al insertar rofesor y usuario: " + ex.getMessage());
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar: " + e.toString());
            return false;
        }
    }

    public void ModificarProfesor(JTextField txtCodPro, JTextField txtNomPro, JTextField txtApellidosPro, JDateChooser jFechaNa, JTextField txtDNIPro, JComboBox<String> jComboBoxEspecialidad, JTextField txtDireccionPro, JTextField txtTelefonoPro, JTextField txtCorreoPro, JLabel lblMostrarFoto, JTextField txtFotoRuta, JTextField txtCodigoUsuarioLogin, JTextField txtContraseñaLogin) {
        Connection con = null;
        CallableStatement cs = null;
        CConexion objCon = new CConexion();
        try {                      
            String sql = "UPDATE Profesores SET Nombre = ?, Apellido = ?, FechaNacimiento = ?, Dni = ?, Especialidad = ?, Direccion = ?, Telefono = ?, Email = ?, Foto = ? " +
                         "WHERE ProfesorID = ?";
            cs=objCon.EstablecerConexion().prepareCall(sql);
//            pst = objCon.prepareStatement(sql);

            cs.setString(1, txtNomPro.getText());
            cs.setString(2, txtApellidosPro.getText());

            // Convertir la fecha de JDateChooser a un tipo de dato SQL
            java.util.Date fecha = jFechaNa.getDate();
            java.sql.Date fechaSQL = (fecha != null) ? new java.sql.Date(fecha.getTime()) : null;
            cs.setDate(3, fechaSQL);

            cs.setString(4, txtDNIPro.getText());
            cs.setString(5, jComboBoxEspecialidad.getSelectedItem().toString());
            cs.setString(6, txtDireccionPro.getText());
            cs.setString(7, txtTelefonoPro.getText());
            cs.setString(8, txtCorreoPro.getText());

            // Cargar la foto desde el archivo seleccionado, si existe
            if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(9, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(9, java.sql.Types.BLOB);
            }

            cs.setInt(10, Integer.parseInt(txtCodPro.getText())); // ID Profesor

            // Ejecutar la consulta
            int rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos del profesor modificados exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos del estudiante. Verifica el ID.");
            }

            // Actualizar también los datos del usuario si es necesario
            String sqlUsuario = "UPDATE Usuarios SET Contraseña = ?, Foto = ? WHERE ProfesorID = ?";
            cs=objCon.EstablecerConexion().prepareCall(sqlUsuario);
            cs.setString(1, txtContraseñaLogin.getText());
//            cs.setString(2,txtUsuarioLogin.getText()); // ID del estudiante
            
             if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(2, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(2, java.sql.Types.BLOB);
            }
            cs.setInt(3, Integer.parseInt(txtCodPro.getText())); // Usar ID profesor

            rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos del usuario modificados exitosamente!");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el profesor: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void SeleccionarProfesor(JTable tabla, JTextField txtCodPro, JTextField txtNomPro, JTextField txtApellidosPro, JDateChooser jFechaNa, JTextField txtDNIPro, JComboBox<String> jComboBoxEspecialidad, JTextField txtDireccionPro, JTextField txtTelefonoPro, JTextField txtCorreoPro, JLabel lblMostrarFoto, JTextField txtFotoRuta, JTextField txtCodigoUsuarioLogin, JTextField txtContraseñaLogin) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodPro.setText(tabla.getValueAt(fila, 0).toString());
                txtNomPro.setText(tabla.getValueAt(fila, 1).toString());
                txtApellidosPro.setText(tabla.getValueAt(fila, 2).toString());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Object fechaEntregaObj = tabla.getValueAt(fila, 3);
                if (fechaEntregaObj != null) {
                    java.util.Date fechanacstr = dateFormat.parse(fechaEntregaObj.toString());
                    jFechaNa.setDate(fechanacstr);
                } else {
                    jFechaNa.setDate(null);
                }
                txtDNIPro.setText(tabla.getValueAt(fila, 4).toString());
                String grado = (tabla.getValueAt(fila, 5) != null) ? tabla.getValueAt(fila, 5).toString() : "";
                if (!grado.isEmpty()) {
                    jComboBoxEspecialidad.setSelectedItem(grado);
                } else {
                    jComboBoxEspecialidad.setSelectedIndex(0);
                }
                
                txtDireccionPro.setText(tabla.getValueAt(fila, 6).toString());
                txtTelefonoPro.setText(tabla.getValueAt(fila, 7).toString());
                txtCorreoPro.setText(tabla.getValueAt(fila, 8).toString());

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
               txtFotoRuta.setText(tabla.getValueAt(fila, 11).toString());

                 // Datos de la tabla Usuario
                txtCodigoUsuarioLogin.setText(tabla.getValueAt(fila, 12).toString());
                txtContraseñaLogin.setText(tabla.getValueAt(fila, 13).toString());
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar el Profesor: " + e.toString());
        }
    }

    public void EliminarProfesor(JTextField txtCodigoUsuarioLogin, JTextField txtCodPro) {
        CConexion objc=new CConexion();
        
        String query= "DELETE FROM Usuarios WHERE Usuarios.NombreUsuario=?";       
        String query2= "DELETE FROM Profesores WHERE Profesores.ProfesorID=?";
        System.out.println("Codigo Usuario: "+ txtCodigoUsuarioLogin.getText());
        try {            
            CallableStatement cs=objc.EstablecerConexion().prepareCall(query);
            cs.setString(1, txtCodigoUsuarioLogin.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
            
            cs=objc.EstablecerConexion().prepareCall(query2);
            cs.setInt(1,Integer.parseInt(txtCodPro.getText()));
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Profesor ELIMINADO");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar"+e.toString());
        }  
    }
    
}
