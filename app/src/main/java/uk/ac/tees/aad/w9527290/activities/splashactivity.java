package uk.ac.tees.aad.w9527290.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import uk.ac.tees.aad.w9527290.R;

public class splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        int SPLASH_TIME_OUT = 3500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashactivity.this,Login.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    }
