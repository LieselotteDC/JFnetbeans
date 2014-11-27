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
 * @author UGent
 */
public class Aanpassenvestiging extends javax.swing.JFrame {

    private static final Aanpassenvestiging aangepastevestiging = new Aanpassenvestiging();
    public static JFrame myCaller;
    public Database d = new Database();
   
    public Aanpassenvestiging() {
        initComponents();
    }

    public static Aanpassenvestiging getInstance(Administrator admini)
    {
        myCaller = admini;
        return aangepastevestiging;
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
        txtHuidigeNaam = new javax.swing.JTextField();
        btnAanpassen = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtHuidigID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtLeveringskosten = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtStraat = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtHuisnummer = new javax.swing.JTextField();
        txtPostcode = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtGemeente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopAdministrator = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pas de gewenste vestiging aan");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Huidig vestigingsID:");

        btnAanpassen.setBackground(new java.awt.Color(0, 0, 0));
        btnAanpassen.setForeground(new java.awt.Color(255, 255, 255));
        btnAanpassen.setText("Aanpassen");
        btnAanpassen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toevoegenAanpassenVestiging(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Huidige naam:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Leveringskosten:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Straat:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Huisnummer:");

        txtHuisnummer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHuisnummerActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Postcode:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Gemeente:");

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

        btnHomeknopAdministrator.setBackground(new java.awt.Color(255, 153, 0));
        btnHomeknopAdministrator.setText("Home");
        btnHomeknopAdministrator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back(evt);
            }
        });
        btnHomeknopAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeknopAdministratorActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnHomeknopAdministrator);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHuisnummer)
                                    .addComponent(txtPostcode)
                                    .addComponent(txtStraat, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtGemeente)
                                    .addComponent(txtLeveringskosten)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtHuidigID, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtHuidigeNaam)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAanpassen)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHuidigeNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHuidigID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLeveringskosten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStraat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHuisnummer, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGemeente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(31, 31, 31)
                .addComponent(btnAanpassen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back
        aangepastevestiging.hide();
        myCaller.show();
    }//GEN-LAST:event_back

    private void toevoegenAanpassenVestiging(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toevoegenAanpassenVestiging
         String gemeente = txtGemeente.getText();   
         String huidigID = txtHuidigID.getText();
         String nieuweStraat = txtStraat.getText();   
         String huidigeTakeAwayNaam = txtHuidigeNaam.getText();

             
        if(!d.bestaatVestiging(huidigID, huidigeTakeAwayNaam)){
         int reply = JOptionPane.showConfirmDialog(null, "Deze vestiging bestaat nog niet. Wil U deze toevoegen?", "Toevoegen vestiging",JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
            Aanmaaknieuwevestiging vestiging = Aanmaaknieuwevestiging.getInstance(aangepastevestiging);
    //      vestiging.setSize(300,300);
            vestiging.pack();
            aangepastevestiging.hide();
            vestiging.show();
            vestiging.setLocationRelativeTo(null);
            }
            else {
            JOptionPane.showConfirmDialog(null, "U kan enkel bestaande vestigingen wijzigen. Probeer opnieuw.");
            txtHuidigID.setText("");
            txtGemeente.setText("");
            txtPostcode.setText("");
            txtHuisnummer.setText("");
            txtStraat.setText("");
            txtLeveringskosten.setText("");
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
            //int postcode = Integer.parseInt(txtPostcode.getText());
            double nieuweLeveringskosten = Double.parseDouble(txtLeveringskosten.getText());
            int nieuwHuisnummer = Integer.parseInt(txtHuisnummer.getText());
            int plaatsnummer = d.getPlaatsnummer(gemeente, postcode);
            //Vestiging huidigeVestiging = d.getVestiging(huidigeTakeAwayNaam, huidigID);
            //ophalen welke vestiging er achter de ingevoerde naam + id zit 
            Vestiging aangepasteVestiging = new Vestiging(nieuweStraat, nieuwHuisnummer, nieuweLeveringskosten, plaatsnummer, huidigeTakeAwayNaam, huidigID);
            //d.updateVestiging(huidigeVestiging, aangepasteVestiging);
            aangepastevestiging.hide();
            myCaller.show();  
            }
        }      
    }//GEN-LAST:event_toevoegenAanpassenVestiging

    private void txtHuisnummerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHuisnummerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHuisnummerActionPerformed

    private void btnHomeknopAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorActionPerformed
       Administrator administrator = Administrator.getInstance(aangepastevestiging);
//     administrator.setSize(300,300);
       administrator.pack();
       aangepastevestiging.hide();
       administrator.show();
       administrator.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopAdministratorActionPerformed

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
            java.util.logging.Logger.getLogger(Aanpassenvestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aanpassenvestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aanpassenvestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aanpassenvestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aanpassenvestiging().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAanpassen;
    private javax.swing.JMenu btnHomeknopAdministrator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField txtGemeente;
    private javax.swing.JTextField txtHuidigID;
    private javax.swing.JTextField txtHuidigeNaam;
    private javax.swing.JTextField txtHuisnummer;
    private javax.swing.JTextField txtLeveringskosten;
    private javax.swing.JTextField txtPostcode;
    private javax.swing.JTextField txtStraat;
    // End of variables declaration//GEN-END:variables
}
