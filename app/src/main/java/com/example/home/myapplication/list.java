package com.example.home.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.app.Fragment;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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
    MyAdapter2 adapter;
    TextView roomnameview;
    ImageView roomimage;
    ArrayList<Room> roomList;
    public String address="대한민국 서울특별시 광진구 자양동";

    ListView listView;
    DatabaseReference table;
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
        roomnameview = (TextView) v.findViewById(R.id.roomnamelist);
        roomimage = (ImageView)v.findViewById(R.id.imageView4);
        roomList = new ArrayList<>();
        adapter = new MyAdapter2(getActivity().getApplicationContext(), R.layout.layout_list, roomList);
        listView.setAdapter(adapter);


        initDB();
        //placeNameView.setText(ID); //선택 지역 표시
        //placeImage.setImageDrawable(); storage에서 이미지 가져오기
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Room tour=(Room)adapterView.getAdapter().getItem(pos);
                /*
                Intent tourActivity = new Intent(register_list.this, TourActivity.class);
                tourActivity.putExtra("userID",ID);
                tourActivity.putExtra("tourPlace",tour.getplace());
                tourActivity.putExtra("regist","0");
                tourActivity.putExtra("guideID",tour.getGuideID());
                startActivity(tourActivity);
                */
            }
        });
        return v;
    }
    public void initDB(){
        table = FirebaseDatabase.getInstance().getReference("Room");
        //주소바꾸기
        table.child(address).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                roomList.clear();
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    Room room = data.getValue(Room.class);
                    roomList.add(room);
                }
                adapter.notifyDataSetChanged();
                listView.setSelection(adapter.getCount()-1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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

}
class MyAdapter2 extends ArrayAdapter<Room> { //arrayList담을 MyAdapter 클래스 상속
    ArrayList<Room> arrayList;

    public MyAdapter2(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Room> objects) {
        super(context, resource, objects);
        arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) { //convertView가 null일 경우에만 새로 만들기.
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.layout_list, parent, false);
        }
        // TextView에 Message 출력하는 기능 구현
        Room tour = arrayList.get(position);
        //현재 행에 해당하는 chat 정보를 가져옴, position

        TextView textView = (TextView)v.findViewById(R.id.textView2);
        TextView textView1 = (TextView)v.findViewById(R.id.textView3);
        TextView textView2 = (TextView)v.findViewById(R.id.textView4);
        ImageView imageView=(ImageView)v.findViewById(R.id.imageView2);

        //일단 투어 이미지 했는데 가이드 얼굴로 바꾸기
        Uri tourImageUri = Uri.parse(tour.getImg1FilePath().toString());

        textView.setText(tour.getroomname());//매핑작업(메시지, ID, 시간순으로 보여줌)
        textView1.setText(tour.getroomlocate());
        textView2.setText(tour.getroommoney());
        imageView.setImageURI(tourImageUri);
        textView2.setText("");
        return v;
    }
}