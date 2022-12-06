package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class DocumentationReceivableRegisters extends AppCompatActivity {
    AutoCompleteTextView available,tracked;
    Button savenext;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_documentation_receivable_registers);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        available=findViewById(R.id.Receivableavailable);
        tracked=findViewById(R.id.Receivabletrack);

        savenext=findViewById(R.id.Receivablenext);

        myDb = new Databasehelper(this);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        available.setAdapter(adapterDist);
        tracked.setAdapter(adapterDist);

        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xavailable=available.getText().toString().trim();
                final String xtracked=tracked.getText().toString().trim();

                boolean var = myDb.registerDocumentationReceivables(xyear,xdistrict,xhc,xavailable,xtracked);
                if (var) {


                Intent intent = new Intent(getBaseContext(), DocumentationMalaria.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);


                startActivity(intent);
                finish();
                }else{
                 Toast.makeText(DocumentationReceivableRegisters.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });
    }
}