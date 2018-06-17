package com.example.home.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class list extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public String address="";;

    ListView listView;
    SingerAdapter adapter;
    DatabaseReference table;
    ArrayList<Room> items = new ArrayList<Room>();
    private OnFragmentInteractionListener mListener;

    public list() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static list newInstance(String param1, String param2) {
        list fragment = new list();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //adapter.addItem(new Room("aa","dd","ee"));
        //initDB();
        //listView.setAdapter(adapter);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView)v.findViewById(R.id.list_room) ;


        initDB();

        //주소바꾸기
        //adapter = new SingerAdapter();
        //adapter.addItem(new Room("bb","ee","ee"));
        //adapter.addItem(new Room("cc","rr","ee"));
        //listView.setAdapter(adapter);

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Room item = (Room)adapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(),"선택: "+item.getroomname(),Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getActivity(), Room_details.class);
//                intent.putExtra("aa,")
                startActivity(intent);

            }
        });
        */
        return v;
    }
    public void initDB(){
        adapter = new SingerAdapter();
        table = FirebaseDatabase.getInstance().getReference("Room");
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    if(data.hasChild("img1FilePath")){
                        Toast.makeText(getActivity().getApplicationContext(),data.child("roommoney").getValue().toString(),Toast.LENGTH_LONG).show();
                        Room room = new Room(data.child("roomname").getValue().toString(),data.child("roomlocate").getValue().toString(),
                                data.child("roommoney").getValue().toString(),
                                data.child("img1FilePath").getValue().toString(),data.child("img2FilePath").getValue().toString(),
                                data.child("img3FilePath").getValue().toString(),data.child("img4FilePath").getValue().toString());
                        adapter.addItem(room);

                        //adapter.addItem(new Room("aa","dd","ee"));
                        listView.setAdapter(adapter);
                    }
                    else{
                        Toast.makeText(getActivity().getApplicationContext(),"fail",Toast.LENGTH_LONG).show();
                    }

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //listView.setAdapter(adapter);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();//Uri uri);

    }
    class SingerAdapter extends BaseAdapter {

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
            roomView itemView = new roomView(getActivity().getApplicationContext());///////
            Room item = items.get(position);
            itemView.setName(item.getroomname());
            itemView.setlocate(item.getroomlocate());
            itemView.setmoney(item.getroommoney());
            itemView.setImageView(Uri.parse(item.getImg1FilePath()));


            return itemView;
        }
    }
}