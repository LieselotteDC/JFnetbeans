package Logica;

public class Bestseller extends Award implements Comparable {

    private int aantalMenus;
    private String takeawayNaam;

    public Bestseller() {
        super();
        this.aantalMenus = 0;
        this.takeawayNaam = null;
    }

    public Bestseller(int AwardID, String maand, int aantalMenus, String takeawayNaam) {
        super(AwardID, maand);
        this.aantalMenus = aantalMenus;
        this.takeawayNaam = takeawayNaam;
    }

    public Bestseller(String maand, int aantalMenus, String takeawayNaam) {
        super(maand);
        this.aantalMenus = aantalMenus;
        this.takeawayNaam = takeawayNaam;
    }
        public Bestseller(int aantalMenus, String takeawayNaam) {
        super();
        this.aantalMenus = aantalMenus;
        this.takeawayNaam = takeawayNaam;
    }
        
    @Override
    public int compareTo(Object o) {
        if (aantalMenus > ((Bestseller)o).getAantalMenus())
            return -1;
        else
            return 1;
    }
    public int getAantalMenus() {
        return aantalMenus;
    }

    public void setAantalMenus(int aantalMenus) {
        this.aantalMenus = aantalMenus;
    }

    public String getTakeawayNaam() {
        return takeawayNaam;
    }

    public void setTakeawayNaam(String takeawayNaam) {
        this.takeawayNaam = takeawayNaam;
    }

    @Override
     public String toString() {
        String result;
        result = "Bestseller Award\n";
        result += super.toString();
        result += "Naam van de take-away:\t" + this.getTakeawayNaam() + "\n";
        result += "Aantal orders:\t" + this.getAantalMenus()+ "\n\n";
        return result;

    }


}
