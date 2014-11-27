package Logica;

public class SorteerKorting implements Comparable{

    private String login;
    private double bedrag;

    public SorteerKorting() {

    }

    public SorteerKorting(String login, double bedrag) {
        this.login = login;
        this.bedrag = bedrag;
    }
    


    public String getLogin() {
        return login;
    }

    public double getBedrag() {
        return bedrag;
    }

    @Override
    public int compareTo(Object o) {
        if (bedrag > ((SorteerKorting)o).getBedrag())
            return -1;
        else
            return 1;
            
                  
    }

}
