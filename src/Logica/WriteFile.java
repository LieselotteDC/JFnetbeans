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
    }

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
