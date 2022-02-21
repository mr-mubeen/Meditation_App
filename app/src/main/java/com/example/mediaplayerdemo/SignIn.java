package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignIn extends AppCompatActivity {


    TextInputEditText phone ;
    TextInputEditText pass;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        phone = findViewById(R.id.phoneid);
        pass = findViewById(R.id.passwordid);

        sharedPreferences = getSharedPreferences("userr" , Context.MODE_PRIVATE);

        if(sharedPreferences.contains("uname") && sharedPreferences.contains("password"))
        {
            Intent intent = new Intent(this , Navigation.class);
            startActivity(intent);
        }


    }

    public void login(View view){

        if(phone.length()==0)
        {
            phone.requestFocus();
            phone.setError("FIELD CANNOT BE EMPTY");
        }

        else if(pass.length()==0)
        {
            pass.requestFocus();
            pass.setError("FIELD CANNOT BE EMPTY");
        }

        else{

            if (phone.length() != 11)
            {
                Toast.makeText(this, "Enter correct mobile number", Toast.LENGTH_SHORT).show();
            }
            else if(pass.length() < 8)
            {
                Toast.makeText(this, "Please enter complete password", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String user_text = phone.getText().toString();
                String pass_text = pass.getText().toString();
//            String type = "login";

                Background_Worker background_worker = new Background_Worker(this);
                background_worker.execute("login", user_text, pass_text);
            }
        }



    }

    public void signup(View view){
        Intent intent = new Intent( SignIn.this , Registration.class);
        startActivity(intent);
    }
}