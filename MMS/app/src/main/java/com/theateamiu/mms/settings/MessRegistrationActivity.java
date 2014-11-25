package com.theateamiu.mms.settings;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.theateamiu.mms.R;
import com.theateamiu.mms.dao.MessDAO;
import com.theateamiu.mms.db.Column;
import com.theateamiu.mms.db.DatabaseHelper;
import com.theateamiu.mms.db.Table;
import com.theateamiu.mms.models.Manager;
import com.theateamiu.mms.models.Mess;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessRegistrationActivity extends Activity implements MessDAO, View.OnClickListener {
    public static final int PICK_POSTER = 0;

    private Mess mess = null;
    private ImageView imageViewMess;
    private EditText etMessName;
    private EditText etMessPostalAddress;
    private EditText etMessDistrict;
    private EditText etMessRegion;
    private EditText etStartDate;
    private EditText etEndDate;
    private Button bSaveMess;
    private Button bShowMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_registration);
        init();
    }

    private void init() {
        mess = new Mess();
        imageViewMess = (ImageView) findViewById(R.id.ivMess);
        etMessName = (EditText) findViewById(R.id.etMessName);
        etMessPostalAddress = (EditText) findViewById(R.id.etMessPostalAddress);
        etMessDistrict = (EditText) findViewById(R.id.etMessDistrict);
        etMessRegion = (EditText) findViewById(R.id.etMessRegion);
        etStartDate = (EditText) findViewById(R.id.etStartDate);
        etEndDate = (EditText) findViewById(R.id.etEndDate);
        bSaveMess = (Button) findViewById(R.id.bSaveMess);
        bShowMess = (Button) findViewById(R.id.bShowMess);

        imageViewMess.setOnClickListener(this);
        bSaveMess.setOnClickListener(this);
        bShowMess.setOnClickListener(this);
    }

    private void reset() {
        mess = new Mess();
        imageViewMess.setImageDrawable(getResources().getDrawable(R.drawable.content_picture));
        etMessName.setText(null);
        etMessPostalAddress.setText(null);
        etMessDistrict.setText(null);
        etMessRegion.setText(null);
        etStartDate.setText(null);
        etEndDate.setText(null);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ivMess) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_POSTER);
        } else if (view.getId() == R.id.bSaveMess) {
            setMess();

            // TODO: validate mess data, if not valid just return;
            setMessToDB(mess);
            reset();

            Toast.makeText(MessRegistrationActivity.this, "Mess Successfully Registered!",
                    Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.bShowMess) {
            getMessListFromDB();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICK_POSTER:
                if (resultCode == RESULT_OK) {
                    Uri imageUri = data.getData();
                    try {
                        InputStream is = getContentResolver().openInputStream(
                                imageUri);
                        Drawable drawable = Drawable.createFromStream(is, "");
                        imageViewMess.setImageDrawable(drawable);
                        mess.setImageURL(imageUri.toString());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
        // super.onActivityResult(requestCode, resultCode, data);
    }

    private void setMess() {

        mess.setName(etMessName.getText().toString());
        mess.setCountryRank(0);
        mess.setDistrict(etMessDistrict.getText().toString());
        mess.setDistrictRank(0);
        mess.setEndDate(etEndDate.getText().toString());

        SharedPreferences sharedPreferences = getSharedPreferences(
                getString(R.string.preference_name_manager), MODE_PRIVATE);
        String managerEmail = sharedPreferences.getString(Manager.MANAGER_EMAIL,
                Manager.DEFAULT_VALUE);
        mess.setManagerEmail(managerEmail);

        mess.setPostalAddress(etMessPostalAddress.getText().toString());
        mess.setRegion(etMessRegion.getText().toString());
        mess.setStartDate(etStartDate.getText().toString());
    }

    @Override
    public Mess getMessFromDB(long id) {
        return null;
    }

    @Override
    public void setMessToDB(Mess mess) {
        ContentValues cv = new ContentValues(10);
        DatabaseHelper databaseHelper = new DatabaseHelper(MessRegistrationActivity.this);
        try {
            SQLiteDatabase db = databaseHelper.open();
            cv.put(Column.NAME, mess.getName());
            cv.put(Column.IMAGE_URL, mess.getImageURL());
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
            System.out.println(mess);
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
        DatabaseHelper databaseHelper = new DatabaseHelper(MessRegistrationActivity.this);
        try {
            SQLiteDatabase db = databaseHelper.open();
            Cursor cursor = db.rawQuery("select * from " + Table.MESS, null);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                String s = cursor.getString(cursor.getColumnIndex(Column.ID));
                s = s + "\n" + cursor.getString(cursor.getColumnIndex(Column.NAME));
                s = s + "\n" + cursor.getString(cursor.getColumnIndex(Column.IMAGE_URL));
                s = s + "\n" + cursor.getString(cursor.getColumnIndex(Column.DATE_START));
                s = s + "\n" + cursor.getString(cursor.getColumnIndex(Column.DATE_END));

                Toast.makeText(MessRegistrationActivity.this, s, Toast.LENGTH_LONG).show();
            }

            cursor.close();
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseHelper.close();
        }
        return null;
    }
}
