package Logica;

import Database.Database;

public class Hot_Item extends Award implements Comparable {

    private int aantalBesteld;
    private int productID;

    public Hot_Item() {
        super();
        this.aantalBesteld = 0;
        this.productID = 0;
    }

    public Hot_Item(int aantalBesteld, int productID) {
        super();
        this.aantalBesteld = aantalBesteld;
        this.productID = productID;
    }

    public Hot_Item(int AwardID, String maand, int aantalBesteld, int productID) {
        super(AwardID, maand);
        this.aantalBesteld = aantalBesteld;
        this.productID = productID;
    }

    public Hot_Item(String maand, int aantalBesteld, int productID) {
        super(maand);
        this.aantalBesteld = aantalBesteld;
        this.productID = productID;
    }

    public int getAantalBesteld() {
        return aantalBesteld;
    }

    public void setAantalBesteld(int aantalBesteld) {
        this.aantalBesteld = aantalBesteld;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public int compareTo(Object o) {
        if (aantalBesteld > ((Hot_Item) o).getAantalBesteld()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        Database d = new Database();
        String result;
        result = "Hot Item Award\n";
        result += super.toString();     
        result += "Naam van de takeaway:\t" + d.getTakeawaynaamProduct(this.getProductID()).getNaam() + "\n";
        result += "Naam van het product:\t" + d.getProduct(this.getProductID()).getNaam() + "\n";
        result += "Aantal keer besteld:\t" + this.getAantalBesteld() + "\n\n";
        return result;

    }

}
