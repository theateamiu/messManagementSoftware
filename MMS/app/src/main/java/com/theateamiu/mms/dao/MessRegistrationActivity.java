package com.theateamiu.mms.dao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.theateamiu.mms.R;
import com.theateamiu.mms.models.Mess;

import java.util.List;

public class MessRegistrationActivity extends Activity implements MessDAO,View.OnClickListener {
    private Mess mess;
    private ImageView imageViewMess;
    private EditText etMessName;
    private EditText etMessPostalAddress;
    private EditText etMessDistrict;
    private EditText etMessRegion;
    private EditText etStartDate;
    private EditText etEndDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_registration);
        init();
    }

    private void init() {

    }

    @Override
    public Mess getMessFromDB() {
        // TODO: load mess data from
        return null;
    }

    @Override
    public void setMessToDB(Mess mess) {
        // TODO
    }

    @Override
    public List<Mess> getMessListFromDB() {
        // No need to implement for Mess List
        return null;
    }

    @Override
    public void onClick(View view) {

    }
}
