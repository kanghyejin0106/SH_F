package com.example.home.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class list extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView listView;
    SingerAdapter adapter;

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

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView)v.findViewById(R.id.list_room) ;

        adapter = new SingerAdapter();
        adapter.addItem(new Room("aa","dd","ee"));
        adapter.addItem(new Room("bb","ee","ee"));
        adapter.addItem(new Room("cc","rr","ee"));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Room item = (Room)adapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(),"선택: "+item.getRoomname(),Toast.LENGTH_SHORT).show();

            }
        });
        return v;
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
            roomView itemView = new roomView(getActivity().getApplicationContext());///////
            Room item = items.get(position);
            itemView.setName(item.getRoomname());
            itemView.setlocate(item.getRoomlocate());
            itemView.setmoney(item.getRoommoney());
            return itemView;
        }
    }
}
