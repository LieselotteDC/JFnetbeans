package Logica;

public class Gemeente {

    private String gemeente;
    private int postcode;

    public Gemeente(String gemeente, int postcode) {
        this.gemeente = gemeente;
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String toString() {
        String result;
        result = "Gemeente: \t" + this.getGemeente() + "\n";
        result = "Postcode: \t" + this.getPostcode() + "\n";
        return result;
    }

}
