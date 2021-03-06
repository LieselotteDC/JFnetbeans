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

    MailingClass mc = new MailingClass();

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

    public DefaultTableModel naarTabel2(String sql) {

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
            kolommen.add("hoeveelheid");
            // inhoud
            while (rs.next()) {
                Vector<Object> vector = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                vector.add("");
                data.add(vector);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
        }
        return new DefaultTableModel(data, kolommen);
    }

    public String bestelFormulier(String sql, String kolomnaam) {
        try {
            ResultSet srs = getData(sql);
            if (srs.next()) {
                String add = srs.getString(kolomnaam);
                return add;
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

    //VERSCHILLENDE CATEGORIEËN OPHALEN (om zoekencategorie zijn JList te vullen)
    public DefaultComboBoxModel initialiseerCombobox(String sql, String kolomnaam) {
        try {
            ResultSet srs = getData(sql);
            if (srs.next()) {
                Vector<String> vector = new Vector<>();
                srs.previous();
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

    public Boolean heeftTakeawayAlVestiging(String takeaway) {
        try {
            String sql = "SELECT COUNT(*) AS aantal FROM tbl_vestigingen WHERE naam = '" + takeaway + "';";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int aantal = srs.getInt("aantal");
                if (aantal == 0) {
                    this.closeConnection();
                    return false;
                } else {
                    this.closeConnection();
                    return true;
                }
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
            stmt.executeUpdate("INSERT INTO tbl_hulpkorting VALUES ('" + tw.getNaam() + "',0);");
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
            stmt.executeUpdate("UPDATE tbl_takeaway SET commissie = " + tw.getCommissie() + " WHERE naam = '" + tw.getNaam() + "';");
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
            if (srs.next()) {
                String email = srs.getString("email");
                double commissie = srs.getDouble("commissie");
                String categorie = srs.getString("categorie");
                categorieen.add(categorie);
                while (srs.next()) {
                    String categorie1 = srs.getString("categorie");
                    categorieen.add(categorie1);
                }
                Take_Away ta = new Take_Away(naam, categorieen, email, commissie);
                this.closeConnection();
                return ta;
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
            stmt.executeUpdate("UPDATE tbl_vestigingen SET leveringskosten = " + nieuw.getLeveringskosten() + " WHERE (vestigingsID = '" + oud.getVestigingsID() + "') and (naam = '" + oud.getTakeawayNaam() + "');");
            stmt.executeUpdate("UPDATE tbl_vestigingen SET straat = '" + nieuw.getStraat() + "' WHERE (vestigingsID = '" + oud.getVestigingsID() + "') and (naam = '" + oud.getTakeawayNaam() + "');");
            stmt.executeUpdate("UPDATE tbl_vestigingen SET huisnummer = " + nieuw.getHuisnummer() + " WHERE (vestigingsID = '" + oud.getVestigingsID() + "') and (naam = '" + oud.getTakeawayNaam() + "');");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void addLeveringsgebiedFromVestiging(int plaatsnummer, Vestiging ves) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_leveringsregio VALUES ('" + ves.getVestigingsID() + "','" + ves.getTakeawayNaam() + "'," + plaatsnummer + ");");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void deleteLeveringsgebiedenFromVestiging(Vestiging ves) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from tbl_leveringsregio WHERE (vestigingsID='" + ves.getVestigingsID() + "') and (naam='" + ves.getTakeawayNaam() + "');");
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
            if (srs.next()) {
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

    public ArrayList<Vestiging> getAlleVestigingen(String takeawayNaam) {
        try {
            ArrayList<Vestiging> alleVestigingen = new ArrayList<>();
            ArrayList<Gemeente> leveringsgebied = new ArrayList<>();
            String sql = "SELECT * FROM tbl_vestigingen WHERE (naam = '" + takeawayNaam + "') ;";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                double leveringskosten = srs.getDouble("leveringskosten");
                String straat = srs.getString("straat");
                int huisnummer = srs.getInt("huisnummer");
                int plaatsnummer = srs.getInt("plaatsnummer");
                String vestigingsID = srs.getString("vestigingsID");

                String sql2 = "SELECT * FROM tbl_vestigingen V, tbl_leveringsregio L WHERE(V.naam=L.naam) and (V.vestigingsID=L.vestigingsID) and (V.naam = '" + takeawayNaam + "')and (V.vestigingsID = '" + vestigingsID + "');";
                ResultSet srs2 = getData(sql2);
                leveringsgebied.clear();
                while (srs2.next()) {
                    int plaatsnrLevering = srs2.getInt("leveringsgebied");
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
            String sql = "SELECT * FROM tbl_product WHERE  (takeawaynaam = '" + takeaway + "') and (naam = '" + product + "');";
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

    public Boolean productProductnaamBestaat(String productnaam) {
        try {
            String sql = "SELECT * FROM tbl_product WHERE naam = '" + productnaam + "';";
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

    public void addProduct(Product prod) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_product VALUES (null,'" + prod.getNaam() + "','" + prod.getProducttype() + "'," + prod.getEenheidsprijs() + ", '" + prod.getTakeawaynaam() + "');");
            //int id = this.getProductID();
            //stmt.executeUpdate("UPDATE tbl_product SET type = '" + prod.getProducttype() + "' WHERE productID = " + id + ";");
            //stmt.executeUpdate("UPDATE tbl_product SET eenheidsprijs = " + prod.getEenheidsprijs() + " WHERE productID = " + id + ";");
            //stmt.executeUpdate("UPDATE tbl_product SET naam = '" + prod.getNaam() + "' WHERE productID = " + id + ";");
            //stmt.executeUpdate("INSERT INTO tbl_biedtAan VALUES ('" + takeawayNaam + "'," + id + ");");
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
            stmt.executeUpdate("DELETE from tbl_product WHERE productID = " + prod.getProductID() + ";");
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
            stmt.executeUpdate("UPDATE tbl_product SET eenheidsprijs = " + nieuw.getEenheidsprijs() + " WHERE productID = " + oud.getProductID() + ";");
            stmt.executeUpdate("UPDATE tbl_product SET naam = '" + nieuw.getNaam() + "' WHERE productID = " + oud.getProductID() + ";");
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
                String takeawaynaam = srs.getString("takeawaynaam");
                Product p = new Product(productID1, naam, type, prijs, takeawaynaam);
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
            String sql = "SELECT * FROM tbl_product WHERE (takeawaynaam = '" + takeawayNaam + "');";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int productID = srs.getInt("productID");
                String naam = srs.getString("naam");
                String type = srs.getString("type");
                double prijs = srs.getDouble("eenheidsprijs");
                Product p = new Product(productID, naam, type, prijs, takeawayNaam);
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

    public void verbruiktKortingen(ArrayList<Korting> ingevoerdeKortingen) {
        this.gebruiktKortingRegistratie(ingevoerdeKortingen);
        this.gebruiktKortingReview(ingevoerdeKortingen);
        this.gebruiktKortingTakeawayBoss(ingevoerdeKortingen);
        this.gebruiktKortingJustfeedBoss(ingevoerdeKortingen);
        this.gebruiktKortingEenmaligUniek(ingevoerdeKortingen);
        this.gebruiktKortingEenmaligPeriodie(ingevoerdeKortingen);
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

    public Boolean kortingRegistratieGeldig(int code) {
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

    public void gebruiktKortingRegistratie(ArrayList<Korting> kortingen) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Korting k : kortingen) {
                if (k instanceof RegistratieKorting) {

                    stmt.executeUpdate("UPDATE tbl_kortingRegistratie SET status = FALSE WHERE kortingscode= " + k.getKortingscode() + ";");
                }
            }
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

    //reviewkorting
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

    public void gebruiktKortingReview(ArrayList<Korting> kortingen) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Korting k : kortingen) {
                if (k instanceof ReviewKorting) {

                    stmt.executeUpdate("UPDATE tbl_kortingReview SET status = FALSE WHERE kortingscode= " + k.getKortingscode() + ";");
                }
            }

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
        if (!(kl == null)) {
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

    public void gebruiktKortingJustfeedBoss(ArrayList<Korting> kortingen) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Korting k : kortingen) {
                if (k instanceof JustFeedBoss) {

                    stmt.executeUpdate("UPDATE tbl_kortingJustfeed_boss SET status = FALSE WHERE kortingscode= " + k.getKortingscode() + ";");
                }
            }
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
                while (srs.next()) {
                    String login = kl.getLogin();
                    double gecumuleerd = srs.getDouble("gecumuleerdBedrag");
                    uitgavenKlant.add(new SorteerKorting(login, gecumuleerd));
                }
            }
            this.closeConnection();
            Collections.sort(uitgavenKlant);
            if (uitgavenKlant.get(0).getBedrag() == 0.0) {
                return null;
            } else {

                Klant bigSpender = new Klant(uitgavenKlant.get(0).getLogin());
                return bigSpender;
            }
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
            if (!(kl == null)) {
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

    public void gebruiktKortingTakeawayBoss(ArrayList<Korting> kortingen) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Korting k : kortingen) {
                if (k instanceof TakeawayBoss) {

                    stmt.executeUpdate("UPDATE tbl_kortingTakeaway_boss SET status = FALSE WHERE kortingscode= " + k.getKortingscode() + ";");
                }
            }
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
            if (uitgavenKlant.get(0).getBedrag() == 0.0) {
                return null;
            } else {
                Klant bigSpender = new Klant(uitgavenKlant.get(0).getLogin());
                return bigSpender;
            }
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

    private Boolean kortingEenmaligUniekBestaat(int code, String vestiging, String takeawayNaam, Klant kl) {
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

    public void gebruiktKortingEenmaligUniek(ArrayList<Korting> kortingen) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Korting k : kortingen) {
                if (k instanceof UniekeActieEenmalig) {

                    stmt.executeUpdate("UPDATE tbl_kortingEenmalig SET status = FALSE WHERE kortingscode= " + k.getKortingscode() + ";");
                }
            }
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

    // Periodieke korting
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

    private Boolean kortingEenmaligPeriodeBestaat(int code, String vestiging, String takeawayNaam, Klant kl) {
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

    public void gebruiktKortingEenmaligPeriodie(ArrayList<Korting> kortingen) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Korting k : kortingen) {
                if (k instanceof UniekeActiePeriode) {

                    stmt.executeUpdate("UPDATE tbl_kortingPeriode SET status = FALSE WHERE kortingscode= " + k.getKortingscode() + ";");
                }
            }
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
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
    //bij elk besteld product een review aanmaken met constructor uit de logica (methode aanmaken review voorlopen) en die dan in een arraylist steken
    //bij het goedkeuren deze methode oproepen met de arraylist
    public void aanmakenReview(ArrayList<Review> besteldeProducten) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Review rev : besteldeProducten) {
                if (!(this.getProduct(rev.getProductId()).getProducttype().equalsIgnoreCase("drank"))) {
                    java.sql.Date startdatum = rev.getStartdatum();
                    stmt.executeUpdate("INSERT INTO tbl_review VALUES (null,0,'" + rev.getLogin() + "'," + rev.getProductId() + ",TRUE,'geen beoordeling','" + startdatum + "');");
                }
            }
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
            stmt.executeUpdate("UPDATE tbl_review SET beoordeling = '" + rev.getBeoordeling() + "' WHERE reviewID= " + rev.getReviewId() + ";");
            this.closeConnection();
            if (this.eersteReview(kl, rev)) {
                this.addKortingReview(kl);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void deleteReview(Klant kl) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from tbl_review WHERE (login = '" + kl.getLogin() + "') and (status=TRUE) and ((DATEDIFF(CURDATE(),startdatum))>7);");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
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

    private Boolean eersteReview(Klant kl, Review rev) {
        try {

            int aantal = 0;
            boolean status = false;
            String sql = "SELECT COUNT(*) AS aantal FROM tbl_review WHERE (productID = " + rev.getProductId() + ") and (login='" + kl.getLogin() + "') and (status=FALSE);";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                aantal = srs.getInt("aantal");
                this.closeConnection();
            }
            if (aantal > 0) {
                return status;
            } else {
                status = true;
                return status;
            }

        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
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
    //bij de knop awards aanmaken: 1. undo, 2. delete, 3. calculate, 4. do
    //visualisatie gebeurd dus pas na het toekennen van alle awards!
    public void undoVisualisationAwards() {
        Bestseller oldBestseller = this.getBestseller();
        Users_Choice oldUsersChoice = this.getUsersChoice();

        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            if (oldBestseller == null) {
            } else {
                if (oldBestseller.getTakeawayNaam().contains("_B_")) {
                    String originalName1 = oldBestseller.getTakeawayNaam().substring(3);
                    stmt.executeUpdate("UPDATE tbl_takeaway SET naam = '" + originalName1 + "' WHERE naam = '" + oldBestseller.getTakeawayNaam() + "';");
                }
            }
            if (oldUsersChoice == null) {
            } else {
                if (oldUsersChoice.getTakeawayNaam().contains("_UC_")) {
                    String originalName2 = oldUsersChoice.getTakeawayNaam().substring(4);
                    stmt.executeUpdate("UPDATE tbl_takeaway SET naam = '" + originalName2 + "' WHERE naam = '" + oldUsersChoice.getTakeawayNaam() + "';");
                }
            }

            /*if (!(oldBestseller == null) | !(oldBestseller.getTakeawayNaam().contains("*B*"))) { //om de eerste keer deze methode niet te laten draaien
             String originalName1 = oldBestseller.getTakeawayNaam().substring(3);
             stmt.executeUpdate("UPDATE tbl_takeaway SET naam = '" + originalName1 + "' WHERE naam = '" + oldBestseller.getTakeawayNaam() + "';");
             }
             if (!(oldUsersChoice == null) | !(oldUsersChoice.getTakeawayNaam().contains("*UC*"))) {
             String originalName2 = oldUsersChoice.getTakeawayNaam().substring(4);
             stmt.executeUpdate("UPDATE tbl_takeaway SET naam = '" + originalName2 + "' WHERE naam = '" + oldUsersChoice.getTakeawayNaam() + "';");
             }*/
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }

    }

    public void deleteAllAwards() {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE FROM tbl_awardBestseller;");
            stmt.executeUpdate("DELETE FROM tbl_awardHotitem;");
            stmt.executeUpdate("DELETE FROM tbl_awardJustfeeder;");
            stmt.executeUpdate("DELETE FROM tbl_awardUserschoice;");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void doVisualisationAwards() {
        Bestseller newBestseller = this.getBestseller();
        Users_Choice newUsersChoice = this.getUsersChoice();

        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            if (!(newBestseller == null)) {
                stmt.executeUpdate("UPDATE tbl_takeaway SET naam = '" + "_B_" + newBestseller.getTakeawayNaam() + "' WHERE naam = '" + newBestseller.getTakeawayNaam() + "';");
            }
            if (!(newUsersChoice == null)) {
                stmt.executeUpdate("UPDATE tbl_takeaway SET naam = '" + "_UC_" + newUsersChoice.getTakeawayNaam() + "' WHERE naam = '" + newUsersChoice.getTakeawayNaam() + "'");
            }
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }

    }

    // bestseller   
    public void addAwardBestseller(String maand, int jaar) {
        try {
            Bestseller newBs = this.findBestseller(maand, jaar); //berekenen van de nieuwe bestseller
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            if (newBs.getAantalMenus() > 0) {
                stmt.executeUpdate("INSERT INTO tbl_awardBestseller VALUES (null,'" + newBs.getMaand() + "'," + newBs.getAantalMenus() + ",'" + newBs.getTakeawayNaam() + "');");
            }
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

    public Bestseller getBestseller() {
        try {
            String sql = "SELECT * FROM tbl_awardBestseller;";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int awardID = srs.getInt("awardID");
                String maand = srs.getString("maand");
                String naam = srs.getString("naam");
                int aantalMenus = srs.getInt("aantalMenus");
                Bestseller bs = new Bestseller(awardID, maand, aantalMenus, naam);
                this.closeConnection();
                return bs;
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

    //hot item
    public void addAwardHotItem(String maand, int jaar) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Hot_Item hi : this.findHotItems(maand, jaar)) {
                if (hi.getAantalBesteld() > 0) {

                    stmt.executeUpdate("INSERT INTO tbl_awardHotitem VALUES (null,'" + hi.getMaand() + "'," + hi.getAantalBesteld() + "," + hi.getProductID() + ");");
                }
            }
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    private ArrayList<Hot_Item> findHotItems(String maand, int jaar) {
        ArrayList<Hot_Item> hotItemPerTakeaway = new ArrayList<>();
        ArrayList<Hot_Item> gecumuleerdeHoeveelheidPerTakeaway = new ArrayList<>();
        String start = DatumFinder.getEersteDag(maand, jaar);
        String eind = DatumFinder.getLaatsteDag(maand, jaar);
        try {
            for (Take_Away ta : this.getAlleTakeaways()) {
                gecumuleerdeHoeveelheidPerTakeaway.clear();
                for (Product p : this.getProductsOfTakeaway(ta.getNaam())) {
                    String sql = "SELECT SUM(B.hoeveelheid) AS gecumuleerd FROM tbl_behoortTot B JOIN tbl_menu M ON (B.menuID=M.menuID) JOIN tbl_order O ON (M.orderID=O.orderID) WHERE (B.productID = " + p.getProductID() + ") AND (O.datum BETWEEN STR_TO_DATE('" + start + "','%m,%d,%Y') AND STR_TO_DATE('" + eind + "','%m,%d,%Y'));";
                    ResultSet srs = getData(sql);
                    while (srs.next()) {
                        int productID = p.getProductID();
                        int gecumuleerd = srs.getInt("gecumuleerd");
                        gecumuleerdeHoeveelheidPerTakeaway.add(new Hot_Item(gecumuleerd, productID));
                    }
                }

                Collections.sort(gecumuleerdeHoeveelheidPerTakeaway);
                if (gecumuleerdeHoeveelheidPerTakeaway.size() > 1) {
                    if (gecumuleerdeHoeveelheidPerTakeaway.get(0).getAantalBesteld() == gecumuleerdeHoeveelheidPerTakeaway.get(1).getAantalBesteld()) {
                        Product product1 = getProduct(gecumuleerdeHoeveelheidPerTakeaway.get(0).getProductID());
                        Product product2 = getProduct(gecumuleerdeHoeveelheidPerTakeaway.get(1).getProductID());
                        if (product1.getEenheidsprijs() > product2.getEenheidsprijs()) {
                            hotItemPerTakeaway.add(new Hot_Item(maand, gecumuleerdeHoeveelheidPerTakeaway.get(0).getAantalBesteld(), gecumuleerdeHoeveelheidPerTakeaway.get(0).getProductID()));
                        } else {

                            hotItemPerTakeaway.add(new Hot_Item(maand, gecumuleerdeHoeveelheidPerTakeaway.get(1).getAantalBesteld(), gecumuleerdeHoeveelheidPerTakeaway.get(1).getProductID()));
                        }
                    } else {
                        hotItemPerTakeaway.add(new Hot_Item(maand, gecumuleerdeHoeveelheidPerTakeaway.get(0).getAantalBesteld(), gecumuleerdeHoeveelheidPerTakeaway.get(0).getProductID()));
                    }
                }
                if (gecumuleerdeHoeveelheidPerTakeaway.size() == 1) {

                    hotItemPerTakeaway.add(new Hot_Item(maand, gecumuleerdeHoeveelheidPerTakeaway.get(0).getAantalBesteld(), gecumuleerdeHoeveelheidPerTakeaway.get(0).getProductID()));
                } else {

//do nothing
                }
            }

            this.closeConnection();
            return hotItemPerTakeaway;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public ArrayList<Hot_Item> getHotItems() {
        try {
            ArrayList<Hot_Item> alleHotItems = new ArrayList<>();
            String sql = "SELECT * FROM tbl_awardHotitem;";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int awardID = srs.getInt("awardID");
                String maand = srs.getString("maand");
                int aantalBesteld = srs.getInt("aantalBesteld");
                int productID = srs.getInt("productID");

                Hot_Item hi = new Hot_Item(awardID, maand, aantalBesteld, productID);
                alleHotItems.add(hi);
            }
            this.closeConnection();
            return alleHotItems;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    // just feeder   
    public void addAwardJustFeeder(String maand) {
        try {
            Just_Feeder jf = this.findJustfeeder(maand);
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            if (jf.getCommissie() > 0.0) {
                stmt.executeUpdate("INSERT INTO tbl_awardJustfeeder VALUES (null,'" + jf.getMaand() + "'," + jf.getCommissie() + ",'" + jf.getTakeawayNaam() + "');");
            }
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

    public Just_Feeder getJustfeeder() {
        try {
            String sql = "SELECT * FROM tbl_awardJustfeeder";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int awardID = srs.getInt("awardID");
                String maand = srs.getString("maand");
                String naam = srs.getString("naam");
                double commissie = srs.getInt("commissie");
                Just_Feeder jf = new Just_Feeder(awardID, maand, commissie, naam);
                this.closeConnection();
                return jf;
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

    // users choice
    public void addAwardUsersChoice(String maand) {
        try {
            Users_Choice newUc = this.findUsersChoice(maand); //berekenen van de nieuwe users choice
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            if (newUc.getBeoordeling() > 0.0) {
                stmt.executeUpdate("INSERT INTO tbl_awardUserschoice VALUES (null,'" + newUc.getMaand() + "','" + newUc.getBeoordeling() + "','" + newUc.getTakeawayNaam() + "');");
            }
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
                //String sql = "SELECT AVG(score) AS avgReview FROM tbl_review R,tbl_biedtAan B WHERE (R.productID=B.productID) and (B.takeawaynaam='" + ta.getNaam() + "') and(R.status=FALSE) and ((SELECT COUNT(*) AS aantalReviews FROM tbl_review R,tbl_biedtAan B WHERE (R.productID=B.productID) and (B.takeawaynaam='" + ta.getNaam() + "') and(R.status=FALSE))>=3);";
                String sql = "SELECT AVG(score) as avgReview FROM tbl_review R, tbl_product P WHERE (R.productID = P.productID) and (P.takeawaynaam ='" + ta.getNaam() + "') and(R.status=FALSE) and ((SELECT COUNT(*) AS aantalReviews FROM tbl_review R, tbl_product P WHERE (R.productID=P.productID)and (P.takeawaynaam='" + ta.getNaam() + "') and(R.status=FALSE))>=3);";
                ResultSet srs = getData(sql);
                if (srs.next()) {
                    String takeaway = ta.getNaam();
                    int avgReview = srs.getInt("avgReview");
                    scorePerTakeaway.add(new Users_Choice(avgReview, takeaway));

                }
            }
            this.closeConnection();
            Collections.sort(scorePerTakeaway);
            //in het geval dat bestseller en users choice dezelfde take-away toewijzen, stel nu dat er maar 1 TA in het systeem zit dan kan dit een error geven
            //moet ik dit oplossen? of laten we dit zo? kan oplgelost worden met getsize.
            Bestseller actieveBestseller = this.getBestseller();
            Users_Choice usersChoice1 = new Users_Choice(maand, scorePerTakeaway.get(0).getBeoordeling(), scorePerTakeaway.get(0).getTakeawayNaam());
            Users_Choice usersChoice2 = new Users_Choice(maand, scorePerTakeaway.get(1).getBeoordeling(), scorePerTakeaway.get(1).getTakeawayNaam());
            if (actieveBestseller.getTakeawayNaam().equalsIgnoreCase(usersChoice1.getTakeawayNaam())) {
                return usersChoice2;
            } else {
                return usersChoice1;
            }

        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public Users_Choice getUsersChoice() {
        try {
            String sql = "SELECT * FROM tbl_awardUserschoice;";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int awardID = srs.getInt("awardID");
                String maand = srs.getString("maand");
                String naam = srs.getString("naam");
                double beoordeling = srs.getInt("beoordeling");
                Users_Choice uc = new Users_Choice(awardID, maand, beoordeling, naam);
                this.closeConnection();
                return uc;
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

    // ALLE AWARDS IN 1 ARRAYLIST
    public ArrayList<Award> getAlleAwards() {
        ArrayList<Award> alleAwards = new ArrayList<>();
        alleAwards.add(this.getBestseller());
        alleAwards.add(this.getJustfeeder());
        alleAwards.add(this.getUsersChoice());
        for (Award a : this.getHotItems()) {
            alleAwards.add(a);
        }
        return alleAwards;
    }

    //METHODES IVM MENU'S
    private void addMenu(ArrayList<Orderverwerking> besteldeProducten, Menu m, int orderID) {
        try {
            int lastInsert = 0;
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_menu VALUES (null," + m.getMenuprijs() + "," + orderID + ",'" + m.getTakeawayNaam() + "','" + m.getVestiging() + "');");
            String sql = "SELECT LAST_INSERT_ID();";
            ResultSet srs = stmt.executeQuery(sql);
            if (srs.next()) {
                lastInsert = srs.getInt("LAST_INSERT_ID()");
            }
            this.closeConnection();
            this.addBehoortTot(besteldeProducten, m.getTakeawayNaam(), m.getVestiging(), lastInsert);

        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    private void addBehoortTot(ArrayList<Orderverwerking> besteldeProducten, String takeawayNaam, String vestigingsID, int menuID) {
        try {
            Orderverwerking o = new Orderverwerking();
            ArrayList<Orderverwerking> productenPerVestiging = o.verdelingBesteldeProducten(besteldeProducten, takeawayNaam, vestigingsID);

            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Orderverwerking orderv : productenPerVestiging) {
                stmt.executeUpdate("INSERT INTO tbl_behoortTot VALUES (" + orderv.getProductID() + ", " + menuID + "," + orderv.getHoeveelheid() + ");");
            }
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public ArrayList<Menu> getAlleMenus(String takeawayNaam, String vestiging) {
        try {
            ArrayList<Menu> alleMenus = new ArrayList<>();
            String sql = "SELECT * FROM tbl_menu WHERE (takeaway = '" + takeawayNaam + "')and (vestiging = '" + vestiging + "' ) ;";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int menuID = srs.getInt("menuID");
                double menuprijs = srs.getDouble("menuprijs");
                int orderID = srs.getInt("orderID");

                Menu menu = new Menu(menuID, menuprijs, orderID, takeawayNaam, vestiging);
                alleMenus.add(menu);
            }
            this.closeConnection();
            return alleMenus;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }

    }

    public Menu getMenu(int menuID) {
        try {
            String sql = "SELECT * FROM tbl_menu WHERE menuID = " + menuID + ";";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                double menuprijs = srs.getDouble("menuprijs");
                int orderID = srs.getInt("orderID");
                String takeawayNaam = srs.getString("takeaway");
                String vestiging = srs.getString("vestiging");
                Menu menu = new Menu(menuID, menuprijs, orderID, takeawayNaam, vestiging);
                this.closeConnection();
                return menu;
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

    //deze methodes wordt gebruikt bij het sturen van de mails naar de take-away met een bestelling van de klant
    public ArrayList<Orderverwerking> getAlleProductenVanMenu(int menuID) {
        try {
            ArrayList<Orderverwerking> productenVanMenu = new ArrayList<>();
            String sql = "SELECT * FROM tbl_behoortTot B, tbl_menu M WHERE (M.menuID=" + menuID + ")and (M.menuID = B.menuID);";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int productID = srs.getInt("B.productID");
                int hoeveelheid = srs.getInt("B.hoeveelheid");
                String vestiging = srs.getString("M.vestiging");
                Product p = this.getProduct(productID);
                Orderverwerking orderverw = new Orderverwerking(productID, p.getNaam(), p.getProducttype(), hoeveelheid, p.getTakeawaynaam(), vestiging);
                productenVanMenu.add(orderverw);
            }
            this.closeConnection();
            return productenVanMenu;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    //deze methode wordt gebruikt om alle menuID's van een orderID te vinden
    public ArrayList<Integer> getMenuIDsFromOrderID(int orderID) {
        try {
            ArrayList<Integer> alleMenuID = new ArrayList<>();
            String sql = "SELECT * FROM tbl_menu WHERE (orderID = " + orderID + ") ;";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int menuID = srs.getInt("menuID");
                alleMenuID.add(menuID);
            }
            this.closeConnection();
            return alleMenuID;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }

    }

    //deze methode oproepen bij het ingeven van kortingscodes niet, de bestaat bij methodes korting
    public boolean kortingEenmaligBruikbaarBijMenu(int code, ArrayList<Menu> berekendeMenus, Klant kl) {
        boolean status = false;
        for (Menu menu : berekendeMenus) {
            if (this.kortingEenmaligUniekBestaat(code, menu.getVestiging(), menu.getTakeawayNaam(), kl)) {
                status = true;
            }
        }
        return status;
    }

    public boolean kortingPeriodeBruikbaarBijMenu(int code, ArrayList<Menu> berekendeMenus, Klant kl) {
        boolean status = false;
        for (Menu menu : berekendeMenus) {
            if (this.kortingEenmaligPeriodeBestaat(code, menu.getVestiging(), menu.getTakeawayNaam(), kl)) {
                status = true;
            }
        }
        return status;
    }

    public boolean kortingEenmaligBruikbaarBijMenu(int code, Menu menu, Klant kl) {
        return (this.kortingEenmaligUniekBestaat(code, menu.getVestiging(), menu.getTakeawayNaam(), kl));
    }

    public boolean kortingPeriodeBruikbaarBijMenu(int code, Menu menu, Klant kl) {
        return (this.kortingEenmaligPeriodeBestaat(code, menu.getVestiging(), menu.getTakeawayNaam(), kl));
    }

    //METHODES IVM ORDERS
    public void addOrder(Order o, ArrayList<Menu> menus, ArrayList<Orderverwerking> besteldeProducten) {
        try {
            int lastInsert = 0;
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_order VALUES (null," + o.getTotaalPrijs() + ",'" + o.getDatum() + "','" + o.getStraat() + "'," + o.getHuisnummer() + "," + o.getPlaatsnummer() + ",'" + o.getLogin() + "',FALSE);");
            String sql = "SELECT LAST_INSERT_ID();";
            ResultSet srs = stmt.executeQuery(sql);
            if (srs.next()) {
                lastInsert = srs.getInt("LAST_INSERT_ID()");
            }
            this.closeConnection();
            for (Menu menu : menus) {
                this.addMenu(besteldeProducten, menu, lastInsert);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public void addHulpKorting(ArrayList<HulpKorting> hulpkortingen) {

        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();

            for (HulpKorting hk : hulpkortingen) {
                double huidigKortingsbedrag = this.getHuidigeHulpKorting(hk.getTakeawayNaam());
                double nieuwKortingsbedrag = huidigKortingsbedrag + hk.getKortingsbedrag();
                stmt.executeUpdate("UPDATE tbl_hulpkorting SET kortingsbedrag=" + nieuwKortingsbedrag + " WHERE (takeawaynaam='" + hk.getTakeawayNaam() + "');");
            }

            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }

    }

    private double getHuidigeHulpKorting(String takeawayNaam) {
        double huidigeHulpkorting = 0.0;
        try {
            String sql = "SELECT * FROM tbl_hulpkorting WHERE (takeawaynaam='" + takeawayNaam + "');";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                huidigeHulpkorting = srs.getInt("kortingsbedrag");
                this.closeConnection();
                return huidigeHulpkorting;
            } else {
                this.closeConnection();
                return huidigeHulpkorting;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return huidigeHulpkorting;
        }
    }

    public ArrayList<Menu> getLopendeOrders(String takeawayNaam, String vestiging) {

        try {
            ArrayList<Menu> lopendeOrders = new ArrayList<>();
            String sql = "SELECT * FROM tbl_order O, tbl_menu M WHERE (M.orderID = O.orderID) and (O.status = FALSE) and (M.takeaway = '" + takeawayNaam + "')and (M.vestiging = '" + vestiging + "' ) ;";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int menuID = srs.getInt("menuID");
                double menuprijs = srs.getDouble("menuprijs");
                int orderID = srs.getInt("M.orderID");

                Menu menu = new Menu(menuID, menuprijs, orderID, takeawayNaam, vestiging);
                lopendeOrders.add(menu);

            }
            this.closeConnection();
            return lopendeOrders;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }

    public ArrayList<Menu> getVerkopen(String takeawayNaam, String vestiging) {

        try {
            ArrayList<Menu> Verkopen = new ArrayList<>();
            String sql = "SELECT * FROM tbl_order O, tbl_menu M WHERE (M.orderID = O.orderID) and (O.status = TRUE) and (M.takeaway = '" + takeawayNaam + "')and (M.vestiging = '" + vestiging + "' );";
            ResultSet srs = getData(sql);
            while (srs.next()) {
                int menuID = srs.getInt("menuID");
                double menuprijs = srs.getDouble("menuprijs");
                int orderID = srs.getInt("M.orderID");

                Menu menu = new Menu(menuID, menuprijs, orderID, takeawayNaam, vestiging);
                Verkopen.add(menu);

            }
            this.closeConnection();
            return Verkopen;
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }

    }

    public void ontvangstbevestigingOrder(int orderID) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_order SET status = TRUE WHERE orderID = " + orderID + ";");
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    public boolean orderIdBestaat(int orderID) {
        try {
            String sql = "SELECT * FROM tbl_order WHERE orderID = " + orderID + ";";
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

    public int getLastOrderKlant(Klant kl) {
        try {
            String sql = "SELECT MAX(orderID) AS lastOrderID FROM tbl_order WHERE login = '" + kl.getLogin() + "';";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                int orderID = srs.getInt("lastOrderID");
                this.closeConnection();
                return orderID;
            } else {
                this.closeConnection();
                return 0;
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return 0;

        }
    }

    public Order getOrder(int orderID) {
        try {
            String sql = "SELECT * FROM tbl_order WHERE orderID = " + orderID + ";";
            ResultSet srs = getData(sql);
            if (srs.next()) {
                double totaalPrijs = srs.getDouble("totaalprijs");
                Date datum = srs.getDate("datum");
                String straat = srs.getString("straat");
                int huisnummer = srs.getInt("huisnummer");
                int plaatsnummer = srs.getInt("plaatsnummer");
                Order order = new Order(orderID, totaalPrijs, datum, straat, huisnummer, plaatsnummer);
                this.closeConnection();
                return order;
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

    //METHODES IVM COMMISSIE
    public void addCommissie(String maand, int jaar) {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            for (Take_Away ta : this.getAlleTakeaways()) {
                double berekendeCommissie = this.berekenenCommissie(ta.getNaam(), maand, jaar);
                stmt.executeUpdate("UPDATE tbl_takeaway SET commissie = " + berekendeCommissie + " WHERE naam = '" + ta.getNaam() + "';");
                mc.sendCommissiemail(ta, maand, jaar, berekendeCommissie);
            }
            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

    private double berekenenCommissie(String takeawayNaam, String maand, int jaar) {
        String start = DatumFinder.getEersteDag(maand, jaar);
        String eind = DatumFinder.getLaatsteDag(maand, jaar);
        double totaleGeldwaarde = 0.0; //sum van menuprijzen die we ophalen + hulpkorting
        double opgehaaldeMenusPrijs = 0.0;
        double opgehaaldeHulpkorting = 0.0;
        double aantalOrders = 0;
        String justfeeder = "geenjustfeeder";
        ResultSet srs;
        //ophalen van gegevens
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            opgehaaldeHulpkorting = this.getHuidigeHulpKorting(takeawayNaam);

            String sql1 = "SELECT SUM(M.menuprijs) AS gecumuleerdeMenuprijs FROM tbl_menu M , tbl_order O WHERE (M.orderID=O.orderID)and (M.takeaway='" + takeawayNaam + "')and (O.datum BETWEEN STR_TO_DATE('" + start + "','%m,%d,%Y') AND STR_TO_DATE('" + eind + "','%m,%d,%Y'));";
            srs = stmt.executeQuery(sql1);
            if (srs.next()) {
                opgehaaldeMenusPrijs = srs.getDouble("gecumuleerdeMenuprijs");
            }

            String sql2 = "SELECT COUNT(*) AS aantalOrders FROM tbl_menu M, tbl_order O WHERE (M.orderID=O.orderID) and (M.takeaway='" + takeawayNaam + "')and (O.datum BETWEEN STR_TO_DATE('" + start + "','%m,%d,%Y') AND STR_TO_DATE('" + eind + "','%m,%d,%Y'));";
            srs = stmt.executeQuery(sql2);
            if (srs.next()) {
                aantalOrders = srs.getDouble("aantalOrders");
            }

            String sql3 = "SELECT * FROM tbl_awardJustfeeder";
            srs = stmt.executeQuery(sql3);
            if (srs.next()) {
                justfeeder = srs.getString("naam");
            }
            this.closeConnection();

        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
        // berekening van de commissie
        totaleGeldwaarde = opgehaaldeMenusPrijs + opgehaaldeHulpkorting;
        double derdeBedrag = (-1.0 / 5000.0) * aantalOrders + (11.0 / 100.0) * totaleGeldwaarde;
        double tweedeBedrag = 0.1 * (totaleGeldwaarde);
        double minTweedeLid = Math.min(derdeBedrag, tweedeBedrag);
        double eersteBedrag = 0.07 * (totaleGeldwaarde);
        double berekendeCommissie = Math.max(eersteBedrag, minTweedeLid);
        if (justfeeder.equalsIgnoreCase(takeawayNaam)) {
            berekendeCommissie *= 0.99;
        }
        this.resetTabelHulpkorting(); // om alle te zorgen da elke take-away terug op 0 staat qua kortingen  van just-feed die zijn gebruikt bij hun takeaway 
        return berekendeCommissie;
    }

    private void resetTabelHulpkorting() {
        try {
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE tbl_hulpkorting SET kortingsbedrag = 0;");

            this.closeConnection();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }

}
