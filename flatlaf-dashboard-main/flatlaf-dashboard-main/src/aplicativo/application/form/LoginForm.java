package aplicativo.application.form;

import AdminEscuela.Conexion.CConexion;
import AdminEscuela.Conexion.SeguridadUtil;
import AdminEscuela.Conexion.UserSession;
import AdminEscuela.Modelo.ModelUsuario;
import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import aplicativo.application.Application;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JPanel {
    
    private HashMap<String, ModelUsuario> usuarios;
    public LoginForm() {
        initComponents();
        init();
        cargarUsuariosYadministradores();
    }

    private void init() {
        setLayout(new MigLayout("al center center"));

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        
        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "User Name");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
    }
    private void cargarUsuariosYadministradores() {
        CConexion conexionPrueba = new CConexion();
        conexionPrueba.EstablecerConexion();
        usuarios = conexionPrueba.obtenerUsuarios(); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new aplicativo.application.form.PanelLogin();
        lbTitle = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lbPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Login");
        panelLogin1.add(lbTitle);

        lbUser.setText("User Name");
        panelLogin1.add(lbUser);
        panelLogin1.add(txtUser);

        lbPass.setText("Password");
        panelLogin1.add(lbPass);
        panelLogin1.add(txtPass);

        cmdLogin.setText("Login");
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });
        panelLogin1.add(cmdLogin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        String nombreUsuario = txtUser.getText();
        String contrasena = new String(txtPass.getPassword());

        ModelUsuario usuario = usuarios.get(nombreUsuario); // Buscar el usuario en la tabla de usuarios

//        if (usuario != null && usuario.getContraseña().equals(SeguridadUtil.hashPassword(contrasena))) {
        if (usuario != null && usuario.getContraseña().equals(contrasena)) {
            // Credenciales válidas
            int UsuarioID = usuario.getUsuarioID();
            String nombre = usuario.getNombreUsuario();
            int RolID = usuario.getRolID();

            // Guardamos los datos del usuario en la sesión
            UserSession.getInstancia().setUsuarioID(UsuarioID);
            UserSession.getInstancia().setNombreUsuario(nombreUsuario);
            UserSession.getInstancia().setRolId(RolID);
            
            System.out.println("Id: " + UsuarioID + " Nombre: " + nombre + " Rol: " + RolID);

            // Llamamos a login sin tener que pasar el rol como argumento
            Application.login();

        } else {
            // Credenciales incorrectas
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
        }
    }//GEN-LAST:event_cmdLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdLogin;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private aplicativo.application.form.PanelLogin panelLogin1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
