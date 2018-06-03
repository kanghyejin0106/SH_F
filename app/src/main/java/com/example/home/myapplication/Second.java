package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button next = findViewById(R.id.next);

        final RadioGroup money = findViewById(R.id.money);
        final RadioGroup period = findViewById(R.id.period);
        final EditText school = findViewById(R.id.school);
        final CheckBox granm = findViewById(R.id.granm);
        final CheckBox granf = findViewById(R.id.granf);
        final CheckBox granc = findViewById(R.id.granc);
        final CheckBox home1 = findViewById(R.id.home1);
        final CheckBox home2 = findViewById(R.id.home2);
        final CheckBox home3 = findViewById(R.id.home3);
        final CheckBox home4 = findViewById(R.id.home4);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Second2.class);

                int selectedId = period.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter desired contract period.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("period", selectedId);
                }

                boolean checked0 = granm.isChecked();
                boolean checked1 = granf.isChecked();
                boolean checked2 = granc.isChecked();
                if(!checked0 && !checked1 && !checked2) {
                    Toast.makeText(getApplicationContext(), "Enter type of house order.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if(checked0)
                        intent.putExtra("granm", selectedId);
                    if(checked1)
                        intent.putExtra("granf", selectedId);
                    if(checked2)
                        intent.putExtra("granc", selectedId);
                }

                checked1 = home1.isChecked();
                boolean checked3 = home3.isChecked();
                boolean checked4 = home4.isChecked();
                checked2 = home2.isChecked();
                if(!checked1 && checked2 && checked3 && checked4) {
                    Toast.makeText(getApplicationContext(), "Enter type of house.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if(checked1)
                        intent.putExtra("home1", selectedId);
                    if(checked2)
                        intent.putExtra("home2", selectedId);
                    if(checked3)
                        intent.putExtra("home3", selectedId);
                    if(checked4)
                        intent.putExtra("home4", selectedId);
                }

                String ttedId = school.getText().toString();

                if(ttedId.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter your school.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("school", ttedId);
                }

                startActivity(intent);

            }
        });

    }
}
