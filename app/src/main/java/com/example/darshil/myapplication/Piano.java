package com.example.darshil.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Piano extends AppCompatActivity {
    String origAns = "";

    ArrayList<Integer> key = new ArrayList();
//    int checker = 0;
//
//
//    {
//        writeMessage();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button unlock = (Button)findViewById(R.id.unlock);
        Button b0 = (Button)findViewById(R.id.buttonWhite1);
        Button b1 = (Button)findViewById(R.id.buttonWhite2);
        Button b2 = (Button)findViewById(R.id.buttonWhite3);
        Button b3 = (Button)findViewById(R.id.buttonWhite4);
        Button b4 = (Button)findViewById(R.id.buttonWhite5);
        Button b5 = (Button)findViewById(R.id.buttonWhite6);
        Button b6 = (Button)findViewById(R.id.buttonWhite7);
        Button b7black = (Button)findViewById(R.id.buttonBlack1);
        Button b8black = (Button)findViewById(R.id.buttonBlack2);
        Button b9black = (Button)findViewById(R.id.buttonBlack3);
        Button b10black = (Button)findViewById(R.id.buttonBlack4);
        Button b11black = (Button)findViewById(R.id.buttonBlack5);


        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(0);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));


            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(1);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(2);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(3);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(4);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(5);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(6);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b7black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(7);
               Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b8black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(8);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b9black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(9);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b10black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(10);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        b11black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                key.add(11);
                Log.d("Test","SUCCESS"+key.get(key.size()-1));

            }
        });

        unlock.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ArrayList<Integer> Compare = new ArrayList<>();

                String origAns = readFromFile();
                //Log.d("Test",origAns+"ORIG ANDS");
                int flag = 0;

                if (key.size() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter a combination", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i = 0; i < origAns.length(); i++) {
                         //Log.d("Test",origAns.substring(i, i + 1)+"INSIDE ADD");
                        Compare.add(Integer.parseInt(origAns.substring(i, i + 1)));
                    }


                    //Log.d("Test", String.valueOf(Compare.size()));
                    for (int i = 0; i < key.size(); i++) {
                        if(key.size() != Compare.size())
                        {
                            flag = 1;
                            break;
                        }
                        // Log.d("Test",key.get(i).toString());
                        if (Compare.get(i) != key.get(i)) {
                            // Log.d("Test",Compare.get(i).toString() + " THIS I SFALSE");
                            flag = 1;
                            break;
                        }
                    }

                    if (flag == 0) {
                        Log.d("Test", "The key is correct");
                        Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                        Timer timer= new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, 1500);


                    } else {
                        Log.d("Test", "The key is incorrect");
                        Toast.makeText(getApplicationContext(), "THE KEY IS INCORRECT", Toast.LENGTH_SHORT).show();
                    }

                    while (!key.isEmpty())
                        key.remove(0);
                }
            }
        });








    }
    public void writeMessage(){
        String storepass = "012345";

//        for(int i = 0;i < key.size();i++)
//        {
//            storepass = storepass + key.get(i).toString();
//        }
        String fileName = "storePianoPass.txt";

        try {

            FileOutputStream fp = openFileOutput(fileName,MODE_PRIVATE);
            fp.write(storepass.getBytes());
            fp.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String readFromFile(){
        writeMessage();
        String message = "";
        try {
            //Context temp = getApplicationContext();
            FileInputStream finp = openFileInput("storePianoPass.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(finp);
            BufferedReader br = new BufferedReader(inputStreamReader);
            message = br.readLine();

        } catch (FileNotFoundException e) {
            Log.d("Test","FILE NOT FOUND");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;

    }
}
