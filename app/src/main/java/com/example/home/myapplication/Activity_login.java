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
    String correctpw = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        table = FirebaseDatabase.getInstance().getReference("student");

        Button login = (Button)findViewById(R.id.login);
        Button loginJoin = (Button)findViewById(R.id.loginJoin);
        loginJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent join = new Intent(Activity_login.this,Zero.class);
                startActivity(join);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText idText = (EditText)findViewById(R.id.loginID);
                EditText pwText = (EditText)findViewById(R.id.loginPW);
                id=idText.getText().toString();
                pw=pwText.getText().toString();
                id = EncodeString(id);

                table.child(id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        correctpw = dataSnapshot.child("userPW").getValue().toString();
                        if(pw.equals(correctpw)){
                            Toast.makeText(getApplicationContext(),"로그인 되었습니다.",Toast.LENGTH_SHORT).show();
                            Intent new_page = new Intent(Activity_login.this,MainActivity.class);
                            new_page.putExtra("ID",id);
                            new_page.putExtra("userID",id);
                            startActivity(new_page);
                        }else{
                            Toast.makeText(getApplicationContext(),"다시 입력해 주세요.",Toast.LENGTH_SHORT).show();
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
