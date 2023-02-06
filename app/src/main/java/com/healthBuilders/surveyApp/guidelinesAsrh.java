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

public class guidelinesAsrh extends AppCompatActivity {
    AutoCompleteTextView registers,spaces,rooms;
    Button save;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guidelines_asrh);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        myDb = new Databasehelper(this);

        //hooks
        registers=findViewById(R.id.Registers);
        spaces=findViewById(R.id.Spaces);
        rooms=findViewById(R.id.Rooms);
        save=findViewById(R.id.Savebtn);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        registers.setAdapter(adapterDist);
        spaces.setAdapter(adapterDist);
        rooms.setAdapter(adapterDist);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xregisters = registers.getText().toString().trim();
                final String xspaces = spaces.getText().toString().trim();
                final String xrooms = rooms.getText().toString().trim();



                boolean var = myDb.registerASRH(xyear,xdistrict,xhc,xregisters,xspaces,xrooms);
                if (var) {
                    Toast.makeText(guidelinesAsrh.this, "Item recorded", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), inpatientsCare .class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                }else{
                    Toast.makeText(guidelinesAsrh.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}