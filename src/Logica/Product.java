package Logica;

public class Product {

    private int ProductID;
    private String naam;
    private String producttype;
    private double eenheidsprijs;
    private String takeawaynaam;

    public Product() {
        this.ProductID = 0;
        this.naam = null;
        this.producttype = null;
        this.eenheidsprijs = 0;
        this.takeawaynaam = null;
    }

    public Product(int ProductID, String naam, String producttype, double eenheidsprijs, String takeawaynaam) {
        this.ProductID = ProductID;
        this.naam = naam;
        this.producttype = producttype;
        this.eenheidsprijs = eenheidsprijs;
        this.takeawaynaam = takeawaynaam;
    }

    public Product(int ProductID, String naam, String producttype, double eenheidsprijs) {
        this.ProductID = ProductID;
        this.naam = naam;
        this.producttype = producttype;
        this.eenheidsprijs = eenheidsprijs;
        this.takeawaynaam = null;
    }

    public Product(int ProductID) {
        this.ProductID = ProductID;
        this.naam = null;
        this.producttype = null;
        this.eenheidsprijs = 0;
        this.takeawaynaam = null;
    }

    public Product(String naam, String type, double eenheidsprijs, String takeawaynaam) {
        this.ProductID = 0;
        this.naam = naam;
        this.producttype = type;
        this.eenheidsprijs = eenheidsprijs;
        this.takeawaynaam = takeawaynaam;
    }

    public Product(String naam, String type, double eenheidsprijs) {
        this.ProductID = 0;
        this.naam = naam;
        this.producttype = type;
        this.eenheidsprijs = eenheidsprijs;
        this.takeawaynaam = null;
    }

    public int getProductID() {
        return ProductID;
    }

    public String getNaam() {
        return naam;
    }

    public String getProducttype() {
        return producttype;
    }

    public double getEenheidsprijs() {
        return eenheidsprijs;
    }

    public String getTakeawaynaam() {
        return takeawaynaam;
    }

    public void setTakeawaynaam(String takeawaynaam) {
        this.takeawaynaam = takeawaynaam;
    }

    @Override
    public String toString() {
        String result;
        result = "\t" + "ProductID:\t" + this.getProductID() + "\n";
        result += "\t" + "Naam:\t\t" + this.getNaam() + "\n";
        result += "\t" + "Producttype:\t" + this.getProducttype() + "\n";
        result += "\t" + "Eenheidsprijs:\t" + this.getEenheidsprijs() + " euro" + "\n\n";

        return result;
    }
}
