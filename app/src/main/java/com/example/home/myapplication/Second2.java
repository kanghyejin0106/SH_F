package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class    Second2 extends AppCompatActivity {
    String email;
    int religionD,petD,smoke,alcohol,breakfast,invite;
    DatabaseReference table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            email = bundle.getString("email");
            Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();
        }

        Button next = findViewById(R.id.next);

        final RadioGroup smoky = findViewById(R.id.smoky);
        final RadioGroup pet = findViewById(R.id.pet);
        final RadioGroup reli = findViewById(R.id.reli);
        final RadioGroup drunken = findViewById(R.id.drunken);
        final RadioGroup bf = findViewById(R.id.bf);
//        final RadioGroup in=(RadioGroup)findViewById(R.id.in);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Second2.this, senior_main.class);

                intent.putExtra("ID",email);
                int selectedId = reli.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter your Religion.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (selectedId){
                        case R.id.reli1:
                            religionD=1;
                            break;
                        case R.id.reli2:
                            religionD=2;
                            break;
                        case R.id.reli3:
                            religionD=3;
                            break;
                        case R.id.reli4:
                            religionD=4;
                            break;
                        case R.id.reli5:
                            religionD=5;
                            break;
                    }
                    intent.putExtra("reli", selectedId);
                }

                selectedId = pet.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about pet.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (selectedId){
                        case R.id.pet1:
                            petD=1;
                            break;
                        case R.id.pet2:
                            petD=2;
                            break;
                        case R.id.pet3:
                            petD=3;
                            break;
                    }
                    intent.putExtra("pet", selectedId);
                }

                selectedId = smoky.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about smoking", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (selectedId){
                        case R.id.smoky1:
                            smoke=1;
                            break;
                        case R.id.smoky2:
                            smoke=2;
                            break;
                        case R.id.smoky3:
                            smoke=3;
                            break;
                        case R.id.smoky4:
                            smoke=4;
                            break;

                    }
                    intent.putExtra("smoky", selectedId);
                }
                selectedId = drunken.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about drinking alcohol.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (selectedId){
                        case R.id.drunken1:
                            alcohol=1;
                            break;
                        case R.id.drunken2:
                            alcohol=2;
                            break;
                        case R.id.drunken3:
                            alcohol=3;
                            break;
                        case R.id.drunken4:
                            alcohol=4;
                            break;
                    }
                    intent.putExtra("drunken", selectedId);
                }

                selectedId = bf.getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Enter about breakfast.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    switch (selectedId){
                        case R.id.bf1:
                            breakfast=1;
                            break;
                        case R.id.bf2:
                            breakfast=2;
                            break;
                        case R.id.bf3:
                            breakfast=3;
                            break;
                        case R.id.bf4:
                            breakfast=4;
                            break;
                    }
                    intent.putExtra("bf", selectedId);
                }

                startActivity(intent);

            }
        });
    }
    public void regQData(){
        Intent intent=getIntent();
        String str=intent.getStringExtra("phone");
        table= FirebaseDatabase.getInstance().getReference("senior").child(str).child("seniorQ");
        table.child("religion").setValue(religionD);
        table.child("pet").setValue(petD);
        table.child("smoke").setValue(smoke);
        table.child("alcohol").setValue(alcohol);
        table.child("breakfast").setValue(breakfast);
    }
}