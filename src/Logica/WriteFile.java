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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author odkeyser,liedcost,mehillew
 */
public class WriteFile extends Exception {

    MailingClass mail = new MailingClass();
    Database d = new Database();

    // checken of dingen leeg zijn of niet?
    // nog die rapporten en awards oproepen
    //AWARDS
    //deze methode moet opgeroepen worden net na het berekenen van de awards, mail wordt automatisch verzonden naar alle takeaways
    //MENNO: heb ik gedaan aanmakenawards na de joption pane 
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
        String titel = "Ovezicht van de uitgereikte Awards van " + maand + " " + jaar + "\n\n";
        String tekst = "";
        for (Award a : d.getAlleAwards()) {
            if (a == null) {

            } else {
                tekst += a.toString();
            }
        }
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

        // aanmaken van heading in kader
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);

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
                doc.add(table);
                doc.add(new Paragraph(tekst, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                doc.newPage();
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        for (Take_Away ta : d.getAlleTakeaways()) {
            mail.sendAwardemail(ta.getNaam(), pdfVoorMail);
        }
    }

    //MENUKAART
    //deze methode moet worden opgeroepen bij het aanvragen van een flyer, mail wordt automatisch verzonden naar betreffende takeaway
    public void pdfMenukaartVanTakeaway(String takeawayNaam) {
        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Menu_" + takeawayNaam;
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;
        String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
        String titel = "Ovezicht van de producten aangeboden door " + takeawayNaam + "\n\n";
        String tekst = "";
        if (d.getProductsOfTakeaway(takeawayNaam).isEmpty()) {
            tekst = "U heeft nog geen producten toegevoegd!";
        } else {
            for (Product p : d.getProductsOfTakeaway(takeawayNaam)) {
                tekst += p.toString();
            }
        }
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

        // aanmaken van heading in kader
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);

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
                doc.add(table);
                doc.add(new Paragraph(tekst, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                doc.newPage();
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        mail.sendMenukaartmail(takeawayNaam, pdfVoorMail);
    }

    //KORTINGSCODES
    //deze methode moet worden opgeroepen bij het aanvragen van het overzicht, mail wordt automatisch naar betreffende takeaway verzonden
    public void pdfKortingscodesTakeawayAlgemeen(String takeawayNaam) {
        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Kortingscodes_" + takeawayNaam;
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;
        String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
        String titel = "Lopende unieke actie kortingscodes van " + takeawayNaam + " die nog geldig zijn op " + datum + "\n\n";
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

        // aanmaken van heading in kader
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);

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
                doc.add(table);

                for (Vestiging v : d.getAlleVestigingen(takeawayNaam)) {
                    String gegevensVestiging = v.toString();
                    doc.add(new Paragraph(gegevensVestiging, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                    String lopendeKortingscodes = "";
                    for (Korting k : d.rapportKortingSpecifiek(takeawayNaam, v.getVestigingsID())) {
                        lopendeKortingscodes += k.toString();
                    }
                    doc.add(new Paragraph(lopendeKortingscodes, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                }
                doc.newPage();
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        mail.sendLopendeUniekeKortingscodesmail(takeawayNaam, pdfVoorMail);
    }

    public void pdfKortingscodesTakeawayVestiging(String takeawayNaam, String vestigingsNaam) {
        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Kortingscodes_" + takeawayNaam + "_" + vestigingsNaam;
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;
        String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
        String titel = "Lopende unieke actie kortingscodes van " + takeawayNaam + " - " + vestigingsNaam + " die nog geldig zijn op " + datum + "\n\n";
        String tekst = "";
        for (Korting k : d.rapportKortingSpecifiek(takeawayNaam, vestigingsNaam)) {
            tekst += k.toString();
        }
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

        // aanmaken van heading in kader
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);

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
                doc.add(table);
                doc.add(new Paragraph(tekst, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                doc.newPage();
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        mail.sendLopendeUniekeKortingscodesmail(takeawayNaam, pdfVoorMail);
    }

    //LOPENDE ORDERS
    //deze methode moet worden opgeroepen bij het aanvragen van het overzicht, mail wordt automatisch naar betreffende takeaway verzonden
    public void pdfLopendeOrdersTakeawayAlgemeen(String takeawayNaam) {
        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "LopendeOrders_" + takeawayNaam;
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;
        String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
        String titel = "Lopende orders van " + takeawayNaam + " op " + datum + "\n\n";
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

        // aanmaken van heading in kader
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);

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
                doc.add(table);

                for (Vestiging v : d.getAlleVestigingen(takeawayNaam)) {
                    String gegevensVestiging = v.toString();
                    doc.add(new Paragraph(gegevensVestiging, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                    String lopendeOrders = "";
                    for (Menu m : d.getLopendeOrders(takeawayNaam, v.getVestigingsID())) {
                        lopendeOrders += m.toString();
                    }
                    doc.add(new Paragraph(lopendeOrders, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                }
                doc.newPage();
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        mail.sendLopendeOrdersmail(takeawayNaam, pdfVoorMail);
    }

    public void pdfLopendeOrdersTakeawayVestiging(String takeawayNaam, String vestigingsNaam) {
        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "LopendeOrders_" + takeawayNaam + "_" + vestigingsNaam;
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;
        String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
        String titel = "Lopende orders van " + takeawayNaam + " - " + vestigingsNaam + " op " + datum + "\n\n";
        String tekst = "";
        for (Menu m : d.getLopendeOrders(takeawayNaam, vestigingsNaam)) {
            tekst += m.toString();
        }
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

        // aanmaken van heading in kader
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);

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
                doc.add(table);
                doc.add(new Paragraph(tekst, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                doc.newPage();
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        mail.sendLopendeOrdersmail(takeawayNaam, pdfVoorMail);
    }

    //VERKOPEN
    //deze methode moet worden opgeroepen bij het aanvragen van het overzicht, mail wordt automatisch naar betreffende takeaway verzonden
    public void pdfVerkopenTakeawayAlgemeen(String takeawayNaam) {
        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Verkopen_" + takeawayNaam;
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;
        String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
        String titel = "Verkopen van " + takeawayNaam + "\n\n";
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

        // aanmaken van heading in kader
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);

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
                doc.add(table);

                for (Vestiging v : d.getAlleVestigingen(takeawayNaam)) {
                    String gegevensVestiging = v.toString();
                    doc.add(new Paragraph(gegevensVestiging, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                    String verkopen = "";
                    for (Menu m : d.getVerkopen(takeawayNaam, v.getVestigingsID())) {
                        verkopen += m.toString();
                    }
                    doc.add(new Paragraph(verkopen, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                }
                doc.newPage();
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        mail.sendVerkopenmail(takeawayNaam, pdfVoorMail);
    }

    public void pdfVerkopenTakeawayVestiging(String takeawayNaam, String vestigingsNaam) {
        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Verkopen_" + takeawayNaam + "_" + vestigingsNaam;
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;
        String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
        String titel = "Verkopen van " + takeawayNaam + " - " + vestigingsNaam + "\n\n";
        String tekst = "";
        for (Menu m : d.getVerkopen(takeawayNaam, vestigingsNaam)) {
            tekst += m.toString();
        }
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

        // aanmaken van heading in kader
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);

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
                doc.add(table);
                doc.add(new Paragraph(tekst, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                doc.newPage();
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verzenden van mail met bijlage naar de take-aways
        mail.sendVerkopenmail(takeawayNaam, pdfVoorMail);
    }

    //ORDER DOORGEVEN NAAR BETREFFENDE TAKEAWAY
    public void pdfBesteldeProductenBijTakeaway(int orderID) {
        for (int menuID : d.getMenuIDsFromOrderID(orderID)) {
            Order besteldOrder = d.getOrder(orderID);
            Menu besteldeMenu = d.getMenu(menuID);
            ArrayList<Orderverwerking> besteldeProductenVanMenu = d.getAlleProductenVanMenu(menuID);

            //aanmaken van de documentsnaam
            DatumFinder date = new DatumFinder();
            String datum = date.getStringFromDate();

            String path = System.getProperty("user.dir") + "\\rapporten\\";
            String naam = "Bestelling_" + besteldeMenu.getTakeawayNaam() + "_" + besteldeMenu.getVestiging() + "_OrderID" + besteldeMenu.getOrderID() + "_MenuID" + besteldeMenu.getMenuID();
            String extensie = ".pdf";
            String bestandsnaam = path + naam + "_" + datum + extensie;
            String pdfVoorMail = naam + "_" + datum + extensie;
            String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

            //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
            String titel = "Bestelbon " + besteldeMenu.getTakeawayNaam() + " - " + besteldeMenu.getVestiging() + "\n\n";
            String tekst = "";
            for (Orderverwerking orderver : besteldeProductenVanMenu) {
                tekst += orderver.toString();
            }
            String gegevensVoorLevering = "Leverdatum: " + besteldOrder.getDatum() + "\n";
            gegevensVoorLevering += "Leveringsadres: " + besteldOrder.getStraat() + " " + besteldOrder.getHuisnummer() + ", " + d.getCoordinaten(besteldOrder.getPlaatsnummer()).getPostcode() + " " + d.getCoordinaten(besteldOrder.getPlaatsnummer()).getGemeente() + "\n";
            gegevensVoorLevering += "Totaal bedrag van bestelling (incl. kortingen): " + besteldeMenu.getMenuprijs() + " euro\n\n";
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

            // aanmaken van heading in kader
            PdfPTable table = new PdfPTable(1);
            PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.ORANGE);
            table.addCell(cell);

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
                    doc.add(table);
                    doc.add(new Paragraph(gegevensVoorLevering, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                    doc.add(new Paragraph(tekst, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                    doc.newPage();
                    doc.add(image);
                    doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                    doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                    doc.add(anchor);
                    doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                } catch (DocumentException ex) {
                    Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
                }
                doc.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            mail.sendBesteldeProductenVanOrder(d.getTakeaway(besteldeMenu.getTakeawayNaam()), pdfVoorMail);
        }
    }

    public void pdfBestellingKlant(int orderID, Klant kl) {

        //aanmaken van de documentsnaam
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();

        String path = System.getProperty("user.dir") + "\\rapporten\\";
        String naam = "Bestelling_" + "OrderID" + orderID + "_Klant" + kl.getLogin();
        String extensie = ".pdf";
        String bestandsnaam = path + naam + "_" + datum + extensie;
        String pdfVoorMail = naam + "_" + datum + extensie;
        String imagepath = System.getProperty("user.dir") + "\\src\\rsz_logo.png";

        //aanmaken van de tekst (hoofd en tekst hebben verschillende opmaak)
        String titel = "Bestelbon van " + kl.getVoornaam() + " " + kl.getNaam() + "\n\n";
        Order besteldOrder = d.getOrder(orderID);
        String gegevensVoorLevering = "Leverdatum: " + besteldOrder.getDatum() + "\n";
        gegevensVoorLevering += "Leveringsadres: " + besteldOrder.getStraat() + " " + besteldOrder.getHuisnummer() + ", " + d.getCoordinaten(besteldOrder.getPlaatsnummer()).getPostcode() + " " + d.getCoordinaten(besteldOrder.getPlaatsnummer()).getGemeente() + "\n";
        gegevensVoorLevering += "Totaal bedrag van bestelling (incl. kortingen): " + besteldOrder.getTotaalPrijs() + " euro\n\n";
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

        // aanmaken van heading in kader
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph(titel, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 16, Font.BOLD, BaseColor.BLACK)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.ORANGE);
        table.addCell(cell);

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
                doc.add(table);
                doc.add(new Paragraph(gegevensVoorLevering, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                for (int menuID : d.getMenuIDsFromOrderID(orderID)) {
                    Menu besteldeMenu = d.getMenu(menuID);
                    String menutekst = "";
                    menutekst += besteldeMenu.toString();
                    doc.add(new Paragraph(menutekst, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                    String producttekst = "";
                    for (Orderverwerking o : d.getAlleProductenVanMenu(menuID)) {
                        producttekst += o.toString();
                    }
                    doc.add(new Paragraph(producttekst, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                }

                doc.newPage();
                doc.add(image);
                doc.add(new Paragraph(aftiteling1, FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12, BaseColor.GRAY)));
                doc.add(new Paragraph(aftiteling2, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
                doc.add(anchor);
                doc.add(new Paragraph(aftiteling3, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, BaseColor.GRAY)));
            } catch (DocumentException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        mail.sendBestellingNaarKlant(kl, pdfVoorMail);

    }
}
