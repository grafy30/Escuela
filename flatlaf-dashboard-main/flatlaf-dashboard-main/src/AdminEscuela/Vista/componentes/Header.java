package AdminEscuela.Vista.componentes;

import aplicativo.swing.PanelTransparent;
import java.awt.event.ActionListener;
import AdminEscuela.Conexion.UserSession;

public class Header extends PanelTransparent {

    public Header() {
        initComponents();
        setTransparent(0.5f);
        UserSession user=new UserSession();
        lbUserName.setText(user.getNombreUsuario());
        lbID.setText(String.valueOf(user.getUsuarioID()));
        if (user.getRolId()==1) {
            lbRole.setText("Administrador");
        }else if (user.getRolId()==2) {
            lbRole.setText("Jefe de Área");
        }else if (user.getRolId()==3) {
            lbRole.setText("Profesor");
        }else if (user.getRolId()==4) {
            lbRole.setText("Estudiante");
        }else if (user.getRolId()==5) {
            lbRole.setText("Recepcionista");
        }else if (user.getRolId()==6) {
            lbRole.setText("Padre de Familia");
        }        
    }

    public void addMenuEvent(ActionListener event) {
//        cmdMenu.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUserName = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonBadges1 = new aplicativo.swing.ButtonBadges();
        buttonBadges2 = new aplicativo.swing.ButtonBadges();
        imageAvatar1 = new aplicativo.swing.ImageAvatar();
        lbUserName1 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        lbUserName3 = new javax.swing.JLabel();

        lbUserName.setText("User Name");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lbUserName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUserName3)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbUserName)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbRole)
                        .addGap(26, 26, 26)))
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
                            .addComponent(lbUserName)
                            .addComponent(lbUserName3))
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
                                .addComponent(lbID))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private aplicativo.swing.ButtonBadges buttonBadges1;
    private aplicativo.swing.ButtonBadges buttonBadges2;
    private aplicativo.swing.ImageAvatar imageAvatar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JLabel lbUserName1;
    private javax.swing.JLabel lbUserName3;
    // End of variables declaration//GEN-END:variables
}
