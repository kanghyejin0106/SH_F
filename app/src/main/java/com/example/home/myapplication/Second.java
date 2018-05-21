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

        Button submit = findViewById(R.id.submit);
        final RadioGroup pet = findViewById(R.id.pet);
        final RadioGroup money = findViewById(R.id.money);
        final RadioGroup period = findViewById(R.id.period);
        final RadioGroup smoky = findViewById(R.id.smoky);
        final RadioGroup reli = findViewById(R.id.reli);
        final RadioGroup drunken = findViewById(R.id.drunken);
        final RadioGroup fest = findViewById(R.id.fest);
        final RadioGroup first = findViewById(R.id.first);
        final RadioGroup second = findViewById(R.id.second);
        final RadioGroup th = findViewById(R.id.third);
        final EditText school = findViewById(R.id.school);
        final EditText intro = findViewById(R.id.intro);
        final CheckBox gran = findViewById(R.id.granm);
        final CheckBox home1 = findViewById(R.id.home1);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Third.class);
                int selectedId = period.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter desired contract period.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("period", selectedId);
                }

                selectedId = reli.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "종교를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("reli", selectedId);
                }

                selectedId = pet.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "애완 동물 여부를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("pet", selectedId);
                }

                selectedId = smoky.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "흡연 여부를 체크해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("smoky", selectedId);
                }
                selectedId = drunken.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "음주 여부를 체크해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("drunken", selectedId);
                }
                selectedId = fest.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "아침 여부를 체크해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("fest", selectedId);
                }

                selectedId = first.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "1순위를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("first", selectedId);
                }

                selectedId = second.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "2순위를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("second", selectedId);
                }

                selectedId = th.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "3순위를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("th", selectedId);
                }

                boolean checked = gran.isChecked();
                if(!checked) {
                    Toast.makeText(getApplicationContext(), "거주 희망자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("gran", selectedId);
                }

                checked = home1.isChecked();
                if(!checked) {
                    Toast.makeText(getApplicationContext(), "입력 안 된 문항이 있습니다.", Toast.LENGTH_SHORT).show();
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

                ttedId = intro.getText().toString();
                if(ttedId.equals("")) {
                    Toast.makeText(getApplicationContext(), "자기 소개를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("intro", ttedId);
                    startActivity(intent);
                }


            }
        });

    }
}
