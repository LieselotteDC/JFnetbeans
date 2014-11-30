package Logica;

public class Just_Feeder extends Award {

    private double commissie;
    private String takeawayNaam;

    public Just_Feeder() {
        super();
        this.commissie = 0;
        this.takeawayNaam = null;
    }

    public Just_Feeder(int AwardID, String maand, double commissie, String takeawayNaam) {
        super(AwardID, maand);
        this.commissie = commissie;
        this.takeawayNaam = takeawayNaam;
    }

    public Just_Feeder(String maand, double commissie, String takeawayNaam) {
        super(maand);
        this.commissie = commissie;
        this.takeawayNaam = takeawayNaam;
    }

    public Just_Feeder(double commissie, String takeawayNaam) {
        super();
        this.commissie = commissie;
        this.takeawayNaam = takeawayNaam;
    }

    public double getCommissie() {
        return commissie;
    }

    public void setCommissie(double commissie) {
        this.commissie = commissie;
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
        result = "Just Feeder Award\n";
        result += super.toString();
        result += "Naam van de Takeaway:\t" + this.getTakeawayNaam() + "\n";
        result += "Commissie:\t" + this.getCommissie() + "\n\n";
        return result;

    }
}
