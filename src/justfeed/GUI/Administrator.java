/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package justfeed.GUI;

import justfeed.GUI.Start;
import java.text.Normalizer.Form;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author UGent
 */
public class Administrator extends javax.swing.JFrame {

    private static final Administrator admini = new Administrator();
    public static JFrame myCaller;
    
    public Administrator() {
        initComponents();
    }
    public static Administrator getInstance()
    {
        return admini;
    }
    public static Administrator getInstance(Loginadministrator caller)
    {
        myCaller = caller;
        return admini;   
    }
    public static Administrator getInstance(AanmaakMaandelijkseKorting aanmaakKorting)
    {
        myCaller = aanmaakKorting;
        return admini;   
    }
    public static Administrator getInstance(AanmaakAward aanmaakAward)
    {
        myCaller = aanmaakAward;
        return admini;   
    }
    public static Administrator getInstance(Aanmaaknieuwevestiging aanmaakVestiging)
    {
        myCaller = aanmaakVestiging;
        return admini;   
    }
    public static Administrator getInstance(AanmaakNieuwProduct aanmaakProduct)
    {
        myCaller = aanmaakProduct;
        return admini;   
    }
    public static Administrator getInstance(AanmaakEenmaligeUniekeActie uniekeActie)
    {
        myCaller = uniekeActie;
        return admini;   
    }
    public static Administrator getInstance(AanmaakPeriodiekeUniekeActie periodiekeActie)
    {
        myCaller = periodiekeActie;
        return admini;   
    }
    public static Administrator getInstance(AanmaaknieuweTakeaway takeaway)
    {
        myCaller = takeaway;
        return admini;   
    }
    public static Administrator getInstance(AanpassenProduct aangepastproduct)
    {
        myCaller = aangepastproduct;
        return admini;   
    }
    public static Administrator getInstance(Aanpassenvestiging aangepastevestiging)
    {
        myCaller = aangepastevestiging;
        return admini;   
    }
    public static Administrator getInstance(Overzichtawardsadministrator awards)
    {
        myCaller = awards;
        return admini;   
    }
    public static Administrator getInstance(Overzichtkortingscodesadministrator kortingscode)
    {
        myCaller = kortingscode;
        return admini;   
    }
        public static Administrator getInstance(VerwijderenVanProduct verwijderenVanProduct)
    {
        myCaller = verwijderenVanProduct;
        return admini;   
    }
       public static Administrator getInstance(VerwijderenTakeAway verwijderenTakeAway)
    {
        myCaller = verwijderenTakeAway;
        return admini;   
    }
       public static Administrator getInstance(VerwijderenVestiging verwijderenVestiging)
    {
        myCaller = verwijderenVestiging;
        return admini;   
    }
      public static Administrator getInstance(Commissieberekening commissieberekening)
    {
        myCaller = commissieberekening;
        return admini;   
    }
      public static Administrator getInstance(OntvangstLeveringsbevestiging ontvangstLeveringsbevestiging)
    {
        myCaller = ontvangstLeveringsbevestiging;
        return admini;   
    }
      public static Administrator getInstance(RapportFlyer rapportFlyer)
    {
        myCaller = rapportFlyer;
        return admini;   
    }
         public static Administrator getInstance(RapportStandVanZaken rapportSVZ)
    {
        myCaller = rapportSVZ;
        return admini;   
    }
    
//    public static Administrator getInstance(VerwijderenProduct verwijderenProduct)
//    {
//        myCaller = verwijderenProduct;
//        return admini;   
//    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        nrAanpassenVestiging = new javax.swing.JMenuItem();
        btnNaarAanpassenProduct = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnNaarVerwijderenTakeaway = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        btnNaarAanmaakAward = new javax.swing.JMenuItem();
        naarAwardsAdministrator = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        EenmaligeUniekeActieAanmaken = new javax.swing.JMenuItem();
        PeriodiekeActieAanmaken = new javax.swing.JMenuItem();
        MaandelijkseActieAanmaken = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Welkom!");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log uit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 0));

