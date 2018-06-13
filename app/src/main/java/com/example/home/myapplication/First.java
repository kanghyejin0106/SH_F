package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class First extends AppCompatActivity{
    DatabaseReference table;
    String email=null;
    String phone=null;
    String getCheck;
    EditText code;
    String right_code;
    String student_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitDiskReads().permitDiskWrites().permitNetwork().build());

        table = FirebaseDatabase.getInstance().getReference("student");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Intent in =this.getIntent();
        email = in.getExtras().getString("email");
        right_code = in.getExtras().getString("code");
        code = (EditText)findViewById(R.id.editText);

        TextView text = (TextView) findViewById(R.id.text2);


        //Intent intent = getIntent();

        Button btn2 = (Button)findViewById(R.id.btn_Confirm);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                student_code=code.getText().toString();

                if(student_code.equals(right_code)){
                    Intent intent = new Intent(First.this, Question.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Try again.",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}

