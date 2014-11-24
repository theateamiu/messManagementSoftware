package com.theateamiu.mms.settings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.theateamiu.mms.R;
import com.theateamiu.mms.dao.MessDAO;
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
        //init();
    }

    private void init() {
        imageViewMess = (ImageView)findViewById(R.id.ivMess);
        etMessName = (EditText)findViewById(R.id.etMessName);
        etMessPostalAddress = (EditText)findViewById(R.id.etMessPostalAddress);
        etMessDistrict = (EditText)findViewById(R.id.etMessDistrict);
        etMessRegion = (EditText)findViewById(R.id.etMessRegion);
        etStartDate = (EditText)findViewById(R.id.etStartDate);
        etEndDate = (EditText)findViewById(R.id.etEndDate);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.ivMess){

        }else if(view.getId() == R.id.bSaveMess){

        }
    }

    @Override
    public Mess getMessFromDB(long id) {
        return null;
    }

    @Override
    public void setMessToDB(Mess mess) {

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
        return null;
    }
}