        jMenu3.setBackground(new java.awt.Color(255, 153, 0));
        jMenu3.setText("Toevoegen");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/newvest.png"))); // NOI18N
        jMenuItem1.setText("Takeaway");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/newvest2.png"))); // NOI18N
        jMenuItem2.setText("Vestiging");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jMenuItem3.setText("Product bij een takeaway");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(255, 153, 0));
        jMenu4.setText("Wijzigen");

        nrAanpassenVestiging.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/aanpasplus.png"))); // NOI18N
        nrAanpassenVestiging.setText("Vestiging");
        nrAanpassenVestiging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nrAanpassenVestigingActionPerformed(evt);
            }
        });
        jMenu4.add(nrAanpassenVestiging);

        btnNaarAanpassenProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/aanpasplus.png"))); // NOI18N
        btnNaarAanpassenProduct.setText("Product bij een takeaway");
        btnNaarAanpassenProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaarAanpassenProductActionPerformed(evt);
            }
        });
        jMenu4.add(btnNaarAanpassenProduct);

        jMenuBar1.add(jMenu4);

        jMenu1.setBackground(new java.awt.Color(255, 153, 0));
        jMenu1.setText("Verwijderen");

        btnNaarVerwijderenTakeaway.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/deletetakeway.png"))); // NOI18N
        btnNaarVerwijderenTakeaway.setText("Take-away");
        btnNaarVerwijderenTakeaway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarVerwijderenTakeAway(evt);
            }
        });
        jMenu1.add(btnNaarVerwijderenTakeaway);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/deletevest.png"))); // NOI18N
        jMenuItem10.setText("Vestiging");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarVerwijderenVestiging(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem8.setText("Product");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarVerwijderenProduct(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu6.setBackground(new java.awt.Color(255, 153, 0));
        jMenu6.setText("Awards");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naarAwardsAdministrator(evt);
            }
        });

        btnNaarAanmaakAward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/aanmaakawards.png"))); // NOI18N
        btnNaarAanmaakAward.setText("Award aanmaken");
        btnNaarAanmaakAward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaarAanmaakAwardActionPerformed(evt);
            }
        });
        jMenu6.add(btnNaarAanmaakAward);

        naarAwardsAdministrator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/overzichtawards.png"))); // NOI18N
        naarAwardsAdministrator.setText("Overzicht awards");
        naarAwardsAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarAwardsAdministratorActionPerformed(evt);
            }
        });
        jMenu6.add(naarAwardsAdministrator);

        jMenuBar1.add(jMenu6);

        jMenu5.setBackground(new java.awt.Color(255, 153, 0));
        jMenu5.setText("Kortingen");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naarKortingscodesAdministrator(evt);
            }
        });

        EenmaligeUniekeActieAanmaken.setText("Eenmalige unieke actie aanmaken");
        EenmaligeUniekeActieAanmaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EenmaligeUniekeActieAanmakenActionPerformed(evt);
            }
        });
        jMenu5.add(EenmaligeUniekeActieAanmaken);

        PeriodiekeActieAanmaken.setText("Periodieke unieke actie aanmaken");
        PeriodiekeActieAanmaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeriodiekeActieAanmakenActionPerformed(evt);
            }
        });
        jMenu5.add(PeriodiekeActieAanmaken);

        MaandelijkseActieAanmaken.setText("Maandelijkse acties aanmaken");
        MaandelijkseActieAanmaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaandelijkseActieAanmakenActionPerformed(evt);
            }
        });
        jMenu5.add(MaandelijkseActieAanmaken);

        jMenuItem6.setText("Overzicht kortingscodes");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarOverzichtKortingscodes(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuBar1.add(jMenu5);

        jMenu7.setBackground(new java.awt.Color(255, 153, 0));
        jMenu7.setText("Rapporten");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menus.png"))); // NOI18N
        jMenuItem7.setText("Flyers maken");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarRapportFlyer(evt);
            }
        });
        jMenu7.add(jMenuItem7);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rapporten.png"))); // NOI18N
        jMenuItem9.setText("Stand van zaken");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarRapportStandVanZaken(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenuBar1.add(jMenu7);

        jMenu2.setBackground(new java.awt.Color(255, 153, 0));
        jMenu2.setText("Order");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/levbev.png"))); // NOI18N
        jMenuItem11.setText("Ontvangst leveringsbevestiging");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarOntvangstLeveringsbevestiging(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        jMenu8.setBackground(new java.awt.Color(255, 153, 0));
        jMenu8.setText("Commissie");

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/commissie.png"))); // NOI18N
        jMenuItem12.setText("Commissieberekening");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naarCommissieBerekening(evt);
            }
        });
        jMenu8.add(jMenuItem12);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       AanmaaknieuweTakeaway takeaway = AanmaaknieuweTakeaway.getInstance(admini);
