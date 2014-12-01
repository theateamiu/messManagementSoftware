package com.theateamiu.mms.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.theateamiu.mms.db.Column;
import com.theateamiu.mms.db.DatabaseHelper;
import com.theateamiu.mms.db.Table;
import com.theateamiu.mms.models.Mess;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessDAOImpl implements MessDAO{
    private Context context;


    public MessDAOImpl(Context context){
        this.context = context;

    }
    @Override
    public Mess getMessFromDB(long id) {
        return null;
    }

    @Override
    public void setMessToDB(Mess mess) {
        ContentValues cv = new ContentValues(10);
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        try {
            SQLiteDatabase db = databaseHelper.open();
            cv.put(Column.NAME, mess.getName());
            cv.put(Column.IMAGE_URI, mess.getImageURL());
            cv.put(Column.POSTAL_ADDRESS, mess.getPostalAddress());
            cv.put(Column.DISTRICT, mess.getDistrict());
            cv.put(Column.REGION, mess.getRegion());
            cv.put(Column.DATE_START, mess.getStartDate());
            cv.put(Column.DATE_END, mess.getEndDate());
            cv.put(Column.RANK_IN_DIST, mess.getDistrictRank());
            cv.put(Column.RANK_IN_COUNTRY, mess.getCountryRank());
            cv.put(Column.EMAIL_MANAGER, mess.getManagerEmail());

            db.insert(Table.MESS, Column.NAME, cv);
            db.close();
            //System.out.println(mess);
            //Toast.makeText(MessRegistrationActivity.this,mess.toString(),Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseHelper.close();
        }
    }

    @Override
    public boolean updateMessOnDB(long id) {
        return false;
    }

    @Override
    public Mess deleteMessFromDB(long id) {
        return null;
    }

    @Override
    public List<Mess> getMessListFromDB() {
        List<Mess> messList = new ArrayList<Mess>();
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        try {
            SQLiteDatabase db = databaseHelper.open();
            Cursor cursor = db.rawQuery("select * from " + Table.MESS, null);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Mess mess = new Mess();



                messList.add(mess);
            }

            cursor.close();
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseHelper.close();
        }
        return messList;
    }
}
