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

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

public class Zero extends AppCompatActivity {
    String name_s, pw_s, phone_s,email_s;
    EditText name, pw, phone,email;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitDiskReads().permitDiskWrites().permitNetwork().build());


        name = (EditText)findViewById(R.id.Name);

        pw = (EditText)findViewById(R.id.Password);
        phone = (EditText)findViewById(R.id.Phone);

<<<<<<< HEAD
        //text = (TextView)findViewById(R.id.texttext);
=======
        email = (EditText)findViewById(R.id.Email);

>>>>>>> 8410f9a61fafe54c8a7b4a613878c6fadc626c1c
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
                intent.putExtra("Userid",name_s);
                intent.putExtra("Userpw",pw_s);
                intent.putExtra("Userph",phone_s);
                startActivity(intent);
            }
        });


    }

}