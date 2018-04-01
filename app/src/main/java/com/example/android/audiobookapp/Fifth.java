package com.example.android.audiobookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;

public class Fifth extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //Create a array
        final ArrayList<com.example.android.audiobookapp.Utwory5> utwory5 = new ArrayList<Utwory5>();

        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter1_5), getString(R.string.time1_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter2_5), getString(R.string.time2_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter3_5), getString(R.string.time3_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter4_5), getString(R.string.time4_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter5_5), getString(R.string.time5_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter6_5), getString(R.string.time6_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter7_5), getString(R.string.time7_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter8_5), getString(R.string.time8_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter9_5), getString(R.string.time9_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter10_5), getString(R.string.time10_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter11_5), getString(R.string.time11_5)));
        utwory5.add(new com.example.android.audiobookapp.Utwory5(getString(R.string.chapter12_5), getString(R.string.time12_5)));


        com.example.android.audiobookapp.UtworyAdapter5 adapter = new com.example.android.audiobookapp.UtworyAdapter5(this, utwory5);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set name of item when one of them is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView wyswietl = (TextView) findViewById(R.id.wyswietlRozdzial);
                wyswietl.setText(utwory5.get(position).getRozdzial());
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