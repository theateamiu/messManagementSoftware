package com.theateamiu.mms.models;

import java.io.Serializable;

public class Managerial implements Serializable{
    private static final long serialVersionUID = 1L;

    private long id;
    private String imagePath;
    private String name;
    private long rankInCountry;
    private long rankInDist;
    private String startDate;
    private String endDate;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRankInCountry() {
        return rankInCountry;
    }

    public void setRankInCountry(long rankInCountry) {
        this.rankInCountry = rankInCountry;
    }

    public long getRankInDist() {
        return rankInDist;
    }

    public void setRankInDist(long rankInDist) {
        this.rankInDist = rankInDist;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    @Override
    public String toString() {
        return "ID: "+id+"\nName: "+name+"\nImagepath: "+imagePath+"\nStartDate: "+startDate+
                "\nEndDate: "+endDate+"\nDistRank: "+rankInDist+"\nCountryRank: "+rankInCountry;
    }
}
