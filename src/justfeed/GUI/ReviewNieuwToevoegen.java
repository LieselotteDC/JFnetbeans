/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justfeed.GUI;
import Database.*;
import Logica.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author liedcost
 */
public class ReviewNieuwToevoegen extends javax.swing.JFrame {
    private static final ReviewNieuwToevoegen toevoegenReview = new ReviewNieuwToevoegen();
    public static JFrame myCaller;
    public Database d = new Database();
    public Klant actief = LoginKlant.getInstance().getActief();
    //DefaultTableModel t = d.naarTabel("SELECT R.reviewID,R.productID,P.naam,P.type,P.eenheidsprijs,B.naam,R.score,R.beoordeling FROM tbl_review R JOIN tbl_product P ON R.productID=P.productID JOIN tbl_biedtAan B ON P.productID=B.productID WHERE (R.status=TRUE) and('" + actief.getLogin() + "'=R.login);");
    DefaultTableModel t = d.naarTabel("SELECT R.reviewID,R.productID,P.naam,P.type,P.eenheidsprijs,P.takeawaynaam,R.score,R.beoordeling FROM tbl_review R, tbl_product P WHERE (R.productID=P.productID) and (R.status=TRUE) and('" + actief.getLogin() + "'=R.login);");
  
    /**
     * Creates new form ReviewToevoegen
     */
    public ReviewNieuwToevoegen() {
        initComponents();
        tblKeuzes.setModel(t);
    }
     public static ReviewNieuwToevoegen getInstance(Profielklant profielklant)
    {
        myCaller = profielklant;
        return toevoegenReview;
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
        tblKeuzes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtReviewID = new javax.swing.JTextField();
        txtProductID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtProductNaam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEenheidsPrijs = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTakeAwayNaam = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboboxScore = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBeoordeling = new javax.swing.JTextPane();
        btnToevoegenReview = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReviews = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        bntHomeknopProfielklant = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Toevoegen review");

        tblKeuzes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblKeuzes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKeuzesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKeuzes);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Selecteer het product waarvan u een review wil schrijven:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("reviewID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("productID:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("productnaam:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("type:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("eenheidsprijs:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("take-awaynaam:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("score:");

        comboboxScore.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("beoordeling:");

        jScrollPane2.setViewportView(txtBeoordeling);

        btnToevoegenReview.setBackground(new java.awt.Color(0, 0, 0));
        btnToevoegenReview.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnToevoegenReview.setForeground(new java.awt.Color(255, 255, 255));
        btnToevoegenReview.setText("Voeg review toe");
        btnToevoegenReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToevoegenReviewActionPerformed(evt);
            }
        });

