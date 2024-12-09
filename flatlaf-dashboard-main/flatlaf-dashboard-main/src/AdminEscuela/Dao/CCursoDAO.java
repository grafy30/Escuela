package AdminEscuela.Dao;

import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Modelo.ModelCurso;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Wilson
 */
public class CCursoDAO {

    public void MostrarTablaCurso(JTable tabla) {
        CConexion objCon = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion"); 
        modelo.addColumn("Grado");         
        tabla.setModel(modelo);
        // Consulta SQL corregida
        String sql = "SELECT CursoID, Nombre, Descripcion, Grado "                   
                   + "FROM Cursos ";                   
        Object[] datos = new Object[4]; 

        try (Connection conn = objCon.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getString("CursoID");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Descripcion");
                datos[3] = rs.getString("Grado");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        } 
    }

    public void SeleccionarCurso(JTable tabla, JTextField txtCodCurso, JTextField txtNomCurso, JTextField txtDescrCurso,JComboBox <String> jcombgrado ) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodCurso.setText(tabla.getValueAt(fila, 0).toString());
                txtNomCurso.setText(tabla.getValueAt(fila, 1).toString());
                txtDescrCurso.setText(tabla.getValueAt(fila, 2).toString());                
//                txtGradoCurso.setText(tabla.getValueAt(fila, 3).toString());                  
                String grado = (tabla.getValueAt(fila, 3) != null) ? tabla.getValueAt(fila, 3).toString() : "";
                if (!grado.isEmpty()) {
                    jcombgrado.setSelectedItem(grado);
                } else {
                    jcombgrado.setSelectedIndex(0);
                }
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar Curso: " + e.toString());
        }
    }

    public void InsertarCurso(ModelCurso curso) {
        CConexion con = new CConexion();
        CallableStatement cs =null;
        String sql = "INSERT INTO Cursos (Nombre, Descripcion, Grado) "
                + "VALUES (?, ?, ?)";
        try {
                cs=con.EstablecerConexion().prepareCall(sql);           
                cs.setString(1, curso.getNombre());
                cs.setString(2, curso.getDescripcion());                
                cs.setString(3, curso.getGrado());                
                cs.execute();
                JOptionPane.showMessageDialog(null, "CURSO AÑADIDO");
            } catch (SQLException ex) {      
                JOptionPane.showMessageDialog(null, "Error al insertar curso: " + ex.getMessage());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir número: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar: " + e.toString());
            }finally {
            try {
                    if (cs != null) cs.close();
                    if (con != null) con.CerrarConexion();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
                    }
            }
    }

    public void ModificarCurso(JTextField txtCodCurso, JTextField txtNomCurso, JTextField txtDescrCurso ,JComboBox <String> jComboBoxGrado) {
        CConexion con=new CConexion();
        CallableStatement cs=null;
        try {                      
            String sql = "UPDATE Cursos SET Nombre = ?, Descripcion = ? , Grado = ? " +
                         "WHERE CursoID = ?";
            cs=con.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtNomCurso.getText());
            cs.setString(2, txtDescrCurso.getText());         
            cs.setString(3, jComboBoxGrado.getSelectedItem().toString());                     
            cs.setInt(4, Integer.parseInt(txtCodCurso.getText())); // ID del estudiante
            cs.execute();
            JOptionPane.showMessageDialog(null, "CURSO MODIFICADO");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el curso: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.CerrarConexion();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }    

    public void EliminarCurso(JTextField txtCodCurso) {
        CConexion con=new CConexion();  
        CallableStatement cs=null;
        String sql= "DELETE FROM Cursos WHERE CursoID=? ";                       
        try {            
            cs=con.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtCodCurso.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "CURSO ELIMINADO");            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el curso"+e.toString());
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
    
    public void SeleccionarAsignCurso (JTable tabla, JTextField txtCodCur) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0){
                txtCodCur.setText(tabla.getValueAt(fila, 0).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar el Curso: " + e.toString());
        }
    }
}
