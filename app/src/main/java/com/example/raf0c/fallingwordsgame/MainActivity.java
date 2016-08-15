package com.example.raf0c.fallingwordsgame;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.raf0c.fallingwordsgame.service.BackgroundMusicService;
import com.example.raf0c.fallingwordsgame.utils.Constants;
import com.example.raf0c.fallingwordsgame.views.WelcomeView;

public class MainActivity extends AppCompatActivity implements WelcomeView.Listener {

    private BackgroundMusicService mBackgroundMusicService;
    private boolean mIsBackgroundMusicServiceBound = false;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WelcomeView welcomeView = (WelcomeView) findViewById(R.id.welcome_layout);
        welcomeView.setListener(this);

        Intent startBackgroundMusicService = new Intent(this, BackgroundMusicService.class);
        startService(startBackgroundMusicService);
        bindService(startBackgroundMusicService, mBackgroundMusicServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeMusic();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mIsBackgroundMusicServiceBound){
            mBackgroundMusicService.pauseIntroMusic();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mIsBackgroundMusicServiceBound){
            unbindService(mBackgroundMusicServiceConnection);
            mIsBackgroundMusicServiceBound = false;
        }
    }

    @Override //Game lobby screen
    public void onStartRequested(String name) {

        Intent startGameIntent = new Intent(this, GameActivity.class);
        startGameIntent.putExtra(Constants.PLAYER_KEY, name);
        startActivity(startGameIntent);
    }

    private void resumeMusic(){
        if(mIsBackgroundMusicServiceBound){
            if(mBackgroundMusicService.getIsIntroMusicPaused()){
                mBackgroundMusicService.resumeIntroMusic();
            } else {
                mBackgroundMusicService.startIntroMusic();
            }
        } else {
            Log.d(TAG, "mBackgroundMusicService is not bound yet");
        }
    }

    private ServiceConnection mBackgroundMusicServiceConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className, IBinder service) {
            BackgroundMusicService.BackgroundMusicServiceBinder binder = (BackgroundMusicService.BackgroundMusicServiceBinder) service;
            mBackgroundMusicService = binder.getService();
            mIsBackgroundMusicServiceBound = true;
            resumeMusic();
        }

        public void onServiceDisconnected(ComponentName arg0) {
            mIsBackgroundMusicServiceBound = false;
        }

    };
}
