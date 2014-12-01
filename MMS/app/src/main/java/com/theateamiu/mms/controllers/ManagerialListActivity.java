package com.theateamiu.mms.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.theateamiu.mms.R;
import com.theateamiu.mms.controllers.adapters.ManagerialListAdapter;
import com.theateamiu.mms.dao.ManagerialDAOImpl;
import com.theateamiu.mms.models.Managerial;

import java.util.List;

public class ManagerialListActivity extends Activity implements AdapterView.OnItemClickListener {
    private ListView lvManagerial;
    private ArrayAdapter<String> stringArrayAdapter;
    private ManagerialDAOImpl managerialDAO;
    private final String[] strings = {"No Managerial"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerial_list);

        lvManagerial = (ListView)findViewById(com.theateamiu.mms.R.id.lvManagerial);
        lvManagerial.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        setManagerialList();
        super.onResume();
    }

    private void setManagerialList() {
        managerialDAO = new ManagerialDAOImpl(ManagerialListActivity.this);
        List<Managerial> managerialList = managerialDAO.getManagerialList();

        if(managerialList.size() == 0) {
            stringArrayAdapter = new ArrayAdapter<String>(ManagerialListActivity.this,
                    android.R.layout.simple_expandable_list_item_1, strings);
            lvManagerial.setAdapter(stringArrayAdapter);
        }else{
            //Toast.makeText(this,""+managerialList.size(),Toast.LENGTH_LONG).show();
            ManagerialListAdapter managerialListAdapter = new ManagerialListAdapter(
                   getApplicationContext(),managerialList);
            lvManagerial.setAdapter(managerialListAdapter);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(ManagerialListActivity.this, SummaryActivity.class);
        startActivity(intent);
        finish();
    }
}
