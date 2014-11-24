package com.theateamiu.mms.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class DataBaseHelper {
    private static final String DB_NAME = "mms";
    private static final int DB_VER = 1;
    private DatabaseOpenHelper databaseOpenHelper=null;
    private Context context;

    public DataBaseHelper(Context context){
        this.context = context;
    }

    private class DatabaseOpenHelper extends SQLiteOpenHelper{

        public DatabaseOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VER);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

        }
    }//end class DatabaseOpenHelper

    public SQLiteDatabase open() throws SQLException{
        if(databaseOpenHelper == null)
            return new DatabaseOpenHelper(context).getWritableDatabase();
        return databaseOpenHelper.getWritableDatabase();
    }
    public void close(){
        if(databaseOpenHelper != null){
            databaseOpenHelper.close();
            databaseOpenHelper = null;
        }
    }

}
