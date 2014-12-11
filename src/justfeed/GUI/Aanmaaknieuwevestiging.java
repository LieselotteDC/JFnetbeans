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
public class Aanmaaknieuwevestiging extends javax.swing.JFrame {

    private static final Aanmaaknieuwevestiging vestiging = new Aanmaaknieuwevestiging();
    public static JFrame myCaller;
    public Database d = new Database();

    public Aanmaaknieuwevestiging() {
        initComponents();
    }

    public static Aanmaaknieuwevestiging getInstance(Administrator admini) {
        myCaller = admini;
        return vestiging;
    }

    public static Aanmaaknieuwevestiging getInstance(Aanpassenvestiging aangepastevestiging) {
        myCaller = aangepastevestiging;
        return vestiging;
    }

    public static Aanmaaknieuwevestiging getInstance(AanmaakEenmaligeUniekeActie uniekeActie) {
        myCaller = uniekeActie;
        return vestiging;
    }

    public static Aanmaaknieuwevestiging getInstance(AanmaakNieuwProduct nieuwproduct) {
        myCaller = nieuwproduct;
        return vestiging;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTakeAwayNaam = new javax.swing.JTextField();
        txtVestigingNaam = new javax.swing.JTextField();
        txtStraat = new javax.swing.JTextField();
        txtHuisnummer = new javax.swing.JTextField();
        txtPostcode = new javax.swing.JTextField();
        txtGemeente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtLeveringskosten = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLeveringsgebied = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        btnHomeknopAdministrator = new javax.swing.JMenu();

        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Voeg de gewenste vestiging toe");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Naam take-away:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Naam vestiging:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Straat:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Huisnummer:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Postcode:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Gemeente:");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Toevoegen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toevoegenNieuweVestiging(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Leveringskosten:");

        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("*");

        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("* Verplicht");

        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("*");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Leveringsgebied(en):");

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel10.setText("(voorbeeld vereiste syntax: 9000Gent;9400Ninove;2000Antwerpen;...;)");

        txtLeveringsgebied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLeveringsgebiedActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("*");

        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("*");

        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("*");

        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setText("*");

        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("*");

        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setText("*");

        jMenuBar2.setBackground(new java.awt.Color(255, 153, 0));

        btnHomeknopAdministrator.setBackground(new java.awt.Color(255, 153, 0));
        btnHomeknopAdministrator.setText("Home");
        btnHomeknopAdministrator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeknopAdministratorMouseClicked(evt);
            }
        });
        btnHomeknopAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeknopAdministratorActionPerformed(evt);
            }
        });
        jMenuBar2.add(btnHomeknopAdministrator);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTakeAwayNaam)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtGemeente, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                            .addComponent(txtLeveringskosten, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                            .addComponent(txtPostcode, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                            .addComponent(txtHuisnummer, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                            .addComponent(txtStraat, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                            .addComponent(txtVestigingNaam, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                            .addComponent(txtLeveringsgebied))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(226, 226, 226))
                                    .addComponent(jLabel10))
                                .addGap(0, 103, Short.MAX_VALUE)))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtVestigingNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtStraat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtHuisnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGemeente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLeveringskosten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtLeveringsgebied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toevoegenNieuweVestiging(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toevoegenNieuweVestiging
        String takeAwayNaam = txtTakeAwayNaam.getText();
        String vestigingsID = txtVestigingNaam.getText();
        String straat = txtStraat.getText();
        String gemeente = txtGemeente.getText();
        String stringlevgebied = txtLeveringsgebied.getText();

        if (takeAwayNaam.isEmpty() || vestigingsID.isEmpty() || straat.isEmpty()
                || txtHuisnummer.getText().isEmpty() || txtPostcode.getText().isEmpty()
                || gemeente.isEmpty() || txtLeveringskosten.getText().isEmpty() || stringlevgebied.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Gelieve alle verplichte velden in te vullen.");
            if (takeAwayNaam.isEmpty()) {
                txtTakeAwayNaam.requestFocus();
            } else if (vestigingsID.isEmpty()) {
                txtVestigingNaam.requestFocus();
            } else if (straat.isEmpty()) {
                txtStraat.requestFocus();
            } else if (txtHuisnummer.getText().isEmpty()) {
                txtHuisnummer.requestFocus();
            } else if (txtPostcode.getText().isEmpty()) {
                txtPostcode.requestFocus();
            } else if (gemeente.isEmpty()) {
                txtGemeente.requestFocus();
            } else if (txtLeveringskosten.getText().isEmpty()) {
                txtLeveringskosten.requestFocus();
            } else if (txtLeveringsgebied.getText().isEmpty()) {
                txtLeveringsgebied.requestFocus();
            }
        } else if (!d.take_AwayBestaat(takeAwayNaam)) {
            int reply = JOptionPane.showConfirmDialog(null, "Deze take-away bestaat niet. Wil U deze toevoegen?", "Take-away toevoegen", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                AanmaaknieuweTakeaway nieuweTakeaway = AanmaaknieuweTakeaway.getInstance(vestiging);
                nieuweTakeaway.pack();
                vestiging.hide();
                nieuweTakeaway.show();
                nieuweTakeaway.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(null, "U kan enkel nieuwe vestigingen aanmaken van bestaande take-aways. Probeer opnieuw.");
                txtTakeAwayNaam.setText("");
            }
        } else if (d.bestaatVestiging(vestigingsID, takeAwayNaam)) {
            JOptionPane.showMessageDialog(null, "Deze vestiging bestaat reeds.Probeer opnieuw.");
            txtVestigingNaam.setText("");
            txtVestigingNaam.requestFocus();
        } else {
            int postcode = Integer.parseInt(txtPostcode.getText());
            int huisnummer = Integer.parseInt(txtHuisnummer.getText());
            if (d.getPlaatsnummer(gemeente, postcode) == 0) {
                JOptionPane.showMessageDialog(null, "De ingevoerde postcode en gemeente van uw vestiging stemmen niet overeen. Probeer opnieuw.");
                txtPostcode.setText("");
                txtGemeente.setText("");
            } else if (stringlevgebied.charAt(stringlevgebied.length() - 1) != ';') {
                JOptionPane.showMessageDialog(null, "De ingevoerde leveringsgebieden hebben niet de vereiste syntax. Probeer opnieuw.");
                txtLeveringsgebied.setText("");
            } else {
                int plaatsnummer = d.getPlaatsnummer(gemeente, postcode);
                double leveringskosten = Double.parseDouble(txtLeveringskosten.getText());
                Vestiging ves = new Vestiging(straat, huisnummer, leveringskosten, plaatsnummer, takeAwayNaam, vestigingsID);
                d.addVestiging(ves);
                int i = 0;
                while (i >= 0 && i < (stringlevgebied.length() - 1)) {
                    String postcodeengemeentelevgebied = stringlevgebied.substring(i, stringlevgebied.indexOf(';'));
                    String postcodelevgebied = postcodeengemeentelevgebied.substring(i, 4);
                    int postcodelevgebied2 = Integer.parseInt(postcodelevgebied);
                    String gemeentelevgebied = stringlevgebied.substring(4, stringlevgebied.indexOf(';'));
                    int plaatsnummerlevgebied = d.getPlaatsnummer(gemeentelevgebied, postcodelevgebied2);
                    d.addLeveringsgebiedFromVestiging(plaatsnummerlevgebied, ves);
                    stringlevgebied = stringlevgebied.substring(stringlevgebied.indexOf(';') + 1);
                }
                JOptionPane.showMessageDialog(null, "De vestiging werd succesvol toegevoegd.");
                vestiging.hide();
                myCaller.show();
                txtTakeAwayNaam.setText("");
                txtVestigingNaam.setText("");
                txtStraat.setText("");
                txtHuisnummer.setText("");
                txtGemeente.setText("");
                txtPostcode.setText("");
                txtLeveringskosten.setText("");
                txtLeveringsgebied.setText("");
                txtLeveringsgebied.setText("");
            }
        }
    }//GEN-LAST:event_toevoegenNieuweVestiging

    private void btnHomeknopAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorActionPerformed
        Administrator administrator = Administrator.getInstance(vestiging);
