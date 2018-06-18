package com.example.home.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

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
    DatabaseReference tableImg;
    Button applyBtn;
    ImageView flipper1, flipper2, flipper3, flipper4;
    String img1,img2,img3,img4;
    String alcohol="";
    String pet2="";
    String religion2="" ;
    String smoke="" ;
    String weed2="" ;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);
        owner = (TextView)findViewById(R.id.owner);
        money = (TextView)findViewById(R.id.money);
        applyBtn=(Button)findViewById(R.id.apply);
//        flipper1 = (ImageView)findViewById(R.id.flipper1);
        ImageView smoking = (ImageView)findViewById(R.id.smoking);
        ImageView drinking = (ImageView)findViewById(R.id.drinking);
        ImageView pet = (ImageView)findViewById(R.id.pet);
        ImageView weed = (ImageView)findViewById(R.id.weed);
        ImageView religion = (ImageView)findViewById(R.id.religion);
        Intent intent=new Intent(this.getIntent());
        id_senior=intent.getExtras().getString("ID_senior");
        id_student=intent.getExtras().getString("ID_student");

        flipper1 = (ImageView)findViewById(R.id.flipper1);
        flipper2 = (ImageView)findViewById(R.id.flipper2);
        flipper3 = (ImageView)findViewById(R.id.flipper3);
        flipper4 = (ImageView)findViewById(R.id.flipper4);

        tableImg = FirebaseDatabase.getInstance().getReference("Room");
        tableImg.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    if (data.getKey().toString().equals(id_senior)) {
                        if (data.hasChild("img1FilePath")) {
                            img1= data.child("img1FilePath").getValue().toString();
                            //Toast.makeText(getApplicationContext(),img1,Toast.LENGTH_LONG).show();
                            //flipper1.setImageURI(Uri.parse(img1));
                            Glide.with(getApplicationContext()).load(Uri.parse(img1)).into(flipper1);

                        }
                        if (data.hasChild("img2FilePath")) {
                            img2= data.child("img2FilePath").getValue().toString();
                            //flipper2.setImageURI(Uri.parse(img2));
                            Glide.with(getApplicationContext()).load(Uri.parse(img2)).into(flipper2);
                        }
                        if (data.hasChild("img3FilePath")) {
                            img3= data.child("img3FilePath").getValue().toString();
                            //flipper3.setImageURI(Uri.parse(img3));
                            Glide.with(getApplicationContext()).load(Uri.parse(img3)).into(flipper3);
                        }
                        if (data.hasChild("img4FilePath")) {
                            img4= data.child("img4FilePath").getValue().toString();
                            //flipper4.setImageURI(Uri.parse(img4));
                            Glide.with(getApplicationContext()).load(Uri.parse(img4)).into(flipper4);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(Room_details.this);
                builder.setTitle("신청");
                builder.setMessage("신청하시겠습니까?");
                builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                builder.setPositiveButton("no",null);
                builder.create();
                builder.show();
                table = FirebaseDatabase.getInstance().getReference("senior"); ////////////////
                table.child(id_senior).child("request").setValue(id_student);

            }
        });
        String text = "OWNER : " + id_senior;
        owner.setText(text);

        String text2 = "Monthly Rent : " + "money";
        money.setText(text2);
        initDB();
        flipper = (ViewFlipper)findViewById(R.id.viewFlipper1);
        flipper.setOnTouchListener(this);

        if (alcohol.equals("4")) {
            drinking.setImageResource(R.drawable.drink);
        }else{
            drinking.setImageResource(R.drawable.ban_drink);
        }
        if(pet2.equals("4")){
            pet.setImageResource(R.drawable.pet);
        }else{
            pet.setImageResource(R.drawable.ban_pet);
        }
        if(smoke.equals("4")){
            smoking.setImageResource(R.drawable.ban_smoke);
        }else {
            smoking.setImageResource(R.drawable.smoke);
        }
        if(weed2.equals("4")){
            weed.setImageResource(R.drawable.ban_marifana);
        }else {
            weed.setImageResource(R.drawable.marifana);
        }
        if(religion2.equals("1")){
            religion.setImageResource(R.drawable.catholic);
        }else if(religion2.equals("2")){
            religion.setImageResource(R.drawable.pagoda);
        }else if(religion2.equals("5")){
            religion.setImageResource(R.drawable.ban_religion);
        }else {
            religion.setImageResource(R.drawable.mosque);
        }


    }

    public void initDB() {
        table = FirebaseDatabase.getInstance().getReference("Room");
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    if (data.getKey().toString().equals(id_senior)) {
                       // Toast.makeText(getApplicationContext(), id_senior, Toast.LENGTH_LONG).show();
                       // Toast.makeText(getApplicationContext(), id_student, Toast.LENGTH_LONG).show();
                        if (data.hasChild("roomMoney")) {
                            String text = "Monthly Rent : " + data.child("roomMoney").getValue().toString();
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
                            alcohol = (data.child("seniorQ").child("alcohol").getValue().toString());
                            pet2 = (data.child("seniorQ").child("q_pet").getValue().toString());
                            religion2 = (data.child("seniorQ").child("q_religion").getValue().toString());
                            smoke = (data.child("seniorQ").child("smoke").getValue().toString());
                            weed2 = (data.child("seniorQ").child("weed").getValue().toString());
                          //  Toast.makeText(getApplicationContext(), alcohol, Toast.LENGTH_LONG).show();
                          //  Toast.makeText(getApplicationContext(), smoke, Toast.LENGTH_LONG).show();
                          //  Toast.makeText(getApplicationContext(), weed2, Toast.LENGTH_LONG).show();
                          //  Toast.makeText(getApplicationContext(), pet2, Toast.LENGTH_LONG).show();
                          //  Toast.makeText(getApplicationContext(), religion2, Toast.LENGTH_LONG).show();

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
        //table=FirebaseDatabase.getInstance().getReference("senior").child(id_senior);


//        Glide.with(getApplicationContext()).load(Uri.parse(img1)).into(flipper1);
 //       Glide.with(getApplicationContext()).load(Uri.parse(img2)).into(flipper2);
 //       Glide.with(getApplicationContext()).load(Uri.parse(img3)).into(flipper3);
  //      Glide.with(getApplicationContext()).load(Uri.parse(img4)).into(flipper4);
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