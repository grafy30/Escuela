package AdminEscuela.Dao;

import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Modelo.ModelEstudiante;
import AdminEscuela.Modelo.ModelUsuario;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
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
                                      JTextField txtCorreoEst, JLabel lblMostrarFoto,JTextField ruta,JTextField codUser,JTextField PassUser) {
                                      
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
                
                Object RutaFoto = tabla.getValueAt(fila, 11);
                ruta.setText(RutaFoto != null ? RutaFoto.toString() : "");

                 // Datos de la tabla Usuario
                Object nombre = tabla.getValueAt(fila, 12);
                Object apellido = tabla.getValueAt(fila, 13);
                codUser.setText(nombre != null ? nombre.toString() : "");
                PassUser.setText(apellido != null ? apellido.toString() : ""); 

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
                   + "e.Telefono, e.Email, e.FechaRegistro, e.Foto, e.RutaFot, u.NombreUsuario, u.Contraseña "
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

    public void InsertarEstudianteYUsuario(ModelEstudiante estudiante, ModelUsuario usuario) {
        CConexion con = new CConexion();
        String sqlEstudiante = "INSERT INTO Estudiantes (Nombre, Apellido, FechaNacimiento, Dni, Grado, Direccion, Telefono, Email, FechaRegistro, Foto, RutaFot)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), ?, ?)";
        String sqlUsuario = "INSERT INTO Usuarios (NombreUsuario, Contraseña, RolID, EstudianteID, Foto) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = con.EstablecerConexion()) {
            conn.setAutoCommit(false); // Inicia la transacción

            try (PreparedStatement cs = conn.prepareStatement(sqlEstudiante, Statement.RETURN_GENERATED_KEYS)) {
                // Inserta en la tabla Estudiantes
                cs.setString(1, estudiante.getNombre());
                cs.setString(2, estudiante.getApellido());
                cs.setDate(3, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
                cs.setString(4, estudiante.getDni());
                cs.setString(5, estudiante.getGrado());
                cs.setString(6, estudiante.getDireccion());
                cs.setString(7, estudiante.getTelefono());
                cs.setString(8, estudiante.getEmail());
                cs.setBytes(9, estudiante.getFoto());
                cs.setString(10, estudiante.getRutfo());

                int rowsAffected = cs.executeUpdate(); // Ejecuta la sentencia

                if (rowsAffected == 0) {
                    throw new SQLException("Fallo al insertar estudiante, no se generaron filas.");
                }

                // Obtén el ID generado
                try (ResultSet rs = cs.getGeneratedKeys()) {
                    if (rs.next()) {
                        int EstudianteID = rs.getInt(1);

                        // Inserta en la tabla Usuarios
                        try (PreparedStatement pr = conn.prepareStatement(sqlUsuario)) {
                            pr.setString(1, usuario.getNombreUsuario());
                            pr.setString(2, usuario.getContraseña());
                            pr.setInt(3, usuario.getRolID());
                            pr.setInt(4, EstudianteID);
                            pr.setBytes(5, usuario.getFoto());
                            pr.executeUpdate();
                        }
                    } else {
                        throw new SQLException("No se pudo obtener el ID generado para el estudiante.");
                    }
                }

                conn.commit(); // Confirma la transacción
                JOptionPane.showMessageDialog(null, "Estudiante y usuario añadidos correctamente.");
            } catch (SQLException ex) {
                conn.rollback(); // Revierte la transacción si ocurre un error
                JOptionPane.showMessageDialog(null, "Error al insertar datos: " + ex.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }        
    }

    public void ModificarEstudiante(JTextField txtCodEst, JTextField txtNomEst, JTextField txtApellidosEst, JDateChooser jFechaNa, JTextField txtDNIEst,
            JComboBox<String> jComboBoxSemeEst, JTextField txtDireccionEst, JTextField txtTelefonoEst, JTextField txtCorreoEst, JLabel lblMostrarFoto, 
            JTextField txtFotoRuta, JTextField txtUsuarioLogin, JTextField txtContraseñaLogin) {
                
        CallableStatement cs = null;
        CConexion con = new CConexion();
        try {                      
            String sql = "UPDATE Estudiantes SET Nombre = ?, Apellido = ?, FechaNacimiento = ?, Dni = ?, Grado = ?, Direccion = ?, Telefono = ?, Email = ?, Foto = ? " +
                         "WHERE EstudianteID = ?";
            cs=con.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtNomEst.getText());
            cs.setString(2, txtApellidosEst.getText());           
            java.util.Date fecha = jFechaNa.getDate();
            java.sql.Date fechaSQL = (fecha != null) ? new java.sql.Date(fecha.getTime()) : null;
            cs.setDate(3, fechaSQL);
            cs.setString(4, txtDNIEst.getText());
            cs.setString(5, jComboBoxSemeEst.getSelectedItem().toString());
            cs.setString(6, txtDireccionEst.getText());
            cs.setString(7, txtTelefonoEst.getText());
            cs.setString(8, txtCorreoEst.getText());
            // Cargar la foto desde el archivo seleccionado, si existe
            if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(9, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(9, java.sql.Types.BLOB);
            }
            cs.setInt(10, Integer.parseInt(txtCodEst.getText())); 
            
            int rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos del estudiante modificados exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos del estudiante. Verifica el ID.");
            }

            // Actualizar también los datos del usuario si es necesario
            String sqlUsuario = "UPDATE Usuarios SET Contraseña = ?, Foto = ? WHERE EstudianteID = ?";
            cs=con.EstablecerConexion().prepareCall(sqlUsuario);
            cs.setString(1, txtContraseñaLogin.getText());            
            if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(2, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(2, java.sql.Types.BLOB);
            }
            cs.setInt(3, Integer.parseInt(txtCodEst.getText())); // Usar id estudiante
            
            rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos del usuario modificados exitosamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el estudiante: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.CerrarConexion();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void EliminarEstudiante(JTextField txtCodUser,JTextField txtCodEstu) {
        CConexion objc=new CConexion();
        
        String query= "DELETE FROM Usuarios WHERE Usuarios.NombreUsuario=?";       
        String query2= "DELETE FROM Estudiantes WHERE Estudiantes.EstudianteID=?";
        System.out.println("Codigo Usuario: "+ txtCodUser.getText());
        try {            
            CallableStatement cs=objc.EstablecerConexion().prepareCall(query);
            cs.setString(1, txtCodUser.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
            
            cs=objc.EstablecerConexion().prepareCall(query2);
            cs.setInt(1,Integer.parseInt(txtCodEstu.getText()));
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE ELIMINADO");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar"+e.toString());
        }  
    }
    
    public void SeleccionarAsignEstudiante (JTable tabla, JTextField txtCodEst) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0){
                txtCodEst.setText(tabla.getValueAt(fila, 0).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar el estudiante: " + e.toString());
        }
    }

}
