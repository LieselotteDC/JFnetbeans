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
public class AanmaakAward extends javax.swing.JFrame {

    private static final AanmaakAward aanmaakAward = new AanmaakAward();
    public Database d = new Database();
    public static JFrame myCaller;
    WriteFile wf = new WriteFile();

    public AanmaakAward() {
        initComponents();
    }

    public static AanmaakAward getInstance(Administrator admini) {
        myCaller = admini;
        return aanmaakAward;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboboxMaand = new javax.swing.JComboBox();
        txtJaar = new javax.swing.JTextField();
        btnAanmaakAward = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopAdministrator = new javax.swing.JMenu();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Aanmaak van de maandelijkse awards:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Selecteer de gewenste maand:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Jaar:");

        comboboxMaand.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december" }));

        txtJaar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJaarActionPerformed(evt);
            }
        });

        btnAanmaakAward.setBackground(new java.awt.Color(0, 0, 0));
        btnAanmaakAward.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAanmaakAward.setForeground(new java.awt.Color(255, 255, 255));
        btnAanmaakAward.setText("Aanmaken");
        btnAanmaakAward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAanmaakAwardActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");

        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("* Verplicht");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAanmaakAward, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJaar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboboxMaand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboboxMaand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtJaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(35, 35, 35)
                        .addComponent(btnAanmaakAward, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJaarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJaarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJaarActionPerformed

    private void btnHomeknopAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorActionPerformed
        Administrator administrator = Administrator.getInstance(aanmaakAward);
//     administrator.setSize(300,300);
        administrator.pack();
        aanmaakAward.hide();
        administrator.show();
        administrator.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopAdministratorActionPerformed

    private void btnAanmaakAwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAanmaakAwardActionPerformed
        String maand = comboboxMaand.getSelectedItem().toString();
        if (maand.isEmpty() || txtJaar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Gelieve alle verplichte velden in te vullen.");
            if (maand.isEmpty()) {
                comboboxMaand.requestFocus();
            } else if (txtJaar.getText().isEmpty()) {
                txtJaar.requestFocus();
            }
        } else {
            int reply = JOptionPane.showConfirmDialog(null, "Heeft U de commissies reeds berekend?", "Commissieberekening", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
               //bij de knop awards aanmaken: 1. undo, 2. delete, 3. calculate, 4. do
                //visualisatie gebeurd dus pas na het toekennen van alle awards!
                int jaar = Integer.parseInt(txtJaar.getText());
                d.undoVisualisationAwards();
                d.deleteAllAwards();
                d.addAwardBestseller(maand, jaar);
                d.addAwardHotItem(maand, jaar);
                d.addAwardUsersChoice(maand);
                d.addAwardJustFeeder(maand);
                d.doVisualisationAwards();
                comboboxMaand.setSelectedItem(null);
                txtJaar.setText("");
                JOptionPane.showMessageDialog(null, "De awards werden succesvol toegevoegd.");
                wf.pdfAwards(maand, jaar);
                Overzichtawardsadministrator awardsoverzicht = Overzichtawardsadministrator.getInstance(aanmaakAward);
                //     amdministrator.setSize(300,300);
                awardsoverzicht.pack();
                aanmaakAward.hide();
                awardsoverzicht.show();
                awardsoverzicht.setLocationRelativeTo(null);
            } else {
                Commissieberekening commissie = Commissieberekening.getInstance(aanmaakAward);
                commissie.pack();
                aanmaakAward.hide();
                commissie.show();
                commissie.setLocationRelativeTo(null);
            }
        }

    }//GEN-LAST:event_btnAanmaakAwardActionPerformed

    private void btnHomeknopAdministratorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorMouseClicked
        aanmaakAward.hide();
        myCaller.show();
        txtJaar.setText("");
        comboboxMaand.setSelectedItem("januari");
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
            java.util.logging.Logger.getLogger(AanmaakAward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AanmaakAward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AanmaakAward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AanmaakAward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AanmaakAward().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAanmaakAward;
    private javax.swing.JMenu btnHomeknopAdministrator;
    private javax.swing.JComboBox comboboxMaand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField txtJaar;
    // End of variables declaration//GEN-END:variables
}
