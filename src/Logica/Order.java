package Logica;

import java.sql.Date;

public class Order {

    private int orderID;
    private double totaalPrijs;
    private Date datum;
    private String straat;
    private int huisnummer;
    private int plaatsnummer;
    private String login;
    private boolean status;

    public Order() {
        this.orderID = 0;
        this.totaalPrijs = 0;
        this.datum = null;
        this.straat = null;
        this.huisnummer = 0;
        this.plaatsnummer = 0;
        this.login = null;
        this.status = false;
    }

    public Order(double totaalPrijs, Date datum, String straat, int huisnummer, int plaatsnummer, String login, boolean status) {
        this.orderID = 0;
        this.totaalPrijs = totaalPrijs;
        this.datum = datum;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.plaatsnummer = plaatsnummer;
        this.login = login;
        this.status = status;
    }

    public Order(int orderID, String straat, int huisnummer, int plaatsnummer) {
        this.orderID = orderID;
        this.totaalPrijs = 0;
        this.datum = null;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.plaatsnummer = plaatsnummer;
        this.login = null;
        this.status = false;
    }
    

    public Order(int orderID, double totaalPrijs, Date datum, String straat, int huisnummer, int plaatsnummer) {
        this.orderID = orderID;
        this.totaalPrijs = totaalPrijs;
        this.datum = datum;
        this.straat = straat;
        this.huisnummer = huisnummer;
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
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

    public int getPlaatsnummer() {
        return plaatsnummer;
    }

    public void setPlaatsnummer(int plaatsnummer) {
        this.plaatsnummer = plaatsnummer;
    }

}