        tblReviews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "reviewID", "productID", "productnaam", "type", "eenheidsprijs", "take-awaynaam", "score", "beoordeling"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblReviews);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Uw toegevoegde reviews:");

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
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnToevoegenReview)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboboxScore, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtReviewID)
                                            .addComponent(txtProductID)
                                            .addComponent(txtProductNaam)
                                            .addComponent(txtType)
                                            .addComponent(txtEenheidsPrijs)
                                            .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtReviewID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtProductNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEenheidsPrijs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(comboboxScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnToevoegenReview))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntHomeknopProfielklantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntHomeknopProfielklantActionPerformed
       Profielklant profiel = Profielklant.getInstance(toevoegenReview);
       profiel.pack();
       toevoegenReview.hide();
       profiel.show();
       profiel.setLocationRelativeTo(null);
       
    }//GEN-LAST:event_bntHomeknopProfielklantActionPerformed

    private void bntHomeknopProfielklantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntHomeknopProfielklantMouseClicked
        toevoegenReview.hide();
        myCaller.show();
        DefaultTableModel model = (DefaultTableModel)tblReviews.getModel();
        model.setRowCount(0);
        txtReviewID.setText("");
        txtProductID.setText("");
        txtProductNaam.setText("");
        txtType.setText("");
        txtEenheidsPrijs.setText("");
        txtTakeAwayNaam.setText("");
        comboboxScore.setSelectedItem(null);
        txtBeoordeling.setText("");
                
        /*       for(int i = 0; i < tblReviews.getRowCount(); i++){
           for (int j = 0; j <tblReviews.getColumnCount();j++){
               tblReviews.setValueAt("",i,j);
           }
       }*/
    }//GEN-LAST:event_bntHomeknopProfielklantMouseClicked

    private void btnToevoegenReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToevoegenReviewActionPerformed
        String productNaam = txtProductNaam.getText();
        String type = txtType.getText();
        String score = comboboxScore.getSelectedItem().toString();
        String reviewTekst = txtBeoordeling.getText();
        String takeAwayNaam = txtTakeAwayNaam.getText();

        if (txtReviewID.getText().isEmpty() || txtProductID.getText().isEmpty() || productNaam.isEmpty() || type.isEmpty()
                || txtEenheidsPrijs.getText().isEmpty() ||txtTakeAwayNaam.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Gelieve een product te selecteren.");
        } 
        else {
            if (!score.isEmpty() && !reviewTekst.isEmpty()) {
                DefaultTableModel model = (DefaultTableModel) tblReviews.getModel();
                model.addRow(new Object[]{txtReviewID.getText(), txtProductID.getText(), txtProductNaam.getText(),
                    txtType.getText(), txtEenheidsPrijs.getText(), txtTakeAwayNaam.getText(), 
                    comboboxScore.getSelectedItem().toString(), txtBeoordeling.getText()});
                int reviewID = Integer.parseInt(txtReviewID.getText());
                int score2 = Integer.parseInt(score);
                int productID = Integer.parseInt(txtProductID.getText());
                double eenheidsprijs = Double.parseDouble(txtEenheidsPrijs.getText());
                Review review = new Review(reviewID, score2, reviewTekst);
                d.invullenReview(actief, review);
                JOptionPane.showMessageDialog(null, "Uw review werd succesvol toegevoegd.");
            } else {
                JOptionPane.showMessageDialog(null, "Gelieve een score en beoordeling in te voeren.");
            }
        }
    }//GEN-LAST:event_btnToevoegenReviewActionPerformed

    private void tblKeuzesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKeuzesMouseClicked
        int row = tblKeuzes.getSelectedRow();
        String tabel_click = (tblKeuzes.getModel().getValueAt(row, 1).toString());
        String sql = "select * from tbl_product where productID = '" + tabel_click + "' ";
        txtProductID.setText(d.bestelFormulier(sql, "productID"));
        txtProductID.setEnabled(false);
        txtProductNaam.setText(d.bestelFormulier(sql, "naam"));
        txtProductNaam.setEnabled(false);
        txtType.setText(d.bestelFormulier(sql, "type"));
        txtType.setEnabled(false);
        txtEenheidsPrijs.setText(d.bestelFormulier(sql, "eenheidsprijs"));
        txtEenheidsPrijs.setEnabled(false);
        String sql2 = "select * from tbl_biedtAan where productID = '" + tabel_click + "' ";
        txtTakeAwayNaam.setText(d.bestelFormulier(sql, "naam"));
        txtTakeAwayNaam.setEnabled(false);
        String tabel_click2 = (tblKeuzes.getModel().getValueAt(row, 0).toString());
        String sql3 = "select * from tbl_review where reviewID = '" + tabel_click2 + "' ";
        txtReviewID.setText(d.bestelFormulier(sql3, "reviewID"));
        txtReviewID.setEnabled(false);
        comboboxScore.setSelectedItem(d.bestelFormulier(sql3, "score"));
        txtBeoordeling.setText(d.bestelFormulier(sql3, "beoordeling"));
        DefaultTableModel model2 = (DefaultTableModel) tblKeuzes.getModel();
        model2.removeRow(row);
    }//GEN-LAST:event_tblKeuzesMouseClicked

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
            java.util.logging.Logger.getLogger(ReviewNieuwToevoegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReviewNieuwToevoegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReviewNieuwToevoegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReviewNieuwToevoegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReviewNieuwToevoegen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bntHomeknopProfielklant;
    private javax.swing.JButton btnToevoegenReview;
    private javax.swing.JComboBox comboboxScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblKeuzes;
    private javax.swing.JTable tblReviews;
    private javax.swing.JTextPane txtBeoordeling;
    private javax.swing.JTextField txtEenheidsPrijs;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductNaam;
    private javax.swing.JTextField txtReviewID;
    private javax.swing.JTextField txtTakeAwayNaam;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
