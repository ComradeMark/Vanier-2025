package edu.vanier.Driver;


public class Driver {

    public static void main(String[] args) {
        System.out.println("Hello from Driver...");
        String csvPath = Driver.class.getResource("/data/postalcodes.csv").getFile();

    }
}
