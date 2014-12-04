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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author liedcost
 */
public class ZoekenReview extends javax.swing.JFrame {

    /**
     * Creates new form ZoekenReview
     */
    public static JFrame myCaller;
    public Database d = new Database();
    public Klant actief = LoginKlant.getInstance().getActief();
    private static final ZoekenReview zoekenReview = new ZoekenReview();
    public ZoekenReview() {
        initComponents();
    }
     public static ZoekenReview getInstance(Profielklant profielklant)
    {
        myCaller = profielklant;
        return zoekenReview;
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
        txtProductNaam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReviews = new javax.swing.JTable();
        btnZoeken = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        bntHomeknopProfielklant = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Zoeken naar reviews");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Naam van het product waarvan u reviews wil:");

        tblReviews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblReviews);

        btnZoeken.setBackground(new java.awt.Color(0, 0, 0));
        btnZoeken.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnZoeken.setForeground(new java.awt.Color(255, 255, 255));
        btnZoeken.setText("Zoek");
        btnZoeken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoekenActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

        bntHomeknopProfielklant.setBackground(new java.awt.Color(255, 153, 0));
        bntHomeknopProfielklant.setText("Home");
        bntHomeknopProfielklant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntHomeknopProfielklantMouseClicked(evt);
            }
        });
        bntHomeknopProfielklant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntHomeknopProfielklantActionPerformed(evt);
            }
        });
        jMenuBar1.add(bntHomeknopProfielklant);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtProductNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnZoeken)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProductNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZoeken))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZoekenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoekenActionPerformed
        String productnaam = txtProductNaam.getText(); 
        if(d.productProductnaamBestaat(productnaam))
        {
           // DefaultTableModel t = d.naarTabel("SELECT R.reviewID,R.productID,P.naam,P.type,P.eenheidsprijs,B.naam,R.score,R.beoordeling FROM tbl_review R JOIN tbl_product P ON R.productID=P.productID JOIN tbl_biedtAan B ON P.productID=B.productID WHERE (R.status=FALSE) and('" + productnaam + "'=P.naam);");
            DefaultTableModel t = d.naarTabel("SELECT R.reviewID,R.productID,P.naam,P.type,P.eenheidsprijs,P.takeawaynaam,R.score,R.beoordeling FROM tbl_review R, tbl_product P WHERE (R.productID=P.productID) and (R.status=FALSE) and('" + productnaam + "'=P.naam);");
            tblReviews.setModel(t);
        }
        else{
            JOptionPane.showMessageDialog(null, "Sorry, Just-Feed biedt dit product momenteel niet aan. Probeer opnieuw.");
            txtProductNaam.setText("");
            txtProductNaam.requestFocus();
        }
        
    }//GEN-LAST:event_btnZoekenActionPerformed

    private void bntHomeknopProfielklantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntHomeknopProfielklantActionPerformed
        Profielklant profiel = Profielklant.getInstance(zoekenReview);
       profiel.pack();
       zoekenReview.hide();
       profiel.show();
       profiel.setLocationRelativeTo(null);
    }//GEN-LAST:event_bntHomeknopProfielklantActionPerformed

    private void bntHomeknopProfielklantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntHomeknopProfielklantMouseClicked
       zoekenReview.hide();
        myCaller.show();
        txtProductNaam.setText("");
    }//GEN-LAST:event_bntHomeknopProfielklantMouseClicked

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
            java.util.logging.Logger.getLogger(ZoekenReview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZoekenReview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZoekenReview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZoekenReview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZoekenReview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bntHomeknopProfielklant;
    private javax.swing.JButton btnZoeken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReviews;
    private javax.swing.JTextField txtProductNaam;
    // End of variables declaration//GEN-END:variables
}
