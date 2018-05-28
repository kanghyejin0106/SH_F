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
        final CheckBox gran = findViewById(R.id.granm);
        final CheckBox home1 = findViewById(R.id.home1);


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

                boolean checked = gran.isChecked();
                if(!checked) {
                    Toast.makeText(getApplicationContext(), "Enter type of house order.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("gran", selectedId);
                }

                checked = home1.isChecked();
                if(!checked) {
                    Toast.makeText(getApplicationContext(), "Enter type of house.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("home", selectedId);
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