//       takeaway.setSize(300,300);
       takeaway.pack();
       admini.hide();
//       myCaller.show();
       takeaway.show();
       takeaway.setLocationRelativeTo(null);
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       Aanmaaknieuwevestiging vestiging = Aanmaaknieuwevestiging.getInstance(admini);
//       vestiging.setSize(300,300);
       vestiging.pack();
       admini.hide();
       vestiging.show();
       vestiging.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       AanmaakNieuwProduct gerecht = AanmaakNieuwProduct.getInstance(admini);
//       gerecht.setSize(300,300);
       gerecht.pack();
       admini.hide();
       gerecht.show();
       gerecht.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void nrAanpassenVestigingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nrAanpassenVestigingActionPerformed
       Aanpassenvestiging anderevestiging  = Aanpassenvestiging.getInstance(admini);
//       anderevestiging.setSize(300,300);
       anderevestiging.pack();
       admini.hide();
       anderevestiging.show();
       anderevestiging.setLocationRelativeTo(null);
    }//GEN-LAST:event_nrAanpassenVestigingActionPerformed

    private void btnNaarAanpassenProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaarAanpassenProductActionPerformed
       AanpassenProduct andergerecht  = AanpassenProduct.getInstance(admini);
//       andergerecht.setSize(300,300);
       andergerecht.pack();
       admini.hide();
       andergerecht.show();
       andergerecht.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnNaarAanpassenProductActionPerformed

    private void naarKortingscodesAdministrator(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naarKortingscodesAdministrator
      
    }//GEN-LAST:event_naarKortingscodesAdministrator

    private void naarAwardsAdministrator(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naarAwardsAdministrator
//       Awardsadministrator awards  = Awardsadministrator.getInstance(admini);
////       awards.setSize(300,300);
////       awards.pack();
////       admini.hide();
//       awards.show();
//       awards.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarAwardsAdministrator

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "U bent nu uitgelogd.");
          Start start = Start.getInstance(admini);
            start.pack();
            start.setSize(580, 520);
           admini.hide();
            start.show();
            start.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EenmaligeUniekeActieAanmakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EenmaligeUniekeActieAanmakenActionPerformed
        AanmaakEenmaligeUniekeActie eenmaligeuniekeactiecode = AanmaakEenmaligeUniekeActie.getInstance(admini);
        eenmaligeuniekeactiecode.pack();
        admini.hide();
        eenmaligeuniekeactiecode.show();
        eenmaligeuniekeactiecode.setLocationRelativeTo(null);
    }//GEN-LAST:event_EenmaligeUniekeActieAanmakenActionPerformed

    private void PeriodiekeActieAanmakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeriodiekeActieAanmakenActionPerformed
        AanmaakPeriodiekeUniekeActie periodiekeuniekeactiecode = AanmaakPeriodiekeUniekeActie.getInstance(admini);
        periodiekeuniekeactiecode.pack();
        admini.hide();
        periodiekeuniekeactiecode.show();
        periodiekeuniekeactiecode.setLocationRelativeTo(null);
    }//GEN-LAST:event_PeriodiekeActieAanmakenActionPerformed

    private void MaandelijkseActieAanmakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaandelijkseActieAanmakenActionPerformed
       AanmaakMaandelijkseKorting aanmaakMaandelijkseKorting  = AanmaakMaandelijkseKorting.getInstance(admini);
//     aanmaakAward.setSize(300,300);
       aanmaakMaandelijkseKorting.pack();
       admini.hide();
       aanmaakMaandelijkseKorting.show();
       aanmaakMaandelijkseKorting.setLocationRelativeTo(null);
    }//GEN-LAST:event_MaandelijkseActieAanmakenActionPerformed

    private void btnNaarAanmaakAwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaarAanmaakAwardActionPerformed
       AanmaakAward aanmaakAward  = AanmaakAward.getInstance(admini);
