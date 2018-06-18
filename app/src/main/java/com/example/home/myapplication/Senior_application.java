package com.example.home.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Senior_application extends AppCompatActivity {
    SingleAdapter adapter;
    ListView listView;
    DatabaseReference table;
    DatabaseReference tableStudent;
    ArrayList<User> items = new ArrayList<User>();
    String id = "";
    String idGetFromRequest="";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_application);
        listView = (ListView)findViewById(R.id.list_app2) ;
        adapter = new SingleAdapter();
        id = getIntent().getExtras().getString("ID");
        initDB();
        table = FirebaseDatabase.getInstance().getReference("student");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final User item = (User)adapter.getItem(position);
                //Toast.makeText(getApplicationContext(),"선택: "+item.getUserID(),Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder( Senior_application.this);
                builder.setTitle("수락");
                builder.setMessage("수락하시겠습니까?");
                builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        table.child(item.getUserID()).child("permission").setValue("y");
                        finish();
                    }
                });

                builder.setPositiveButton("no",null);
                builder.create();
                builder.show();
            }
        });

    }
    public void initDB(){
        table = FirebaseDatabase.getInstance().getReference("senior");
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    if (data.getKey().toString().equals(id)) {
                        if(data.hasChild("request")){
                            idGetFromRequest=data.child("request").getValue().toString();
                        //    Toast.makeText(getApplicationContext(),idGetFromRequest,Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        tableStudent = FirebaseDatabase.getInstance().getReference("student");
        tableStudent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    if (data.getKey().toString().equals(idGetFromRequest)) {
                       // Toast.makeText(getApplicationContext(),idGetFromRequest,Toast.LENGTH_LONG).show();
                            User user = new User(idGetFromRequest, data.child("userPW").getValue().toString(),
                                    data.child("name").getValue().toString(),
                                    data.child("phone").getValue().toString(),
                                    Integer.parseInt(data.child("gender").getValue().toString()));
                            adapter.addItem(user);

                            //adapter.addItem(new Room("aa","dd","ee"));
                            listView.setAdapter(adapter);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //String studentid = table.child(id).child("request").get.toString();
//        table = FirebaseDatabase.getInstance().getReference("student").child(studentid);
//        Toast.makeText(getApplicationContext(),studentid,Toast.LENGTH_LONG).show();
        //User user = new User(studentid, table.child("userPW").getKey().toString(),table.child("name").getKey().toString()
        //        ,table.child("phone").getKey().toString(),parseInt(table.child("gender").getKey().toString()));
        //adapter.addItem(user);
        //listView.setAdapter(adapter);


    }
    class SingleAdapter extends BaseAdapter {
        //ArrayList<Room> items = new ArrayList<Room>();
        @Override
        public int getCount() {
            return items.size();
        }
        public void addItem (User item){
            items.add(item);
        }
        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            roomView itemView = new roomView(getApplicationContext());
            User item = items.get(position);
            itemView.setName(item.getName());
            itemView.setlocate(item.getPhone());
            itemView.setmoney(item.getUserID());
            return itemView;
        }
    }

}