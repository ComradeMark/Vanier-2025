package edu.vanier.DistanceCalculator.controllers;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import edu.vanier.DistanceCalculator.models.PostalCode;

import java.io.FileReader;

public class PostalCodeController {



    public PostalCodeController(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    String csvFilePath;


    public void parse(String csvFilePath){
        CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath)).build();


    }




    void distanceTo(PostalCode from, PostalCode to){

    }

    void nearbyLocations(PostalCode from){

    }
}









