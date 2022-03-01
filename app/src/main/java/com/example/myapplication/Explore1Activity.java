package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Explore1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore1);
        TextView len = (TextView) findViewById(R.id.textView3);
        TextView widit = (TextView) findViewById(R.id.textView2);


        //explore len
        len.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Explore1Activity.this, ExploreActivityLEN.class);
                startActivity(registerIntent);
            }
        });
        //explore widit
        widit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Explore1Activity.this, ExploreActivityWidyatama.class);
                startActivity(registerIntent);
            }
        });

    }}