package Logica;

import java.util.ArrayList;

public class Orderverwerking {

    private int productID;
    private String productNaam;
    private String type;
    private double prijs;
    private int hoeveelheid;
    private String takeawayNaam;
    private String vestigingsID;

    public Orderverwerking() {
        this.productID = 0;
        this.productNaam = null;
        this.type = null;
        this.prijs = 0;
        this.hoeveelheid = 0;
        this.takeawayNaam = null;
        this.vestigingsID = null;
    }

    public Orderverwerking(int productID, String productNaam, String type, double prijs, int hoeveelheid, String takeawayNaam, String vestigingsID) {
        this.productID = productID;
        this.productNaam = productNaam;
        this.type = type;
        this.prijs = prijs;
        this.hoeveelheid = hoeveelheid;
        this.takeawayNaam = takeawayNaam;
        this.vestigingsID = vestigingsID;
    }

    public Orderverwerking(int productID, String productNaam, String type, int hoeveelheid) {
        this.productID = productID;
        this.productNaam = productNaam;
        this.type = type;
        this.prijs = 0;
        this.hoeveelheid = hoeveelheid;
        this.takeawayNaam = null;
        this.vestigingsID = null;
    }

    public ArrayList<Orderverwerking> verdelingBesteldeProducten(ArrayList<Orderverwerking> besteldeProducten, String takeaway, String vestiging) {

        ArrayList<Orderverwerking> menu = new ArrayList<>();
        for (Orderverwerking o : besteldeProducten) {
            if ((o.takeawayNaam.equalsIgnoreCase(takeaway)) && o.vestigingsID.equalsIgnoreCase(vestiging)) {
                menu.add(o);
            }
        }
        return menu;
    }

    @Override
    public String toString() {
        String result;
        result = "\t" + "ProductID:\t" + this.getProductID() + "\n";
        result +="\t" + "Naam:\t\t" + this.getProductNaam() + "\n";
        result += "\t" + "Producttype:\t" + this.getType()+ "\n";
        result += "\t" + "Hoeveelheid:\t" + this.getHoeveelheid() +"\n\n";
        return result;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getTakeawayNaam() {
        return takeawayNaam;
    }

    public void setTakeawayNaam(String takeawayNaam) {
        this.takeawayNaam = takeawayNaam;
    }

    public String getVestigingsID() {
        return vestigingsID;
    }

    public void setVestigingsID(String vestigingsID) {
        this.vestigingsID = vestigingsID;
    }

}
