package com.example.raf0c.fallingwordsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.raf0c.fallingwordsgame.views.WelcomeView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WelcomeView welcomeView = (WelcomeView) findViewById(R.id.welcome_layout);
    }
}
