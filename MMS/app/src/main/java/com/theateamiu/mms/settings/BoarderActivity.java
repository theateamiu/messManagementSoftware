package com.theateamiu.mms.settings;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.theateamiu.mms.R;
import com.theateamiu.mms.dao.BoarderDAO;
import com.theateamiu.mms.db.Column;
import com.theateamiu.mms.db.DatabaseHelper;
import com.theateamiu.mms.db.Table;
import com.theateamiu.mms.models.Boarder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class BoarderActivity extends Activity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener,BoarderDAO {
    private static final int PICK_POSTER = 0;

    private Boarder boarder;
    private Intent boarderIntent;

    private ImageView ivBoarder;
    private EditText etBoarderName;
    private EditText etBoarderPhoneNo;
    private EditText etBoarderEmail;
    private EditText etBoarderProfession;
    private EditText etBoarderDOB;
    private Spinner spinnerBoarderBG;
    private Button bSaveBoarder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarder);
        //boarderIntent = getIntent();
        init();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    private void init() {
        boarder = new Boarder();
        ivBoarder = (ImageView)findViewById(R.id.ivBoarder);
        etBoarderName = (EditText)findViewById(R.id.etBoarderName);
        etBoarderPhoneNo = (EditText)findViewById(R.id.etBoarderPhoneNo);
        etBoarderEmail = (EditText)findViewById(R.id.etBoarderEmail);
        etBoarderProfession = (EditText)findViewById(R.id.etBoarderProfession);
        etBoarderDOB = (EditText)findViewById(R.id.etBoarderDOB);
        spinnerBoarderBG = (Spinner)findViewById(R.id.spinnerBloodGroup);
        bSaveBoarder = (Button)findViewById(R.id.bSaveBoarder);

        bSaveBoarder.setOnClickListener(this);
        ivBoarder.setOnClickListener(this);
        spinnerBoarderBG.setOnItemSelectedListener(this);
    }


    // this method is for update tasks
    private void setBoardersToView() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bSaveBoarder:

                // TODO: check for validity, if something is not valid just return;
                buildBoarder();
                setBoarderToDB(boarder);
                //boarderIntent.putExtra("boarder",boarder);
                Toast.makeText(getApplicationContext(),"Boarder saved successfully.",
                        Toast.LENGTH_LONG).show();
                //finish();
                break;
            case R.id.ivBoarder:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_POSTER);
                break;
            default:
        }
    }

    private void buildBoarder() {
        /* TODO: apply TextUtils.isEmpty on every field
        // if empty set error, and return
        // on writing text reset error to null
        */

        boarder.setName(etBoarderName.getText().toString());
        boarder.setPhoneNo(etBoarderPhoneNo.getText().toString());
        boarder.setEmail(etBoarderEmail.getText().toString());
        boarder.setProfession(etBoarderProfession.getText().toString());
        boarder.setDateOfBirth(etBoarderDOB.getText().toString());
        boarder.setBloodGroup((String)spinnerBoarderBG.getSelectedItem());

        // TODO: get managerial id from sharedPreferences
        boarder.setManagerialID(0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICK_POSTER:
                if (resultCode == RESULT_OK) {
                    //Toast.makeText(this,"RESULT_OK",Toast.LENGTH_LONG).show();
                    Uri imageUri = data.getData();
                    try {
                        InputStream is = getContentResolver().openInputStream(
                                imageUri);
                        Drawable drawable = Drawable.createFromStream(is, "");
                        ivBoarder.setImageDrawable(drawable);
                        boarder.setImageURL(imageUri.toString());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
        // super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,(String)parent.getSelectedItem(),Toast.LENGTH_LONG).show();
        //boarder.setBloodGroup((String)parent.getItemAtPosition(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //boarder.setBloodGroup((String)parent.getItemAtPosition(0));
        //Toast.makeText(this,(String)parent.getSelectedItem(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void setBoarderToDB(Boarder boarder) {
        ContentValues contentValues = new ContentValues(8);
        DatabaseHelper databaseHelper = new DatabaseHelper(BoarderActivity.this);
        try {
            SQLiteDatabase db = databaseHelper.open();
            //contentValues.clear();

            contentValues.put(Column.NAME,boarder.getName());
            contentValues.put(Column.PHONE_NO,boarder.getPhoneNo());
            contentValues.put(Column.EMAIL,boarder.getEmail());
            contentValues.put(Column.PROFESSION,boarder.getProfession());
            contentValues.put(Column.DATE_OF_BIRTH,boarder.getDateOfBirth());
            contentValues.put(Column.BLOOD_GROUP,boarder.getBloodGroup());
            contentValues.put(Column.IMAGE_URI,boarder.getImageURL());
            contentValues.put(Column.MANAGERIAL_ID,boarder.getManagerialID());

            db.insert(Table.BOARDERS,null,contentValues);
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseHelper.close();
        }
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
        return null;
    }
}
