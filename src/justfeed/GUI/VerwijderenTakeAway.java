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
 * @author liedcost
 */
public class VerwijderenTakeAway extends javax.swing.JFrame {
    private static final VerwijderenTakeAway verwijderenTakeAway = new VerwijderenTakeAway();
     public static JFrame myCaller;
     public Database d = new Database();

    /**
     * Creates new form VerwijderenTakeAway
     */
    public VerwijderenTakeAway() {
        initComponents();
    }
     public static VerwijderenTakeAway getInstance(Administrator caller)
    {
        myCaller = caller;
        return verwijderenTakeAway;
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
        txtJAVerwijderTakeAway = new javax.swing.JButton();
        txtNEEVerwijderTakeAway = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopAdmini = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Verwijderen Take-Away");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Naam van de te verwijderen take-away:");

        txtJAVerwijderTakeAway.setBackground(new java.awt.Color(0, 0, 0));
        txtJAVerwijderTakeAway.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtJAVerwijderTakeAway.setForeground(new java.awt.Color(255, 255, 255));
        txtJAVerwijderTakeAway.setText("Ja, ik weet het zeker");
        txtJAVerwijderTakeAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJAVerwijderTakeAwayActionPerformed(evt);
            }
        });

        txtNEEVerwijderTakeAway.setBackground(new java.awt.Color(0, 0, 0));
        txtNEEVerwijderTakeAway.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNEEVerwijderTakeAway.setForeground(new java.awt.Color(255, 255, 255));
        txtNEEVerwijderTakeAway.setText("Nee");
        txtNEEVerwijderTakeAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNEEVerwijderTakeAwayActionPerformed(evt);
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
        btnHomeknopAdmini.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnHomeknopAdminiKeyTyped(evt);
            }
        });
        jMenuBar1.add(btnHomeknopAdmini);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTakeAwayNaam)))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtJAVerwijderTakeAway)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNEEVerwijderTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJAVerwijderTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNEEVerwijderTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJAVerwijderTakeAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJAVerwijderTakeAwayActionPerformed
         if(txtTakeAwayNaam.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Gelieve de naam van een take-away in te vullen.");
        }
        else{
            String takeAwayNaam = txtTakeAwayNaam.getText();
            if(d.take_AwayBestaat(takeAwayNaam)){
                Take_Away t = d.getTakeaway(takeAwayNaam);
                d.deleteTake_Away(t);
                JOptionPane.showMessageDialog(null,"De take-away werd succesvol verwijderd.");
                txtTakeAwayNaam.setText("");
                Administrator admini = Administrator.getInstance(verwijderenTakeAway);
                admini.pack();
                verwijderenTakeAway.hide();
                admini.show();
                admini.setLocationRelativeTo(null);
            }
            else{
                JOptionPane.showMessageDialog(null,"Deze take-away bestaat niet. Probeer opnieuw.");
                txtTakeAwayNaam.setText("");
                txtTakeAwayNaam.requestFocus();
            }
                    
        }
    }//GEN-LAST:event_txtJAVerwijderTakeAwayActionPerformed

    private void txtNEEVerwijderTakeAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNEEVerwijderTakeAwayActionPerformed
        txtTakeAwayNaam.setText("");
        Administrator admini = Administrator.getInstance(verwijderenTakeAway);
        admini.pack();
        verwijderenTakeAway.hide();
        admini.show();
        admini.setLocationRelativeTo(null);
    }//GEN-LAST:event_txtNEEVerwijderTakeAwayActionPerformed

    private void btnHomeknopAdminiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnHomeknopAdminiKeyTyped
       Administrator admini = Administrator.getInstance(verwijderenTakeAway);
       admini.pack();
       verwijderenTakeAway.hide();
       admini.show();
       admini.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopAdminiKeyTyped

    private void btnHomeknopAdminiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeknopAdminiMouseClicked
       verwijderenTakeAway.hide();
       myCaller.show();
       txtTakeAwayNaam.setText("");
    }//GEN-LAST:event_btnHomeknopAdminiMouseClicked

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
            java.util.logging.Logger.getLogger(VerwijderenTakeAway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerwijderenTakeAway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerwijderenTakeAway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerwijderenTakeAway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerwijderenTakeAway().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnHomeknopAdmini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton txtJAVerwijderTakeAway;
    private javax.swing.JButton txtNEEVerwijderTakeAway;
    private javax.swing.JTextField txtTakeAwayNaam;
    // End of variables declaration//GEN-END:variables
}
