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

public class Second3 extends AppCompatActivity {

    private Spinner sleep;
    private Spinner wake;
    private Spinner comeback;
    private Spinner call;
    private Spinner bath_m;
    private Spinner bath_n;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button next = findViewById(R.id.next);

        addListenerOnwake();

        final RadioGroup bath = findViewById(R.id.bath);
        final RadioGroup weekend = findViewById(R.id.weekend);

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
                int selectedId = bath.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter your time using bathroom.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("bath", selectedId);
                }

                selectedId = weekend.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about what you do on weekend.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("weekend", selectedId);
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

    private void addListenerOnbath_m() {
        bath_m = (Spinner)findViewById(R.id.bath_m);
        bath_m.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    private void addListenerOnbath_n() {
        bath_n = (Spinner)findViewById(R.id.bath_n);
        bath_n.setOnItemSelectedListener(new CustomOnItemSelectedListener());
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
