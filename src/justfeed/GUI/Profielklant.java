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
public class Profielklant extends javax.swing.JFrame {

    private static final Profielklant profiel = new Profielklant();
    public static JFrame myCaller;
    public Database d = new Database();
     private static final LoginKlant login = new LoginKlant();
    
    public Profielklant() {
        initComponents();
    }

    public static Profielklant getInstance(LoginKlant caller)
    {
        myCaller = caller;
        return profiel;
    }
    
    public static Profielklant getInstance(RegistratieKlant caller)
    {
        myCaller = caller;
        return profiel;
    }
    public static Profielklant getInstance(ZoekresultatenGemeente zoekresultatenGemeente)
    {
        myCaller = zoekresultatenGemeente;
        return profiel;
    }
    public static Profielklant getInstance(ZoekresultatenTakeaway zoekresultatenTakeaway)
    {
        myCaller = zoekresultatenTakeaway;
        return profiel;
    }
    public static Profielklant getInstance(ZoekresultatenCategorie zoekresultatenCategorie)
    {
        myCaller = zoekresultatenCategorie;
        return profiel;
    }
    public static Profielklant getInstance(ZoekresultatenProduct zoekresultatenProduct)
    {
        myCaller = zoekresultatenProduct;
        return profiel;
    }
    public static Profielklant getInstance(Overzichtkortingscodesklant codesklant)
    {
        myCaller = codesklant;
        return profiel;
    }
    public static Profielklant getInstance(Overzichtreviewsklant reviewsklant)
    {
        myCaller = reviewsklant;
        return profiel;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        naarContact = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Welkom op jouw profiel!");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setText("Eén menu bestaat uit gerechten van slechts één vestiging.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel3.setText("Eén order kan uit verschillende menu's bestaan.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setText("Vanaf een bedrag van 20 euro per vestiging valt de leveringskost weg. ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Toelichting bij de werking van het systeem:");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log uit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarUitloggen(evt);
            }
        });

        jMenu2.setText("Aanpassen");

        jMenuItem2.setText("Gegevens");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarAanpassenklantgegevens(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Account verwijderen");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarAccountklantverwijderen(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Order plaatsen");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderPlaatsen(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Kortingscodes");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naarOverzichtKortingscodesKlant(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reviews");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naarOverzichtReviewsKlant(evt);
            }
        });

        jMenuItem11.setText("Zoek reviews van bepaald product");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekenReview(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem10.setText("Voeg nieuwe review toe");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarToevoegenReview(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem9.setText("Overzicht van uw reviews");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarOverzichtReviews(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Zoeken");

        jMenuItem4.setText("Categorie");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekenCategorie(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("Product");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekenProduct(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItem6.setText("Takeaway");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekenTakeAway(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem7.setText("Gemeente");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekenGemeente(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        naarContact.setText("Contact");
        naarContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarContact(evt);
            }
        });

        jMenuItem8.setText("Zend e-mail naar klantendienst");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarContact(evt);
            }
        });
        naarContact.add(jMenuItem8);

        jMenuBar1.add(naarContact);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void naarAanpassenklantgegevens(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarAanpassenklantgegevens
       Aanpassenklantgegevens anderegegevensklant = Aanpassenklantgegevens.getInstance(profiel);
//     anderegevensklant.setSize(300,300);
       anderegegevensklant.pack();
       profiel.hide();
       anderegegevensklant.show();
       anderegegevensklant.setLocationRelativeTo(null);

       
    }//GEN-LAST:event_naarAanpassenklantgegevens

    private void naarAccountklantverwijderen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarAccountklantverwijderen
        int reply = JOptionPane.showConfirmDialog(null, "Bent u zeker dat U uw profiel wil verwijderen?", "Profiel verwijderen", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          //Verwijder de actieve klant zijn gegevens
          Klant actief = LoginKlant.getInstance().getActief();
          d.deleteKlant(actief);
          JOptionPane.showMessageDialog(null, "Uw profiel werd succesvol verwijderd");
          Start start = Start.getInstance(profiel);
            start.pack();
            start.setSize(580, 520);
            profiel.hide();
            start.show();
            start.setLocationRelativeTo(null);
        }
        else {//do nothing
        }
    }//GEN-LAST:event_naarAccountklantverwijderen

    private void naarOverzichtKortingscodesKlant(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naarOverzichtKortingscodesKlant
       Overzichtkortingscodesklant codesklant = Overzichtkortingscodesklant.getInstance(profiel);
//     codesklant.setSize(300,300);
       codesklant.pack();
       profiel.hide();
       codesklant.show();
       codesklant.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarOverzichtKortingscodesKlant

    private void naarOverzichtReviewsKlant(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naarOverzichtReviewsKlant
       
    }//GEN-LAST:event_naarOverzichtReviewsKlant

    private void naarZoekenCategorie(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarZoekenCategorie
    Zoekencategorie zoekenCategorie = Zoekencategorie.getInstance(profiel);
        //     anderegevensklant.setSize(300,300);
       zoekenCategorie.pack();
       profiel.hide();
       zoekenCategorie.show();
       zoekenCategorie.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarZoekenCategorie

    private void naarZoekenGemeente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarZoekenGemeente
       Zoekengemeente zoekenGemeente = Zoekengemeente.getInstance(profiel);
        //     anderegevensklant.setSize(300,300);
       zoekenGemeente.pack();
       profiel.hide();
       zoekenGemeente.show();
       zoekenGemeente.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_naarZoekenGemeente

    private void naarUitloggen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarUitloggen
          JOptionPane.showMessageDialog(null, "U bent nu uitgelogd.");
          Start start = Start.getInstance(profiel);
            start.pack();
            start.setSize(580, 520);
            profiel.hide();
            start.show();
            start.setLocationRelativeTo(null);
            login.setActief(null);
    }//GEN-LAST:event_naarUitloggen

    private void orderPlaatsen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderPlaatsen
        // TODO add your handling code here:
    }//GEN-LAST:event_orderPlaatsen

    private void naarZoekenProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarZoekenProduct
        Zoekenproduct zoekenProduct = Zoekenproduct.getInstance(profiel);
        //     anderegevensklant.setSize(300,300);
       zoekenProduct.pack();
       profiel.hide();
       zoekenProduct.show();
       zoekenProduct.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarZoekenProduct

    private void naarContact(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarContact
       Contact contact = Contact.getInstance(profiel);
        //     anderegevensklant.setSize(300,300);
       contact.pack();
       profiel.hide();
       contact.show();
       contact.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarContact

    private void naarOverzichtReviews(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarOverzichtReviews
        Overzichtreviewsklant reviewsklant = Overzichtreviewsklant.getInstance(profiel);
//     reviewsklant.setSize(300,300);
       reviewsklant.pack();
       profiel.hide();
       reviewsklant.show();
       reviewsklant.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarOverzichtReviews

    private void naarToevoegenReview(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarToevoegenReview
       ToevoegenReview toevoegenReview = ToevoegenReview.getInstance(profiel);
//     reviewsklant.setSize(300,300);
       toevoegenReview.pack();
       profiel.hide();
       toevoegenReview.show();
       toevoegenReview.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarToevoegenReview

    private void naarZoekenReview(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarZoekenReview
       ZoekenReview zoekenReview = ZoekenReview.getInstance(profiel);
//     reviewsklant.setSize(300,300);
       zoekenReview.pack();
       profiel.hide();
       zoekenReview.show();
       zoekenReview.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarZoekenReview

    private void naarZoekenTakeAway(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarZoekenTakeAway
       Zoekentakeaway zoekenTakeAway = Zoekentakeaway.getInstance(profiel);
//     reviewsklant.setSize(300,300);
       zoekenTakeAway.pack();
       profiel.hide();
       zoekenTakeAway.show();
       zoekenTakeAway.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarZoekenTakeAway

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
            java.util.logging.Logger.getLogger(Profielklant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profielklant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profielklant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profielklant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profielklant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu naarContact;
    // End of variables declaration//GEN-END:variables
}
