package com.example.raf0c.fallingwordsgame;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.example.raf0c.fallingwordsgame.model.Word;
import com.example.raf0c.fallingwordsgame.service.BackgroundMusicService;
import com.example.raf0c.fallingwordsgame.utils.Constants;
import com.example.raf0c.fallingwordsgame.utils.Utils;
import com.example.raf0c.fallingwordsgame.views.GameLayoutView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity implements GameLayoutView.Listener {

    private BackgroundMusicService mBackgroundMusicService;
    private boolean mIsBackgroundMusicServiceBound = false;

    private List<Word> mWordsBank; // All words found on the json file


    private String mPlayerName;

    private GameLayoutView mGameLayoutView;


    private static final String JSONFILE_NAME = "words.json";
    private static final String ENGLISH_TAG   = "text_eng";
    private static final String SPANISH_TAG   = "text_spa";
    private static final String TAG = GameActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        mGameLayoutView = (GameLayoutView) findViewById(R.id.game_layout_id);
        mGameLayoutView.setListener(this);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            mPlayerName= null;
        } else {
            mPlayerName = extras.getString(Constants.PLAYER_KEY);
        }

        mGameLayoutView.updatePlayerName(mPlayerName);

        Intent startBackgroundMusicService = new Intent(this, BackgroundMusicService.class);
        bindService(startBackgroundMusicService, mBackgroundMusicServiceConnection, Context.BIND_AUTO_CREATE);

        mGameLayoutView.startCountDown();

        mWordsBank = new ArrayList<>();

        new PopulateWordsBank().execute();

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
        mGameLayoutView.cancelCountDown();
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

    @Override // GameLayoutView.Listener method
    public void onCountDownFinished() {
        for (Word word: mWordsBank) {
            Log.d(TAG, "The word is : " + word.getQuestionLanguage() + " - " + word.getAnswerLanguage());
        }
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

    /**
     * Task to populate the words bank
     * */
    private class PopulateWordsBank extends AsyncTask<Void,Void,Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            try {

                JSONArray jsonArr = new JSONArray(Utils.readFileFromAssets(GameActivity.this, JSONFILE_NAME));

                for (int i = 0; i < jsonArr.length(); i++) {

                    JSONObject jsonObj = (JSONObject) jsonArr.get(i);
                    Word word = new Word(jsonObj.get(SPANISH_TAG).toString(), jsonObj.get(ENGLISH_TAG).toString());
                    mWordsBank.add(word);

                }
            } catch (JSONException e) {
                Log.e(TAG, e.getMessage());
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                mGameLayoutView.startCountDown();
            } else {
                Log.e(TAG, "Error on the JSONFile");
            }
        }
    }
}
