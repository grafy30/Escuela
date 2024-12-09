package AdminEscuela.Dao;

import java.sql.*;
import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Modelo.ModelMatricula;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author Muguruza
 */
public class CMatriculaDAO {

    public void MostrarTablaMatricula(JTable tabla) {
        CConexion objCon = new CConexion();
        DefaultTableModel modelo = new DefaultTableModel();

        //definimos las columnas de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("Estudiante");
        modelo.addColumn("Curso");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");

        //consulta sql
        String sql = "SELECT m.MatriculaID, (e.Nombre + ' ' + e.Apellido) AS Estudiante, c.Nombre AS Curso, m.FechaMatricula, m.Estado "
                + "FROM Matriculas m JOIN Estudiantes e ON m.EstudianteID = e.EstudianteID "
                + "JOIN Cursos c ON m.CursoID = c.CursoID";
        Object[] datos = new Object[5];

        try (Connection conn = objCon.EstablecerConexion(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                datos[0] = rs.getString("MatriculaID");
                datos[1] = rs.getString("Estudiante");
                datos[2] = rs.getString("Curso");
                datos[3] = rs.getString("FechaMatricula");
                datos[4] = rs.getString("Estado");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        }
    }

    public void InsertarMatricula(ModelMatricula matricula) {
        CConexion con = new CConexion();
        String sql = "INSERT INTO Matriculas (EstudianteID, CursoID, FechaMatricula, Estado) VALUES (?,?,GETDATE(),?)";
        try (PreparedStatement ps = con.EstablecerConexion().prepareStatement(sql)) {
            ps.setInt(1, matricula.getEstudianteID());
            ps.setInt(2, matricula.getCursoID());
            ps.setString(3, matricula.getEstado());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "MATRÍCULA INSERTADA CON ÉXITO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar la matrícula: " + ex.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir número: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + e.toString());
        } finally {
            try {
                con.CerrarConexion();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }

    }

    public void ModificarMatricula(JTextField txtCodMat, JComboBox<String> cbEstMat) {
        Connection con = null;
        CallableStatement cs = null;
        CConexion objCon = new CConexion();
        try {
            String sql = "UPDATE Matriculas SET Estado = ? WHERE MatriculaID = ?";
            cs = objCon.EstablecerConexion().prepareCall(sql);
            cs.setString(1, cbEstMat.getSelectedItem().toString());
            cs.setInt(2, Integer.parseInt(txtCodMat.getText()));
            
            int rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos de la matrícula modificada exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos de la matrícula. Verifica el ID.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la matrícula: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public void EliminarMatricula(JTextField txtCodMat) {
        CConexion con = new CConexion();  
        CallableStatement cs = null;
        String sql= "DELETE FROM Matriculas WHERE MatriculaID=? ";                       
        try {            
            cs = con.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtCodMat.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "MATRÍCULA ELIMINADA");            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar la matrícula."+e.toString());
        }  
        finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.CerrarConexion();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void SeleccionarMatricula(JTable tabla, JTextField txtCodMat, JTextField txtCodEst, JTextField txtCodCur, JComboBox<String> cbEstMat) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodMat.setText(tabla.getValueAt(fila, 0).toString());
                txtCodEst.setText(tabla.getValueAt(fila, 1).toString());
                txtCodCur.setText(tabla.getValueAt(fila, 2).toString());
                String estado =(tabla.getValueAt(fila, 3) != null) ? tabla.getValueAt(fila, 3).toString() : "";
                if (!estado.isEmpty()) {
                    cbEstMat.setSelectedItem(estado);
                } else {
                    cbEstMat.setSelectedIndex(0);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar la matrícula: " + e.toString());
        }
    }
}
