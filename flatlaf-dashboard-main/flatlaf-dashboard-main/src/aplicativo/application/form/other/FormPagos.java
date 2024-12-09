package aplicativo.application.form.other;
import AdminEscuela.Dao.CEstudianteDAO;
import AdminEscuela.Dao.CPagoDAO;
import AdminEscuela.Modelo.ModelPago;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * @author Wilson
 */
public class FormPagos extends javax.swing.JPanel {
    public FormPagos() {
        initComponents();
        CEstudianteDAO estu=new CEstudianteDAO();
        estu.MostrarTablaEstudiante(JTableMostrarEstudiantes);
        CPagoDAO pago=new CPagoDAO();
        pago.MostrarTablaPago(JTableMostrarPagos);
    }

    public void limpiarcampos(){
        txtCodPago.setText("");
        txtCodEstudi.setText("");
        txtMontoPa.setText("");
        jComboBoxCuota.setSelectedIndex(0);
        jComboBoxMetoPa.setSelectedIndex(0);
        jComboBoxEstaPag.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new AdminEscuela.Vista.componentes.Header();
        panelTransparent1 = new aplicativo.swing.PanelTransparent();
        jLabel5 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodPago = new javax.swing.JTextField();
        lblEstudiante = new javax.swing.JLabel();
        txtCodEstudi = new javax.swing.JTextField();
        btnAgregarPago = new javax.swing.JButton();
        btnEditarPago = new javax.swing.JButton();
        btnEliminarPago = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        txtMontoPa = new javax.swing.JTextField();
        lblMetodoPago = new javax.swing.JLabel();
        jComboBoxMetoPa = new javax.swing.JComboBox<>();
        scrollBarCustom1 = new aplicativo.swing.scrollbar.ScrollBarCustom();
        jComboBoxEstaPag = new javax.swing.JComboBox<>();
        lblCuota = new javax.swing.JLabel();
        jComboBoxCuota = new javax.swing.JComboBox<>();
        panelTransparent2 = new aplicativo.swing.PanelTransparent();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableMostrarPagos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        panelTransparent3 = new aplicativo.swing.PanelTransparent();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableMostrarEstudiantes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel5.setText("CRUD Pagos");

        lblCodigo.setText("Nº :");

        txtCodPago.setEnabled(false);

        lblEstudiante.setText("Estudiante:");

        txtCodEstudi.setEnabled(false);

        btnAgregarPago.setText("Asignar");
        btnAgregarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPagoActionPerformed(evt);
            }
        });

        btnEditarPago.setText("Editar");
        btnEditarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPagoActionPerformed(evt);
            }
        });

        btnEliminarPago.setText("Eliminar");
        btnEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPagoActionPerformed(evt);
            }
        });

        lblEstado.setText("Estado:");

        lblMonto.setText("Monto:");

        lblMetodoPago.setText("Método de pago:");

        jComboBoxMetoPa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "MasterCard", "BCP", "InterBank", "BBVA" }));

        jComboBoxEstaPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Pagado", " " }));
        jComboBoxEstaPag.setEnabled(false);

        lblCuota.setText("Cuota:");

        jComboBoxCuota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Cuota 1", "Cuota 2", "Cuota 3", "Cuota 4", "Cuota 5" }));

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jComboBoxEstaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                            .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(txtMontoPa))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMetodoPago)
                                .addComponent(lblCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxMetoPa, 0, 140, Short.MAX_VALUE)
                                .addComponent(jComboBoxCuota, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodEstudi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodPago, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnAgregarPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarPago)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstudiante)
                    .addComponent(txtCodEstudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonto)
                    .addComponent(txtMontoPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuota)
                    .addComponent(jComboBoxCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetodoPago)
                    .addComponent(jComboBoxMetoPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(jComboBoxEstaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPago)
                    .addComponent(btnEditarPago)
                    .addComponent(btnEliminarPago))
                .addGap(37, 37, 37)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 363, Short.MAX_VALUE))
        );

        JTableMostrarPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableMostrarPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMostrarPagosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTableMostrarPagos);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel6.setText("Mostrar Pagos");

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTableMostrarEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableMostrarEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMostrarEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTableMostrarEstudiantes);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel7.setText("Mostrar Estudiantes");

        javax.swing.GroupLayout panelTransparent3Layout = new javax.swing.GroupLayout(panelTransparent3);
        panelTransparent3.setLayout(panelTransparent3Layout);
        panelTransparent3Layout.setHorizontalGroup(
            panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelTransparent3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTransparent3Layout.setVerticalGroup(
            panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransparent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTransparent3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTransparent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPagoActionPerformed
        int filaSeleccionada = JTableMostrarPagos.getSelectedRow();

        if (filaSeleccionada == -1) {            
            JOptionPane.showMessageDialog(
                this,
                "Por favor, seleccione un registro de la tabla para eliminar.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
            );
        } else {            
            int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de que desea eliminar este registro?",
                "Confirmación de eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                CPagoDAO objPago=new CPagoDAO();
                objPago.EliminarPago(txtCodPago);
                objPago.MostrarTablaPago(JTableMostrarPagos);
                System.out.println("Registro eliminado.");
            } else {
                System.out.println("Operación cancelada.");
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
            }
        }
        limpiarcampos();
    }//GEN-LAST:event_btnEliminarPagoActionPerformed

    private void btnEditarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPagoActionPerformed
        CPagoDAO objPago=new CPagoDAO();
        objPago.ModificarPago(txtCodPago, txtMontoPa, jComboBoxCuota, jComboBoxMetoPa, jComboBoxEstaPag);
        objPago.MostrarTablaPago(JTableMostrarPagos);
        limpiarcampos();
    }//GEN-LAST:event_btnEditarPagoActionPerformed

    private void btnAgregarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPagoActionPerformed
        if (txtCodEstudi.getText().isEmpty() || txtMontoPa.getText().isEmpty() || jComboBoxCuota.getSelectedItem().toString().isEmpty() ||
                jComboBoxMetoPa.getSelectedItem().toString().isEmpty() || jComboBoxEstaPag.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }else{
            ModelPago pago=new ModelPago();
            pago.setEstudianteID(Integer.parseInt(txtCodEstudi.getText()));
            
            DecimalFormat df = new DecimalFormat("#.##");
            pago.setMonto(Double.parseDouble(df.format(pago.getMonto())));
//            pago.setMonto(Double.parseDouble(txtMontoPa.getText()));
            pago.setCuota(jComboBoxCuota.getSelectedItem().toString());
            pago.setMetodoPago(jComboBoxMetoPa.getSelectedItem().toString());
            pago.setEstado(jComboBoxEstaPag.getSelectedItem().toString());          

            CPagoDAO objPago = new CPagoDAO();
            objPago.InsertarPagoEstud(pago);           
            objPago.MostrarTablaPago(JTableMostrarPagos);
            limpiarcampos();
        }
    }//GEN-LAST:event_btnAgregarPagoActionPerformed

    private void JTableMostrarEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMostrarEstudiantesMouseClicked
        CEstudianteDAO objEstu=new CEstudianteDAO();        
        objEstu.SeleccionarAsignEstudiante(JTableMostrarEstudiantes, txtCodEstudi);
    }//GEN-LAST:event_JTableMostrarEstudiantesMouseClicked

    private void JTableMostrarPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMostrarPagosMouseClicked
        CPagoDAO pago=new CPagoDAO();
        pago.SeleccionarPagosAsignados(JTableMostrarPagos,txtCodPago,txtCodEstudi,txtMontoPa,jComboBoxCuota,jComboBoxMetoPa,jComboBoxEstaPag );
    }//GEN-LAST:event_JTableMostrarPagosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableMostrarEstudiantes;
    private javax.swing.JTable JTableMostrarPagos;
    private javax.swing.JButton btnAgregarPago;
    private javax.swing.JButton btnEditarPago;
    private javax.swing.JButton btnEliminarPago;
    private AdminEscuela.Vista.componentes.Header header1;
    private javax.swing.JComboBox<String> jComboBoxCuota;
    private javax.swing.JComboBox<String> jComboBoxEstaPag;
    private javax.swing.JComboBox<String> jComboBoxMetoPa;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCuota;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblMetodoPago;
    private javax.swing.JLabel lblMonto;
    private aplicativo.swing.PanelTransparent panelTransparent1;
    private aplicativo.swing.PanelTransparent panelTransparent2;
    private aplicativo.swing.PanelTransparent panelTransparent3;
    private aplicativo.swing.scrollbar.ScrollBarCustom scrollBarCustom1;
    private javax.swing.JTextField txtCodEstudi;
    private javax.swing.JTextField txtCodPago;
    private javax.swing.JTextField txtMontoPa;
    // End of variables declaration//GEN-END:variables
}
