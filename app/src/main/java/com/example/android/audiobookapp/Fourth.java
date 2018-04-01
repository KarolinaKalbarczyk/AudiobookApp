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


import com.example.android.audiobookapp.Utwory4;
import com.example.android.audiobookapp.UtworyAdapter4;

import java.util.ArrayList;

public class Fourth extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //Create a array
        final ArrayList<Utwory4> utwory4 = new ArrayList<Utwory4>();

        utwory4.add(new Utwory4(getString(R.string.chapter1_4), getString(R.string.time1_4)));
        utwory4.add(new Utwory4(getString(R.string.chapter2_4), getString(R.string.time2_4)));
        utwory4.add(new Utwory4(getString(R.string.chapter3_4), getString(R.string.time3_4)));
        utwory4.add(new Utwory4(getString(R.string.chapter4_4), getString(R.string.time4_4)));


        UtworyAdapter4 adapter = new UtworyAdapter4(this, utwory4);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set name of item when one of them is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView wyswietl = (TextView) findViewById(R.id.wyswietlRozdzial);
                wyswietl.setText(utwory4.get(position).getRozdzial());
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