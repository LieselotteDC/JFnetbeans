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
 * @author ladkerpe
 */
public class AanmaakEenmaligeUniekeActie extends javax.swing.JFrame {
    
    private static final AanmaakEenmaligeUniekeActie uniekeActie = new AanmaakEenmaligeUniekeActie();
    public static JFrame myCaller;
    public Database d = new Database();
    /**
     * Creates new form EenmaligeUniekeActieAanmaken
     */
    public AanmaakEenmaligeUniekeActie() {
        initComponents();
    }
    public static AanmaakEenmaligeUniekeActie getInstance(Administrator caller)
    {
        
        myCaller = caller;
        return uniekeActie;
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
        txtTakeAwayNaam = new javax.swing.JTextField();
        aanmakenEenmaligeUniekeKorting = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtVestigingsNaam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBedrag = new javax.swing.JTextField();
        txtPercentage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopAdministrator = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Aanmaak van een eenmalige unieke korting: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Takeaway:");

        txtTakeAwayNaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTakeAwayNaamActionPerformed(evt);
            }
        });

        aanmakenEenmaligeUniekeKorting.setBackground(new java.awt.Color(0, 0, 0));
        aanmakenEenmaligeUniekeKorting.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        aanmakenEenmaligeUniekeKorting.setForeground(new java.awt.Color(255, 255, 255));
        aanmakenEenmaligeUniekeKorting.setText("Aanmaken");
        aanmakenEenmaligeUniekeKorting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aanmakenEenmaligeUniekeKortingActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Vestiging:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Bedrag:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Percentage:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel8.setText("* Indien u bedrag invult, gelieve percentage op 0 te zetten.");

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel9.setText("Indien u echter percentage invult, gelieve bedrag op 0 te zetten.");

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("* Verplicht");

        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("* ");

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("* ");

        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("* ");

        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("* ");

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

        btnHomeknopAdministrator.setBackground(new java.awt.Color(255, 153, 0));
        btnHomeknopAdministrator.setText("Home");
        btnHomeknopAdministrator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeknopAdministratorMouseClicked(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtVestigingsNaam)
                                        .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtBedrag)
                                        .addComponent(txtPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aanmakenEenmaligeUniekeKorting)))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVestigingsNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel15)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBedrag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPercentage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel14)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)))
                    .addComponent(aanmakenEenmaligeUniekeKorting, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTakeAwayNaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTakeAwayNaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTakeAwayNaamActionPerformed

    private void aanmakenEenmaligeUniekeKortingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aanmakenEenmaligeUniekeKortingActionPerformed
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
                UniekeActieEenmalig nieuweUniekeActie = new UniekeActieEenmalig(true, vestigingsNaam, takeAwayNaam, bedrag, percentage);
                d.addKortingEenmaligUniek(nieuweUniekeActie);
                JOptionPane.showMessageDialog(null, "Uw kortingscode werd succesvol toegevoegd.");
                Administrator admini = Administrator.getInstance(uniekeActie);
                admini.pack();
                uniekeActie.hide();
                admini.show();
                admini.setLocationRelativeTo(null);
                txtVestigingsNaam.setText("");
                txtTakeAwayNaam.setText("");
                txtBedrag.setText("");
                txtPercentage.setText("");
            }
        }
    }//GEN-LAST:event_aanmakenEenmaligeUniekeKortingActionPerformed

    private void btnHomeknopAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorActionPerformed
       Administrator admini = Administrator.getInstance(uniekeActie);
       admini.pack();
       uniekeActie.hide();
       admini.show();
       admini.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopAdministratorActionPerformed

    private void btnHomeknopAdministratorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorMouseClicked
        uniekeActie.hide();
        myCaller.show();
        txtTakeAwayNaam.setText("");
        txtVestigingsNaam.setText("");
        txtBedrag.setText("");
        txtPercentage.setText("");
    }//GEN-LAST:event_btnHomeknopAdministratorMouseClicked

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
            java.util.logging.Logger.getLogger(AanmaakEenmaligeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AanmaakEenmaligeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AanmaakEenmaligeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AanmaakEenmaligeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AanmaakEenmaligeUniekeActie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aanmakenEenmaligeUniekeKorting;
    private javax.swing.JMenu btnHomeknopAdministrator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField txtBedrag;
    private javax.swing.JTextField txtPercentage;
    private javax.swing.JTextField txtTakeAwayNaam;
    private javax.swing.JTextField txtVestigingsNaam;
    // End of variables declaration//GEN-END:variables
}
