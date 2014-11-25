package com.theateamiu.mms.constituents;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.theateamiu.mms.R;
import com.theateamiu.mms.constituents.adapters.ManagerialListAdapter;
import com.theateamiu.mms.constituents.listsrowmodels.Managerial;
import com.theateamiu.mms.dao.ManagerialDAO;
import com.theateamiu.mms.db.Column;
import com.theateamiu.mms.db.DatabaseHelper;
import com.theateamiu.mms.db.Table;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerialListActivity extends Activity implements ManagerialDAO{
    private ListView lvManagerial;
    private ArrayAdapter<String> stringArrayAdapter;

    private final String[] strings = {"Create New Managerial"};
    //List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerial_list);
    }

    @Override
    protected void onResume() {
        setManagerialList();
        super.onResume();
    }

    private void setManagerialList() {
        lvManagerial = (ListView)findViewById(com.theateamiu.mms.R.id.lvManagerial);
        List<Managerial> managerialList = getManagerialList();

        stringArrayAdapter = new ArrayAdapter<String>(ManagerialListActivity.this,
                android.R.layout.simple_expandable_list_item_1, strings);
        if(managerialList.size() == 0) {

            lvManagerial.setAdapter(stringArrayAdapter);
        }else{
            //Toast.makeText(this,""+managerialList.size(),Toast.LENGTH_LONG).show();
            ManagerialListAdapter managerialListAdapter = new ManagerialListAdapter(
                   ManagerialListActivity.this,managerialList);
            lvManagerial.setAdapter(managerialListAdapter);
        }
    }


    @Override
    public List<Managerial> getManagerialList() {
        List<Managerial> managerialList = new ArrayList<Managerial>();
        DatabaseHelper dbHelper = new DatabaseHelper(ManagerialListActivity.this);
        try {
            SQLiteDatabase db = dbHelper.open();

            Cursor cursor = db.rawQuery("Select * from "+Table.MESS,null);

            for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Managerial managerial = new Managerial();
                managerial.id = cursor.getInt(cursor.getColumnIndex(Column.ID));
                managerial.imagePath = cursor.getString(cursor.getColumnIndex(Column.IMAGE_URL));
                managerial.name = cursor.getString(cursor.getColumnIndex(Column.NAME));
                managerial.startDate = cursor.getString(cursor.getColumnIndex(Column.DATE_START));
                managerial.endDate = cursor.getString(cursor.getColumnIndex(Column.DATE_END));
                managerial.rankInDist = cursor.getInt(cursor.getColumnIndex(Column.RANK_IN_DIST));
                managerial.rankInCountry = cursor.getInt(cursor.getColumnIndex(Column.RANK_IN_COUNTRY));

                managerialList.add(managerial);
                //Toast.makeText(this,managerial.toString(),Toast.LENGTH_LONG).show();
            }

            cursor.close();
            db.close();
        } catch (SQLException e) {
            Toast.makeText(ManagerialListActivity.this,e.toString(),Toast.LENGTH_LONG).show();
        }finally {
            dbHelper.close();
        }
        return managerialList;
    }
}
