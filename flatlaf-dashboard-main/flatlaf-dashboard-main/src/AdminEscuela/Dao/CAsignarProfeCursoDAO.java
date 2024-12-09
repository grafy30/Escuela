package AdminEscuela.Dao;

import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Modelo.ModeloAsignarProfeCurs;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * @author Wilson
 */
public class CAsignarProfeCursoDAO {

    public void SeleccionarCurso(JTable tabla, JTextField txtCodCurso) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodCurso.setText(tabla.getValueAt(fila, 0).toString());                
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar Curso: " + e.toString());
        }
    }

    public void SeleccionarAsignarProfeCur(JTable tabla, JTextField txtCodAsi, JTextField txtCodProAsi, JTextField txtCodCurAsi) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodAsi.setText(tabla.getValueAt(fila, 0).toString());                
                String nombreProfesor=tabla.getValueAt(fila, 1).toString();
                String nombreCurso=tabla.getValueAt(fila, 2).toString();
                int[] ids=ObtenerIdsPorNombres(nombreProfesor,nombreCurso);
                int profeID=ids[0];
                int cursoID=ids[1];
                txtCodProAsi.setText(String.valueOf(profeID));
                txtCodCurAsi.setText(String.valueOf(cursoID));                
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar Curso: " + e.toString());
        }
    }
    
    public int[] ObtenerIdsPorNombres(String nombreProfesor, String nombreCurso) {
        CConexion con = new CConexion();
        String sql = "SELECT p.ProfesorID, c.CursoID "
                   + "FROM Profesores p "
                   + "JOIN Cursos c ON p.Nombre = ? AND c.Nombre = ?";
        int[] ids = new int[2]; // [0] = ProfesorID, [1] = CursoID
        try (PreparedStatement ps = con.EstablecerConexion().prepareStatement(sql)) {
            ps.setString(1, nombreProfesor);
            ps.setString(2, nombreCurso);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ids[0] = rs.getInt("ProfesorID");
                    ids[1] = rs.getInt("CursoID");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener IDs: " + e.getMessage());
        } finally {
            try {
                con.CerrarConexion();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
        return ids;
    }
    
    public void MostrarTablaAsignaciones(JTable tabla) {
        CConexion objCon = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas de la tabla
        modelo.addColumn("N");
        modelo.addColumn("Profesor");
        modelo.addColumn("Curso");           
        tabla.setModel(modelo);

        String sql = "SELECT a.ProfesorCursoID, p.Nombre AS Profesor, c.Nombre AS Curso "                   
                    + "FROM ProfesorCurso a "
                    + "JOIN Cursos c ON a.CursoID = c.CursoID "
                    + "JOIN Profesores p ON a.ProfesorID = p.ProfesorID ";

        Object[] datos = new Object[3];

        try (Connection conn = objCon.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getString("ProfesorCursoID");
                datos[1] = rs.getString("Profesor");
                datos[2] = rs.getString("Curso");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        } 
    }

    public void InsertarAsign(ModeloAsignarProfeCurs asi) {
        CConexion con = new CConexion();
        String sql= "INSERT INTO ProfesorCurso (ProfesorID,CursoID) VALUES(?,?)";
        try (PreparedStatement ps = con.EstablecerConexion().prepareStatement(sql)) {
            ps.setInt(1, asi.getProfesorID());
            ps.setInt(2, asi.getCursoID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "PROFESOR ASIGNADO CON ÉXITO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar asignación: " + ex.getMessage());
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

    public void ModificarAsignacion(JTextField txtCodAsignacion, JTextField txtNomProfesor, JTextField txtNomCurso) {     
        CConexion con=new CConexion();
        CallableStatement cs=null;
        try {                      
            String sql = "UPDATE ProfesorCurso SET ProfesorID = ?, CursoID = ? " +
                         "WHERE ProfesorCursoID = ?";
            cs=con.EstablecerConexion().prepareCall(sql);
            cs.setInt(1, Integer.parseInt(txtNomProfesor.getText()));
            cs.setInt(2, Integer.parseInt(txtNomCurso.getText()));         
            cs.setInt(3, Integer.parseInt(txtCodAsignacion.getText())); // ID del estudiante
            cs.execute();
            JOptionPane.showMessageDialog(null, "ASIGNACION MODIFICADA");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Asignacion: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.CerrarConexion();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void EliminarAsignacion(JTextField txtCodAsigna) {
        CConexion con=new CConexion();  
        CallableStatement cs=null;
        String sql= "DELETE FROM ProfesorCurso WHERE ProfesorCursoID=? ";                       
        try {            
            cs=con.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtCodAsigna.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "ASIGNACION ELIMINADA");            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar la asignacion"+e.toString());
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
}
