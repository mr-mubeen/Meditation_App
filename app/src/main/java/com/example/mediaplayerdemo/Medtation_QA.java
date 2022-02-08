package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Medtation_QA extends AppCompatActivity {


    RadioGroup r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    Button b1;

    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medtation__q);

        r1 = (RadioGroup) findViewById(R.id.radio1);
        r2 = findViewById(R.id.radio2);
        r3 = findViewById(R.id.radio3);
        r4 = findViewById(R.id.radio4);
        r5 = findViewById(R.id.radio5);
        r6 = findViewById(R.id.radio6);
        r7 = findViewById(R.id.radio7);
        r8 = findViewById(R.id.radio8);
        r9 = findViewById(R.id.radio9);
        r10 = findViewById(R.id.radio10);



    }

    public void go_med(View view)
    {


        // get selected radio button from radioGroup
        int selectedId = r1.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        rb = (RadioButton) findViewById(selectedId);

        Toast.makeText(getApplicationContext(),
                rb.getText(), Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent(getApplicationContext(), SongList.class);
//        startActivity(intent);
    }
}