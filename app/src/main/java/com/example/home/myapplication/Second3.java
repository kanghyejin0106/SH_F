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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second3);

        Button next = findViewById(R.id.next);

        final String[] data = getResources().getStringArray(R.array.wake);

        final Spinner wakeup = findViewById(R.id.wakeup);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, data);

        wakeup.setAdapter(adapter);

        wakeup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), data[i], Toast.LENGTH_LONG).show();
            }
        });

/*        final Spinner sleep = findViewById(R.id.sleep);
        final Spinner comeback = findViewById(R.id.comeback);
        final Spinner call = findViewById(R.id.call);
        final RadioGroup bath = findViewById(R.id.bath);
        final Spinner bath_m = findViewById(R.id.bath_m);
        final Spinner bath_n = findViewById(R.id.bath_n);
        final RadioGroup weekend = findViewById(R.id.weekend);
*/
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second3.this, Second4.class);
/*                int selectedId = wakeup.CheckedArrayId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter your Religion.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("reli", selectedId);
                }

                selectedId = pet.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about pet.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("pet", selectedId);
                }

                selectedId = smoky.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about smoking", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("smoky", selectedId);
                }
                selectedId = drunken.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about drinking alcohol.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("drunken", selectedId);
                }

                selectedId = bf.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about breakfast.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    intent.putExtra("bf", selectedId);
                }*/

                startActivity(intent);

            }
        });

    }
}
