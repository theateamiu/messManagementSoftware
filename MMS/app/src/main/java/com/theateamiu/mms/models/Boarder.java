package com.theateamiu.mms.models;

import java.io.Serializable;

public class Boarder implements Serializable{
    private static final long serialVersionUID = 1L;
    //public static final int NO_PROPERTIES = 8;
    private String name;
    private String phoneNo;
    private String email;
    private String profession;
    private String dateOfBirth;
    private String bloodGroup;
    private String imageURL;
    private long managerialID;


    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public long getManagerialID() {
        return managerialID;
    }

    public void setManagerialID(long managerialID) {
        this.managerialID = managerialID;
    }


    @Override
    public String toString() {

        return "Name: "+name+"\n"+
                "PhoneNo: "+phoneNo+"\n"+
                "ImageURI: "+imageURL+"\n"+
                "BG: "+bloodGroup;
    }
}
