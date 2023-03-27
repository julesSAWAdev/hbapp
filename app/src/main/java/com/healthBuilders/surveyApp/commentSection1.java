package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class commentSection1 extends AppCompatActivity {
    TextInputEditText comment;
    Button saveClose;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_section1);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");

      comment = findViewById(R.id.Comment);
      saveClose = findViewById(R.id.saveNExt);

        myDb = new Databasehelper(this);


        saveClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear = year;
                final String xdistrict = district;
                final String xhc = hc;
                final String xsection = section;
                final String xcomment = comment.getText().toString().trim();


                boolean var = myDb.registerComment(xyear, xdistrict, xhc, xsection,xcomment);
                if (var) {
                    Toast.makeText(commentSection1.this, "Item recorded", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), SurveySection.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(commentSection1.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}