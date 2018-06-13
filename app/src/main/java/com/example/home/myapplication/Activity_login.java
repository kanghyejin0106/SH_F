package com.example.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity_login extends AppCompatActivity {
    DatabaseReference table;
    String id;
    String pw;
    Button login;
    Button loginJoin;
    String correctpw = null;
    String check;
    EditText idText;
    EditText pwText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        Intent new_intent = getIntent();
        check = new_intent.getStringExtra("type");
        if(check.equals("1")){
           setContentView(R.layout.activity_login);
            table = FirebaseDatabase.getInstance().getReference("student");
            login = (Button)findViewById(R.id.login);
            loginJoin = (Button)findViewById(R.id.loginJoin);
            idText = (EditText)findViewById(R.id.loginID);
            pwText = (EditText)findViewById(R.id.loginPW);
        }
        else if(check.equals("2")){
            setContentView(R.layout.senior_login);
            table = FirebaseDatabase.getInstance().getReference("senior");
            login = (Button)findViewById(R.id.login_s);
            loginJoin = (Button)findViewById(R.id.loginJoin_s);
            idText = (EditText)findViewById(R.id.loginID_s);
            pwText = (EditText)findViewById(R.id.loginPW_s);
        }

        loginJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent join = new Intent(Activity_login.this,Zero.class);
                join.putExtra("check",check);
                startActivity(join);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id=idText.getText().toString();
                pw=pwText.getText().toString();
                id = EncodeString(id);

                table.child(id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        correctpw = dataSnapshot.child("userPW").getValue().toString();
                        if(pw.equals(correctpw)){
                            Toast.makeText(getApplicationContext(),"Log in.",Toast.LENGTH_SHORT).show();
                            if(check.equals("1")){
                                Intent new_page = new Intent(Activity_login.this,MainActivity.class);
                                new_page.putExtra("ID",id);
                                new_page.putExtra("userID",id);
                                startActivity(new_page);
                            }
                            else{
                                Intent new_page = new Intent(Activity_login.this,senior_main.class);
                                new_page.putExtra("ID",id);
                                startActivity(new_page);
                            }

                        }else{
                            Toast.makeText(getApplicationContext(),"Try again.",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });

    }
    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }
}
