package aplicativo.application.form.other;

import AdminEscuela.Dao.CAsignarProfeCursoDAO;
import AdminEscuela.Dao.CCursoDAO;
import AdminEscuela.Dao.CProfesorDAO;
import AdminEscuela.Modelo.ModelCurso;
import AdminEscuela.Modelo.ModeloAsignarProfeCurs;
import javax.swing.JOptionPane;
/**
 * @author Wilson
 */
public class FormCurso extends javax.swing.JPanel {

    public FormCurso() {
        initComponents();
        CCursoDAO curso=new CCursoDAO();
        curso.MostrarTablaCurso(JTablaMostrarCurso);
        CProfesorDAO profe=new CProfesorDAO();
        profe.MostrarTablaProfesor(JTablaMostrarProfesor);
        CAsignarProfeCursoDAO asi=new CAsignarProfeCursoDAO();
        asi.MostrarTablaAsignaciones(JTablaMostrarProfesorAsig);
    }
    
    public void limpiarcampos(){
        txtCodCurso.setText("");
        txtNomCurso.setText("");
        txtDescrCurso.setText("");
        txtCodAsignar.setText("");
        txtCodCursoAsi.setText("");
        txtCodProAsi.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new AdminEscuela.Vista.componentes.Header();
        panelTransparent1 = new aplicativo.swing.PanelTransparent();
        jLabel5 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodCurso = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNomCurso = new javax.swing.JTextField();
        btnAgregarCurso = new javax.swing.JButton();
        btnEditarCurso = new javax.swing.JButton();
        btnEliminarCurso = new javax.swing.JButton();
        lblDescrip = new javax.swing.JLabel();
        txtDescrCurso = new javax.swing.JTextField();
        scrollBarCustom1 = new aplicativo.swing.scrollbar.ScrollBarCustom();
        panelTransparent2 = new aplicativo.swing.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablaMostrarCurso = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        panelTransparent3 = new aplicativo.swing.PanelTransparent();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTablaMostrarProfesor = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        panelTransparent4 = new aplicativo.swing.PanelTransparent();
        jLabel8 = new javax.swing.JLabel();
        lblCodigo1 = new javax.swing.JLabel();
        txtCodAsignar = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtCodCursoAsi = new javax.swing.JTextField();
        btnAsignarCurso = new javax.swing.JButton();
        btnEditarAsignarC = new javax.swing.JButton();
        btnEliminarAsignC = new javax.swing.JButton();
        lblDescrip1 = new javax.swing.JLabel();
        txtCodProAsi = new javax.swing.JTextField();
        scrollBarCustom2 = new aplicativo.swing.scrollbar.ScrollBarCustom();
        panelTransparent5 = new aplicativo.swing.PanelTransparent();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTablaMostrarProfesorAsig = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel5.setText("CRUD Cursos");

        lblCodigo.setText("CursoID:");

        txtCodCurso.setEnabled(false);

        lblNombre.setText("Nombre:");

        btnAgregarCurso.setText("Añadir");
        btnAgregarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCursoActionPerformed(evt);
            }
        });

        btnEditarCurso.setText("Editar");
        btnEditarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCursoActionPerformed(evt);
            }
        });

        btnEliminarCurso.setText("Eliminar");
        btnEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCursoActionPerformed(evt);
            }
        });

        lblDescrip.setText("Descripcion:");

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addComponent(lblDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtDescrCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNomCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnAgregarCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCurso)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNomCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescrip)
                    .addComponent(txtDescrCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCurso)
                    .addComponent(btnEditarCurso)
                    .addComponent(btnEliminarCurso))
                .addGap(41, 41, 41)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTablaMostrarCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTablaMostrarCurso.setOpaque(false);
        JTablaMostrarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablaMostrarCursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTablaMostrarCurso);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel7.setText("Tabla de Cursos Resgistrados");

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JTablaMostrarProfesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTablaMostrarProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablaMostrarProfesorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTablaMostrarProfesor);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel6.setText("Tabla de Profesores");

        javax.swing.GroupLayout panelTransparent3Layout = new javax.swing.GroupLayout(panelTransparent3);
        panelTransparent3.setLayout(panelTransparent3Layout);
        panelTransparent3Layout.setHorizontalGroup(
            panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelTransparent3Layout.setVerticalGroup(
            panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel8.setText("Asignar Cursos");

        lblCodigo1.setText("Nº");

        txtCodAsignar.setEnabled(false);

        lblNombre1.setText("CursoID:");

        txtCodCursoAsi.setEnabled(false);

        btnAsignarCurso.setText("Asignar");
        btnAsignarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarCursoActionPerformed(evt);
            }
        });

        btnEditarAsignarC.setText("Editar");
        btnEditarAsignarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAsignarCActionPerformed(evt);
            }
        });

        btnEliminarAsignC.setText("Eliminar");
        btnEliminarAsignC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAsignCActionPerformed(evt);
            }
        });

        lblDescrip1.setText("ProfesorID:");

        txtCodProAsi.setEnabled(false);

        javax.swing.GroupLayout panelTransparent4Layout = new javax.swing.GroupLayout(panelTransparent4);
        panelTransparent4.setLayout(panelTransparent4Layout);
        panelTransparent4Layout.setHorizontalGroup(
            panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent4Layout.createSequentialGroup()
                .addGroup(panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollBarCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelTransparent4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTransparent4Layout.createSequentialGroup()
                                .addComponent(lblDescrip1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtCodProAsi, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTransparent4Layout.createSequentialGroup()
                                .addGroup(panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCodCursoAsi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelTransparent4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnAsignarCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarAsignarC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarAsignC)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelTransparent4Layout.setVerticalGroup(
            panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo1)
                    .addComponent(txtCodAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre1)
                    .addComponent(txtCodCursoAsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescrip1)
                    .addComponent(txtCodProAsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsignarCurso)
                    .addComponent(btnEditarAsignarC)
                    .addComponent(btnEliminarAsignC))
                .addGap(41, 41, 41)
                .addComponent(scrollBarCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTablaMostrarProfesorAsig.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTablaMostrarProfesorAsig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablaMostrarProfesorAsigMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTablaMostrarProfesorAsig);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel9.setText("Profesores Asignados");

        javax.swing.GroupLayout panelTransparent5Layout = new javax.swing.GroupLayout(panelTransparent5);
        panelTransparent5.setLayout(panelTransparent5Layout);
        panelTransparent5Layout.setHorizontalGroup(
            panelTransparent5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .addGroup(panelTransparent5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTransparent5Layout.setVerticalGroup(
            panelTransparent5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent5Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1075, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(panelTransparent4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTransparent3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTransparent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTransparent5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTransparent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTransparent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTransparent5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTransparent4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTablaMostrarCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablaMostrarCursoMouseClicked
        CCursoDAO curso=new CCursoDAO();
        curso.SeleccionarCurso(JTablaMostrarCurso, txtCodCurso, txtNomCurso, txtDescrCurso);
        CAsignarProfeCursoDAO asig=new CAsignarProfeCursoDAO();
        asig.SeleccionarCurso(JTablaMostrarCurso, txtCodCursoAsi);
    }//GEN-LAST:event_JTablaMostrarCursoMouseClicked

    private void btnEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCursoActionPerformed
        int filaSeleccionada = JTablaMostrarCurso.getSelectedRow();

        if (filaSeleccionada == -1) {
                // Si no hay fila seleccionada, mostrar mensaje de advertencia
                JOptionPane.showMessageDialog(
                        this,
                        "Por favor, seleccione un registro de la tabla para eliminar.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                    );
            } else {
                // Mostrar mensaje de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(
                        this,
                        "¿Está seguro de que desea eliminar este registro?",
                        "Confirmación de eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                    );

                if (confirmacion == JOptionPane.YES_OPTION) {
                        CCursoDAO objCurso=new CCursoDAO();
                        objCurso.EliminarCurso(txtCodCurso);
                        objCurso.MostrarTablaCurso(JTablaMostrarCurso);
                        System.out.println("Registro eliminado.");
                    } else {
                        System.out.println("Operación cancelada.");
                        JOptionPane.showMessageDialog(this, "Operación cancelada.");
                    }
            }
        limpiarcampos();
    }//GEN-LAST:event_btnEliminarCursoActionPerformed

    private void btnEditarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCursoActionPerformed
        CCursoDAO objcurso=new CCursoDAO();
        objcurso.ModificarCurso(txtCodCurso, txtNomCurso, txtDescrCurso);
        objcurso.MostrarTablaCurso(JTablaMostrarCurso);
        limpiarcampos();
    }//GEN-LAST:event_btnEditarCursoActionPerformed

    private void btnAgregarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCursoActionPerformed
        if (txtNomCurso.getText().isEmpty() || txtDescrCurso.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            }
        else{
                ModelCurso curso=new ModelCurso();
                curso.setNombre(txtNomCurso.getText());
                curso.setDescripcion(txtDescrCurso.getText());                
                CCursoDAO objcurso=new CCursoDAO();               
                objcurso.InsertarCurso(curso);                                
                objcurso.MostrarTablaCurso(JTablaMostrarCurso);
                limpiarcampos();                    
            }
    }//GEN-LAST:event_btnAgregarCursoActionPerformed

    private void btnAsignarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarCursoActionPerformed
        if (txtCodCursoAsi.getText().isEmpty() || txtCodProAsi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            }
        else{
                ModeloAsignarProfeCurs asi=new ModeloAsignarProfeCurs();
                asi.setProfesorID(Integer.parseInt(txtCodProAsi.getText()));                
                asi.setCursoID(Integer.parseInt(txtCodCursoAsi.getText()));
                CAsignarProfeCursoDAO objAsi=new CAsignarProfeCursoDAO();               
                objAsi.InsertarAsign(asi);                                
                objAsi.MostrarTablaAsignaciones(JTablaMostrarProfesorAsig);
                limpiarcampos();                    
            }
    }//GEN-LAST:event_btnAsignarCursoActionPerformed

    private void btnEditarAsignarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAsignarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarAsignarCActionPerformed

    private void btnEliminarAsignCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAsignCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarAsignCActionPerformed

    private void JTablaMostrarProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablaMostrarProfesorMouseClicked
        CProfesorDAO objPro=new CProfesorDAO();
        objPro.SeleccionarAsignProfe(JTablaMostrarProfesor, txtCodProAsi);
    }//GEN-LAST:event_JTablaMostrarProfesorMouseClicked

    private void JTablaMostrarProfesorAsigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablaMostrarProfesorAsigMouseClicked
         CAsignarProfeCursoDAO objAsig=new CAsignarProfeCursoDAO();
         objAsig.SeleccionarAsignarProfeCur(JTablaMostrarProfesorAsig, txtCodAsignar,txtCodProAsi, txtCodCursoAsi);
    }//GEN-LAST:event_JTablaMostrarProfesorAsigMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablaMostrarCurso;
    private javax.swing.JTable JTablaMostrarProfesor;
    private javax.swing.JTable JTablaMostrarProfesorAsig;
    private javax.swing.JButton btnAgregarCurso;
    private javax.swing.JButton btnAsignarCurso;
    private javax.swing.JButton btnEditarAsignarC;
    private javax.swing.JButton btnEditarCurso;
    private javax.swing.JButton btnEliminarAsignC;
    private javax.swing.JButton btnEliminarCurso;
    private AdminEscuela.Vista.componentes.Header header1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblDescrip;
    private javax.swing.JLabel lblDescrip1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private aplicativo.swing.PanelTransparent panelTransparent1;
    private aplicativo.swing.PanelTransparent panelTransparent2;
    private aplicativo.swing.PanelTransparent panelTransparent3;
    private aplicativo.swing.PanelTransparent panelTransparent4;
    private aplicativo.swing.PanelTransparent panelTransparent5;
    private aplicativo.swing.scrollbar.ScrollBarCustom scrollBarCustom1;
    private aplicativo.swing.scrollbar.ScrollBarCustom scrollBarCustom2;
    private javax.swing.JTextField txtCodAsignar;
    private javax.swing.JTextField txtCodCurso;
    private javax.swing.JTextField txtCodCursoAsi;
    private javax.swing.JTextField txtCodProAsi;
    private javax.swing.JTextField txtDescrCurso;
    private javax.swing.JTextField txtNomCurso;
    // End of variables declaration//GEN-END:variables
}
