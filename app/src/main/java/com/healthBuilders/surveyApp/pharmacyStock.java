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

import com.google.android.material.textfield.TextInputEditText;

public class pharmacyStock extends AppCompatActivity {
    TextInputEditText drugname,drugquantity,drugquantityshelf;
    AutoCompleteTextView drugavailable,drugexpired,drugrequested,drugstockcard,drugstockcardfilled,drugexcess,
                        druginventory,druglabel;
    String[] response = new String[]{ "Yes","No","N/A"};
    private ProgressDialog progressDialog;
    private Databasehelper myDb;
    Button saveItem,closePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pharmacy_stock);


        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        drugname=findViewById(R.id.drugName);
        drugquantity=findViewById(R.id.drugQuantity);
        drugquantityshelf=findViewById(R.id.drugQuantityShelf);


        drugavailable=findViewById(R.id.drugAvailable);
        drugexpired=findViewById(R.id.drugExpired);
        drugrequested=findViewById(R.id.drugRequested);
        drugstockcard=findViewById(R.id.drugStockCard);
        drugstockcardfilled=findViewById(R.id.drugStockCardFilled);
        drugexcess=findViewById(R.id.drugExcess);
        druginventory=findViewById(R.id.drugInventory);
        druglabel=findViewById(R.id.drugLabel);

        saveItem=findViewById(R.id.saveItem);
        closePage=findViewById(R.id.closePage);

        //adapter
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, response);

        //set adapters
        drugavailable.setAdapter(adapterDist);
        drugexpired.setAdapter(adapterDist);
        drugrequested.setAdapter(adapterDist);
        drugstockcard.setAdapter(adapterDist);
        drugstockcardfilled.setAdapter(adapterDist);
        drugexcess.setAdapter(adapterDist);
        druginventory.setAdapter(adapterDist);
        druglabel.setAdapter(adapterDist);


        myDb = new Databasehelper(this);

        closePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent = new Intent(getBaseContext(), SurveySection.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);

                    startActivity(intent);
                }
              });

        saveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xdrugname= drugname.getText().toString().trim();
                final String xdrugquantity= drugquantity.getText().toString().trim();
                final String xdrugquantityshelf= drugquantityshelf.getText().toString().trim();
                final String xdrugavailable= drugavailable.getText().toString().trim();
                final String xdrugexpired= drugexpired.getText().toString().trim();
                final String xdrugrequested= drugrequested.getText().toString().trim();
                final String xdrugstockcard= drugstockcard.getText().toString().trim();
                final String xdrugstockcardfilled= drugstockcardfilled.getText().toString().trim();
                final String xdrugexcess= drugexcess.getText().toString().trim();
                final String xdruginventory= druginventory.getText().toString().trim();
                final String xdruglabel= druglabel.getText().toString().trim();

                boolean var = myDb.registerPharmacyStock(xyear,xdistrict,xhc,xdrugname,xdrugquantity,xdrugquantityshelf,xdrugavailable,xdrugexpired,xdrugrequested,xdrugstockcard,xdrugstockcardfilled,xdrugexcess,xdruginventory,xdruglabel);
                if (var) {
                    Toast.makeText(pharmacyStock.this, "Item recorded", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(pharmacyStock.this, "An error occured", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}