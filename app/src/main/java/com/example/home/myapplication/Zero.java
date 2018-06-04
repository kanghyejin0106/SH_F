package com.example.home.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.MotionEvent;
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
    boolean status = true;
    Button female;
    Button male;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitDiskReads().permitDiskWrites().permitNetwork().build());

        table = FirebaseDatabase.getInstance().getReference("student");


        final boolean Status[]={true, false};

        female = (Button)findViewById(R.id.Female);
        male = (Button)findViewById(R.id.Male);

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

<<<<<<< HEAD
=======


        //text = (TextView)findViewById(R.id.texttext);





>>>>>>> 1cb0a4c4633025e9c6b83674435380e3005d472e
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
                table.child("dsa").setValue("dafdsf");
                regiUser();

//                Messenger messenger = new Messenger(getApplicationContext());
 //               messenger.sendMessageTo(phone.getText().toString());

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
                    gMailSender.sendMail("ddd","ddd",email_s);
                    Toast.makeText(getApplicationContext(), "확인코드를 입력해주세요", Toast.LENGTH_SHORT).show();

//                    Messenger messenger = new Messenger(getApplicationContext());
//                   messenger.sendMessageTo(phone_s);
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

/*    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    } */
}