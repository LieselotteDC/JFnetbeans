/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package justfeed.GUI;

import Database.*;
import Logica.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author UGent
 */
public class Aanpassenklantgegevens extends javax.swing.JFrame {

    private static final Aanpassenklantgegevens aanpassengegevensklant = new Aanpassenklantgegevens();
    public static JFrame myCaller;
    public Database d = new Database();
    public Aanpassenklantgegevens() {
        initComponents();
    }

    public static Aanpassenklantgegevens getInstance(Profielklant caller)
    {
        myCaller = caller;
        return aanpassengegevensklant;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNieuweVoornaam = new javax.swing.JTextField();
        txtNieuweNaam = new javax.swing.JTextField();
        txtNieuwEmail = new javax.swing.JTextField();
        btnAanpassen = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtHuidigPaswoord = new javax.swing.JPasswordField();
        txtNieuwPaswoord = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        txtNieuwPaswoord2 = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pas uw gegevens aan");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nieuwe voornaam:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nieuwe naam:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nieuw e-mailadres:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Huidig paswoord:");

        btnAanpassen.setBackground(new java.awt.Color(0, 0, 0));
        btnAanpassen.setForeground(new java.awt.Color(255, 255, 255));
        btnAanpassen.setText("Aanpassen");
        btnAanpassen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wijzigingOpslaan(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Login:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nieuw paswoord:");

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("*");

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("* Verplicht");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Herhaal nieuw paswoord:");

        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("*");

        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("*");

        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("*");

        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("*");

        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("*");

        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setText("*");

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

        jMenu1.setBackground(new java.awt.Color(255, 153, 0));
        jMenu1.setText("Home");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHuidigPaswoord, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAanpassen, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNieuweNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNieuwEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNieuweVoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNieuwPaswoord, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                        .addComponent(txtNieuwPaswoord2))
                                    .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(btnAanpassen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHuidigPaswoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNieuwPaswoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel19))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNieuwPaswoord2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNieuweVoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNieuweNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel16))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNieuwEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13))
                        .addGap(61, 61, 61)
                        .addComponent(jLabel14)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wijzigingOpslaan(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wijzigingOpslaan
        String login = txtLogin.getText();
        String huidigPaswoord = txtHuidigPaswoord.getText();
        String voornaam = txtNieuweVoornaam.getText();
        String naam = txtNieuweNaam.getText();
        String email = txtNieuwEmail.getText();
        String nieuwPaswoord = txtNieuwPaswoord.getText();
        String nieuwPaswoord2 = txtNieuwPaswoord2.getText();
        EmailValidator checkemail = new EmailValidator();
         
         if(naam.isEmpty() || voornaam.isEmpty() || login.isEmpty() || huidigPaswoord.isEmpty() || nieuwPaswoord.isEmpty() || nieuwPaswoord2.isEmpty() || email.isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Gelieve alle verplichte velden in te vullen.");
        if (login.isEmpty()){
        txtLogin.requestFocus();
        }    
        else if(huidigPaswoord.isEmpty()){
        txtHuidigPaswoord.requestFocus();
        }
        else if(nieuwPaswoord.isEmpty()){
        txtNieuwPaswoord.requestFocus();
        }
        else if(nieuwPaswoord2.isEmpty()){
        txtNieuwPaswoord.requestFocus();
        }
        else if (voornaam.isEmpty()){
        txtNieuweVoornaam.requestFocus();
        }
        else if(naam.isEmpty()){
        txtNieuweNaam.requestFocus();
        }
        else if(email.isEmpty()){
        txtNieuwEmail.requestFocus();
        }
        }
        else if(!d.loginBestaat(login)){
        JOptionPane.showMessageDialog(null, "U heeft een foute login ingevoerd. Probeer opnieuw.");
        txtLogin.setText("");
        txtHuidigPaswoord.setText("");
        txtLogin.requestFocus();
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        }
        //else 
        else if ((huidigPaswoord.length() < 8) || (huidigPaswoord.contains(login))){
        JOptionPane.showMessageDialog(null, "Ongeldig huidig paswoord. Probeer opnieuw.");
        txtHuidigPaswoord.setText("");
        txtHuidigPaswoord.requestFocus(); 
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        }
        else if(!huidigPaswoord.equals(d.ophalenPaswoord(login))){
         JOptionPane.showMessageDialog(null, "Uw login en huidig paswoord stemmen niet overeen. Probeer opnieuw.");
        txtLogin.setText("");
        txtHuidigPaswoord.setText("");
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        txtLogin.requestFocus(); 
        }
        else if ((nieuwPaswoord.length() < 8) || (nieuwPaswoord.contains(login))){
        JOptionPane.showMessageDialog(null, "Uw nieuw paswoord moet minstens 8 tekens bevatten en mag de login niet bevatten. Probeer opnieuw.");
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        txtNieuwPaswoord.requestFocus();
        txtHuidigPaswoord.setText("");
        }
        else if(!nieuwPaswoord.equals(nieuwPaswoord2)){
        JOptionPane.showMessageDialog(null, "Uw nieuw paswoord bevat niet tweemaal dezelfde waarde. Probeer opnieuw.");  
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        txtNieuwPaswoord.requestFocus();
        txtHuidigPaswoord.setText("");
        }
        else if(nieuwPaswoord.equals(huidigPaswoord)){
        JOptionPane.showMessageDialog(null, "Uw nieuw paswoord moet verschillen van uw huidig paswoord. Probeer opnieuw."); 
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        txtNieuwPaswoord.requestFocus();
        txtHuidigPaswoord.setText("");
        }
        else if(!checkemail.validate(email)){
        JOptionPane.showMessageDialog(null, "Het opgegeven e-mailadres heeft niet de vereiste syntax. Probeer opnieuw");
        txtNieuwEmail.setText("");
        txtHuidigPaswoord.setText("");
        txtNieuwEmail.requestFocus();
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        }
        else if(d.emailBestaat(email)){
        JOptionPane.showMessageDialog(null, "Het opgegeven e-mailadres is reeds in gebruik. Probeer opnieuw");
        txtNieuwEmail.setText("");
        txtHuidigPaswoord.setText("");
        txtNieuwEmail.requestFocus();
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        }       
        else{
         Klant nieuweKlant = new Klant(login, nieuwPaswoord, email, naam, voornaam);
         Klant huidigeKlant = d.getKlant(login);
         d.updateKlant(huidigeKlant, nieuweKlant);
         aanpassengegevensklant.hide();
         myCaller.show();
        txtLogin.setText("");
        txtHuidigPaswoord.setText("");
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        txtNieuweNaam.setText("");
        txtNieuweVoornaam.setText("");
        txtNieuwEmail.setText("");
        }
    }//GEN-LAST:event_wijzigingOpslaan

    private void back(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back
        aanpassengegevensklant.hide();
        myCaller.show();
                txtLogin.setText("");
        txtHuidigPaswoord.setText("");
        txtNieuwPaswoord.setText("");
        txtNieuwPaswoord2.setText("");
        txtNieuweNaam.setText("");
        txtNieuweVoornaam.setText("");
        txtNieuwEmail.setText("");
    }//GEN-LAST:event_back

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aanpassenklantgegevens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aanpassenklantgegevens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aanpassenklantgegevens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aanpassenklantgegevens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aanpassenklantgegevens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAanpassen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPasswordField txtHuidigPaswoord;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNieuwEmail;
    private javax.swing.JPasswordField txtNieuwPaswoord;
    private javax.swing.JPasswordField txtNieuwPaswoord2;
    private javax.swing.JTextField txtNieuweNaam;
    private javax.swing.JTextField txtNieuweVoornaam;
    // End of variables declaration//GEN-END:variables
}
