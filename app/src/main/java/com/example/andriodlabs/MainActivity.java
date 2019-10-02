package com.example.andriodlabs;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    // public static SharedPreferences preferences;
    // public static final String EMAILAD = "EMAILAD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        email = findViewById(R.id.email);
        //  preferences = getSharedPreferences(String.valueOf(email), MODE_PRIVATE);

        SharedPreferences preferences = getSharedPreferences("Email", MODE_PRIVATE);
        String variable = preferences.getString("emailAd", "");
        email.setText(variable);



        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> {

            Intent goToProfileActivity = new Intent(MainActivity.this, ProfileActivity.class);
             goToProfileActivity.putExtra("emailAd", email.getText().toString());
            startActivityForResult(goToProfileActivity, 30);

            Log.e("MainActivity", "in onCreate()");
        });
    }

    @Override
    protected void onPause() {
        //String savedEmail = email.getText().toString();
        SharedPreferences preferences = getSharedPreferences("Email", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("emailAd", email.getText().toString());
        editor.commit();
        super.onPause();
        Log.e("MainActivity", "in onPause()");
    }
}
