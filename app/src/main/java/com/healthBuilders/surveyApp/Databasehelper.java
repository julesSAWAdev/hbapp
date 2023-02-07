package com.healthBuilders.surveyApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hbexercise";
    private static final String TABLE_NAME = "users";

    private static final String COL_1 = "ID";
    private static final String COL_2 = "FNAME";
    private static final String COL_3 = "LNAME";
    private static final String COL_4 = "EMAIL";
    private static final String COL_5 = "PASSWORD";

    private static final String TABLE_NAME2 = "BASIC_INFO";
    private static final String COL2_1 = "year";
    private static final String COL2_2 = "district";
    private static final String COL2_3 = "hc";
    private static final String COL2_4 = "sector";
    private static final String COL2_5 = "cell";
    private static final String COL2_6 = "village";
    private static final String COL2_7 = "pubpost";
    private static final String COL2_8 = "pripost";
    private static final String COL2_9 = "population";
    private static final String COL2_10 = "patients";
    private static final String COL2_11 = "beds";
    private static final String COL2_12 = "consrooms";
    private static final String COL2_13 = "hosprooms";
    private static final String COL2_14 = "chw";
    private static final String COL2_15 = "a0";
    private static final String COL2_16 = "a1";
    private static final String COL2_17 = "a2";
    private static final String COL2_18 = "midwife";

    private static final String TABLE_NAME3="BASIC_INFO2";
    private static final String COL3_1 = "year";
    private static final String COL3_2 = "district";
    private static final String COL3_3 = "hc";
    private static final String COL3_4 = "organi";
    private static final String COL3_5 = "uptodate";
    private static final String COL3_6 = "accessible";
    private static final String COLP_1 = "position1";
    private static final String COL3_7 = "labtecav";
    private static final String COL3_8 = "labsign";
    private static final String COL3_9 = "labemp";
    private static final String COLP_2 = "position2";
    private static final String COL3_10 = "nursearv";
    private static final String COL3_11 = "nursearsign";
    private static final String COL3_12 = "nursearempsign";
    private static final String COLP_3 = "position3";
    private static final String COL3_13 = "nursevacav";
    private static final String COL3_14 = "nursevacsign";
    private static final String COL3_15 = "nursevacempsign";
    private static final String COLP_4 = "position4";
    private static final String COL3_16 = "custocareav";
    private static final String COL3_17 = "custcaresign";
    private static final String COL3_18 = "custcareemppsign";
    private static final String COLP_5 = "position5";
    private static final String COL3_19 = "nursetbav";
    private static final String COL3_20 = "nursetbsign";
    private static final String COL3_21 = "nursetbempsign";
    private static final String COLP_6 = "position6";
    private static final String COL3_22 = "nursechi";
    private static final String COL3_23 = "nursechisign";
    private static final String COL3_24 = "nursechiempsign";
    private static final String COLP_7 = "position7";
    private static final String COL3_25 = "socialav";
    private static final String COL3_26 = "socialsign";
    private static final String COL3_27= "socialempsign";
    private static final String COLP_8 = "position8";
    private static final String COL3_28 = "nursecpnav";
    private static final String COL3_29 = "nursecpnsign";
    private static final String COL3_30 = "nursecpnempsign";
    private static final String COLP_9                                                                                                                                                                                                                                                                                      = "position9";
    private static final String COL3_31 = "midwifeav";
    private static final String COL3_32 = "midwifesign";
    private static final String COL3_33 = "midwifeempsign";
    private static final String COL3_34 = "SOPpharmacy";
    private static final String COL3_35 = "evidence";
    private static final String COL3_36 = "qicomitee";
    private static final String COL3_37 = "totstaff";
    private static final String COL3_38 = "totnurse";
    private static final String COL3_39 = "paidstaff";
    private static final String COL3_40 = "clinicalstaff";
    private static final String COL3_41 = "tbstaff";
    private static final String COL3_42 = "staffinfection";
    private static final String COL3_43 = "staffcovid";
    private static final String COL3_44 = "staffevaluated";
    private static final String COL3_45= "staffillness";
    private static final String COL3_46 = "staffinjuries";
    private static final String COL3_47= "staffhepatite";
    private static final String COL3_48= "staffrate";
    private static final String COL3_49= "patientrate";
    private static final String COL3_50= "staffmetting";
    private static final String COL3_51= "cosametting";
    private static final String COL3_52= "cogemetting";
    private static final String COL3_53= "chwmetting";



    //Service description table
    private static final String TABLE_NAME4="Anc_servicedescription";
    private static final String anc_1= "year";
    private static final String anc_2= "district";
    private static final String anc_3= "hc";
    private static final String anc_4= "direction";
    private static final String anc_5= "service";
    private static final String anc_6= "responsiblename";
    private static final String anc_7= "currentdata";
    private static final String anc_8= "responsiblephoto";
    private static final String anc_9= "area";
    private static final String anc_10= "requestedlistofsupplies";
    private static final String anc_11= "currentlistofsupplies";
    private static final String anc_12= "hygiene";
    private static final String anc_13= "handhygiene";

    private static final String TABLE_NAME5="vaccinaion_description";
    private static final String TABLE_NAME6="familyplanning_description";
    private static final String TABLE_NAME7="pharmacystock_description";
    private static final String TABLE_NAME8="pharmacydispensing_description";
    private static final String TABLE_NAME9="ncd_description";
    private static final String TABLE_NAME10="ceho_description";
    private static final String TABLE_NAME11="cashier_description";
    private static final String TABLE_NAME12="accounting_description";
    private static final String TABLE_NAME13="laboratory_description";
    private static final String TABLE_NAME14="titulaire_description";
    private static final String TABLE_NAME15="datamanager_description";
    private static final String TABLE_NAME16="arv_description";
    private static final String TABLE_NAME17="customercare_description";
    private static final String TABLE_NAME18="consultationroom_description";
    private static final String TABLE_NAME19="maternity_description";
    private static final String TABLE_NAME20="hospitalization_description";
    private static final String TABLE_NAME21="toilets_description";
    private static final String TABLE_NAME22="noticeboard_description";

    //documentation and sanitation
    private static final String TABLE_NAME23="documentation_actionplan";
    private static final String TABLE_NAME24="documentation_businessplan";
    private static final String TABLE_NAME25="documentation_budget";
    private static final String TABLE_NAME26="documentation_inservice";
    private static final String TABLE_NAME27="documentation_workschedule";
    private static final String TABLE_NAME28="documentation_qiplan";
    private static final String TABLE_NAME29="external_trainings";
    private static final String TABLE_NAME30="attendance_register";
    private static final String TABLE_NAME31="payables_register";
    private static final String TABLE_NAME32="receivables_register";
    private static final String TABLE_NAME33="malaria_plan";
    private static final String TABLE_NAME34="customercare_program";
    private static final String TABLE_NAME35="sanitation";
    private static final String TABLE_NAME36="datamanagement_sop";
    private static final String TABLE_NAME37="datamanagement_deliveries";
    private static final String TABLE_NAME38="datamanagement_NCD";
    private static final String TABLE_NAME39="datamanagement_BCG";
    private static final String TABLE_NAME40="datamanagement_Malaria";
    private static final String TABLE_NAME41="datamanagement_opdregisters";
    private static final String TABLE_NAME42="maternal_neonatal";
    private static final String TABLE_NAME43="finance_review";
    private static final String TABLE_NAME44="insurance_review";
    private static final String TABLE_NAME45="income_review";
    private static final String TABLE_NAME46="Accounts";
    private static final String TABLE_NAME47="expense_review";

    private static final String doc_1= "year";
    private static final String doc_2= "district";
    private static final String doc_3= "hc";
    private static final String doc_4= "available";
    private static final String doc_5= "tracked";
    private static final String doc_6= "approvedti";
    private static final String doc_7= "approvedcosa";
    private static final String doc_8= "comstaff";
    private static final String doc_9= "approved";


    //sanitation
    private static final String s1= "year";
    private static final String s2= "district";
    private static final String s3= "hc";
    private static final String s4= "STAFFLATRINES";
    private static final String s5= "PATIRNETLATRINES";
    private static final String s6= "TOTALLATRINES";
    private static final String s7= "BROKENLATRINES";
    private static final String s8= "CLEANLATRINES";
    private static final String s9= "ODORLESSLATRINES";
    private static final String s10= "HANDWASHLATRINES";
    private static final String s11= "LATRINESCHEDULES";
    private static final String s12= "OPD";
    private static final String s13= "HOSPITALIZATIONROOMS";

    //data management SOP
    private static final String d1= "year";
    private static final String d2= "district";
    private static final String d3= "hc";
    private static final String d4= "available";
    private static final String d5= "signed";
    private static final String d6= "submited";
    private static final String d7= "dmavailable";

    //data management data accuracy deliveries
    private static final String de1= "year";
    private static final String de2= "district";
    private static final String de3= "hc";
    private static final String de4= "patientfile";
    private static final String de5= "register";
    private static final String de6= "hmis_hardcopy";
    private static final String de7= "hmis_softcopy";
    private static final String de8= "accurate";
    private static final String de10= "labregister";

    //opd registers
    private static final String opd1= "year";
    private static final String opd2= "district";
    private static final String opd3= "hc";
    private static final String opd4= "lines";
    private static final String opd5= "fields";
    private static final String opd6= "blanks";

    ///maternity and neonatal health
    private static final String m1="year";
    private static final String m2="district";
    private static final String m3="hc";
    private static final String m4="maternalyear";
    private static final String m5="obsetricalANC";
    private static final String m6="registrations";
    private static final String m7="referalsANC";
    private static final String m8="obsetricalMaternity";
    private static final String m9="deliveries";
    private static final String m10="livebirths";
    private static final String m11="maternaldeaths";
    private static final String m12="neonataldeaths";
    private static final String m13="stillbirths";
    private static final String m14="postpartun";
    private static final String m15="anc4";
    private static final String m16="anc1";
    private static final String m17="underfivedeaths";
    private static final String m18="childrenconsulted";
    private static final String m19="contraceptiveusers";
    private static final String m20="mr2vaccines";
    private static final String m21="ultrasoundscans";

    //finance review
    private static final String fr1="year";
    private static final String fr2="district";
    private static final String fr3="hc";
    private static final String fr4="fyear";
    private static final String fr5="cbank";
    private static final String fr6="cpetty";
    private static final String fr7="creceivable";
    private static final String fr8="cpayable";
    private static final String fr9="cpharmacy";
    private static final String fr10="crevenue";
    private static final String fr11="chcincome";
    private static final String fr12="cmedecines";
    private static final String fr13="cexpenses";
    private static final String fr14="chrexpenses";
    private static final String fr15="cexpenditure";
    private static final String fr16="cpmedecines";
    private static final String fr17="cequipments";
    private static final String fr18="ctravel";
    private static final String fr19="cabudget";
    private static final String fr20="cpbudget";

    //insurancereview
    private static final String iv1="year";
    private static final String iv2="district";
    private static final String iv3="hc";
    private static final String iv4="fyear";
    private static final String iv5="ivperiod";
    private static final String iv6="subcbhi";
    private static final String iv7="subrssb";
    private static final String iv8="submmi";
    private static final String iv9="returncbhi";
    private static final String iv10="returnrssb";
    private static final String iv11="returnmmi";
    private static final String iv12="verifyrssb";
    private static final String iv13="verifymmi";
    private static final String iv14="amountcbhi";
    private static final String iv15="amountrssb";
    private static final String iv16="amountmmi";
    private static final String iv17="aftercbhi";
    private static final String iv18="afterrssb";
    private static final String iv19="aftermmi";


    //incomereview
    private static final String ic1="year";
    private static final String ic2="district";
    private static final String ic3="hc";
    private static final String ic4="incomedate";
    private static final String ic5="journalincome";
    private static final String ic6="receiptincome";
    private static final String ic7="incomematch";


    //incomereview
    private static final String acc1="year";
    private static final String acc2="district";
    private static final String acc3="hc";
    private static final String acc4="accreco";
    private static final String acc5="accbook";

    //expense review
    private static final String ex1="year";
    private static final String ex2="district";
    private static final String ex3="hc";
    private static final String ex4="expenseReference";
    private static final String ex5="expenseSigned";
    private static final String ex6="expenseinvoice";
    private static final String ex7="expensenumbered";
    private static final String ex8="expenseOrdered";
    private static final String ex9="expenseRecorded";
    private static final String ex90="CURRENTDATA";


    //safetyManagement
    private static final String TABLE_NAME48="safety_management";
    private static final String sm1="year";
    private static final String sm2="district";
    private static final String sm3="hc";
    private static final String sm4="rightsposted";
    private static final String sm5="infection";
    private static final String sm6="satisfactiontool";
    private static final String sm7="satisfactiondata";
    private static final String sm8="suggestionbox";
    private static final String sm9="qiincident";
    private static final String sm10="annualhazard";
    private static final String sm11="ppe";
    private static final String sm12="staffppe";
    private static final String sm13="staffsatisfactiontool";
    private static final String sm14="incidenttool";
    private static final String sm15="asrh";
    private static final String sm16="staffsatisfactiondata";
    private static final String sm17="patientincidents";
    private static final String sm18="patientincidentanalyzed";
    private static final String sm19="numberhazards";
    private static final String sm20="numberhazardsfixed";


    //safetyManagement
    private static final String TABLE_NAME49="healthEducation";
    private static final String he1="year";
    private static final String he2="district";
    private static final String he3="hc";
    private static final String he4="rmsessions";
    private static final String he5="rmbeneficiones";
    private static final String he6="rmscreened";
    private static final String he7="idsessions";
    private static final String he8="idbeneficiones";
    private static final String he9="idscreened";
    private static final String he10="ncsessions";
    private static final String he11="ncbeneficiones";
    private static final String he12="ncscreened";


    //pharmacy management
    private static final String TABLE_NAME50="pharmacyManagement";
    private static final String pm1="year";
    private static final String pm2="district";
    private static final String pm3="hc";
    private static final String pm4="drugseparate";
    private static final String pm5="drugforms";
    private static final String pm6="drugrequisition";
    private static final String pm7="drugalphabet";
    private static final String pm8="drugclass";
    private static final String pm9="drugfifo";
    private static final String pm10="drugfefo";
    private static final String pm11="drugother";
    private static final String pm12="drugnone";
    private static final String pm13="pharmacydry";
    private static final String pm14="pharmacyclean";
    private static final String pm15="pharmacyprotected";
    private static final String pm16="pharmacyorganized";
    private static final String pm17="pharmacythermometer";
    private static final String pm18="pharmacyrefrigerator";
    private static final String pm19="pharmacymonitored";
    private static final String pm20="pharmacyinventory";
    private static final String pm21="pharmacyessentials";
    private static final String pm22="pharmacynotes";
    private static final String pm23="pharmacyregister";
    private static final String pm24="pharmacytallies";
    private static final String pm25="pharmacybook";
    private static final String pm26="pharmacysigned";
    private static final String pm27="pharmacytemperature";
    private static final String pm28="pharmacyrefrigiratortemp";

    //pharmacyStock
    private static final String TABLE_NAME51="pharmacyStock";
    private static final String ps1="year";
    private static final String ps2="district";
    private static final String ps3="hc";
    private static final String ps4="drugname";
    private static final String ps5="drugquantity";
    private static final String ps6="drugquantityshelf";
    private static final String ps7="drugavailable";
    private static final String ps8="drugexpired";
    private static final String ps9="drugrequested";
    private static final String ps10="drugstockcard";
    private static final String ps11="drugstockcardfilled";
    private static final String ps12="drugexcess";
    private static final String ps13="druginventory";
    private static final String ps14="druglabel";

    //treatmentguideline hypertension

    private static final String TABLE_NAME52="guidelines_hypertension";
    private static final String hy1="year";
    private static final String hy2="district";
    private static final String hy3="hc";
    private static final String hy4="patientid";
    private static final String hy5="weightcheck";
    private static final String hy6="currentprotocol";
    private static final String hy7="bpcheck";
    private static final String hy8="eyecheck";
    private static final String hy9="procheck";
    private static final String hy10="crecheck";
    private static final String hy11="footcheck";

    private static final String TABLE_NAME53="guidelines_diabetes";

    private static final String TABLE_NAME54="guidelines_Asthma";
    private static final String as1="year";
    private static final String as2="district";
    private static final String as3="hc";
    private static final String as4="patientid";
    private static final String as5="bpcheck";
    private static final String as6="apptreatment";
    private static final String as7="severeclass";


    private static final String TABLE_NAME55="guidelines_Anc";
    private static final String anc1="year";
    private static final String anc2="district";
    private static final String anc3="hc";
    private static final String anc4="patientid";
    private static final String anc5="nationalanc";
    private static final String anc6="patienthistory";
    private static final String anc7="bpcheck";
    private static final String anc8="urinecheck";
    private static final String anc9="hemoglobincheck";
    private static final String anc10="rprcheck";
    private static final String anc11="ultracheck";

    private static final String TABLE_NAME56="guidelines_overall";
    private static final String ov1="year";
    private static final String ov2="district";
    private static final String ov3="hc";
    private static final String ov4="hyavailable";
    private static final String ov5="hyuptodate";
    private static final String ov6="hyinformed";
    private static final String ov7="diaavailable";
    private static final String ov8="diauptodate";
    private static final String ov9="diainformed";
    private static final String ov10="resavailable";
    private static final String ov11="resuptodate";
    private static final String ov12="resinformed";
    private static final String ov13="malavailable";
    private static final String ov14="maluptodate";
    private static final String ov15="malinformed";
    private static final String ov16="stiavailable";
    private static final String ov17="stiuptodate";
    private static final String ov18="stiinformed";


    private static final String TABLE_NAME57="guidelines_maternity";
    private static final String mat1="year";
    private static final String mat2="district";
    private static final String mat3="hc";
    private static final String mat4="nationaprotocol";
    private static final String mat5="essentialsupplies";
    private static final String mat6="privacyprovided";
    private static final String mat7="ppesupply";



    private static final String TABLE_NAME58="referal_process";
    private static final String ref1="year";
    private static final String ref2="district";
    private static final String ref3="hc";
    private static final String ref4="reason";
    private static final String ref5="findings";
    private static final String ref6="procedures";
    private static final String ref7="immediatecondition";
    private static final String ref8="patienttransferedto";
    private static final String ref9="feedback";
    private static final String ref10="referalsheets";
    private static final String ref11="standardform";

    private static final String TABLE_NAME59="outpatient_malaria";
    private static final String omal1="year";
    private static final String omal2="district";
    private static final String omal3="hc";
    private static final String omal4="patientid";
    private static final String omal5="assesment";
    private static final String omal6="classification";
    private static final String omal7="correcttreatment";
    private static final String omal8="patienteducated";
    private static final String omal9="followup";

    private static final String TABLE_NAME60="outpatient_fever";
    private static final String TABLE_NAME61="outpatient_cough";
    private static final String TABLE_NAME62="outpatient_pnemonia";
    private static final String TABLE_NAME63="outpatient_diarhea";


    private static final String TABLE_NAME64="guidelinesASRH";
    private static final String asr1="year";
    private static final String asr2="district";
    private static final String asr3="hc";
    private static final String asr4="registers";
    private static final String asr5="spaces";
    private static final String asr6="rooms";

    private static final String TABLE_NAME65="inpatient_care";
    private static final String inc1="year";
    private static final String inc2="district";
    private static final String inc3="hc";
    private static final String inc4="patientid";
    private static final String inc5="assessmentchecklist";
    private static final String inc6="biographicaldata";
    private static final String inc7="relevanthistory";
    private static final String inc8="chiefcomplaint";
    private static final String inc9="rapidsurvey";
    private static final String inc10="vitalsigns";
    private static final String inc11="examsytem";
    private static final String inc12="diagnosis";
    private static final String inc13="nursingplan";
    private static final String inc14="soapnote";
    private static final String inc15="treatmanetplan";
    private static final String inc16="complete";

    private static final String TABLE_NAME66="key_indicators";
    private static final String ki1="year";
    private static final String ki2="district";
    private static final String ki3="hc";
    private static final String ki4="yearId";
    private static final String ki5="diacases";
    private static final String ki6="diadeaths";
    private static final String ki7="pnecases";
    private static final String ki8="pnedeaths";
    private static final String ki9="malcases";
    private static final String ki10="maldeaths";
    private static final String ki11="malucases";
    private static final String ki12="maludeaths";

    private static final String TABLE_NAME67="AdmitedPatient_outcome";
    private static final String ap1="year";
    private static final String ap2="district";
    private static final String ap3="hc";
    private static final String ap4="patientid";
    private static final String ap5="admissiondate";
    private static final String ap6="dischargedate";
    private static final String ap7="duration";
    private static final String ap8="outcome";


    private static final String TABLE_NAME68="outcome_hypertensionBP";
    private static final String oh1="year";
    private static final String oh2="district";
    private static final String oh3="hc";
    private static final String oh4="patientid";
    private static final String oh5="month1";
    private static final String oh6="month2";
    private static final String oh7="month3";
    private static final String oh8="month4";
    private static final String oh9="month5";
    private static final String oh10="month6";

    private static final String TABLE_NAME69="outcome_diabetesBS";
    private static final String TABLE_NAME70="outcome_AsthmaClass";







    public Databasehelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, EMAIL TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME2 + "(YEAR TEXT, DISTRICT TEXT, HC TEXT,SECTOR TEXT, CELL TEXT,VILLAGE TEXT, PUBPOST TEXT, PRIPOST TEXT,POPULATION TEXT,PATIENTS TEXT,BEDS TEXT, CONSROOMS TEXT,HOSPROOMS TEXT,CHW TEXT,A0 TEXT,A1 TEXT,A2 TEXT,MIDWIFE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME3 + "(YEAR TEXT, DISTRICT TEXT, HC TEXT,ORGANI TEXT, UPTODATE TEXT,ACCESSIBLE TEXT,POSITION1 TEXT, LABTECAV TEXT,LABSIGN TEXT,LABEMP TEXT,POSITION2 TEXT, NURSEARV TEXT,NURSEARSIGN TEXT,NURSEAREMPSIGN TEXT,POSITION3 TEXT,NURSEVACAV TEXT,NURSEVACSIGN TEXT,NURSEVACEMPSIGN TEXT,POSITION4 TEXT, CUSTOCAREAV TEXT,CUSTCARESIGN TEXT,CUSTCAREEMPPSIGN TEXT,POSITION5 TEXT, NURSETBAV TEXT,NURSETBSIGN TEXT,NURSETBEMPSIGN TEXT,POSITION6 TEXT,NURSECHI TEXT,NURSECHISIGN TEXT,NURSECHIEMPSIGN TEXT,POSITION7 TEXT,SOCIALAV TEXT,SOCIALSIGN TEXT,SOCIALEMPSIGN TEXT,POSITION8 TEXT, NURSECPNAV TEXT,NURSECPNSIGN TEXT,NURSECPNEMPSIGN TEXT,POSITION9 TEXT,MIDWIFEAV TEXT,MIDWIFESIGN TEXT,MIDWIFEEMPSIGN TEXT,SOPPHARMACY TEXT,EVIDENCE TEXT,QICOMITEE TEXT,TOTSTAFF TEXT,TOTNURSE TEXT,PAIDSTAFF TEXT,CLINICALSTAFF TEXT,TBSTAFF TEXT,STAFFINFECTION TEXT,STAFFCOVID TEXT,STAFFEVALUATED TEXT,STAFFILLNESS TEXT,STAFFINJURIES TEXT,STAFFHEPATITE TEXT,STAFFRATE TEXT,PATIENTRATE TEXT,STAFFMETTING TEXT,COSAMETTING TEXT,COGEMETTING TEXT,CHWMETTING TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME4 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME5 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME6 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME7 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME8 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME9 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME10 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME11 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME12 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME13 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME14 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME15 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME16 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME17 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME18 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME19 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME20 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME21 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES,HYGIENE TEXT,HANDHYGIENE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME22 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,CURRENTDATA TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME23 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME24 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME25 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME26 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME27   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME28   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME29   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME30   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME31   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME32   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME33   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME34   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME35 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,STAFFLATRINES TEXT,PATIRNETLATRINES TEXT,TOTALLATRINES TEXT,BROKENLATRINES TEXT,CLEANLATRINES TEXT,ODORLESSLATRINES TEXT,HANDWASHLATRINES TEXT,LATRINESCHEDULES,OPD TEXT,HOSPITALIZATIONROOMS TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME36   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,SIGNED TEXT,SUBMITED TEXT,DMAVAILABLE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME37   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME38   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME39   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME40   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,LABREGISTER TEXT,ACCURATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME41   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,LINES TEXT,FIELDS TEXT,BLANKS TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME42   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,maternalyear TEXT,obsetricalANC TEXT,registrations TEXT,referalsANC TEXT,obsetricalMaternity TEXT,deliveries TEXT,livebirths TEXT,maternaldeaths TEXT,neonataldeaths TEXT,stillbirths TEXT,postpartun TEXT,anc4 TEXT,anc1 TEXT,underfivedeaths TEXT,childrenconsulted TEXT,contraceptiveusers TEXT,mr2vaccines TEXT,ultrasoundscans TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME43   + "(year TEXT,district TEXT,hc TEXT,fyear TEXT, cbank TEXT, cpetty TEXT, creceivable TEXT, cpayable TEXT, cpharmacy TEXT, crevenue TEXT, chcincome TEXT, cmedecines TEXT, cexpenses TEXT, chrexpenses TEXT, cexpenditure TEXT, cpmedecines TEXT, cequipments TEXT, ctravel TEXT, cabudget TEXT, cpbudget TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME44   + "(YEAR TEXT,HC TEXT,DISTRICT TEXT,fyear TEXT,ivperiod TEXT,subcbhi TEXT,subrssb TEXT,submmi TEXT,returncbhi TEXT,returnrssb TEXT,returnmmi TEXT,verifyrssb TEXT,verifymmi TEXT,amountcbhi TEXT,amountrssb TEXT,amountmmi TEXT,aftercbhi TEXT,afterrssb TEXT,aftermmi TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME45   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,INCOMEDATE TEXT,JOURNALINCOME TEXT,RECEIPTINCOME TEXT,INCOMEMATCH TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME46   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,ACCRECO TEXT,ACCBOOK TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME47   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,EXPENSEREFERENCE TEXT,EXPENSESIGNED TEXT,EXPENSEINVOICE TEXT,EXPENSENUMBERED TEXT,EXPENSEORDERED TEXT,EXPENSERECORDED TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME48   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,  rightsposted TEXT, infection TEXT, satisfactiontool TEXT, satisfactiondata TEXT, suggestionbox TEXT, qiincident TEXT, annualhazard TEXT, ppe TEXT, staffppe TEXT,staffsatisfactiontool TEXT, incidenttool TEXT, asrh TEXT, staffsatisfactiondata TEXT, patientincidents TEXT, patientincidentanalyzed TEXT, numberhazards TEXT, numberhazardsfixed TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME49   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, rmsessions TEXT, rmbeneficiones TEXT, rmscreened TEXT, idsessions TEXT, idbeneficiones TEXT, idscreened TEXT, ncsessions TEXT, ncbeneficiones TEXT, ncscreened TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME50   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,drugseparate TEXT,drugforms TEXT,drugrequisition TEXT,drugalphabet TEXT,drugclass TEXT,drugfifo TEXT,drugfefo TEXT,drugother TEXT,drugnone TEXT,pharmacydry TEXT,pharmacyclean TEXT,pharmacyprotected TEXT,pharmacyorganized TEXT,pharmacythermometer TEXT,pharmacyrefrigerator TEXT,pharmacymonitored TEXT,pharmacyinventory TEXT,pharmacyessentials TEXT,pharmacynotes TEXT,pharmacyregister TEXT,pharmacytallies TEXT,pharmacybook TEXT,pharmacysigned TEXT, pharmacytemperature  TEXT,pharmacyrefrigiratortemp TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME51   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,drugname TEXT,drugquantity TEXT,drugquantityshelf TEXT,drugavailable TEXT,drugexpired TEXT,drugrequested TEXT,drugstockcard TEXT,drugstockcardfilled TEXT,drugexcess TEXT,druginventory TEXT,druglabel TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME52   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,weightcheck TEXT,currentprotocol TEXT,bpcheck TEXT,eyecheck TEXT,procheck TEXT,crecheck TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME53   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,weightcheck TEXT,currentprotocol TEXT,bpcheck TEXT,eyecheck TEXT,procheck TEXT,crecheck TEXT,footcheck TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME54   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,bpcheck TEXT,apptreatment TEXT,severeclass TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME55   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,nationalanc TEXT,patienthistory TEXT,bpcheck TEXT,urinecheck TEXT,hemoglobincheck TEXT,rprcheck TEXT,ultracheck TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME56   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,hyavailable TEXT,hyuptodate TEXT,hyinformed TEXT,diaavailable TEXT,diauptodate TEXT,diainformed TEXT,resavailable TEXT,resuptodate TEXT,resinformed TEXT,malavailable TEXT,maluptodate TEXT,malinformed TEXT,stiavailable TEXT,stiuptodate TEXT,stiinformed TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME57   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,nationaprotocol TEXT,essentialsupplies TEXT,privacyprovided TEXT,ppesupply TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME58   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, reason TEXT,findings TEXT,procedures TEXT,immediatecondition TEXT,patienttransferedto TEXT,feedback TEXT,referalsheets TEXT,standardform TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME59   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT,followup TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME60   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT,followup TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME61   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME62   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT,followup TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME63   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT,followup TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME64   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,registers TEXT,spaces TEXT,rooms TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME65   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,assessmentchecklist  TEXT,biographicaldata  TEXT,relevanthistory  TEXT,chiefcomplaint  TEXT,rapidsurvey  TEXT,vitalsigns  TEXT,examsytem  TEXT,diagnosis  TEXT,nursingplan  TEXT,soapnote  TEXT,treatmanetplan  TEXT,complete  TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME66   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,yearid TEXT, diacases TEXT,diadeaths TEXT,pnecases TEXT,pnedeaths TEXT,malcases TEXT, maldeaths TEXT,malucases TEXT, maludeaths TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME67   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT, admissiondate TEXT, dischargedate TEXT, duration TEXT,outcome TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME68   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT, month1 TEXT, month2 TEXT, month3 TEXT,month4 TEXT,month5 TEXT,month6 TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME69   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT, month1 TEXT, month2 TEXT, month3 TEXT,month4 TEXT,month5 TEXT,month6 TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME70   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT, month1 TEXT, month2 TEXT, month3 TEXT,month4 TEXT,month5 TEXT,month6 TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME6);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME7);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME8);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME9);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME10);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME11);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME12);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME13);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME14);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME15);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME16);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME17);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME18);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME19);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME20);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME21);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME22);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME23);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME24);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME25);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME26);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME27);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME28);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME29);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME30);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME31);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME32);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME33);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME34);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME35);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME36);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME37);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME38);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME39);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME40);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME41);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME42);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME43);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME44);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME45);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME46);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME47);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME48);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME49);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME50);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME51);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME52);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME53);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME54);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME55);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME56);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME57);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME58);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME59);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME60);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME61);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME62);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME63);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME64);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME65);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME66);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME67);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME68);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME69);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME70);
        onCreate(db);
    }

    public boolean registerUSer(String firstname,String lastname, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, firstname);
        values.put(COL_3, lastname);
        values.put(COL_4, email);
        values.put(COL_5, password);


        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerBasicInformation(String year, String district, String hc, String sector, String cell, String village, String pubpost, String pripost, String population, String patients, String beds, String consrooms, String hosprooms, String chw, String a0, String a1,String a2, String midwives){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL2_1,year);
        values.put(COL2_2,district);
        values.put(COL2_3,hc);
        values.put(COL2_4,sector);
        values.put(COL2_5,cell);
        values.put(COL2_6,village);
        values.put(COL2_7,pubpost);
        values.put(COL2_8,pripost);
        values.put(COL2_9,population);
        values.put(COL2_10,patients);
        values.put(COL2_11,beds);
        values.put(COL2_12,consrooms);
        values.put(COL2_13,hosprooms);
        values.put(COL2_14,chw);
        values.put(COL2_15,a0);
        values.put(COL2_16,a1);
        values.put(COL2_17,a2);
        values.put(COL2_18,midwives);

        long result = db.insert(TABLE_NAME2, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean registerAncServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME4, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerVacServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME5, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerFpServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME6, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerPharmacyServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME7, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerPharmacyDispenseServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME8, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerNcdServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME9, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerCehoServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME10, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerCashierServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME11, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerAccountingServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME12, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerLaboratoryServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME13, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerTitulaireServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME14, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDataManagerServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME15, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerArvServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME16, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerCustomerCareServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME17, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerConsultationServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME18, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerMaternityServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME19, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerHospitalizationServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME20, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerToiletsServiceDescription(String year, String district, String hc,String direction,String service,String responsiblename,String currentdata,String responsiblephoto,String area,String requestedlistofsupplies,String currentlistofsupplies,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_5,service);
        values.put(anc_6,responsiblename);
        values.put(anc_7,currentdata);
        values.put(anc_8,responsiblephoto);
        values.put(anc_9,area);
        values.put(anc_10,requestedlistofsupplies);
        values.put(anc_11,currentlistofsupplies);
        values.put(anc_12,hygiene);
        values.put(anc_13,handgygiene);

        long result = db.insert(TABLE_NAME21, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerTNoticeBoardCurrentDataServiceDescription(String year, String district, String hc,String currentdata){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(ex90,currentdata);

        long result = db.insert(TABLE_NAME22, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }


        public boolean registerBasicInformation2(String year, String district, String hc, String organi,String uptodate,String accessible,String position1,String  labtecav,
                                             String  labsign, String  labemp,String position2, String  nursearv, String  nursearsign, String  nursearempsign, String position3,String  nursevacav,
                                             String  nursevacsign ,String  nursevacempsign,String position4, String  custocareav, String  custcaresign, String  custcareemppsign,
                                                 String position5,String  nursetbav ,String  nursetbsign ,
                                             String  nursetbempsign, String position6, String  nursechi, String  nursechisign ,String  nursechiempsign ,String position7, String  socialav ,
                                             String socialsign ,String  socialempsign ,String position8, String  nursecpnav ,String  nursecpnsign ,String  nursecpnempsign ,
                                                 String position9, String  midwifeav, String  midwifesign, String  midwifeempsign ,String  SOPpharmacy, String  evidence,
                                             String  qicomitee ,String  totstaff ,String  totnurse, String  paidstaff ,String  clinicalstaff,
                                             String  tbstaff ,String  staffinfection, String  staffcovid ,String  staffevaluated ,
                                             String  staffillness ,String  staffinjuries ,String  staffhepatite, String  staffrate ,
                                             String  patientrate ,String  staffmetting, String cosametting, String cogemeeting,String chwmeeting ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( COL3_1 ,year);
        values.put( COL3_2 ,district);
        values.put( COL3_3 ,hc);
        values.put( COL3_4 ,organi);
        values.put( COL3_5 ,uptodate);
        values.put( COL3_6 ,accessible);
        values.put( COLP_1 ,position1);
        values.put( COL3_7 ,labtecav);
        values.put( COL3_8 ,labsign);
        values.put( COL3_9 ,labemp);
        values.put( COLP_2 ,position2);
        values.put( COL3_10 ,nursearv);
        values.put( COL3_11 ,nursearsign);
        values.put( COL3_12 ,nursearempsign);
        values.put( COLP_3 ,position3);
        values.put( COL3_13 ,nursevacav);
        values.put( COL3_14 ,nursevacsign);
        values.put( COL3_15 ,nursevacempsign);
        values.put( COLP_4 ,position4);
        values.put( COL3_16 ,custocareav);
        values.put( COL3_17 ,custcaresign);
        values.put( COL3_18 ,custcareemppsign);
        values.put( COLP_5 ,position5);
        values.put( COL3_19 ,nursetbav);
        values.put( COL3_20 ,nursetbsign);
        values.put( COL3_21 ,nursetbempsign);
        values.put( COLP_6 ,position6);
        values.put( COL3_22 ,nursechi);
        values.put( COL3_23 ,nursechisign);
        values.put( COL3_24 ,nursechiempsign);
        values.put( COLP_7 ,position7);
        values.put( COL3_25 ,socialav);
        values.put( COL3_26 ,socialsign);
        values.put( COL3_27,socialempsign);
        values.put( COLP_8 ,position8);
        values.put( COL3_28 ,nursecpnav);
        values.put( COL3_29 ,nursecpnsign);
        values.put( COL3_30 ,nursecpnempsign);
        values.put( COLP_9 ,position9);
        values.put( COL3_31 ,midwifeav);
        values.put( COL3_32 ,midwifesign);
        values.put( COL3_33 ,midwifeempsign);
        values.put( COL3_34 ,SOPpharmacy);
        values.put( COL3_35 ,evidence);
        values.put( COL3_36 ,qicomitee);
        values.put( COL3_37 ,totstaff);
        values.put( COL3_38 ,totnurse);
        values.put( COL3_39 ,paidstaff);
        values.put( COL3_40 ,clinicalstaff);
        values.put( COL3_41 ,tbstaff);
        values.put( COL3_42 ,staffinfection);
        values.put( COL3_43 ,staffcovid);
        values.put( COL3_44 ,staffevaluated);
        values.put( COL3_45,staffillness);
        values.put( COL3_46 ,staffinjuries);
        values.put( COL3_47,staffhepatite);
        values.put( COL3_48,staffrate);
        values.put( COL3_49,patientrate);
        values.put( COL3_50,staffmetting);
        values.put( COL3_51,cosametting);
        values.put( COL3_52,cogemeeting);
        values.put( COL3_53,chwmeeting);

        long result = db.insert(TABLE_NAME3, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean userCheck(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String [] colummns = { COL_1 };
        String selection = COL_4 + "=?" + " and " + COL_5 + "=?";
        String [] selectionargs = {email, password};
        Cursor cursor = db.query(TABLE_NAME, colummns, selection, selectionargs, null, null, null);
        int counter = cursor.getCount();
        db.close();
        cursor.close();
        if(counter > 0){
            return true;
        }else{
            return false;
        }
    }



    //documentation and sanitation save functions
    public boolean registerDocumentationActionPlan(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME23, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationBusinessPlan(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME24, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationBudget(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME25, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationInService(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME26, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }


    public boolean registerDocumentationWorkSchedule(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME27, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationQiplan(String year, String district, String hc,String available,String tracked,String approvedti,String approvedcosa,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_7,approvedcosa);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME28, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }


    public boolean registerDocumentationRegister(String year, String district, String hc,String available,String tracked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        long result = db.insert(TABLE_NAME29, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationAttendance(String year, String district, String hc,String available,String tracked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        long result = db.insert(TABLE_NAME30, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerDocumentationPayables(String year, String district, String hc,String available,String tracked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        long result = db.insert(TABLE_NAME31, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerDocumentationReceivables(String year, String district, String hc,String available,String tracked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        long result = db.insert(TABLE_NAME32, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationMalaria(String year, String district, String hc,String available,String tracked,String approved){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_9,approved);
        long result = db.insert(TABLE_NAME33, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationCustomer(String year, String district, String hc,String available,String tracked,String approved){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_9,approved);
        long result = db.insert(TABLE_NAME34, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationSanitation(String year, String district, String hc,String stafflatrines,String patientlatrines,String totlatrines,String brokelatrines,String cleanlatrines,String nodorlatrines,String handwashlatrine,String schedulelatrine,String opd,String hospirooms){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(s1,year);
        values.put(s2,district);
        values.put(s3,hc);
        values.put(s4,stafflatrines);
        values.put(s5,patientlatrines);
        values.put(s6,totlatrines);
        values.put(s7,brokelatrines);
        values.put(s8,cleanlatrines);
        values.put(s9,nodorlatrines);
        values.put(s10,handwashlatrine);
        values.put(s11,schedulelatrine);
        values.put(s12,opd);
        values.put(s13,hospirooms);

        long result = db.insert(TABLE_NAME35, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDatamanagementSOP(String year, String district, String hc,String available,String signed,String submited,String dmavailable){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(d1,year);
        values.put(d2,district);
        values.put(d3,hc);
        values.put(d4,available);
        values.put(d5,signed);
        values.put(d6,submited);
        values.put(d7,dmavailable);
        long result = db.insert(TABLE_NAME36, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDatamanagementDeliveries(String year, String district, String hc,String patientfile,String register,String hmis_hardcopy,String hmis_softcopy,String accurate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(de1,year);
        values.put(de2,district);
        values.put(de3,hc);
        values.put(de4,patientfile);
        values.put(de5,register);
        values.put(de6,hmis_hardcopy);
        values.put(de7,hmis_softcopy);
        values.put(de8,accurate);
        long result = db.insert(TABLE_NAME37, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDatamanagementNcd(String year, String district, String hc,String patientfile,String register,String hmis_hardcopy,String hmis_softcopy,String accurate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(de1,year);
        values.put(de2,district);
        values.put(de3,hc);
        values.put(de4,patientfile);
        values.put(de5,register);
        values.put(de6,hmis_hardcopy);
        values.put(de7,hmis_softcopy);
        values.put(de8,accurate);
        long result = db.insert(TABLE_NAME38, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerDatamanagementBcg(String year, String district, String hc,String patientfile,String register,String hmis_hardcopy,String hmis_softcopy,String accurate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(de1,year);
        values.put(de2,district);
        values.put(de3,hc);
        values.put(de4,patientfile);
        values.put(de5,register);
        values.put(de6,hmis_hardcopy);
        values.put(de7,hmis_softcopy);
        values.put(de8,accurate);
        long result = db.insert(TABLE_NAME39, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDatamanagementMalaria(String year, String district, String hc,String patientfile,String register,String hmis_hardcopy,String hmis_softcopy,String labregister,String accurate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(de1,year);
        values.put(de2,district);
        values.put(de3,hc);
        values.put(de4,patientfile);
        values.put(de5,register);
        values.put(de6,hmis_hardcopy);
        values.put(de7,hmis_softcopy);
        values.put(de10,labregister);
        values.put(de8,accurate);
        long result = db.insert(TABLE_NAME40, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }



    }

    public boolean registerDatamanagementOpdRegisters(String year, String district, String hc,String lines,String fields,String blanks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(opd1,year);
        values.put(opd2,district);
        values.put(opd3,hc);
        values.put(opd4,lines);
        values.put(opd5,fields);
        values.put(opd6,blanks);
        long result = db.insert(TABLE_NAME41, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }



    }

    public boolean registerMaternalNeonatal( String year,String district,String hc,String maternalyear, String obsetricalANC, String registrations, String referalsANC, String obsetricalMaternity, String deliveries, String livebirths, String maternaldeaths, String neonataldeaths, String stillbirths, String postpartun, String anc4, String anc1, String underfivedeaths, String childrenconsulted, String contraceptiveusers, String mr2vaccines, String ultrasoundscans){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(m1,year);
        values.put(m2,district);
        values.put(m3,hc);
        values.put(m4,maternalyear);
        values.put(m5,obsetricalANC);
        values.put(m6  ,registrations);
        values.put(m7  ,referalsANC);
        values.put(m8  ,obsetricalMaternity);
        values.put(m9  ,deliveries);
        values.put(m10  ,livebirths);
        values.put(m11  ,maternaldeaths);
        values.put(m12  ,neonataldeaths);
        values.put(m13  ,stillbirths);
        values.put(m14  ,postpartun);
        values.put(m15  ,anc4);
        values.put(m16  ,anc1);
        values.put(m17  ,underfivedeaths);
        values.put(m18  ,childrenconsulted);
        values.put(m19  ,contraceptiveusers);
        values.put(m20  ,mr2vaccines);
        values.put(m21  ,ultrasoundscans);
        long result = db.insert(TABLE_NAME42, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }



    }



    public boolean RegisterFinanceReview(String year,String district,String hc,String fyear, String cbank, String cpetty, String creceivable, String cpayable, String cpharmacy, String crevenue, String chcincome, String cmedecines, String cexpenses, String chrexpenses, String cexpenditure, String cpmedecines, String cequipments, String ctravel, String cabudget, String cpbudget){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(fr1,year);
        values.put(fr2,district);
        values.put(fr3,hc);
        values.put(fr4,fyear);
        values.put(fr5,cbank);
        values.put(fr6  ,cpetty);
        values.put(fr7  ,creceivable);
        values.put(fr8  ,cpayable);
        values.put(fr9  ,cpharmacy);
        values.put(fr10  ,crevenue);
        values.put(fr11  ,chcincome);
        values.put(fr12  ,cmedecines);
        values.put(fr13  ,cexpenses);
        values.put(fr14  ,chrexpenses);
        values.put(fr15  ,cexpenditure);
        values.put(fr16  ,cpmedecines);
        values.put(fr17  ,cequipments);
        values.put(fr18  ,ctravel);
        values.put(fr19 ,cabudget);
        values.put(fr20  ,cpbudget);
        long result = db.insert(TABLE_NAME43, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }



    }


    public boolean RegisterAssuranceReview(String year  ,String hc  ,String district  ,String fyear  ,String ivperiod  ,String subcbhi  ,String subrssb  ,String submmi  ,String returncbhi  ,String returnrssb  ,String returnmmi  ,String verifyrssb  ,String verifymmi  ,String amountcbhi  ,String amountrssb  ,String amountmmi  ,String aftercbhi  ,String afterrssb  ,String aftermmi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(iv1,year);
        values.put(iv2,district);
        values.put(iv3,hc);
        values.put(iv4,fyear);
        values.put(iv5,ivperiod);
        values.put(iv6  ,subcbhi);
        values.put(iv7  ,subrssb);
        values.put(iv8  ,submmi);
        values.put(iv9  ,returncbhi);
        values.put(iv10  ,returnrssb);
        values.put(iv11  ,returnmmi);
        values.put(iv12  ,verifyrssb);
        values.put(iv13  ,verifymmi);
        values.put(iv14  ,amountcbhi);
        values.put(iv15  ,amountrssb);
        values.put(iv16  ,amountmmi);
        values.put(iv17  ,aftercbhi);
        values.put(iv18  ,afterrssb);
        values.put(iv19 ,aftermmi);
        long result = db.insert(TABLE_NAME44, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }



    }


    public boolean registerIncomeReview(String year, String district, String hc,String incomedate,String journalincome,String receiptincome,String incomematch){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ic1,year);
        values.put(ic2,district);
        values.put(ic3,hc);
        values.put(ic4,incomedate);
        values.put(ic5,journalincome);
        values.put(ic6,receiptincome);
        values.put(ic7,incomematch);
        long result = db.insert(TABLE_NAME45, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerAccounts(String year, String district, String hc,String accreco,String accbook){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(acc1,year);
        values.put(acc2,district);
        values.put(acc3,hc);
        values.put(acc4,accreco);
        values.put(acc5,accbook);
        long result = db.insert(TABLE_NAME46, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerExpenseReview(String year, String district, String hc,String expensereference,String expensesigned,String expenseinvoice,String expensenumbered,String expenseordered,String expenserecorded){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ex1,year);
        values.put(ex2,district);
        values.put(ex3,hc);
        values.put(ex4,expensereference);
        values.put(ex5,expensesigned);
        values.put(ex6,expenseinvoice);
        values.put(ex7,expensenumbered);
        values.put(ex8,expenseordered);
        values.put(ex9,expenserecorded);
        long result = db.insert(TABLE_NAME47, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean RegisterSafetyManagement(String year  ,String hc  ,String district, String rightsposted , String infection , String satisfactiontool , String satisfactiondata , String suggestionbox , String qiincident , String annualhazard , String ppe , String staffppe ,  String staffsatisfactiontool , String incidenttool , String asrh , String staffsatisfactiondata , String patientincidents , String patientincidentanalyzed , String numberhazards , String numberhazardsfixed ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(sm1,year);
        values.put(sm2,district);
        values.put(sm3,hc);
        values.put(sm4,rightsposted);
        values.put(sm5,infection);
        values.put(sm6  ,satisfactiontool);
        values.put(sm7  ,satisfactiondata);
        values.put(sm8  ,suggestionbox);
        values.put(sm9  ,qiincident);
        values.put(sm10  ,annualhazard);
        values.put(sm11  ,ppe);
        values.put(sm12  ,staffppe);
        values.put(sm13  ,staffsatisfactiontool);
        values.put(sm14  ,incidenttool);
        values.put(sm15  ,asrh);
        values.put(sm16  ,staffsatisfactiondata);
        values.put(sm17  ,patientincidents);
        values.put(sm18  ,patientincidentanalyzed);
        values.put(sm19 ,numberhazards);
        values.put(sm20 ,numberhazardsfixed);
        long result = db.insert(TABLE_NAME48, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }



    }

    public boolean registerHealthEducation(String year, String district, String hc, String rmsessions , String rmbeneficiones , String rmscreened , String idsessions , String idbeneficiones , String idscreened , String ncsessions , String ncbeneficiones , String ncscreened){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(he1,year);
        values.put(he2,district);
        values.put(he3,hc);
        values.put(he4,rmsessions);
        values.put(he5,rmbeneficiones);
        values.put(he6,rmscreened);
        values.put(he7,idsessions);
        values.put(he8,idbeneficiones);
        values.put(he9,idscreened);
        values.put(he10,ncsessions);
        values.put(he11,ncbeneficiones);
        values.put(he12,ncscreened);
        long result = db.insert(TABLE_NAME49, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerManagementReview(String year, String district, String hc,  String drugseparate, String drugforms, String drugrequisition, String drugalphabet, String drugclass, String drugfifo, String drugfefo, String drugother, String drugnone, String pharmacydry, String pharmacyclean, String pharmacyprotected, String pharmacyorganized, String pharmacythermometer, String pharmacyrefrigerator, String pharmacymonitored, String pharmacyinventory, String pharmacyessentials, String pharmacynotes, String pharmacyregister, String pharmacytallies, String pharmacybook, String pharmacysigned, String pharmacytemperature,  String pharmacyrefrigiratortemp){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(pm1,year);
        values.put(pm2,district);
        values.put(pm3,hc);
        values.put(pm4,drugseparate);
        values.put(pm5,drugforms);
        values.put(pm6,drugrequisition);
        values.put(pm7,drugalphabet);
        values.put(pm8,drugclass);
        values.put(pm9,drugfifo);
        values.put(pm10,drugfefo);
        values.put(pm11,drugother);
        values.put(pm12,drugnone);
        values.put(pm13,pharmacydry);
        values.put(pm14,pharmacyclean);
        values.put(pm15,pharmacyprotected);
        values.put(pm16,pharmacyorganized);
        values.put(pm17,pharmacythermometer);
        values.put(pm18,pharmacyrefrigerator);
        values.put(pm19,pharmacymonitored);
        values.put(pm20,pharmacyinventory);
        values.put(pm21,pharmacyessentials);
        values.put(pm22,pharmacynotes);
        values.put(pm23,pharmacyregister);
        values.put(pm24,pharmacytallies);
        values.put(pm25,pharmacybook);
        values.put(pm26,pharmacysigned);
        values.put(pm27,pharmacytemperature);
        values.put(pm28,pharmacyrefrigiratortemp);
        long result = db.insert(TABLE_NAME50, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerPharmacyStock(String year, String district, String hc, String drugname , String drugquantity , String drugquantityshelf , String drugavailable , String drugexpired , String drugrequested , String drugstockcard , String drugstockcardfilled , String drugexcess , String druginventory , String druglabel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ps1,year);
        values.put(ps2,district);
        values.put(ps3,hc);
        values.put(ps4,drugname);
        values.put(ps5,drugquantity);
        values.put(ps6,drugquantityshelf);
        values.put(ps7,drugavailable);
        values.put(ps8,drugexpired);
        values.put(ps9,drugrequested);
        values.put(ps10,drugstockcard);
        values.put(ps11,drugstockcardfilled);
        values.put(ps12,drugexcess);
        values.put(ps13,druginventory);
        values.put(ps14,druglabel);
        long result = db.insert(TABLE_NAME51, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerTGhypertension(String year, String district, String hc, String patientid,String weightcheck,String currentprotocol,String bpcheck,String eyecheck,String procheck,String crecheck){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(hy1,year);
        values.put(hy2,district);
        values.put(hy3,hc);
        values.put(hy4,patientid);
        values.put(hy5,weightcheck);
        values.put(hy6,currentprotocol);
        values.put(hy7,bpcheck);
        values.put(hy8,eyecheck);
        values.put(hy9,procheck);
        values.put(hy10,crecheck);
        long result = db.insert(TABLE_NAME52, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }


    public boolean registerTGdiabetes(String year, String district, String hc, String patientid,String weightcheck,String currentprotocol,String bpcheck,String eyecheck,String procheck,String crecheck,String footcheck){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(hy1,year);
        values.put(hy2,district);
        values.put(hy3,hc);
        values.put(hy4,patientid);
        values.put(hy5,weightcheck);
        values.put(hy6,currentprotocol);
        values.put(hy7,bpcheck);
        values.put(hy8,eyecheck);
        values.put(hy9,procheck);
        values.put(hy10,crecheck);
        values.put(hy11,footcheck);
        long result = db.insert(TABLE_NAME53, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerAsthma(String year, String district, String hc, String patientid,String bpcheck,String apptreatment,String severeclass){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(as1,year);
        values.put(as2,district);
        values.put(as3,hc);
        values.put(as4,patientid);
        values.put(as5,bpcheck);
        values.put(as6,apptreatment);
        values.put(as7,severeclass);
        long result = db.insert(TABLE_NAME54, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerAnc(String year, String district, String hc, String patientid, String nationalanc, String patienthistory, String bpcheck, String urinecheck, String hemoglobincheck, String rprcheck,String ultracheck){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc1,year);
        values.put(anc2,district);
        values.put(anc3,hc);
        values.put(anc4,patientid);
        values.put(anc5,nationalanc);
        values.put(anc6,patienthistory);
        values.put(anc7,bpcheck);
        values.put(anc8,urinecheck);
        values.put(anc9,hemoglobincheck);
        values.put(anc10,rprcheck);
        values.put(anc11,ultracheck);
        long result = db.insert(TABLE_NAME55, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerOverall(String year, String district, String hc, String hyavailable, String hyuptodate, String hyinformed,String diaavailable, String diauptodate, String diainformed,String resavailable, String resuptodate, String resinformed,String malavailable, String maluptodate, String malinformed,String stiavailable, String stiuptodate, String stiinformed){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ov1,year);
        values.put(ov2,district);
        values.put(ov3,hc);
        values.put(ov4,hyavailable);
        values.put(ov5,hyuptodate);
        values.put(ov6,hyinformed);
        values.put(ov7,diaavailable);
        values.put(ov8,diauptodate);
        values.put(ov9,diainformed);
        values.put(ov10,resavailable);
        values.put(ov11,resuptodate);
        values.put(ov12,resinformed);
        values.put(ov13,malavailable);
        values.put(ov14,maluptodate);
        values.put(ov15,malinformed);
        values.put(ov16,stiavailable);
        values.put(ov17,stiuptodate);
        values.put(ov18,stiinformed);
        long result = db.insert(TABLE_NAME56, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }


    public boolean registerMaternity(String year, String district, String hc, String nationaprotocol,String essentialsupplies,String privacyprovided,String ppesupply){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(mat1,year);
        values.put(mat2,district);
        values.put(mat3,hc);
        values.put(mat4,nationaprotocol);
        values.put(mat5,essentialsupplies);
        values.put(mat6,privacyprovided);
        values.put(mat7,ppesupply);
        long result = db.insert(TABLE_NAME57, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerReferal(String year, String district, String hc,  String reason,String findings,String procedures,String immediatecondition,String patienttransferedto,String feedback,String referalsheets,String standardform){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ref1,year);
        values.put(ref2,district);
        values.put(ref3,hc);
        values.put(ref4,reason);
        values.put(ref5,findings);
        values.put(ref6,procedures);
        values.put(ref7,immediatecondition);
        values.put(ref8,patienttransferedto);
        values.put(ref9,feedback);
        values.put(ref10,referalsheets);
        values.put(ref11,standardform);
        long result = db.insert(TABLE_NAME58, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerOutMalaria(String year, String district, String hc, String patientid , String assesment  ,String classification  ,String correcttreatment  ,String patienteducated  ,String followup  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( omal1,year);
        values.put( omal2,district);
        values.put( omal3,hc);
        values.put( omal4,patientid);
        values.put( omal5,assesment);
        values.put( omal6,classification);
        values.put( omal7,correcttreatment);
        values.put( omal8,patienteducated);
        values.put( omal9,followup);
        long result = db.insert(TABLE_NAME59, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerOutFever(String year, String district, String hc, String patientid , String assesment  ,String classification  ,String correcttreatment  ,String patienteducated  ,String followup  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( omal1,year);
        values.put( omal2,district);
        values.put( omal3,hc);
        values.put( omal4,patientid);
        values.put( omal5,assesment);
        values.put( omal6,classification);
        values.put( omal7,correcttreatment);
        values.put( omal8,patienteducated);
        values.put( omal9,followup);
        long result = db.insert(TABLE_NAME60, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerOutCough(String year, String district, String hc, String patientid , String assesment  ,String classification  ,String correcttreatment  ,String patienteducated){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( omal1,year);
        values.put( omal2,district);
        values.put( omal3,hc);
        values.put( omal4,patientid);
        values.put( omal5,assesment);
        values.put( omal6,classification);
        values.put( omal7,correcttreatment);
        values.put( omal8,patienteducated);
        long result = db.insert(TABLE_NAME61, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerOutPnemonia(String year, String district, String hc, String patientid , String assesment  ,String classification  ,String correcttreatment  ,String patienteducated  ,String followup  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( omal1,year);
        values.put( omal2,district);
        values.put( omal3,hc);
        values.put( omal4,patientid);
        values.put( omal5,assesment);
        values.put( omal6,classification);
        values.put( omal7,correcttreatment);
        values.put( omal8,patienteducated);
        values.put( omal9,followup);
        long result = db.insert(TABLE_NAME62, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerOutDiarhea(String year, String district, String hc, String patientid , String assesment  ,String classification  ,String correcttreatment  ,String patienteducated  ,String followup  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( omal1,year);
        values.put( omal2,district);
        values.put( omal3,hc);
        values.put( omal4,patientid);
        values.put( omal5,assesment);
        values.put( omal6,classification);
        values.put( omal7,correcttreatment);
        values.put( omal8,patienteducated);
        values.put( omal9,followup);
        long result = db.insert(TABLE_NAME63, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerASRH(String year, String district, String hc, String registers,String spaces,String rooms  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( asr1,year);
        values.put( asr2,district);
        values.put( asr3,hc);
        values.put( asr4,registers);
        values.put( asr5,spaces);
        values.put( asr6,rooms);
        long result = db.insert(TABLE_NAME64, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }


    public boolean registerInpatientCare(String year, String district, String hc,String patientid,String assessmentchecklist ,String biographicaldata ,String relevanthistory ,String chiefcomplaint ,String rapidsurvey ,String vitalsigns ,String examsytem ,String diagnosis ,String nursingplan ,String soapnote ,String treatmanetplan ,String complete){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( inc1,year);
        values.put( inc2,district);
        values.put( inc3,hc);
        values.put( inc4,patientid);
        values.put( inc5,assessmentchecklist);
        values.put( inc6,biographicaldata);
        values.put( inc7,relevanthistory);
        values.put( inc8,chiefcomplaint);
        values.put( inc9,rapidsurvey);
        values.put( inc10,vitalsigns);
        values.put( inc11,examsytem);
        values.put( inc12,diagnosis);
        values.put( inc13,nursingplan);
        values.put( inc14,soapnote);
        values.put( inc15,treatmanetplan);
        values.put( inc16,complete);
        long result = db.insert(TABLE_NAME65, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerKeyIndicators(String year, String district, String hc,String yearid, String diacases,String diadeaths,String pnecases,String pnedeaths,String malcases, String maldeaths,String malucases, String maludeaths){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( ki1,year);
        values.put( ki2,district);
        values.put( ki3,hc);
        values.put( ki4,yearid);
        values.put( ki5,diacases);
        values.put( ki6,diadeaths);
        values.put( ki7,pnecases);
        values.put( ki8,pnedeaths);
        values.put( ki9,malcases);
        values.put( ki10,maldeaths);
        values.put( ki11,malucases);
        values.put( ki12,maludeaths);
        long result = db.insert(TABLE_NAME66, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerAdmittedPatients(String year, String district, String hc,String patientid, String admissiondate, String dischargedate, String duration,String outcome){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ap1,year);
        values.put(ap2,district);
        values.put(ap3,hc);
        values.put(ap4,patientid);
        values.put(ap5,admissiondate);
        values.put(ap6,dischargedate);
        values.put(ap7,duration);
        values.put(ap8,outcome);
        long result = db.insert(TABLE_NAME67, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean registerAdmittedPatientsHypertensionBP(String year, String district, String hc,String patientid, String month1, String month2, String month3,String month4,String month5,String month6){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(oh1,year);
        values.put(oh2,district);
        values.put(oh3,hc);
        values.put(oh4,patientid);
        values.put(oh5,month1);
        values.put(oh6,month2);
        values.put(oh7,month3);
        values.put(oh8,month4);
        values.put(oh9,month5);
        values.put(oh10,month6);
        long result = db.insert(TABLE_NAME68, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerAdmittedPatientsDiabetes(String year, String district, String hc,String patientid, String month1, String month2, String month3,String month4,String month5,String month6){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(oh1,year);
        values.put(oh2,district);
        values.put(oh3,hc);
        values.put(oh4,patientid);
        values.put(oh5,month1);
        values.put(oh6,month2);
        values.put(oh7,month3);
        values.put(oh8,month4);
        values.put(oh9,month5);
        values.put(oh10,month6);
        long result = db.insert(TABLE_NAME69, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerAdmittedPatientsAsthma(String year, String district, String hc,String patientid, String month1, String month2, String month3,String month4,String month5,String month6){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(oh1,year);
        values.put(oh2,district);
        values.put(oh3,hc);
        values.put(oh4,patientid);
        values.put(oh5,month1);
        values.put(oh6,month2);
        values.put(oh7,month3);
        values.put(oh8,month4);
        values.put(oh9,month5);
        values.put(oh10,month6);
        long result = db.insert(TABLE_NAME70, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

}
