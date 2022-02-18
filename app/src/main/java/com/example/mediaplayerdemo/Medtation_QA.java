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
    int points;

    RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medtation__q);

        r1 = (RadioGroup) findViewById(R.id.radio1);
        r2 = (RadioGroup) findViewById(R.id.radio2);
        r3 = (RadioGroup) findViewById(R.id.radio3);
        r4 = (RadioGroup) findViewById(R.id.radio4);
        r5 = (RadioGroup) findViewById(R.id.radio5);
        r6 = (RadioGroup) findViewById(R.id.radio6);
        r7 = (RadioGroup) findViewById(R.id.radio7);
        r8 = (RadioGroup) findViewById(R.id.radio8);
        r9 = (RadioGroup) findViewById(R.id.radio9);
        r10 = (RadioGroup) findViewById(R.id.radio10);

    }

    public void go_med(View view)
    {


        // get selected radio button from radioGroup
        int q1 = r1.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb1 = (RadioButton) findViewById(q1);
        String Q1 = rb1.getText().toString();


        int q2 = r2.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb2 = (RadioButton) findViewById(q2);
        String Q2 = rb2.getText().toString();


        int q3 = r3.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb3 = (RadioButton) findViewById(q3);
        String Q3 = rb3.getText().toString();


        int q4 = r4.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb4 = (RadioButton) findViewById(q4);
        String Q4 = rb4.getText().toString();


        int q5 = r5.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb5 = (RadioButton) findViewById(q5);
        String Q5 = rb5.getText().toString();


        int q6 = r6.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb6 = (RadioButton) findViewById(q6);
        String Q6 = rb6.getText().toString();


        int q7 = r7.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb7 = (RadioButton) findViewById(q7);
        String Q7 = rb7.getText().toString();


        int q8 = r8.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb8 = (RadioButton) findViewById(q8);
        String Q8 = rb8.getText().toString();


        int q9 = r9.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb9 = (RadioButton) findViewById(q9);
        String Q9 = rb9.getText().toString();


        int q10 = r10.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        rb10 = (RadioButton) findViewById(q10);
        String Q10 = rb10.getText().toString();

        String ans = Q1 + Q2 + Q3 + Q4 + Q5 + Q6 + Q7+ Q8 + Q9 + Q10;

        if (Q1.equals("Yes"))
        {
            points += 1;
        }
        if(Q2.equals("Yes"))
        {
            points += 1;
        }
        if(Q3.equals("Yes"))
        {
            points += 1;
        }
        if(Q4.equals("Yes"))
        {
            points += 1;
        }
        if(Q5.equals("Yes"))
        {
            points += 1;
        }
        if(Q6.equals("Yes"))
        {
            points += 1;
        }
        if(Q7.equals("Yes"))
        {
            points += 1;
        }
        if(Q8.equals("Yes"))
        {
            points += 1;
        }
        if(Q9.equals("Yes"))
        {
            points += 1;
        }
        if(Q10.equals("Yes"))
        {
            points += 1;
        }
//        else{
//            points += 0;
//            Toast.makeText(this, "You are mentally healthy", Toast.LENGTH_SHORT).show();
//        }

//        Toast.makeText(this, "Your Points are", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, points, Toast.LENGTH_SHORT).show();

//        Toast.makeText(this, ans, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), SongList.class);
        startActivity(intent);
    }
}