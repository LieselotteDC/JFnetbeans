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

    public void berekenMenuprijs(ArrayList<Orderverwerking> besteldeProductenMenu) {
        Database d = new Database();
        if (!(besteldeProductenMenu.isEmpty())) {
            String takeaway1 = besteldeProductenMenu.get(0).getTakeawayNaam();
            String vestiging1 = besteldeProductenMenu.get(0).getVestigingsID();
            this.setTakeawayNaam(takeaway1);
            this.setVestiging(vestiging1);
            double leveringskosten = d.getVestiging(takeaway1, vestiging1).getLeveringskosten();
            double menuprijs1 = 0.0;
            for (Orderverwerking o : besteldeProductenMenu) {
                menuprijs1 += o.getHoeveelheid() * o.getPrijs();
                String takeaway2 = o.getTakeawayNaam();
                String vestiging2 = o.getVestigingsID();
                this.setTakeawayNaam(takeaway2);
                this.setVestiging(vestiging2);
            }
            if (menuprijs1 >= 20.0) {
                this.setMenuprijs(menuprijs1);

            } else {
                menuprijs1 += leveringskosten;
                this.setMenuprijs(menuprijs1);
            }
        }
    }

    public double berekenOrderprijs(ArrayList<Menu> berekendeMenus) {
        double totaalprijs = 0.0;
        for (Menu m : berekendeMenus) {
            totaalprijs += m.getMenuprijs();
        }
        return totaalprijs;
    }

    private double gecumuleerdPercentageKortingOpOrderprijs(ArrayList<Korting> kortingen, Order orderZonderKorting) {
        double orderprijs = orderZonderKorting.getTotaalPrijs();
        double gecumuleerdPercentageOpOrderprijs = 0;
        for (Korting k : kortingen) {
            if (k instanceof RegistratieKorting) {
                RegistratieKorting reg = (RegistratieKorting) k;
                gecumuleerdPercentageOpOrderprijs += reg.getBedrag() / orderprijs;
            } else if (k instanceof ReviewKorting) {
                ReviewKorting rev = (ReviewKorting) k;
                gecumuleerdPercentageOpOrderprijs += rev.getPercentage();
            } else if (k instanceof TakeawayBoss) {
                TakeawayBoss tab = (TakeawayBoss) k;
                gecumuleerdPercentageOpOrderprijs += tab.getPercentage();
            } else if (k instanceof JustFeedBoss) {
                JustFeedBoss jfb = (JustFeedBoss) k;
                gecumuleerdPercentageOpOrderprijs += jfb.getPercentage();
            }
        }
        return gecumuleerdPercentageOpOrderprijs;

    }

    private double gecumuleerdPercentageKortingOpMenuprijs(ArrayList<Korting> kortingen, Order orderZonderKorting, ArrayList<Menu> berekendeMenus) {
        double orderprijs = orderZonderKorting.getTotaalPrijs();
        double gecumuleerdPercentageOpOrderprijs = 0;

        for (Korting k : kortingen) {

            if (k instanceof UniekeActieEenmalig) {
                UniekeActieEenmalig uae = (UniekeActieEenmalig) k;
                for (Menu m : berekendeMenus) {
                    if ((m.getTakeawayNaam().equalsIgnoreCase(uae.getTakeawayNaam())) && (m.getVestiging().equalsIgnoreCase(uae.getVestiging()))) {
                        if (uae.getBedrag() == 0) {
                            gecumuleerdPercentageOpOrderprijs += (uae.getPercentage() * m.menuprijs) / orderprijs;
                        } else {
                            gecumuleerdPercentageOpOrderprijs += uae.getBedrag() / orderprijs;
                        }
                    }
                }

            } else if (k instanceof UniekeActiePeriode) {
                UniekeActiePeriode uap = (UniekeActiePeriode) k;
                for (Menu m : berekendeMenus) {
                    if ((m.getTakeawayNaam().equalsIgnoreCase(uap.getTakeawayNaam())) && (m.getVestiging().equalsIgnoreCase(uap.getVestiging()))) {
                        if (uap.getBedrag() == 0) {
                            gecumuleerdPercentageOpOrderprijs += (uap.getPercentage() * m.menuprijs) / orderprijs;
                        } else {
                            gecumuleerdPercentageOpOrderprijs += uap.getBedrag() / orderprijs;
                        }
                    }
                }
            }
        }
        return gecumuleerdPercentageOpOrderprijs;

    }

    private void toepassenUniekePeriodiekeKortingen(ArrayList<Korting> kortingen, ArrayList<Menu> berekendeMenus, Klant kl) {
        Database d = new Database();
        for (Korting k : kortingen) {
            if (k instanceof UniekeActiePeriode) {
                UniekeActiePeriode uap = (UniekeActiePeriode) k;
                int code = uap.getKortingscode();
                for (Menu menu : berekendeMenus) {
                    if (d.kortingPeriodeBruikbaarBijMenu(code, menu, kl)) {

                        if (d.getKortingEenmaligPeriode(code).getBedrag() == 0) {
                            double korting = d.getKortingEenmaligPeriode(code).getPercentage() * menu.getMenuprijs();
                            menu.setMenuprijs(menu.getMenuprijs() - korting);
                        } else {
                            menu.setMenuprijs(menuprijs - d.getKortingEenmaligPeriode(code).getBedrag());
                        }
                    }
                }
            }
        }
    }

    private void toepassenUniekeEenmaligeKortingen(ArrayList<Korting> kortingen, ArrayList<Menu> berekendeMenus, Klant kl) {
        Database d = new Database();
        for (Korting k : kortingen) {
            if (k instanceof UniekeActieEenmalig) {
                UniekeActieEenmalig uae = (UniekeActieEenmalig) k;
                int code = uae.getKortingscode();
                for (Menu menu : berekendeMenus) {
                    if (d.kortingEenmaligBruikbaarBijMenu(code, menu, kl)) {
                        if (d.getKortingEenmaligUniek(code).getBedrag() == 0) {
                            double korting = d.getKortingEenmaligUniek(code).getPercentage() * menu.getMenuprijs();
                            menu.setMenuprijs(menu.getMenuprijs() - korting);
                            menu.setMenuprijs(menuprijs * (1 - d.getKortingEenmaligUniek(code).getPercentage()));
                        } else {
                            menu.setMenuprijs(menuprijs - d.getKortingEenmaligUniek(code).getBedrag());
                        }
                    }
                }
            }
        }
    }

    public void toepassenDefinitieveKortingen(ArrayList<Korting> kortingen, Order orderZonderKorting, Order orderMetKorting, Klant kl, ArrayList<Menu> berekendeMenus, ArrayList<HulpKorting> hulpKorting)// arraylist hulpkorting initialiseren en wij moeten die dan setten,LIESELOTTE MOET DEFAULT VAN ORDERMETKORTING AANMAKEN EN WIJ DAN SETTEN
    {
        double gecumuleerdPercentageKortingOpOrderprijs = this.gecumuleerdPercentageKortingOpOrderprijs(kortingen, orderZonderKorting);
        double gecumuleerdPercentageKortingOpMenuprijs = this.gecumuleerdPercentageKortingOpMenuprijs(kortingen, orderZonderKorting, berekendeMenus);
        double totaalGecumuleerdPercentage = gecumuleerdPercentageKortingOpMenuprijs + gecumuleerdPercentageKortingOpOrderprijs;
        if (totaalGecumuleerdPercentage <= 0.50) {
            toepassenUniekeEenmaligeKortingen(kortingen, berekendeMenus, kl);
            toepassenUniekePeriodiekeKortingen(kortingen, berekendeMenus, kl);
            orderMetKorting.setTotaalPrijs(berekenOrderprijs(berekendeMenus));
            double orderprijsMetKortingenOpOrderprijs = orderMetKorting.getTotaalPrijs() * (1 - gecumuleerdPercentageKortingOpOrderprijs);
            for (Menu m : berekendeMenus) {
                double nieuweMenu = m.getMenuprijs() * (1 - gecumuleerdPercentageKortingOpOrderprijs);
                double hulpkorting = m.getMenuprijs() * gecumuleerdPercentageKortingOpOrderprijs;
                m.setMenuprijs(nieuweMenu);
                hulpKorting.add(new HulpKorting(m.getTakeawayNaam(), hulpkorting));
            }

            orderMetKorting.setTotaalPrijs(orderprijsMetKortingenOpOrderprijs);
        } else {
            toepassenUniekeEenmaligeKortingen(kortingen, berekendeMenus, kl);
            toepassenUniekePeriodiekeKortingen(kortingen, berekendeMenus, kl);
            double aangepastGecumuleerdPercentageKortingOpOrderprijs = 0.50 - gecumuleerdPercentageKortingOpMenuprijs;
            orderMetKorting.setTotaalPrijs(berekenOrderprijs(berekendeMenus));
            double orderprijsMetKortingenOpOrderprijs = orderMetKorting.getTotaalPrijs() * (1 - aangepastGecumuleerdPercentageKortingOpOrderprijs);
            for (Menu m : berekendeMenus) {
                double nieuweMenu = m.getMenuprijs() * (1 - aangepastGecumuleerdPercentageKortingOpOrderprijs);
                double hulpkorting = m.getMenuprijs() * aangepastGecumuleerdPercentageKortingOpOrderprijs;
                m.setMenuprijs(nieuweMenu);

                hulpKorting.add(new HulpKorting(m.getTakeawayNaam(), hulpkorting));
            }
            orderMetKorting.setTotaalPrijs(orderprijsMetKortingenOpOrderprijs);
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

    public String toString() {
        String result;
        result = "\t MenuID:\t" + this.getMenuID() + "\n";
        result += "\t Menuprijs:\t" + this.getMenuprijs() + "\n";
        result += "\t orderID:\t" + this.getOrderID() + "\n";
        result += "\t Takeaway:\t" + this.getTakeawayNaam() + "\n";
        result += "\t Vestiging:\t" + this.getVestiging() + "\n";
        result += "\n";
        return result;
    }

}
