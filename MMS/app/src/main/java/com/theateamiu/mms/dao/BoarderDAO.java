package com.theateamiu.mms.dao;


import com.theateamiu.mms.models.Boarder;

import java.util.List;

public interface BoarderDAO {
    public void setBoarder(Boarder boarder);

    public Boarder getBoarder(String phoneNo);
    public boolean updateBoarder(long id);

    public List<Boarder> getAllBoarders();
}
