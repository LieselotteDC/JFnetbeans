/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author odkeyser
 */
public class testMain {
 public static void main(String[] args) {
     WriteFile test= new WriteFile();
     test.awardsPerTakeaway("januari", 2014);
     test.lopendeOrdersPerTakeaway("pizzahut");
     //test.verkopenPerTakeaway("pizzahut");
     //test.menukaartPerTakeaway("pizzahut");
    }
}
