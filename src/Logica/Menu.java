package Logica;

import Database.Database;
import java.util.ArrayList;

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

    public Menu(double menuprijs, String takeawayNaam, String vestiging) {
        this.menuID = 0;
        this.menuprijs = menuprijs;
        this.orderID = 0;
        this.takeawayNaam = takeawayNaam;
        this.vestiging = vestiging;
    }

    public Menu berekenMenuprijs(ArrayList<Orderverwerking> besteldeProductenMenu) {
        if (!(besteldeProductenMenu.isEmpty())) {
            String takeaway1 = besteldeProductenMenu.get(0).getTakeawayNaam();
            String vestiging1 = besteldeProductenMenu.get(0).getVestigingsID();
            double menuprijs1 = 0;
            for (Orderverwerking o : besteldeProductenMenu) {
                menuprijs1 += o.getHoeveelheid() * o.getPrijs();
            }
            Menu menu = new Menu(menuprijs1, takeaway1, vestiging1);
            return menu;
        } else {
            return null;
        }
    }
    
    public void toepassenUniekePeriodiekeKortingen(int code, ArrayList<Menu> berekendeMenus, Klant kl){
        Database d=new Database();
        for(Menu menu:berekendeMenus){
            if(d.kortingPeriodeBruikbaarBijMenu(code, menu, kl)){
              if(d.getKortingEenmaligPeriode(code).getBedrag()==0){
                  menu.setMenuprijs(menuprijs*(1-d.getKortingEenmaligPeriode(code).getPercentage()));
              }else{
                  menu.setMenuprijs(menuprijs-d.getKortingEenmaligPeriode(code).getBedrag());
              }       
            }
        }           
    }
    
    public void toepassenUniekeEenmailgeKortingen(int code, ArrayList<Menu> berekendeMenus, Klant kl){
        Database d=new Database();
        for(Menu menu:berekendeMenus){
            if(d.kortingEenmaligBruikbaarBijMenu(code, menu, kl)){
              if(d.getKortingEenmaligPeriode(code).getBedrag()==0){
                  menu.setMenuprijs(menuprijs*(1-d.getKortingEenmaligPeriode(code).getPercentage()));
              }else{
                  menu.setMenuprijs(menuprijs-d.getKortingEenmaligPeriode(code).getBedrag());
              }       
            }
        }           
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
