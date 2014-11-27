package Logica;

public class UniekeActieEenmalig extends UniekeActie {

    private boolean status;

    public UniekeActieEenmalig(boolean status) {
        super();
        this.status = status;
    }

    public UniekeActieEenmalig(boolean status, String vestiging, double bedrag, double percentage, String login, String takeawayNaam) {
        super(vestiging, bedrag, percentage, login, takeawayNaam);
        this.status = status;
    }

    public UniekeActieEenmalig(boolean status, int kortingscode, String vestiging, double bedrag, double percentage, String login, String takeawayNaam) {
        super(kortingscode, vestiging, bedrag, percentage, login, takeawayNaam);
        this.status = status;
    }

    public UniekeActieEenmalig(int kortingscode, String vestiging, double bedrag, double percentage, String login, String takeawayNaam) {
        super(kortingscode, vestiging, bedrag, percentage, login, takeawayNaam);
        this.status = true;
    }

    public UniekeActieEenmalig(boolean status, String vestiging, String takeawayNaam, double bedrag, double percentage) {
        super(vestiging, takeawayNaam, bedrag, percentage);
        this.status = status;
    }

    public UniekeActieEenmalig(String vestiging, String takeawayNaam, double bedrag, double percentage) {
        super(vestiging, takeawayNaam, bedrag, percentage);
        this.status = true;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result+="/n";
        return result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
