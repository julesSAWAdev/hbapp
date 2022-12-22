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

public class Accounts extends AppCompatActivity {
    AutoCompleteTextView accReco,accBook;
    Button savecont;
    String[] response = new String[]{ "Yes","No"};
    private Databasehelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_accounts);

        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        accReco = findViewById(R.id.accreco);
        accBook = findViewById(R.id.accbook);
        savecont = findViewById(R.id.saviNext);

        myDb = new Databasehelper(this);


        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);
        accBook.setAdapter(adapterDist);
        accReco.setAdapter(adapterDist);

        savecont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear = year;
                final String xdistrict = district;
                final String xhc = hc;
                final String xaccreco = accReco.getText().toString().trim();
                final String xaccbook = accBook.getText().toString().trim();


                boolean var = myDb.registerAccounts(xyear, xdistrict, xhc, xaccreco, xaccbook);
                if (var) {


                    Intent intent = new Intent(getBaseContext(), ExpensesReview.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);


                    startActivity(intent);
                    finish();


                    Toast.makeText(Accounts.this, "data saved", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(Accounts.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }
}