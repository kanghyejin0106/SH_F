package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Second extends AppCompatActivity {

  DatabaseReference table;
    EditText school;

    String email;
    int checkmoney;
    int checkPeriod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button next = findViewById(R.id.next);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
           email = bundle.getString("email");
            Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();
        }

       RadioGroup money = (RadioGroup) findViewById(R.id.money);
       RadioGroup period =  (RadioGroup)findViewById(R.id.period);

       school = (EditText) findViewById(R.id.school);


        final CheckBox granm = findViewById(R.id.granm);
        final CheckBox granf = findViewById(R.id.granf);
        final CheckBox granc = findViewById(R.id.granc);
        final CheckBox home1 = findViewById(R.id.home1);
        final CheckBox home2 = findViewById(R.id.home2);
        final CheckBox home3 = findViewById(R.id.home3);
        final CheckBox home4 = findViewById(R.id.home4);
        period.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    Toast.makeText(getApplicationContext(), "Enter desired contract period.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (i){
                        case R.id.ms4:
                            checkPeriod=1;
                            break;
                        case R.id.ms6:
                            checkPeriod=2;
                            break;
                        case R.id.ms66:
                            checkPeriod=3;
                            break;
                    }
                }
            }
        });
       // Toast.makeText(getApplicationContext(),checkPeriod,Toast.LENGTH_SHORT).show();
        money.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    Toast.makeText(getApplicationContext(), "Enter desired rent.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (i){
                        case R.id.min15:
                            checkmoney=1;
                            break;
                        case R.id.min20:
                            checkmoney=2;
                            break;
                        case R.id.min25:
                            checkmoney=3;
                            break;
                        case R.id.min30:
                            checkmoney=4;
                            break;
                        case R.id.min35:
                            checkmoney=5;
                            break;
                    }
                }
            }
        });
        //Toast.makeText(getApplicationContext(),checkmoney,Toast.LENGTH_SHORT).show();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Second2.class);


                intent.putExtra("period", checkPeriod);


                boolean checked0 = granm.isChecked();
                boolean checked1 = granf.isChecked();
                boolean checked2 = granc.isChecked();
                if (!checked0 && !checked1 && !checked2) {
                    Toast.makeText(getApplicationContext(), "Enter type of house order.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (checked0)
                        intent.putExtra("granm", checked0);
                    if (checked1)
                        intent.putExtra("granf", checked1);
                    if (checked2)
                        intent.putExtra("granc", checked2);
                }

                boolean home1Checked = home1.isChecked();
                boolean home2Checked = home2.isChecked();
                boolean home3Checked = home3.isChecked();
                boolean home4Checked = home4.isChecked();
                if (!home1Checked && home2Checked && home3Checked && home4Checked) {
                    Toast.makeText(getApplicationContext(), "Enter type of house.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (home1Checked)
                        intent.putExtra("home1", home1Checked);
                    if (home2Checked)
                        intent.putExtra("home2", home2Checked);
                    if (home3Checked)
                        intent.putExtra("home3", home3Checked);
                    if (home4Checked)
                        intent.putExtra("home4", home4Checked);
                }

                String ttedId = school.getText().toString();

                if (ttedId.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter your school.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("school", ttedId);
                }



                regQ();
                table.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                startActivity(intent);

            }
        });
    }

    public void regQ(){
          table= FirebaseDatabase.getInstance().getReference("student").child(email);
          table.child("period").setValue(checkPeriod);
          table.child("school").setValue(school.getText().toString());
          table.child("money").setValue(checkmoney);
    }


}
