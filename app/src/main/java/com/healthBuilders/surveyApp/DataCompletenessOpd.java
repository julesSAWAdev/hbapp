package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataCompletenessOpd extends AppCompatActivity {
    EditText lines,fields,blanks;
    Button savenext,closenext;
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_data_completeness_opd);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        lines=findViewById(R.id.line);
        fields=findViewById(R.id.fields);
        blanks=findViewById(R.id.blanks);

        savenext=findViewById(R.id.deliveryNext);
        closenext=findViewById(R.id.closeNext);

        myDb = new Databasehelper(this);

        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xlines=lines.getText().toString().trim();
                final String xfields=fields.getText().toString().trim();
                final String xblanks=blanks.getText().toString().trim();

                boolean var = myDb.registerDatamanagementOpdRegisters(xyear,xdistrict,xhc,xlines,xfields,xblanks);
                if (var) {

                    Toast.makeText(DataCompletenessOpd.this, "Line recorded", Toast.LENGTH_LONG).show();
                    lines.setText("");
                    fields.setText("");
                    blanks.setText("");
                }else{
                    Toast.makeText(DataCompletenessOpd.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });

        closenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), DataManagementMaternal.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);


                    startActivity(intent);
            }


        });
    }
}