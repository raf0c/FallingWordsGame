package com.example.raf0c.fallingwordsgame;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Random;

public class GameActivity extends AppCompatActivity implements GameLayoutView.Listener {

    private BackgroundMusicService mBackgroundMusicService;
    private boolean mIsBackgroundMusicServiceBound = false;
    private List<Word> mWordsBank; // All words found on the json file
    private List<Word> mFallingWords;

    private String mPlayerName;

    private Rect mDisplaySize = new Rect();
    private float mScale;

    private GameLayoutView mGameLayoutView;

    private int mFallingWordIndex = 0;
    private int mWordsMissed;
    private int mWordsCorrect;

    private PopulateWordsBank mPopulateWordsBankTask;

    private static final String PLAYER_WRONG_SCORE_KEY = "wrong_score_key";
    private static final String PLAYER_CORRECT_SCORE_KEY = "correct_score_key";
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

        Display display = getWindowManager().getDefaultDisplay();
        display.getRectSize(mDisplaySize);

        mScale = getResources().getDisplayMetrics().density;

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            mPlayerName= null;
        } else {
            mPlayerName = extras.getString(Constants.PLAYER_KEY);
        }

        if(savedInstanceState != null){// restore player info
            mPlayerName = savedInstanceState.getString(Constants.PLAYER_KEY);
            mWordsMissed = savedInstanceState.getInt(PLAYER_WRONG_SCORE_KEY);
            mWordsCorrect = savedInstanceState.getInt(PLAYER_CORRECT_SCORE_KEY);
        }

        mGameLayoutView.updatePlayerName(mPlayerName);
        mGameLayoutView.updatePlayerWrongScore(mWordsMissed);
        mGameLayoutView.updatePlayerCorrectScore(mWordsCorrect);

        Intent startBackgroundMusicService = new Intent(this, BackgroundMusicService.class);
        bindService(startBackgroundMusicService, mBackgroundMusicServiceConnection, Context.BIND_AUTO_CREATE);

        mWordsBank = new ArrayList<>();
        mFallingWords = new ArrayList<>();

        mPopulateWordsBankTask =  new PopulateWordsBank();
        mPopulateWordsBankTask.execute();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //Save player info
        savedInstanceState.putString(Constants.PLAYER_KEY, mPlayerName);
        savedInstanceState.putInt(PLAYER_WRONG_SCORE_KEY, mWordsMissed);
        savedInstanceState.putInt(PLAYER_CORRECT_SCORE_KEY, mWordsCorrect);
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
        mPopulateWordsBankTask.cancel(true);
        mHandler.removeCallbacks(mDroppingWordsInterval);
        mGameLayoutView.clearCurrentQuestionWord();
        resetFallinWordsBatch();
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
        moveToNextRandomWord();
    }

    private final Runnable mDroppingWordsInterval = new Runnable() {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
        }
    };

    /**
     * Handler to enque our falling words
     * */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            mFallingWordIndex ++;
            if(mFallingWordIndex >= mFallingWords.size()){ // avoid getting the size in the index
                mFallingWordIndex = 0;
            }
            final TextView currentFallingWord = new TextView(GameActivity.this);

            final Word currentFallingWordObject = mFallingWords.get(mFallingWordIndex); // get a random word, even tho this is sequentially, is stored as random
            currentFallingWord.setText(currentFallingWordObject.getAnswerLanguage());
            currentFallingWord.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

            currentFallingWord.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    /**
                     * If the current displayed word is equal to the translation of the current touched word
                     * */
                    if(mGameLayoutView.getCurrentQuestionWord().equals(currentFallingWordObject.getQuestionLanguage())) {
                        mGameLayoutView.changeBackgroundColor(Color.GREEN);
                        Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        mWordsCorrect ++; // Increment in one, the number of correct words
                        checkScore(); // Check how many we got
                        mGameLayoutView.updatePlayerCorrectScore(mWordsCorrect);
                        resetFallinWordsBatch();
                        moveToNextRandomWord();

                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mGameLayoutView.changeBackgroundColor(Color.WHITE);
                            }
                        }, 100);

                    } else {
                        mGameLayoutView.changeBackgroundColor(Color.RED);
                        Toast.makeText(GameActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                        mWordsMissed ++; //Increment the wrong ones by one
                        checkScore(); // Check how many we got
                        mGameLayoutView.updatePlayerWrongScore(mWordsMissed);
                        resetFallinWordsBatch();
                        moveToNextRandomWord();
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mGameLayoutView.changeBackgroundColor(Color.WHITE);
                            }
                        }, 100);

                        Log.e(TAG, "That's not the correct answer");
                    }

                    return false;

                }
            });

            mGameLayoutView.addFallingWord(currentFallingWord); // Add word to the main container

            RelativeLayout.LayoutParams fallingWordLayout = (RelativeLayout.LayoutParams) currentFallingWord.getLayoutParams();
            fallingWordLayout.setMargins(0, (int)(-50*mScale), 0, 0); // Spawn the word above the top margin

            String currentFallingWordTranslated  = "";
            for (int i = 0; i < mFallingWords.size(); i++) { // Get translated word
                if(mFallingWords.get(i).getAnswerLanguage().equals(currentFallingWord.getText())){
                    currentFallingWordTranslated = mFallingWords.get(i).getQuestionLanguage();
                    break;
                }
            }

            startFallingAnimation(currentFallingWord, currentFallingWordTranslated);
        }
    };

    /**
     * Method that receives the textview to animate and the translation of that textview
     * @param fallingWord the TextView to animate
     * @param currentFallingWordTranslated the translation of the textview
     * */
    public void startFallingAnimation(final TextView fallingWord, final String currentFallingWordTranslated) {

        long delay = new Random().nextInt(Constants.MAX_DELAY);
        final ValueAnimator animator = ValueAnimator.ofFloat(0, 1);

        animator.setDuration(Constants.ANIM_DURATION);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setStartDelay(delay);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            int angle = 50 + (int)(Math.random() * 101); //Betweeen 0 and 100
            int moveX = new Random().nextInt(mDisplaySize.right); // value to move across the width of the screen
            boolean wordMissed = false;

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) (animation.getAnimatedValue());
                fallingWord.setRotation(angle * value); // Rotate our TextView to make it less plain, falling down
                fallingWord.setTranslationX((moveX) * value); // Translate across the width
                fallingWord.setTranslationY((mDisplaySize.bottom + (150 * mScale)) * value); // Translate across the screen height

                /**If the word displayed to be answered is equal to the translation of the current one falling
                 * and its Y position is greater than the bottom of the screen
                 * and is not missed yet
                 * */
                if(mGameLayoutView.getCurrentQuestionWord().equals(currentFallingWordTranslated) && (fallingWord.getY() > mDisplaySize.bottom) && (!wordMissed)) {

                    mGameLayoutView.changeBackgroundColor(Color.RED);
                    Toast.makeText(GameActivity.this, "You missed it!", Toast.LENGTH_SHORT).show();
                    mWordsMissed ++; //Increment the wrong ones by one
                    checkScore(); // Check how many we got
                    mGameLayoutView.updatePlayerWrongScore(mWordsMissed);
                    resetFallinWordsBatch();
                    moveToNextRandomWord();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mGameLayoutView.changeBackgroundColor(Color.WHITE);
                        }
                    }, 100);

                    wordMissed = true;
                    Log.e(TAG, "You missed the correct answer");
                }

            }

        });

        animator.start();
    }


    /**
     * Reset falling words list
     * */
    private void resetFallinWordsBatch(){
        mFallingWords.clear();
    }

    /**
     * Reset score of the player
     * */
    private void resetScore(){
        mWordsCorrect = 0;
        mWordsMissed = 0;
        mGameLayoutView.updatePlayerName(mPlayerName);
        mGameLayoutView.updatePlayerWrongScore(mWordsMissed);
        mGameLayoutView.updatePlayerCorrectScore(mWordsCorrect);
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

    /**
     * Display a dialog to interact with the user and allow to retry or quit the game
     * */
    private void displayGameOverDialog(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                mHandler.removeCallbacks(mDroppingWordsInterval);
                dialog.dismiss();
                mGameLayoutView.startCountDown();
                resetScore();
                resetFallinWordsBatch();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetScore();
                dialog.dismiss();
                finish();
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

    /**
     * Method to check if we hit the success goal or the wrong answer limit
     * */
    private void checkScore(){
        if(mWordsCorrect == 5){
            displayGameOverDialog("You rock!", "You passed, you wanna try again?");
        } else if (mWordsMissed == 3){
            displayGameOverDialog("We need to study more!","You failed, you wanna try again?" );
        }

    }

    /**
     * Fills the new batch of falling words without repeating one
     * */
    private void populateFallingWordsBatch() {

        mFallingWords.clear();
        for (int i = 0; i < Constants.MAX_BATCH_CAPACITY; i++) {
            int randomIndex = new Random().nextInt(mWordsBank.size()); // Gets a random index from 0 to the words bank size
            if(!mFallingWords.contains(mWordsBank.get(randomIndex))){ // Checks if we don't have that word
                mFallingWords.add(mWordsBank.get(randomIndex)); // Add the word if it wasn't found
            }
        }

        boolean correctAnswerIsInBatch = false;
        //Look for the correct answer on the falling words batch
        for (int i = 0; i < mFallingWords.size(); i++) {
            if(mFallingWords.get(i).getQuestionLanguage().equals(mGameLayoutView.getCurrentQuestionWord())){
                correctAnswerIsInBatch = true;
                break; // If it actually is inside the falling words batch, then we don't keep searching.
            }
        }

        if(!correctAnswerIsInBatch){ //If it's not in the batch of falling words
            String answer  = "";
            for (int i = 0; i < mWordsBank.size(); i++) { // Look for the correct answer comparing the translation to the current word displayed in the middle to be answered
                if(mWordsBank.get(i).getQuestionLanguage().equals(mGameLayoutView.getCurrentQuestionWord())){
                    answer = mWordsBank.get(i).getAnswerLanguage(); // If we found it, store the answer
                }
            }
            int randomIndex = new Random().nextInt(mFallingWords.size()); // Gets a random index between 0 and the falling words batch size
            //Explicitly put the correct answer inside this batch
            mFallingWords.set(randomIndex, new Word(answer, mGameLayoutView.getCurrentQuestionWord()));//replace a random element to be the correct one

        }

    }

    /**
     * Retrieves a random word from the words bank,
     * when found, replace the word to be answered and populate a new falling words batch
     * */
    private void moveToNextRandomWord(){
        int randomIndex = new Random().nextInt(mWordsBank.size());
        mGameLayoutView.setCurrentQuestionWord(mWordsBank.get(randomIndex).getQuestionLanguage());
        populateFallingWordsBatch();
        mFallingWordIndex = 0;
        for (int i = 0; i < mFallingWords.size(); i++) {
            mHandler.postDelayed(mDroppingWordsInterval, i * Constants.ONE_SECOND);
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
