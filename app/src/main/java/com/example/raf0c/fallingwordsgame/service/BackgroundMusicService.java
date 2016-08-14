package com.example.raf0c.fallingwordsgame.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.raf0c.fallingwordsgame.R;

/**
 * Created by raf0c on 14/08/16.
 */
public class BackgroundMusicService extends Service {

    private final IBinder mBackgroundMusicServiceBinder = new BackgroundMusicServiceBinder();
    private MediaPlayer mIntroGameSongPlayer = null;
    private MediaPlayer mGameMusicPlayer = null;
    private int mIntroMusicLength = 0;
    private int mGameMusicLength = 0;
    private boolean mIsIntroMusicPaused = false;
    private boolean mIsGameMusicPaused = false;

    private static final String TAG = BackgroundMusicService.class.getSimpleName();

    public class BackgroundMusicServiceBinder extends Binder {

        public BackgroundMusicService getService() {
            return BackgroundMusicService.this;
        }
    }

    @Override
    public void onCreate (){
        super.onCreate();
        initializeMediaPlayers();
    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBackgroundMusicServiceBinder;
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        if(mIntroGameSongPlayer != null) {
            try{
                mIntroGameSongPlayer.stop();
                mIntroGameSongPlayer.release();
            }finally {
                mIntroGameSongPlayer = null;
            }
        }
        if(mGameMusicPlayer != null) {
            try{
                mGameMusicPlayer.stop();
                mGameMusicPlayer.release();
            }finally {
                mGameMusicPlayer = null;
            }
        }
    }

    public void startIntroMusic() {
        if(mIntroGameSongPlayer != null){
            mIntroGameSongPlayer.start();
            setIntroMusicPaused(false);
        } else {
            setIntroMusicPaused(false);
            Log.d(TAG, " startIntroMusic() - mIntroGameSongPlayer is null ");
        }
    }

    public void pauseIntroMusic() {
        if(mIntroGameSongPlayer != null) {
            if(mIntroGameSongPlayer.isPlaying()) {
                mIntroGameSongPlayer.pause();
                setIntroMusicPaused(true);
                mIntroMusicLength = mIntroGameSongPlayer.getCurrentPosition();
            }
        } else {
            setIntroMusicPaused(false);
            Log.d(TAG, "pauseIntroMusic() - mIntroGameSongPlayer is null ");
        }

    }

    public void resumeIntroMusic() {
        if(mIntroGameSongPlayer != null) {
            if(!mIntroGameSongPlayer.isPlaying()) {
                mIntroGameSongPlayer.seekTo(mIntroMusicLength);
                mIntroGameSongPlayer.start();
                setIntroMusicPaused(false);
            }
        } else {
            setIntroMusicPaused(false);
            Log.d(TAG, "resumeIntroMusic() - mIntroGameSongPlayer is null ");
        }

    }

    public void stopIntroMusic() {
        if(mIntroGameSongPlayer != null) {
            mIntroGameSongPlayer.stop();
            mIntroGameSongPlayer.release();
            mIntroGameSongPlayer = null;
        } else {
            Log.d(TAG, "stopIntroMusic() - mIntroGameSongPlayer is null ");
        }
    }

    public void startGameMusic() {
        if(mGameMusicPlayer != null){
            mGameMusicPlayer.start();
            setGameMusicPaused(false);
        } else {
            setGameMusicPaused(false);
            Log.d(TAG, "startGameMusic() - mGameMusicPlayer is null ");
        }
    }

    public void pauseGameMusic() {
        if(mGameMusicPlayer != null) {
            if(mGameMusicPlayer.isPlaying()) {
                mGameMusicPlayer.pause();
                setGameMusicPaused(true);
                mGameMusicLength = mGameMusicPlayer.getCurrentPosition();
            }
        } else {
            setGameMusicPaused(false);
            Log.d(TAG, "pauseGameMusic() - mGameMusicPlayer is null ");
        }

    }

    public void resumeGameMusic() {
        if(mGameMusicPlayer != null) {
            if(!mGameMusicPlayer.isPlaying()) {
                mGameMusicPlayer.seekTo(mGameMusicLength);
                mGameMusicPlayer.start();
                setGameMusicPaused(false);
            }
        } else {
            setGameMusicPaused(false);
            Log.d(TAG, "resumeGameMusic() - mGameMusicPlayer is null ");
        }

    }

    public void stopGameMusic() {
        if(mGameMusicPlayer != null) {
            mGameMusicPlayer.stop();
            mGameMusicPlayer.release();
            mGameMusicPlayer = null;
        } else {
            Log.d(TAG, "stopGameMusic() - mGameMusicPlayer is null ");
        }
    }

    public boolean getIsIntroMusicPaused(){
        return mIsIntroMusicPaused;
    }

    public boolean getIsGameMusicPaused(){
        return mIsGameMusicPaused;
    }

    private void setIntroMusicPaused(boolean paused){
        mIsIntroMusicPaused = paused;
    }

    private void setGameMusicPaused(boolean paused){
        mIsGameMusicPaused = paused;
    }


    /**
     * My background music choice
     * EarthBound - Onette Theme
     * Reference : https://www.youtube.com/watch?v=7y5RRgjfNek
     * EarthBound - Choose a File
     * Reference : https://www.youtube.com/watch?v=PL74bvxjYqc
     * I do not own this songs, made it for test purpose.
     * */
    private void initializeMediaPlayers(){

        mIntroGameSongPlayer = MediaPlayer.create(this, R.raw.intro_game_song);
        mIntroGameSongPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                // ... react appropriately ...
                // The MediaPlayer has moved to the Error state, must be reset!
                Toast.makeText(BackgroundMusicService.this, "Music player failed", Toast.LENGTH_SHORT).show();
                if(mIntroGameSongPlayer != null) {
                    try{
                        mIntroGameSongPlayer.stop();
                        mIntroGameSongPlayer.release();
                    }finally {
                        mIntroGameSongPlayer = null;
                    }
                }
                return false;
            }
        });


        if(mIntroGameSongPlayer!= null) {
            mIntroGameSongPlayer.setLooping(true);
            mIntroGameSongPlayer.setVolume(100,100);
        }

        mGameMusicPlayer = MediaPlayer.create(this, R.raw.gamesong);
        mGameMusicPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                // ... react appropriately ...
                // The MediaPlayer has moved to the Error state, must be reset!
                Toast.makeText(BackgroundMusicService.this, "Music player failed", Toast.LENGTH_SHORT).show();
                if(mGameMusicPlayer != null) {
                    try{
                        mGameMusicPlayer.stop();
                        mGameMusicPlayer.release();
                    }finally {
                        mGameMusicPlayer = null;
                    }
                }
                return false;
            }
        });


        if(mGameMusicPlayer!= null) {
            mGameMusicPlayer.setLooping(true);
            mGameMusicPlayer.setVolume(100,100);
        }

    }
}
