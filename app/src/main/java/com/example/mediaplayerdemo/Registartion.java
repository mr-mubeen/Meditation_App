package com.example.mediaplayerdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registartion extends AppCompatActivity {



    EditText ed1 ,ed2,ed3,ed4;
    TextView t1, t35, t36;
    Button b1;

    Button button;
    ImageView pr_up;
    String image_path;
    Bitmap bitmap;

    String a;
    String b;


    Uri uri1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registartion);


        button = findViewById(R.id.register);
        ed1 = findViewById(R.id.username);
        ed2 = findViewById(R.id.phone);
        ed3 = findViewById(R.id.email);
        ed4 = findViewById(R.id.password);

        b1 = findViewById(R.id.register);




        pr_up = findViewById(R.id.profile_upload);

        pr_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Registration.this)
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });











        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



                if (ed1.length() == 0) {
                    ed1.requestFocus();
                    ed1.setError("FIELD CANNOT BE EMPTY");
                }

                else if (!(ed3.getText().toString().trim().matches(emailPattern))) {
                    ed3.requestFocus();
                    Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                } else if (ed4.length() == 0) {
                    ed4.requestFocus();
                    ed4.setError("FIELD CANNOT BE EMPTY");
                } else if (ed2.length() != 11) {
                    ed2.requestFocus();
                    ed2.setError("Enter correct mobile number");
                } else if (ed2.length() == 11 && ed4.length() != 0 && ed3.length() != 0 && ed1.length() != 0 && t1.length() != 0 && ed3.getText().toString().trim().matches(emailPattern)) {

                    String username = ed1.getText().toString();
                    String phone = ed2.getText().toString();
                    String email = ed3.getText().toString();
                    String password = ed4.getText().toString();
                    String address_text = t1.getText().toString();


                    Background_Worker background_worker = new Background_Worker(getApplication());
                    background_worker.execute("register", username, phone, email, password, address_text, tp, image_path, a, b);


                    if (isValidPassword(password))
                    {

//                        Intent intent = new Intent(registration.this , OTP.class);
//                        intent.putExtra("mobile" , phone);
//
//                        intent.putExtra("verificationId" , verificationId);


                        if (uri1 == null)
                        {
                            Toast.makeText(getApplicationContext(), "Please upoad Image", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            image_path = encodedbitmap(bitmap);



                        }



                    }
                    else{
                        Toast.makeText(Registration.this, " Password must has atleast 8 characters that include at least 1 lowercase character, 1 uppercase, 1 number, and 1 special character", Toast.LENGTH_SHORT).show();
                    }


//

                }



            }
        });




    }

    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

//        val passwordREGEX = Pattern.compile("^" +
//                "(?=.*[0-9])" +         //at least 1 digit
//                "(?=.*[a-z])" +         //at least 1 lower case letter
//                "(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
//                "(?=.*[@#$%^&+=])" +    //at least 1 special character
//                "(?=\\S+$)" +           //no white spaces
//                ".{8,}" +               //at least 8 characters
//                "$");

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uri1 = data.getData();
        if (uri1 == null)
        {
            Toast.makeText(getApplicationContext(), "Please upoad Image", Toast.LENGTH_SHORT).show();
        }
        else
        {
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri1);
                pr_up.setImageBitmap(bitmap);
//        t2.setText(uri1.toString());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public String encodedbitmap(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, byteArrayOutputStream);

        byte[] byteofimage = byteArrayOutputStream.toByteArray();
        image_path = android.util.Base64.encodeToString(byteofimage , Base64.DEFAULT);
//        t2.setText(image_path);
        return image_path;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}