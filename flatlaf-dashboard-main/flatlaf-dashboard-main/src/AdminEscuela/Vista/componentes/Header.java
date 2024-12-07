package AdminEscuela.Vista.componentes;

import aplicativo.swing.PanelTransparent;
import AdminEscuela.Conexion.UserSession;
import AdminEscuela.Modelo.ModelUsuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Header extends PanelTransparent {

    public Header() {
        initComponents();
        setTransparent(0.5f);              
        UserSession user=new UserSession();
//        UserSession user = UserSession.getInstancia();
        lbCodUser.setText(user.getNombreUsuario());
        lbID.setText(String.valueOf(user.getUsuarioID()));
        lblNombUser.setText(user.getNombreCompleto());
        switch (user.getRolId()) {
            case 1:
                lbRole.setText("Administrador");
                break;
            case 2:
                lbRole.setText("Profesor");
                break;
            case 3:
                lbRole.setText("Estudiante");
                break;
            case 4:
                lbRole.setText("Estudiante");
                break;
            case 5:
                lbRole.setText("Recepcionista");
                break;
            case 6:
                lbRole.setText("Padre de Familia");
                break;
            default:
                lbRole.setText("Rol Desconocido");
        }
         
        byte[] fotoBytes = user.getFoto();
        int anchoFijo = 39; // Ancho fijo de la imagen
        int altoFijo = 39;  // Alto fijo de la imagen

        if (fotoBytes != null && fotoBytes.length > 0) {
            try {
                // Convertir los bytes en un BufferedImage
                ByteArrayInputStream bis = new ByteArrayInputStream(fotoBytes);
                BufferedImage bufferedImage = ImageIO.read(bis);

                // Escalar la imagen al tamaño fijo
                if (bufferedImage != null) {
                    Image imgEscalada = bufferedImage.getScaledInstance(
                        anchoFijo,
                        altoFijo,
                        Image.SCALE_SMOOTH
                    );
                    imageAvatar1.setIcon(new ImageIcon(imgEscalada));
                } else {
                    System.err.println("No se pudo convertir la imagen recuperada.");
                }
            } catch (IOException e) {
                System.err.println("Error al procesar la imagen: " + e.getMessage());
            }
        } else {
            // Imagen predeterminada si no hay datos en la base de datos
            ImageIcon icono = new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
            Image imgEscalada = icono.getImage().getScaledInstance(
                anchoFijo,
                altoFijo,
                Image.SCALE_SMOOTH
            );
            imageAvatar1.setIcon(new ImageIcon(imgEscalada));
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCodUser = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonBadges1 = new aplicativo.swing.ButtonBadges();
        buttonBadges2 = new aplicativo.swing.ButtonBadges();
        imageAvatar1 = new aplicativo.swing.ImageAvatar();
        lbUserName1 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        lbUserName3 = new javax.swing.JLabel();
        lbUserName2 = new javax.swing.JLabel();
        lblNombUser = new javax.swing.JLabel();

        lbCodUser.setText("CodUser");

        lbRole.setText("Admin");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicativo/icon/png/message.png"))); // NOI18N
        buttonBadges1.setBadges(4);

        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicativo/icon/png/notification.png"))); // NOI18N
        buttonBadges2.setBadges(8);
        buttonBadges2.setEffectColor(new java.awt.Color(0, 0, 0));

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicativo/icon/jpg/profile.jpg"))); // NOI18N

        lbUserName1.setText("Id:");

        lbID.setText("<Id>");

        lbUserName3.setText("Hola,");

        lbUserName2.setText("Cod:");

        lblNombUser.setText("NombreUser");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lbUserName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbID)
                .addGap(27, 27, 27)
                .addComponent(lbUserName2)
                .addGap(18, 18, 18)
                .addComponent(lbCodUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUserName3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lbRole))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblNombUser)))
                .addGap(26, 26, 26)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbUserName3)
                            .addComponent(lblNombUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRole))
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbUserName1)
                                .addComponent(lbID)
                                .addComponent(lbUserName2)
                                .addComponent(lbCodUser))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private aplicativo.swing.ButtonBadges buttonBadges1;
    private aplicativo.swing.ButtonBadges buttonBadges2;
    private aplicativo.swing.ImageAvatar imageAvatar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCodUser;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName1;
    private javax.swing.JLabel lbUserName2;
    private javax.swing.JLabel lbUserName3;
    private javax.swing.JLabel lblNombUser;
    // End of variables declaration//GEN-END:variables
}
