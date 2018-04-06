package com.example.android.audiobookapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Find the View that shows first category

        TextView txv1 = (TextView) findViewById(R.id.first);

        // Set a clickListener on a View
        txv1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link FirstActivity}
                Intent firstIntent = new Intent(MainActivity.this, FirstActivity.class);

                //start the new activity
                startActivity(firstIntent);
            }
        });

        // second activity
        TextView txv2 = (TextView) findViewById(R.id.second);

        txv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(secondIntent);
            }
        });

        //third activity

        TextView txv3 = (TextView) findViewById(R.id.third);

        txv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdIntent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(thirdIntent);
            }
        });

        //fourth activity

        TextView txv4 = (TextView) findViewById(R.id.fourth);

        txv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fourthIntent = new Intent(MainActivity.this, FourthActivity.class);
                startActivity(fourthIntent);
            }
        });

        TextView txv5 = (TextView) findViewById(R.id.fifth);

        txv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fifthIntent = new Intent(MainActivity.this, FifthActivity.class);
                startActivity(fifthIntent);
            }
        });

        TextView txv6 = (TextView) findViewById(R.id.sixth);

        txv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sixthIntent = new Intent(MainActivity.this, SixthActivity.class);
                startActivity(sixthIntent);
            }
        });

    }
}
