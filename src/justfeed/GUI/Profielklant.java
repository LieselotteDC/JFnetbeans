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
    public String loginnaam = LoginKlant.getInstance().getLoginnaam(); // voor wat is deze? (oli)
    public String naamKlant = LoginKlant.getInstance().actief.getVoornaam();//ik weet niet als deze klopt, ik heb hem bij mousemoved gebruikt
    public Klant actief = LoginKlant.getInstance().getActief();
    public Klant k = LoginKlant.getInstance().getK();

    public Profielklant() {
        initComponents();
        lblLogin.setText(actief.getVoornaam()+"!");
    }

    public static Profielklant getInstance(LoginKlant caller) {
        myCaller = caller;
        return profiel;
    }

    public static Profielklant getInstance(Contact caller) {
        myCaller = caller;
        return profiel;
    }

    public static Profielklant getInstance(RegistratieKlant caller) {
        myCaller = caller;
        return profiel;
    }

    public static Profielklant getInstance(ZoekenReview zoekenReview) {
        myCaller = zoekenReview;
        return profiel;
    }

    public static Profielklant getInstance(Zoekencategorie zoekenCategorie) {
        myCaller = zoekenCategorie;
        return profiel;
    }

    public static Profielklant getInstance(Zoekengemeente zoekenGemeente) {
        myCaller = zoekenGemeente;
        return profiel;
    }

    public static Profielklant getInstance(Zoekentakeaway zoekenTakeaway) {
        myCaller = zoekenTakeaway;
        return profiel;
    }

    public static Profielklant getInstance(Zoekenproduct zoekenProduct) {
        myCaller = zoekenProduct;
        return profiel;
    }

    public static Profielklant getInstance(Overzichtkortingscodesklant codesklant) {
        myCaller = codesklant;
        return profiel;
    }

    public static Profielklant getInstance(Overzichtreviewsklant reviewsklant) {
        myCaller = reviewsklant;
        return profiel;
    }

    public static Profielklant getInstance(BestellingBevestiging bevestiging) {
        myCaller = bevestiging;
        return profiel;
    }

    public static Profielklant getInstance(BestellingFactuur factuur) {
        myCaller = factuur;
        return profiel;
    }

    public static Profielklant getInstance(ReviewBestaandOvernemen schrijvenReview) {
        myCaller = schrijvenReview;
        return profiel;
    }

    public static Profielklant getInstance(ReviewNieuwToevoegen toevoegenReview) {
        myCaller = toevoegenReview;
        return profiel;
    }

    public static Profielklant getInstance(AanmaakNieuwProduct nieuwproduct) {
        myCaller = nieuwproduct;
        return profiel;
    }

    public static Profielklant getInstance(OverzichtTakeAwaysReedsBesteld ontvangenTakeAwaysReedsBesteld) {
        myCaller = ontvangenTakeAwaysReedsBesteld;
        return profiel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblKlant = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuItemBestelling = new javax.swing.JMenuItem();
        naarOverzichtTakeAwaysReedsBesteld = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        naarReviewBestaandOvernemen = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        naarCategorie = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        naarContact = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Welkom op jouw profiel,");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log uit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarUitloggen(evt);
            }
        });

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsz_logo.png"))); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

        jMenu2.setBackground(new java.awt.Color(255, 153, 0));
        jMenu2.setText("Aanpassen");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wrench.png"))); // NOI18N
        jMenuItem2.setText("Gegevens");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarAanpassenklantgegevens(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/verwijderen.png"))); // NOI18N
        jMenuItem3.setText("Account verwijderen");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarAccountklantverwijderen(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu1.setBackground(new java.awt.Color(255, 153, 0));
        jMenu1.setText("Order");

        menuItemBestelling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shoppingbasket.png"))); // NOI18N
        menuItemBestelling.setText("Plaats een bestelling");
        menuItemBestelling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarBestelling(evt);
            }
        });
        jMenu1.add(menuItemBestelling);

        naarOverzichtTakeAwaysReedsBesteld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tables.png"))); // NOI18N
        naarOverzichtTakeAwaysReedsBesteld.setText("Overzicht takeaways waarbij u reeds besteld heeft");
        naarOverzichtTakeAwaysReedsBesteld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarOverzichtTakeAwaysReedsBesteldActionPerformed(evt);
            }
        });
        jMenu1.add(naarOverzichtTakeAwaysReedsBesteld);

        jMenuBar1.add(jMenu1);

        jMenu3.setBackground(new java.awt.Color(255, 153, 0));
        jMenu3.setText("Kortingscodes");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naarOverzichtKortingscodesKlant(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(255, 153, 0));
        jMenu4.setText("Reviews");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naarOverzichtReviewsKlant(evt);
            }
        });

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoekrev.png"))); // NOI18N
        jMenuItem11.setText("Zoek reviews van bepaald product");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekenReview(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addreview.png"))); // NOI18N
        jMenuItem10.setText("Voeg nieuwe review toe");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarToevoegenReview(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        naarReviewBestaandOvernemen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/overzichtreviews.png"))); // NOI18N
        naarReviewBestaandOvernemen.setText("Neem bestaande review over");
        naarReviewBestaandOvernemen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarReviewBestaandOvernemenActionPerformed(evt);
            }
        });
        jMenu4.add(naarReviewBestaandOvernemen);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/listreviews.png"))); // NOI18N
        jMenuItem9.setText("Overzicht van uw geschreven reviews");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarOverzichtReviews(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(255, 153, 0));
        jMenu5.setText("Zoeken");

        naarCategorie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoekcat.png"))); // NOI18N
        naarCategorie.setText("Categorie");
        naarCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarCategorieActionPerformed(evt);
            }
        });
        jMenu5.add(naarCategorie);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoekprod.png"))); // NOI18N
        jMenuItem5.setText("Product");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekenProduct(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoektakeaway.png"))); // NOI18N
        jMenuItem6.setText("Takeaway");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekenTakeAway(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoekengemeente3.png"))); // NOI18N
        jMenuItem7.setText("Gemeente");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarZoekenGemeente(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        naarContact.setBackground(new java.awt.Color(255, 153, 0));
        naarContact.setText("Contact");
        naarContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarContact(evt);
            }
        });

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mail.png"))); // NOI18N
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
                .addGap(169, 169, 169)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKlant, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(lblKlant, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            System.exit(0);
        } else {//do nothing
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
        System.exit(0);
 
    }//GEN-LAST:event_naarUitloggen

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
        ReviewNieuwToevoegen reviewToevoegen = ReviewNieuwToevoegen.getInstance(profiel);
