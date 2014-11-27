package Logica;

public class ReviewKorting extends Korting {

    private static final double PERCENTAGE = 10.0;
    private double percentage;
    private boolean status;

    public ReviewKorting() {
        super();
        this.percentage = PERCENTAGE;
        this.status = true;
    }

    public ReviewKorting(int kortingscode, boolean status, String login) {
        super(kortingscode,login);
        this.percentage = PERCENTAGE;
        this.status = status;
    }

    public ReviewKorting(String login) {
        super(login);
        this.percentage = PERCENTAGE;
        this.status = true;
    }

    public double getPercentage() {
        return percentage;
    }

    public boolean isStatus() {
        return status;
    }

}
