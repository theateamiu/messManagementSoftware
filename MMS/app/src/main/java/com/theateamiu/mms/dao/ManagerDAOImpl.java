package com.theateamiu.mms.dao;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.theateamiu.mms.R;
import com.theateamiu.mms.models.Manager;

public class ManagerDAOImpl extends Activity implements View.OnClickListener {
    public static final String DEFAULT_VALUE="No Value";
    Manager manager;
    SharedPreferences sharedPreferences;

    private ImageView ivManager;
    private EditText etName;
    private EditText etAge;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etProfession;
    private EditText etPostalAddress;
    private EditText etDistrict;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button bSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_manager);
        init();
    }

    private void setManagerLayout() {
        //TODO set ImageView

        etName.setText(manager.getName());
        etAge.setText(String.valueOf(manager.getAge()));
        etPhone.setText(manager.getPhoneNo());
        etEmail.setText(manager.getEmail());
        etProfession.setText(manager.getProfession());
        etPostalAddress.setText(manager.getAddress());

    }

    private void init() {
        ivManager = (ImageView)findViewById(R.id.userImageView);
        etName = (EditText)findViewById(R.id.etManagerName);
        etAge = (EditText)findViewById(R.id.etManagerAge);
        etPhone = (EditText)findViewById(R.id.etManagerPhoneNumber);
        etEmail = (EditText)findViewById(R.id.etManagerEmail);

        etProfession = (EditText)findViewById(R.id.etManagerProfession);
        etPostalAddress = (EditText)findViewById(R.id.etManagerPostalAddress);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword);

        bSave = (Button)findViewById(R.id.bSaveManager);

        sharedPreferences = getSharedPreferences(getString(R.string.preference_name_manager),
                MODE_PRIVATE);
        manager = new Manager();
        loadManagerFromPreference();
        setManagerLayout();

        bSave.setOnClickListener(this);


    }

    private void saveManagerToPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        View focusView;

        editor.putString(Manager.MANAGER_NAME,etName.getText().toString());
        editor.putString(Manager.MANAGER_AGE,etAge.getText().toString());
        editor.putString(Manager.MANAGER_PHONE_NO,etPhone.getText().toString());
        editor.putString(Manager.MANAGER_EMAIL,etEmail.getText().toString());
        editor.putString(Manager.MANAGER_PROFESSION,etProfession.getText().toString());
        editor.putString(Manager.MANAGER_ADDRESS,etPostalAddress.getText().toString());
        editor.putString(Manager.MANAGER_PASSWORD,etPassword.getText().toString());

        editor.commit();

    }

    private void loadManagerFromPreference() {
        //TODO set Image URL
        manager.setName(sharedPreferences.getString(Manager.MANAGER_NAME,DEFAULT_VALUE));
        manager.setAge(Integer.parseInt(sharedPreferences.
                getString(Manager.MANAGER_AGE, "0")));
        manager.setPhoneNo(sharedPreferences.getString(Manager.MANAGER_PHONE_NO,DEFAULT_VALUE));
        manager.setEmail(sharedPreferences.getString(Manager.MANAGER_EMAIL,DEFAULT_VALUE));
        manager.setProfession(sharedPreferences.getString(Manager.MANAGER_PROFESSION,DEFAULT_VALUE));
        manager.setAddress(sharedPreferences.getString(Manager.MANAGER_ADDRESS,DEFAULT_VALUE));
        manager.setPassword(sharedPreferences.getString(Manager.MANAGER_PASSWORD,DEFAULT_VALUE));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.userImageView:
                break;
            case R.id.bSaveManager:
                saveManagerToPreference();
                break;
            default:
                break;
        }
    }
}
