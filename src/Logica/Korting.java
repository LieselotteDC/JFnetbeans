package Logica;

import java.util.ArrayList;

public class Korting {

    private int kortingscode;
    private String login;

    public Korting() {
        this.kortingscode = 0;
        this.login = null;
    }

    public Korting(int kortingscode, String login) {
        this.kortingscode = kortingscode;
        this.login = login;
    }

    public Korting(String login) {
        this.kortingscode = 0;
        this.login = login;
    }

    public Korting(int kortingscode) {
        this.kortingscode = kortingscode;
        this.login = null;
    }

    public Boolean bevatTypeKorting(Korting ingevoerdeKorting, ArrayList<Korting> reedsIngevoerdeKortingen) {
        boolean bevatType = false;
        if (reedsIngevoerdeKortingen.isEmpty()) {
            bevatType = false;
        } else {
            if (reedsIngevoerdeKortingen.contains(ingevoerdeKorting)) {
                bevatType = true;
            }
        }
        return bevatType;
    }

    @Override
    public String toString() {
        String result = null;
        result += "\tKortingscode:\t" + this.getKortingscode() + "\n";
        result += "\tEigenaar code:\t" + this.getLogin() + "\n";
        return result;
    }

    public int getKortingscode() {
        return kortingscode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
