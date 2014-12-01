package com.theateamiu.mms.dao;


import com.theateamiu.mms.models.Boarder;

import java.util.List;

public interface BoarderDAO {
    public void setBoarderToDB(Boarder boarder);

    public Boarder getBoarderFromDB(String phoneNo);
    public boolean updateBoarderToDB(long id);

    public List<Boarder> getAllBoardersFromDB();
}
