package com.example.android.audiobookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;


import com.example.android.audiobookapp.Utwory2;
import com.example.android.audiobookapp.UtworyAdapter2;

import java.util.ArrayList;

public class Second extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //Create a array
        final ArrayList<Utwory2> utwory2 = new ArrayList<Utwory2>();

        utwory2.add(new Utwory2(getString(R.string.chapter1_2), getString(R.string.time1_2)));
        utwory2.add(new Utwory2(getString(R.string.chapter2_2), getString(R.string.time2_2)));
        utwory2.add(new Utwory2(getString(R.string.chapter3_2), getString(R.string.time3_2)));
        utwory2.add(new Utwory2(getString(R.string.chapter4_2), getString(R.string.time4_2)));
        utwory2.add(new Utwory2(getString(R.string.chapter5_2), getString(R.string.time5_2)));
        utwory2.add(new Utwory2(getString(R.string.chapter6_2), getString(R.string.time6_2)));
        utwory2.add(new Utwory2(getString(R.string.chapter7_2), getString(R.string.time7_2)));
        utwory2.add(new Utwory2(getString(R.string.chapter8_2), getString(R.string.time8_2)));


        UtworyAdapter2 adapter = new UtworyAdapter2(this, utwory2);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set name of item when one of them is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView wyswietl = (TextView) findViewById(R.id.wyswietlRozdzial);
                wyswietl.setText(utwory2.get(position).getRozdzial());
                progressBar.setProgress(0);
            }
        });

        Button play = (Button) findViewById(R.id.play);
        Button previous = (Button) findViewById(R.id.previous);
        Button next = (Button) findViewById(R.id.next);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set the progress status zero on each button click
                progressStatus = 0;

                // Start the lengthy operation in a background thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100) {
                            // Update the progress status
                            progressStatus += 1;
                        }

                        //Try to sleep the thread for 30 milliseconds
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // Update the progress bar
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(progressStatus);
                            }
                        });
                    }
                }).start();// Start the operation
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressStatus -= 30;
                progressBar.setProgress(progressStatus);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressStatus += 30;
                progressBar.setProgress(progressStatus);
            }
        });
    }
}
