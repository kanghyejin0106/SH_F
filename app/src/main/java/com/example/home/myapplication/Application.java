package com.example.home.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class Application extends AppCompatActivity {
    SingleAdapter adapter;

    ListView listView;
    DatabaseReference table;
    ArrayList<Room> items = new ArrayList<Room>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        listView = (ListView)findViewById(R.id.list_app) ;
        adapter = new SingleAdapter();
        initDB();
        //adapter = new SingerAdapter();
//        adapter.addItem(new Room("aa","dd","ee"));
//        adapter.addItem(new Room("bb","ee","ee"));
//        adapter.addItem(new Room("cc","rr","ee"));

        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Room item = (Room)adapter.getItem(position);
                //Toast.makeText(getApplicationContext(),"선택: "+item.getroomname(),Toast.LENGTH_SHORT).show();
            }
        });

        Button btn = (Button)findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void initDB(){

        table = FirebaseDatabase.getInstance().getReference("Room");
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    if(data.hasChild("img1FilePath")){
                        Toast.makeText(getApplicationContext(),data.child("roomMoney").getValue().toString(),Toast.LENGTH_LONG).show();
                        Room room = new Room(data.child("roomname").getValue().toString(),data.child("roomlocate").getValue().toString(),
                                data.child("roomMoney").getValue().toString(),
                                data.child("img1FilePath").getValue().toString(),data.child("img2FilePath").getValue().toString(),
                                data.child("img3FilePath").getValue().toString(),data.child("img4FilePath").getValue().toString());
                        adapter.addItem(room);

                        //adapter.addItem(new Room("aa","dd","ee"));
                        listView.setAdapter(adapter);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_LONG).show();
                    }

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //listView.setAdapter(adapter);
    }

    class SingleAdapter extends BaseAdapter {

        //ArrayList<Room> items = new ArrayList<Room>();
        @Override
        public int getCount() {
            return items.size();
        }
        public void addItem (Room item){
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
            Room item = items.get(position);
            itemView.setName(item.getroomname());
            itemView.setlocate(item.getroomlocate());
            itemView.setmoney(item.getroommoney());
            itemView.setImageView(Uri.parse(item.getImg1FilePath()));
            return itemView;
        }
    }

}
