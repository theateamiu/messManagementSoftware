package com.theateamiu.mms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.theateamiu.mms.settings.SettingsActivity;

public class LoginActivity extends FragmentActivity {

    private UserLoginTask userLoginTask;

    private String email,password;

    private EditText etEmail;
    private EditText etPassword;
    private TextView tvLoginStatusMessage;
    private View vLoginForm;
    private View vLoginStatus;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);

        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if(id == R.id.login || id == EditorInfo.IME_NULL){
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        vLoginForm = findViewById(R.id.login_form);
        vLoginStatus = findViewById(R.id.login_status);
        tvLoginStatusMessage = (TextView)findViewById(R.id.login_status_message);

        findViewById(R.id.bSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        sharedPreferences = getSharedPreferences(getString(R.string.preference_name_manager),MODE_PRIVATE);
    }

    private void attemptLogin() {
        if(userLoginTask != null){
            return;
        }

        // Reset errors
        etEmail.setError(null);
        etPassword.setError(null);

        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for valid password
        if(TextUtils.isEmpty(password)){
            //etPassword.setError(getString(R.string.error_field_required));
            //focusView = etPassword;
            //cancel = true;
            new TryAgainDialogFragment().show(getSupportFragmentManager(),null);
            return;
        }else if(password.length() < 4){
            etPassword.setError(getString(R.string.error_invalid_password));
            focusView = etPassword;
            cancel = true;
        }

        // Check for valid email address
        if(TextUtils.isEmpty(email)){
            //etEmail.setError(getString(R.string.error_field_required));
            //focusView = etEmail;
            //cancel = true;
            new TryAgainDialogFragment().show(getSupportFragmentManager(),null);
            return;
        }else if(!email.contains("@")){
            etEmail.setError(getString(R.string.error_invalid_email));
            focusView = etEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            tvLoginStatusMessage.setText(R.string.login_progress_signing_in);
            //showProgress(true);
            userLoginTask = new UserLoginTask();
            userLoginTask.execute((Void) null);
        }

    }


    public class UserLoginTask extends AsyncTask<Void,Void,Boolean>{

        @Override
        protected Boolean doInBackground(Void... voids) {
            String storedEmail=null,storedPassword=null;

            try{
                storedEmail = sharedPreferences.getString("email","");
                storedPassword = sharedPreferences.getString("password","");
                Thread.sleep(1000);
            }catch(InterruptedException e){
                return false;
            }

            if(storedEmail.equals(email)){
                return storedPassword.equals(password);
            }

            // TODO: register the new account here.

            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            userLoginTask = null;
            showProgress(false);

            if (success) {
                finish();
            } else {
                //mPasswordView.setError(getString(R.string.error_incorrect_password));
                //mPasswordView.requestFocus();
                new TryAgainDialogFragment().show(getSupportFragmentManager(),null);
            }
        }

        @Override
        protected void onCancelled() {
            userLoginTask = null;
            showProgress(false);
        }
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(
                    android.R.integer.config_shortAnimTime);

            vLoginStatus.setVisibility(View.VISIBLE);
            vLoginStatus.animate().setDuration(shortAnimTime)
                    .alpha(show ? 1 : 0)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            vLoginStatus.setVisibility(show ? View.VISIBLE
                                    : View.GONE);
                        }
                    });

            vLoginForm.setVisibility(View.VISIBLE);
            vLoginForm.animate().setDuration(shortAnimTime)
                    .alpha(show ? 0 : 1)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            vLoginForm.setVisibility(show ? View.GONE
                                    : View.VISIBLE);
                        }
                    });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            vLoginStatus.setVisibility(show ? View.VISIBLE : View.GONE);
            vLoginForm.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public static class TryAgainDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.try_again_message)
                    .setPositiveButton(R.string.register, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            startActivity(new Intent(getActivity(),SettingsActivity.class));
                        }
                    })
                    .setNegativeButton(R.string.try_again, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }//end class TryAgainDialog
}
