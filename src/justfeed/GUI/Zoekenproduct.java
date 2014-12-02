/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package justfeed.GUI;

import Database.Database;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UGent
 */
public class Zoekenproduct extends javax.swing.JFrame {
    private static final Zoekenproduct zoekenProduct = new Zoekenproduct();
    public static JFrame myCaller;
    public Database d = new Database();
    public static Zoekenproduct getInstance(Profielklant caller)
    {
        myCaller = caller;
        return zoekenProduct;
    }
    /**
     * Creates new form Zoekengerecht
     */
    public Zoekenproduct() {
        initComponents();
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
        txtProductnaam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblZoekenProduct = new javax.swing.JTable();
        btnZoeken = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopProfielklant = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Zoeken op gerecht ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Naam product:");

        tblZoekenProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblZoekenProduct);

        btnZoeken.setBackground(new java.awt.Color(0, 0, 0));
        btnZoeken.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnZoeken.setForeground(new java.awt.Color(255, 255, 255));
        btnZoeken.setText("Zoeken");
        btnZoeken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoekenActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

        btnHomeknopProfielklant.setBackground(new java.awt.Color(255, 153, 0));
        btnHomeknopProfielklant.setText("Home");
        btnHomeknopProfielklant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeknopProfielklantMouseClicked(evt);
            }
        });
        btnHomeknopProfielklant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeknopProfielklantActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnHomeknopProfielklant);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtProductnaam, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnZoeken)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProductnaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZoeken))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZoekenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoekenActionPerformed
        String productnaam = txtProductnaam.getText();
        if(d.productProductnaamBestaat(productnaam))
        {
            DefaultTableModel t = d.naarTabel("SELECT * FROM tbl_product WHERE (naam = '" + productnaam + "');");
            tblZoekenProduct.setModel(t);
        }
        else{
            JOptionPane.showMessageDialog(null, "Sorry, Just-Feed biedt dit product momenteel niet aan. Probeer opnieuw.");
            txtProductnaam.setText("");
            txtProductnaam.requestFocus();
        }
    }//GEN-LAST:event_btnZoekenActionPerformed

    private void btnHomeknopProfielklantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopProfielklantActionPerformed
         Profielklant profiel = Profielklant.getInstance(zoekenProduct);
       profiel.pack();
       zoekenProduct.hide();
       profiel.show();
       profiel.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopProfielklantActionPerformed

    private void btnHomeknopProfielklantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeknopProfielklantMouseClicked
       zoekenProduct.hide();
       myCaller.show();
       txtProductnaam.setText("");
    }//GEN-LAST:event_btnHomeknopProfielklantMouseClicked

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
            java.util.logging.Logger.getLogger(Zoekenproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zoekenproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zoekenproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zoekenproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Zoekenproduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnHomeknopProfielklant;
    private javax.swing.JButton btnZoeken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblZoekenProduct;
    private javax.swing.JTextField txtProductnaam;
    // End of variables declaration//GEN-END:variables
}
