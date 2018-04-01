package com.example.android.audiobookapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.audiobookapp.Fifth;
import com.example.android.audiobookapp.Fourth;
import com.example.android.audiobookapp.R;
import com.example.android.audiobookapp.Second;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Find the View that shows first category

        TextView first = (TextView) findViewById(R.id.first);

        // Set a clickListener on a View
        first.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link First}
                Intent firstIntent = new Intent(MainActivity.this, com.example.android.audiobookapp.First.class);

                //start the new activity
                startActivity(firstIntent);
            }
        });

        // second activity
        TextView second = (TextView) findViewById(R.id.second);

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondIntent = new Intent(MainActivity.this, Second.class);
                startActivity(secondIntent);
            }
        });

        //third activity

        TextView third = (TextView) findViewById(R.id.third);

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdIntent = new Intent(MainActivity.this, com.example.android.audiobookapp.Third.class);
                startActivity(thirdIntent);
            }
        });

        //fourth activity

        TextView fourth = (TextView) findViewById(R.id.fourth);

        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fourthIntent = new Intent(MainActivity.this, Fourth.class);
                startActivity(fourthIntent);
            }
        });

        TextView fifth = (TextView) findViewById(R.id.fifth);

        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fifthIntent = new Intent(MainActivity.this, Fifth.class);
                startActivity(fifthIntent);
            }
        });

        TextView sixth = (TextView) findViewById(R.id.sixth);

        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sixthIntent = new Intent(MainActivity.this, com.example.android.audiobookapp.Sixth.class);
                startActivity(sixthIntent);
            }
        });

    }
}
