package com.theateamiu.mms.dao;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.theateamiu.mms.db.Column;
import com.theateamiu.mms.db.DatabaseHelper;
import com.theateamiu.mms.db.Table;
import com.theateamiu.mms.models.Managerial;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerialDAOImpl implements ManagerialDAO{
    private Context context;

    public ManagerialDAOImpl(Context context){
        this.context = context;
    }

    @Override
    public List<Managerial> getManagerialList() {
        List<Managerial> managerialList = new ArrayList<Managerial>();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        try {
            SQLiteDatabase db = dbHelper.open();

            Cursor cursor = db.rawQuery("Select * from "+ Table.MESS,null);

            for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Managerial managerial = new Managerial();
                managerial.setId(cursor.getInt(cursor.getColumnIndex(Column.ID)));
                managerial.setImagePath(cursor.getString(cursor.getColumnIndex(Column.IMAGE_URI)));
                managerial.setName(cursor.getString(cursor.getColumnIndex(Column.NAME)));
                managerial.setStartDate(cursor.getString(cursor.getColumnIndex(Column.DATE_START)));
                managerial.setEndDate(cursor.getString(cursor.getColumnIndex(Column.DATE_END)));
                managerial.setRankInDist(cursor.getInt(cursor.getColumnIndex(Column.RANK_IN_DIST)));
                managerial.setRankInCountry(cursor.getInt(cursor.getColumnIndex(Column.RANK_IN_COUNTRY)));

                managerialList.add(managerial);
                //Toast.makeText(this,managerial.toString(),Toast.LENGTH_LONG).show();
            }

            cursor.close();
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbHelper.close();
        }
        return managerialList;
    }
}
