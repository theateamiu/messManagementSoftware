package com.theateamiu.mms.dao;


import android.content.Context;
import android.content.SharedPreferences;

import com.theateamiu.mms.R;
import com.theateamiu.mms.models.Manager;

public class ManagerDAOImpl implements ManagerDAO{
    private SharedPreferences sharedPreferences;
    private Context context;

    public ManagerDAOImpl(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.
                getString(R.string.preference_name_manager),context.MODE_PRIVATE);
    }

    @Override
    public Manager getManagerFromSharedPreferences() {
        Manager manager = new Manager();
        manager.setImageURL(sharedPreferences.getString(MANAGER_IMAGE_URI,DEFAULT_VALUE));
        manager.setName(sharedPreferences.getString(MANAGER_NAME,DEFAULT_VALUE));
        manager.setAge(sharedPreferences.getInt(MANAGER_AGE,0));
        manager.setPhoneNo(sharedPreferences.getString(MANAGER_PHONE_NO,DEFAULT_VALUE));
        manager.setEmail(sharedPreferences.getString(MANAGER_EMAIL,DEFAULT_VALUE));
        manager.setProfession(sharedPreferences.getString(MANAGER_PROFESSION,DEFAULT_VALUE));
        manager.setAddress(sharedPreferences.getString(MANAGER_ADDRESS,DEFAULT_VALUE));
        manager.setPassword(sharedPreferences.getString(MANAGER_PASSWORD,DEFAULT_VALUE));

        return manager;
    }

    @Override
    public boolean updateManagerOnSharedPreferences(Manager manager) {
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putString(MANAGER_NAME,manager.getName());
        editor.putInt(MANAGER_AGE, manager.getAge());
        editor.putString(MANAGER_PHONE_NO,manager.getPhoneNo());
        editor.putString(MANAGER_EMAIL,manager.getEmail());
        editor.putString(MANAGER_PROFESSION,manager.getProfession());
        editor.putString(MANAGER_ADDRESS,manager.getAddress());
        editor.putString(MANAGER_PASSWORD,manager.getPassword());

        editor.commit();
        return true;
    }
}
