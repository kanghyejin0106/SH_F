package com.example.home.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;


public class Room_details extends Activity implements View.OnTouchListener {

    private ViewFlipper flipper;
    float xAtDown;
    float xAtUp;
    int count = 0;
    private TextView owner;
    private TextView money;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        owner = (TextView)findViewById(R.id.owner);
        money = (TextView)findViewById(R.id.money);

        ImageView smoking = (ImageView)findViewById(R.id.smoking);
        ImageView drinking = (ImageView)findViewById(R.id.drinking);
        ImageView pet = (ImageView)findViewById(R.id.pet);
        ImageView weed = (ImageView)findViewById(R.id.weed);
        ImageView religion = (ImageView)findViewById(R.id.religion);

        /*

        To use database

         */

        String text = "OWNER : " + "name";
        owner.setText(text);

        String text2 = "Monthly Rent : " + "money";
        money.setText(text2);

        flipper = (ViewFlipper)findViewById(R.id.viewFlipper1);
        flipper.setOnTouchListener(this);
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
