package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Senior_question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_question1);

        final RadioGroup provide = findViewById(R.id.provide_fur);
        final RadioGroup security = findViewById(R.id.security);
        final RadioGroup wifi = findViewById(R.id.security);
        final RadioGroup vacation = findViewById(R.id.vacation);
        Button next = findViewById(R.id.next);

        provide.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1) {
                    LinearLayout li = (LinearLayout)findViewById(R.id.furniture);
                    switch (checkedId){
                        case R.id.pf_y:
                            li.setVisibility(View.VISIBLE);
//                            OncheckedFurniture();
                            break;
                        case R.id.pf_n:
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
                boolean checked1 = fur2.isChecked();
                boolean checked2 = fur3.isChecked();
                boolean checked3 = fur4.isChecked();
                boolean checked4 = fur5.isChecked();
                boolean checked5 = fur6.isChecked();
                boolean checked6 = fur7.isChecked();
                boolean checked7 = fur8.isChecked();
                boolean checked8 = fur9.isChecked();
                boolean checked9 = fur10.isChecked();
                boolean checked10 = fur11.isChecked();
                boolean checked11 = fur12.isChecked();
                boolean checked12 = fur13.isChecked();
                boolean checked13 = fur14.isChecked();
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
                Intent intent = new Intent(Senior_question1.this, Activity_login.class);

                CheckBox fe = findViewById(R.id.fe);
                CheckBox m = findViewById(R.id.m);

                boolean checked0 = fe.isChecked();
                boolean checked1 = m.isChecked();

                if(!checked0 && !checked1) {
                    Toast.makeText(getApplicationContext(), "Enter about which you want gender of student.", Toast.LENGTH_SHORT).show();
                    return;
                }


                int selectedId = provide.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter your providing furniture.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("provide", selectedId);
                }

                selectedId = security.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about home security.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("security", selectedId);
                }

                selectedId = wifi.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about wifi.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("wifi", selectedId);
                }

                selectedId = vacation.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about vacation rent expense", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("vacation", selectedId);
                }

                startActivity(intent);
            }
        });


    }
}
