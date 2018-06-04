package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            startActivity(new Intent(this,Intro.class));
            finish();
        }
    }
