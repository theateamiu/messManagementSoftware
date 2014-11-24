package com.theateamiu.mms.dao;


import com.theateamiu.mms.models.Mess;

import java.util.List;

public interface MessDAO {
    public Mess getMessFromDB(long id);
    public void setMessToDB(Mess mess);
    public boolean updateMessOnDB(long id);
    public Mess deleteMessFromDB(long id);
    public List<Mess> getMessListFromDB();
}
