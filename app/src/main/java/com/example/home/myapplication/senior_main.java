package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class senior_main extends AppCompatActivity {
    String SeniorID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_main);
        Button button = (Button) findViewById(R.id.button2);
        Intent intent=getIntent();
       SeniorID=intent.getStringExtra("ID");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(senior_main.this,Senior_addroom.class);
                intent.putExtra("ID",SeniorID);
                startActivity(intent);
            }
        });
    }
}
