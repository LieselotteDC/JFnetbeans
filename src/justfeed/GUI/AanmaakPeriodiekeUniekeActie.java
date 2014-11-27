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
import java.sql.Date;
import java.util.*;

/**
 *
 * @author ladkerpe
 */
public class AanmaakPeriodiekeUniekeActie extends javax.swing.JFrame {

    /**
     * Creates new form PeriodiekeUniekeActieAanmaken
     */
    private static final AanmaakPeriodiekeUniekeActie periodiekeActie = new AanmaakPeriodiekeUniekeActie();
    public static JFrame myCaller;
    public Database d = new Database();
    public AanmaakPeriodiekeUniekeActie() {
        initComponents();
    }
        public static AanmaakPeriodiekeUniekeActie getInstance(Administrator caller)
    {
        myCaller = caller;
        return periodiekeActie;
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
        txtVestigingsNaam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAanmakenPeriodiekeUniekeActie = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTakeAwayNaam = new javax.swing.JTextField();
        txtBedrag = new javax.swing.JTextField();
        txtPercentage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        calendarStartdatum = new com.toedter.calendar.JCalendar();
        calendarEinddatum = new com.toedter.calendar.JCalendar();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopAdministrator = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Aanmaak van een periodieke unieke korting:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Vestiging:");

        txtVestigingsNaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVestigingsNaamActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Gewenste startdatum:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Gewenste einddatum:");

        btnAanmakenPeriodiekeUniekeActie.setBackground(new java.awt.Color(0, 0, 0));
        btnAanmakenPeriodiekeUniekeActie.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAanmakenPeriodiekeUniekeActie.setForeground(new java.awt.Color(255, 255, 255));
        btnAanmakenPeriodiekeUniekeActie.setText("Aanmaken");
        btnAanmakenPeriodiekeUniekeActie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAanmakenPeriodiekeUniekeActieActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Takeaway:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Bedrag:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Percentage:");

        txtBedrag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedragActionPerformed(evt);
            }
        });

        txtPercentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPercentageActionPerformed(evt);
            }
        });

        jLabel8.setText("*");

        jLabel9.setText("*");

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel10.setText("* Indien u bedrag invult, gelieve percentage op 0 te zetten.");

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel11.setText("Indien u echter percentage invult, gelieve bedrag op 0 te zetten.");

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 204, 153));

        btnHomeknopAdministrator.setBackground(new java.awt.Color(255, 153, 0));
        btnHomeknopAdministrator.setText("Home");
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
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(106, 106, 106))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(74, 74, 74)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(calendarStartdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(calendarEinddatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAanmakenPeriodiekeUniekeActie, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBedrag, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVestigingsNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVestigingsNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBedrag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendarStartdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(calendarEinddatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAanmakenPeriodiekeUniekeActie, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVestigingsNaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVestigingsNaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVestigingsNaamActionPerformed

    private void btnAanmakenPeriodiekeUniekeActieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAanmakenPeriodiekeUniekeActieActionPerformed
        String takeAwayNaam = txtTakeAwayNaam.getText();
        String vestigingsNaam = txtVestigingsNaam.getText();
        if(takeAwayNaam.isEmpty() || vestigingsNaam.isEmpty() || txtBedrag.getText().isEmpty() || txtPercentage.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Gelieve alle verplichte velden in te vullen.");
            if (takeAwayNaam.isEmpty()){
            txtTakeAwayNaam.requestFocus();
            }
            else if(vestigingsNaam.isEmpty()){
            txtVestigingsNaam.requestFocus();
            }
            else if(txtBedrag.getText().isEmpty()){
            txtBedrag.requestFocus();
            }
            else if (txtPercentage.getText().isEmpty()){
            txtPercentage.requestFocus();
            }
        }
        else{
            double bedrag = Double.parseDouble(txtBedrag.getText());
            double percentage = Double.parseDouble(txtPercentage.getText());
            if(!d.take_AwayBestaat(takeAwayNaam)){
                JOptionPane.showMessageDialog(null, "Deze take-away bestaat niet. Probeer opnieuw.");
                txtTakeAwayNaam.setText("");
            }
            else if(!d.bestaatVestiging(vestigingsNaam, takeAwayNaam)){
                JOptionPane.showMessageDialog(null, "Deze vestiging bestaat niet. Probeer opnieuw.");
                txtVestigingsNaam.setText("");
            }
            else{
                java.sql.Date startdatum = new java.sql.Date(calendarStartdatum.getDate().getTime());
                java.sql.Date einddatum = new java.sql.Date(calendarEinddatum.getDate().getTime());
                //(Date startdatum, Date einddatum, String vestiging, String takeawayNaam, double bedrag, double percentage)
                UniekeActiePeriode nieuweUniekeActiePeriode = new UniekeActiePeriode(startdatum, einddatum, vestigingsNaam, takeAwayNaam, bedrag, percentage);
                d.addKortingEenmaligPeriode(nieuweUniekeActiePeriode);
                JOptionPane.showMessageDialog(null, "Uw kortingscode werd succesvol toegevoegd.");
                Administrator administrator = Administrator.getInstance(periodiekeActie);
//     administrator.setSize(300,300);
                administrator.pack();
                periodiekeActie.hide();
                administrator.show();
                administrator.setLocationRelativeTo(null);
                txtVestigingsNaam.setText("");
                txtTakeAwayNaam.setText("");
                txtBedrag.setText("");
                txtPercentage.setText("");
                startdatum.setDate(0);
                einddatum.setDate(0);
            }
        }
    }//GEN-LAST:event_btnAanmakenPeriodiekeUniekeActieActionPerformed

    private void txtBedragActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedragActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedragActionPerformed

    private void txtPercentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPercentageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPercentageActionPerformed

    private void btnHomeknopAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorActionPerformed
       Administrator administrator = Administrator.getInstance(periodiekeActie);
//     administrator.setSize(300,300);
       administrator.pack();
       periodiekeActie.hide();
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
            java.util.logging.Logger.getLogger(AanmaakPeriodiekeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AanmaakPeriodiekeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AanmaakPeriodiekeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AanmaakPeriodiekeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AanmaakPeriodiekeUniekeActie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAanmakenPeriodiekeUniekeActie;
    private javax.swing.JMenu btnHomeknopAdministrator;
    private com.toedter.calendar.JCalendar calendarEinddatum;
    private com.toedter.calendar.JCalendar calendarStartdatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField txtBedrag;
    private javax.swing.JTextField txtPercentage;
    private javax.swing.JTextField txtTakeAwayNaam;
    private javax.swing.JTextField txtVestigingsNaam;
    // End of variables declaration//GEN-END:variables
}
