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

public class FinanceManagementSop extends AppCompatActivity {
    EditText fyear,cbank,cpetty,creceivable,cpayable,cpharmacy,crevenue,chcincome,cmedecines,cexpenses,chrexpenses,cexpenditure,
            cpmedecines,cequipments,ctravel,cabudget,cpbudget;
    Button savecont;
    private ProgressDialog progressDialog;
    private Databasehelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_finance_management_sop);


        Intent intent = getIntent();
        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        fyear=findViewById(R.id.financeYear);
        cbank=findViewById(R.id.closeBank);
        cpetty=findViewById(R.id.closePetty);
        creceivable=findViewById(R.id.closeReceivable);
        cpayable=findViewById(R.id.closePaybles);
        cpharmacy=findViewById(R.id.closePharmacy);
        crevenue=findViewById(R.id.closeRevenue);
        chcincome=findViewById(R.id.closeIncome);
        cmedecines=findViewById(R.id.closeSells);
        cexpenses=findViewById(R.id.closeExpenses);
        chrexpenses=findViewById(R.id.closeHrExpenses);
        cexpenditure=findViewById(R.id.closeExpenditure);
        cpmedecines=findViewById(R.id.closePurchasedMedecine);
        cequipments=findViewById(R.id.closeMedicalEquipments);
        ctravel=findViewById(R.id.closeTravel);
        cabudget=findViewById(R.id.closeBudget);
        cpbudget=findViewById(R.id.closePbudget);



        savecont=findViewById(R.id.saniNext);

        myDb = new Databasehelper(this);


        savecont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String xyear= year;
                final String xdistrict = district;
                final String xhc= hc;
                final String xfyear=fyear.getText().toString().trim();
                final String xcbank=cbank.getText().toString().trim();
                final String xcpetty=cpetty.getText().toString().trim();
                final String xcreceivable=creceivable.getText().toString().trim();
                final String xcpayable=cpayable.getText().toString().trim();
                final String xcpharmacy=cpharmacy.getText().toString().trim();
                final String xcrevenue=crevenue.getText().toString().trim();
                final String xchcincome=chcincome.getText().toString().trim();
                final String xcmedecines=cmedecines.getText().toString().trim();
                final String xcexpenses=cexpenses.getText().toString().trim();
                final String xchrexpenses=chrexpenses.getText().toString().trim();
                final String xcexpenditure=cexpenditure.getText().toString().trim();
                final String xcpmedecines=cpmedecines.getText().toString().trim();
                final String xcequipments=cequipments.getText().toString().trim();
                final String xctravel=ctravel.getText().toString().trim();
                final String xcabudget=cabudget.getText().toString().trim();
                final String xcpbudget=cpbudget.getText().toString().trim();

                boolean var = myDb.RegisterFinanceReview(xyear,xdistrict,xhc,xfyear,xcbank,xcpetty,xcreceivable,xcpayable,xcpharmacy,xcrevenue,xchcincome,xcmedecines,
                        xcexpenses,xchrexpenses,xcexpenditure,xcpmedecines,xcequipments,xctravel,xcabudget,xcpbudget);
                if (var) {


                    Intent intent = new Intent(getBaseContext(), InsuranceReview.class);
                    intent.putExtra("year_id", year);
                    intent.putExtra("district", district);
                    intent.putExtra("hc", hc);


                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(FinanceManagementSop.this, "An error occured", Toast.LENGTH_SHORT).show();

                }
            }


        });

    }


}