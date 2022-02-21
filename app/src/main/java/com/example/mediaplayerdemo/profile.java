package com.example.mediaplayerdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends Fragment {


    public profile() {
        // Required empty public constructor
    }


    SharedPreferences sharedPreferences;

    String r_id;

    TextView t38,t40,t42,t44,t45,t47,t49,t55,t57,t59;
    CircleImageView pf;
    Button lg;

    ImageView i1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        sharedPreferences = getContext().getSharedPreferences("userr" , Context.MODE_PRIVATE);

        if(sharedPreferences.contains("r_id") && sharedPreferences.contains("password"))
        {
            r_id = sharedPreferences.getString("r_id", "0");

        }
//        Initializing
        t38 = view.findViewById(R.id.textView38);
        t40 = view.findViewById(R.id.textView40);
        t42 = view.findViewById(R.id.textView42);
        t45 = view.findViewById(R.id.textView45);
        t47 = view.findViewById(R.id.textView47);
        t49 = view.findViewById(R.id.textView49);
        t55 = view.findViewById(R.id.textView55);
        t57 = view.findViewById(R.id.textView57);
        t59 = view.findViewById(R.id.textView59);
        pf = view.findViewById(R.id.profile_image);



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


        getProfile();


        return view;
    }


    public void getProfile(){


        class bgWorker extends AsyncTask<String, Void, String> {


            @Override
            protected String doInBackground(String... strings) {

//              rid is the vallue we get from sharedpreferences
                String rid = strings[1];
                String type = strings[0];

// working for fetch profile from database for which we are using rid to sent this id to mysql api where we get data
                if (type.equals("profile")) {

                    try {
//                        API link
                        String fetch_url = "http://192.168.2.107/meditation_app/profile.php";
                        URL url = new URL(fetch_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("rid", "UTF-8") + "=" + URLEncoder.encode(rid, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return null;
            }


            @Override
            protected void onPreExecute()
            {

            }

            @Override
            protected void onPostExecute(String s) {
                if (s != null) {

                    if (s.equals("Failed")) {

                    }
                    else {
//                        Getting data in JSON Array from PHP MYSQL
                        try
                        {
                            JSONArray jsonArray = new JSONArray(s);
                            JSONObject jsonObject = null;

                            String image = "";

                            for (int i=0; i<jsonArray.length(); i++)
                            {
                                jsonObject = jsonArray.getJSONObject(i);

                                String name = jsonObject.getString("uname");
                                String email = jsonObject.getString("email");
                                String phone = jsonObject.getString("phone");
                                String anxiety_points = jsonObject.getString("anxiety_points");
                                String depression_points = jsonObject.getString("depression_points");
                                String pstd_points = jsonObject.getString("pstd_points");
                                String addiction_points = jsonObject.getString("addiction_points");
                                String bipolar_points = jsonObject.getString("bipolar_points");
                                String psychosis_points = jsonObject.getString("psychosis_points");
                                String url = "http://192.168.2.107/meditation_app/profiles/";
//                                http://lms-php.000webhostapp.com/naiki/profiles/
                                image = url + jsonObject.getString("image");


//  Setting values again to textboxes
                                t38.setText(name);
                                t40.setText(email);
                                t42.setText(phone);


                                t45.setText(anxiety_points);
                                t47.setText(depression_points);
                                t49.setText(pstd_points);
                                t55.setText(addiction_points);
                                t57.setText(bipolar_points);
                                t59.setText(psychosis_points);


                                Glide.with(getContext()).load(image).into(pf);


                            }

//                            pf.setImageURI(Uri.parse(image));
//                            byte[] bytes = Base64.decode(image,Base64.DEFAULT);
//                            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0, bytes.length);
//                            pf.setImageBitmap(bitmap);

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }

                    }

                }
            }

        }





//

//        Calling object
        bgWorker bg = new bgWorker();
        bg.execute("profile" , r_id);
    }
}