package com.example.home.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Application extends AppCompatActivity {
    SingerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        ListView listView;
        listView = (ListView)findViewById(R.id.list_app) ;
        adapter = new SingerAdapter();
        adapter.addItem(new Room("aa","dd","ee"));
        adapter.addItem(new Room("bb","ee","ee"));
        adapter.addItem(new Room("cc","rr","ee"));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Room item = (Room)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택: "+item.getRoomname(),Toast.LENGTH_SHORT).show();
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
    class SingerAdapter extends BaseAdapter {

        ArrayList<Room> items = new ArrayList<Room>();
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
            roomView itemView = new roomView(getApplicationContext());///////
            Room item = items.get(position);
            itemView.setName(item.getRoomname());
            itemView.setlocate(item.getRoomlocate());
            itemView.setmoney(item.getRoommoney());
            return itemView;
        }
    }
}
