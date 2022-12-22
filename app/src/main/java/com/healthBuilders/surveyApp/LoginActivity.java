package com.healthBuilders.surveyApp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    // initializing components of the login layout
    final String TAG = "Login";
    Button callSignUp,loginbtn,forget;
    TextView logotext,slogan;
    ImageView image;
    TextInputLayout username,password;
    TextInputEditText etEmailAddress;
    TextInputEditText etPassword;
    ProgressBar loading;
    private ProgressDialog progressDialog;
    private Databasehelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressDialog = new ProgressDialog(this);
        setContentView(R.layout.activity_login);


        callSignUp = findViewById(R.id.do_register);
        image = findViewById(R.id.logoImage);
        logotext = findViewById(R.id.logo_name);
        slogan = findViewById(R.id.slogan);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.login);
        forget = findViewById(R.id.forgot);
        etEmailAddress = findViewById(R.id.etusername);
        etPassword = findViewById(R.id.etpassword);
        loading = findViewById(R.id.loading);

        myDB = new Databasehelper(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginAction();
            }
        });
        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,Registration.class);

                Pair[] pairs = new Pair[8];
                pairs[0] = new Pair<View,String>(image,"logo_image");
                pairs[1] = new Pair<View,String>(logotext,"logo_text");
                pairs[2] = new Pair<View,String>(slogan,"logo_desc");
                pairs[3] = new Pair<View,String>(username,"username_trans");
                pairs[4] = new Pair<View,String>(password,"user_trans");
                pairs[5] = new Pair<View,String>(loginbtn,"login_trans");
                pairs[6] = new Pair<View,String>(callSignUp,"acc_trans");
                pairs[7] = new Pair<View,String>(forget,"forg_trans");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    // ActivityOptions options =ActivityOptions.makeSceneTransitionAnimation(login.this,pairs);
                    startActivity(intent);
                    // finish();
                }
            }
        });

    }

    private void loginAction(){
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //Without this user can hide loader by tapping outside screen
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait");
        progressDialog.show();


        final String username = this.etEmailAddress.getText().toString().trim();
        final String password = this.etPassword.getText().toString().trim();

        if(username.isEmpty()){
            etEmailAddress.setError("Email or phone required");


            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.dismiss();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();

            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.dismiss();
            return;
        }

        boolean var = myDB.userCheck(username,password);
        if (var){
            Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, startPage.class));

        }else{
            Toast.makeText(LoginActivity.this, "User not found or incorrect credentials", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();

        }


    }


}