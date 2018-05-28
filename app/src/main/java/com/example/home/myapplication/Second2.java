package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Second2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Button next = findViewById(R.id.next);
        final RadioGroup smoky = findViewById(R.id.smoky);
        final RadioGroup pet = findViewById(R.id.pet);
        final RadioGroup reli = findViewById(R.id.reli);
        final RadioGroup drunken = findViewById(R.id.drunken);
        final RadioGroup bf = findViewById(R.id.bf);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Third.class);
                int selectedId = reli.getCheckedRadioButtonId();
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

                selectedId = bf.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "아침 여부를 체크해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("bf", selectedId);
                }

            }
        });
    }
}