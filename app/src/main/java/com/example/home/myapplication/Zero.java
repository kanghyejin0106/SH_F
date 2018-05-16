package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Zero extends AppCompatActivity {
    String id_s, pw_s, phone_s;
    EditText id, pw, phone;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);
    }

    public void SignUp(View view) {

        id = (EditText)findViewById(R.id.ID);
        pw = (EditText)findViewById(R.id.Password);
        phone = (EditText)findViewById(R.id.Phone);

        text = (TextView)findViewById(R.id.txt_Join);

        id_s = id.getText().toString();
        pw_s = pw.getText().toString();
        phone_s = phone.getText().toString();

        Button btn = (Button)findViewById(R.id.btn_Submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        Intent intent = new Intent(this, First.class);
        intent.putExtra("Userid",id_s);
        intent.putExtra("Userpw",pw_s);
        intent.putExtra("Userph",phone_s);
        startActivity(intent);

    }
}