package Logica;

public class UniekeActie extends Korting {

    private String vestiging;
    private double bedrag;
    private double percentage;
    private String takeawayNaam;

    public UniekeActie() {
        super();
        this.bedrag = 0;
        this.percentage = 0;
        this.vestiging = null;
        this.takeawayNaam = null;
    }

    public UniekeActie(String vestiging, double bedrag, double percentage, String login, String takeawayNaam) {
        super(login);
        this.vestiging = vestiging;
        this.bedrag = bedrag;
        this.percentage = percentage;
        this.takeawayNaam = takeawayNaam;
    }

    public UniekeActie(int kortingscode, String vestiging, double bedrag, double percentage, String login, String takeawayNaam) {
        super(kortingscode, login);
        this.vestiging = vestiging;
        this.bedrag = bedrag;
        this.takeawayNaam = takeawayNaam;
    }

    public UniekeActie(String vestiging, String takeawayNaam, double bedrag, double percentage) {
        super();
        this.vestiging = vestiging;
        this.bedrag = bedrag;
        this.percentage = percentage;
        this.takeawayNaam = takeawayNaam;
    }

    @Override
    public String toString() {
        String result = super.toString();
        if (this.bedrag == 0) {
            result += "\tKortingspercentage:\t" + this.getPercentage() + "%\n";
        } else {
            result += "\tKortingsbedrag:\t" + this.getBedrag() + "%\n";
        }
        return result;
    }

    public String getVestiging() {
        return vestiging;
    }

    public void setVestiging(String vestiging) {
        this.vestiging = vestiging;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getTakeawayNaam() {
        return takeawayNaam;
    }

    public void setTakeawayNaam(String takeawayNaam) {
        this.takeawayNaam = takeawayNaam;
    }

}
