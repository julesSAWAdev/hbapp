package com.healthBuilders.surveyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Services extends AppCompatActivity {
    Button anc,vaccination,fplaning,pstock,pdispensing,ncd,ceho,cashier,accounting,laboratory,titulaire,dmanager,arv,custcare,consroom,maternity,
           hospitalization,toilets,noticeboard,close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_services);

        Intent intent = getIntent();

        final String year = getIntent().getStringExtra("year_id");
        final String district = getIntent().getStringExtra("district");
        final String hc = getIntent().getStringExtra("hc");

        anc=findViewById(R.id.ANC);
        vaccination=findViewById(R.id.vaccination);
        fplaning=findViewById(R.id.fplanning);
        pstock=findViewById(R.id.pstock);
        pdispensing=findViewById(R.id.pdispensing);
        ncd=findViewById(R.id.ncd);
        ceho=findViewById(R.id.ceho);
        cashier=findViewById(R.id.cashier);
        accounting=findViewById(R.id.accounting);
        laboratory=findViewById(R.id.laboratory);
        titulaire=findViewById(R.id.titulaire);
        dmanager=findViewById(R.id.datamanager);
        arv=findViewById(R.id.arv);
        custcare=findViewById(R.id.custocare);
        consroom=findViewById(R.id.consroom);
        maternity=findViewById(R.id.maternity);
        hospitalization=findViewById(R.id.hospitalization);
        toilets=findViewById(R.id.toilets);
        noticeboard=findViewById(R.id.noteboard);
        close=findViewById(R.id.close);



        anc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), serviceDescription.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        vaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionVaccination.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        fplaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionFamilyplanning.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        pstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionPharmacy.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        pdispensing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionPharmacyDispense.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        ncd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionNcd.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        ceho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionCeho.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        cashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionCashier.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        accounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionAccounting.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        laboratory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionLaboratory.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        titulaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionTitulaire.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        dmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionDataManager.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        arv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionArv.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        custcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionCustomerCare.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        consroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionConsultation.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        maternity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionMaternity.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        hospitalization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionHospitalization.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        toilets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionToilets.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });

        noticeboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), ServiceDescriptionNoticeboard.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
            }
        });


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String xdistrict = district.toString().trim();
                final String xyear = year.toString().trim();
                final String xhc = hc.toString().trim();

                Intent intent = new Intent(getBaseContext(), SurveySection.class);
                intent.putExtra("year_id", xyear);
                intent.putExtra("district", xdistrict);
                intent.putExtra("hc", xhc);
                startActivity(intent);
                finish();
            }
        });

    }
}