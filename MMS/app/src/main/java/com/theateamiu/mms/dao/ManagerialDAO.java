package com.theateamiu.mms.dao;


import com.theateamiu.mms.constituents.listsrowmodels.Managerial;
import com.theateamiu.mms.models.Mess;

import java.util.List;

public interface ManagerialDAO {
    public List<Managerial> getManagerialList();
    public Mess getMess(long messId); // sets Image,Name & Duration
    public int getManagerialRankInDistrict(); // sets Rank in district
    public int getManagerialRankInCountry();  // sets Rank in country
}
