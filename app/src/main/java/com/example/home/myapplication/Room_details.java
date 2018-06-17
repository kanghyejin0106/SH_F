package com.example.home.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import android.support.v7.app.AppCompatActivity;


public class Room_details extends Activity implements View.OnTouchListener {

    private ViewFlipper flipper;
    float xAtDown;
    float xAtUp;
    int count = 0;
    private TextView owner;
    private TextView money;
    String id_senior="";
    String id_student="";
    DatabaseReference table;
    DatabaseReference tableQuestion;
    Button applyBtn;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);
        owner = (TextView)findViewById(R.id.owner);
        money = (TextView)findViewById(R.id.money);
        applyBtn=(Button)findViewById(R.id.apply);
        ImageView smoking = (ImageView)findViewById(R.id.smoking);
        ImageView drinking = (ImageView)findViewById(R.id.drinking);
        ImageView pet = (ImageView)findViewById(R.id.pet);
        ImageView weed = (ImageView)findViewById(R.id.weed);
        ImageView religion = (ImageView)findViewById(R.id.religion);
        Intent intent=new Intent(this.getIntent());
        id_senior=intent.getExtras().getString("ID_senior");
        id_student=intent.getExtras().getString("ID_student");

        applyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent second3=new Intent(getApplicationContext(),Second3.class);
                second3.putExtra("ID_senior",id_senior);
                second3.putExtra("ID_student",id_student);
                startActivity(second3);
            }
        });
        String text = "OWNER : " + id_senior;
        owner.setText(text);

        String text2 = "Monthly Rent : " + "money";
        money.setText(text2);
        initDB();
        flipper = (ViewFlipper)findViewById(R.id.viewFlipper1);
        flipper.setOnTouchListener(this);
    }
    public void initDB() {
        table = FirebaseDatabase.getInstance().getReference("Room");
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    if (data.getKey().toString().equals(id_senior)) {
                        Toast.makeText(getApplicationContext(), id_senior, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), id_student, Toast.LENGTH_LONG).show();
                        if (data.hasChild("roommoney")) {
                            String text = "Monthly Rent : " + data.child("roommoney").getValue().toString();
                            money.setText(text);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        tableQuestion = FirebaseDatabase.getInstance().getReference("senior");
        tableQuestion.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    if (data.getKey().toString().equals(id_senior)) {
                        if (data.hasChild("seniorQ")) {
                            String alcohol = (data.child("seniorQ").child("alcohol").getValue().toString());
                            String pet = (data.child("seniorQ").child("q_pet").getValue().toString());
                            String religion = (data.child("seniorQ").child("q_religion").getValue().toString());
                            String smoke = (data.child("seniorQ").child("smoke").getValue().toString());
                            String weed = (data.child("seniorQ").child("weed").getValue().toString());
                        Toast.makeText(getApplicationContext(), alcohol, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), smoke, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), weed, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), pet, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), religion, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if( v != flipper) return false;
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            xAtDown=event.getX();
        } else if(event.getAction() == MotionEvent.ACTION_UP) {
            xAtUp = event.getX();
            if(xAtDown > xAtUp) {
                flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.left_in));
                flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.left_out));
                count++;

                if(count < 4)
                    flipper.showNext();
                else {
                    Toast.makeText(this, "Final Photo", Toast.LENGTH_SHORT).show();
                    count--;
                }
            }
            else if(xAtDown < xAtUp) {
                flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.right_in));
                flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.right_out));
                count--;
                if(count > -1)
                    flipper.showPrevious();
                else {
                    Toast.makeText(this, "First Photo", Toast.LENGTH_SHORT).show();
                    count++;
                }
            }
        }

        return true;
    }
}