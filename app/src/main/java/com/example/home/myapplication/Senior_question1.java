package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Senior_question1 extends AppCompatActivity {
    boolean StudentGenderD;//true면 여자 false면 남자
    boolean furniture;//true면 가구제공 false면 가구 제공안함
    String furnitureType="";//가구종류
    int securityD;//보안 종류 1이면 Doorlock 2이면 key 3이면 keys+shackles
    boolean wifiD;//true면 wifi 제공 false면 제공안함
    boolean vactionRent;//ture면 방학동안에 살지않아도 돈을 내야함 false면 반대
    DatabaseReference table;
    String phone;
    RadioGroup security;RadioGroup wifi;RadioGroup vacation;RadioGroup provide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_question1);
        security = findViewById(R.id.security);
        wifi = findViewById(R.id.wifi);
        vacation = findViewById(R.id.vacation);
        provide = findViewById(R.id.provide_fur);
        Button next = findViewById(R.id.next);


        provide.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1) {
                    LinearLayout li = (LinearLayout)findViewById(R.id.furniture);
                    switch (checkedId){
                        case R.id.pf_y:
                            furniture=true;
                            li.setVisibility(View.VISIBLE);
                            OncheckedFurniture();
                            break;
                        case R.id.pf_n:
                            furniture=false;
                            furnitureType="";
                            li.setVisibility(View.GONE);
                            break;
                    }
                }

            }

            private void OncheckedFurniture() {

                CheckBox fur1 = findViewById(R.id.fur1);
                CheckBox fur2 = findViewById(R.id.fur2);
                CheckBox fur3 = findViewById(R.id.fur3);
                CheckBox fur4 = findViewById(R.id.fur4);
                CheckBox fur5 = findViewById(R.id.fur5);
                CheckBox fur6 = findViewById(R.id.fur6);
                CheckBox fur7 = findViewById(R.id.fur7);
                CheckBox fur8 = findViewById(R.id.fur8);
                CheckBox fur9 = findViewById(R.id.fur9);
                CheckBox fur10 = findViewById(R.id.fur10);
                CheckBox fur11 = findViewById(R.id.fur11);
                CheckBox fur12 = findViewById(R.id.fur12);
                CheckBox fur13 = findViewById(R.id.fur13);
                CheckBox fur14 = findViewById(R.id.fur14);

                boolean checked0 = fur1.isChecked();
                if(checked0){
                    furnitureType+="/Bed";
                }
                boolean checked1 = fur2.isChecked();
                if(checked1){furnitureType+="/Desk";}
                boolean checked2 = fur3.isChecked();
                if(checked2){furnitureType+="/Closet";}
                boolean checked3 = fur4.isChecked();
                if(checked3){furnitureType+="/Shelves";}
                boolean checked4 = fur5.isChecked();
                if(checked4){furnitureType+="/Shoe rack";}
                boolean checked5 = fur6.isChecked();
                if(checked5){furnitureType+="/Sink";}
                boolean checked6 = fur7.isChecked();
                if(checked6){furnitureType+="/Washing machine";}
                boolean checked7 = fur8.isChecked();
                if(checked7){furnitureType+="/Fan";}
                boolean checked8 = fur9.isChecked();
                if(checked8){furnitureType+="/Air conditioner";}
                boolean checked9 = fur10.isChecked();
                if(checked9){furnitureType+="/Basin";}
                boolean checked10 = fur11.isChecked();
                if(checked10){furnitureType+="/Shower";}
                boolean checked11 = fur12.isChecked();
                if(checked11){furnitureType+="/Boiler";}
                boolean checked12 = fur13.isChecked();
                if(checked12){furnitureType+="/Induction";}
                boolean checked13 = fur14.isChecked();
                if(checked13){furnitureType+="/Refrigerator";}
                if (!checked0 && !checked1 && !checked2 && !checked3 && !checked4 && !checked5
                        && !checked6 && !checked7 && !checked8 && !checked9 && !checked10
                        && !checked11 && !checked12 && !checked13) {
//                    Toast.makeText(getApplicationContext(), "Enter providing furniture.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
//                    switch ()
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent id=getIntent();
                phone=id.getStringExtra("phone");
                CheckBox fe = findViewById(R.id.fe);
                CheckBox m = findViewById(R.id.m);


                if(fe.isChecked()){StudentGenderD=true;}
                else if (m.isChecked()){StudentGenderD=false;}

                if(!fe.isChecked() && !m.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Enter about which you want gender of student.", Toast.LENGTH_SHORT).show();
                    return;
                }


                int selectedId = provide.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter your providing furniture.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    //intent.putExtra("provide", selectedId);
                }

                selectedId = security.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about home security.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (selectedId){
                        case R.id.security1:
                            securityD=1;
                            break;
                        case R.id.security2:
                            securityD=2;
                            break;
                        case R.id.security3:
                            securityD=3;
                            break;
                    }
                    ///intent.putExtra("security", selectedId);
                }

                selectedId = wifi.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about wifi.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (selectedId){
                        case R.id.wifi_y:
                            wifiD=true;
                            break;
                        case R.id.wifi_n:
                            wifiD=false;
                            break;
                    }
                    //intent.putExtra("wifi", selectedId);
                }

                selectedId = vacation.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about vacation rent expense", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (selectedId){
                        case R.id.vacation_y:
                            vactionRent=true;
                            break;
                        case R.id.vacation_n:
                            vactionRent=false;
                            break;
                    }
                    //intent.putExtra("vacation", selectedId);
                }
                regSeniorQ();
                Toast.makeText(getApplicationContext(),"dd",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Senior_question1.this, Second2.class);
                intent.putExtra("phone",phone);
                startActivity(intent);
            }
        });
    }
    public void regSeniorQ(){
        table= FirebaseDatabase.getInstance().getReference("senior").child(phone).child("seniorQ");
        SeniorQuestionData Sgd=new SeniorQuestionData(StudentGenderD,furniture,furnitureType,securityD,
                wifiD,vactionRent,0,0,0,0,0);
        table.setValue(Sgd);
    }
}
