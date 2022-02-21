package com.example.mediaplayerdemo;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

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

public class Background_Worker extends AsyncTask<String,Void,String> {

    String type;
    Context context;
    AlertDialog alertDialog;
    SharedPreferences sharedPreferences;
    Background_Worker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        type = params[0];


//        http://192.168.56.1/naiki/login.php
//        http://lms-php.000webhostapp.com/LMS_PHP/mlogin.php


        if (type.equals("login")) {
            try {
                String login_url = "http://192.168.2.107/meditation_app/login.php";
                String un = params[1];
                String ps = params[2];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("un", "UTF-8") + "=" + URLEncoder.encode(un, "UTF-8") + "&"
                        + URLEncoder.encode("ps", "UTF-8") + "=" + URLEncoder.encode(ps, "UTF-8");
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



        if (type.equals("update")) {
            String reg_url = "http://lms-php.000webhostapp.com/naiki/update.php";
            String did = params[1];
            String nm = params[2];
            String ct = params[3];
            String qt = params[4];
            String nt = params[5];



            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("did", "UTF-8") + "=" + URLEncoder.encode(did, "UTF-8") +
                                "&" + URLEncoder.encode("nm", "UTF-8") + "=" + URLEncoder.encode(nm, "UTF-8") +
                                "&" + URLEncoder.encode("ct", "UTF-8") + "=" + URLEncoder.encode(ct, "UTF-8") +
                                "&" + URLEncoder.encode("qt", "UTF-8") + "=" + URLEncoder.encode(qt, "UTF-8") +

                                "&" + URLEncoder.encode("nt", "UTF-8") + "=" + URLEncoder.encode(nt, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();


                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        if (type.equals("anxiety_points")) {
            String reg_url = "http://192.168.2.107/meditation_app/anxiety_points.php";
            String p = params[1];
            String rid = params[2];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("p", "UTF-8") + "=" + URLEncoder.encode(p, "UTF-8") + "&" +
                        URLEncoder.encode("rid", "UTF-8") + "=" + URLEncoder.encode(rid, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Registration Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (type.equals("bipolar_points")) {
            String reg_url = "http://192.168.2.107/meditation_app/bipolar_points.php";
            String p = params[1];
            String rid = params[2];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("p", "UTF-8") + "=" + URLEncoder.encode(p, "UTF-8") + "&" +
                                URLEncoder.encode("rid", "UTF-8") + "=" + URLEncoder.encode(rid, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Registration Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (type.equals("depression_points")) {
            String reg_url = "http://192.168.2.107/meditation_app/depression_points.php";
            String p = params[1];
            String rid = params[2];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("p", "UTF-8") + "=" + URLEncoder.encode(p, "UTF-8") + "&" +
                                URLEncoder.encode("rid", "UTF-8") + "=" + URLEncoder.encode(rid, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Registration Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (type.equals("psychosis_points")) {
            String reg_url = "http://192.168.2.107/meditation_app/psychosis_points.php";
            String p = params[1];
            String rid = params[2];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("p", "UTF-8") + "=" + URLEncoder.encode(p, "UTF-8") + "&" +
                                URLEncoder.encode("rid", "UTF-8") + "=" + URLEncoder.encode(rid, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Registration Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (type.equals("pstd_points")) {
            String reg_url = "http://192.168.2.107/meditation_app/pstd_points.php";
            String p = params[1];
            String rid = params[2];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("p", "UTF-8") + "=" + URLEncoder.encode(p, "UTF-8") + "&" +
                                URLEncoder.encode("rid", "UTF-8") + "=" + URLEncoder.encode(rid, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Registration Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (type.equals("addiction_points")) {
            String reg_url = "http://192.168.2.107/meditation_app/addiction_points.php";
            String p = params[1];
            String rid = params[2];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("p", "UTF-8") + "=" + URLEncoder.encode(p, "UTF-8") + "&" +
                                URLEncoder.encode("rid", "UTF-8") + "=" + URLEncoder.encode(rid, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Registration Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


//        REGISTER CODE
        if (type.equals("register")) {
            String reg_url = "http://192.168.2.107/meditation_app/register.php";
            String un = params[1];
            String ph = params[2];
            String em = params[3];
            String ps = params[4];
            String im = params[5];





            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("un", "UTF-8") + "=" + URLEncoder.encode(un, "UTF-8") +
                                "&" + URLEncoder.encode("ph", "UTF-8") + "=" + URLEncoder.encode(ph, "UTF-8") +
                                "&" + URLEncoder.encode("em", "UTF-8") + "=" + URLEncoder.encode(em, "UTF-8") +
                                "&" + URLEncoder.encode("im", "UTF-8") + "=" + URLEncoder.encode(im, "UTF-8") +
                                "&" + URLEncoder.encode("ps", "UTF-8") + "=" + URLEncoder.encode(ps, "UTF-8");




                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Registration Status");
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
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Alert Message");

    }


    @Override
    protected void onPostExecute(String s) {
        if (s != null) {

            String tt = type;


            if (type.equals("login")) {

                if (s.equals("Login-Failed")) {
                    alertDialog.setMessage("Invalid username or password");
                    alertDialog.show();
                } else {
                    try {
                        sharedPreferences = context.getSharedPreferences("userr", Context.MODE_PRIVATE);

                        JSONObject jobj = new JSONObject(s);
                        String r_id = jobj.getString("r_id");
                        int uphon = jobj.getInt("phone");
                        String nam = jobj.getString("uname");
                        String pas = jobj.getString("password");

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("uphone", uphon);
                        editor.putString("r_id", r_id);
                        editor.putString("uname", nam);
                        editor.putString("password", pas);
                        editor.commit();

                        Intent intent = new Intent(context, Navigation.class);
                        context.startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

// Register request Result
            if (type.equals("register")) {

                if (s.equals("Registered")) {
//                    alertDialog.setMessage("Regsiteration Failed Phone Number already Exists '\n' Please Login");
//                    alertDialog.show();
                    Toast.makeText(context, "Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, SignIn.class);
                        context.startActivity(intent);



                } else {
//                    alertDialog.setMessage("Registered Successfully");
//                    alertDialog.show();
                    Toast.makeText(context, "Regsiteration Failed Email already Exists '\n'  Please Login", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(context, MainActivity.class);
//                        context.startActivity(intent);
                }
            }



        }


    }


}







