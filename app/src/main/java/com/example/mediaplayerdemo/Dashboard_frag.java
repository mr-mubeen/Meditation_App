package com.example.mediaplayerdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Dashboard_frag extends Fragment {


    public Dashboard_frag() {
        // Required empty public constructor
    }

    ImageView i1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dashboard_frag, container, false);

        i1 = view.findViewById(R.id.logout);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getActivity().getSharedPreferences("userr", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                getActivity().finish();

                Intent intent = new Intent(getContext(), SignIn.class);
                startActivity(intent);
            }
        });


        return view;
    }
}