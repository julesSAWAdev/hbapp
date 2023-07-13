package com.healthBuilders.surveyApp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Locale;

public class InsuranceReview extends AppCompatActivity {
    TextInputEditText invoiceCBHI,invoiceRSSB,invoiceMMI,returnCBHI,returnRSSB,returnMMI,verifyCBHI,verifyRSSB,verifyMMI,
                        amountCBHI,amountRSSB,amountMMI,afterCBHI,afterRSSB,afterMMI,fyear,ivperiod;
    Calendar myCalendar;
    Button savecont,close;
    private ProgressDialog progressDialog;
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_insurance_review);


        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");
        final String section = getIntent().getStringExtra("section");


        fyear=findViewById(R.id.financeYear);
        ivperiod=findViewById(R.id.period);

        invoiceCBHI=findViewById(R.id.invoicecbhi);
        invoiceMMI=findViewById(R.id.invoicemmi);
        invoiceRSSB=findViewById(R.id.invoicerssb);

        returnCBHI=findViewById(R.id.returncbhi);
        returnRSSB=findViewById(R.id.returnrssb);
        returnMMI=findViewById(R.id.returnmmi);

        verifyRSSB=findViewById(R.id.verifyrssb);
        verifyMMI=findViewById(R.id.verifymmi);
        verifyCBHI=findViewById(R.id.verifycbhi);

        amountCBHI=findViewById(R.id.amountcbhi);
        amountRSSB=findViewById(R.id.amountrssb);
        amountMMI=findViewById(R.id.amountmmi);


        afterCBHI=findViewById(R.id.aftercbhi);
        afterRSSB=findViewById(R.id.afterrssb);
        afterMMI=findViewById(R.id.aftermmi);


        savecont=findViewById(R.id.saviNext);
        close=findViewById(R.id.Close);
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

                updateLabe1();
            }
        };
        final DatePickerDialog.OnDateSetListener dateSetListener2=new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);

                updateLabe2();
            }
        };




        final DatePickerDialog.OnDateSetListener dateSetListener3=new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);

                updateLabe3();
            }
        };
        final DatePickerDialog.OnDateSetListener dateSetListener4=new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);

                updateLabe4();
            }
        };
        final DatePickerDialog.OnDateSetListener dateSetListener5=new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);

                updateLabe5();
            }
        };

        final DatePickerDialog.OnDateSetListener dateSetListener6=new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);

                updateLabe6();
            }
        };
        final DatePickerDialog.OnDateSetListener dateSetListener7=new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);

                updateLabe7();
            }
        };

        invoiceCBHI.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(InsuranceReview.this,dateSetListener,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });

        invoiceRSSB.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(InsuranceReview.this,dateSetListener1,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });
        invoiceMMI.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(InsuranceReview.this,dateSetListener2,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });



        returnCBHI.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(InsuranceReview.this,dateSetListener3,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });

        returnRSSB.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(InsuranceReview.this,dateSetListener4,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });
        returnMMI.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(InsuranceReview.this,dateSetListener5,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });

        verifyCBHI.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(InsuranceReview.this,dateSetListener6,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });

        verifyRSSB.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(InsuranceReview.this,dateSetListener6,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }


        });

        verifyMMI.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                new DatePickerDialog(InsuranceReview.this,dateSetListener7,
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
                final String xfyear=fyear.getText().toString().trim();
                final String xivperiod=ivperiod.getText().toString().trim();
                final String xinvoiceCBHI=invoiceCBHI.getText().toString();
                final String xinvoiceRSSB=invoiceRSSB.getText().toString();
                final String xinvoiceMMI=invoiceMMI.getText().toString();
                final String xreturnCBHI=returnCBHI.getText().toString();
                final String xreturnRSSB=returnRSSB.getText().toString();
                final String xreturnMMI=returnMMI.getText().toString();
                final String xverifyCBHI=verifyCBHI.getText().toString();
                final String xverifyRSSB=verifyRSSB.getText().toString();
                final String xverifyMMI=verifyMMI.getText().toString();
                final String xamountCBHI=amountCBHI.getText().toString();
                final String xamountRSSB=amountRSSB.getText().toString();
                final String xamountMMI=amountMMI.getText().toString();
                final String xafterCBHI=afterCBHI.getText().toString();
                final String xafterRSSB=afterRSSB.getText().toString();
                final String xafterMMI=afterMMI.getText().toString();

                boolean var = myDb.RegisterAssuranceReview(xyear,xdistrict,xhc,xfyear,xivperiod,xinvoiceCBHI,xinvoiceRSSB,xinvoiceMMI,xreturnCBHI,xreturnRSSB,xreturnMMI,
                        xverifyRSSB,xverifyMMI,xamountCBHI,xamountRSSB,xamountMMI,xafterCBHI,xafterRSSB,xafterMMI,xverifyCBHI);
                if (var) {
                    fyear.setText("");
                    ivperiod.setText("");
                    invoiceCBHI.setText("");
                    invoiceRSSB.setText("");
                    invoiceMMI.setText("");
                    returnCBHI.setText("");
                    returnRSSB.setText("");
                    returnMMI.setText("");
                    verifyRSSB.setText("");
                    verifyMMI.setText("");
                    amountCBHI.setText("");
                    amountRSSB.setText("");
                    amountMMI.setText("");
                    afterCBHI.setText("");
                    afterRSSB.setText("");
                    afterMMI.setText("");
                    Toast.makeText(InsuranceReview.this, "Data saved", Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(InsuranceReview.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), IncomeReview.class);
                intent.putExtra("year_id", year);
                intent.putExtra("district", district);
                intent.putExtra("hc", hc);


                startActivity(intent);
                finish();
            }


        });


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        invoiceCBHI.setText(dateFormat.format(myCalendar.getTime()));

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe1() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        invoiceRSSB.setText(dateFormat.format(myCalendar.getTime()));

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe2() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        invoiceMMI.setText(dateFormat.format(myCalendar.getTime()));

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe3() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        returnCBHI.setText(dateFormat.format(myCalendar.getTime()));

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe4() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        returnRSSB.setText(dateFormat.format(myCalendar.getTime()));

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe5() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        returnMMI.setText(dateFormat.format(myCalendar.getTime()));

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe6() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        verifyRSSB.setText(dateFormat.format(myCalendar.getTime()));

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe7() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        verifyMMI.setText(dateFormat.format(myCalendar.getTime()));

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabe8() {
        String myFormat ="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        verifyCBHI.setText(dateFormat.format(myCalendar.getTime()));

    }





}