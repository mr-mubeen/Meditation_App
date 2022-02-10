package com.example.mediaplayerdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class meditation_frag extends Fragment {


    public meditation_frag() {
        // Required empty public constructor
    }


    LinearLayout l1,l2,l3,l4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_meditation_frag, container, false);

        l1 = view.findViewById(R.id.meditation_layout_id);
        l2 = view.findViewById(R.id.yoga_id);
        l3 = view.findViewById(R.id.diet_id);
        l4 = view.findViewById(R.id.keggle_id);


        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , Meditation_Screen.class);
                startActivity(intent);
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , SongList.class);
                startActivity(intent);
            }
        });


        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , SongList.class);
                startActivity(intent);
            }
        });

        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , SongList.class);
                startActivity(intent);
            }
        });

        return view;
    }
}