//     reviewsklant.setSize(300,300);
        reviewToevoegen.pack();
        profiel.hide();
        reviewToevoegen.show();
        reviewToevoegen.setLocationRelativeTo(null);
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

    private void naarCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarCategorieActionPerformed
        Zoekencategorie zoekencategorie = Zoekencategorie.getInstance(profiel);
        zoekencategorie.pack();
        profiel.hide();
        zoekencategorie.show();
        zoekencategorie.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarCategorieActionPerformed

    private void naarReviewBestaandOvernemenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarReviewBestaandOvernemenActionPerformed
        ReviewBestaandOvernemen reviewOvernemen = ReviewBestaandOvernemen.getInstance(profiel);
//     reviewsklant.setSize(300,300);
        reviewOvernemen.pack();
        profiel.hide();
        reviewOvernemen.show();
        reviewOvernemen.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarReviewBestaandOvernemenActionPerformed

    private void naarOverzichtTakeAwaysReedsBesteldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarOverzichtTakeAwaysReedsBesteldActionPerformed
        OverzichtTakeAwaysReedsBesteld ontvangenTakeAwaysReedsBesteld = OverzichtTakeAwaysReedsBesteld.getInstance(profiel);
//     reviewsklant.setSize(300,300);
        ontvangenTakeAwaysReedsBesteld.pack();
        profiel.hide();
        ontvangenTakeAwaysReedsBesteld.show();
        ontvangenTakeAwaysReedsBesteld.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarOverzichtTakeAwaysReedsBesteldActionPerformed

    private void naarBestelling(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarBestelling
        Bestelling bestelling = Bestelling.getInstance(profiel);
        bestelling.pack();
        profiel.hide();
        bestelling.show();
        bestelling.setLocationRelativeTo(null);
        login.setActief(null);
    }//GEN-LAST:event_naarBestelling

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
            java.util.logging.Logger.getLogger(Profielklant.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profielklant.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profielklant.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profielklant.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblKlant;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JMenuItem menuItemBestelling;
    private javax.swing.JMenuItem naarCategorie;
    private javax.swing.JMenu naarContact;
    private javax.swing.JMenuItem naarOverzichtTakeAwaysReedsBesteld;
    private javax.swing.JMenuItem naarReviewBestaandOvernemen;
    // End of variables declaration//GEN-END:variables
}
