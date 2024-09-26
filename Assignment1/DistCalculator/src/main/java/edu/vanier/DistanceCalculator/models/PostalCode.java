package edu.vanier.DistanceCalculator.models;

import com.opencsv.bean.*;

public class PostalCode {
    @CsvBindByPosition(position = 0)
    int id;
    @CsvBindByPosition(position = 1)
    String country;
    @CsvBindByPosition(position = 4)
    String province;
    @CsvBindByPosition(position = 5)
    double latitude;
    @CsvBindByPosition(position = 6)
    double longitude;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


}

