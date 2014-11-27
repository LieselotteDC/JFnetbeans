package Logica;

public class DatumFinder {

    public String maand;

    public static String getLaatsteDag(String maand, int jaar) {
        String datum = null;
        if (maand.equalsIgnoreCase("januari")) {
            datum = "01,31," + jaar;

        } else if (maand.equalsIgnoreCase("februari")) {
            datum = "02,29," + jaar;

        } else if (maand.equalsIgnoreCase("maart")) {
            datum = "03,31," + jaar;
        } else if (maand.equalsIgnoreCase("april")) {
            datum = "04,30," + jaar;

        } else if (maand.equalsIgnoreCase("mei")) {
            datum = "05,31," + jaar;

        } else if (maand.equalsIgnoreCase("juni")) {
            datum = "06,30," + jaar;

        } else if (maand.equalsIgnoreCase("juli")) {
            datum = "071,31," + jaar;
        } else if (maand.equalsIgnoreCase("augustus")) {
            datum = "08,31," + jaar;

        } else if (maand.equalsIgnoreCase("september")) {
            datum = "09,30," + jaar;

        } else if (maand.equalsIgnoreCase("oktober")) {
            datum = "10,31," + jaar;

        } else if (maand.equalsIgnoreCase("november")) {
            datum = "11,30," + jaar;

        } else if (maand.equalsIgnoreCase("december")) {
            datum = "12,31," + jaar;
        }
        return datum;
    }
       public static String getEersteDag(String maand, int jaar) {
        String datum = null;
        if (maand.equalsIgnoreCase("januari")) {
            datum = "01,01," + jaar;

        } else if (maand.equalsIgnoreCase("februari")) {
            datum = "02,01," + jaar;

        } else if (maand.equalsIgnoreCase("maart")) {
            datum = "03,01," + jaar;
        } else if (maand.equalsIgnoreCase("april")) {
            datum = "04,01," + jaar;

        } else if (maand.equalsIgnoreCase("mei")) {
            datum = "05,01," + jaar;

        } else if (maand.equalsIgnoreCase("juni")) {
            datum = "06,01," + jaar;

        } else if (maand.equalsIgnoreCase("juli")) {
            datum = "071,01," + jaar;
        } else if (maand.equalsIgnoreCase("augustus")) {
            datum = "08,01," + jaar;

        } else if (maand.equalsIgnoreCase("september")) {
            datum = "09,01," + jaar;

        } else if (maand.equalsIgnoreCase("oktober")) {
            datum = "10,01," + jaar;

        } else if (maand.equalsIgnoreCase("november")) {
            datum = "11,01," + jaar;

        } else if (maand.equalsIgnoreCase("december")) {
            datum = "12,01," + jaar;
        }
        return datum;
    }
}
