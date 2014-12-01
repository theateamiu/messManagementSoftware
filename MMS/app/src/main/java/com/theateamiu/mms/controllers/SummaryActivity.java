package com.theateamiu.mms.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.theateamiu.mms.R;
import com.theateamiu.mms.models.Managerial;
import com.theateamiu.mms.dao.SummaryDAO;
import com.theateamiu.mms.models.Summary;


public class SummaryActivity extends Activity implements SummaryDAO{
    private Managerial managerial;
    private Summary summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.all_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_boarder_list:
                Intent intent = new Intent(SummaryActivity.this, BoarderListActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_account_list:
                return true;

            case R.id.action_meal_list:
                return true;
            case R.id.action_bazaar_list:
                return true;
            case R.id.action_extra_list:
                return true;
            case R.id.action_bill_list:
                return true;
            case R.id.action_settings_list:
                return true;
            case R.id.action_contribution_list:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public Summary getSummary(long managerialId) {
        return null;
    }

    @Override
    public boolean updateCurrentManagerialSummary(long managerialId) {
        return false;
    }
}