//     aanmaakAward.setSize(300,300);
       aanmaakAward.pack();
       admini.hide();
       aanmaakAward.show();
       aanmaakAward.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnNaarAanmaakAwardActionPerformed

    private void naarAwardsAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarAwardsAdministratorActionPerformed
       Overzichtawardsadministrator awardsAdmini  = Overzichtawardsadministrator.getInstance(admini);
//     awardsAdmini.setSize(300,300);
       awardsAdmini.pack();
       admini.hide();
       awardsAdmini.show();
       awardsAdmini.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarAwardsAdministratorActionPerformed

    private void naarVerwijderenTakeAway(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarVerwijderenTakeAway
        VerwijderenTakeAway verwijderenTakeAway = VerwijderenTakeAway.getInstance(admini);
        verwijderenTakeAway.pack();
        admini.hide();
        verwijderenTakeAway.show();
        verwijderenTakeAway.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarVerwijderenTakeAway

    private void naarVerwijderenVestiging(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarVerwijderenVestiging
        VerwijderenVestiging verwijderenVestiging = VerwijderenVestiging.getInstance(admini);
        verwijderenVestiging.pack();
        admini.hide();
        verwijderenVestiging.show();
        verwijderenVestiging.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarVerwijderenVestiging

    private void naarVerwijderenProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarVerwijderenProduct
        VerwijderenVanProduct verwijderenVanProduct = VerwijderenVanProduct.getInstance(admini);
        verwijderenVanProduct.pack();
        admini.hide();
        verwijderenVanProduct.show();
        verwijderenVanProduct.setLocationRelativeTo(null);      
    }//GEN-LAST:event_naarVerwijderenProduct

    private void naarOverzichtKortingscodes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarOverzichtKortingscodes
        Overzichtkortingscodesadministrator korting  = Overzichtkortingscodesadministrator.getInstance(admini);
//       korting.setSize(300,300);
       korting.pack();
       admini.hide();
       korting.show();
       korting.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarOverzichtKortingscodes

    private void naarRapportStandVanZaken(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarRapportStandVanZaken
        RapportStandVanZaken rapportSVZ  = RapportStandVanZaken.getInstance(admini);
       rapportSVZ.pack();
        admini.hide();
        rapportSVZ.show();
        rapportSVZ.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarRapportStandVanZaken

    private void naarRapportFlyer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarRapportFlyer
        RapportFlyer rapportFlyer  = RapportFlyer.getInstance(admini);
        rapportFlyer.pack();
        admini.hide();
        rapportFlyer.show();
        rapportFlyer.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarRapportFlyer

    private void naarCommissieBerekening(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarCommissieBerekening
        Commissieberekening commissieberekening = Commissieberekening.getInstance(admini);
        commissieberekening.pack();
        admini.hide();
        commissieberekening.show();
        commissieberekening.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarCommissieBerekening

    private void naarOntvangstLeveringsbevestiging(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naarOntvangstLeveringsbevestiging
        OntvangstLeveringsbevestiging ontvangstleveringsbevestiging = OntvangstLeveringsbevestiging.getInstance(admini);
        ontvangstleveringsbevestiging.pack();
        admini.hide();
        ontvangstleveringsbevestiging.show();
        ontvangstleveringsbevestiging.setLocationRelativeTo(null);
    }//GEN-LAST:event_naarOntvangstLeveringsbevestiging
   
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
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EenmaligeUniekeActieAanmaken;
    private javax.swing.JMenuItem MaandelijkseActieAanmaken;
    private javax.swing.JMenuItem PeriodiekeActieAanmaken;
    private javax.swing.JMenuItem btnNaarAanmaakAward;
    private javax.swing.JMenuItem btnNaarAanpassenProduct;
    private javax.swing.JMenuItem btnNaarVerwijderenTakeaway;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem naarAwardsAdministrator;
    private javax.swing.JMenuItem nrAanpassenVestiging;
    // End of variables declaration//GEN-END:variables
}
