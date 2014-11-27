package Database;

import Logica.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Database {

    private Connection dbConnection = null;

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String protocol = "jdbc";
            String subProtocol = "mysql";
            String subName = "//mysqlha2.ugent.be/" + "BINFG01"
                    + "?user=" + "BINFG01"
                    + "&password=" + "iWu3mxUN";

            String URL = protocol + ":" + subProtocol + ":" + subName;

            dbConnection = DriverManager.getConnection(URL);

            return dbConnection;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            try {
                dbConnection.close();
            } catch (Exception e) {
            }
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            try {
                dbConnection.close();
            } catch (Exception e) {
            }
            return null;
        }
    }

    public void closeConnection() {
        try {
            dbConnection.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            try {
                dbConnection.close();
            } catch (Exception e) {
            }
        }
    }

    public ResultSet getData(String opdracht) {

        ResultSet srs = null;

        try {
            dbConnection = getConnection();

            Statement stmt = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = opdracht;
            srs = stmt.executeQuery(sql);

            return srs;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return srs;
        }
    }

    //GEGEVENS -> TABEL
    public DefaultTableModel naarTabel(String sql) {

        Database db = new Database();
        ResultSet rs = db.getData(sql);
        Vector<Vector<Object>> data = new Vector<>();
        Vector<String> kolommen = new Vector<>();

        try {
            ResultSetMetaData metaData = rs.getMetaData();
            // kolomnamen
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                kolommen.add(metaData.getColumnName(column));
            }
            // inhoud
            while (rs.next()) {
                Vector<Object> vector = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
        }
        return new DefaultTableModel(data, kolommen);
    }

    //VERSCHILLENDE CATEGORIEËN OPHALEN (om zoekencategorie zijn JList te vullen)
    public DefaultComboBoxModel initialiseerCombobox(String sql, String kolomnaam) {
        try {
            ResultSet srs = getData(sql);
            if (srs.next()) {
                Vector<String> vector = new Vector<>();
                while (srs.next()) {
                    vector.add(srs.getString(kolomnaam));
                }
                Object[] objArray = vector.toArray();
                return new DefaultComboBoxModel(objArray);
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //METHODES IVM KLANT
    public Boolean loginBestaat(String login) {
        try {
            String sql = "SELECT * FROM tbl_klant WHERE login = '" + login + "';";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public String ophalenPaswoord(String login) {
        try {
            String sql = "SELECT paswoord FROM tbl_klant WHERE login = '" + login + "';";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                String paswoord = srs.getString("paswoord");
                this.closeConnection();
                return paswoord;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public Boolean emailBestaat(String email) {
        try {
            String sql = "SELECT * FROM tbl_klant WHERE email = '" + email + "';";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public void addKlant(Klant kl) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_klant VALUES ('" + kl.getLogin() + "', '" + kl.getPaswoord() + "', '" + kl.getEmail() + "','" + kl.getNaam() + "','" + kl.getVoornaam() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void deleteKlant(Klant kl) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from tbl_klant WHERE login = '" + kl.getLogin() + "';");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void updateKlant(Klant oud, Klant nieuw) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_klant SET paswoord = '" + nieuw.getPaswoord() + "' WHERE login = '" + oud.getLogin() + "';");
            stmt.executeUpdate("UPDATE tbl_klant SET email = '" + nieuw.getEmail() + "' WHERE login = '" + oud.getLogin() + "';");
            stmt.executeUpdate("UPDATE tbl_klant SET naam = '" + nieuw.getNaam() + "' WHERE login = '" + oud.getLogin() + "';");
            stmt.executeUpdate("UPDATE tbl_klant SET voornaam = '" + nieuw.getVoornaam() + "' WHERE login = '" + oud.getLogin() + "';");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public Klant getKlant(String login) {
        try {
            String sql = "SELECT * FROM tbl_klant WHERE login = '" + login + "';";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                String login1 = srs.getString("login");
                String paswoord = srs.getString("paswoord");
                String email = srs.getString("email");
                String naam = srs.getString("naam");
                String voornaam = srs.getString("voornaam");
                Klant kl = new Klant(login1, paswoord, email, naam, voornaam);
                this.closeConnection();
                return kl;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public ArrayList<Klant> getAlleKlanten() {
        try {
            ArrayList<Klant> alleKlanten = new ArrayList<>();
            String sql = "SELECT * FROM tbl_klant;";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                String login = srs.getString("login");
                String paswoord = srs.getString("paswoord");
                String email = srs.getString("email");
                String naam = srs.getString("naam");
                String voornaam = srs.getString("voornaam");

                Klant kl = new Klant(login, paswoord, email, naam, voornaam);
                alleKlanten.add(kl);
            }
            this.closeConnection();
            return alleKlanten;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //METHODES IVM TAKE-AWAY
    public Boolean take_AwayBestaat(String takeaway) {
        try {
            String sql = "SELECT * FROM tbl_takeaway WHERE naam = '" + takeaway + "';";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public Boolean emailBestaatTakeaway(String email) {
        try {
            String sql = "SELECT * FROM tbl_takeaway WHERE email = '" + email + "';";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public void addTake_Away(Take_Away tw) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_takeaway VALUES ('" + tw.getNaam() + "','" + tw.getEmail() + "',0);");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void deleteTake_Away(Take_Away tw) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from tbl_takeaway WHERE naam = '" + tw.getNaam() + "';");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void updateTake_Away(Take_Away oud, Take_Away nieuw) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_takeaway SET email = '" + nieuw.getEmail() + "' WHERE naam = '" + oud.getNaam() + "'");
            stmt.executeUpdate("UPDATE tbl_takeaway SET naam = '" + nieuw.getNaam() + "' WHERE naam = '" + oud.getNaam() + "'");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void updateCommissieTake_Away(Take_Away tw) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_takeaway SET commissie = '" + tw.getCommissie() + "' WHERE naam = '" + tw.getNaam() + "';");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public Take_Away getTakeaway(String naam) {
        try {
            ArrayList<String> categorieen = new ArrayList<>();
            String sql = "SELECT * FROM tbl_takeaway T,tbl_soort S WHERE (T.naam=S.naam) and (T.naam = '" + naam + "');";
            ResultSet srs = getData(sql);
            String email = srs.getString("email");
            double commissie = srs.getDouble("commissie");
            while (srs.next()) {
                String categorie = srs.getString("categorie");
                categorieen.add(categorie);
            }
            Take_Away ta = new Take_Away(naam, categorieen, email, commissie);
            this.closeConnection();
            return ta;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public ArrayList<Take_Away> getAlleTakeaways() {
        try {
            ArrayList<Take_Away> alleTakeaways = new ArrayList<>();
            String sql = "SELECT * FROM tbl_takeaway;";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                String naam = srs.getString("naam");
                String email = srs.getString("email");
                double commissie = srs.getDouble("commissie");
                Take_Away ta = new Take_Away(naam, email, commissie);
                alleTakeaways.add(ta);
            }
            this.closeConnection();
            return alleTakeaways;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public void addCategorieFromTake_Away(String cat, Take_Away tw) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_soort VALUES ('" + cat + "', '" + tw.getNaam() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void deleteCategorieFromTake_Away(String cat, Take_Away tw) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from tbl_soort WHERE (naam = '" + tw.getNaam() + "') and (categorie ='" + cat + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    // FUNCTIES VOOR VESTIGING
    public Boolean bestaatVestiging(String vestigingsID, String takeawayNaam) {
        try {
            String sql = "SELECT * FROM tbl_vestigingen WHERE (vestigingsID = '" + vestigingsID + "') and (naam = '" + takeawayNaam + "');";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public void addVestiging(Vestiging v) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_vestigingen VALUES ('" + v.getVestigingsID() + "', '" + v.getTakeawayNaam() + "', " + v.getLeveringskosten() + ",'" + v.getStraat() + "', " + v.getHuisnummer() + "," + v.getPlaatsnummer() + ");");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void deleteVestiging(Vestiging v) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE FROM tbl_vestigingen WHERE (vestigingsID = '" + v.getVestigingsID() + "') and (naam = '" + v.getTakeawayNaam() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();

        }
    }

    public void updateVestiging(Vestiging oud, Vestiging nieuw) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();

            stmt.executeUpdate("UPDATE tbl_vestigingen SET leveringskosten = '" + nieuw.getLeveringskosten() + "' WHERE (vestigingsID = '" + oud.getVestigingsID() + "') and (naam = '" + oud.getTakeawayNaam() + "'));");
            stmt.executeUpdate("UPDATE tbl_vestigingen SET straat = '" + nieuw.getStraat() + "' WHERE (vestigingsID = '" + oud.getVestigingsID() + "') and (naam = '" + oud.getTakeawayNaam() + "'));");
            stmt.executeUpdate("UPDATE tbl_vestigingen SET huisnummer = '" + nieuw.getHuisnummer() + "' WHERE (vestigingsID = '" + oud.getVestigingsID() + "') and (naam = '" + oud.getTakeawayNaam() + "'));");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public Vestiging getVestiging(String takeawayNaam, String vestigingsID) {
        try {
            ArrayList<Gemeente> leveringsgebied = new ArrayList<>();
            String sql = "SELECT * FROM tbl_vestigingen V, tbl_leveringsregio L WHERE (V.vestigingsID = L.vestigingsID)and (V.naam=L.naam) and(V.vestigingsID = '" + vestigingsID + "')and (V.naam='" + takeawayNaam + "');";
            ResultSet srs = getData(sql);
            double leveringskosten = srs.getDouble("leveringskosten");
            String straat = srs.getString("straat");
            int huisnummer = srs.getInt("huisnummer");
            int plaatsnummer = srs.getInt("plaatsnummer");
            while (srs.next()) {
                int plaatsnrLevering = srs.getInt("leveringsgebied");
                leveringsgebied.add(this.getCoordinaten(plaatsnrLevering));
            }
            Vestiging ves = new Vestiging(vestigingsID, takeawayNaam, straat, huisnummer, plaatsnummer, leveringskosten, leveringsgebied);
            this.closeConnection();
            return ves;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public ArrayList<Vestiging> getAlleVestigingen(String takeawayNaam) {
        try {
            ArrayList<Vestiging> alleVestigingen = new ArrayList<>();
            ArrayList<Gemeente> leveringsgebied = new ArrayList<>();
            String sql = "SELECT * FROM tbl_vestigingen WHERE and (naam = '" + takeawayNaam + "') ;";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                double leveringskosten = srs.getDouble("leveringskosten");
                String straat = srs.getString("straat");
                int huisnummer = srs.getInt("huisnummer");
                int plaatsnummer = srs.getInt("plaatsnummer");
                String vestigingsID = srs.getString("vestigingsID");

                String sql2 = "SELECT * FROM tbl_vestigingen V, tbl_leveringsregio L WHERE (V.naam = '" + takeawayNaam + "')and (V.vestigingsID = '" + vestigingsID + "') ;";
                ResultSet srs2 = getData(sql2);
                while (srs2.next()) {
                    leveringsgebied.clear();
                    int plaatsnrLevering = srs.getInt("leveringsgebied");
                    leveringsgebied.add(this.getCoordinaten(plaatsnrLevering));
                }
                Vestiging ves = new Vestiging(vestigingsID, takeawayNaam, straat, huisnummer, plaatsnummer, leveringskosten, leveringsgebied);
                alleVestigingen.add(ves);
            }
            this.closeConnection();
            return alleVestigingen;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //METHODES IVM PRODUCTEN
    public Boolean productBestaat(String product, String takeaway) {
        try {
            String sql = "SELECT * FROM tbl_product P,tbl_biedtAan B WHERE (P.productID=B.productID) and (B.naam = '" + takeaway + "') and (P.naam = '" + product + "');";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public Boolean productIDBestaat(int productID) {
        try {
            String sql = "SELECT * FROM tbl_product WHERE productID=" + productID + ";";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    private int getProductID() {
        try {
            String sql = "SELECT productID FROM tbl_product WHERE naam = 'dummyID';";
            ResultSet srs = getData(sql);
            srs.next();
            int id = srs.getInt("productID");
            this.closeConnection();
            return id;

        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return 0;
        }
    } //enkel gebruiken in de methode addProduct

    public void addProduct(Product prod, String takeawayNaam) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_product VALUES (null,'dummyID','null',0);");
            int id = this.getProductID();
            stmt.executeUpdate("UPDATE tbl_product SET type = '" + prod.getProducttype() + "' WHERE productID = " + id + ";");
            stmt.executeUpdate("UPDATE tbl_product SET eenheidsprijs = '" + prod.getEenheidsprijs() + "' WHERE productID = " + id + ";");
            stmt.executeUpdate("UPDATE tbl_product SET naam = '" + prod.getNaam() + "' WHERE productID = " + id + ";");
            stmt.executeUpdate("INSERT INTO tbl_biedtAan VALUES ('" + takeawayNaam + "'," + id + ");");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void deleteProduct(Product prod) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from tbl_product WHERE productID = '" + prod.getProductID() + "';");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void updateProduct(Product oud, Product nieuw) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_product SET type = '" + nieuw.getProducttype() + "' WHERE productID = " + oud.getProductID() + ";");
            stmt.executeUpdate("UPDATE tbl_product SET eenheidsprijs = '" + nieuw.getEenheidsprijs() + "' WHERE productID = " + oud.getProductID() + ";");
            stmt.executeUpdate("UPDATE tbl_product SET naam = '" + nieuw.getNaam() + "' WHERE productID = '" + oud.getProductID() + "';");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public Product getProduct(int productID) {
        try {
            String sql = "SELECT * FROM tbl_product WHERE (productID = " + productID + ");";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int productID1 = srs.getInt("productID");
                String naam = srs.getString("naam");
                String type = srs.getString("type");
                double prijs = srs.getDouble("eenheidsprijs");
                Product p = new Product(productID1, naam, type, prijs);
                this.closeConnection();
                return p;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public ArrayList<Product> getProductsOfTakeaway(String takeawayNaam) {
        try {
            ArrayList<Product> alleProducten = new ArrayList<>();
            String sql = "SELECT * FROM tbl_product P,tbl_biedtAan B WHERE (P.productID=B.productID) and (B.naam = '" + takeawayNaam + "');";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int productID = srs.getInt("productID");
                String naam = srs.getString("naam");
                String type = srs.getString("type");
                double prijs = srs.getDouble("eenheidsprijs");
                Product p = new Product(productID, naam, type, prijs);
                alleProducten.add(p);
            }
            this.closeConnection();
            return alleProducten;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //METHODES IVM KORTINGEN
   /* public ArrayList<UniekeActie> rapportKortingAlgemeen(String takeawayNaam) {
     ArrayList<UniekeActie> alleKortingen = new ArrayList<>();
     try {
     for (Vestiging ves : this.getAlleVestigingen(takeawayNaam)) {
     String vestiging = ves.getVestigingsID();
     String sql = "SELECT * FROM tbl_kortingEenmalig WHERE (naam='" + takeawayNaam + "') and (status=TRUE);";
     ResultSet srs = getData(sql);
     while (srs.next()) {
     int code = srs.getInt("kortingscode");
     double bedrag = srs.getDouble("bedrag");
     double percentage = srs.getDouble("percentage");
     String login = srs.getString("login");
     UniekeActieEenmalig uae = new UniekeActieEenmalig(code, vestiging, bedrag, percentage, login, takeawayNaam);
     alleKortingen.add(uae);
     }
     String sql2 = "SELECT * FROM tbl_kortingPeriode WHERE (naam='" + takeawayNaam + "') and (CURDATE() BETWEEN startdatum AND einddatum);";
     ResultSet srs2 = getData(sql2);
     while (srs2.next()) {
     int code2 = srs2.getInt("kortingscode");
     double bedrag2 = srs2.getDouble("bedrag");
     double percentage2 = srs2.getDouble("percentage");
     String login2 = srs2.getString("login");
     Date startdatum = srs2.getDate("startdatum");
     Date einddatum = srs2.getDate("einddatum");
     UniekeActiePeriode uap = new UniekeActiePeriode(startdatum, einddatum, code2, vestiging, bedrag2, percentage2, login2, takeawayNaam);
     alleKortingen.add(uap);
     }
     }
     this.closeConnection();
     return alleKortingen;
     } catch (SQLException sqle) {
     System.out.println("SQLException: " + sqle.getMessage());
     this.closeConnection();
     return null;
     }
     }*/
    // in schrijven naar document, eerst checken of ze algemeen schrijven of een vestiging, bij algemeen een TOSTRING VAN TAKEAWAY dan for(getallevest) et (toString vestiging,oproepen specifieke,toString van producten ) 
    public ArrayList<UniekeActie> rapportKortingSpecifiek(String takeawayNaam, String vestiging) {
        ArrayList<UniekeActie> alleKortingen = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbl_kortingEenmalig WHERE (naam='" + takeawayNaam + "') and (vestiging='" + vestiging + "') and (status=TRUE);";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int code = srs.getInt("kortingscode");
                double bedrag = srs.getDouble("bedrag");
                double percentage = srs.getDouble("percentage");
                String login = srs.getString("login");
                UniekeActieEenmalig uae = new UniekeActieEenmalig(code, vestiging, bedrag, percentage, login, takeawayNaam);
                alleKortingen.add(uae);
            }
            String sql2 = "SELECT * FROM tbl_kortingPeriode WHERE (naam='" + takeawayNaam + "') and (vestiging='" + vestiging + "') and (CURDATE() BETWEEN startdatum AND einddatum);";
            ResultSet srs2 = getData(sql2);
            while (srs2.next()) {
                int code2 = srs2.getInt("kortingscode");
                double bedrag2 = srs2.getDouble("bedrag");
                double percentage2 = srs2.getDouble("percentage");
                String login2 = srs2.getString("login");
                Date startdatum = srs2.getDate("startdatum");
                Date einddatum = srs2.getDate("einddatum");
                UniekeActiePeriode uap = new UniekeActiePeriode(startdatum, einddatum, code2, vestiging, bedrag2, percentage2, login2, takeawayNaam);
                alleKortingen.add(uap);
            }
            this.closeConnection();
            return alleKortingen;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //registratiekorting
    public void addKortingRegistratie(Klant kl) {
        RegistratieKorting reg = new RegistratieKorting();
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_kortingRegistratie VALUES (null," + reg.getBedrag() + "," + reg.isStatus() + ",'" + kl.getLogin() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public Boolean kortingRegistratieBestaat(int code, Klant kl) {
        try {
            String sql = "SELECT * FROM tbl_kortingRegistratie WHERE (kortingscode = " + code + ") and (login = '" + kl.getLogin() + "');";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public Boolean kortingRegistratieGeldig(int code, Klant kl) {
        try {
            String sql = "SELECT * FROM tbl_kortingRegistratie WHERE (kortingscode = " + code + ") and (status =TRUE);";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public void gebruiktKortingRegistratie(int code) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_kortingRegistratie SET status = FALSE WHERE kortingscode= " + code + ";");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public RegistratieKorting getKortingRegistratie(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingRegistratie WHERE (kortingscode = " + code + ");";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int kortingscode = srs.getInt("kortingscode");
                Boolean status = srs.getBoolean("status");
                String login = srs.getString("login");
                RegistratieKorting reg = new RegistratieKorting(kortingscode, status, login);
                this.closeConnection();
                return reg;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //registratiekorting
    public void addKortingReview(Klant kl) {
        ReviewKorting rev = new ReviewKorting();
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_kortingReview VALUES (null," + rev.getPercentage() + "," + rev.isStatus() + ",'" + kl.getLogin() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public Boolean kortingReviewBestaat(int code, Klant kl) {
        try {
            String sql = "SELECT * FROM tbl_kortingReview WHERE (kortingscode = " + code + ") and (login = '" + kl.getLogin() + "');";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public Boolean kortingReviewGeldig(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingReview WHERE (kortingscode = " + code + ")  and (status =TRUE);";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public void gebruiktKortingReview(int code) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_kortingReview SET status = FALSE WHERE kortingscode= " + code + ";");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public ReviewKorting getKortingReview(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingReview WHERE (kortingscode = " + code + ");";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int kortingscode = srs.getInt("kortingscode");
                Boolean status = srs.getBoolean("status");
                String login = srs.getString("login");
                ReviewKorting rev = new ReviewKorting(kortingscode, status, login);
                this.closeConnection();
                return rev;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //just-feed boss korting
    public void addKortingJustfeedBoss(String maand, int jaar) {
        Klant kl = this.bigSpenderAlgemeen(maand, jaar);
        JustFeedBoss jfb = new JustFeedBoss();
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_kortingJustfeed_boss VALUES (null," + jfb.getPercentage() + "," + jfb.isStatus() + ",'" + kl.getLogin() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public Boolean kortingJustfeedBossBestaat(int code, Klant kl) {
        try {
            String sql = "SELECT * FROM tbl_kortingJustfeed_boss WHERE (kortingscode = " + code + ") and (login = '" + kl.getLogin() + "') ;";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public Boolean kortingJustfeedBossGeldig(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingJustfeed_boss WHERE (kortingscode = " + code + ")  and (status =TRUE) ;";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public void gebruiktKortingJustfeedBoss(int code) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_kortingJustfeed_boss SET status = FALSE WHERE kortingscode= " + code + ";");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public JustFeedBoss getKortingJustfeedBoss(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingJustfeed_boss WHERE (kortingscode = " + code + ");";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int kortingscode = srs.getInt("kortingscode");
                Boolean status = srs.getBoolean("status");
                String login = srs.getString("login");
                JustFeedBoss jfb = new JustFeedBoss(kortingscode, status, login);
                this.closeConnection();
                return jfb;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    private Klant bigSpenderAlgemeen(String maand, int jaar) {
        ArrayList<SorteerKorting> uitgavenKlant = new ArrayList<>();
        String start = DatumFinder.getEersteDag(maand, jaar);
        String eind = DatumFinder.getLaatsteDag(maand, jaar);
        try {
            for (Klant kl : this.getAlleKlanten()) {

                String sql = "SELECT SUM(totaalprijs) AS gecumuleerdBedrag FROM tbl_order WHERE (login = '" + kl.getLogin() + "') and (datum BETWEEN STR_TO_DATE('" + start + "','%m,%d,%Y') AND STR_TO_DATE('" + eind + "','%m,%d,%Y'));";
                ResultSet srs = getData(sql);
                if (srs.next()) {
                    String login = kl.getLogin();
                    double gecumuleerd = srs.getDouble("gecumuleerdBedrag");
                    uitgavenKlant.add(new SorteerKorting(login, gecumuleerd));
                }
            }
            this.closeConnection();
            Collections.sort(uitgavenKlant);
            Klant bigSpender = new Klant(uitgavenKlant.get(0).getLogin());
            return bigSpender;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }

    }

    //takeaway boss korting
    public void addKortingTakeawayBoss(String maand, int jaar) {
        ArrayList<Take_Away> takeaways = this.getAlleTakeaways();
        TakeawayBoss tab = new TakeawayBoss();
        for (Take_Away ta : takeaways) {
            Klant kl = this.bigSpenderTakeaway(maand, jaar, ta.getNaam());
            try {
                dbConnection = getConnection();
                Statement stmt = dbConnection.createStatement();
                stmt.executeUpdate("INSERT INTO tbl_kortingTakeaway_boss VALUES (null," + tab.getPercentage() + "," + tab.isStatus() + ",'" + kl.getLogin() + "');");
                this.closeConnection();
            } catch (SQLException sqle) {
                System.out.println("SQLException: " + sqle.getMessage());
                this.closeConnection();
            }
        }
    }

    public Boolean kortingTakeawayBossBestaat(int code, Klant kl) {
        try {
            String sql = "SELECT * FROM tbl_kortingTakeaway_boss WHERE (kortingscode = " + code + ") and (login = '" + kl.getLogin() + "') ;";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public Boolean kortingTakeawayBossGeldig(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingTakeaway_boss WHERE (kortingscode = " + code + ") and (status =TRUE);";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public void gebruiktKortingTakeawayBoss(int code) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_kortingTakeaway_boss SET status = FALSE WHERE kortingscode= " + code + ";");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public TakeawayBoss getKortingTakeawayBoss(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingTakeaway_boss WHERE (kortingscode = " + code + ");";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int kortingscode = srs.getInt("kortingscode");
                Boolean status = srs.getBoolean("status");
                String login = srs.getString("login");
                TakeawayBoss tab = new TakeawayBoss(kortingscode, status, login);
                this.closeConnection();
                return tab;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    private Klant bigSpenderTakeaway(String maand, int jaar, String takeawayNaam) {
        ArrayList<SorteerKorting> uitgavenKlant = new ArrayList<>();
        String start = DatumFinder.getEersteDag(maand, jaar);
        String eind = DatumFinder.getLaatsteDag(maand, jaar);
        try {
            for (Klant kl : this.getAlleKlanten()) {

                String sql = "SELECT SUM(totaalprijs) AS gecumuleerdBedrag FROM tbl_menu M,tbl_order O WHERE (M.orderID=O.orderID) and (O.login = '" + kl.getLogin() + "')and(M.takeaway='" + takeawayNaam + "') and (O.datum BETWEEN STR_TO_DATE('" + start + "','%m,%d,%Y') AND STR_TO_DATE('" + eind + "','%m,%d,%Y'));";
                ResultSet srs = getData(sql);
                if (srs.next()) {
                    String login = kl.getLogin();
                    double gecumuleerd = srs.getDouble("gecumuleerdBedrag");
                    uitgavenKlant.add(new SorteerKorting(login, gecumuleerd));
                }
            }
            this.closeConnection();
            Collections.sort(uitgavenKlant);
            Klant bigSpender = new Klant(uitgavenKlant.get(0).getLogin());
            return bigSpender;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }

    }

    //eenmalige unieke korting
    public void addKortingEenmaligUniek(UniekeActieEenmalig eenmalig) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Klant kl : this.getAlleKlanten()) {
                stmt.executeUpdate("INSERT INTO tbl_kortingEenmalig VALUES (null," + eenmalig.getBedrag() + "," + eenmalig.getPercentage() + ",'" + eenmalig.getVestiging() + "','" + eenmalig.getTakeawayNaam() + "'," + eenmalig.isStatus() + ",'" + kl.getLogin() + "');");
            }
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public Boolean kortingEenmaligUniekBestaat(int code, String vestiging, String takeawayNaam, Klant kl) {
        try {
            String sql = "SELECT * FROM tbl_kortingEenmalig WHERE (kortingscode = " + code + ") and (vestiging = '" + vestiging + "') and (naam = '" + takeawayNaam + "')and (login = '" + kl.getLogin() + "') ;";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public Boolean kortingEenmaligUniekGeldig(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingEenmalig WHERE (kortingscode = " + code + ")and (status=TRUE);";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public void gebruiktKortingEenmaligUniek(int code) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_kortingEenmalig SET status = FALSE WHERE kortingscode= " + code + ";");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public UniekeActieEenmalig getKortingEenmaligUniek(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingEenmalig WHERE (kortingscode = " + code + ");";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int kortingscode = srs.getInt("kortingscode");
                Boolean status = srs.getBoolean("status");
                String login = srs.getString("login");
                String vestiging = srs.getString("vestiging");
                String takeawayNaam = srs.getString("naam");
                double bedrag = srs.getDouble("bedrag");
                double percentage = srs.getDouble("percentage");
                UniekeActieEenmalig eenmalig = new UniekeActieEenmalig(status, kortingscode, vestiging, bedrag, percentage, login, takeawayNaam);
                this.closeConnection();
                return eenmalig;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //periodieke unieke korting
    public void addKortingEenmaligPeriode(UniekeActiePeriode periode) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Klant kl : this.getAlleKlanten()) {
                stmt.executeUpdate("INSERT INTO tbl_kortingPeriode VALUES (null," + periode.getBedrag() + "," + periode.getPercentage() + ",'" + periode.getVestiging() + "','" + periode.getTakeawayNaam() + "','" + periode.getStartdatum() + "','" + periode.getEinddatum() + "','" + kl.getLogin() + "');");
            }
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public Boolean kortingEenmaligPeriodeBestaat(int code, String vestiging, String takeawayNaam, Klant kl) {
        try {
            String sql = "SELECT * FROM tbl_kortingPeriode WHERE kortingscode = (kortingscode = '" + code + "') and (vestiging = '" + vestiging + "') and (naam = '" + takeawayNaam + "')and (login = '" + kl.getLogin() + "');";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public Boolean kortingEenmaligPeriodeGeldig(int code, Date orderdatum) {
        try {
            String sql = "SELECT * FROM tbl_kortingPeriode WHERE (kortingscode = " + code + ")and ('" + orderdatum + "' BETWEEN '" + this.getKortingEenmaligPeriode(code).getStartdatum() + "' AND'" + this.getKortingEenmaligPeriode(code).getEinddatum() + "');";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                this.closeConnection();
                return true;
            } else {
                this.closeConnection();
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }

    public UniekeActiePeriode getKortingEenmaligPeriode(int code) {
        try {
            String sql = "SELECT * FROM tbl_kortingEenmalig WHERE (kortingscode = " + code + ");";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int kortingscode = srs.getInt("kortingscode");
                Date startdatum = srs.getDate("startdatum");
                Date einddatum = srs.getDate("einddatum");
                String login = srs.getString("login");
                String vestiging = srs.getString("vestiging");
                String takeawayNaam = srs.getString("naam");
                double bedrag = srs.getDouble("bedrag");
                double percentage = srs.getDouble("percentage");
                UniekeActiePeriode periode = new UniekeActiePeriode(startdatum, einddatum, kortingscode, vestiging, bedrag, percentage, login, takeawayNaam);
                this.closeConnection();
                return periode;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //METHODES IVM REVIEWS
    public void aanmakenReview(Klant kl, int productId, Date orderdatum) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_review VALUES (null,0,'" + kl.getLogin() + "'," + productId + ",TRUE,'geen beoordeling','" + orderdatum + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void invullenReview(Klant kl, Review rev) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_review SET score = " + rev.getScore() + " WHERE reviewID= " + rev.getReviewId() + ";");
            stmt.executeUpdate("UPDATE tbl_review SET status = FALSE WHERE reviewID= " + rev.getReviewId() + ";");
            stmt.executeUpdate("UPDATE tbl_review SET beoordeling = " + rev.getBeoordeling() + " WHERE reviewID= " + rev.getReviewId() + ";");
            this.addKortingReview(kl);
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void deleteReview(Klant kl) {
        ArrayList<Review> reviewsPerKlant = this.getReviews(kl);
        for (Review rev : reviewsPerKlant) {
            if (rev.isStatus()) {
                try {
                    String sql = "SELECT startdatum FROM tbl_review WHERE (reviewID = " + rev.getReviewId() + ");";
                    ResultSet srs = getData(sql);
                    Date datum = srs.getDate("startdatum");
                    dbConnection = getConnection();
                    Statement stmt = dbConnection.createStatement();
                    stmt.executeUpdate("DELETE from tbl_review WHERE (reviewID = '" + rev.getReviewId() + "') and ((DATEDIFF(CURDATE(),'" + datum + "'))>7);");
                    this.closeConnection();
                } catch (SQLException sqle) {
                    System.out.println("SQLException: " + sqle.getMessage());
                    this.closeConnection();
                }
            }
        }
    }

    public Review getReview(int reviewID) {
        try {
            String sql = "SELECT * FROM tbl_review WHERE (reviewID = " + reviewID + ");";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int reviewID1 = srs.getInt("reviewID");
                double score = srs.getDouble("score");
                String login = srs.getString("login");
                int productID = srs.getInt("productID");
                Boolean status = srs.getBoolean("status");
                String beoordeling = srs.getString("beoordeling");
                Date startdatum = srs.getDate("startdatum");
                Review review = new Review(reviewID1, score, login, productID, status, beoordeling, startdatum);
                this.closeConnection();
                return review;
            } else {
                this.closeConnection();
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public ArrayList<Review> getReviews(int productID) {
        try {
            ArrayList<Review> reviews = new ArrayList<>();
            String sql = "SELECT * FROM tbl_review WHERE (productID=" + productID + ") and (status=FALSE);";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int reviewID = srs.getInt("reviewID");
                double score = srs.getDouble("score");
                String beoordeling = srs.getString("beoordeling");
                Review r = new Review(reviewID, score, beoordeling);
                reviews.add(r);
            }
            this.closeConnection();
            return reviews;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public ArrayList<Review> getReviews(Klant kl) {
        try {
            ArrayList<Review> reviews = new ArrayList<>();
            String sql = "SELECT * FROM tbl_review WHERE (login='" + kl.getLogin() + "') and (status=FALSE);";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int reviewID = srs.getInt("reviewID");
                double score = srs.getDouble("score");
                String beoordeling = srs.getString("beoordeling");
                int productID = srs.getInt("productID");
                Review r = new Review(reviewID, score, productID, beoordeling);
                reviews.add(r);
            }
            this.closeConnection();
            return reviews;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //METHODE OPHALEN PLAATSNUMMERS OP BASIS VAN GEMEENTE EN POSTCODE
    public int getPlaatsnummer(String gemeente, int postcode) {
        try {
            String sql = "SELECT plaatsnummer FROM tbl_gemeente WHERE (plaatsnaam = '" + gemeente + "') and(postcode = " + postcode + ");";
            ResultSet srs = getData(sql);
            srs.next();
            int plaatsnummer = srs.getInt("plaatsnummer");
            this.closeConnection();
            return plaatsnummer;

        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return 0;
        }
    }

    public Gemeente getCoordinaten(int plaatsnummer) {
        try {
            String sql = "SELECT * FROM tbl_gemeente WHERE (plaatsnummer = " + plaatsnummer + ");";
            ResultSet srs = getData(sql);
            srs.next();
            int postcode = srs.getInt("postcode");
            String gemeente = srs.getString("plaatsnaam");
            this.closeConnection();
            Gemeente gem = new Gemeente(gemeente, postcode);
            return gem;

        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //METHODES IVM AWARDS
    // bestseller   
    public void addAwardBestseller(String maand, int jaar) {
        try {
            Bestseller bs = this.findBestseller(maand, jaar);
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE FROM tbl_awardBestseller;");
            stmt.executeUpdate("INSERT INTO tbl_awardBestseller VALUES (null," + bs.getMaand() + ",'" + bs.getAantalMenus() + "','" + bs.getTakeawayNaam() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    private Bestseller findBestseller(String maand, int jaar) {
        ArrayList<Bestseller> aantalMenusPerTakeaway = new ArrayList<>();
        String start = DatumFinder.getEersteDag(maand, jaar);
        String eind = DatumFinder.getLaatsteDag(maand, jaar);
        try {
            for (Take_Away ta : this.getAlleTakeaways()) {

                String sql = "SELECT COUNT(*) AS aantalMenus FROM tbl_menu M,tbl_order O WHERE (M.orderID=O.orderID) and (M.takeaway='" + ta.getNaam() + "') and (O.datum BETWEEN STR_TO_DATE('" + start + "','%m,%d,%Y') AND STR_TO_DATE('" + eind + "','%m,%d,%Y'));";
                ResultSet srs = getData(sql);
                if (srs.next()) {
                    String takeaway = ta.getNaam();
                    int totaalMenus = srs.getInt("aantalMenus");
                    aantalMenusPerTakeaway.add(new Bestseller(totaalMenus, takeaway));
                }
            }
            this.closeConnection();
            Collections.sort(aantalMenusPerTakeaway);
            Bestseller bestseller = new Bestseller(maand, aantalMenusPerTakeaway.get(0).getAantalMenus(), aantalMenusPerTakeaway.get(0).getTakeawayNaam());
            return bestseller;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }

    }

    //hot item
    public void addAwardHotItem(String maand, int jaar) {
        try {

            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE FROM tbl_awardHotitem;");
            //  stmt.executeUpdate("INSERT INTO tbl_awardHotitem VALUES (null," 0 ",maand,'" + h + "','" + hi.getProductID() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    // just feeder   
    public void addAwardJustFeeder(String maand) {
        try {
            Just_Feeder jf = this.findJustfeeder(maand);
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE FROM tbl_awardJustfeeder;");
            stmt.executeUpdate("INSERT INTO tbl_awardJustfeeder VALUES (null,'" + jf.getMaand() + "'," + jf.getCommissie() + ",'" + jf.getTakeawayNaam() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    private Just_Feeder findJustfeeder(String maand) {
        double hoogsteCommissie = 0;
        String takeaway = null;
        try {
            String sql = "SELECT MAX(commissie) AS hoogsteCommissie FROM tbl_takeaway;";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                hoogsteCommissie = srs.getDouble("hoogsteCommissie");
            }
            String sql2 = "SELECT * FROM tbl_takeaway WHERE commissie=" + hoogsteCommissie + ";";
            ResultSet srs2 = getData(sql2);
            if (srs2.next()) {
                takeaway = srs2.getString("naam");
            }
            this.closeConnection();
            Just_Feeder jf = new Just_Feeder(maand, hoogsteCommissie, takeaway);
            return jf;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    // users choice
    public void addAwardUsersChoice(String maand) {
        try {
            Users_Choice uc = this.findUsersChoice(maand);
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE FROM tbl_awardUserschoice;");
            stmt.executeUpdate("INSERT INTO tbl_awardUserschoice VALUES (null,'" + uc.getMaand() + "','" + uc.getBeoordeling() + "','" + uc.getTakeawayNaam() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    private Users_Choice findUsersChoice(String maand) {
        ArrayList<Users_Choice> scorePerTakeaway = new ArrayList<>();
        try {
            for (Take_Away ta : this.getAlleTakeaways()) {

                String sql = "SELECT AVG(score) AS avgReview FROM tbl_review R,tbl_biedtAan B WHERE (R.productID=B.productID) and (B.naam='" + ta.getNaam() + "') and(R.status=FALSE) and ((SELECT COUNT(*) AS aantalReviews FROM tbl_review R,tbl_biedtAan B WHERE (R.productID=B.productID) and (B.naam='" + ta.getNaam() + "') and(R.status=FALSE))>=3);";
                ResultSet srs = getData(sql);
                if (srs.next()) {
                    String takeaway = ta.getNaam();
                    int avgReview = srs.getInt("avgReview");
                    scorePerTakeaway.add(new Users_Choice(avgReview, takeaway));
                }
            }
            this.closeConnection();
            Collections.sort(scorePerTakeaway);
            Users_Choice usersChoice = new Users_Choice(maand, scorePerTakeaway.get(0).getBeoordeling(), scorePerTakeaway.get(0).getTakeawayNaam());
            return usersChoice;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //METHODES IVM ORDERS
    //METHODES IVM MENU'S
}
/*
 Zoeken product:
 methode nodig die zoekt of productnaam wel bestaat in hele database (dus niet zoals productbestaat nu dat checkt of takeaway bepaald product heeft)

 Zoeken product:
 klant geeft take-awaynaam in -> take-aways uit tbl biedtAan halen met deze naam -> de producttupels van de tbl product eruithalen die overeenkomen met deze naam
 getVestigingsID nodig die vestigingsID ophaalt van bepaalde vestiging
 kortingEenmaligUniekBestaat om na te gaan of ze al geen bestaande unieke actie kortingscode willen toevoegen*/
