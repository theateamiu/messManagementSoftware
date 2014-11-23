package com.theateamiu.mms.dao;

import com.theateamiu.mms.models.Boarder;

import java.util.List;

public interface BoarderListDAO {
    public Boarder deleteABoarder(long id);
    public boolean updateABoarder(long id);
    public List<Boarder> getAllBoarder();
    public Boarder getABoarder(long id);
}
