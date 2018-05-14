package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class Question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        CheckBox agree = findViewById(R.id.agree);
        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button vi = v.getRootView().findViewById(R.id.next);

                if(vi.getVisibility() == View.GONE)
                v.getRootView().findViewById(R.id.next).setVisibility(View.VISIBLE);
                else
                    v.getRootView().findViewById(R.id.next).setVisibility(View.GONE);
            }
        });

        Button next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Second.class);
                startActivity(intent);
            }
        });
    }
}
