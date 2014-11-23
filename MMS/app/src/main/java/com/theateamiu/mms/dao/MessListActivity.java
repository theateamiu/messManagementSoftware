package com.theateamiu.mms.dao;

import android.app.Activity;
import android.os.Bundle;

import com.theateamiu.mms.models.Mess;

import java.util.List;

/**
 * Created by AIR on 11/22/2014.
 */
public class MessListActivity extends Activity implements MessDAO {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public Mess getMessFromDB() {
        // No need to implement for Mess List
        return null;
    }

    @Override
    public void setMessToDB(Mess mess) {
        // No need to implement for Mess List
    }

    @Override
    public List<Mess> getMessListFromDB() {
        // TODO: implement this

        return null;
    }
}
