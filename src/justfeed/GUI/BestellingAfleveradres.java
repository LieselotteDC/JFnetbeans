/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package justfeed.GUI;
import Database.*;
import Logica.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author UGent
 */
public class BestellingAfleveradres extends javax.swing.JFrame {
private static final BestellingAfleveradres adres = new BestellingAfleveradres();
public Klant actief = LoginKlant.getInstance().getActief();
public Order orderZonderKorting = Bestelling.getInstance().getOrderZonderKorting();
public ArrayList<Menu> berekendeMenus = Bestelling.getInstance().getBerekendeMenus();
String gemeente = Bestelling.getInstance().getGemeente();
int postcode = Bestelling.getInstance().getPostcode();
String postcode2 = Integer.toString(postcode);
public static JFrame myCaller;
    
    public Database d = new Database();
    /**
     * Creates new form Afleveradres
     */
    public BestellingAfleveradres() {
        initComponents();
        txtGemeente.setText(gemeente);
        txtPostcode.setText(postcode2);
    }
    public static BestellingAfleveradres getInstance(BestellingOverzicht bestellingOverzicht)
    {
        myCaller = bestellingOverzicht;
        return adres;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStraat = new javax.swing.JTextField();
        txtHuisnummer = new javax.swing.JTextField();
        txtPostcode = new javax.swing.JTextField();
        txtGemeente = new javax.swing.JTextField();
        btnAfrekenen = new javax.swing.JButton();
        btnKortingscodeToevoegen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Gelieve het gewenste afleveradres in te voeren");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Straat:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Huisnummer:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Postcode:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Gemeente:");

        btnAfrekenen.setBackground(new java.awt.Color(0, 0, 0));
        btnAfrekenen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAfrekenen.setForeground(new java.awt.Color(255, 255, 255));
        btnAfrekenen.setText("Afrekenen");
        btnAfrekenen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfrekenenActionPerformed(evt);
            }
        });

        btnKortingscodeToevoegen.setBackground(new java.awt.Color(0, 0, 0));
        btnKortingscodeToevoegen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnKortingscodeToevoegen.setForeground(new java.awt.Color(255, 255, 255));
        btnKortingscodeToevoegen.setText("Kortingscode toevoegen");
        btnKortingscodeToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKortingscodeToevoegenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStraat, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGemeente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPostcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHuisnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnKortingscodeToevoegen)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnAfrekenen, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtStraat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHuisnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGemeente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAfrekenen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKortingscodeToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAfrekenenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfrekenenActionPerformed
       String straat = txtStraat.getText();
       String gemeente = txtGemeente.getText();
       
       if(straat.isEmpty() || txtHuisnummer.getText().isEmpty() || txtPostcode.getText().isEmpty() 
               || gemeente.isEmpty()){
            JOptionPane.showMessageDialog(null, "Gelieve alle verplichte velden in te vullen.");
            if (straat.isEmpty()){
            txtStraat.requestFocus();
            }
            else if (txtHuisnummer.getText().isEmpty()){
            txtHuisnummer.requestFocus();
            }
            else if(txtPostcode.getText().isEmpty()){
            txtPostcode.requestFocus();
            }
            else if(gemeente.isEmpty()){
            txtGemeente.requestFocus();
            }
        }
       else{
            int postcode = Integer.parseInt(txtPostcode.getText());
            int huisnummer = Integer.parseInt(txtHuisnummer.getText());
            if(d.getPlaatsnummer(gemeente, postcode) == 0){
                JOptionPane.showMessageDialog(null, "De ingevoerde postcode en gemeente stemmen niet overeen. Probeer opnieuw.");
                txtPostcode.setText("");
                txtGemeente.setText("");
                }
            else{
                int plaatsnummer = d.getPlaatsnummer(gemeente, postcode);
                //Order(double totaalPrijs, Date datum, String straat, int huisnummer, int plaatsnummer, String login, boolean status)
                orderZonderKorting.setHuisnummer(huisnummer);
                orderZonderKorting.setPlaatsnummer(plaatsnummer);
                orderZonderKorting.setStraat(straat);

            }
       }
       BestellingFactuur factuur = BestellingFactuur.getInstance(adres);
       factuur.pack();
       adres.hide();
       factuur.show();
       factuur.setLocationRelativeTo(null);
       txtStraat.setText("");
       txtGemeente.setText("");
       txtHuisnummer.setText("");
       txtPostcode.setText("");
    }//GEN-LAST:event_btnAfrekenenActionPerformed

    private void btnKortingscodeToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKortingscodeToevoegenActionPerformed
        txtStraat.setText("");
        txtGemeente.setText("");
        txtHuisnummer.setText("");
        txtPostcode.setText("");
        BestellingKortingscode kortingscode = BestellingKortingscode.getInstance(adres);
        kortingscode.pack();
        adres.hide();
        kortingscode.show();
        kortingscode.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnKortingscodeToevoegenActionPerformed

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
            java.util.logging.Logger.getLogger(BestellingAfleveradres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BestellingAfleveradres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BestellingAfleveradres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BestellingAfleveradres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BestellingAfleveradres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfrekenen;
    private javax.swing.JButton btnKortingscodeToevoegen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtGemeente;
    private javax.swing.JTextField txtHuisnummer;
    private javax.swing.JTextField txtPostcode;
    private javax.swing.JTextField txtStraat;
    // End of variables declaration//GEN-END:variables
}
