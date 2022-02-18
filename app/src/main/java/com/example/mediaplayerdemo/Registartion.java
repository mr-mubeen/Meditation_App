package com.example.mediaplayerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Registartion extends AppCompatActivity {



    EditText ed1 ,ed2,ed3,ed4;
    TextView t1, t35, t36;
    Button b1;
    ProgressBar progressBar;
    Button button;
    ImageView pr_up;
    String image_path;
    Bitmap bitmap;

    String a;
    String b;
    Spinner spinner;
    ArrayList<String> data = new ArrayList<>();

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

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        getLocation();

        t1 =(TextView)  findViewById(R.id.address);

        spinner =  findViewById(R.id.type_reg);

        pr_up = findViewById(R.id.profile_upload);

        pr_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(registration.this)
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });





        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource ( this, R.array.type , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (ActivityCompat.checkSelfPermission(registration.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(registration.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }

                if (ed1.length() == 0) {
                    ed1.requestFocus();
                    ed1.setError("FIELD CANNOT BE EMPTY");
                } else if (t1.length() == 0) {
                    t1.requestFocus();
                    t1.setError("FIELD CANNOT BE EMPTY");
                    Toast.makeText(getApplicationContext(), "Please enable Location to proceed", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(registration.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
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
                    String tp = spinner.getSelectedItem().toString();


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



//                        intent.putExtra("user_text" , username);
//                        intent.putExtra("pass_text" , password);
//                        intent.putExtra("address_text" , address_text);
//                        intent.putExtra("email_text" , email);
//                        intent.putExtra("tp" , tp);
//                        intent.putExtra("image" , image_path);
//
//                        startActivity(intent);

                            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                    "+92" + phone,
                                    60,
                                    TimeUnit.SECONDS,
                                    registration.this,
                                    new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                        @Override
                                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                            progressBar.setVisibility(View.GONE);
                                            button.setVisibility(View.VISIBLE);
                                        }

                                        @Override
                                        public void onVerificationFailed(@NonNull FirebaseException e) {
                                            progressBar.setVisibility(View.GONE);
                                            button.setVisibility(View.VISIBLE);
                                            Toast.makeText(registration.this, e.getMessage(), Toast.LENGTH_SHORT).show();


                                        }

                                        @Override
                                        public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                            progressBar.setVisibility(View.GONE);
                                            button.setVisibility(View.VISIBLE);

                                            Background_Worker background_worker = new Background_Worker(getApplication());
                                            background_worker.execute("register", username, phone, email, password, address_text, tp, image_path, a, b);

                                            Intent intent = new Intent(registration.this, OTP.class);
                                            intent.putExtra("mobile", phone);

                                            intent.putExtra("verificationId", verificationId);


                                            startActivity(intent);
                                        }
                                    }
                            );
                        }



                    }
                    else{
                        Toast.makeText(registration.this, " Password must has atleast 8 characters that include at least 1 lowercase character, 1 uppercase, 1 number, and 1 special character", Toast.LENGTH_SHORT).show();
                    }


//

                }



            }
        });




    }
}