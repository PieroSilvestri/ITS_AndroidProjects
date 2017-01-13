package com.example.piero.giuliaapp1;

import java.util.ArrayList;

/**
 * Created by piero on 17/08/2016.
 */
public class OggettoMaps {

    private String title;
    private String description;
    private String phone;
    private ArrayList<String> type;
    private double lat;
    private double lon;
    private int id;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAll(String title, String description, String phone, ArrayList<String> type, double lat, double lon, int id){
        this.title = title;
        this.description = description;
        this.phone = phone;
        this.type = type;
        this.lat = lat;
        this.lon = lon;
        this.id = id;
    }



}


