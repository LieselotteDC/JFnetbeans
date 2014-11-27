package Logica;

import java.util.ArrayList;

public class Take_Away {

    private String naam;
    private ArrayList<String> categorie;
    private String email;
    private double commissie;

    public Take_Away() {
        this.naam = null;
        this.categorie = null;
        this.email = null;
        this.commissie = 0;
    }

    public Take_Away(String naam, ArrayList<String> categorie, String email, double commissie) {
        this.naam = naam;
        this.categorie = categorie;
        this.email = email;
        this.commissie = commissie;
    }

    public Take_Away(String naam, ArrayList<String> categorie, String email) {
        this.naam = naam;
        this.categorie = categorie;
        this.email = email;
        this.commissie = 0;
    }

    public Take_Away(String naam, String email) {
        this.naam = naam;
        this.categorie = null;
        this.email = email;
        this.commissie = 0;
    }

    public Take_Away(String naam, String email, double commissie) {
        this.naam = naam;
        this.categorie = null;
        this.email = email;
        this.commissie = commissie;
    }

    public Take_Away(String naam, double commissie) {
        this.naam = naam;
        this.categorie = null;
        this.email = null;
        this.commissie = commissie;
    }
    
        public Take_Away(String naam) {
        this.naam = naam;
        this.categorie = null;
        this.email = null;
        this.commissie = 0;
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<String> getCategorie() {
        return categorie;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setCategorie(ArrayList<String> categorie) {
        this.categorie = categorie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCommissie() {
        return commissie;
    }

    public void setCommissie(double commissie) {
        this.commissie = commissie;
    }
    
    @Override
    public String toString ()
    {
        String result;
        result = "Naam takeaway:\t" + this.getNaam() + "\n";
        result += "Categorie:\t";
        for (String cat : this.getCategorie())
        {
            result += cat + ", ";
        }
        result += "\n";
        result = "Email:\t" + this.getEmail() + "\n\n";
        return result;
        
        
    }

}
