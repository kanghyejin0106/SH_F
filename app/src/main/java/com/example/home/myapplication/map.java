package com.example.home.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;


public class map extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    MapView mapView;
    GoogleMap mGoogleMap;
    Geocoder geocoder;
    Button button;
    EditText editText;
    View view;
    Marker exMarker;
    //
    DatabaseReference table;
    private OnFragmentInteractionListener mListener;

    public map() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // TODO: Rename and change types and number of parameters

    public void initDB(){
        table = FirebaseDatabase.getInstance().getReference("senior");
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                        if(data.hasChild("address")) {
                            String getAddress = data.child("address").getValue().toString();
                            Toast.makeText(getActivity().getApplicationContext(), getAddress, Toast.LENGTH_SHORT).show();
                            List<Address> addressList = null;
                            try {
                                addressList = geocoder.getFromLocationName(getAddress, 10);

                                System.out.println(addressList.get(0).toString());
                                String[] splitStr = addressList.get(0).toString().split(",");
                                String address = splitStr[0].substring(splitStr[0].indexOf("\"") + 1, splitStr[0].length() - 2);
                                System.out.println(address);

                                String latitude = splitStr[10].substring(splitStr[10].indexOf("=") + 1);
                                String longtitude = splitStr[12].substring(splitStr[12].indexOf("=") + 1);
                                System.out.println(latitude);
                                System.out.println(longtitude);
                                LatLng point = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longtitude));

                                MarkerOptions mOptions2 = new MarkerOptions();
                                mOptions2.title("search result");
                                mOptions2.snippet(address);
                                mOptions2.position(point);
                                mGoogleMap.addMarker(mOptions2);
                               // mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 15));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_map, container, false);
        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        mapView=(MapView) view.findViewById(R.id.map);
        editText=(EditText) view.findViewById(R.id.editText);
        button=(Button) view.findViewById(R.id.button);
        if(mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }
    public void onMapReady(final GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap=googleMap;
        geocoder=new Geocoder(view.getContext());

        mGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if(exMarker!=null) {
                    exMarker.remove();
                }
                MarkerOptions mOptions=new MarkerOptions();
                mOptions.title("마커좌표");
                Double latitude=latLng.latitude;
                Double longtitue=latLng.longitude;
                mOptions.snippet(latitude.toString()+","+longtitue.toString());
                mOptions.position(new LatLng(latitude,longtitue));

                exMarker=googleMap.addMarker(mOptions);
            }
        });
        mGoogleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getActivity().getApplicationContext(),"success했음^~",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                List<Address> addressList = null;
                try {
                    addressList = geocoder.getFromLocationName(str, 10);

                    System.out.println(addressList.get(0).toString());
                    String[] splitStr = addressList.get(0).toString().split(",");
                    String address = splitStr[0].substring(splitStr[0].indexOf("\"") + 1, splitStr[0].length() - 2);
                    System.out.println(address);

                    String latitude = splitStr[10].substring(splitStr[10].indexOf("=") + 1);
                    String longtitude = splitStr[12].substring(splitStr[12].indexOf("=") + 1);
                    System.out.println(latitude);
                    System.out.println(longtitude);
                    LatLng point = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longtitude));

                    MarkerOptions mOptions2 = new MarkerOptions();
                    mOptions2.title("search result");
                    mOptions2.snippet(address);
                    mOptions2.position(point);
                    mGoogleMap.addMarker(mOptions2);
                    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 15));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        initDB();
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(40.689247,-74.044502)).title("Statue of Liberty").snippet("I hope to go"));
        // CameraPosition Liberty= CameraPosition.builder().target(new LatLng(40.689247,-74.044502)).zoom(16).bearing(0).tilt(45).build();
        // mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));
    }

    // TODO: Rename method, update argument and hook method into UI event
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (OnFragmentInteractionListener)getContext();
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name

    }
}

