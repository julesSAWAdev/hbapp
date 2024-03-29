package com.healthBuilders.surveyApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {




    public static final String server_url1= "http://report.healthbuilders.org/app/home.php";
    public static final String UI_broadcast="com.healthBuilders.surveyApp.uiupdatebroadcast";

    public static final int sync_status_failed= 0;

    public static final String DATABASE_NAME = "hbexercise";
    public static final String TABLE_NAME = "users";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "FNAME";
    public static final String COL_3 = "LNAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "PASSWORD";
    public static final String COL_6 = "STATUS";

    public static final String TABLE_NAME2 = "BASIC_INFO";
    public static final String COL2_1 = "year";
    public static final String COL2_2 = "district";
    public static final String COL2_3 = "hc";
    public static final String COL2_4 = "sector";
    public static final String COL2_5 = "cell";
    public static final String COL2_6 = "village";
    public static final String COL2_7 = "pubpost";
    public static final String COL2_8 = "pripost";
    public static final String COL2_9 = "population";
    public static final String COL2_10 = "patients";
    public static final String COL2_11 = "beds";
    public static final String COL2_12 = "consrooms";
    public static final String COL2_13 = "hosprooms";
    public static final String COL2_14 = "chw";
    public static final String COL2_15 = "a0";
    public static final String COL2_16 = "a1";
    public static final String COL2_17 = "a2";
    public static final String COL2_18 = "midwife";
    public static final String COL2_19 = "STATUS";

    public static final String TABLE_NAME3="BASIC_INFO2";
    public static final String COL3_1 = "year";
    public static final String COL3_2 = "district";
    public static final String COL3_3 = "hc";
    public static final String COL3_4 = "organi";
    public static final String COL3_5 = "uptodate";
    public static final String COL3_6 = "accessible";
    public static final String COLP_1 = "position1";
    public static final String COL3_7 = "labtecav";
    public static final String COL3_8 = "labsign";
    public static final String COL3_9 = "labemp";
    public static final String COLP_2 = "position2";
    public static final String COL3_10 = "nursearv";
    public static final String COL3_11 = "nursearsign";
    public static final String COL3_12 = "nursearempsign";
    public static final String COLP_3 = "position3";
    public static final String COL3_13 = "nursevacav";
    public static final String COL3_14 = "nursevacsign";
    public static final String COL3_15 = "nursevacempsign";
    public static final String COLP_4 = "position4";
    public static final String COL3_16 = "custocareav";
    public static final String COL3_17 = "custcaresign";
    public static final String COL3_18 = "custcareemppsign";
    public static final String COLP_5 = "position5";
    public static final String COL3_19 = "nursetbav";
    public static final String COL3_20 = "nursetbsign";
    public static final String COL3_21 = "nursetbempsign";
    public static final String COLP_6 = "position6";
    public static final String COL3_22 = "nursechi";
    public static final String COL3_23 = "nursechisign";
    public static final String COL3_24 = "nursechiempsign";
    public static final String COLP_7 = "position7";
    public static final String COL3_25 = "socialav";
    public static final String COL3_26 = "socialsign";
    public static final String COL3_27= "socialempsign";
    public static final String COLP_8 = "position8";
    public static final String COL3_28 = "nursecpnav";
    public static final String COL3_29 = "nursecpnsign";
    public static final String COL3_30 = "nursecpnempsign";
    public static final String COLP_9  = "position9";
    public static final String COL3_31 = "midwifeav";
    public static final String COL3_32 = "midwifesign";
    public static final String COL3_33 = "midwifeempsign";
    public static final String COL3_34 = "SOPpharmacy";
    public static final String COL3_35 = "evidence";
    public static final String COL3_36 = "qicomitee";
    public static final String COL3_37 = "totstaff";
    public static final String COL3_38 = "totnurse";
    public static final String COL3_39 = "paidstaff";
    public static final String COL3_40 = "clinicalstaff";
    public static final String COL3_41 = "tbstaff";
    public static final String COL3_42 = "staffinfection";
    public static final String COL3_43 = "staffcovid";
    public static final String COL3_44 = "staffevaluated";
    public static final String COL3_45= "staffillness";
    public static final String COL3_46 = "staffinjuries";
    public static final String COL3_47= "staffhepatite";
    public static final String COL3_48= "staffrate";
    public static final String COL3_49= "patientrate";
    public static final String COL3_50= "staffmetting";
    public static final String COL3_51= "cosametting";
    public static final String COL3_52= "cogemetting";
    public static final String COL3_53= "chwmetting";



    //Service description table
    public static final String TABLE_NAME4="Anc_servicedescription";
    public static final String anc_1= "year";
    public static final String anc_2= "district";
    public static final String anc_3= "hc";
    public static final String anc_4= "direction";
    public static final String anc_5= "service";
    public static final String anc_6= "responsiblename";
    public static final String anc_7= "currentdata";
    public static final String anc_8= "responsiblephoto";
    public static final String anc_9= "area";
    public static final String anc_10= "requestedlistofsupplies";
    public static final String anc_11= "currentlistofsupplies";
    public static final String anc_12= "hygiene";
    public static final String anc_13= "handhygiene";

    public static final String TABLE_NAME5="vaccinaion_description";
    public static final String TABLE_NAME6="familyplanning_description";
    public static final String TABLE_NAME7="pharmacystock_description";
    public static final String TABLE_NAME8="pharmacydispensing_description";
    public static final String TABLE_NAME9="ncd_description";
    public static final String TABLE_NAME10="ceho_description";
    public static final String TABLE_NAME11="cashier_description";
    public static final String TABLE_NAME12="accounting_description";
    public static final String TABLE_NAME13="laboratory_description";
    public static final String TABLE_NAME14="titulaire_description";
    public static final String TABLE_NAME15="datamanager_description";
    public static final String TABLE_NAME16="arv_description";
    public static final String TABLE_NAME17="customercare_description";
    public static final String TABLE_NAME18="consultationroom_description";
    public static final String TABLE_NAME19="maternity_description";
    public static final String TABLE_NAME20="hospitalization_description";
    public static final String TABLE_NAME21="toilets_description";
    public static final String TABLE_NAME22="noticeboard_description";

    //documentation and sanitation
    public static final String TABLE_NAME23="documentation_actionplan";
    public static final String TABLE_NAME24="documentation_businessplan";
    public static final String TABLE_NAME25="documentation_budget";
    public static final String TABLE_NAME26="documentation_inservice";
    public static final String TABLE_NAME27="documentation_workschedule";
    public static final String TABLE_NAME28="documentation_qiplan";
    public static final String TABLE_NAME29="external_trainings";
    public static final String TABLE_NAME30="attendance_register";
    public static final String TABLE_NAME31="payables_register";
    public static final String TABLE_NAME32="receivables_register";
    public static final String TABLE_NAME33="malaria_plan";
    public static final String TABLE_NAME34="customercare_program";
    public static final String TABLE_NAME35="sanitation";
    public static final String TABLE_NAME36="datamanagement_sop";
    public static final String TABLE_NAME37="datamanagement_deliveries";
    public static final String TABLE_NAME38="datamanagement_NCD";
    public static final String TABLE_NAME39="datamanagement_BCG";
    public static final String TABLE_NAME40="datamanagement_Malaria";
    public static final String TABLE_NAME41="datamanagement_opdregisters";
    public static final String TABLE_NAME42="maternal_neonatal";
    public static final String TABLE_NAME43="finance_review";
    public static final String TABLE_NAME44="insurance_review";
    public static final String TABLE_NAME45="income_review";
    public static final String TABLE_NAME46="Accounts";
    public static final String TABLE_NAME47="expense_review";

    public static final String doc_1= "year";
    public static final String doc_2= "district";
    public static final String doc_3= "hc";
    public static final String doc_4= "available";
    public static final String doc_5= "tracked";
    public static final String doc_6= "approvedti";
    public static final String doc_7= "approvedcosa";
    public static final String doc_8= "comstaff";
    public static final String doc_9= "approved";


    //sanitation
    public static final String s1= "year";
    public static final String s2= "district";
    public static final String s3= "hc";
    public static final String s4= "STAFFLATRINES";
    public static final String s5= "PATIRNETLATRINES";
    public static final String s6= "TOTALLATRINES";
    public static final String s7= "BROKENLATRINES";
    public static final String s8= "CLEANLATRINES";
    public static final String s9= "ODORLESSLATRINES";
    public static final String s10= "HANDWASHLATRINES";
    public static final String s11= "LATRINESCHEDULES";
    public static final String s12= "OPD";
    public static final String s13= "HOSPITALIZATIONROOMS";

    //data management SOP
    public static final String d1= "year";
    public static final String d2= "district";
    public static final String d3= "hc";
    public static final String d4= "available";
    public static final String d5= "signed";
    public static final String d6= "submited";
    public static final String d7= "dmavailable";

    //data management data accuracy deliveries
    public static final String de1= "year";
    public static final String de2= "district";
    public static final String de3= "hc";
    public static final String de4= "patientfile";
    public static final String de5= "register";
    public static final String de6= "hmis_hardcopy";
    public static final String de7= "hmis_softcopy";
    public static final String de8= "accurate";
    public static final String de10= "labregister";
    public static final String de11= "pharmacy";

    //opd registers
    public static final String opd1= "year";
    public static final String opd2= "district";
    public static final String opd3= "hc";
    public static final String opd4= "lines";
    public static final String opd5= "fields";
    public static final String opd6= "blanks";

    ///maternity and neonatal health
    public static final String m1="year";
    public static final String m2="district";
    public static final String m3="hc";
    public static final String m4="maternalyear";
    public static final String m5="obsetricalANC";
    public static final String m6="registrations";
    public static final String m7="referalsANC";
    public static final String m8="obsetricalMaternity";
    public static final String m9="deliveries";
    public static final String m10="livebirths";
    public static final String m11="maternaldeaths";
    public static final String m12="neonataldeaths";
    public static final String m13="stillbirths";
    public static final String m14="postpartun";
    public static final String m15="anc4";
    public static final String m16="anc1";
    public static final String m17="underfivedeaths";
    public static final String m18="childrenconsulted";
    public static final String m19="contraceptiveusers";
    public static final String m20="mr2vaccines";
    public static final String m21="ultrasoundscans";
    public static final String m22="deadunderfive";

    //finance review
    public static final String fr1="year";
    public static final String fr2="district";
    public static final String fr3="hc";
    public static final String fr4="fyear";
    public static final String fr5="cbank";
    public static final String fr6="cpetty";
    public static final String fr7="creceivable";
    public static final String fr8="cpayable";
    public static final String fr9="cpharmacy";
    public static final String fr10="crevenue";
    public static final String fr11="chcincome";
    public static final String fr12="cmedecines";
    public static final String fr13="cexpenses";
    public static final String fr14="chrexpenses";
    public static final String fr15="cexpenditure";
    public static final String fr16="cpmedecines";
    public static final String fr17="cequipments";
    public static final String fr18="ctravel";
    public static final String fr19="cabudget";
    public static final String fr20="cpbudget";

    //insurancereview
    public static final String iv1="year";
    public static final String iv2="district";
    public static final String iv3="hc";
    public static final String iv4="fyear";
    public static final String iv5="ivperiod";
    public static final String iv6="subcbhi";
    public static final String iv7="subrssb";
    public static final String iv8="submmi";
    public static final String iv9="returncbhi";
    public static final String iv10="returnrssb";
    public static final String iv11="returnmmi";
    public static final String iv12="verifyrssb";
    public static final String iv13="verifymmi";
    public static final String iv14="amountcbhi";
    public static final String iv15="amountrssb";
    public static final String iv16="amountmmi";
    public static final String iv17="aftercbhi";
    public static final String iv18="afterrssb";
    public static final String iv19="aftermmi";
    public static final String iv20="verifycbhi";


    //incomereview
    public static final String ic1="year";
    public static final String ic2="district";
    public static final String ic3="hc";
    public static final String ic4="incomedate";
    public static final String ic5="journalincome";
    public static final String ic6="receiptincome";
    public static final String ic7="incomematch";


    //Accounts
    public static final String acc1="year";
    public static final String acc2="district";
    public static final String acc3="hc";
    public static final String acc4="accreco";
    public static final String acc5="accbook";

    //expense review
    public static final String ex1="year";
    public static final String ex2="district";
    public static final String ex3="hc";
    public static final String ex4="expenseReference";
    public static final String ex5="expenseSigned";
    public static final String ex6="expenseinvoice";
    public static final String ex7="expensenumbered";
    public static final String ex8="expenseOrdered";
    public static final String ex9="expenseRecorded";
    public static final String ex90="CURRENTDATA";


    //safetyManagement
    public static final String TABLE_NAME48="safety_management";
    public static final String sm1="year";
    public static final String sm2="district";
    public static final String sm3="hc";
    public static final String sm4="rightsposted";
    public static final String sm5="infection";
    public static final String sm6="satisfactiontool";
    public static final String sm7="satisfactiondata";
    public static final String sm8="suggestionbox";
    public static final String sm9="qiincident";
    public static final String sm10="annualhazard";
    public static final String sm11="ppe";
    public static final String sm12="staffppe";
    public static final String sm13="staffsatisfactiontool";
    public static final String sm14="incidenttool";
    public static final String sm15="asrh";
    public static final String sm16="staffsatisfactiondata";
    public static final String sm17="patientincidents";
    public static final String sm18="patientincidentanalyzed";
    public static final String sm19="numberhazards";
    public static final String sm20="numberhazardsfixed";


    //safetyManagement
    public static final String TABLE_NAME49="healthEducation";
    public static final String he1="year";
    public static final String he2="district";
    public static final String he3="hc";
    public static final String he4="rmsessions";
    public static final String he5="rmbeneficiones";
    public static final String he6="rmscreened";
    public static final String he7="idsessions";
    public static final String he8="idbeneficiones";
    public static final String he9="idscreened";
    public static final String he10="ncsessions";
    public static final String he11="ncbeneficiones";
    public static final String he12="ncscreened";


    //pharmacy management
    public static final String TABLE_NAME50="pharmacyManagement";
    public static final String pm1="year";
    public static final String pm2="district";
    public static final String pm3="hc";
    public static final String pm4="drugseparate";
    public static final String pm5="drugforms";
    public static final String pm6="drugrequisition";
    public static final String pm7="drugalphabet";
    public static final String pm8="drugclass";
    public static final String pm9="drugfifo";
    public static final String pm10="drugfefo";
    public static final String pm11="drugother";
    public static final String pm12="drugnone";
    public static final String pm13="pharmacydry";
    public static final String pm14="pharmacyclean";
    public static final String pm15="pharmacyprotected";
    public static final String pm16="pharmacyorganized";
    public static final String pm17="pharmacythermometer";
    public static final String pm18="pharmacyrefrigerator";
    public static final String pm19="pharmacymonitored";
    public static final String pm20="pharmacyinventory";
    public static final String pm21="pharmacyessentials";
    public static final String pm22="pharmacynotes";
    public static final String pm23="pharmacyregister";
    public static final String pm24="pharmacytallies";
    public static final String pm25="pharmacybook";
    public static final String pm26="pharmacysigned";
    public static final String pm27="pharmacytemperature";
    public static final String pm28="pharmacyrefrigiratortemp";

    //pharmacyStock
    public static final String TABLE_NAME51="pharmacyStock";
    public static final String ps1="year";
    public static final String ps2="district";
    public static final String ps3="hc";
    public static final String ps4="drugname";
    public static final String ps5="drugquantity";
    public static final String ps6="drugquantityshelf";
    public static final String ps7="drugavailable";
    public static final String ps8="drugexpired";
    public static final String ps9="drugrequested";
    public static final String ps10="drugstockcard";
    public static final String ps11="drugstockcardfilled";
    public static final String ps12="drugexcess";
    public static final String ps13="druginventory";
    public static final String ps14="druglabel";

    //treatmentguideline hypertension

    public static final String TABLE_NAME52="guidelines_hypertension";
    public static final String hy1="year";
    public static final String hy2="district";
    public static final String hy3="hc";
    public static final String hy4="patientid";
    public static final String hy5="weightcheck";
    public static final String hy6="currentprotocol";
    public static final String hy7="bpcheck";
    public static final String hy8="eyecheck";
    public static final String hy9="procheck";
    public static final String hy10="crecheck";
    public static final String hy11="footcheck";

    public static final String TABLE_NAME53="guidelines_diabetes";

    public static final String TABLE_NAME54="guidelines_Asthma";
    public static final String as1="year";
    public static final String as2="district";
    public static final String as3="hc";
    public static final String as4="patientid";
    public static final String as5="bpcheck";
    public static final String as6="apptreatment";
    public static final String as7="severeclass";


    public static final String TABLE_NAME55="guidelines_Anc";
    public static final String anc1="year";
    public static final String anc2="district";
    public static final String anc3="hc";
    public static final String anc4="patientid";
    public static final String anc5="nationalanc";
    public static final String anc6="patienthistory";
    public static final String anc7="bpcheck";
    public static final String anc8="urinecheck";
    public static final String anc9="hemoglobincheck";
    public static final String anc10="rprcheck";
    public static final String anc11="ultracheck";

    public static final String TABLE_NAME56="guidelines_overall";
    public static final String ov1="year";
    public static final String ov2="district";
    public static final String ov3="hc";
    public static final String ov4="hyavailable";
    public static final String ov5="hyuptodate";
    public static final String ov6="hyinformed";
    public static final String ov7="diaavailable";
    public static final String ov8="diauptodate";
    public static final String ov9="diainformed";
    public static final String ov10="resavailable";
    public static final String ov11="resuptodate";
    public static final String ov12="resinformed";
    public static final String ov13="malavailable";
    public static final String ov14="maluptodate";
    public static final String ov15="malinformed";
    public static final String ov16="stiavailable";
    public static final String ov17="stiuptodate";
    public static final String ov18="stiinformed";


    public static final String TABLE_NAME57="guidelines_maternity";
    public static final String mat1="year";
    public static final String mat2="district";
    public static final String mat3="hc";
    public static final String mat4="nationaprotocol";
    public static final String mat5="essentialsupplies";
    public static final String mat6="privacyprovided";
    public static final String mat7="ppesupply";



    public static final String TABLE_NAME58="referal_process";
    public static final String ref1="year";
    public static final String ref2="district";
    public static final String ref3="hc";
    public static final String ref4="reason";
    public static final String ref5="findings";
    public static final String ref6="procedures";
    public static final String ref7="immediatecondition";
    public static final String ref8="patienttransferedto";
    public static final String ref9="feedback";
    public static final String ref10="referalsheets";
    public static final String ref11="standardform";
    public static final String ref12="transport";

    public static final String TABLE_NAME59="outpatient_malaria";
    public static final String omal1="year";
    public static final String omal2="district";
    public static final String omal3="hc";
    public static final String omal4="patientid";
    public static final String omal5="assesment";
    public static final String omal6="classification";
    public static final String omal7="correcttreatment";
    public static final String omal8="patienteducated";
    public static final String omal9="followup";
    public static final String omal10="malaria";
    public static final String omal11="orsgiven";

    public static final String TABLE_NAME60="outpatient_fever";
    public static final String TABLE_NAME61="outpatient_cough";
    public static final String TABLE_NAME62="outpatient_pnemonia";
    public static final String TABLE_NAME63="outpatient_diarhea";


    public static final String TABLE_NAME64="guidelinesASRH";
    public static final String asr1="year";
    public static final String asr2="district";
    public static final String asr3="hc";
    public static final String asr4="registers";
    public static final String asr5="spaces";
    public static final String asr6="rooms";

    public static final String TABLE_NAME65="inpatient_care";
    public static final String inc1="year";
    public static final String inc2="district";
    public static final String inc3="hc";
    public static final String inc4="patientid";
    public static final String inc5="assessmentchecklist";
    public static final String inc6="biographicaldata";
    public static final String inc7="relevanthistory";
    public static final String inc8="chiefcomplaint";
    public static final String inc9="rapidsurvey";
    public static final String inc10="vitalsigns";
    public static final String inc11="examsytem";
    public static final String inc12="diagnosis";
    public static final String inc13="nursingplan";
    public static final String inc14="soapnote";
    public static final String inc15="treatmanetplan";
    public static final String inc16="complete";

    public static final String TABLE_NAME66="key_indicators";
    public static final String ki1="year";
    public static final String ki2="district";
    public static final String ki3="hc";
    public static final String ki4="yearId";
    public static final String ki5="diacases";
    public static final String ki6="diadeaths";
    public static final String ki7="pnecases";
    public static final String ki8="pnedeaths";
    public static final String ki9="malcases";
    public static final String ki10="maldeaths";
    public static final String ki11="malucases";
    public static final String ki12="maludeaths";

    public static final String TABLE_NAME67="AdmitedPatient_outcome";
    public static final String ap1="year";
    public static final String ap2="district";
    public static final String ap3="hc";
    public static final String ap4="patientid";
    public static final String ap5="admissiondate";
    public static final String ap6="dischargedate";
    public static final String ap7="duration";
    public static final String ap8="outcome";


    public static final String TABLE_NAME68="outcome_hypertensionBP";
    public static final String oh1="year";
    public static final String oh2="district";
    public static final String oh3="hc";
    public static final String oh4="patientid";
    public static final String oh5="month1";
    public static final String oh6="month2";
    public static final String oh7="month3";
    public static final String oh8="month4";
    public static final String oh9="month5";
    public static final String oh10="month6";

    public static final String TABLE_NAME69="outcome_diabetesBS";
    public static final String TABLE_NAME70="outcome_AsthmaClass";

    public static final String TABLE_NAME71="value_pharmacyStock";
    public static final String vp1="year";
    public static final String vp2="district";
    public static final String vp3="hc";
    public static final String vp4="fyear";
    public static final String vp5="medcost";
    public static final String vp6="medexpcost";
    public static final String vp7="valuestock";

    public static final String TABLE_NAME72="pharmacy_dispensary";
    public static final String pd1="year";
    public static final String pd2="district";
    public static final String pd3="hc";
    public static final String pd4="drugname";
    public static final String pd5="drugexpired";
    public static final String pd6="pharmacyregister";
    public static final String pd7="pharmacytallies";
    public static final String pd8="pharmacybook";
    public static final String pd9="pharmacysigned";
    public static final String pd10="consumptiontotal";
    public static final String pd11="tallyconsmatch";


    public static final String TABLE_NAME73="generalinformation2";
    public static final String gi1="year";
    public static final String gi2="district";
    public static final String gi3="hc";
    public static final String gi4="meetmonth";
    public static final String gi5="qifocalperson";
    public static final String gi6="qifocalpersonletter";
    public static final String gi7="ipcfocalperson";
    public static final String gi8="ipcfocalpersonletter";
    public static final String gi9="custofocalperson";
    public static final String gi10="custofocalpersonletter";


    //comment section
    public static final String cs1="YEAR";
    public static final String cs2="DISTRICT";
    public static final String cs3="HC";
    public static final String cs4="SECTION";
    public static final String cs5="COMMENT";
    public static final String TABLE_NAME74="comments";



    public Databasehelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, EMAIL TEXT,PASSWORD TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME2 + "(YEAR TEXT, DISTRICT TEXT, HC TEXT,SECTOR TEXT, CELL TEXT,VILLAGE TEXT, PUBPOST TEXT, PRIPOST TEXT,POPULATION TEXT,PATIENTS TEXT,BEDS TEXT, CONSROOMS TEXT,HOSPROOMS TEXT,CHW TEXT,A0 TEXT,A1 TEXT,A2 TEXT,MIDWIFE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME3 + "(YEAR TEXT, DISTRICT TEXT, HC TEXT,ORGANI TEXT, UPTODATE TEXT,ACCESSIBLE TEXT,POSITION1 TEXT, LABTECAV TEXT,LABSIGN TEXT,LABEMP TEXT,POSITION2 TEXT, NURSEARV TEXT,NURSEARSIGN TEXT,NURSEAREMPSIGN TEXT,POSITION3 TEXT,NURSEVACAV TEXT,NURSEVACSIGN TEXT,NURSEVACEMPSIGN TEXT,POSITION4 TEXT, CUSTOCAREAV TEXT,CUSTCARESIGN TEXT,CUSTCAREEMPPSIGN TEXT,POSITION5 TEXT, NURSETBAV TEXT,NURSETBSIGN TEXT,NURSETBEMPSIGN TEXT,POSITION6 TEXT,NURSECHI TEXT,NURSECHISIGN TEXT,NURSECHIEMPSIGN TEXT,POSITION7 TEXT,SOCIALAV TEXT,SOCIALSIGN TEXT,SOCIALEMPSIGN TEXT,POSITION8 TEXT, NURSECPNAV TEXT,NURSECPNSIGN TEXT,NURSECPNEMPSIGN TEXT,POSITION9 TEXT,MIDWIFEAV TEXT,MIDWIFESIGN TEXT,MIDWIFEEMPSIGN TEXT,SOPPHARMACY TEXT,EVIDENCE TEXT,QICOMITEE TEXT,TOTSTAFF TEXT,TOTNURSE TEXT,PAIDSTAFF TEXT,CLINICALSTAFF TEXT,TBSTAFF TEXT,STAFFINFECTION TEXT,STAFFCOVID TEXT,STAFFEVALUATED TEXT,STAFFILLNESS TEXT,STAFFINJURIES TEXT,STAFFHEPATITE TEXT,STAFFRATE TEXT,PATIENTRATE TEXT,STAFFMETTING TEXT,COSAMETTING TEXT,COGEMETTING TEXT,CHWMETTING TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME4 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME5 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME6 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME7 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME8 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME9 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME10 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME11 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME12 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME13 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME14 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME15 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME16 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME17 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME18 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME19 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME20 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,RESPONSIBLENAME TEXT,CURRENTDATA TEXT,RESPONSIBLEPHOTO TEXT,AREA TEXT,REQUESTEDLISTOFSUPPLIES TEXT,CURRENTLISTOFSUPPLIES TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME21 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,DIRECTION TEXT,SERVICE TEXT,AREA TEXT,HYGIENE TEXT,HANDHYGIENE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME22 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,CURRENTDATA TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME23 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME24 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,COMSTAFF TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME25 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,APPROVEDCOSA TEXT,COMSTAFF TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME26 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,COMSTAFF TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME27   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,COMSTAFF TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME28   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVEDTI TEXT,COMSTAFF TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME29   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME30   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME31   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME32   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME33   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVED TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME34   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,TRACKED TEXT,APPROVED TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME35 + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,STAFFLATRINES TEXT,PATIRNETLATRINES TEXT,TOTALLATRINES TEXT,BROKENLATRINES TEXT,CLEANLATRINES TEXT,ODORLESSLATRINES TEXT,HANDWASHLATRINES TEXT,LATRINESCHEDULES TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME36   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,AVAILABLE TEXT,SIGNED TEXT,SUBMITED TEXT,DMAVAILABLE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME37   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME38   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME39   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME40   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,PATIENTFILE TEXT,REGISTER TEXT,HMIS_HARDCOPY TEXT,HMIS_SOFTCOPY TEXT,ACCURATE TEXT,LABREGISTER TEXT,PHARMACY TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME41   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,LINES TEXT,FIELDS TEXT,BLANKS TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME42   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,maternalyear TEXT,obsetricalANC TEXT,registrations TEXT,referalsANC TEXT,obsetricalMaternity TEXT,deliveries TEXT,livebirths TEXT,maternaldeaths TEXT,neonataldeaths TEXT,stillbirths TEXT,postpartun TEXT,anc4 TEXT,anc1 TEXT,underfivedeaths TEXT,childrenconsulted TEXT,contraceptiveusers TEXT,mr2vaccines TEXT,ultrasoundscans TEXT,deadunderfive TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME43   + "(year TEXT,district TEXT,hc TEXT,fyear TEXT, cbank TEXT, cpetty TEXT, creceivable TEXT, cpayable TEXT, cpharmacy TEXT, crevenue TEXT, chcincome TEXT, cmedecines TEXT, cexpenses TEXT, chrexpenses TEXT, cexpenditure TEXT, cpmedecines TEXT, cequipments TEXT, ctravel TEXT, cabudget TEXT, cpbudget TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME44   + "(YEAR TEXT,HC TEXT,DISTRICT TEXT,fyear TEXT,ivperiod TEXT,subcbhi TEXT,subrssb TEXT,submmi TEXT,returncbhi TEXT,returnrssb TEXT,returnmmi TEXT,verifyrssb TEXT,verifymmi TEXT,amountcbhi TEXT,amountrssb TEXT,amountmmi TEXT,aftercbhi TEXT,afterrssb TEXT,aftermmi TEXT,verifycbhi TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME45   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,INCOMEDATE TEXT,JOURNALINCOME TEXT,RECEIPTINCOME TEXT,INCOMEMATCH TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME46   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,ACCRECO TEXT,ACCBOOK TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME47   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,EXPENSEREFERENCE TEXT,EXPENSESIGNED TEXT,EXPENSEINVOICE TEXT,EXPENSENUMBERED TEXT,EXPENSEORDERED TEXT,EXPENSERECORDED TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME48   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,  rightsposted TEXT, infection TEXT, satisfactiontool TEXT, satisfactiondata TEXT, suggestionbox TEXT, qiincident TEXT, annualhazard TEXT, ppe TEXT, staffppe TEXT,staffsatisfactiontool TEXT, incidenttool TEXT, asrh TEXT, staffsatisfactiondata TEXT, patientincidents TEXT, patientincidentanalyzed TEXT, numberhazards TEXT, numberhazardsfixed TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME49   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, rmsessions TEXT, rmbeneficiones TEXT, rmscreened TEXT, idsessions TEXT, idbeneficiones TEXT, idscreened TEXT, ncsessions TEXT, ncbeneficiones TEXT, ncscreened TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME50   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,drugseparate TEXT,drugforms TEXT,drugrequisition TEXT,drugalphabet TEXT,drugclass TEXT,drugfifo TEXT,drugfefo TEXT,drugother TEXT,drugnone TEXT,pharmacydry TEXT,pharmacyclean TEXT,pharmacyprotected TEXT,pharmacyorganized TEXT,pharmacythermometer TEXT,pharmacyrefrigerator TEXT,pharmacymonitored TEXT,pharmacyinventory TEXT,pharmacyessentials TEXT,pharmacynotes TEXT, pharmacytemperature  TEXT,pharmacyrefrigiratortemp TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME51   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,drugname TEXT,drugquantity TEXT,drugquantityshelf TEXT,drugavailable TEXT,drugexpired TEXT,drugrequested TEXT,drugstockcard TEXT,drugstockcardfilled TEXT,drugexcess TEXT,druginventory TEXT,druglabel TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME52   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,weightcheck TEXT,currentprotocol TEXT,bpcheck TEXT,eyecheck TEXT,procheck TEXT,crecheck TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME53   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,weightcheck TEXT,currentprotocol TEXT,bpcheck TEXT,eyecheck TEXT,procheck TEXT,crecheck TEXT,footcheck TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME54   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,bpcheck TEXT,apptreatment TEXT,severeclass TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME55   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,nationalanc TEXT,patienthistory TEXT,bpcheck TEXT,urinecheck TEXT,hemoglobincheck TEXT,rprcheck TEXT,ultracheck TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME56   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,hyavailable TEXT,hyuptodate TEXT,hyinformed TEXT,diaavailable TEXT,diauptodate TEXT,diainformed TEXT,resavailable TEXT,resuptodate TEXT,resinformed TEXT,malavailable TEXT,maluptodate TEXT,malinformed TEXT,stiavailable TEXT,stiuptodate TEXT,stiinformed TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME57   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,nationaprotocol TEXT,essentialsupplies TEXT,privacyprovided TEXT,ppesupply TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME58   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, reason TEXT,findings TEXT,procedures TEXT,immediatecondition TEXT,patienttransferedto TEXT,feedback TEXT,referalsheets TEXT,standardform TEXT,transport TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME59   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT,followup TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME60   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT,followup TEXT,malaria TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME61   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME62   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT,followup TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME63   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT, patientid TEXT,assesment TEXT,classification TEXT,correcttreatment TEXT,patienteducated TEXT,followup TEXT,orsgiven TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME64   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,registers TEXT,spaces TEXT,rooms TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME65   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT,assessmentchecklist  TEXT,biographicaldata  TEXT,relevanthistory  TEXT,chiefcomplaint  TEXT,rapidsurvey  TEXT,vitalsigns  TEXT,examsytem  TEXT,diagnosis  TEXT,nursingplan  TEXT,soapnote  TEXT,treatmanetplan  TEXT,complete  TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME66   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,yearid TEXT, diacases TEXT,diadeaths TEXT,pnecases TEXT,pnedeaths TEXT,malcases TEXT, maldeaths TEXT,malucases TEXT, maludeaths TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME67   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT, admissiondate TEXT, dischargedate TEXT, duration TEXT,outcome TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME68   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT, month1 TEXT, month2 TEXT, month3 TEXT,month4 TEXT,month5 TEXT,month6 TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME69   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT, month1 TEXT, month2 TEXT, month3 TEXT,month4 TEXT,month5 TEXT,month6 TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME70   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,patientid TEXT, month1 TEXT, month2 TEXT, month3 TEXT,month4 TEXT,month5 TEXT,month6 TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME71   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,fyear TEXT,medcost TEXT,medexpcost TEXT,valuestock TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME72   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,drugname TEXT ,drugexpired TEXT ,pharmacyregister TEXT ,pharmacytallies TEXT,pharmacybook TEXT ,pharmacysigned TEXT,consumptiontotal  TEXT,tallyconsmatch TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME73   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,meetmonth TEXT,qifocalperson TEXT,qifocalpersonletter TEXT,ipcfocalperson TEXT,ipcfocalpersonletter TEXT,custofocalperson TEXT,custofocalpersonletter TEXT,STATUS DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME74   + "(YEAR TEXT,DISTRICT TEXT,HC TEXT,SECTION TEXT,COMMENT TEXT,STATUS DEFAULT 0)");

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
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME71);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME72);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME73);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME74);
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

    public boolean registerComment(String YEAR,String DISTRICT, String HC, String SECTION,String COMMENT){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(cs1, YEAR);
        values.put(cs2, DISTRICT);
        values.put(cs3, HC);
        values.put(cs4, SECTION);
        values.put(cs5, COMMENT);


        long result = db.insert(TABLE_NAME74, null, values);
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
    public boolean registerToiletsServiceDescription(String year, String district, String hc,String direction,String area,String hygiene,String handgygiene){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(anc_1,year);
        values.put(anc_2,district);
        values.put(anc_3,hc);
        values.put(anc_4,direction);
        values.put(anc_9,area);
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

    public boolean registerDocumentationBusinessPlan(String year, String district, String hc,String available,String tracked,String approvedti,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
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

    public boolean registerDocumentationInService(String year, String district, String hc,String available,String tracked,String approvedti,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME26, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }


    public boolean registerDocumentationWorkSchedule(String year, String district, String hc,String available,String tracked,String approvedti,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
        values.put(doc_8,comsatff);
        long result = db.insert(TABLE_NAME27, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerDocumentationQiplan(String year, String district, String hc,String available,String tracked,String approvedti,String comsatff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(doc_1,year);
        values.put(doc_2,district);
        values.put(doc_3,hc);
        values.put(doc_4,available);
        values.put(doc_5,tracked);
        values.put(doc_6,approvedti);
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

    public boolean registerDocumentationSanitation(String year, String district, String hc,String stafflatrines,String patientlatrines,String totlatrines,String brokelatrines,String cleanlatrines,String nodorlatrines,String handwashlatrine,String schedulelatrine){
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

    public boolean registerDatamanagementMalaria(String year, String district, String hc,String patientfile,String register,String hmis_hardcopy,String hmis_softcopy,String labregister,String accurate,String pharmacy){
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
        values.put(de10,labregister);
        values.put(de11,pharmacy);
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

    public boolean registerMaternalNeonatal( String year,String district,String hc,String maternalyear, String obsetricalANC, String registrations, String referalsANC, String obsetricalMaternity, String deliveries, String livebirths, String maternaldeaths, String neonataldeaths, String stillbirths, String postpartun, String anc4, String anc1, String underfivedeaths, String childrenconsulted, String contraceptiveusers, String mr2vaccines, String ultrasoundscans,String deadunderfive){
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
        values.put(m22  ,deadunderfive);
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


    public boolean RegisterAssuranceReview(String year  ,String hc  ,String district  ,String fyear  ,String ivperiod  ,String subcbhi  ,String subrssb  ,String submmi  ,String returncbhi  ,String returnrssb  ,String returnmmi  ,String verifyrssb  ,String verifymmi  ,String amountcbhi  ,String amountrssb  ,String amountmmi  ,String aftercbhi  ,String afterrssb  ,String aftermmi,String verifycbhi){
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
        values.put(iv20 ,verifycbhi);
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

    public boolean registerManagementReview(String year, String district, String hc,  String drugseparate, String drugforms, String drugrequisition, String drugalphabet, String drugclass, String drugfifo, String drugfefo, String drugother, String drugnone, String pharmacydry, String pharmacyclean, String pharmacyprotected, String pharmacyorganized, String pharmacythermometer, String pharmacyrefrigerator, String pharmacymonitored, String pharmacyinventory, String pharmacyessentials, String pharmacynotes, String pharmacytemperature,  String pharmacyrefrigiratortemp){

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

    public boolean registerReferal(String year, String district, String hc,  String reason,String findings,String procedures,String immediatecondition,String patienttransferedto,String feedback,String referalsheets,String standardform,String transport){

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
        values.put(ref12,transport);
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

    public boolean registerOutFever(String year, String district, String hc, String patientid , String assesment  ,String classification  ,String correcttreatment  ,String patienteducated  ,String followup,String malaria  ){

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
        values.put( omal10,malaria);
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
    public boolean registerOutDiarhea(String year, String district, String hc, String patientid , String assesment  ,String classification  ,String correcttreatment  ,String patienteducated  ,String followup  ,String orsgiven){

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
        values.put( omal11,followup);
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

    public boolean registerValuePharmacyStock(String year, String district, String hc,String fyear,String medcost,String medexpcost,String valuestock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(vp1,year);
        values.put(vp2,district);
        values.put(vp3,hc);
        values.put(vp4,fyear);
        values.put(vp5,medcost);
        values.put(vp6,medexpcost);
        values.put(vp7,valuestock);

        long result = db.insert(TABLE_NAME71, null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean registerValuePharmacyDispensary(String year, String district, String hc,String drugname ,String drugexpired,String pharmacyregister,String pharmacytallies,String pharmacybook,String pharmacysigned,String consumptiontotal,String tallyconsmatch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(pd1, year);
        values.put(pd2, district);
        values.put(pd3, hc);
        values.put(pd4, drugname);
        values.put(pd5, drugexpired);
        values.put(pd6, pharmacyregister);
        values.put(pd7, pharmacytallies);
        values.put(pd8, pharmacybook);
        values.put(pd9, pharmacysigned);
        values.put(pd10, consumptiontotal);
        values.put(pd11, tallyconsmatch);

        long result = db.insert(TABLE_NAME72, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean registerGeneralinformation2(String year, String district, String hc,String meetmonth,String qifocalperson,String qifocalpersonletter,String ipcfocalperson,String ipcfocalpersonletter,String custofocalperson,String custofocalpersonletter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(gi1, year);
        values.put(gi2, district);
        values.put(gi3, hc);
        values.put(gi4, meetmonth);
        values.put(gi5, qifocalperson);
        values.put(gi6, qifocalpersonletter);
        values.put(gi7, ipcfocalperson);
        values.put(gi8, ipcfocalpersonletter);
        values.put(gi9, custofocalperson);
        values.put(gi10, custofocalpersonletter);

        long result = db.insert(TABLE_NAME73, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static Cursor getUSers(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {COL_1,COL_2,COL_3,COL_4,COL_5,COL_6};
        String selection = COL_6+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateUsers(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL_6+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getBasicInfo(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {COL2_1,COL2_2,COL2_3,COL2_4,COL2_5,COL2_6,COL2_7,COL2_8,COL2_9,COL2_10,COL2_11,COL2_12,COL2_13,COL2_14,COL2_15,COL2_16,COL2_17,COL2_18};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME2,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateBasicInfo(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME2,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getBasicInfo2(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {COL3_1, COL3_2, COL3_3, COL3_4, COL3_5, COL3_6, COLP_1, COL3_7, COL3_8, COL3_9, COLP_2, COL3_10, COL3_11, COL3_12, COLP_3, COL3_13, COL3_14, COL3_15, COLP_4, COL3_16, COL3_17, COL3_18, COLP_5, COL3_19, COL3_20, COL3_21, COLP_6, COL3_22, COL3_23, COL3_24, COLP_7, COL3_25, COL3_26, COL3_27,COLP_8, COL3_28, COL3_29, COL3_30, COLP_9,  COL3_31, COL3_32, COL3_33, COL3_34, COL3_35, COL3_36, COL3_37, COL3_38, COL3_39, COL3_40, COL3_41, COL3_42, COL3_43, COL3_44,  COL3_45, COL3_46,  COL3_47, COL3_48, COL3_49, COL3_50, COL3_51, COL3_52, COL3_53 };
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME3,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateBasicInfo2(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME3,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getAnc_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME4,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateAnc_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME4,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getVacc_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME5,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateVacc_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME5,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getFam_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME6,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateFam_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME6,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getPharmaStock_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME7,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updatePharmaStock_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME7,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getPharmaDisp_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME8,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updatePharmacyDisp_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME8,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getncd_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME9,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updatencd_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME9,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getceho_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME10,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateceho_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME10,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getcashier_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME11,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updatecashier_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME11,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getAccounting_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME12,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateAccounting_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME12,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getLaboratory_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME13,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateLaboratory_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME13,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getTitulaire_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME14,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateTitulaire_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME14,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDataman_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME15,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDataman_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME15,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getArv_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME16,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateArv_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME16,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getCustoCare_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME17,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateCustoCare_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME17,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getConsroom_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME18,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateConsroom_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME18,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getMaternity_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME19,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateMaternity_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME19,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getHosproom_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_5,anc_6,anc_7,anc_8,anc_9,anc_10,anc_11,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME20,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateHosproom_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME20,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor gettoilets_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_4,anc_9,anc_12,anc_13};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME21,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updatetoilets_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME21,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getNoticeboard_servicedescription(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {anc_1,anc_2,anc_3,anc_7};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME22,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateNoticeboard_servicedescription(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME22,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getDocumentation_actionplan(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5,doc_6,doc_7,doc_8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME23,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_actionplan(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME23,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDocumentation_businessplan(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5,doc_6,doc_8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME24,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_businessplan(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME24,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDocumentation_budgetplan(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {doc_1,doc_2,doc_3,doc_4,doc_5,doc_6,doc_7,doc_8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME25,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_budgetplan(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME25,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDocumentation_inservice(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5,doc_6,doc_8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME26,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_inservice(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME26,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDocumentation_work(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5,doc_6,doc_8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME27,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_work(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME27,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDocumentation_qiplan(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5,doc_6,doc_8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME28,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_qiplan(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME28,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getDocumentation_externaltraining(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME29,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_externaltraining(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME29,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDocumentation_attendanceregister(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME30,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_attendanceregisters(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME30,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getDocumentation_payableregister(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME31,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_payableregisters(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME31,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getDocumentation_receivableregister(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME32,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_receivableregisters(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME32,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDocumentation_malariaplan(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5,doc_9};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME33,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_malariaplan(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME33,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDocumentation_CustomerCareProgram(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {doc_1,doc_2,doc_3,doc_4,doc_5,doc_9};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME34,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_CustomerCareprogram(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME34,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getDocumentation_sanitation(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME35,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateDocumentation_sanitation(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME35,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getdata_datamanagemntSOP(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {d1,d2,d3,d4,d5,d6,d7};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME36,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_datamanagementSOP(String old_status, String status, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME36,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_datamanagementDeliveries(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {de1,de2,de3,de4,de5,de6,de7,de8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME37,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_datamanagementDeliveries(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME37,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_datamanagementNCD(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {de1,de2,de3,de4,de5,de6,de7,de8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME38,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_datamanagementNCD(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME38,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_datamanagementBCG(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {de1,de2,de3,de4,de5,de6,de7,de8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME39,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_datamanagementBCG(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME39,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_MalariaCases(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {de1,de2,de3,de4,de5,de6,de7,de8,de10,de11};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME40,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_MalariaCases(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME40,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getData_OPDregisters(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {opd1,opd2,opd3,opd4,opd5,opd6};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME41,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_OPDregisters(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME41,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getData_MaternalNeonatal(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18,m19,m20,m21,m22};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME42,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_MaternalNeonatal(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME42,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_Finance_review(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {fr1,fr2,fr3,fr4,fr5,fr6,fr7,fr8,fr9,fr10,fr11,fr12,fr13,fr14,fr15,fr16,fr17,fr18,fr19,fr20};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME43,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_Finance_review(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME43,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_Insurance_review(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12,iv13,iv14,iv15,iv16,iv17,iv18,iv19,iv20};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME44,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_Insurance_review(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME44,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_Income_review(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {ic1,ic2,ic3,ic4,ic5,ic6,ic7};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME45,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_Income_review(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME45,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_Accounts(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {acc1,acc2,acc3,acc4,acc5};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME46,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_Accountss(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME46,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_Expense_review(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {ex1,ex2,ex3,ex4,ex5,ex6,ex7,ex8,ex9};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME47,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_Expense_review(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME47,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_SafetyManagement(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {sm1,sm2,sm3,sm4,sm5,sm6,sm7,sm8,sm9,sm10,sm11,sm12,sm13,sm14,sm15,sm16,sm17,sm18,sm19,sm20};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME48,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_safetyManagement(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME48,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getData_HealthEducation(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {he1,he2,he3,he4,he5,he6,he7,he8,he9,he10,he11,he12};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME49,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_HealthEducation(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME49,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getData_PharmacyManagement(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {pm1,pm2,pm3,pm4,pm5,pm6,pm7,pm8,pm9,pm10,pm11,pm12,pm13,pm14,pm15,pm16,pm17,pm18,pm19,pm20,pm21,pm22,pm27,pm28};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME50,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_PharmacyManagement(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME50,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_PharmacyStock(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {ps1,ps2,ps3,ps4,ps5,ps6,ps7,ps8,ps9,ps10,ps11,ps12,ps13,ps14};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME51,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_PharmacyStock(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME51,contentValues,selection,selection_args);
        return count;


    }



    public static Cursor getData_guideHypertension(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {hy1,hy2,hy3,hy4,hy5,hy6,hy7,hy8,hy9,hy10};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME52,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_guideHypertension(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME52,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_guideDiabetes(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {hy1,hy2,hy3,hy4,hy5,hy6,hy7,hy8,hy9,hy10,hy11};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME53,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_guideDiabetes(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME53,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_guideAsthma(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {as1,as2,as3,as4,as5,as5,as6,as7};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME54,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_guideAsthma(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME54,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_guideAnc(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {anc1,anc2,anc3,anc4,anc5,anc6,anc7,anc8,anc9,anc10,anc11};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME55,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_guideAnc(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME55,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_guideOverall(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {ov1,ov2,ov3,ov4,ov5,ov6,ov7,ov8,ov9,ov10,ov11,ov12,ov13,ov14,ov15,ov16,ov17,ov18};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME56,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_guideOverall(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME56,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_guideMaternity(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {mat1,mat2,mat3,mat4,mat5,mat6,mat7};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME57,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_guideMaternity(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME57,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_guideReferal(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {ref1,ref2,ref3,ref4,ref5,ref6,ref7,ref8,ref9,ref10,ref11,ref12};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME58,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_guideReferall(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME58,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_outpatientMalaria(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {omal1,omal2,omal3,omal4,omal5,omal6,omal7,omal8,omal9};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME59,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_outpatientMalaria(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME59,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_outpatientFever(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {omal1,omal2,omal3,omal4,omal5,omal6,omal7,omal8,omal9,omal10};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME60,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_outpatientFever(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME60,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_outpatientCough(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {omal1,omal2,omal3,omal4,omal5,omal6,omal7,omal8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME61,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_outpatientCough(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME61,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_outpatientPnemonia(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {omal1,omal2,omal3,omal4,omal5,omal6,omal7,omal8,omal9};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME62,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_outpatientPnemonia(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME62,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getData_outpatientDiar(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {omal1,omal2,omal3,omal4,omal5,omal6,omal7,omal8,omal9,omal11};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME63,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_outpatientDiar(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME63,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_guideASRH(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {asr1,asr2,asr3,asr4,asr5,asr6};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME64,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_guideASRH(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME64,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_InpatientCare(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {inc1,inc2,inc3,inc4,inc5,inc6,inc7,inc8,inc9,inc10,inc11,inc12,inc13,inc14,inc15,inc16};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME65,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_InpatientCare(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME65,contentValues,selection,selection_args);
        return count;


    }


    public static Cursor getData_KeyIndicators(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {ki1,ki2,ki3,ki4,ki5,ki6,ki7,ki8,ki9,ki10,ki11,ki12};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME66,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_KeyIndicators(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME66,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_AdmittedPatients(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {ap1,ap2,ap3,ap4,ap5,ap6,ap7,ap8};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME67,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_AdmittedPatients(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME67,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_AdmittedPatients_hp(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {oh1,oh2,oh3,oh4,oh5,oh6,oh7,oh8,oh9,oh10};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME68,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_AdmittedPatients_hp(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME68,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_DiabetetesBS(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {oh1,oh2,oh3,oh4,oh5,oh6,oh7,oh8,oh9,oh10};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME69,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_DiabetetesBS(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME69,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_AsthmaClass(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {oh1,oh2,oh3,oh4,oh5,oh6,oh7,oh8,oh9,oh10};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME70,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_AsthmaClass(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME70,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_PharmacyStockValue(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {vp1,vp2,vp3,vp4,vp5,vp6,vp7};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME71,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_PharmacyStockValue(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME71,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_PharmacyDispensary(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {pd1,pd2,pd3,pd4,pd5,pd6,pd7,pd8,pd9,pd10,pd11};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME72,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_PharmacyDispensary(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME72,contentValues,selection,selection_args);
        return count;


    }

    public static Cursor getData_GenInfo2(String status, SQLiteDatabase db){
        Cursor cursor;
        String[] projections =  {gi1,gi2,gi3,gi4,gi5,gi6,gi7,gi8,gi9,gi10};
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {status};
        cursor= db.query(TABLE_NAME73,projections,selection,selection_args  ,null,null,null);
        return cursor;
    }
    public static int updateData_GenInfo2(String old_status, String status,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        String selection = COL2_19+" LIKE ?";
        String[] selection_args = {old_status};
        int count = db.update(TABLE_NAME73,contentValues,selection,selection_args);
        return count;


    }

}
