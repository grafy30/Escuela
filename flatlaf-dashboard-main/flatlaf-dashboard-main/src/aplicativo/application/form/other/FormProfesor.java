package aplicativo.application.form.other;

import AdminEscuela.Dao.CProfesorDAO;
import AdminEscuela.Dao.CUsuarioDAO;
import AdminEscuela.Modelo.ModelProfesor;
import AdminEscuela.Modelo.ModelUsuario;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Wilson
 */
public class FormProfesor extends javax.swing.JPanel {
    String filename;
    byte[] Profesor_image;
    public FormProfesor() {
        initComponents();
        CProfesorDAO profe= new CProfesorDAO();
        CUsuarioDAO user=new CUsuarioDAO();
        profe.MostrarTablaProfesor(JTablaMostrarProfesor);
    }

    public void limpiarcampos(){
        txtCodPro.setText("");
        txtNomPro.setText("");
        txtApellidosPro.setText("");
        jFechaNa.setDate(null);
        txtDNIPro.setText("");  
        jComboBoxEspecialidad.setSelectedIndex(0);
        txtDireccionPro.setText("");
        txtTelefonoPro.setText("");
        txtCorreoPro.setText("");
        txtFotoRuta.setText("");
        ImageIcon icono=new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
        lblMostrarFoto.setIcon(icono);
        txtCodigoUsuarioLogin.setText("");
        txtContraseñaLogin.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new AdminEscuela.Vista.componentes.Header();
        panelTransparent1 = new aplicativo.swing.PanelTransparent();
        jLabel5 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodPro = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNomPro = new javax.swing.JTextField();
        lblFechaNa = new javax.swing.JLabel();
        btnAgregarPro = new javax.swing.JButton();
        btnEditarPro = new javax.swing.JButton();
        btnEliminarPro = new javax.swing.JButton();
        jFechaNa = new com.toedter.calendar.JDateChooser();
        lblTele = new javax.swing.JLabel();
        txtDNIPro = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccionPro = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        txtFotoRuta = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreoPro = new javax.swing.JTextField();
        lblMostrarFoto = new javax.swing.JLabel();
        btnBuscarFoto = new javax.swing.JButton();
        lblCodigoUsuarioLogin = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        txtApellidosPro = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        txtTelefonoPro = new javax.swing.JTextField();
        lblSemestre = new javax.swing.JLabel();
        jComboBoxEspecialidad = new javax.swing.JComboBox<>();
        scrollBarCustom1 = new aplicativo.swing.scrollbar.ScrollBarCustom();
        lblContraseñaLogin = new javax.swing.JLabel();
        txtCodigoUsuarioLogin = new javax.swing.JTextField();
        txtContraseñaLogin = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablaMostrarProfesor = new javax.swing.JTable();

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel5.setText("CRUD Profesor");

        lblCodigo.setText("Codigo:");

        txtCodPro.setEnabled(false);

        lblNombres.setText("Nombres:");

        lblFechaNa.setText("Fecha Nacimiento:");

        btnAgregarPro.setText("Añadir");
        btnAgregarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProActionPerformed(evt);
            }
        });

        btnEditarPro.setText("Editar");
        btnEditarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProActionPerformed(evt);
            }
        });

        btnEliminarPro.setText("Eliminar");
        btnEliminarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProActionPerformed(evt);
            }
        });

        lblTele.setText("Telefono:");

        lblDireccion.setText("Direccion:");

        lblFoto.setText("Foto:");

        txtFotoRuta.setEnabled(false);

        lblCorreo.setText("Correo:");

        lblMostrarFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMostrarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicativo/icon/jpg/foto_fondo.jpg"))); // NOI18N
        lblMostrarFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblMostrarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMostrarFoto.setMaximumSize(new java.awt.Dimension(120, 149));
        lblMostrarFoto.setMinimumSize(new java.awt.Dimension(120, 149));
        lblMostrarFoto.setPreferredSize(new java.awt.Dimension(120, 149));

        btnBuscarFoto.setText("Buscar");
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });

        lblCodigoUsuarioLogin.setText("Codigo Usuario:");

        lblApellidos.setText("Apellidos:");

        lblDNI.setText("DNI:");

        lblSemestre.setText("Especialidad:");

        jComboBoxEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Master", "Doctor", "PHD" }));

        lblContraseñaLogin.setText("Contraseña:");

        txtCodigoUsuarioLogin.setEnabled(false);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addComponent(lblTele, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefonoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                            .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtApellidosPro))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addComponent(lblFechaNa)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDireccionPro, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                            .addComponent(lblSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                            .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDNIPro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addComponent(lblMostrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnBuscarFoto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCorreoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFotoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 3, Short.MAX_VALUE)))))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                    .addComponent(lblCodigoUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodigoUsuarioLogin))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                    .addComponent(lblContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(btnAgregarPro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarPro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarPro)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidosPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNa)
                    .addComponent(jFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI)
                    .addComponent(txtDNIPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemestre)
                    .addComponent(jComboBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccionPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTele)
                    .addComponent(txtTelefonoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFoto)
                    .addComponent(lblMostrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFotoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoUsuarioLogin)
                    .addComponent(txtCodigoUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseñaLogin)
                    .addComponent(txtContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPro)
                    .addComponent(btnEditarPro)
                    .addComponent(btnEliminarPro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        JTablaMostrarProfesor.setOpaque(false);
        JTablaMostrarProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablaMostrarProfesorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTablaMostrarProfesor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                        .addGap(0, 0, 0))
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProActionPerformed
        if (txtNomPro.getText().isEmpty() || txtApellidosPro.getText().isEmpty() || jFechaNa.getDateFormatString().isEmpty() || txtDNIPro.getText().isEmpty() ||
            jComboBoxEspecialidad.getSelectedItem().toString().isEmpty() || txtDireccionPro.getText().isEmpty() || txtTelefonoPro.getText().isEmpty() || txtCorreoPro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }else{
            ModelProfesor profesor=new ModelProfesor();
            profesor.setNombre(txtNomPro.getText());
            profesor.setApellido(txtApellidosPro.getText());
            profesor.setFechaNacimiento(jFechaNa.getDate());

            String dni = txtDNIPro.getText().trim();
            if (dni.length() == 8 && dni.matches("\\d+")) {
                profesor.setDni(dni);
            } else {
                JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 dígitos numéricos.");
                return; // Salir de la función si el DNI es inválido
            }
            String email = txtCorreoPro.getText().trim();
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un correo electrónico válido.");
                return;
            }
            profesor.setEmail(email);
            profesor.setEspecialidad(jComboBoxEspecialidad.getSelectedItem().toString());
            profesor.setDireccion(txtDireccionPro.getText());
            profesor.setTelefono(txtTelefonoPro.getText());
            profesor.setEmail(txtCorreoPro.getText());
            try {
                File ruta=new File(txtFotoRuta.getText());
                byte[] icono=new byte[(int)ruta.length()];
                InputStream input= new FileInputStream(ruta);
                input.read(icono);
                profesor.setFoto(icono);
            } catch (Exception e) {
                profesor.setFoto(null);
            }
            profesor.setRutfo(txtFotoRuta.getText());
            // Crear objeto Usuario
            ModelUsuario usuario = new ModelUsuario();
            usuario.setNombreUsuario(txtCodigoUsuarioLogin.getText());
            usuario.setContraseña(new String(txtContraseñaLogin.getText()));
            usuario.setRolID(3); // Profesor
            usuario.setFoto(profesor.getFoto()); // Usar la misma foto que el estudiante

            // Llamar al método de inserción
            CProfesorDAO profe = new CProfesorDAO();
            profe.InsertarProfesorYUsuario(profesor, usuario);
            profe.MostrarTablaProfesor(JTablaMostrarProfesor);
            limpiarcampos();           
        }
    }//GEN-LAST:event_btnAgregarProActionPerformed

    private void btnEditarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProActionPerformed
        CProfesorDAO profe = new CProfesorDAO();
        profe.ModificarProfesor(txtCodPro, txtNomPro, txtApellidosPro, jFechaNa, txtDNIPro, jComboBoxEspecialidad, txtDireccionPro,
            txtTelefonoPro, txtCorreoPro,lblMostrarFoto,txtFotoRuta,txtCodigoUsuarioLogin,txtContraseñaLogin);
        profe.MostrarTablaProfesor(JTablaMostrarProfesor);
        limpiarcampos();
    }//GEN-LAST:event_btnEditarProActionPerformed

    private void btnEliminarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProActionPerformed
        int filaSeleccionada = JTablaMostrarProfesor.getSelectedRow();

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
                CProfesorDAO profe=new CProfesorDAO();
                profe.EliminarProfesor(txtCodigoUsuarioLogin,txtCodPro);
                profe.MostrarTablaProfesor(JTablaMostrarProfesor);
                System.out.println("Registro eliminado.");
            } else {
                System.out.println("Operación cancelada.");
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
            }
        }
        limpiarcampos();
    }//GEN-LAST:event_btnEliminarProActionPerformed

    private void JTablaMostrarProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablaMostrarProfesorMouseClicked
        CProfesorDAO objPro=new CProfesorDAO();
        objPro.SeleccionarProfesor(JTablaMostrarProfesor, txtCodPro, txtNomPro, txtApellidosPro, jFechaNa, txtDNIPro,
            jComboBoxEspecialidad, txtDireccionPro, txtTelefonoPro, txtCorreoPro,lblMostrarFoto,txtFotoRuta,txtCodigoUsuarioLogin,txtContraseñaLogin);

    }//GEN-LAST:event_JTablaMostrarProfesorMouseClicked

    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        filename = file.getAbsolutePath();
        txtFotoRuta.setText(filename);

        // Mostrar imagen en el lblMostrarFoto
        ImageIcon icon = new ImageIcon(filename);
        Image image = icon.getImage().getScaledInstance(lblMostrarFoto.getWidth(), lblMostrarFoto.getHeight(), Image.SCALE_SMOOTH);
        lblMostrarFoto.setIcon(new ImageIcon(image));

        // Guardar la imagen como bytes
        try {
            File imageFile = new File(filename);
            FileInputStream fis = new FileInputStream(imageFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int readNum; (readNum = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, readNum);
            }
            Profesor_image = bos.toByteArray();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablaMostrarProfesor;
    private javax.swing.JButton btnAgregarPro;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnEditarPro;
    private javax.swing.JButton btnEliminarPro;
    private AdminEscuela.Vista.componentes.Header header1;
    private javax.swing.JComboBox<String> jComboBoxEspecialidad;
    private com.toedter.calendar.JDateChooser jFechaNa;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoUsuarioLogin;
    private javax.swing.JLabel lblContraseñaLogin;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNa;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblMostrarFoto;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblTele;
    private aplicativo.swing.PanelTransparent panelTransparent1;
    private aplicativo.swing.scrollbar.ScrollBarCustom scrollBarCustom1;
    private javax.swing.JTextField txtApellidosPro;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtCodigoUsuarioLogin;
    private javax.swing.JTextField txtContraseñaLogin;
    private javax.swing.JTextField txtCorreoPro;
    private javax.swing.JTextField txtDNIPro;
    private javax.swing.JTextField txtDireccionPro;
    private javax.swing.JTextField txtFotoRuta;
    private javax.swing.JTextField txtNomPro;
    private javax.swing.JTextField txtTelefonoPro;
    // End of variables declaration//GEN-END:variables
}
