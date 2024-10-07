package edu.vanier.DistanceCalculator.controllers;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvValidationException;
import edu.vanier.DistanceCalculator.models.PostalCode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.*;

public class PostalCodeController {


    public PostalCodeController(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    String csvFilePath;


    public HashMap<String, PostalCode> parse(String csvFilePath) {
        HashMap<String, PostalCode> codeMap = new HashMap<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            int i = 0;
            while ((line = reader.readNext()) != null) {

                PostalCode pc = new PostalCode();
                try {
                    Double.parseDouble(line[5]);
                } catch (NumberFormatException e) {
                    //not a double
                    reader.readNext();
                    break;
                }
                try {
                    Double.parseDouble(line[6]);
                } catch (NumberFormatException e) {
                    //not a double
                    reader.readNext();
                    break;
                }
                try {
                    Integer.parseInt(line[0]);
                } catch (NumberFormatException e) {
                    //not an int
                    reader.readNext();
                    break;
                }
                /*if(!line[4].equalsIgnoreCase ("AB") || (!line[4].equalsIgnoreCase ("BC")) || (!line[4].equalsIgnoreCase ("SK")) || (!line[4].equalsIgnoreCase ("QC")) || (!line[4].equalsIgnoreCase ("ON")) || (!line[4].equalsIgnoreCase ("MB")) || (!line[4].equalsIgnoreCase ("NS")) || (!line[4].equalsIgnoreCase ("PEI")) || (!line[4].equalsIgnoreCase ("NB")) || (!line[4].equalsIgnoreCase ("YT")) ||(!line[4].equalsIgnoreCase ("NT")) || (!line[4].equalsIgnoreCase ("NU"))){
                    reader.readNext();
                    break;
                }*/
                pc.setLatitude(Double.parseDouble(line[5]));
                pc.setId(Integer.parseInt(line[0]));
                pc.setCountry(line[1]);
                pc.setProvince(line[4]);
                pc.setLongitude(Double.parseDouble(line[6]));


                codeMap.put(line[2], pc);

            }

            //codeMap.forEach((key, value) -> System.out.println(key + " " + value.getProvince()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            System.out.println(e.getMessage());

            throw new RuntimeException(e);

        }

        return codeMap;
    }


    public double distanceTo(PostalCode from, PostalCode to) {
        //Longitude of origin
        double originLong = from.getLongitude();
        originLong = Math.toRadians(originLong);
        //Latitude of origin
        double originLat = from.getLatitude();
        originLat = Math.toRadians(originLat);
        //Long. of destination
        double destLong = to.getLongitude();
        destLong = Math.toRadians(destLong);
        //Lat. of destination
        double destLat = to.getLatitude();
        destLat = Math.toRadians(destLat);

        //Math operations:
        double a = Math.pow(Math.sin((destLat - originLat) / 2), 2) + (Math.cos(originLat) * Math.cos(destLat) * Math.pow(Math.sin((destLong - originLong) / 2), 2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        final double R = 6371e3; //Earth's radius in m
        double dist = R * c;
        double scale = Math.pow(10, 4);

        return Math.round((dist * scale) / scale);
    }

    public HashMap<PostalCode, Double> nearbyLocations(PostalCode from, double radius, HashMap<String, PostalCode> pcList) {
        HashMap<PostalCode, Double> codesWithinRadius = new HashMap<>();
        LinkedList<PostalCode> pc3 = new LinkedList<>();
        Collection<PostalCode> pc2 = pcList.values();
        pc3.addAll(pc2);

        //Calculates distance from origin to all points in database. If a point falls within radius, it is added
        for (int i = 0; i < pcList.size(); i++) {
            //Longitude of origin
            double originLong = from.getLongitude();
            originLong = Math.toRadians(originLong);
            //Latitude of origin
            double originLat = from.getLatitude();
            originLat = Math.toRadians(originLat);
            //Long. of destination
            double destLong = pc3.get(i).getLongitude();
            destLong = Math.toRadians(destLong);
            //Lat. of destination
            double destLat = pc3.get(i).getLatitude();
            destLat = Math.toRadians(destLat);


            double a = Math.pow(Math.sin((destLat - originLat) / 2), 2) + (Math.cos(originLat) * Math.cos(destLat) * Math.pow(Math.sin((destLong - originLong) / 2), 2));
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            final double R = 6371e3; //Earth's radius in m
            double dist = (R * c) / 1000.0;
            if (dist <= radius) {
                codesWithinRadius.put(pc3.get(i), dist);
            }
        }
        if (codesWithinRadius.isEmpty()) {
            System.out.println("No codes found within radius. ");
        } else {
            codesWithinRadius.forEach((key, value) -> {
                System.out.println("Key=" + key.getId() + ", Value=" + value);
            });


                }
            return codesWithinRadius;
    }



        }













