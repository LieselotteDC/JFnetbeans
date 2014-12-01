
package Logica;


public class Orderverwerking {
    private int productID;
    private String productNaam;
    private String type;
    private double prijs;
    private String takeawayNaam;
    private String vestigingsID;

    public Orderverwerking(int productID, String productNaam, String type, double prijs, String takeawayNaam, String vestigingsID) {
        this.productID = productID;
        this.productNaam = productNaam;
        this.type = type;
        this.prijs = prijs;
        this.takeawayNaam = takeawayNaam;
        this.vestigingsID = vestigingsID;
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
