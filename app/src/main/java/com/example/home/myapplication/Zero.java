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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

public class Zero extends AppCompatActivity {
    DatabaseReference table;
    String name_s, pw_s, phone_s,email_s;
    EditText name, pw, phone,email;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitDiskReads().permitDiskWrites().permitNetwork().build());
        table = FirebaseDatabase.getInstance().getReference("student");

        name = (EditText)findViewById(R.id.Name);

        pw = (EditText)findViewById(R.id.Password);
        phone = (EditText)findViewById(R.id.Phone);

        email = (EditText)findViewById(R.id.Email);
        //email_Encode=EncodeString(email.getText().toString());
        text = (TextView)findViewById(R.id.txt_Join);


        name_s = name.getText().toString();
        pw_s = pw.getText().toString();
        phone_s = phone.getText().toString();
        email_s = email.getText().toString();

        Button btn = (Button)findViewById(R.id.btn_Submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table.child("dsa").setValue("dafdsf");
                regiUser();
                table.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
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
    public void regiUser(){
        //DB
        table = FirebaseDatabase.getInstance().getReference("student");
        String str=EncodeString(email.getText().toString());
        User newUser = new User(str,pw.getText().toString());
        table.child(str).setValue(newUser);
        email.setText("");
        pw.setText("");
    }
    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }
}