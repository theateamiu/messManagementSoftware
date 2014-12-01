package com.theateamiu.mms.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.theateamiu.mms.R;

public class SettingsActivity extends PreferenceActivity {
    public static final int THREAD_DELAY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }


}
