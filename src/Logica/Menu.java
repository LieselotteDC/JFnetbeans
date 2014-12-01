package Logica;

public class Menu {

    private int menuID;
    private double menuprijs;
    private int orderID;
    private String takeawayNaam;
    private String vestiging;

    public Menu() {
        this.menuID = 0;
        this.menuprijs = 0;
        this.orderID = 0;
        this.takeawayNaam = null;
        this.vestiging = null;
    }

    public Menu(int menuID, double menuprijs, int orderID, String takeawayNaam, String vestiging) {
        this.menuID = menuID;
        this.menuprijs = menuprijs;
        this.orderID = orderID;
        this.takeawayNaam = takeawayNaam;
        this.vestiging = vestiging;
    }

    public Menu(double menuprijs, int orderID, String takeawayNaam, String vestiging) {
        this.menuID = 0;
        this.menuprijs = menuprijs;
        this.orderID = orderID;
        this.takeawayNaam = takeawayNaam;
        this.vestiging = vestiging;
    }

    public String getVestiging() {
        return vestiging;
    }

    public void setVestiging(String vestiging) {
        this.vestiging = vestiging;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public double getMenuprijs() {
        return menuprijs;
    }

    public void setMenuprijs(double menuprijs) {
        this.menuprijs = menuprijs;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getTakeawayNaam() {
        return takeawayNaam;
    }

    public void setTakeawayNaam(String takeawayNaam) {
        this.takeawayNaam = takeawayNaam;
    }

}
