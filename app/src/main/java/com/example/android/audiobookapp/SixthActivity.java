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

public class SixthActivity extends AppCompatActivity {

    private ProgressBar pgb;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        pgb = (ProgressBar) findViewById(R.id.progressBar);

        //Create a array
        final ArrayList<Utwory6> utwory6 = new ArrayList<Utwory6>();

        utwory6.add(new Utwory6(getString(R.string.chapter1_6), getString(R.string.time1_6)));
        utwory6.add(new Utwory6(getString(R.string.chapter2_6), getString(R.string.time2_6)));
        utwory6.add(new Utwory6(getString(R.string.chapter3_6), getString(R.string.time3_6)));
        utwory6.add(new Utwory6(getString(R.string.chapter4_6), getString(R.string.time4_6)));
        utwory6.add(new Utwory6(getString(R.string.chapter5_6), getString(R.string.time5_6)));
        utwory6.add(new Utwory6(getString(R.string.chapter6_6), getString(R.string.time6_6)));
        utwory6.add(new Utwory6(getString(R.string.chapter7_6), getString(R.string.time7_6)));


        Utwory6Adapter adapter = new Utwory6Adapter(this, utwory6);
        ListView lsv = (ListView) findViewById(R.id.list);
        lsv.setAdapter(adapter);

        // Set name of item when one of them is clicked
        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView wyswietl = (TextView) findViewById(R.id.wyswietlRozdzial);
                wyswietl.setText(utwory6.get(position).getRozdzial());
                pgb.setProgress(0);
            }
        });

        Button btn1 = (Button) findViewById(R.id.play);
        Button btn2 = (Button) findViewById(R.id.previous);
        Button btn3 = (Button) findViewById(R.id.next);


        btn1.setOnClickListener(new View.OnClickListener() {
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
                                pgb.setProgress(progressStatus);
                            }
                        });
                    }
                }).start();// Start the operation
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressStatus -= 30;
                pgb.setProgress(progressStatus);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressStatus += 30;
                pgb.setProgress(progressStatus);
            }
        });
    }
}