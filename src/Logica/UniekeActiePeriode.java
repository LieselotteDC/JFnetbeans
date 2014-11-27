package Logica;

import java.sql.Date;

public class UniekeActiePeriode extends UniekeActie {

    private Date startdatum;
    private Date einddatum;

    public UniekeActiePeriode(Date startdatum, Date einddatum) {
        super();
        this.startdatum = startdatum;
        this.einddatum = einddatum;
    }

    public UniekeActiePeriode(Date startdatum, Date einddatum, String vestiging, double bedrag, double percentage, String login, String takeawayNaam) {
        super(vestiging, bedrag, percentage, login, takeawayNaam);
        this.startdatum = startdatum;
        this.einddatum = einddatum;
    }

    public UniekeActiePeriode(Date startdatum, Date einddatum, int kortingscode, String vestiging, double bedrag, double percentage, String login, String takeawayNaam) {
        super(kortingscode, vestiging, bedrag, percentage, login, takeawayNaam);
        this.startdatum = startdatum;
        this.einddatum = einddatum;
    }

    public UniekeActiePeriode(Date startdatum, Date einddatum, String vestiging, String takeawayNaam, double bedrag, double percentage) {
        super(vestiging, takeawayNaam, bedrag, percentage);
        this.startdatum = startdatum;
        this.einddatum = einddatum;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "/tStartdatum:/t" +this.getStartdatum()+"/n";
        result += "/tEinddatum:/t" +this.getStartdatum()+"/n/n";
        return result;
    }

    public Date getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(Date startdatum) {
        this.startdatum = startdatum;
    }

    public Date getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(Date einddatum) {
        this.einddatum = einddatum;
    }

}
