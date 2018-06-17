package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Second3 extends AppCompatActivity {

    private Spinner sleep;
    private Spinner wake;
    private Spinner comeback;
    private Spinner call;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button next = findViewById(R.id.next);

        addListenerOnwake();
        addListenerOnsleep();
        addListenerOncomeback();
        addListenerOncall();

        final RadioGroup noise = findViewById(R.id.noise);
        final RadioGroup laundry = findViewById(R.id.laundry);
        final RadioGroup bf = findViewById(R.id.bf);
        final RadioGroup bathroom = findViewById(R.id.bathroom);
        final RadioGroup kitchen = findViewById(R.id.kit);
        final RadioGroup study = findViewById(R.id.study);

//        final RadioGroup bath = findViewById(R.id.bath);
//         final RadioGroup weekend = findViewById(R.id.weekend);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second3.this, Activity_login.class);

/*                Toast.makeText(MainActivity.this,
                        "OnClickListener : " + "\nwake : " + String.valueOf(wake.getSelectedItem())
                                + "\nsleep : " + String.valueOf(sleep.getSelectedItem())
                                + "\ncomeback : " + String.valueOf(comeback.getSelectedItem())
                                + "\nbath_m : " + String.valueOf(bath_m.getSelectedItem())
                                + "\nbath_n : " + String.valueOf(bath_n.getSelectedItem()), Toast.LENGTH_SHORT).show();
*/
                int selectedId = noise.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter your time using bathroom.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("noise", selectedId);
                }

                selectedId = laundry.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about what you do on weekend.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("laundry", selectedId);
                }

                selectedId = bf.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about what you do on weekend.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("bf", selectedId);
                }

                selectedId = kitchen.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about what you do on weekend.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("kitchen", selectedId);
                }

                selectedId = bathroom.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about what you do on weekend.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("bathroom", selectedId);
                }

                selectedId = study.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about what you do on weekend.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("study", selectedId);
                }

                startActivity(intent);

            }
        });

    }

    private void addListenerOnwake() {
        wake = (Spinner)findViewById(R.id.wakeup);
        wake.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    private void addListenerOnsleep() {
        sleep = (Spinner)findViewById(R.id.sleep);
        sleep.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    private void addListenerOncomeback() {
        comeback = (Spinner)findViewById(R.id.comeback);
        comeback.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    private void addListenerOncall() {
        call = (Spinner)findViewById(R.id.call);
        call.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    private class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}


