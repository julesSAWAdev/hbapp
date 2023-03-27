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

public class DataManagementMaternal extends AppCompatActivity {
    EditText deadunderfive,maternalyear,obsetricalANC,registrations,referalsANC,obsetricalMaternity,deliveries,livebirths,maternaldeaths,neonataldeaths,stillbirths,postpartun,anc4,anc1,underfivedeaths,childrenconsulted,contraceptiveusers,mr2vaccines,ultrasoundscans;
    Button savenext;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_data_management_maternal);


        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

         maternalyear=findViewById(R.id.maternalyear);
         obsetricalANC=findViewById(R.id.maternalobsetrical);
         registrations=findViewById(R.id.maternalregistrations);
         referalsANC=findViewById(R.id.maternalreferals);
         obsetricalMaternity=findViewById(R.id.maternalmaternity);
         deliveries=findViewById(R.id.maternaldeliveries);
         livebirths=findViewById(R.id.maternalbirths);
         maternaldeaths=findViewById(R.id.maternaldeaths);
         neonataldeaths=findViewById(R.id.maternalneonataldeath);
         stillbirths=findViewById(R.id.maternalstillbirths);
         postpartun=findViewById(R.id.maternalpostpartum);
         anc4=findViewById(R.id.maternalanc4);
         anc1=findViewById(R.id.maternalanc1);
         underfivedeaths=findViewById(R.id.maternalfivedeaths);
         childrenconsulted=findViewById(R.id.maternalchildconsulted);
         contraceptiveusers=findViewById(R.id.maternalcontraceptives);
         mr2vaccines=findViewById(R.id.maternalmr2);
         ultrasoundscans=findViewById(R.id.maternalultrasound);
         deadunderfive=findViewById(R.id.deadUnderFive);

         savenext=findViewById(R.id.maternalNext);

        myDb = new Databasehelper(this);

        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xmaternalyear=maternalyear.getText().toString().trim();
                final String xobsetricalANC=obsetricalANC.getText().toString().trim();
                final String xregistrations=registrations.getText().toString().trim();
                final String xreferalsANC=referalsANC.getText().toString().trim();
                final String xobsetricalMaternity=obsetricalMaternity.getText().toString().trim();
                final String xdeliveries=deliveries.getText().toString().trim();
                final String xlivebirths=livebirths.getText().toString().trim();
                final String xmaternaldeaths=maternaldeaths.getText().toString().trim();
                final String xneonataldeaths=neonataldeaths.getText().toString().trim();
                final String xstillbirths=stillbirths.getText().toString().trim();
                final String xpostpartun=postpartun.getText().toString().trim();
                final String xanc4=anc4.getText().toString().trim();
                final String xanc1=anc1.getText().toString().trim();
                final String xunderfivedeaths=underfivedeaths.getText().toString().trim();
                final String xchildrenconsulted=childrenconsulted.getText().toString().trim();
                final String xcontraceptiveusers=contraceptiveusers.getText().toString().trim();
                final String xmr2vaccines=mr2vaccines.getText().toString().trim();
                final String xultrasoundscans=ultrasoundscans.getText().toString().trim();
                final String xdeadunderfive=deadunderfive.getText().toString().trim();


                boolean var = myDb.registerMaternalNeonatal(xyear,xdistrict,xhc,xmaternalyear,xobsetricalANC,xregistrations,xreferalsANC,xobsetricalMaternity,xdeliveries,xlivebirths,
                        xmaternaldeaths,xneonataldeaths,xstillbirths,xpostpartun,xanc4,xanc1,xunderfivedeaths,xchildrenconsulted,xcontraceptiveusers,xmr2vaccines,xultrasoundscans,xdeadunderfive);
                if (var) {


                    Intent intent = new Intent(getBaseContext(), commentSection1.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    Toast.makeText(DataManagementMaternal.this, "Survey Section recorded", Toast.LENGTH_SHORT).show();

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(DataManagementMaternal.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });

    }
}