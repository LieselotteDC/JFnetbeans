/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justfeed.GUI;

import Database.*;
import Logica.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liedcost
 */
public class Bestelling extends javax.swing.JFrame {

    private static final Bestelling bestelling = new Bestelling();
    public static JFrame myCaller;
    public Database d = new Database();

    public Klant actief = LoginKlant.getInstance().getActief();
    ArrayList<Orderverwerking> besteldeProducten = new ArrayList<>();
    ArrayList<Menu> berekendeMenus = new ArrayList<>(); // deze arraylist moet naar volgende scherm overgedragen worden
    Order orderZonderKorting = new Order(); // ook meegegeven worden

    //String[] columNames = new String[5];
    //Object data [][] = null;
    /**
     * Creates new form Bestelling
     */
    public Bestelling() {
        initComponents();

    }
    //private String[] columnNames = {"productID", "naam", "type", "eenheidsprijs", "hoeveelheid"};
    //DefaultTableModel table = new DefaultTableModel(columnNames, 0);

    /*public void addRow(String productID, String naam, String type, String eenheidsprijs, String hoeveelheid)
     {
     Object [] row = new Object [5];
     row[0] = productID;
     row[1] = naam;
     row[2] = type;
     row[3] = eenheidsprijs;
     row[4] = hoeveelheid;
     //table.addRow(row);
     }*/
    public static Bestelling getInstance(Profielklant caller) {
        myCaller = caller;
        return bestelling;
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
        btnBestellingPlaatsen = new javax.swing.JButton();
        btnToevoegenAanBestelling = new javax.swing.JButton();
        txtProductNaam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        txtEenheidsPrijs = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtProductID = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKeuzes = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBestelling = new javax.swing.JTable();
        spnrHoeveelheid = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSuggesties = new javax.swing.JTable();
        combobox = new javax.swing.JComboBox();
        rbtnType = new javax.swing.JRadioButton();
        btnZoek = new javax.swing.JButton();
        rbtnTakeAway = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPostcode = new javax.swing.JTextField();
        txtGemeente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTakeAwayNaam = new javax.swing.JTextField();
        txtVestigingsID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Bestelling plaatsen");

        btnBestellingPlaatsen.setBackground(new java.awt.Color(0, 0, 0));
        btnBestellingPlaatsen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBestellingPlaatsen.setForeground(new java.awt.Color(255, 255, 255));
        btnBestellingPlaatsen.setText("Bestelling plaatsen");
        btnBestellingPlaatsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestellingPlaatsenActionPerformed(evt);
            }
        });

        btnToevoegenAanBestelling.setBackground(new java.awt.Color(0, 0, 0));
        btnToevoegenAanBestelling.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnToevoegenAanBestelling.setForeground(new java.awt.Color(255, 255, 255));
        btnToevoegenAanBestelling.setText("Voeg toe aan mijn bestelling");
        btnToevoegenAanBestelling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToevoegenAanBestellingActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Naam");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Type");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Eenheidsprijs");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Hoeveelheid");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ProductID");

        tblKeuzes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblKeuzes.getTableHeader().setReorderingAllowed(false);
        tblKeuzes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKeuzesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKeuzes);

        tblBestelling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "productID", "productnaam", "type", "eenheidsprijs", "hoeveelheid", "take-awaynaam", "vestigingsID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBestelling.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBestelling);

        tblSuggesties.setBackground(new java.awt.Color(255, 153, 0));
        tblSuggesties.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblSuggesties.setForeground(new java.awt.Color(255, 153, 0));
        tblSuggesties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSuggesties.getTableHeader().setReorderingAllowed(false);
        tblSuggesties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSuggestiesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSuggesties);

        buttonGroup1.add(rbtnType);
        rbtnType.setText("type");
        rbtnType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnTypeMouseClicked(evt);
            }
        });

        btnZoek.setBackground(new java.awt.Color(0, 0, 0));
        btnZoek.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnZoek.setForeground(new java.awt.Color(255, 255, 255));
        btnZoek.setText("Zoek");
        btnZoek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoekActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnTakeAway);
        rbtnTakeAway.setText("take-away");
        rbtnTakeAway.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnTakeAwayMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Postcode waar moet worden  geleverd:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Gemeente waar moet worden geleverd:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Take-awaynaam");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("VestigingsID");

        jLabel11.setText("Suggesties:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Zoeken op:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(26, 26, 26)
                                        .addComponent(rbtnTakeAway)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtnType)))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtGemeente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combobox, javax.swing.GroupLayout.Alignment.LEADING, 0, 237, Short.MAX_VALUE)
                                    .addComponent(txtPostcode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZoek)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBestellingPlaatsen)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(spnrHoeveelheid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtEenheidsPrijs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                            .addComponent(txtType, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtProductNaam, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtProductID, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtVestigingsID, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(btnToevoegenAanBestelling)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel5))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtGemeente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTakeAwayNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtVestigingsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtProductNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEenheidsPrijs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(spnrHoeveelheid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnToevoegenAanBestelling)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBestellingPlaatsen))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnType)
                            .addComponent(rbtnTakeAway)
                            .addComponent(jLabel12)
                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnZoek))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBestellingPlaatsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBestellingPlaatsenActionPerformed
        Orderverwerking o = new Orderverwerking();
        Menu menu = new Menu();
        double totaalprijs = 0;

        for (Take_Away ta : d.getAlleTakeaways()) {
            for (Vestiging v : d.getAlleVestigingen(ta.getNaam())) {
                ArrayList<Orderverwerking> productenPerVestiging = o.verdelingBesteldeProducten(besteldeProducten, v.getTakeawayNaam(), v.getVestigingsID());
                berekendeMenus.add(menu.berekenMenuprijs(productenPerVestiging));
            }
        }
        for (Menu m : berekendeMenus) {

            totaalprijs += m.getMenuprijs();
        }
        orderZonderKorting.setTotaalPrijs(totaalprijs);
        
        //bovenaan de file
        /*Order orderMetKorting = new Order();
        double totaalprijs = 0;
        for(Menu m:berekendeMenus){
            totaalprijs += m.getMenuprijs();
        }
        orderMetKorting.setTotaalPrijs(totaalprijs);
        */
        BestellingOverzicht bestellingOverzicht = BestellingOverzicht.getInstance(bestelling);
        bestellingOverzicht.pack();
        bestelling.hide();
        bestellingOverzicht.show();
        bestellingOverzicht.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBestellingPlaatsenActionPerformed

    private void btnToevoegenAanBestellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToevoegenAanBestellingActionPerformed
        /*columNames = new String[] {"productID","naam","type","eenheidsprijs","hoeveelheid"};
         data = new Object[1][5];
         int i = 0;
         data [i][0] = txtProductID.getText();
         data [i][1] = txtProductNaam.getText();
         data [i][2] = txtType.getText();
         data [i][3] = txtEenheidsPrijs.getText();
         data [i][4] = txtHoeveelheid.getText();
         tblBestelling.setModel(new DefaultTableModel(data, columNames));
         i++;*/
        //
        String productNaam = txtProductNaam.getText();
        String type = txtType.getText();
        //Double eenheidsprijs = Double.parseDouble(txtEenheidsPrijs.getText());

        if (txtProductID.getText().isEmpty() || productNaam.isEmpty() || type.isEmpty()
                || txtEenheidsPrijs.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Gelieve een product te selecteren.");
        } else {
            if (Integer.parseInt(spnrHoeveelheid.getValue().toString()) > 0) {
                DefaultTableModel model = (DefaultTableModel) tblBestelling.getModel();
                model.addRow(new Object[]{txtProductID.getText(), txtProductNaam.getText(),
                    txtType.getText(), txtEenheidsPrijs.getText(), spnrHoeveelheid.getValue(), txtTakeAwayNaam.getText(), txtVestigingsID.getText()});
                int productID = Integer.parseInt(txtProductID.getText());
                double eenheidsprijs = Double.parseDouble(txtEenheidsPrijs.getText());
                String hoeveelheid1 = spnrHoeveelheid.getValue().toString();
                int hoeveelheid = Integer.parseInt(hoeveelheid1);
                String takeAwayNaam = txtTakeAwayNaam.getText();
                String vestigingsID = txtVestigingsID.getText();
                Orderverwerking p = new Orderverwerking(productID, productNaam, type, eenheidsprijs, hoeveelheid, takeAwayNaam, vestigingsID);
                //we hebben de initialisatie van de arratlist uit de methode gehaald omdat wij die moeten kunnen oproepen bij de knop bestelling aanmaken
                besteldeProducten.add(null);
            } else {
                JOptionPane.showMessageDialog(null, "Gelieve een geldige hoeveelheid in te voeren.");
            }
        }
    }//GEN-LAST:event_btnToevoegenAanBestellingActionPerformed


    private void tblKeuzesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKeuzesMouseClicked
        int row = tblKeuzes.getSelectedRow();
        String tabel_click = (tblKeuzes.getModel().getValueAt(row, 0).toString());
        String sql = "select * from tbl_product where productID = '" + tabel_click + "' ";
        txtProductID.setText(d.bestelFormulier(sql, "productID"));
        txtProductID.setEnabled(false);
        txtProductNaam.setText(d.bestelFormulier(sql, "naam"));
        txtProductNaam.setEnabled(false);
        txtType.setText(d.bestelFormulier(sql, "type"));
        txtType.setEnabled(false);
        txtEenheidsPrijs.setText(d.bestelFormulier(sql, "eenheidsprijs"));
        txtEenheidsPrijs.setEnabled(false);
        spnrHoeveelheid.setValue(0);
        String tabel_click2 = (tblKeuzes.getModel().getValueAt(row, 5).toString());
        String sql2 = "select * from tbl_vestigingen where vestigingsID = '" + tabel_click2 + "' ";
        txtTakeAwayNaam.setText(d.bestelFormulier(sql2, "naam"));
        txtTakeAwayNaam.setEnabled(false);
        txtVestigingsID.setText(d.bestelFormulier(sql2, "vestigingsID"));
        txtVestigingsID.setEnabled(false);
    }//GEN-LAST:event_tblKeuzesMouseClicked

    private void rbtnTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnTypeMouseClicked
        DefaultComboBoxModel c = d.initialiseerCombobox("SELECT type FROM tbl_product;", "type");
        combobox.setModel(c);
    }//GEN-LAST:event_rbtnTypeMouseClicked

    private void btnZoekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoekActionPerformed
        int postcode = Integer.parseInt(txtPostcode.getText());
        String gemeente = txtGemeente.getText();
        if (d.getPlaatsnummer(gemeente, postcode) == 0) {
            JOptionPane.showMessageDialog(null, "De ingevoerde postcode en gemeente voor uw levering stemmen niet overeen. Probeer opnieuw.");
            txtPostcode.setText("");
            txtGemeente.setText("");
        } else {
            int plaatsnummer = d.getPlaatsnummer(gemeente, postcode);
            if (rbtnType.isSelected()) {
                String gekozenType = combobox.getSelectedItem().toString();
                DefaultTableModel t = d.naarTabel("SELECT P.productID,P.naam,P.type,P.eenheidsprijs,B.naam,V.vestigingsID FROM tbl_product P JOIN tbl_biedtAan B ON (P.productID=B.productID) JOIN tbl_vestigingen V ON (B.naam=V.naam) JOIN tbl_leveringsregio L ON ((V.naam=L.naam) and (V.vestigingsID=L.vestigingsID)) WHERE (P.type = '" + gekozenType + "') AND (L.leveringsgebied= " + plaatsnummer + ")");
                tblKeuzes.setModel(t);
            } else if (rbtnTakeAway.isSelected()) {
                String gekozenTakeAway = combobox.getSelectedItem().toString();
                DefaultTableModel q = d.naarTabel("SELECT P.productID,P.naam,P.type,P.eenheidsprijs,B.naam,V.vestigingsID FROM tbl_product P JOIN tbl_biedtAan B ON (P.productID=B.productID) JOIN tbl_vestigingen V ON (B.naam=V.naam) JOIN tbl_leveringsregio L ON ((V.naam=L.naam) and (V.vestigingsID=L.vestigingsID)) WHERE (B.naam = '" + gekozenTakeAway + "') AND (L.leveringsgebied= " + plaatsnummer + ")");
                tblKeuzes.setModel(q);
            }
        }
    }//GEN-LAST:event_btnZoekActionPerformed

    private void rbtnTakeAwayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnTakeAwayMouseClicked
        DefaultComboBoxModel f = d.initialiseerCombobox("SELECT naam FROM tbl_takeaway;", "naam");
        combobox.setModel(f);
    }//GEN-LAST:event_rbtnTakeAwayMouseClicked

    private void tblSuggestiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuggestiesMouseClicked
        int row = tblSuggesties.getSelectedRow();
        String tabel_click = (tblSuggesties.getModel().getValueAt(row, 0).toString());
        String sql = "select * from tbl_product where productID = '" + tabel_click + "' ";
        txtProductID.setText(d.bestelFormulier(sql, "productID"));
        txtProductID.setEnabled(false);
        txtProductNaam.setText(d.bestelFormulier(sql, "naam"));
        txtProductNaam.setEnabled(false);
        txtType.setText(d.bestelFormulier(sql, "type"));
        txtType.setEnabled(false);
        txtEenheidsPrijs.setText(d.bestelFormulier(sql, "eenheidsprijs"));
        txtEenheidsPrijs.setEnabled(false);
        spnrHoeveelheid.setValue(0);
        String tabel_click2 = (tblKeuzes.getModel().getValueAt(row, 5).toString());
        String sql2 = "select * from tbl_vestigingen where vestigingsID = '" + tabel_click2 + "' ";
        txtTakeAwayNaam.setText(d.bestelFormulier(sql2, "naam"));
        txtTakeAwayNaam.setEnabled(false);
        txtVestigingsID.setText(d.bestelFormulier(sql2, "vestigingsID"));
        txtVestigingsID.setEnabled(false);
    }//GEN-LAST:event_tblSuggestiesMouseClicked

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
            java.util.logging.Logger.getLogger(Bestelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bestelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bestelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bestelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bestelling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBestellingPlaatsen;
    private javax.swing.JButton btnToevoegenAanBestelling;
    private javax.swing.JButton btnZoek;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rbtnTakeAway;
    private javax.swing.JRadioButton rbtnType;
    private javax.swing.JSpinner spnrHoeveelheid;
    private javax.swing.JTable tblBestelling;
    private javax.swing.JTable tblKeuzes;
    private javax.swing.JTable tblSuggesties;
    private javax.swing.JTextField txtEenheidsPrijs;
    private javax.swing.JTextField txtGemeente;
    private javax.swing.JTextField txtPostcode;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductNaam;
    private javax.swing.JTextField txtTakeAwayNaam;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtVestigingsID;
    // End of variables declaration//GEN-END:variables
}
