package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Adding_question extends AppCompatActivity {

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
/*                boolean checked0 = bf.isChecked();
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
//            c0.putExtra("bf", 0);

                } if (checked1) {

                } if (checked2) {

                } if (checked3) {

                } if (checked4) {

                } if (checked5) {

                } if (checked6) {

                } if (checked7) {

                } if (checked8) {

                } if (checked9) {

                }

*/
                Intent intent = new Intent(Adding_question.this, Success_adding.class);
                startActivity(intent);
            }
        });
    }
}
