package Logica;

public class JustFeedBoss extends Korting {

    private static final double PERCENTAGE = 0.40;
    private double percentage;
    private boolean status;

    public JustFeedBoss() {
        super();
        this.percentage = PERCENTAGE;
        this.status = true;
    }

    public JustFeedBoss(String login) {
        super();
        this.percentage = PERCENTAGE;
        this.status = true;

    }

    public JustFeedBoss(int kortingscode, boolean status, String login) {
        super(kortingscode, login);
        this.percentage = PERCENTAGE;
        this.status = status;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
