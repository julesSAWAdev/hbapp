package com.example.secondexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SurveySection extends AppCompatActivity {
    TextInputLayout xsection;
    AutoCompleteTextView xsectiontxt;
    Button savecont;
    String Step;
    String[] Sections = new String[]{ "General Information","Services/Area Description","Documentation and Sanitation","Data Management","Finance Management","Pharmacy Management","Safety Management & Health Education","Treament Guideline"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_survey_section);

        xsection=findViewById(R.id.secdrop);
        xsectiontxt=findViewById(R.id.MainSection);

        savecont= findViewById(R.id.nextPage2);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, Sections);
        xsectiontxt.setAdapter(adapterDist);

        xsectiontxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Step = xsectiontxt.getText().toString();
            }
        });

        savecont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Step.equals("General Information")){
                    startActivity(new Intent(SurveySection.this, MainActivity.class));
                }
            }
        });
    }


}