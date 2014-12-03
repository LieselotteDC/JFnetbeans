/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package justfeed.GUI;

import Database.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import Logica.*;
import javax.swing.JOptionPane;

/**
 *
 * @author UGent
 */
public class AanmaaknieuweTakeaway extends javax.swing.JFrame {
    

    private static final AanmaaknieuweTakeaway takeaway = new AanmaaknieuweTakeaway();
    public static JFrame myCaller;
    public Database d = new Database();
    
    public AanmaaknieuweTakeaway() {
        initComponents();
    }
    
    public static AanmaaknieuweTakeaway getInstance(Administrator admini)
    {
        myCaller = admini;
        return takeaway;
    }
    public static AanmaaknieuweTakeaway getInstance(Aanmaaknieuwevestiging vestiging)
    {
        myCaller = vestiging;
        return takeaway;
    }
    
    public static AanmaaknieuweTakeaway getInstance(AanmaakNieuwProduct nieuwproduct)
    {
        myCaller = nieuwproduct;
        return takeaway;
    }
    
    public static AanmaaknieuweTakeaway getInstance(AanmaakEenmaligeUniekeActie uniekeActie)
    {
        myCaller = uniekeActie;
        return takeaway;
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
        jButton1 = new javax.swing.JButton();
        txtNaam = new javax.swing.JTextField();
        txtCategorie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmailadres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu btnHomeknopAdministrator = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Voeg de nieuwe take-away toe");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Naam nieuwe takeaway:");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Aanmaken");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aanmakenNieuweTakeaway(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Categorieën:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setText("(vereiste syntax: categorie1;categorie2;categorie3;...;)");

        txtEmailadres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailadresActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("E-mailadres:");

        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("*");

        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setText("*");

        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setText("*");

        jLabel25.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 51, 51));
        jLabel25.setText("* Verplicht");

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

        btnHomeknopAdministrator.setBackground(new java.awt.Color(255, 153, 0));
        btnHomeknopAdministrator.setText("Home");
        btnHomeknopAdministrator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back(evt);
            }
        });
        btnHomeknopAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeknopAdministratorActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnHomeknopAdministrator);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addGap(21, 21, 21)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmailadres, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailadres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel22))
                        .addGap(47, 47, 47)
                        .addComponent(jButton1)))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back
       takeaway.hide();
       myCaller.show();
       txtNaam.setText("");
       txtEmailadres.setText("");
       txtCategorie.setText("");
    }//GEN-LAST:event_back


    private void aanmakenNieuweTakeaway(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aanmakenNieuweTakeaway
        String naam = txtNaam.getText();
        String categoriestring = txtCategorie.getText();
        String email = txtEmailadres.getText();
        EmailValidator checkemail = new EmailValidator();
        
        if(naam.isEmpty() || categoriestring.isEmpty() ||  email.isEmpty()){
        JOptionPane.showMessageDialog(null, "Gelieve alle verplichte velden in te vullen.");
        if (naam.isEmpty()){
        txtNaam.requestFocus();
        }
        else if(categoriestring.isEmpty()){
        txtCategorie.requestFocus();
        }
        else if(email.isEmpty()){
        txtEmailadres.requestFocus();
        }
        }
        else if(!checkemail.validate(email)){
        JOptionPane.showMessageDialog(null, "Het opgegeven e-mailadres heeft niet de vereiste syntax. Probeer opnieuw");
        txtEmailadres.setText("");
        txtEmailadres.requestFocus();
        }
        else if(d.emailBestaatTakeaway(email)){
        JOptionPane.showMessageDialog(null, "Het opgegeven e-mailadres is reeds in gebruik. Probeer opnieuw");
        txtEmailadres.setText("");
        txtEmailadres.requestFocus();
        }       
        else if(d.take_AwayBestaat(naam)){
            JOptionPane.showMessageDialog(null, "Deze Take-Away bestaat reeds. Probeer opnieuw.");
            txtNaam.setText("");
            txtNaam.requestFocus();
            txtCategorie.setText("");
            txtEmailadres.setText("");
        }
        else if(categoriestring.charAt(categoriestring.length()-1) != ';'){
                JOptionPane.showMessageDialog(null, "De ingevoerde categorie(ën) hebben niet de vereiste syntax. Probeer opnieuw.");
                txtCategorie.setText("");
            }
        else{
            Take_Away ta = new Take_Away(naam,email,0);
            d.addTake_Away(ta);
            int i = 0;
            while (i>=0 && i <(categoriestring.length()-1)) { 
            String categorie = categoriestring.substring(i, categoriestring.indexOf(';'));
            d.addCategorieFromTake_Away(categorie, ta);
            categoriestring = categoriestring.substring(categoriestring.indexOf(';')+1);
            }
            JOptionPane.showMessageDialog(null,"De Take-Away werd succesvol toegevoegd. \n Vergeet geen vestiging toe te voegen aan deze Take-Away alvorens een product toe te voegen.");
            takeaway.hide();
            myCaller.show();
            txtNaam.setText("");
            txtCategorie.setText("");
            txtEmailadres.setText("");
        }
        
        
    }//GEN-LAST:event_aanmakenNieuweTakeaway

    private void txtEmailadresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailadresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailadresActionPerformed

    private void btnHomeknopAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorActionPerformed
       Administrator administrator = Administrator.getInstance(takeaway);
//     administrator.setSize(300,300);
       administrator.pack();
       takeaway.hide();
       administrator.show();
       administrator.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopAdministratorActionPerformed

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
            java.util.logging.Logger.getLogger(AanmaaknieuweTakeaway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AanmaaknieuweTakeaway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AanmaaknieuweTakeaway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AanmaaknieuweTakeaway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AanmaaknieuweTakeaway().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField txtCategorie;
    private javax.swing.JTextField txtEmailadres;
    private javax.swing.JTextField txtNaam;
    // End of variables declaration//GEN-END:variables
}
