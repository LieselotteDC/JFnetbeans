/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justfeed.GUI;

import Database.Database;
import Logica.Klant;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Overzichtreviewsklant extends javax.swing.JFrame {

    private static final Overzichtreviewsklant reviewsklant = new Overzichtreviewsklant();
    public static JFrame myCaller;
    public Klant actief = LoginKlant.getInstance().getActief();
    public Database d = new Database();
    // DefaultTableModel t = d.naarTabel("SELECT R.reviewID,R.productID,P.naam,P.type,P.eenheidsprijs,P.takeawaynaam,R.score,R.beoordeling FROM tbl_review R JOIN tbl_product P ON R.productID=P.productID WHERE (R.status=FALSE) and('" + actief.getLogin() + "'=R.login);");
    DefaultTableModel t = d.naarTabel("SELECT R.reviewID,R.productID,P.naam,P.type,P.eenheidsprijs,P.takeawaynaam,R.score,R.beoordeling FROM tbl_review R, tbl_product P WHERE (R.productID=P.productID) and (R.status=FALSE) and('" + actief.getLogin() + "'=R.login);");

    public Overzichtreviewsklant() {
        initComponents();
        tblOverzichtReviewsKlant.setModel(t);
    }

    public static Overzichtreviewsklant getInstance(Profielklant caller) {
        myCaller = caller;
        return reviewsklant;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOverzichtReviewsKlant = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopProfielklant = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Overzicht van uw geplaatste reviews:");

        tblOverzichtReviewsKlant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblOverzichtReviewsKlant);

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
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeknopProfielklantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopProfielklantActionPerformed
        Profielklant profiel = Profielklant.getInstance(reviewsklant);
//     profiel.setSize(300,300);
        profiel.pack();
        reviewsklant.hide();
        profiel.show();
        profiel.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopProfielklantActionPerformed

    private void btnHomeknopProfielklantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeknopProfielklantMouseClicked
        reviewsklant.hide();
        myCaller.show();
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
            java.util.logging.Logger.getLogger(Overzichtreviewsklant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Overzichtreviewsklant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Overzichtreviewsklant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Overzichtreviewsklant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Overzichtreviewsklant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnHomeknopProfielklant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOverzichtReviewsKlant;
    // End of variables declaration//GEN-END:variables
}
