package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class First extends AppCompatActivity{
    DatabaseReference table;
    String email=null;
    String phone=null;
    String getCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitDiskReads().permitDiskWrites().permitNetwork().build());

        table = FirebaseDatabase.getInstance().getReference("student");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Intent in =this.getIntent();
        email = in.getExtras().getString("email");


        TextView text = (TextView) findViewById(R.id.text2);


        //Intent intent = getIntent();

        Button btn2 = (Button)findViewById(R.id.btn_Confirm);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(First.this, Question.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });


    }
}

