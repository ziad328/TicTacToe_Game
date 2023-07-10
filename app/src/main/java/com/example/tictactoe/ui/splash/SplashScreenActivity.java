package com.example.tictactoe.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.tictactoe.R;
import com.example.tictactoe.ui.AddPlayersActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int SPLASH_TIME_OUT = 1000;
        new Handler().postDelayed(this::run, SPLASH_TIME_OUT);
    }

    private void run() {
        startActivity(new Intent(SplashScreenActivity.this, AddPlayersActivity.class));
        finish();
    }
}