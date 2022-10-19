package com.example.secondexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.ref.SoftReference;

public class MainActivity extends AppCompatActivity {

    TextInputLayout xtypelayout, xdistlayout, xhclayout;
    AutoCompleteTextView xtypetxt, xdistricttxt,xhctxt;
    Integer Districtid;
    Button savecont;
    String[] Rulindo = new String[]{"MURAMBI Rulindo","KININI","MAREMBO","BUBANGU","BUREGA","TUMBA","KISARO","MUSHONGI","MUYANZA","KAJEVUBA","REMERA MBOGO","TARE","RULINDO","RUKOZO","BUYOGA","SHYORONGI","RUTONDE","MUYANZA","RWAHI","MASORO","KINIHIRA"};
    String[] Nyabihu = new String[]{"MWIYANIKE","BIGOGWE","KAREBA","ARUSHA","RWANKERI","SHYIRA","KINTOBO","NYAKIGEZI","KABATWA","RUREMBO","KORA","JOMBA","BIREMBO","GAKAMBA","RAMBURA","NYAKIRIBA"};
    String[] Rwamagana = new String[]{"AVEGA","NYAGASAMBU","RUBONA","MURAMBI","NYAKARIRO","GISHARI","KARENGE","MUSHA","RWAMAGANA","MUNYAGA","MWULIRE","NZIGE","MUYUMBU","GAHENGERI","RUHUNDA"};

    TextInputEditText xsector,xcells,xvillage,xpubhpost,xprihpost,xpopulation,xpatients,xbeds,xconsrooms,xhosprooms;
    private Databasehelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        xtypetxt = findViewById(R.id.typetxt);
        xdistricttxt = findViewById(R.id.districttxt);
        xhctxt = findViewById(R.id.hctxt);
        xtypelayout = findViewById(R.id.typelayout);
        xdistlayout = findViewById(R.id.distlayout);
        xhclayout = findViewById(R.id.hclayout);

        xsector = findViewById(R.id.sector);
        xcells = findViewById(R.id.cells);
        xvillage = findViewById(R.id.village);
        xpubhpost = findViewById(R.id.pubhpost);
        xprihpost = findViewById(R.id.prihpost);
        xpopulation = findViewById(R.id.population);
        xpatients = findViewById(R.id.patients);
        xbeds = findViewById(R.id.beds);
        xconsrooms = findViewById(R.id.consrooms);
        xhosprooms = findViewById(R.id.hosprooms);


        savecont=findViewById(R.id.save1);
        myDB = new Databasehelper(this);



        String[] type = new String[]{"Health center", "District Hospital"};

        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, type);
        xtypetxt.setAdapter(adapter);

        //district inflate

        final String[] Districts = new String[]{"Nyabihu", "Rulindo", "Rwamagana"};
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, Districts);
        xdistricttxt.setAdapter(adapterDist);




        //to get selected value add item click listener
        xdistricttxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String district = xdistricttxt.getText().toString();

               // Log.d("district is: ", district);

                if (district.equals("Nyabihu")){
                    Districtid = 6;
                    getHC(Districtid);


                }else if(district.equals("Rulindo")){
                    Districtid = 3;

                   getHC(Districtid);

                }else if(district.equals("Rwamagana")){
                    Districtid = 9;
                    getHC(Districtid);

                }
            }

        });


        savecont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save1();
            }
        });
    }

    private void save1() {
        final String ftype = this.xtypetxt.getText().toString().trim();
        final String fdistrict = this.xdistricttxt.getText().toString().trim();
        final String fhc = this.xhctxt.getText().toString().trim();
        final String fsector = this.xsector.getText().toString().trim();
        final String fcell = this.xcells.getText().toString().trim();
        final String fvillage = this.xvillage.getText().toString().trim();
        final String fpubhpost = this.xpubhpost.getText().toString().trim();
        final String fprihpost = this.xprihpost.getText().toString().trim();
        final String fpopulation = this.xpopulation.getText().toString().trim();
        final String fpatients = this.xpatients.getText().toString().trim();
        final String fbeds = this.xbeds.getText().toString().trim();
        final String fconsrooms = this.xconsrooms.getText().toString().trim();
        final String fhosprooms = this.xhosprooms.getText().toString().trim();

        startActivity(new Intent(MainActivity.this, SurveySection.class));

    }

    private void getHC(Integer districtid) {
        if (districtid==3){
            ArrayAdapter<String> adapterHC = new ArrayAdapter<>(this, R.layout.dropdown_item2, Rulindo);
            xhctxt.setAdapter(adapterHC);
        }else if (districtid==6){
            ArrayAdapter<String> adapterHC = new ArrayAdapter<>(this, R.layout.dropdown_item2, Nyabihu);
            xhctxt.setAdapter(adapterHC);
        }else{
            ArrayAdapter<String> adapterHC = new ArrayAdapter<>(this, R.layout.dropdown_item2, Rwamagana);
            xhctxt.setAdapter(adapterHC);
        }
    }
}