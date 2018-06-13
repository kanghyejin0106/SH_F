package com.example.home.myapplication;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by USER on 2018-06-04.
 */

public class roomView extends LinearLayout {
    TextView textView;
    TextView textView1;
    TextView textView2;
    ImageView imageView;
    public roomView(Context context) {
        super(context);
        init(context);
    }
    public roomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_list,this,true);

        textView = (TextView)findViewById(R.id.textView2);
        textView1 = (TextView)findViewById(R.id.textView3);
        textView2 = (TextView)findViewById(R.id.textView4);
        imageView=(ImageView)findViewById(R.id.imageView2);
    }

    public void setName(String name){
        textView.setText(name);
    }
    public void setlocate(String locate){
        textView1.setText(locate);
    }
    public void setmoney(String money){
        textView2.setText(money);
    }
    public void setImageView(Uri uri){
        imageView.setImageURI(uri);
    }
}
