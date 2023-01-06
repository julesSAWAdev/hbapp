package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

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
            final String xdistrict = district.toString().trim();
            final String xyear = year.toString().trim();
            final String xhc = hc.toString().trim();
               // Log.d("year", xyear);
                //Log.d("district", xdistrict);
                //Log.d("Hc", xhc);
                if (Step.equals("General Information")){
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra("year_id", xyear);
                    intent.putExtra("district", xdistrict);
                    intent.putExtra("hc", xhc);
                    startActivity(intent);

                }else if (Step.equals("Services/Area Description")){

                    Intent intent = new Intent(getBaseContext(), Services.class);
                    intent.putExtra("year_id", xyear);
                    intent.putExtra("district", xdistrict);
                    intent.putExtra("hc", xhc);
                    startActivity(intent);


                }else if(Step.equals("Documentation and Sanitation")){
                    Intent intent = new Intent(getBaseContext(), DocumentationActionPlan.class);
                    intent.putExtra("year_id", xyear);
                    intent.putExtra("district", xdistrict);
                    intent.putExtra("hc", xhc);
                    startActivity(intent);

                }else if(Step.equals("Data Management")){
                    Intent intent = new Intent(getBaseContext(), Datamanagement_Sop.class);
                    intent.putExtra("year_id", xyear);
                    intent.putExtra("district", xdistrict);
                    intent.putExtra("hc", xhc);
                    startActivity(intent);
                }else if (Step.equals("Finance Management")){
                    Intent intent = new Intent(getBaseContext(), FinanceManagementSop.class);
                    intent.putExtra("year_id", xyear);
                    intent.putExtra("district", xdistrict);
                    intent.putExtra("hc", xhc);
                    startActivity(intent);

                }
            }
        });
    }


}