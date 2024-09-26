package edu.vanier.DistanceCalculator.tests;
import java.util.Scanner;

import edu.vanier.DistanceCalculator.controllers.PostalCodeController;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Welcome! How would you like to proceed? ");
        String csvPath = String.valueOf(Driver.class.getResource("/data/postalcodes.csv"));
        Scanner input = new Scanner(System.in);
        System.out.println("1 - Calculate distance between two canadian postal codes ");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                testParse(csvPath);
            case 2:
        }

    }


  static void testParse(String csvPath){
     PostalCodeController PCC = new PostalCodeController(csvPath);
     PCC.parse(csvPath);
 }

 void testDistanceTo(String from){

 }
 void testNearbyLocations(String from){

 }


}
