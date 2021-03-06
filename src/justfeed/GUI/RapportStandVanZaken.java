/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justfeed.GUI;

import Database.*;
import Logica.*;
import java.awt.Color;
import java.awt.Transparency;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liedcost
 */
public class RapportStandVanZaken extends javax.swing.JFrame {

    private static final RapportStandVanZaken rapportSVZ = new RapportStandVanZaken();
    public Database d = new Database();
    public static JFrame myCaller;
    DefaultComboBoxModel c = d.initialiseerCombobox("SELECT naam FROM tbl_takeaway;", "naam");
    WriteFile pdf=new WriteFile();

    /**
     * Creates new form RapportStandVanZaken //
     */
    public RapportStandVanZaken() {
        initComponents();
        comboboxTakeAway.setModel(c);
        txtVestiging.setEnabled(false);
    }

    public static RapportStandVanZaken getInstance(Administrator admini) {
        myCaller = admini;
        return rapportSVZ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        comboboxInhoud = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboboxTakeAway = new javax.swing.JComboBox();
        lblVestiging = new javax.swing.JLabel();
        lblTakeAway = new javax.swing.JLabel();
        btnRapportMaken = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        rbtnTakeAway = new javax.swing.JRadioButton();
        rbtnVestiging = new javax.swing.JRadioButton();
        txtVestiging = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopAdmini = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Rapport met stand van zaken opvragen");

        comboboxInhoud.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Verkopen", "Lopende orders", "Lopende unieke actie kortingscodes" }));
        comboboxInhoud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxInhoudActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Inhoud rapport");

        lblVestiging.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVestiging.setText("Selecteer de gewenste vestiging:");

        lblTakeAway.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTakeAway.setText("Kies de betreffende take-away:");

        btnRapportMaken.setBackground(new java.awt.Color(0, 0, 0));
        btnRapportMaken.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRapportMaken.setForeground(new java.awt.Color(255, 255, 255));
        btnRapportMaken.setText("Rapport maken");
        btnRapportMaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRapportMakenActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Genereer rapport:");

        buttonGroup1.add(rbtnTakeAway);
        rbtnTakeAway.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnTakeAway.setText("per take-away");
        rbtnTakeAway.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnTakeAwayMouseClicked(evt);
            }
        });
        rbtnTakeAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTakeAwayActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnVestiging);
        rbtnVestiging.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnVestiging.setText("per vestiging");
        rbtnVestiging.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnVestigingMouseClicked(evt);
            }
        });
        rbtnVestiging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVestigingActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

        btnHomeknopAdmini.setBackground(new java.awt.Color(255, 153, 0));
        btnHomeknopAdmini.setText("Home");
        btnHomeknopAdmini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeknopAdminiMouseClicked(evt);
            }
        });
        btnHomeknopAdmini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeknopAdminiActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnHomeknopAdmini);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboboxInhoud, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTakeAway)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbtnTakeAway)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtnVestiging))
                                    .addComponent(lblVestiging))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRapportMaken, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboboxTakeAway, 0, 161, Short.MAX_VALUE)
                                        .addComponent(txtVestiging)))))
                        .addGap(78, 78, 78))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboboxInhoud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTakeAway)
                    .addComponent(comboboxTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnTakeAway)
                    .addComponent(rbtnVestiging))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVestiging, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVestiging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnRapportMaken, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnTakeAwayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnTakeAwayMouseClicked
            //comboboxVestiging.setEnabled(false);
            //lblVestiging.setForeground(Color.LIGHT_GRAY);
            txtVestiging.setText("");
            txtVestiging.setEnabled(false);
    }//GEN-LAST:event_rbtnTakeAwayMouseClicked

    private void rbtnVestigingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnVestigingMouseClicked
            //query om de vestigingen van de geselecteerde take-away op te halen
            //DefaultComboBoxModel f = d.initialiseerCombobox("SELECT vestigingsID FROM tbl_vestigingen;", "vestigingsID");
            String gekozenTakeAway;
            gekozenTakeAway = comboboxTakeAway.getSelectedItem().toString();
            txtVestiging.setText("");
            txtVestiging.setEnabled(true);
    }//GEN-LAST:event_rbtnVestigingMouseClicked

    private void btnRapportMakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRapportMakenActionPerformed
        String inhoud = comboboxInhoud.getSelectedItem().toString();
        String gekozenTakeAway = comboboxTakeAway.getSelectedItem().toString();
        if(inhoud.equals("Verkopen")){
            if(rbtnVestiging.isSelected()){
                String vestigingsID = txtVestiging.getText();
                pdf.pdfVerkopenTakeawayVestiging(gekozenTakeAway, vestigingsID);
                JOptionPane.showMessageDialog(null, "Het rapport werd succesvol gegenereerd.");
                rapportSVZ.hide();
                myCaller.show();
            }
            else if (rbtnTakeAway.isSelected()){
                //Take_Away geselecteerdeTakeAway = d.getTakeaway(gekozenTakeAway);
                pdf.pdfVerkopenTakeawayAlgemeen(gekozenTakeAway); 
                JOptionPane.showMessageDialog(null, "Het rapport werd succesvol gegenereerd.");
                rapportSVZ.hide();
                myCaller.show();
            }  
        }
        else if(inhoud.equals("Lopende orders")){
             if(rbtnVestiging.isSelected()){
                String vestigingsID = txtVestiging.getText();
                pdf.pdfLopendeOrdersTakeawayVestiging(gekozenTakeAway, vestigingsID);
                JOptionPane.showMessageDialog(null, "Het rapport werd succesvol gegenereerd.");
                rapportSVZ.hide();
                myCaller.show();
            }
            else if (rbtnTakeAway.isSelected()){
                //Take_Away geselecteerdeTakeAway = d.getTakeaway(gekozenTakeAway);
                pdf.pdfLopendeOrdersTakeawayAlgemeen(gekozenTakeAway);
                JOptionPane.showMessageDialog(null, "Het rapport werd succesvol gegenereerd.");
                rapportSVZ.hide();
                myCaller.show();
            }  
        }
        else{
            if(rbtnVestiging.isSelected()){
                String vestigingsID = txtVestiging.getText();
                pdf.pdfKortingscodesTakeawayVestiging(gekozenTakeAway, vestigingsID);
                JOptionPane.showMessageDialog(null, "Het rapport werd succesvol gegenereerd.");
                rapportSVZ.hide();
                myCaller.show();
            }
            else if (rbtnTakeAway.isSelected()){
                //Take_Away geselecteerdeTakeAway = d.getTakeaway(gekozenTakeAway);
                pdf.pdfKortingscodesTakeawayAlgemeen(gekozenTakeAway);
                JOptionPane.showMessageDialog(null, "Het rapport werd succesvol gegenereerd.");
                rapportSVZ.hide();
                myCaller.show();
            } 
        }
    }//GEN-LAST:event_btnRapportMakenActionPerformed

    private void btnHomeknopAdminiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopAdminiActionPerformed
        Administrator admini = Administrator.getInstance(rapportSVZ);
       admini.pack();
       rapportSVZ.hide();
       admini.show();
       admini.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopAdminiActionPerformed

    private void btnHomeknopAdminiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeknopAdminiMouseClicked
        rapportSVZ.hide();
       myCaller.show();
       comboboxInhoud.setSelectedItem(null);
       comboboxTakeAway.setSelectedItem(null);
       
    }//GEN-LAST:event_btnHomeknopAdminiMouseClicked

    private void comboboxInhoudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxInhoudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxInhoudActionPerformed

    private void rbtnTakeAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTakeAwayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnTakeAwayActionPerformed

    private void rbtnVestigingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVestigingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnVestigingActionPerformed

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
            java.util.logging.Logger.getLogger(RapportStandVanZaken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RapportStandVanZaken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RapportStandVanZaken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RapportStandVanZaken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RapportStandVanZaken().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnHomeknopAdmini;
    private javax.swing.JButton btnRapportMaken;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboboxInhoud;
    private javax.swing.JComboBox comboboxTakeAway;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblTakeAway;
    private javax.swing.JLabel lblVestiging;
    private javax.swing.JRadioButton rbtnTakeAway;
    private javax.swing.JRadioButton rbtnVestiging;
    private javax.swing.JTextField txtVestiging;
    // End of variables declaration//GEN-END:variables
}
