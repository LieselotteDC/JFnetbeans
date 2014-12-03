/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Database.Database;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author kpittoor
 */
public class WriteFile extends Exception {

   //DatumFinder date = new DatumFinder();
    //String datum = date.getStringFromDate();

    //Awardrapporten
    public void awardsPerTakeaway(String maand, int jaar) {
        DatumFinder date = new DatumFinder();
        String datum = date.getStringFromDate();
        
        String path = System.getProperty("user.dir") +"\\rapporten\\";
        String naam = "Awards_"+maand+"_"+jaar;
        String extensie = ".doc";
        String bestandsnaam =path + naam + " " + datum + extensie;

        this.writeFile(bestandsnaam, this.awardsBoodschap(maand, jaar));
    }

    private String awardsBoodschap(String maand, int jaar) {
        String tekst = "Ovezicht van de uitgereikte Awards van "+maand+" "+jaar+"\n\n";
        Database d = new Database();

        for(Award a: d.getAlleAwards()){
            
            tekst+=a.toString();
        }

        return tekst;
    }
/*
    //Lopende orders
    public void lopendeOrdersPerTakeaway(String takeawayNaam) {
        String bestandsnaam = "H:";
        String naam = "Lopende orders " + takeawayNaam;
        String extensie = ".doc";
        bestandsnaam = bestandsnaam + naam + " " + datum + extensie;

        this.writeFile(bestandsnaam, this.lopendeOrdersPerTakeawayBoodschap(takeawayNaam));
    }

    private String lopendeOrdersPerTakeawayBoodschap(String takeawayNaam) {
        int spaces = 33;
        String tekst = "Lopende orders: " + takeawayNaam;
        String space = " ";
        for (int i = 1; i < spaces; i++) {
            space += " ";
        }
        tekst += space + date.getDate() + "\n\n";

        Database db = new Database();
        for (Vestiging v : db.getAlleVestigingen(takeawayNaam)) {
            tekst += lopendeOrdersPerVestigingBoodschap(takeawayNaam, v.getVestigingsID());
        }
        return tekst;
    }

    public void lopendeOrdersPerVestiging(String takeawayNaam, String vestigingsNaam) {
        String bestandsnaam = "H:";
        String naam = "Lopende orders " + takeawayNaam + vestigingsNaam;
        String extensie = ".doc";
        bestandsnaam = bestandsnaam + naam + " " + datum + extensie;

        this.writeFile(bestandsnaam, this.lopendeOrdersPerVestigingBoodschap(takeawayNaam, vestigingsNaam));
    }

    private String lopendeOrdersPerVestigingBoodschap(String takeawaynaam, String vestigingsNaam) {
        String tekst = "Lopende orders: " + takeawaynaam + " - " + vestigingsNaam + "\n";

        Database db = new Database();

        for (Menu m : db.getLopendeOrders(takeawaynaam, vestigingsNaam)) {
            tekst = tekst + m.toString();
        }
        return tekst;
    }

    //Verkopen
    public void verkopenPerTakeaway(String takeawayNaam) {
        String bestandsnaam = "H:";
        String naam = "Verkopen " + takeawayNaam;
        String extensie = ".doc";
        bestandsnaam = bestandsnaam + naam + " " + datum + extensie;

        this.writeFile(bestandsnaam, this.verkopenPerTakeawayBoodschap(takeawayNaam));
    }

    private String verkopenPerTakeawayBoodschap(String takeawayNaam) {
        int spaces = 33;
        String tekst = "Verkopen: " + takeawayNaam;
        String space = " ";
        for (int i = 1; i < spaces; i++) {
            space += " ";
        }
        tekst += space + date.getDate() + "\n\n";

        Database db = new Database();
        for (Vestiging v : db.getAlleVestigingen(takeawayNaam)) {
            tekst += this.verkopenPerVestigingBoodschap(takeawayNaam, v.getVestigingsID());
        }
        return tekst;
    }

    public void verkopenPerVestiging(String takeawayNaam, String vestigingsNaam) {
        String bestandsnaam = "H:";
        String naam = "Verkopen " + takeawayNaam + vestigingsNaam;
        String extensie = ".doc";
        bestandsnaam = bestandsnaam + naam + " " + datum + extensie;

        this.writeFile(bestandsnaam, this.verkopenPerVestigingBoodschap(takeawayNaam, vestigingsNaam));
    }

    private String verkopenPerVestigingBoodschap(String takeawaynaam, String vestigingsNaam) {
        String tekst = "Verkopen: " + takeawaynaam + " - " + vestigingsNaam + "\n";

        Database db = new Database();
        for (Menu m : db.getVerkopen(takeawaynaam, vestigingsNaam)) {
            tekst = tekst + m.toString();
        }
        return tekst;
    }

    //kortingscodes
    public void kortingscodesPerTakeaway(String takeawayNaam) {
        String bestandsnaam = "H:";
        String naam = "Kortingscodes " + takeawayNaam;
        String extensie = ".doc";
        bestandsnaam = bestandsnaam + naam + " " + datum + extensie;

        this.writeFile(bestandsnaam, this.kortingscodesPerTakeawayBoodschap(takeawayNaam));
    }

    private String kortingscodesPerTakeawayBoodschap(String takeawayNaam) {
        int spaces = 33;
        String tekst = "Kortingscodes: " + takeawayNaam;
        String space = " ";
        for (int i = 1; i < spaces; i++) {
            space += " ";
        }
        tekst += space + date.getDate() + "\n\n";

        Database db = new Database();
        for (Vestiging v : db.getAlleVestigingen(takeawayNaam)) {
            tekst += kortingscodesPerVestigingBoodschap(takeawayNaam, v.getVestigingsID());
        }
        return tekst;
    }

    public void kortingscodesPerVestiging(String takeawayNaam, String vestigingsNaam) {
        String bestandsnaam = "H:";
        String naam = "Kortingscodes " + takeawayNaam + vestigingsNaam;
        String extensie = ".doc";
        bestandsnaam = bestandsnaam + naam + " " + datum + extensie;

        this.writeFile(bestandsnaam, this.kortingscodesPerVestigingBoodschap(takeawayNaam, vestigingsNaam));
    }

    private String kortingscodesPerVestigingBoodschap(String takeawaynaam, String vestigingsNaam) {
        String tekst = "Kortingscodes: " + takeawaynaam + " - " + vestigingsNaam + "\n";

        Database db = new Database();
        for (Korting k : db.rapportKortingSpecifiek(takeawaynaam, vestigingsNaam)) {
            tekst = tekst + k.toString();
        }
        return tekst;
    }

    //menu
    public void menukaartPerTakeaway(String takeawayNaam) {
        String bestandsnaam = "H:";
        String naam = "Menu " + takeawayNaam;
        String extensie = ".doc";
        bestandsnaam = bestandsnaam + naam + " " + datum + extensie;

        this.writeFile(bestandsnaam, this.menukaartPerTakeawayBoodschap(takeawayNaam));
    }

    private String menukaartPerTakeawayBoodschap(String takeawayNaam) {
        int spaces = 38;
        String tekst = "Menukaart " + takeawayNaam;
        String space = " ";
        for (int i = 1; i < spaces; i++) {
            space += " ";
        }
        tekst += space + date.getDate() + "\n\n";

        Database db = new Database();
        for (Product p : db.getProductsOfTakeaway(takeawayNaam)) {
            tekst = tekst + p.toString();
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

}
