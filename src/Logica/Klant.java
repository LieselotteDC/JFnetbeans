package Logica;

import Database.Database;

public class Klant {

    private String login;
    private String paswoord;
    private String email;
    private String naam;
    private String voornaam;
    Database wdb = new Database();

    public Klant() {
        this.login = null;
        this.paswoord = null;
        this.email = null;
        this.naam = null;
        this.voornaam = null;
    }

    public Klant(String login, String paswoord, String email, String naam, String voornaam) {
        this.login = login;
        this.paswoord = paswoord;
        this.email = email;
        this.naam = naam;
        this.voornaam = voornaam;
    }

    public Klant(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

}
