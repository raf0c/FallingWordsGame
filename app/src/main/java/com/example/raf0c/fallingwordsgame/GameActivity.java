package com.example.raf0c.fallingwordsgame;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.example.raf0c.fallingwordsgame.service.BackgroundMusicService;

public class GameActivity extends AppCompatActivity {

    private BackgroundMusicService mBackgroundMusicService;
    private boolean mIsBackgroundMusicServiceBound = false;

    private static final String TAG = GameActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent startBackgroundMusicService = new Intent(this, BackgroundMusicService.class);
        bindService(startBackgroundMusicService, mBackgroundMusicServiceConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mIsBackgroundMusicServiceBound){
            mBackgroundMusicService.pauseGameMusic();
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            displayWarningDialog();
        }
        return true;
    }

    /**
     * Display a warning dialog to inform the user is about to exit the game
     * */
    private void displayWarningDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Exit Game");
        builder.setMessage("Are you sure? :(");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void resumeMusic(){
        if(mIsBackgroundMusicServiceBound){
            if(mBackgroundMusicService.getIsIntroMusicPaused()){
                mBackgroundMusicService.resumeGameMusic();
            } else {
                mBackgroundMusicService.startGameMusic();
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
