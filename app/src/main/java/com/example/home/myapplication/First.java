package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class First extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        TextView text = (TextView) findViewById(R.id.text2);

        //Intent intent = getIntent();

        Button btn2 = (Button)findViewById(R.id.btn_Confirm);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First.this, Question.class);
                startActivity(intent);
            }
        });


    }
}

