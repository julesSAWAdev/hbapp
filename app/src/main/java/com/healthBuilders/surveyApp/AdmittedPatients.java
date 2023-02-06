package com.healthBuilders.surveyApp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Locale;

public class AdmittedPatients extends AppCompatActivity {
    TextInputEditText patientid,admissiondate,dischargedate,duration,outcome;
    Button save,close;
    String[] response = new String[]{ "Yes","No"};
    Calendar myCalendar;
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admitted_patients);

        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        patientid=findViewById(R.id.patientid);
        admissiondate=findViewById(R.id.admissionDate);
        dischargedate=findViewById(R.id.dischargeDate);
        duration=findViewById(R.id.duration);
        outcome=findViewById(R.id.outcome);

        save=findViewById(R.id.save);
        close=findViewById(R.id.close);

        myCalendar=Calendar.getInstance();
        myDb = new Databasehelper(this);

        final DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);

                updateLabe();
            }
        };

        final DatePickerDialog.OnDateSetListener dateSetListener1=new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);

                updateLabel();
            }
        };

        admissiondate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(AdmittedPatients.this,dateSetListener,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });

        dischargedate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(AdmittedPatients.this,dateSetListener1,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xpatientid = patientid.getText().toString().trim();
                final String xadmissiondate = admissiondate.getText().toString().trim();
                final String xdischargedate = dischargedate.getText().toString().trim();
                final String xduration = duration.getText().toString().trim();
                final String xoutcome = outcome.getText().toString().trim();


                boolean var = myDb.registerAdmittedPatients(xyear,xdistrict,xhc,xpatientid,xadmissiondate,xdischargedate,xduration,xoutcome);
                if (var) {
                    Toast.makeText(AdmittedPatients.this, "Item recorded", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(AdmittedPatients.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AdmittedPatientsHypertension .class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);

                startActivity(intent);
            }
        });




    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        admissiondate.setText(dateFormat.format(myCalendar.getTime()));

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        dischargedate.setText(dateFormat.format(myCalendar.getTime()));

    }
}