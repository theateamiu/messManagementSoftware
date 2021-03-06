package com.theateamiu.mms.models;


public class Mess {
    private String id;
    private String name;
    private String imageURL;
    private String postalAddress;
    private String district;
    private String region;
    private String startDate;
    private String endDate;
    private int districtRank;
    private int countryRank;
    private String managerEmail;

    public int getDistrictRank() {
        return districtRank;
    }

    public void setDistrictRank(int districtRank) {
        this.districtRank = districtRank;
    }

    public int getCountryRank() {
        return countryRank;
    }

    public void setCountryRank(int countryRank) {
        this.countryRank = countryRank;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Name: "+name+";ImagePath: "+imageURL+";StartDate: "+startDate+";EndDate: "+
                endDate+"; RankInDist: "+districtRank+"; RankInCountry: "+countryRank;
    }
}
