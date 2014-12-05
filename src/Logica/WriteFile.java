/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Database.Database;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author odkeyser,liedcost,mehillew
 */
public class WriteFile extends Exception {

    MailingClass mail = new MailingClass();
    Database d = new Database();

    /*public void awardsPerTakeaway(String maand, int jaar) {
     DatumFinder date = new DatumFinder();
     String datum = date.getStringFromDate();

     String path = System.getProperty("user.dir") + "\\rapporten\\";
     String naam = "Awards_" + maand + "_" + jaar;
     String extensie = ".doc";
     String bestandsnaam = path + naam + "_" + datum + extensie;

     this.writeFile(bestandsnaam, this.awardsBoodschap(maand, jaar));
     }

     private String awardsBoodschap(String maand, int jaar) {
     String tekst = "Ovezicht van de uitgereikte Awards van " + maand + " " + jaar + "\n\n";
     Database d = new Database();

     for (Award a : d.getAlleAwards()) {

     tekst += a.toString();
     }

     return tekst;
     }*/
    //Lopende orders
    public void lopendeOrdersPerTakeaway(String takeawayNaam) {
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Lopende orders_" + takeawayNaam;
        String extensie = ".doc";
        String bestandsnaam = path + naam + "_" + datum + extensie;

        this.writeFile(bestandsnaam, this.lopendeOrdersPerTakeawayBoodschap(takeawayNaam, datum));
    }

    private String lopendeOrdersPerTakeawayBoodschap(String takeawayNaam, String datum) {

        String tekst = "Lopende orders van " + takeawayNaam + " op " + datum + "\n\n";
        Database d = new Database();
        for (Vestiging v : d.getAlleVestigingen(takeawayNaam)) {
            tekst += v.toString();
            for (Menu m : d.getLopendeOrders(takeawayNaam, v.getVestigingsID())) {
                tekst += m.toString();
            }
        }
        return tekst;
    }

    public void lopendeOrdersPerVestiging(String takeawayNaam, String vestigingsNaam) {
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Lopende orders_" + takeawayNaam + "_" + vestigingsNaam;
        String extensie = ".doc";
        String bestandsnaam = path + naam + "_" + datum + extensie;

        this.writeFile(bestandsnaam, this.lopendeOrdersPerVestigingBoodschap(takeawayNaam, vestigingsNaam, datum));
    }

    private String lopendeOrdersPerVestigingBoodschap(String takeawaynaam, String vestigingsNaam, String datum) {
        String tekst = "Lopende orders van " + takeawaynaam + " - " + vestigingsNaam + " op " + datum + "\n\n";
        Database d = new Database();
        for (Menu m : d.getLopendeOrders(takeawaynaam, vestigingsNaam)) {
            tekst += m.toString();
        }
        return tekst;
    }

    //Verkopen
    public void verkopenPerTakeaway(String takeawayNaam) {
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Verkopen_" + takeawayNaam;
        String extensie = ".doc";
        String bestandsnaam = path + naam + "_" + datum + extensie;

        this.writeFile(bestandsnaam, this.verkopenPerTakeawayBoodschap(takeawayNaam, datum));
    }

    private String verkopenPerTakeawayBoodschap(String takeawayNaam, String datum) {

        String tekst = "Verkopen van " + takeawayNaam + " op " + datum + "\n\n";
        Database d = new Database();
        for (Vestiging v : d.getAlleVestigingen(takeawayNaam)) {
            tekst += v.toString();
            for (Menu m : d.getVerkopen(takeawayNaam, v.getVestigingsID())) {
                tekst += m.toString();
            }
        }
        return tekst;
    }

    public void verkopenPerVestiging(String takeawayNaam, String vestigingsNaam) {
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Verkopen_" + takeawayNaam + "_" + vestigingsNaam;
        String extensie = ".doc";
        String bestandsnaam = path + naam + "_" + datum + extensie;

        this.writeFile(bestandsnaam, this.verkopenPerVestigingBoodschap(takeawayNaam, vestigingsNaam, datum));
    }

    private String verkopenPerVestigingBoodschap(String takeawaynaam, String vestigingsNaam, String datum) {
        String tekst = "Verkopen van " + takeawaynaam + " - " + vestigingsNaam + " op " + datum + "\n\n";
        Database d = new Database();
        for (Menu m : d.getVerkopen(takeawaynaam, vestigingsNaam)) {
            tekst += m.toString();
        }
        return tekst;
    }

    //kortingscodes
    public void kortingscodesPerTakeaway(String takeawayNaam) {
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Kortingscodes_" + takeawayNaam;
        String extensie = ".doc";
        String bestandsnaam = path + naam + "_" + datum + extensie;

        this.writeFile(bestandsnaam, this.kortingscodesPerTakeawayBoodschap(takeawayNaam, datum));
    }

    private String kortingscodesPerTakeawayBoodschap(String takeawayNaam, String datum) {
        String tekst = "Kortingscodes van " + takeawayNaam + " die nog geldig zijn op " + datum + "\n\n";
        Database d = new Database();
        for (Vestiging v : d.getAlleVestigingen(takeawayNaam)) {
            tekst += v.toString();
            for (Korting k : d.rapportKortingSpecifiek(takeawayNaam, v.getVestigingsID())) {
                tekst += k.toString();
            }
        }
        return tekst;
    }

    public void kortingscodesPerVestiging(String takeawayNaam, String vestigingsNaam) {
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Kortingscodes " + takeawayNaam + vestigingsNaam;
        String extensie = ".doc";
        String bestandsnaam = path + naam + "_" + datum + extensie;

        this.writeFile(bestandsnaam, this.kortingscodesPerVestigingBoodschap(takeawayNaam, vestigingsNaam, datum));
    }

