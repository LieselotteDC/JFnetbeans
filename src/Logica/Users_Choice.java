package Logica;

public class Users_Choice extends Award implements Comparable {

    private double beoordeling;
    private String takeawayNaam;

    public Users_Choice() {
        super();
        this.beoordeling = 0;
        this.takeawayNaam = null;
    }

    public Users_Choice(int AwardID, String maand, double beoordeling, String takeawayNaam) {
        super(AwardID, maand);
        this.beoordeling = beoordeling;
        this.takeawayNaam = takeawayNaam;
    }

    public Users_Choice(String maand, double beoordeling, String takeawayNaam) {
        super(maand);
        this.beoordeling = beoordeling;
        this.takeawayNaam = takeawayNaam;
    }

    public Users_Choice(double beoordeling, String takeawayNaam) {
        super();
        this.beoordeling = beoordeling;
        this.takeawayNaam = takeawayNaam;
    }

    @Override
    public int compareTo(Object o) {
        if (beoordeling > ((Users_Choice) o).getBeoordeling()) {
            return -1;
        } else {
            return 1;
        }
    }

    public double getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(double beoordeling) {
        this.beoordeling = beoordeling;
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
        result = "Users Choice Award\n";
        result += super.toString();
        result += "Naam van de Takeaway:\t" + this.getTakeawayNaam() + "\n";
        result += "Gemiddelde beoordeling:\t" + this.getBeoordeling() + "\n";
        result += "\n";
        return result;

    }

}
