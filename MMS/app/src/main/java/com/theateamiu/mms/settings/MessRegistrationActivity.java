package com.theateamiu.mms.settings;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.theateamiu.mms.R;
import com.theateamiu.mms.models.Mess;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MessRegistrationActivity extends Activity implements View.OnClickListener {
    private static final int PICK_POSTER = 0;

    private Mess mess = null;
    private ImageView imageViewMess;
    private EditText etMessName;
    private EditText etMessPostalAddress;
    private EditText etMessDistrict;
    private EditText etMessRegion;
    private EditText etStartDate;
    private EditText etEndDate;
    private Button bSaveMess;
    //private Button bShowMess;

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
       // bShowMess = (Button) findViewById(R.id.bShowMess);

        imageViewMess.setOnClickListener(this);
        bSaveMess.setOnClickListener(this);
       // bShowMess.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ivMess) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_POSTER);
        } else if (view.getId() == R.id.bSaveMess) {

        } else if (view.getId() == R.id.bShowMess) {

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
}
