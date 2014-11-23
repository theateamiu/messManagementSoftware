package com.theateamiu.mms.dao;


import com.theateamiu.mms.models.Mess;

import java.util.List;

public interface MessDAO {
    public Mess getMessFromDB();
    public void setMessToDB(Mess mess);
    public List<Mess> getMessListFromDB();
}
