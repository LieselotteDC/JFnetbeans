/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package justfeed.GUI;

import Database.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UGent
 */
public class Zoekengemeente extends javax.swing.JFrame {

    /**
     * Creates new form Zoekengemeente
     */
    public Database d = new Database();
   
    public Zoekengemeente() {
        initComponents();
    }
    private static final Zoekengemeente zoekenGemeente = new Zoekengemeente();
    public static JFrame myCaller;
    public static Zoekengemeente getInstance(Profielklant caller)
    {
        myCaller = caller;
        return zoekenGemeente;
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
        txtGemeente = new javax.swing.JTextField();
        btnZoeken = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblZoekenGemeente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtPostcode = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopProfielklant = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Zoeken op gemeente");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Gemeente:");

        btnZoeken.setBackground(new java.awt.Color(0, 0, 0));
        btnZoeken.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnZoeken.setForeground(new java.awt.Color(255, 255, 255));
        btnZoeken.setText("Zoeken");
        btnZoeken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoekenActionPerformed(evt);
            }
        });

        tblZoekenGemeente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblZoekenGemeente);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Postcode:");

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
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37)
                                .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGemeente, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnZoeken)
                        .addGap(130, 130, 130)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZoeken)
                    .addComponent(txtGemeente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZoekenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoekenActionPerformed
        String gemeente = txtGemeente.getText();
        if(txtPostcode.getText().isEmpty() ||
               gemeente.isEmpty()){
            JOptionPane.showMessageDialog(null, "Gelieve alle verplichte velden in te vullen.");
            if (txtPostcode.getText().isEmpty()){
            txtPostcode.requestFocus();
            }
            else if(gemeente.isEmpty()){
            txtGemeente.requestFocus();
            }
        }
         else{
            int postcode = Integer.parseInt(txtPostcode.getText());
            if(d.getPlaatsnummer(gemeente, postcode) == 0){
            JOptionPane.showMessageDialog(null, "De ingevoerde postcode en gemeente stemmen niet overeen. Probeer opnieuw.");
            txtPostcode.setText("");
            txtGemeente.setText("");
            }
            else{
            int plaatsnummer = d.getPlaatsnummer(gemeente, postcode);
            DefaultTableModel t = d.naarTabel("SELECT * FROM tbl_vestigingen WHERE (plaatsnummer = '" + plaatsnummer + "');");
            tblZoekenGemeente.setModel(t);
            txtPostcode.setText("");
            txtGemeente.setText("");
            }
        }
    }//GEN-LAST:event_btnZoekenActionPerformed

    private void btnHomeknopProfielklantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopProfielklantActionPerformed
       Profielklant profiel = Profielklant.getInstance(zoekenGemeente);
       profiel.pack();
       zoekenGemeente.hide();
       profiel.show();
       profiel.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopProfielklantActionPerformed

    private void btnHomeknopProfielklantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeknopProfielklantMouseClicked
       zoekenGemeente.hide();
       myCaller.show();
       txtPostcode.setText("");
       txtGemeente.setText("");
        DefaultTableModel model = (DefaultTableModel) tblZoekenGemeente.getModel();
        model.setRowCount(0);
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
            java.util.logging.Logger.getLogger(Zoekengemeente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zoekengemeente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zoekengemeente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zoekengemeente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Zoekengemeente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnHomeknopProfielklant;
    private javax.swing.JButton btnZoeken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblZoekenGemeente;
    private javax.swing.JTextField txtGemeente;
    private javax.swing.JTextField txtPostcode;
    // End of variables declaration//GEN-END:variables
}
