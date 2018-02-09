package com.example.amit.a163054001_recorddata;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Amit on 24-01-2018.
 */

public class LoginActivity  extends MainActivity{
    private EditText inputFName,inputLName, inputAge, inputEmail, inputMobile;
    private Button loginbtn;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setSelectedNavigationItem(0);
        setContentView(R.layout.login);

        inputFName = (EditText) findViewById(R.id.enterfname);
        inputLName = (EditText) findViewById(R.id.enterlname);
        inputEmail = (EditText) findViewById(R.id.enteremail);
        inputAge = (EditText) findViewById(R.id.enterage);
        inputMobile = (EditText) findViewById(R.id.entermobile);
        loginbtn = (Button) findViewById(R.id.login_btn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=submitForm();
                if(result==1) {
                    Intent intent = new Intent(LoginActivity.this, SensorActivity.class);
                    startActivity(intent);
                }
                }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.record_item:
                    Intent intent = new Intent(LoginActivity.this,RecordActivity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                   break;

            }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
            if(itemPosition ==1){
                Intent intent = new Intent(LoginActivity.this,SensorActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        if(itemPosition ==2){
            Intent intent = new Intent(LoginActivity.this,RecordActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
        return true;
        //return super.onNavigationItemSelected(itemPosition, itemId);
    }



    /**
     * Validating form
     */
    private int submitForm() {
        if (!validateName()) {
            return 0;
        }
        if (!validateMobile()) {
            return 0;
        }

        if (!validateEmail()) {
            return 0;
        }

        if (!validateAge()) {
            return 0;
        }
        Toast.makeText(getApplicationContext(), "Login successful!!!", Toast.LENGTH_SHORT).show();
        return 1;
    }

    private boolean validateName() {
        if (inputFName.getText().toString().trim().isEmpty()) {
            inputFName.setError(getString(R.string.err_msg));
            //requestFocus(inputFName);
            Toast.makeText(getApplicationContext(), "Error: Enter first name", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (inputLName.getText().toString().trim().isEmpty()){
            inputLName.setError(getString(R.string.err_msg));
            //requestFocus(inputFName);
            Toast.makeText(getApplicationContext(), "Error: Enter last name", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            // inputFName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputEmail.setError(getString(R.string.err_msg));
            Toast.makeText(getApplicationContext(), "Error: Enter correct email", Toast.LENGTH_SHORT).show();
            //requestFocus(inputEmail);
            return false;
        } else {
            //inputEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateMobile() {
        String mobile = inputMobile.getText().toString().trim();

        if (mobile.isEmpty() || !isValidMobile(mobile)) {
            inputMobile.setError(getString(R.string.err_msg));
            Toast.makeText(getApplicationContext(), "Error: Enter correct 10 digit mobile", Toast.LENGTH_SHORT).show();
            //requestFocus(inputEmail);
            return false;
        } else {
            //inputEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAge() {
        int age = Integer.parseInt(inputAge.getText().toString());
        //String age = inputAge.getText().toString().trim();

        if ( !isValidAge(age)) {
            inputAge.setError(getString(R.string.err_msg));
            Toast.makeText(getApplicationContext(), "Error: Enter correct age between 10 to 99", Toast.LENGTH_SHORT).show();
            //requestFocus(inputEmail);
            return false;
        } else {
            //inputEmail.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    private static boolean isValidMobile(String mobile) {
        if(mobile.length() !=10)
            return false;
        else
            return true;
    }

    private static boolean isValidAge(int age) {
        if(age>=100  || age<10)
            return false;
        else
            return true;
    }

}
