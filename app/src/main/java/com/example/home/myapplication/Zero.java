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
    String str;
    DatabaseReference table;
    String name_s, pw_s, phone_s,email_s;
    EditText name, pw, phone,email;
    TextView text;
    boolean status = true;
    Button female;
    Button male;
    String check;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitDiskReads().permitDiskWrites().permitNetwork().build());
        Intent new_intent = getIntent();
        check = new_intent.getStringExtra("check");
        if(check.equals("1")){
            setContentView(R.layout.activity_zero);
            table = FirebaseDatabase.getInstance().getReference("student");
            female = (Button)findViewById(R.id.Female);
            male = (Button)findViewById(R.id.Male);
            name = (EditText)findViewById(R.id.Name);
            pw = (EditText)findViewById(R.id.Password);
            phone = (EditText)findViewById(R.id.Phone);
            email = (EditText)findViewById(R.id.Email);
            btn = (Button)findViewById(R.id.btn_Submit);
        }
        else if(check.equals("2")){
            setContentView(R.layout.senior_zero);
            table = FirebaseDatabase.getInstance().getReference("senior");
            female = (Button)findViewById(R.id.Female_s);
            male = (Button)findViewById(R.id.Male_s);
            name = (EditText)findViewById(R.id.Name_s);
            pw = (EditText)findViewById(R.id.Password_s);
            phone = (EditText)findViewById(R.id.Phone_s);
            email = (EditText)findViewById(R.id.Email_s);
            btn = (Button)findViewById(R.id.btn_Submit_s);
        }


        final boolean Status[]={true, false};

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


        name_s = name.getText().toString();
        pw_s = pw.getText().toString();
        phone_s = phone.getText().toString();
        email_s = email.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_s = email.getText().toString();
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

//                   Messenger messenger = new Messenger(getApplicationContext());
//                   messenger.sendMessageTo(phone_s);
                }catch (SendFailedException e){

                    Toast.makeText(getApplicationContext(), "이메일 확인해주세요1 "+email_s, Toast.LENGTH_SHORT).show();
                }catch(MessagingException e){
                    Toast.makeText(getApplicationContext(), "이메일 확인해주세요2 "+email_s, Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "이메일 확인해주세요3 "+email_s, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        });


    }
    public void regiUser(){
        //DB
        if(check.equals("1")){
            table = FirebaseDatabase.getInstance().getReference("student");
        }else{
            table = FirebaseDatabase.getInstance().getReference("senior");
        }

        str=EncodeString(email.getText().toString());
        User newUser = new User(str,pw.getText().toString(),name.getText().toString(),phone.getText().toString(),status,0,0,null);
        table.child(str).setValue(newUser);

        Intent intent = new Intent(Zero.this, First.class);
        intent.putExtra("email",str);
        startActivity(intent);

        email.setText("");
        pw.setText("");
        name.setText("");
        phone.setText("");
        status=true;
    }
    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }

/*    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    } */
}