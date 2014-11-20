package com.theateamiu.mms.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.theateamiu.mms.R;

public class SettingsActivity extends PreferenceActivity {
    public static final String MANAGER_PREF_NAME = "manager_registration";
    public static final String MESS_PREF_NAME = "mess_registration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