    private String kortingscodesPerVestigingBoodschap(String takeawaynaam, String vestigingsNaam, String datum) {
        String tekst = "Kortingscodes van " + takeawaynaam + " - " + vestigingsNaam + " op " + datum + "\n\n";
        Database d = new Database();
        for (Korting k : d.rapportKortingSpecifiek(takeawaynaam, vestigingsNaam)) {
            tekst += k.toString();
        }
        return tekst;
    }
    /*
     //menu
     public void menukaartPerTakeaway(String takeawayNaam) {
     DatumFinder date = new DatumFinder();
     String datum = date.getStringFromDate();

     String path = System.getProperty("user.dir") + "\\rapporten\\";
     String naam = "Menu_" + takeawayNaam;
     String extensie = ".doc";
     String bestandsnaam = path + naam + "_" + datum + extensie;

     this.writeFile(bestandsnaam, this.menukaartPerTakeawayBoodschap(takeawayNaam));
     }

     private String menukaartPerTakeawayBoodschap(String takeawayNaam) {
     String tekst = "Menukaart " + takeawayNaam;
     Database d = new Database();
     for (Product p : d.getProductsOfTakeaway(takeawayNaam)) {
     tekst += p.toString();
     }
     return tekst;
     }
     */

    public void writeFile(String file, String msg) {

        PrintWriter outFile = null;
        try {
            System.out.print("Opening file...");
            outFile = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            System.out.println("Succeeded");
        } catch (IOException io) {
            System.out.println("failed (" + io.toString() + ")");

        }

        try {
            System.out.print("Writing file...");
            outFile.println(msg);
            System.out.println("Succeeded");
        } catch (Exception e) {
            System.out.println("failed (" + e.toString() + ")");
        }

        try {
            System.out.print("Closing file...");
            outFile.flush();
            outFile.close();
            System.out.println("Succeeded");
        } catch (NullPointerException np) {
            System.out.println("failed: no file to close (" + np.toString() + ")");
        } catch (Exception e) {
            System.out.println("failed (" + e.toString() + ")");
        }

    }

    //AWARDS
    //deze methode moet opgeroepen worden net na het berekenen van de awars
    public void pdfAwards(String maand, int jaar) {
        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Awards_" + maand + "_" + jaar;
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;
        String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak, ook nog een eindaftiteling)
        /*String hoofd = "Ovezicht van de uitgereikte Awards van " + maand + " " + jaar + "\n\n";
         String tekst = "";
         for (Award a : d.getAlleAwards()) {
         tekst += a.toString();
         }*/
        String aftiteling1 = "Het team van Just-Feed\n";
        String aftiteling2
                = "        De Coster Lieselotte\n"
                + "        De Kerpel Laura\n"
                + "        De Keyser Olivier\n"
                + "        Hillewaere Menno\n"
                + "        Pittoors Kimberley\n"
                + "        Van der Poten Kelly\n";
        String aftiteling3 = "Project Beleidsinformatica, Prof. dr. Geert Poels, Begeleider Jan Claes";

        Anchor anchor = new Anchor("justfeedgroep01@gmail.com", FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY));
        anchor.setReference("mailto: justfeedgroep01@gmail.com");

        //aanmaken van de image (logo)
        Image image = null;
        try {
            image = Image.getInstance(imagepath);
        } catch (BadElementException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        // aanmaken van heading
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell= new PdfPCell(new Paragraph("Overzicht van een bepaalde takeaway", FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);
        //openen van documenten, toevoegen van tekst en sluiten van document
        try {
            Document doc = new Document(PageSize.A4);
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(bestandsnaam));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();
            try {
                //doc.add(new Paragraph(hoofd, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.ORANGE)));
                doc.add(table);
                doc.add(new Paragraph("Overzicht van een bepaalde takeaway", FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.ORANGE)));
                doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.ORANGE)));
                //doc.add(new Paragraph(tekst, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                doc.add(new Paragraph("testje voor Mennofdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddfhhhhhhhhhhhhhhhhh\n", FontFactory.getFont(FontFactory.HELVETICA, 12)));
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                //deze uit commentaar halen als we een link willen om te mailen
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        /*for (Take_Away ta : d.getAlleTakeaways()) {
         mail.sendAwardemail(ta.getEmail(), pdfVoorMail);
         }*/
    }

    //MENUKAART
    public void pdfMenukaartVanTakeaway(String takeawayNaam) {
        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Menu_" + takeawayNaam;
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
        String hoofd = "Ovezicht van de producten aangeboden door " + takeawayNaam + "\n\n";
        String tekst = "";

        for (Product p : d.getProductsOfTakeaway(takeawayNaam)) {
            tekst += p.toString();
        }
        //openen van documenten, toevoegen van tekst en sluiten van document
        try {
            Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(bestandsnaam));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();
            try {
                doc.add(new Paragraph(hoofd, FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD, BaseColor.ORANGE)));
                doc.add(new Paragraph(tekst, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12)));
                //doc.add(new Paragraph("Lieselot aka Lotje69*BLING*BLING*", FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.ORANGE)));
                //doc.add(new Paragraph("testje voor Menno",FontFactory.getFont(FontFactory.TIMES_ROMAN,12)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        mail.sendMenukaartmail(d.getTakeaway(takeawayNaam).getEmail(), pdfVoorMail);
    }

}
