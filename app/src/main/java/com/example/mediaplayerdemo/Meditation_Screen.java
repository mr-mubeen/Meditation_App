package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Meditation_Screen extends AppCompatActivity {


    LinearLayout l1,l2,l3,l4,l5,l6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation__screen);

        l1 = findViewById(R.id.anxiety_id);
        l2 = findViewById(R.id.depression_id);
        l3 = findViewById(R.id.sleep_id);
        l4 = findViewById(R.id.focus_id);
        l5 = findViewById(R.id.bipolar);
        l6 = findViewById(R.id.psychosis);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Medtation_QA.class);
                startActivity(intent);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Medtation_QA.class);
                startActivity(intent);
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Medtation_QA.class);
                startActivity(intent);
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Medtation_QA.class);
                startActivity(intent);
            }
        });

        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() ,);
                startActivity(intent);
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Medtation_QA.class);
                startActivity(intent);
            }
        });
    }
}