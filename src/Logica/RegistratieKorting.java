package Logica;

public class RegistratieKorting extends Korting {

    private static final double BEDRAG = 2.00;
    private double bedrag;
    private boolean status;

    public RegistratieKorting() {
        super();
        this.bedrag = BEDRAG;
        this.status = true;

    }

    public RegistratieKorting(int kortingscode, boolean status, String login) {
        super(kortingscode, login);
        this.bedrag = BEDRAG;
        this.status = status;
    }

    public RegistratieKorting(String login) {
        super(login);
        this.bedrag = BEDRAG;
        this.status = true;
    }

    public double getBedrag() {
        return bedrag;
    }

    public boolean isStatus() {
        return status;
    }

}
