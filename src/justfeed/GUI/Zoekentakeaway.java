package justfeed.GUI;

import Database.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Zoekentakeaway extends javax.swing.JFrame {
    private static final Zoekentakeaway zoekenTakeaway = new Zoekentakeaway();
    public static JFrame myCaller;
    public Database d = new Database();
    public static Zoekentakeaway getInstance(Profielklant caller)
    {
        myCaller = caller;
        return zoekenTakeaway;
    }
    /**
     * Creates new form Zoekencategorie
     */
    public Zoekentakeaway() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNaamTakeAway = new javax.swing.JTextField();
        btnNaarZoekresultatenTakeaway = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblZoekenTakeaway = new javax.swing.JTable();
        btnZoeken = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Zoeken op takeaway");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Naam takeaway:");

        btnNaarZoekresultatenTakeaway.setBackground(new java.awt.Color(0, 0, 0));
        btnNaarZoekresultatenTakeaway.setForeground(new java.awt.Color(255, 255, 255));
        btnNaarZoekresultatenTakeaway.setText("Volgende");
        btnNaarZoekresultatenTakeaway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekresultaten(evt);
            }
        });

        tblZoekenTakeaway.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblZoekenTakeaway);

        btnZoeken.setText("Zoeken");
        btnZoeken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoekenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNaarZoekresultatenTakeaway)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNaamTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnZoeken)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaamTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnZoeken))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnNaarZoekresultatenTakeaway, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void naarZoekresultaten(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarZoekresultaten

    }//GEN-LAST:event_naarZoekresultaten

    private void btnZoekenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoekenActionPerformed
        String takeAwayNaam = txtNaamTakeAway.getText();
        if(d.take_AwayBestaat(takeAwayNaam)){
            DefaultTableModel t = d.naarTabel("SELECT * FROM tbl_takeaway WHERE (naam = '" + takeAwayNaam + "');");
            tblZoekenTakeaway.setModel(t);
        }
        else{
            JOptionPane.showMessageDialog(null, "Sorry, deze take-away zit niet in ons bestand. Probeer opnieuw");
            txtNaamTakeAway.setText("");
            txtNaamTakeAway.requestFocus();
        }
    }//GEN-LAST:event_btnZoekenActionPerformed

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
            java.util.logging.Logger.getLogger(Zoekentakeaway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zoekentakeaway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zoekentakeaway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zoekentakeaway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Zoekentakeaway().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNaarZoekresultatenTakeaway;
    private javax.swing.JButton btnZoeken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblZoekenTakeaway;
    private javax.swing.JTextField txtNaamTakeAway;
    // End of variables declaration//GEN-END:variables
}
