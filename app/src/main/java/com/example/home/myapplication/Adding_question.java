package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Adding_question extends AppCompatActivity {
   String seniorMakeQ;
    DatabaseReference table;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_question);


        final CheckBox bf = findViewById(R.id.bf);
        final CheckBox kitchen = findViewById(R.id.kitchen);
        final CheckBox bathroom = findViewById(R.id.bathroom);
        final CheckBox coming = findViewById(R.id.comeback);
        final CheckBox sleep = findViewById(R.id.sleep);
        final CheckBox wake = findViewById(R.id.wakeup);
        final CheckBox noise = findViewById(R.id.noise);
        final CheckBox laundry = findViewById(R.id.laundry);
        final CheckBox call = findViewById(R.id.call);
        final CheckBox study = findViewById(R.id.study);


        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=getIntent();
                phone=i.getStringExtra("phone");
                boolean checked0 = bf.isChecked();
                boolean checked1 = kitchen.isChecked();
                boolean checked2 = laundry.isChecked();
                boolean checked3 = bathroom.isChecked();
                boolean checked4 = coming.isChecked();
                boolean checked5 = sleep.isChecked();
                boolean checked6 = wake.isChecked();
                boolean checked7 = call.isChecked();
                boolean checked8 = noise.isChecked();
                boolean checked9 = study.isChecked();

//        Intent c0 = new Intent();

                if(checked0) {
                    seniorMakeQ+="0/";
                }
                if (checked1) {
                    seniorMakeQ+="1/";
                } if (checked2) {
                    seniorMakeQ+="2/";
                } if (checked3) {
                    seniorMakeQ+="3/";
                } if (checked4) {
                    seniorMakeQ+="4/";
                } if (checked5) {
                    seniorMakeQ+="5/";
                } if (checked6) {
                    seniorMakeQ+="6/";
                } if (checked7) {
                    seniorMakeQ+="7/";
                } if (checked8) {
                    seniorMakeQ+="8/";
                } if (checked9) {
                    seniorMakeQ+="9/";
                }

                regMQ();
                Intent intent = new Intent(Adding_question.this, senior_main.class);
                startActivity(intent);
            }
        });
    }
    public void regMQ(){
        table= FirebaseDatabase.getInstance().getReference("Room").child(phone).child("seniorMq");
        table.setValue(seniorMakeQ);
    }
}
