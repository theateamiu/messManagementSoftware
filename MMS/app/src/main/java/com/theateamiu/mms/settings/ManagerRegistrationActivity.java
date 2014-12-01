package com.theateamiu.mms.settings;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.theateamiu.mms.R;
import com.theateamiu.mms.dao.ManagerDAO;
import com.theateamiu.mms.dao.ManagerDAOImpl;
import com.theateamiu.mms.models.Manager;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ManagerRegistrationActivity extends Activity implements View.OnClickListener {
    private static final int PICK_POSTER = 0;
    private Manager manager;
    private ManagerDAO managerDAO;

    private ImageView ivManager;
    private EditText etName;
    private EditText etAge;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etProfession;
    private EditText etPostalAddress;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button bSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_manager);
        init();
    }


    private void init() {
        manager = new Manager();
        ivManager = (ImageView)findViewById(R.id.ivManager);
        etName = (EditText)findViewById(R.id.etManagerName);
        etAge = (EditText)findViewById(R.id.etManagerAge);
        etPhone = (EditText)findViewById(R.id.etManagerPhoneNumber);
        etEmail = (EditText)findViewById(R.id.etManagerEmail);

        etProfession = (EditText)findViewById(R.id.etManagerProfession);
        etPostalAddress = (EditText)findViewById(R.id.etManagerPostalAddress);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword);

        bSave = (Button)findViewById(R.id.bSaveManager);
        bSave.setOnClickListener(this);
        ivManager.setOnClickListener(this);
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
                        ivManager.setImageDrawable(drawable);
                        manager.setImageURL(imageUri.toString());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivManager:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_POSTER);
                break;
            case R.id.bSaveManager:
                if(setManagerFields()){
                    managerDAO = new ManagerDAOImpl(ManagerRegistrationActivity.this);
                    managerDAO.updateManagerOnSharedPreferences(manager);
                    Toast.makeText(ManagerRegistrationActivity.this,"Saved Successfully",
                            Toast.LENGTH_LONG).show();
                    try {
                        Thread.sleep(SettingsActivity.THREAD_DELAY);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }

    private boolean setManagerFields() {
        View focusView=null;
        boolean cancel = false;
        clearErrors();

        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();

        if(password.length() < 4){
            etPassword.setError("Password is too short");
            cancel = true;
            focusView = etPassword;
        }else if(!password.equals(confirmPassword)){
            etConfirmPassword.setError("Password not matched");
            cancel = true;
            focusView = etConfirmPassword;
        }else{
            manager.setPassword(password);
        }

        String postalAddress = etPostalAddress.getText().toString();
        if (TextUtils.isEmpty(postalAddress)){
            etPostalAddress.setError("Address is required");
            cancel = true;
            focusView = etPostalAddress;
        }else{
            manager.setAddress(postalAddress);
        }

        String profession = etProfession.getText().toString();
        if(TextUtils.isEmpty(profession)){
            etProfession.setError("Profession is required");
            cancel = true;
            focusView = etProfession;
        }else{
            manager.setProfession(profession);
        }

        String email = etEmail.getText().toString();
        if(!email.contains("@")){
            etEmail.setError("Invalid Email");
            cancel = true;
            focusView = etEmail;
        }else {
            manager.setEmail(email);
        }

        String phoneNo = etPhone.getText().toString();
        // TODO: also check for only digits, and valid phone no.
        if(TextUtils.isEmpty(phoneNo)){
            etPhone.setError("Invalid Phone Number");
            cancel = true;
            focusView = etPhone;
        }else{
            manager.setPhoneNo(phoneNo);
        }

        try{
            int age = Integer.parseInt(etAge.getText().toString());
            manager.setAge(age);
        }catch (NumberFormatException e){
            etAge.setError("Invalid Age");
            cancel = true;
            focusView = etAge;
        }

        String name = etName.getText().toString();
        if(TextUtils.isEmpty(name)){
            etName.setError("Name should be given");
            cancel = true;
            focusView = etName;
        }else {
            manager.setName(name);
        }

        if(manager.getImageURL() == null){
            Toast.makeText(ManagerRegistrationActivity.this,"Image is Required.",
                    Toast.LENGTH_LONG).show();
            cancel = true;
            focusView = ivManager;
        }

        if(cancel){
            focusView.requestFocus();
            return false;
        }

        return true;
    }

    private void clearErrors() {
        etName.setError(null);
        etAge.setError(null);
        etPhone.setError(null);
        etEmail.setError(null);
        etProfession.setError(null);
        etPostalAddress.setError(null);
        etPassword.setError(null);
        etConfirmPassword.setError(null);
    }

}
