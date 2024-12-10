package AdminEscuela.Dao;

import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Conexion.UserSession;
import AdminEscuela.Modelo.ModelPago;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author Wilson
 */
public class CPagoDAO {

    public void InsertarPagoEstud(ModelPago pago) {
        CConexion con = new CConexion();
        String sqlPago = "INSERT INTO Pagos (EstudianteID, Monto, Cuota, FechaPago, MetodoPago, Estado )"
                + " VALUES ( ?, ?, ?, GETDATE(), ?, ?)";

        try (Connection conn = con.EstablecerConexion()) {
            conn.setAutoCommit(false); // Inicia la transacción

            try (PreparedStatement cs = conn.prepareStatement(sqlPago, Statement.RETURN_GENERATED_KEYS)) {
                cs.setInt(1, pago.getEstudianteID());
                cs.setDouble(2, pago.getMonto());
                cs.setString(3, pago.getCuota());
                cs.setString(4, pago.getMetodoPago());
                cs.setString(5, pago.getEstado());

                int rowsAffected = cs.executeUpdate(); // Ejecuta la sentencia
                if (rowsAffected == 0) {
                    throw new SQLException("Fallo al insertar pago, no se generaron filas.");
                }
                conn.commit(); // Confirma la transacción
                JOptionPane.showMessageDialog(null, "PAGO EXITOSO");
            } catch (SQLException ex) {
                conn.rollback(); // Revierte la transacción si ocurre un error
                JOptionPane.showMessageDialog(null, "Error al insertar datos: " + ex.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
    }

    public void MostrarTablaPago(JTable tabla) {
        CConexion objCon = new CConexion();
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas de la tabla
        modelo.addColumn("Nro");
        modelo.addColumn("Estudiante");
        modelo.addColumn("Monto");
        modelo.addColumn("Cuota");
        modelo.addColumn("FechaPago");
        modelo.addColumn("Metodo Pago");
        modelo.addColumn("Estado");
        tabla.setModel(modelo);
        // Consulta SQL corregida
        String sql = "SELECT p.PagoID, e.Nombre + ' ' + e.Apellido AS Estudiante, p.Monto, p.Cuota, "
                + "p.FechaPago, p.MetodoPago, p.Estado "
                + "FROM Pagos p "
                + "JOIN Estudiantes e ON p.EstudianteID = e.EstudianteID";

        Object[] datos = new Object[7]; // Número de columnas en la tabla

        try (Connection conn = objCon.EstablecerConexion(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getInt("PagoID");
                datos[1] = rs.getString("Estudiante");
                datos[2] = rs.getDouble("Monto");
                datos[3] = rs.getString("Cuota");
                datos[4] = rs.getDate("FechaPago").toString();
                datos[5] = rs.getString("MetodoPago");
                datos[6] = rs.getString("Estado");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los pagos: " + e.toString());
        }
    }

    public void EliminarPago(JTextField txtCodPago) {
        CConexion con = new CConexion();
        CallableStatement cs = null;
        String sql = "DELETE FROM Pagos WHERE PagoID = ? ";
        try {
            cs = con.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtCodPago.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "ASIGNACION DE PAGO ELIMINADA");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar la asignacion de pago" + e.toString());
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null) {
                    con.CerrarConexion();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void ModificarPago(JTextField txtCodPago, JTextField txtMontoPa, JComboBox<String> jComboBoxCuota, JComboBox<String> jComboBoxMetoPa, JComboBox<String> jComboBoxEstaPag) {
        CConexion con = new CConexion();
        CallableStatement cs = null;
        try {
            String sql = "UPDATE Pagos SET Monto = ?, Cuota = ?, MetodoPago = ?, Estado = ? "
                    + "WHERE PagoID = ?";
            cs = con.EstablecerConexion().prepareCall(sql);

            double monto = Double.parseDouble(txtMontoPa.getText());
            cs.setDouble(1, monto);

            cs.setString(2, jComboBoxCuota.getSelectedItem().toString());
            cs.setString(3, jComboBoxMetoPa.getSelectedItem().toString());
            cs.setString(4, jComboBoxEstaPag.getSelectedItem().toString());
            cs.setInt(5, Integer.parseInt(txtCodPago.getText())); // ID del estudiante
            cs.execute();
            JOptionPane.showMessageDialog(null, "ASIGNACION DE PAGO MODIFICADA");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Asignacion de pago: " + e.getMessage());
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null) {
                    con.CerrarConexion();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void SeleccionarPagosAsignados(JTable tabla, JTextField txtCodPago, JTextField txtCodEstudi, JTextField txtMontoPa, JComboBox<String> jComboBoxCuota,
            JComboBox<String> jComboBoxMetoPa, JComboBox<String> jComboBoxEstaPag) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodPago.setText(tabla.getValueAt(fila, 0).toString());

                String nombreEstudiante = tabla.getValueAt(fila, 1).toString();
                int idEstu = ObtenerIdEstu(nombreEstudiante);
                txtCodEstudi.setText(String.valueOf(idEstu));

                txtMontoPa.setText(tabla.getValueAt(fila, 2).toString());
                String cuota = (tabla.getValueAt(fila, 3) != null) ? tabla.getValueAt(fila, 3).toString() : "";
                if (!cuota.isEmpty()) {
                    jComboBoxCuota.setSelectedItem(cuota);
                } else {
                    jComboBoxCuota.setSelectedIndex(0);
                }
                String metodo = (tabla.getValueAt(fila, 4) != null) ? tabla.getValueAt(fila, 4).toString() : "";
                if (!metodo.isEmpty()) {
                    jComboBoxMetoPa.setSelectedItem(metodo);
                } else {
                    jComboBoxMetoPa.setSelectedIndex(0);
                }
                String estado = (tabla.getValueAt(fila, 5) != null) ? tabla.getValueAt(fila, 5).toString() : "";
                if (!estado.isEmpty()) {
                    jComboBoxEstaPag.setSelectedItem(estado);
                } else {
                    jComboBoxEstaPag.setSelectedIndex(0);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar registro: " + e.toString());
        }
    }

    public int ObtenerIdEstu(String nombreEstudiante) {
        CConexion con = new CConexion();
        String sql = "SELECT EstudianteID "
                + "FROM Estudiantes "
                + "WHERE CONCAT(Nombre, ' ', Apellido) = ?";
        int estudianteId = 0;
        try (PreparedStatement ps = con.EstablecerConexion().prepareStatement(sql)) {
            ps.setString(1, nombreEstudiante);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    estudianteId = rs.getInt("EstudianteID");
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
        return estudianteId;
    }

    public void MostrarTablaPagoAlumno(JTable tabla) {
        CConexion objCon = new CConexion();
        DefaultTableModel modelo = new DefaultTableModel();

        // Obtener el UsuarioID del usuario logeado
        UserSession user = new UserSession();
        int usuarioID = user.getUsuarioID();
        int estudianteID = obtenerEstudianteID(usuarioID); // Llama al método para obtener el EstudianteID

        if (estudianteID == -1) {
            JOptionPane.showMessageDialog(null, "No se encontró un estudiante asociado al usuario logeado.");
            return;
        }

        // Definir las columnas de la tabla
        modelo.addColumn("Nro");
        modelo.addColumn("Cuotas");
        modelo.addColumn("Monto");
        modelo.addColumn("Fecha Vencimiento");
        modelo.addColumn("Estado");
        modelo.addColumn("Metodo Pago");
        tabla.setModel(modelo);

        // Consulta SQL para obtener los pagos del estudiante
        String sql = "SELECT p.PagoID, p.Cuota, p.Monto, p.FechaPago, p.Estado, p.MetodoPago " +
                     "FROM Pagos p WHERE p.EstudianteID = ?";

        try (Connection conn = objCon.EstablecerConexion(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, estudianteID);
            ResultSet rs = pst.executeQuery();

            // Llenar la tabla con los resultados
            Object[] datos = new Object[6];
            while (rs.next()) {
                datos[0] = rs.getInt("PagoID");
                datos[1] = rs.getString("Cuota");
                datos[2] = rs.getDouble("Monto");
                datos[3] = rs.getDate("FechaPago").toString();
                datos[4] = rs.getString("Estado");
                datos[5] = rs.getString("MetodoPago");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los pagos: " + e.toString());
        }
    }
    public int obtenerEstudianteID(int usuarioID) {
        CConexion objCon = new CConexion();
        String sql = "SELECT EstudianteID FROM Usuarios WHERE UsuarioID = ?";
        try (Connection conn = objCon.EstablecerConexion(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, usuarioID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("EstudianteID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener EstudianteID: " + e.toString());
        }
        return -1; // Retorna un valor inválido si no se encuentra el EstudianteID
    }
}
