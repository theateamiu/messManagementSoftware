package com.theateamiu.mms.constituents.listsrowmodels;

import java.io.Serializable;

public class Managerial implements Serializable{
    private static final long serialVersionUID = 1L;

    public long id;
    public String imagePath;
    public String name;
    public long rankInCountry;
    public long rankInDist;
    public String startDate;
    public String endDate;


    @Override
    public String toString() {
        return "ID: "+id+"\nName: "+name+"\nImagepath: "+imagePath+"\nStartDate: "+startDate+
                "\nEndDate: "+endDate+"\nDistRank: "+rankInDist+"\nCountryRank: "+rankInCountry;
    }
}