//     amdministrator.setSize(300,300);
        administrator.pack();
        vestiging.hide();
        administrator.show();
        administrator.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopAdministratorActionPerformed

    private void btnHomeknopAdministratorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorMouseClicked
        vestiging.hide();
        myCaller.show();
        txtTakeAwayNaam.setText("");
        txtVestigingNaam.setText("");
        txtStraat.setText("");
        txtHuisnummer.setText("");
        txtPostcode.setText("");
        txtGemeente.setText("");
        txtLeveringskosten.setText("");
    }//GEN-LAST:event_btnHomeknopAdministratorMouseClicked

    private void txtLeveringsgebiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLeveringsgebiedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLeveringsgebiedActionPerformed

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
            java.util.logging.Logger.getLogger(Aanmaaknieuwevestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aanmaaknieuwevestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aanmaaknieuwevestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aanmaaknieuwevestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aanmaaknieuwevestiging().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnHomeknopAdministrator;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JTextField txtGemeente;
    private javax.swing.JTextField txtHuisnummer;
    private javax.swing.JTextField txtLeveringsgebied;
    private javax.swing.JTextField txtLeveringskosten;
    private javax.swing.JTextField txtPostcode;
    private javax.swing.JTextField txtStraat;
    private javax.swing.JTextField txtTakeAwayNaam;
    private javax.swing.JTextField txtVestigingNaam;
    // End of variables declaration//GEN-END:variables
}
