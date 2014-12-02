package Logica;

public class HulpKorting {

    private String takeawayNaam;
    private double kortingsbedrag;

    public HulpKorting() {
        this.takeawayNaam = null;
        this.kortingsbedrag = 0;
    }

    public HulpKorting(String takeawayNaam, double kortingsbedrag) {
        this.takeawayNaam = takeawayNaam;
        this.kortingsbedrag = kortingsbedrag;
    }

    public String getTakeawayNaam() {
        return takeawayNaam;
    }

    public void setTakeawayNaam(String takeawayNaam) {
        this.takeawayNaam = takeawayNaam;
    }

    public double getKortingsbedrag() {
        return kortingsbedrag;
    }

    public void setKortingsbedrag(double kortingsbedrag) {
        this.kortingsbedrag = kortingsbedrag;
    }

}
