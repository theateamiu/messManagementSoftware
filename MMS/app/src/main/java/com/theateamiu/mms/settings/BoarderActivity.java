package com.theateamiu.mms.settings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.theateamiu.mms.R;
import com.theateamiu.mms.dao.BoarderDAO;
import com.theateamiu.mms.models.Boarder;

import java.util.List;

public class BoarderActivity extends Activity implements BoarderDAO,View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarder);
    }



    @Override
    public void onClick(View view) {

    }

    @Override
    public void setBoarder(Boarder boarder) {

    }

    @Override
    public Boarder getBoarder(String phoneNo) {
        return null;
    }

    @Override
    public boolean updateBoarder(long id) {
        return false;
    }

    @Override
    public List<Boarder> getAllBoarders() {
        return null;
    }
}
