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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Locale;

public class IncomeReview extends AppCompatActivity {
    TextInputEditText incomeDate,journalIncome,receiptIncome;
    AutoCompleteTextView incomeMatch;
    Button savecont,close;
    String[] response = new String[]{ "Yes","No"};
    Calendar myCalendar;
     private ProgressDialog progressDialog;
    private Databasehelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_income_review);

        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        incomeDate=findViewById(R.id.incomeDate);
        journalIncome=findViewById(R.id.journalIncome);
        receiptIncome=findViewById(R.id.receiptIncome);

        incomeMatch=findViewById(R.id.incomeMatch);

        savecont=findViewById(R.id.saviNext);
        close=findViewById(R.id.Close);

        myCalendar=Calendar.getInstance();
        myDb = new Databasehelper(this);

        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        incomeMatch.setAdapter(adapterDist);


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

        incomeDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(IncomeReview.this,dateSetListener,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });

        savecont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xincomeDate=incomeDate.getText().toString().trim();
                final String xjournalIncome=journalIncome.getText().toString().trim();
                final String xreceiptIncome=receiptIncome.getText().toString().trim();
                final String xincomeMatch=incomeMatch.getText().toString().trim();

                boolean var = myDb.registerIncomeReview(xyear,xdistrict,xhc,xincomeDate,xjournalIncome,xreceiptIncome,xincomeMatch);
                if (var) {

                    Toast.makeText(IncomeReview.this, "data saved", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(IncomeReview.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(getBaseContext(), Accounts.class);
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
        incomeDate.setText(dateFormat.format(myCalendar.getTime()));

    }
}