package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    AlertDialog.Builder builder;
    FloatingActionButton scan;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME= "username";
    private static final String KEY_PASS= "password";

    BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                default:
                    f = new HomeFragment();
                    break;
                case R.id.fab:
                    f = new qrcodeFragment();
                    break;
                case R.id.navigation_profile:
                    f = new ProfileFragment();
                    break;


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,
                    f).commit();

            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        BottomNavigationView navView = findViewById(R.id.bottom_navigation);

        navView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));
        String name = sharedPreferences.getString(KEY_NAME,null);
        String password = sharedPreferences.getString(KEY_PASS,null);
        FloatingActionButton explore = (FloatingActionButton) findViewById(R.id.fab);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,
                    new HomeFragment()).commit();
        }
        //explore
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(DashboardActivity.this, Explore1Activity.class);
                startActivity(registerIntent);
            }
        });


    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Kamu yakin ingin keluar?");
        alert.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.show();
    }



}