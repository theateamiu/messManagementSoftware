package com.theateamiu.mms.dao;

import com.theateamiu.mms.models.Manager;

public interface ManagerDAO {
    public static final String DEFAULT_VALUE="";
    public static final String MANAGER_IMAGE_URI = "manager_image_uri";
    public static final String MANAGER_NAME = "manager_name";
    public static final String MANAGER_AGE = "manager_age";
    public static final String MANAGER_PHONE_NO = "manager_phone_no";
    public static final String MANAGER_EMAIL = "manager_email";
    public static final String MANAGER_PROFESSION = "manager_profession";
    public static final String MANAGER_ADDRESS = "manager_address";
    public static final String MANAGER_PASSWORD = "manager_password";


    public Manager getManagerFromSharedPreferences();
    public boolean updateManagerOnSharedPreferences(Manager manager);
}
