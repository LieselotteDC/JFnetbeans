package Logica;

import Database.Database;
import java.util.ArrayList;

public class Vestiging {

    //eventueel ToString methode schrijven voor adres. Afhankelijk van hoe het in de GUI weergegeven wordt.
    private String vestigingsID;
    private String takeawayNaam;
    private String straat;
    private int huisnummer;
    private double leveringskosten;
    private int plaatsnummer;
    private ArrayList<Gemeente> leveringsgebied;

    public Vestiging(String straat, int huisnummer, double leveringskosten, int plaatsnummer, String takeawayNaam, String vestigingsID) {
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.leveringskosten = leveringskosten;
        this.takeawayNaam = takeawayNaam;
        this.plaatsnummer = plaatsnummer;
        this.vestigingsID = vestigingsID;
    }

    public Vestiging(String vestigingsID, String takeawayNaam, String straat, int huisnummer,int plaatsnummer, double leveringskosten, ArrayList<Gemeente> leveringsgebied) {
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.leveringskosten = leveringskosten;
        this.takeawayNaam = takeawayNaam;
        this.plaatsnummer = plaatsnummer;
        this.vestigingsID = vestigingsID;
        this.leveringsgebied = leveringsgebied;
    }

    public String getStraat() {
        return straat;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public double getLeveringskosten() {
        return leveringskosten;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public void setLeveringskosten(double leveringskosten) {
        this.leveringskosten = leveringskosten;
    }

    public String getVestigingsID() {
        return vestigingsID;
    }

    public void setVestigingsID(String vestigingsID) {
        this.vestigingsID = vestigingsID;
    }

    public String getTakeawayNaam() {
        return takeawayNaam;
    }

    public void setTakeawayNaam(String takeawayNaam) {
        this.takeawayNaam = takeawayNaam;
    }

    public int getPlaatsnummer() {
        return plaatsnummer;
    }

    public void setPlaatsnummer(int plaatsnummer) {
        this.plaatsnummer = plaatsnummer;
    }

    public ArrayList<Gemeente> getLeveringsgebied() {
        return leveringsgebied;
    }

    public void setLeveringsgebied(ArrayList<Gemeente> leveringsgebied) {
        this.leveringsgebied = leveringsgebied;
    }

    @Override
    public String toString() {
        Database d = new Database();
        String result;
        result = "VestigingsID:\t" + this.getVestigingsID() + "\n";
        result += d.getCoordinaten(this.getPlaatsnummer()).toString();
        result += "Straat:\t" + this.getStraat() + "\n";
        result += "Huisnummer:\t" + this.getHuisnummer() + "\n";
        result += "Leveringskosten:\t" + this.getLeveringskosten() + " euro\n";
        result += "Leveringsgebied:\t\n";
        for (Gemeente gem : this.getLeveringsgebied()) {
            result += "\t" + gem.toString();
            result += "\n";
        }
        return result;
    }

}
