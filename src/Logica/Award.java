package Logica;

public class Award {

    private int awardID;
    private String maand;

    public Award() {
        this.awardID = 0;
        this.maand = null;
    }

    public Award(String maand) {
        this.awardID = 0;
        this.maand = maand;
    }

    public Award(int awardID, String maand) {
        this.awardID = awardID;
        this.maand = maand;
    }

    public int getAwardID() {
        return awardID;
    }

    public void setAwardID(int awardID) {
        this.awardID = awardID;
    }

    public String getMaand() {
        return maand;
    }

    public void setMaand(String maand) {
        this.maand = maand;
    }

    
 
    @Override
    public String toString() {
        String result;
        result = "AwardID: \t" + this.getAwardID() + "\n";
        result += "Maand: \t" + this.getMaand() + "\n";
        return result;
    }
}
