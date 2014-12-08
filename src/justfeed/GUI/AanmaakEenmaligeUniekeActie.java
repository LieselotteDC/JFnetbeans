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
 * @author ladkerpe
 */
public class AanmaakEenmaligeUniekeActie extends javax.swing.JFrame {
    
    private static final AanmaakEenmaligeUniekeActie uniekeActie = new AanmaakEenmaligeUniekeActie();
    public static JFrame myCaller;
    public Database d = new Database();
    DefaultComboBoxModel c = d.initialiseerCombobox("SELECT naam FROM tbl_takeaway;", "naam");
    /**
     * Creates new form EenmaligeUniekeActieAanmaken
     */
    public AanmaakEenmaligeUniekeActie() {
        initComponents();
        comboboxTakeAway.setModel(c);
    }
    public static AanmaakEenmaligeUniekeActie getInstance(Administrator caller)
    {
        
        myCaller = caller;
        return uniekeActie;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        aanmakenEenmaligeUniekeKorting = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBedrag = new javax.swing.JTextField();
        txtPercentage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rbtnVestiging = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbtnTakeAway = new javax.swing.JRadioButton();
        lblVestiging = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVestigingen = new javax.swing.JTable();
        comboboxTakeAway = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnHomeknopAdministrator = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Aanmaak van een eenmalige unieke korting: ");

        aanmakenEenmaligeUniekeKorting.setBackground(new java.awt.Color(0, 0, 0));
        aanmakenEenmaligeUniekeKorting.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        aanmakenEenmaligeUniekeKorting.setForeground(new java.awt.Color(255, 255, 255));
        aanmakenEenmaligeUniekeKorting.setText("Aanmaken");
        aanmakenEenmaligeUniekeKorting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aanmakenEenmaligeUniekeKortingActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Bedrag:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Percentage:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel8.setText("* Indien u bedrag invult, gelieve percentage op 0 te zetten.");

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel9.setText("Indien u echter percentage invult, gelieve bedrag op 0 te zetten.");

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("* Verplicht");

        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("* ");

        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("* ");

        buttonGroup1.add(rbtnVestiging);
        rbtnVestiging.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnVestiging.setText("per vestiging");
        rbtnVestiging.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnVestigingMouseClicked(evt);
            }
        });
        rbtnVestiging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVestigingActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Takeaway:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 51, 51));
        jLabel31.setText("*");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Kortingscode maken:");

        buttonGroup1.add(rbtnTakeAway);
        rbtnTakeAway.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnTakeAway.setText("per take-away");
        rbtnTakeAway.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnTakeAwayMouseClicked(evt);
            }
        });
        rbtnTakeAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTakeAwayActionPerformed(evt);
            }
        });

        lblVestiging.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVestiging.setText("Selecteer de gewenste vestiging:");

        tblVestigingen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVestigingen);

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

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
        jMenuBar1.add(btnHomeknopAdministrator);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblVestiging)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnTakeAway)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnVestiging))
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                                .addComponent(txtPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBedrag, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(aanmakenEenmaligeUniekeKorting, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboboxTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(54, 54, 54))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnTakeAway)
                            .addComponent(rbtnVestiging))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVestiging, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel15)))
                            .addComponent(txtBedrag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPercentage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel14)))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel11))
                        .addComponent(aanmakenEenmaligeUniekeKorting, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aanmakenEenmaligeUniekeKortingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aanmakenEenmaligeUniekeKortingActionPerformed
        String gekozenTakeAway;
        gekozenTakeAway = comboboxTakeAway.getSelectedItem().toString();
        if(gekozenTakeAway.isEmpty() || txtBedrag.getText().isEmpty() || txtPercentage.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Gelieve alle verplichte velden in te vullen.");
            if (gekozenTakeAway.isEmpty()){
            comboboxTakeAway.requestFocus();
            }
            else if(txtBedrag.getText().isEmpty()){
            txtBedrag.requestFocus();
            }
            else if (txtPercentage.getText().isEmpty()){
            txtPercentage.requestFocus();
            }
        }
        else if(!rbtnTakeAway.isSelected() && !rbtnVestiging.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Gelieve een keuze te maken tussen 'per takeaway' en 'per vestiging'.");
        }
        else{
            double bedrag = Double.parseDouble(txtBedrag.getText());
            double percentage = Double.parseDouble(txtPercentage.getText());
                if(rbtnVestiging.isSelected()){
                    int gekozenVestiging = tblVestigingen.getSelectedRow();
                    String vestigingsID = tblVestigingen.getValueAt(gekozenVestiging,0).toString();
                    UniekeActieEenmalig nieuweUniekeActieEenmalig = new UniekeActieEenmalig(vestigingsID, gekozenTakeAway, bedrag, percentage);
                    d.addKortingEenmaligUniek(nieuweUniekeActieEenmalig);
                }
                else if(rbtnTakeAway.isSelected()){
                    for(Vestiging ves: d.getAlleVestigingen(gekozenTakeAway)){
                        String vestigingsID2 = ves.getVestigingsID();
                        UniekeActieEenmalig nieuweUniekeActieEenmalig = new UniekeActieEenmalig(vestigingsID2, gekozenTakeAway, bedrag, percentage);
                    d.addKortingEenmaligUniek(nieuweUniekeActieEenmalig);
                    }
                }
                //(Date startdatum, Date einddatum, String vestiging, String takeawayNaam, double bedrag, double percentage)
            JOptionPane.showMessageDialog(null, "Uw kortingscode werd succesvol toegevoegd.");
            Administrator administrator = Administrator.getInstance(uniekeActie);
            //     administrator.setSize(300,300);
            administrator.pack();
            uniekeActie.hide();
            administrator.show();
            administrator.setLocationRelativeTo(null);
            comboboxTakeAway.setSelectedItem(null);
            DefaultTableModel model = (DefaultTableModel)tblVestigingen.getModel();
            model.setRowCount(0);
            txtBedrag.setText("");
            txtPercentage.setText("");
        }
    }//GEN-LAST:event_aanmakenEenmaligeUniekeKortingActionPerformed

    private void btnHomeknopAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorActionPerformed
       Administrator admini = Administrator.getInstance(uniekeActie);
       admini.pack();
       uniekeActie.hide();
       admini.show();
       admini.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHomeknopAdministratorActionPerformed

    private void btnHomeknopAdministratorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeknopAdministratorMouseClicked
        uniekeActie.hide();
        myCaller.show();
        comboboxTakeAway.setSelectedItem(null);
        DefaultTableModel model = (DefaultTableModel)tblVestigingen.getModel();
        model.setRowCount(0);
        txtBedrag.setText("");
        txtPercentage.setText("");
    }//GEN-LAST:event_btnHomeknopAdministratorMouseClicked

    private void rbtnVestigingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnVestigingMouseClicked
        //query om de vestigingen van de geselecteerde take-away op te halen
        //DefaultComboBoxModel f = d.initialiseerCombobox("SELECT vestigingsID FROM tbl_vestigingen;", "vestigingsID");
        String gekozenTakeAway;
        gekozenTakeAway = comboboxTakeAway.getSelectedItem().toString();
        //System.out.println(gekozenTakeAway);
        DefaultTableModel t = d.naarTabel("SELECT vestigingsID FROM tbl_vestigingen WHERE naam = '" + gekozenTakeAway + "';");
        tblVestigingen.setModel(t);
    }//GEN-LAST:event_rbtnVestigingMouseClicked

    private void rbtnVestigingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVestigingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnVestigingActionPerformed

    private void rbtnTakeAwayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnTakeAwayMouseClicked
        //comboboxVestiging.setEnabled(false);
        //lblVestiging.setForeground(Color.LIGHT_GRAY);
        DefaultTableModel model = (DefaultTableModel)tblVestigingen.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_rbtnTakeAwayMouseClicked

    private void rbtnTakeAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTakeAwayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnTakeAwayActionPerformed

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
            java.util.logging.Logger.getLogger(AanmaakEenmaligeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AanmaakEenmaligeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AanmaakEenmaligeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AanmaakEenmaligeUniekeActie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AanmaakEenmaligeUniekeActie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aanmakenEenmaligeUniekeKorting;
    private javax.swing.JMenu btnHomeknopAdministrator;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboboxTakeAway;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVestiging;
    private javax.swing.JRadioButton rbtnTakeAway;
    private javax.swing.JRadioButton rbtnVestiging;
    private javax.swing.JTable tblVestigingen;
    private javax.swing.JTextField txtBedrag;
    private javax.swing.JTextField txtPercentage;
    // End of variables declaration//GEN-END:variables
}
