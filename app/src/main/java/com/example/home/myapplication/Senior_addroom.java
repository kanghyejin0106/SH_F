package com.example.home.myapplication;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Senior_addroom extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_addroom);

        Button button = (Button)findViewById(R.id.add_room);
        button.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v){
        AlertDialog.Builder add = new AlertDialog.Builder(this);
        add.setMessage("방값책정+사진등록+구비물품");
        add.setPositiveButton("등록",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_PICK);

                        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");

                        startActivityForResult(intent, 4);
                    }
                });
        add.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        add.setNegativeButton("Close",null);
        add.show();
    }
/*
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Uri selPhotoUri = imageReturnedIntent.getData();
        ContentResolver cr;
        try {
            cr = this.getContentResolver();

            Bitmap bitmap = MediaStore.Images.Media.getBitmap(cr, selPhotoUri);
        } catch (IOException e) {

        }

        String urlString = urlPath.getImgPath();

        Cursor c = this.getContentResolver().query(Uri.parse(selPhotoUri.toString()), null, null, null, null);
        c.moveToNext();
        String absolutePath = c.getString(c.getColumnIndex(MediaStore.MediaColumns.DATA));

        DoFileUpload(urlString,absolutePath);
    }
    */
}



