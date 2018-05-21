package com.example.home.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

public class Zero extends AppCompatActivity {
    String name_s, pw_s, phone_s,email_s;
    EditText name, pw, phone,email;
    TextView text;
    boolean status = true;
    Button female;
    Button male;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitDiskReads().permitDiskWrites().permitNetwork().build());

        final boolean Status[]={true, false};

        female = (Button)findViewById(R.id.Female);
        male = (Button)findViewById(R.id.Male);
        /*

        female.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        female.setBackgroundColor(R.color.Clicked);
                        //male.setBackgroundColor(R.color.Male);
                        v.setPressed(true);
                        }
                    case MotionEvent.ACTION_UP:{
                        female.setBackgroundColor(R.color.Female);
                        //male.setBackgroundColor(R.color.Clicked);
                        v.setPressed(false);
                        break;}
                }
                return false;
            }
        });

        male.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        male.setBackgroundColor(R.color.Clicked);
                        //female.setBackgroundColor(R.color.Female);
                        v.setPressed(true);
                        break;}
                    case MotionEvent.ACTION_UP:{
                        //female.setBackgroundColor(R.color.Clicked);
                        male.setBackgroundColor(R.color.Male);
                        v.setPressed(false);
                        break;}
                }
                return false;
            }
        });*/


        female.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                status = true;
                if(status==true) {
                    female.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.Clicked));
                    female.setTextColor(getApplicationContext().getResources().getColor(R.color.White));
                    male.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.Male));
                    male.setTextColor(getApplicationContext().getResources().getColor(R.color.Black));
                }
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = false;
                if(status==false) {
                    male.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.Clicked));
                    male.setTextColor(getApplicationContext().getResources().getColor(R.color.White));
                    female.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.Male));
                    female.setTextColor(getApplicationContext().getResources().getColor(R.color.Black));
                }
            }
        });

        name = (EditText)findViewById(R.id.Name);

        pw = (EditText)findViewById(R.id.Password);
        phone = (EditText)findViewById(R.id.Phone);

        email = (EditText)findViewById(R.id.Email);

        text = (TextView)findViewById(R.id.txt_Join);


        name_s = name.getText().toString();
        pw_s = pw.getText().toString();
        phone_s = phone.getText().toString();
        email_s = email.getText().toString();

        Button btn = (Button)findViewById(R.id.btn_Submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    GMailSender gMailSender = new GMailSender("shp.shouse@gmail.com","tksguqvm1!");
                    gMailSender.sendMail("ddd","ddd",email.getText().toString());
                    Toast.makeText(getApplicationContext(), "확인코드를 입력해주세요", Toast.LENGTH_SHORT).show();
                }catch (SendFailedException e){

                }catch(MessagingException e){

                }catch (Exception e){
                    e.printStackTrace();
                }

                Intent intent = new Intent(Zero.this, First.class);
                startActivity(intent);
            }
        });


    }

}