package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Question extends AppCompatActivity {
    String email;
    String phone;
    String check;
    Button vi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Intent in=getIntent();
        check=in.getStringExtra("check");
        if(check.equals("2")){
            phone=in.getStringExtra("phone");
        }
        else{
            email=in.getStringExtra("email");
        }


        CheckBox agree = findViewById(R.id.agree);
        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               vi = v.getRootView().findViewById(R.id.next);

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
                //Intent in=getIntent();
                //=in.getStringExtra("check");
                Toast.makeText(getApplicationContext(),check, Toast.LENGTH_SHORT).show();
                if(check.equals("2")){
                    Intent intent = new Intent(Question.this, Activity_login.class);
                    intent.putExtra("type","2");
                    intent.putExtra("phone",phone);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Question.this, Second.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }

            }
        });
    }
}
