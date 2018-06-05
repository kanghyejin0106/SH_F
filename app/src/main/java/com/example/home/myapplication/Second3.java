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
<<<<<<< HEAD

    private Spinner sleep;
    private Spinner wake;
    private Spinner comeback;
    private Spinner call;
    private Spinner bath_m;
    private Spinner bath_n;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
=======
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {

<<<<<<< HEAD
=======
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second3);
//
//        Button next = findViewById(R.id.next);
//
//        final Spinner wakeup = findViewById(R.id.wakeup);
//        final Spinner sleep = findViewById(R.id.sleep);
//        final Spinner comeback = findViewById(R.id.comeback);
//        final Spinner call = findViewById(R.id.call);
//        final RadioGroup bath = findViewById(R.id.bath);
//        final Spinner bath_m = findViewById(R.id.bath_m);
//        final Spinner bath_n = findViewById(R.id.bath_n);
//        final RadioGroup weekend = findViewById(R.id.weekend);
//
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Second3.this, Second4.class);
//                int selectedId = wakeup.CheckedArrayId();
//                if(selectedId == -1) {
//                    Toast.makeText(getApplicationContext(), "Enter your Religion.", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//                    intent.putExtra("reli", selectedId);
//                }
//
//                selectedId = pet.getCheckedRadioButtonId();
//                if(selectedId == -1) {
//                    Toast.makeText(getApplicationContext(), "Enter about pet.", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//                    intent.putExtra("pet", selectedId);
//                }
//
//                selectedId = smoky.getCheckedRadioButtonId();
//                if(selectedId == -1) {
//                    Toast.makeText(getApplicationContext(), "Enter about smoking", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//                    intent.putExtra("smoky", selectedId);
//                }
//                selectedId = drunken.getCheckedRadioButtonId();
//                if(selectedId == -1) {
//                    Toast.makeText(getApplicationContext(), "Enter about drinking alcohol.", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//                    intent.putExtra("drunken", selectedId);
//                }
//
//                selectedId = bf.getCheckedRadioButtonId();
//                if(selectedId == -1) {
//                    Toast.makeText(getApplicationContext(), "Enter about breakfast.", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//                    intent.putExtra("bf", selectedId);
//                }
//
//                startActivity(intent);
//
//            }
//        });

>>>>>>> b73a9465fe8aac7d3ce637ff3568e622d4c6ccad
>>>>>>> eb384667719297e08a731cb429e1759b7fdf3b9d
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button next = findViewById(R.id.next);

        addListenerOnwake();

<<<<<<< HEAD
=======
        wakeup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), data[i], Toast.LENGTH_LONG).show();
            }
        });

        final Spinner sleep = findViewById(R.id.sleep);
        final Spinner comeback = findViewById(R.id.comeback);
        final Spinner call = findViewById(R.id.call);
>>>>>>> eb384667719297e08a731cb429e1759b7fdf3b9d
        final RadioGroup bath = findViewById(R.id.bath);
        final RadioGroup weekend = findViewById(R.id.weekend);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                Intent intent = new Intent(Second3.this, Activity_login.class);

/*                Toast.makeText(MainActivity.this,
                        "OnClickListener : " + "\nwake : " + String.valueOf(wake.getSelectedItem())
                                + "\nsleep : " + String.valueOf(sleep.getSelectedItem())
                                + "\ncomeback : " + String.valueOf(comeback.getSelectedItem())
                                + "\nbath_m : " + String.valueOf(bath_m.getSelectedItem())
                                + "\nbath_n : " + String.valueOf(bath_n.getSelectedItem()), Toast.LENGTH_SHORT).show();
*/
                int selectedId = bath.getCheckedRadioButtonId();
=======
                Intent intent = new Intent(Second3.this, Second4.class);
<<<<<<< HEAD

               int selectedId = wakeup.CheckedArrayId();

               int selectedId = wakeup.CheckedArrayId();

=======
/*                int selectedId = wakeup.CheckedArrayId();
>>>>>>> b73a9465fe8aac7d3ce637ff3568e622d4c6ccad
>>>>>>> eb384667719297e08a731cb429e1759b7fdf3b9d
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

<<<<<<< HEAD
=======
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
<<<<<<< HEAD

                }

                }
=======
                }*/

>>>>>>> b73a9465fe8aac7d3ce637ff3568e622d4c6ccad

>>>>>>> eb384667719297e08a731cb429e1759b7fdf3b9d
                startActivity(intent);

            }
<<<<<<< HEAD

        });

        });

    }*/

=======
        });

    }
<<<<<<< HEAD

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
=======
>>>>>>> b73a9465fe8aac7d3ce637ff3568e622d4c6ccad
>>>>>>> eb384667719297e08a731cb429e1759b7fdf3b9d
}
