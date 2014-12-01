package com.theateamiu.mms.controllers;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.theateamiu.mms.R;
import com.theateamiu.mms.controllers.adapters.BoarderListAdapter;
import com.theateamiu.mms.dao.BoarderDAO;
import com.theateamiu.mms.db.Column;
import com.theateamiu.mms.db.DatabaseHelper;
import com.theateamiu.mms.db.Query;
import com.theateamiu.mms.models.Boarder;
import com.theateamiu.mms.settings.BoarderActivity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoarderListActivity extends Activity implements BoarderDAO,View.OnClickListener {
    private String[] strings = {"No Boarder.\nto create click here"};
    private ArrayAdapter<String> stringArrayAdapter;
    private ListView lvBoarderList;
    //List<Boarder> boarderList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarder_list);
        init();
    }

    private void init() {
        lvBoarderList = (ListView)findViewById(R.id.lvBoarderList);
        //lvBoarderList.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        // TODO: there is a problem on loading; use AsyncTask
        loadBoarders();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.boarder_list,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_boarder_add:
                Intent intent = new Intent(BoarderListActivity.this, BoarderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadBoarders() {

        List<Boarder> boarderList = getAllBoardersFromDB();
        //It's ok. Toast.makeText(this,"list size: "+boarderList.size(),Toast.LENGTH_LONG).show();
        if (boarderList.size() == 0){
            lvBoarderList.setAdapter(new ArrayAdapter(BoarderListActivity.this,
                    android.R.layout.simple_list_item_1,strings));
        }else {
            BoarderListAdapter boarderListAdapter = new BoarderListAdapter(getApplicationContext(),
                    boarderList);
            lvBoarderList.setAdapter(boarderListAdapter);
        }
    }



    @Override
    public void onClick(View view) {

    }

    @Override
    public void setBoarderToDB(Boarder boarder) {
        //
    }

    @Override
    public Boarder getBoarderFromDB(String phoneNo) {
        return null;
    }

    @Override
    public boolean updateBoarderToDB(long id) {
        return false;
    }

    @Override
    public List<Boarder> getAllBoardersFromDB() {
        List<Boarder> boarderList=new ArrayList<Boarder>();
        DatabaseHelper dbHelper = new DatabaseHelper(BoarderListActivity.this);
        try {
            SQLiteDatabase db = dbHelper.open();

            Cursor cursor = db.rawQuery(Query.SELECT_ALL_BOARDER,null);

            for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Boarder boarder = new Boarder();

                boarder.setName(cursor.getString(cursor.getColumnIndex(Column.NAME)));
                boarder.setPhoneNo(cursor.getString(cursor.getColumnIndex(Column.PHONE_NO)));
                boarder.setEmail(cursor.getString(cursor.getColumnIndex(Column.EMAIL)));
                boarder.setProfession(cursor.getString(cursor.getColumnIndex(Column.PROFESSION)));
                boarder.setDateOfBirth(cursor.getString(cursor.getColumnIndex(Column.DATE_OF_BIRTH)));
                boarder.setBloodGroup(cursor.getString(cursor.getColumnIndex(Column.BLOOD_GROUP)));
                boarder.setImageURL(cursor.getString(cursor.getColumnIndex(Column.IMAGE_URI)));
                boarder.setManagerialID(cursor.getLong(cursor.getColumnIndex(Column.MANAGERIAL_ID)));

                boarderList.add(boarder);
                //Toast.makeText(getApplicationContext(),boarder.toString(), Toast.LENGTH_LONG).show();
            }

            cursor.close();
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbHelper.close();
        }
        return boarderList;
    }

}
