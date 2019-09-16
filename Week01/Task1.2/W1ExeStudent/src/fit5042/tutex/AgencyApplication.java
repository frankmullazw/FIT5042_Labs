/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex;

/**
 *
 * @author mukar
 */
public class AgencyApplication {

    public static void main(String[] args) {
        // Uses the real estate agency run method to test out repository classes
        try {
            
            RealEstateAgency agency = new RealEstateAgency("Test Agency");
            agency.run();
        } catch (Exception e) {
            System.out.println("Error! Check logs");
            e.printStackTrace();
        }

    }

}
