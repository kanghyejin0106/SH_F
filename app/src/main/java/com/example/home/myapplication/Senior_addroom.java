package com.example.home.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class Senior_addroom extends AppCompatActivity {

    private Button btn;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    Button buttonnext;
    private ImageView imageview;
    private ImageView imageview2;
    private ImageView imageview3;
    private ImageView imageview4;
    private EditText editText;
    private String img1Path;
    private String img2Path;
    private String img3Path;
    private String img4Path;
    int num = 0;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    final int GALLERY = 1, CAMERA = 2;
    FirebaseStorage storage;
    StorageReference storageReference;
    String SeniorID;
    DatabaseReference table;
    String money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_addroom);
        Intent intent=getIntent();
        SeniorID=intent.getStringExtra("ID");


        btn = (Button) findViewById(R.id.add_bedroom);
        imageview = (ImageView) findViewById(R.id.iv_bedroom);
        btn2 = (Button) findViewById(R.id.add_livingroom);
        imageview2 = (ImageView) findViewById(R.id.iv_livingroom);
        btn3 = (Button) findViewById(R.id.add_kitchen);
        imageview3 = (ImageView) findViewById(R.id.iv_kitchen);
        btn4 = (Button) findViewById(R.id.add_bathroom);
        imageview4 = (ImageView) findViewById(R.id.iv_bathroom);
        buttonnext = (Button) findViewById(R.id.btn_next);
        editText=(EditText)findViewById(R.id.roomprice);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 1;
                showPictureDialog();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 2;
                showPictureDialog();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 3;
                showPictureDialog();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 4;
                showPictureDialog();
            }
        });
        money=editText.getText().toString();
        buttonnext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                money=editText.getText().toString();
                regRoom();
                editText.setText("");
                Intent intent = new Intent(Senior_addroom.this, Senior_question1.class);
                intent.putExtra("phone",SeniorID);
                startActivity(intent);
            }
        });
    }
    public void regRoom(){
        Intent intent=getIntent();
        Toast.makeText(getApplication(),money,Toast.LENGTH_SHORT).show();
        table=FirebaseDatabase.getInstance().getReference("Room").child(SeniorID);
        table.child("roomMoney").setValue(money);
        table.child("img1FilePath").setValue(img1Path);
        table.child("img2FilePath").setValue(img2Path);
        table.child("img3FilePath").setValue(img3Path);
        table.child("img4FilePath").setValue(img4Path);
    }

    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }
    boolean checkAppPermission(String[] requestPermission){
        boolean[] requestResult= new boolean[requestPermission.length];
        for(int i=0; i< requestResult.length; i++){
            requestResult[i] = (ContextCompat.checkSelfPermission(this,
                    requestPermission[i]) == PackageManager.PERMISSION_GRANTED);
            if(!requestResult[i])
            {
                return false;
            }
        }
        return true;
    }
    void askPermission(String[] requestPermission, int REQ_PERMISSION) {
        ActivityCompat.requestPermissions(this,requestPermission,
                REQ_PERMISSION);
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case GALLERY:
                if(checkAppPermission(permissions)){
                    Intent intent=new Intent(Intent.ACTION_PICK);
                    intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                    intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent,GALLERY);
                }
                else{
                    finish();
                }
                break;
        }
    }

    public void choosePhotoFromGallary() {

        if(checkAppPermission(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE})){
            Intent intent=new Intent(Intent.ACTION_PICK);
            intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,GALLERY);
        }
        else{
            askPermission(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    GALLERY);
        }
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        storage= FirebaseStorage.getInstance();
        storageReference=storage.getReference();
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    Toast.makeText(Senior_addroom.this, "Image Saved!", Toast.LENGTH_SHORT).show();

                    String path = saveImage(bitmap);

                    switch (num){
                        case 1:
                            imageview.setImageBitmap(bitmap);
                            break;
                        case 2:
                            imageview2.setImageBitmap(bitmap);
                            break;
                        case 3:
                            imageview3.setImageBitmap(bitmap);
                            break;
                        case 4:
                            imageview4.setImageBitmap(bitmap);
                            break;
                    }
                    uploadImage(contentURI);
                    Toast.makeText(Senior_addroom.this,contentURI.toString(),Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(Senior_addroom.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            Uri cameraUri=null;
            switch (num){
                case 1:
                    imageview.setImageBitmap(thumbnail);
                    break;
                case 2:
                    imageview2.setImageBitmap(thumbnail);
                    break;
                case 3:
                    imageview3.setImageBitmap(thumbnail);
                    break;
                case 4:
                    imageview4.setImageBitmap(thumbnail);
                    break;
            }
            String str= saveImage(thumbnail);
            //CameraUri=Uri.fromFile(getFileStreamPath(f.toString()));
            File f=new File(str);
            cameraUri=Uri.fromFile(f);
            uploadImage(cameraUri);
            Toast.makeText(Senior_addroom.this, "Image Saved!", Toast.LENGTH_SHORT).show();
        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();

            Log.d("TAG", "File Saved::—>" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
    private void uploadImage(Uri filePath) {

        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            final StorageReference ref = storageReference.child("images/").child(SeniorID).child(filePath.getLastPathSegment());
            UploadTask uploadTask = ref.putFile(filePath);

            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            if(num==1){
                                ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        img1Path=uri.toString();
                                    }
                                });
                            }
                            else if(num==2){
                                ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        img2Path=uri.toString();
                                    }
                                });
                            }
                            else if(num==3){
                                ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        img3Path=uri.toString();
                                    }
                                });
                            }
                            else if(num==4){
                                ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        img4Path=uri.toString();
                                    }
                                });
                            }
                            Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }

}