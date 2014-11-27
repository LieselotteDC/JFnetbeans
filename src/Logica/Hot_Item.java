package Logica;

public class Hot_Item extends Award implements Comparable{

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
        if (aantalBesteld > ((Hot_Item)o).getAantalBesteld())
            return -1;
        else
            return 1;
    }

}
