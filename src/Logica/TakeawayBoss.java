package Logica;

public class TakeawayBoss extends Korting {

    private static final double PERCENTAGE = 20.0;
    private double percentage;
    private boolean status;
    private String login;

    public TakeawayBoss() {
        super();
        this.percentage = PERCENTAGE;
        this.status = true;
        this.login = null;
    }

    public TakeawayBoss(String login) {
        super();
        this.percentage = PERCENTAGE;
        this.status = true;
        this.login = login;
    }

    public TakeawayBoss(int kortingscode, boolean status, String login) {
        super(kortingscode);
        this.percentage = PERCENTAGE;
        this.status = status;
        this.login = login;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
