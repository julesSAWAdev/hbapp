package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private Button callLogin,register;
    private EditText firstname,lastname,email,password,passwordConf;
    private ProgressBar loading;
    ImageView image;
    private ProgressDialog progressDialog;
    private Databasehelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressDialog = new ProgressDialog(this);
        setContentView(R.layout.activity_registration);

        //hooks
        callLogin = findViewById(R.id.acc_exist);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        passwordConf = findViewById(R.id.conf_pass);
        register = findViewById(R.id.register);
        loading = findViewById(R.id.loading);
        image =findViewById(R.id.logoImage);

        myDb = new Databasehelper(this);


        callLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });


    }

    private void Register() {
        if (!validateFname() | !validatelname() | !validateEmail() | !validatePassword() | !Password1n2Validate())
            return;

        else {
        final String firstname = this.firstname.getText().toString();
        final String lastname = this.lastname.getText().toString();
        final String email = this.email.getText().toString();
        final String password = this.password.getText().toString();
        final String passwordconf = this.passwordConf.getText().toString();

        boolean var = myDb.registerUSer(firstname,lastname,email,password);
        if (var){
            Toast.makeText(Registration.this,"user added succesfuly",Toast.LENGTH_SHORT);
            startActivity(new Intent(Registration.this, LoginActivity.class));
            finish();
        }else{
            Toast.makeText(Registration.this, "An error occured", Toast.LENGTH_SHORT).show();
        }
       }



    }

    private boolean validateFname(){
        String val = firstname.getText().toString();
        if (val.isEmpty()){
            firstname.setError("first name can't be empty");
            return false;
        }else{
            firstname.setError(null);
            return true;
        }
    }
    private boolean validatelname(){
        String val = lastname.getText().toString();
        if (val.isEmpty()){
            lastname.setError("last name can't be empty");
            return false;
        }else{
            lastname.setError(null);
            return true;
        }
    }
    private boolean validateEmail(){
        String val = email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()){
            email.setError("Email can't be empty");
            return false;
        }else if(!val.matches(emailPattern)){
            email.setError("Invalid email Address");
            return false;
        } else{
            email.setError(null);
            return true;
        }
    }
    private boolean validatePassword(){
        String val = password.getText().toString();
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";

        if (val.isEmpty()){
            password.setError("Password can't be empty");
            return false;
        }else if(!val.matches(PASSWORD_PATTERN)){
            password.setError("Weak password");
            return false;
        } else{
            password.setError(null);
            return true;
        }
    }
    private boolean Password1n2Validate(){
        String val1 = password.getText().toString();
        String val2 = passwordConf.getText().toString();
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";

        if (val1.equals(val2)) {
            passwordConf.setError(null);
            return true;
        } else{
            passwordConf.setError("Passwords don't match");
            return false;
        }
    }


}