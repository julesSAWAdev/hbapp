package com.healthBuilders.surveyApp;

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

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class startPage extends AppCompatActivity {
    TextInputLayout xsurvey, xdisdrop,xhcdrop;
    AutoCompleteTextView xdistricttxt, xhealthcentertxt;
    Integer Districtid;
    Button savecont;
    String[] Rulindo = new String[]{"MURAMBI Rulindo","KININI","MAREMBO","BUBANGU","BUREGA","TUMBA","KISARO","MUSHONGI","MUYANZA","KAJEVUBA","REMERA MBOGO","TARE","RULINDO","RUKOZO","BUYOGA","SHYORONGI","RUTONDE","MUYANZA","RWAHI","MASORO","KINIHIRA"};
    String[] Nyabihu = new String[]{"MWIYANIKE","BIGOGWE","KAREBA","ARUSHA","RWANKERI","SHYIRA","KINTOBO","NYAKIGEZI","KABATWA","RUREMBO","KORA","JOMBA","BIREMBO","GAKAMBA","RAMBURA","NYAKIRIBA"};
    String[] Rwamagana = new String[]{"AVEGA","NYAGASAMBU","RUBONA","MURAMBI","NYAKARIRO","GISHARI","KARENGE","MUSHA","RWAMAGANA","MUNYAGA","MWULIRE","NZIGE","MUYUMBU","GAHENGERI","RUHUNDA"};

    TextInputEditText xsurveyyear;
    private Databasehelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_page);



        xsurveyyear=findViewById(R.id.etsurvey);
        xdistricttxt=findViewById(R.id.MainDist);
        xhealthcentertxt= findViewById(R.id.Mainhc);

        savecont= findViewById(R.id.nextPage1);


        final String[] Districts = new String[]{"Nyabihu", "Rulindo", "Rwamagana"};
        ArrayAdapter<String> adapterDist = new ArrayAdapter<>(this, R.layout.dropdown_item2, Districts);
        xdistricttxt.setAdapter(adapterDist);

        //to get selected value add item click listener
        xdistricttxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String district = xdistricttxt.getText().toString();

                Log.d("district is: ", district);

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
    private void getHC(Integer districtid) {
        if (districtid==3){
            ArrayAdapter<String> adapterHC = new ArrayAdapter<>(this, R.layout.dropdown_item2, Rulindo);
            xhealthcentertxt.setAdapter(adapterHC);
        }else if (districtid==6){
            ArrayAdapter<String> adapterHC = new ArrayAdapter<>(this, R.layout.dropdown_item2, Nyabihu);
            xhealthcentertxt.setAdapter(adapterHC);
        }else{
            ArrayAdapter<String> adapterHC = new ArrayAdapter<>(this, R.layout.dropdown_item2, Rwamagana);
            xhealthcentertxt.setAdapter(adapterHC);
        }
    }
    private void save1() {

        final String year = this.xsurveyyear.getText().toString().trim();
        final String district = this.xdistricttxt.getText().toString().trim();
        final String hc = this.xhealthcentertxt.getText().toString().trim();
        Intent intent = new Intent(getBaseContext(), SurveySection.class);
        intent.putExtra("year_id", year);
        intent.putExtra("district", district);
        intent.putExtra("hc", hc);

        startActivity(intent);

    }
}