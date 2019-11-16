package com.example.andriodlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    //EditText email = findViewById(R.id.email);
    static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";
    private ImageButton mImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.e("ProfileActivity", "in onCreate()");


        Intent intent = getIntent();
        String emailAd = intent.getStringExtra("emailAd");
        TextView address = (TextView) findViewById(R.id.email);
        address.setText(emailAd);


        mImageButton = (ImageButton) findViewById(R.id.pictureButton);
        mImageButton.setOnClickListener(v -> {
            dispatchTakePictureIntent();
        });

        Button goToChatButton = (Button) findViewById(R.id.goToChatButton);
        goToChatButton.setOnClickListener(v -> {
            Intent goToChatRoomActivity = new Intent(ProfileActivity.this, ChatRoomActivity.class);
          //  goToChatRoomActivityActivity.putExtra("emailAd", email.getText().toString());
            startActivityForResult(goToChatRoomActivity, 30);


        });
        Button goToWeatherButton = (Button) findViewById(R.id.goToWeatherButton);
        goToWeatherButton.setOnClickListener(v -> {
            Intent goToWeatherActivity = new Intent(ProfileActivity.this, WeatherForecast.class);
            startActivityForResult(goToWeatherActivity, 32);


        });
        Button goToToolbar = (Button) findViewById(R.id.goToToolbar);
        goToToolbar.setOnClickListener(v -> {
            Intent goToTestToolbar = new Intent(ProfileActivity.this, TestToolbar.class);
            startActivityForResult(goToTestToolbar, 34);
        });

    }


    private void dispatchTakePictureIntent() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onStart() {
        Log.e("ProfileActivity", "in onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.e("ProfileActivity", "in onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("ProfileActivity", "in onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        Log.e("ProfileActivity", "in onResume()");
        super.onResume();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            mImageButton.setImageBitmap(imageBitmap);
            Log.e("ProfileActivity", "in onActivityRequest()");

        }

    }

}



