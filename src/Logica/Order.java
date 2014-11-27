package Logica;

public class Order {

    private int orderID;
    private double totaalPrijs;
    private String datum;
    private String straat;
    private String huisnummer;
    private String gemeente;
    private String postcode;
    private String login;
    private int plaatsnummer;
    private Boolean status;

    public Order() {
        this.orderID = orderID;
        this.totaalPrijs = totaalPrijs;
        this.datum = datum;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.login = login;
        this.plaatsnummer = plaatsnummer;

    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getTotaalPrijs() {
        return totaalPrijs;
    }

    public void setTotaalPrijs(double totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPlaatsnummer() {
        return plaatsnummer;
    }

    public void setPlaatsnummer(int plaatsnummer) {
        this.plaatsnummer = plaatsnummer;
    }

}
