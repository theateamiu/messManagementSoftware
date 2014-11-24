package com.theateamiu.mms.constituents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.theateamiu.mms.constituents.listsrowmodels.Managerial;

public class ManagerialListActivity extends Activity {
    private ListView lvManagerial;
    private ArrayAdapter<String> stringArrayAdapter;
    private ArrayAdapter<Managerial> managerialArrayAdapter;
    private final String[] strings = {"Create New Managerial"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.theateamiu.mms.R.layout.activity_managerial_list);
        setManagerialList();
    }

    private void setManagerialList() {
        lvManagerial = (ListView)findViewById(com.theateamiu.mms.R.id.lvManagerial);
        stringArrayAdapter = new ArrayAdapter<String>(ManagerialListActivity.this,
                android.R.layout.simple_expandable_list_item_1,strings);
        lvManagerial.setAdapter(stringArrayAdapter);
    }
}
