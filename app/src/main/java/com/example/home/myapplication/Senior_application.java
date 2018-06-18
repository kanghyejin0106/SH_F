package com.example.home.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    ArrayList<User> items = new ArrayList<User>();
    String id = "";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_application);
        listView = (ListView)findViewById(R.id.list_app2) ;
        adapter = new SingleAdapter();
        id = getIntent().getExtras().getString("ID");
        initDB();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Room item = (Room)adapter.getItem(position);
                //Toast.makeText(getApplicationContext(),"선택: "+item.getroomname(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void initDB(){

        table = FirebaseDatabase.getInstance().getReference("senior");
        String studentid = table.child(id).child("request").getKey();
        table = FirebaseDatabase.getInstance().getReference("student").child(studentid);

        User user = new User(studentid, table.child("PW").getKey(),table.child("Name").getKey(),table.child("Phone").getKey(),parseInt(table.child("Gender").getKey()));
        adapter.addItem(user);
        listView.setAdapter(adapter);

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