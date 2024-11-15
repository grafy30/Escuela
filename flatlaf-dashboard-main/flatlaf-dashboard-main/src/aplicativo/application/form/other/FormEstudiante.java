package aplicativo.application.form.other;

import AdminEscuela.Dao.CEstudianteDAO;
import AdminEscuela.Modelo.ModelEstudiante;
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
public class FormEstudiante extends javax.swing.JPanel {
    
    String filename;
    byte[] Estudiente_image;
    public FormEstudiante() {
        initComponents();
        CEstudianteDAO doctor=new CEstudianteDAO();
        doctor.MostrarTablaDoctor(JTablaMostrarEstu);
    }
    
    public void limpiarcampos(){
        txtCodEst.setText("");
        txtNomEst.setText("");
        txtApellidosEst.setText("");
        jFechaNa.setDate(null);
        txtDNIEst.setText("");  
        jComboBoxSemeEst.setSelectedIndex(0);
        txtDireccionEst.setText("");
        txtTelefonoEst.setText("");
        txtCorreoEst.setText("");
        txtFotoRuta.setText("");
        ImageIcon icono=new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
        lblMostrarFoto.setIcon(icono);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new AdminEscuela.Vista.componentes.Header();
        panelTransparent1 = new aplicativo.swing.PanelTransparent();
        jLabel5 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodEst = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNomEst = new javax.swing.JTextField();
        lblFechaNa = new javax.swing.JLabel();
        btnAgregarEst = new javax.swing.JButton();
        btnEditarEst = new javax.swing.JButton();
        btnEliminarEst = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablaMostrarEstu = new javax.swing.JTable();
        jFechaNa = new com.toedter.calendar.JDateChooser();
        lblTele = new javax.swing.JLabel();
        txtDNIEst = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccionEst = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        txtFotoRuta = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreoEst = new javax.swing.JTextField();
        lblMostrarFoto = new javax.swing.JLabel();
        btnBuscarFoto = new javax.swing.JButton();
        lblRuta = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        txtApellidosEst = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        txtTelefonoEst = new javax.swing.JTextField();
        lblSemestre = new javax.swing.JLabel();
        jComboBoxSemeEst = new javax.swing.JComboBox<>();
        scrollBarCustom1 = new aplicativo.swing.scrollbar.ScrollBarCustom();

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel5.setText("CRUD Estudiante");

        lblCodigo.setText("Codigo:");

        txtCodEst.setEnabled(false);

        lblNombres.setText("Nombres:");

        lblFechaNa.setText("Fecha Nacimiento:");

        btnAgregarEst.setText("Añadir");
        btnAgregarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstActionPerformed(evt);
            }
        });

        btnEditarEst.setText("Editar");
        btnEditarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEstActionPerformed(evt);
            }
        });

        btnEliminarEst.setText("Eliminar");
        btnEliminarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEstActionPerformed(evt);
            }
        });

        JTablaMostrarEstu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTablaMostrarEstu.setOpaque(false);
        JTablaMostrarEstu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablaMostrarEstuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTablaMostrarEstu);

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

        lblRuta.setText("Ruta:");

        lblApellidos.setText("Apellidos:");

        lblDNI.setText("DNI:");

        lblSemestre.setText("Semestre:");

        jComboBoxSemeEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1er Semestre ", "2do Semestre", "3ro Semestre", "4to Semestre", "5to Semestre", "6to Semestre", "7mo Semestre", "8vo Semestre", "9no Semestre", "10mo Semestre" }));

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addComponent(lblTele, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefonoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCorreoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(lblMostrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnBuscarFoto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtApellidosEst))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                    .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodEst, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNomEst, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addComponent(lblFechaNa)
                                .addGap(18, 18, 18)
                                .addComponent(jFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccionEst, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                    .addComponent(lblSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxSemeEst, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                    .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDNIEst, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addComponent(lblRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addComponent(btnAgregarEst)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEditarEst)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminarEst))
                                    .addComponent(txtFotoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNomEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidosEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNa)
                    .addComponent(jFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI)
                    .addComponent(txtDNIEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemestre)
                    .addComponent(jComboBoxSemeEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccionEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTele)
                    .addComponent(txtTelefonoEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreoEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFoto)
                            .addComponent(lblMostrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRuta)
                            .addComponent(txtFotoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBuscarFoto))
                .addGap(18, 18, 18)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarEst)
                    .addComponent(btnEditarEst)
                    .addComponent(btnEliminarEst))
                .addGap(99, 99, 99))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
            .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEstActionPerformed
        if (txtNomEst.getText().isEmpty() || txtApellidosEst.getText().isEmpty() || jFechaNa.getDateFormatString().isEmpty() || txtDNIEst.getText().isEmpty() || 
            jComboBoxSemeEst.getSelectedItem().toString().isEmpty() || txtDireccionEst.getText().isEmpty() || txtTelefonoEst.getText().isEmpty() || txtCorreoEst.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }else{
            ModelEstudiante estudiante=new ModelEstudiante();
            estudiante.setNombre(txtNomEst.getText());
            estudiante.setApellido(txtApellidosEst.getText());
            estudiante.setFechaNacimiento(jFechaNa.getDate()); 

            String dni = txtDNIEst.getText().trim();
            if (dni.length() == 8 && dni.matches("\\d+")) {
                estudiante.setDni(dni);
            } else {
                JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 dígitos numéricos.");
                return; // Salir de la función si el DNI es inválido
            }
            estudiante.setDni(dni);  
            estudiante.setGrado(jComboBoxSemeEst.getSelectedItem().toString());
            estudiante.setDireccion(txtDireccionEst.getText());
            estudiante.setTelefono(txtTelefonoEst.getText());
            estudiante.setEmail(txtCorreoEst.getText());

            try {
                File ruta=new File(txtFotoRuta.getText());
                byte[] icono=new byte[(int)ruta.length()];
                InputStream input= new FileInputStream(ruta);
                input.read(icono);
                estudiante.setFoto(icono);
            } catch (Exception e) {
                estudiante.setFoto(null);
            }
            CEstudianteDAO objDoc=new CEstudianteDAO();
            objDoc.InsertarEstudiante(estudiante);
            objDoc.MostrarTablaDoctor(JTablaMostrarEstu);
            limpiarcampos();
        }
        
    }//GEN-LAST:event_btnAgregarEstActionPerformed

    private void btnEditarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEstActionPerformed
        //        AutorDAO objAutor=new AutorDAO();
        //        objAutor.ModificarAutor(txtCodDoc,txtNomDoc, txtAutorApe);
        //        objAutor.MostrarTablaAutor(JTablaMostrarDoctor);
        //        txtCodDoc.setText("");
        //        txtNomDoc.setText("");
        //        txtAutorApe.setText("");
    }//GEN-LAST:event_btnEditarEstActionPerformed

    private void btnEliminarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEstActionPerformed
        //        AutorDAO objDis=new AutorDAO();
        //        objDis.EliminarAutor(txtCodDoc);
        //        objDis.MostrarTablaAutor(JTablaMostrarDoctor);
        //        txtCodDoc.setText("");
        //        txtNomDoc.setText("");
        //        txtAutorApe.setText("");
    }//GEN-LAST:event_btnEliminarEstActionPerformed

    private void JTablaMostrarEstuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablaMostrarEstuMouseClicked
        CEstudianteDAO objDoc=new CEstudianteDAO();
        objDoc.SeleccionarEstudiante(JTablaMostrarEstu, txtCodEst, txtNomEst, txtApellidosEst, jFechaNa, txtDNIEst, jComboBoxSemeEst, txtDireccionEst, txtTelefonoEst, txtCorreoEst,lblMostrarFoto,txtFotoRuta);
    }//GEN-LAST:event_JTablaMostrarEstuMouseClicked

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
            Estudiente_image = bos.toByteArray();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablaMostrarEstu;
    private javax.swing.JButton btnAgregarEst;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnEditarEst;
    private javax.swing.JButton btnEliminarEst;
    private AdminEscuela.Vista.componentes.Header header1;
    private javax.swing.JComboBox<String> jComboBoxSemeEst;
    private com.toedter.calendar.JDateChooser jFechaNa;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNa;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblMostrarFoto;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblTele;
    private aplicativo.swing.PanelTransparent panelTransparent1;
    private aplicativo.swing.scrollbar.ScrollBarCustom scrollBarCustom1;
    private javax.swing.JTextField txtApellidosEst;
    private javax.swing.JTextField txtCodEst;
    private javax.swing.JTextField txtCorreoEst;
    private javax.swing.JTextField txtDNIEst;
    private javax.swing.JTextField txtDireccionEst;
    private javax.swing.JTextField txtFotoRuta;
    private javax.swing.JTextField txtNomEst;
    private javax.swing.JTextField txtTelefonoEst;
    // End of variables declaration//GEN-END:variables
}
