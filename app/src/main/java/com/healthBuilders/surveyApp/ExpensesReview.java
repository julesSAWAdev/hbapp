package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ExpensesReview extends AppCompatActivity {
    TextInputEditText expenseReference;
    AutoCompleteTextView expenseSigned,expenseInvoice,expenseNumbered,expenseOrdered,expenseRecorded;
    Button savecont;
    String[] response = new String[]{ "Yes","No"};
    private Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_expenses_review);

        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        expenseReference=findViewById(R.id.expenseRefnumber);
        expenseSigned=findViewById(R.id.expenseSigned);
        expenseInvoice=findViewById(R.id.expenseInvoice);
        expenseNumbered=findViewById(R.id.expenseNumbered);
        expenseOrdered=findViewById(R.id.expenseOrdered);
        expenseRecorded=findViewById(R.id.expenseRecorded);

        savecont=findViewById(R.id.saviNext);

        myDb = new Databasehelper(this);


        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        expenseSigned.setAdapter(adapterDist);
        expenseInvoice.setAdapter(adapterDist);
        expenseNumbered.setAdapter(adapterDist);
        expenseOrdered.setAdapter(adapterDist);
        expenseRecorded.setAdapter(adapterDist);

        savecont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear = year;
                final String xdistrict = district;
                final String xhc = hc;
                final String xexpenseReference = expenseReference.getText().toString().trim();
                final String xexpenseSigned = expenseSigned.getText().toString().trim();
                final String xexpenseInvoice = expenseInvoice.getText().toString().trim();
                final String xexpenseNumbered = expenseNumbered.getText().toString().trim();
                final String xexpenseOrdered = expenseOrdered.getText().toString().trim();
                final String xexpenseRecorded = expenseRecorded.getText().toString().trim();


                boolean var = myDb.registerExpenseReview(xyear, xdistrict, xhc, xexpenseReference, xexpenseSigned,xexpenseInvoice,xexpenseNumbered,xexpenseOrdered,xexpenseRecorded);
                if (var) {


                    Intent intent = new Intent(getBaseContext(), ExpensesReview.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);


                    //startActivity(intent);
                    //finish();
                    //finish();


                    Toast.makeText(ExpensesReview.this, "data saved", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(ExpensesReview.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }
}