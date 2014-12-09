/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justfeed.GUI;

import Database.Database;
import Logica.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UGent
 */
public class BestellingFactuur extends javax.swing.JFrame {

    /**
     * Creates new form Betaling
     */
    private static final BestellingFactuur factuur = new BestellingFactuur();
    public Order orderZonderKorting = Bestelling.getInstance().getOrderZonderKorting();
    public DefaultTableModel model = Bestelling.getInstance().getModel();
    public Order orderMetKorting = BestellingKortingscode.getInstance().getOrderMetKorting();
    public ArrayList<Review> voorlopigeReviews = Bestelling.getInstance().getVoorlopigeReviews();
    public ArrayList<Menu> berekendeMenus = Bestelling.getInstance().getBerekendeMenus();
    public ArrayList<Orderverwerking> besteldeProducten = Bestelling.getInstance().getBesteldeProducten();
    public ArrayList<HulpKorting> hulpKorting = BestellingKortingscode.getInstance().getHulpKorting();
    public Klant actief = LoginKlant.getInstance().getActief();
    public Database d = new Database();
    public static JFrame myCaller;

    public BestellingFactuur() {
        initComponents();
        String totaalprijs2 = String.valueOf(orderZonderKorting.getTotaalPrijs());
        txtTotaalBedragExcl.setText(totaalprijs2);
        txtTotaalBedragExcl.setEnabled(false);
        String totaalprijs3 = String.valueOf(orderMetKorting.getTotaalPrijs());
        txtTotaalBedragIncl.setText(totaalprijs3);
        txtTotaalBedragIncl.setEnabled(false);
        double kortingsbedrag = (orderZonderKorting.getTotaalPrijs() - orderMetKorting.getTotaalPrijs());
        String kortingsbedrag2 = String.valueOf(kortingsbedrag);
        txtKortingsbedrag.setText(kortingsbedrag2);
        txtKortingsbedrag.setEnabled(false);
    }

    public static BestellingFactuur getInstance(BestellingKortingscode caller) {
        myCaller = caller;
        return factuur;
    }

    public static BestellingFactuur getInstance(BestellingAfleveradres caller) {
        myCaller = caller;
        return factuur;
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
        btnGoedkeuren = new javax.swing.JButton();
        btnAfkeuren = new javax.swing.JButton();
        txtTotaalBedragIncl = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotaalBedragExcl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKortingsbedrag = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Betaling");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Het totale bedrag van uw order bedraagt (incl. korting):");

        btnGoedkeuren.setBackground(new java.awt.Color(0, 0, 0));
        btnGoedkeuren.setForeground(new java.awt.Color(255, 255, 255));
        btnGoedkeuren.setText("Goedkeuren");
        btnGoedkeuren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoedkeurenActionPerformed(evt);
            }
        });

        btnAfkeuren.setBackground(new java.awt.Color(0, 0, 0));
        btnAfkeuren.setForeground(new java.awt.Color(255, 255, 255));
        btnAfkeuren.setText("Afkeuren");
        btnAfkeuren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfkeurenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Het totale bedrag van uw order bedraagt (excl. korting):");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Totale toegekende korting:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAfkeuren, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGoedkeuren, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotaalBedragIncl, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(txtTotaalBedragExcl)
                            .addComponent(txtKortingsbedrag))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotaalBedragExcl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtKortingsbedrag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotaalBedragIncl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoedkeuren, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAfkeuren, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoedkeurenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoedkeurenActionPerformed
        java.sql.Date datumVanLevering = orderMetKorting.getDatum();
        orderMetKorting.setDatum(datumVanLevering);
        d.addOrder(orderMetKorting, berekendeMenus, besteldeProducten);
        d.aanmakenReview(voorlopigeReviews);
        d.addHulpKorting(hulpKorting);
        //naar elke takeaway word een mail verstuurd met de producten die bij hen besteld zijn
        //orderId ophalen en dan alle menus van dat id in plaats van berekende menus
        WriteFile pdf = new WriteFile();
        pdf.pdfBesteldeProductenBijTakeaway(d.getLastOrderKlant(actief));
        pdf.pdfBestellingKlant(d.getLastOrderKlant(actief), actief);

        txtTotaalBedragIncl.setText("");
        BestellingBevestiging bevestiging = BestellingBevestiging.getInstance(factuur);
        bevestiging.pack();
        factuur.hide();
        bevestiging.show();
        bevestiging.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnGoedkeurenActionPerformed

    private void btnAfkeurenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfkeurenActionPerformed
        txtTotaalBedragIncl.setText("");
        model.setRowCount(0);
        Profielklant profiel = Profielklant.getInstance(factuur);
        profiel.pack();
        factuur.hide();
        profiel.show();
        profiel.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAfkeurenActionPerformed

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
            java.util.logging.Logger.getLogger(BestellingFactuur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BestellingFactuur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BestellingFactuur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BestellingFactuur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BestellingFactuur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfkeuren;
    private javax.swing.JButton btnGoedkeuren;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtKortingsbedrag;
    private javax.swing.JTextField txtTotaalBedragExcl;
    private javax.swing.JTextField txtTotaalBedragIncl;
    // End of variables declaration//GEN-END:variables
}
