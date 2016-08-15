package com.example.raf0c.fallingwordsgame.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.raf0c.fallingwordsgame.R;
import com.example.raf0c.fallingwordsgame.utils.Constants;

/**
 * Created by raf0c on 14/08/16.
 * Class for abstracting our GameLayoutView
 */
public class GameLayoutView extends RelativeLayout {

    private Listener mListener;

    private RelativeLayout mRootLayout;     // The whole container
    private TextView mCurrentWordTv;        // The word in the middle of the screen
    private TextView mWarningCountDownTv;   // The numbers in the middle of the screen to prepare the player for starting a game
    private TextView mPlayerNameTv;         // The name of the player
    private TextView mWrongScoreTv;         // The score of missed words of the player
    private TextView mCorrectScoreTv;       // The score of correct words of the player

    private int mWarningSecondsLeft = 3;    // The number of seconds for the countdown to prepare the user

    private Handler mWarningCountDownTimer = new Handler();

    public GameLayoutView(Context context) {
        super(context);
    }

    public GameLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * The interface for communication between our view and our activity
     * */
    public interface Listener {
        void onCountDownFinished();
    }

    public void setListener(Listener listener){
        mListener = listener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mRootLayout = (RelativeLayout) findViewById(R.id.root_view);

        mCurrentWordTv        = (TextView) findViewById(R.id.current_word_text_view);
        mWarningCountDownTv   = (TextView) findViewById(R.id.count_down_text_view);
        mPlayerNameTv         = (TextView) findViewById(R.id.player_text_view);
        mWrongScoreTv         = (TextView) findViewById(R.id.wrongs_text_view);
        mCorrectScoreTv       = (TextView) findViewById(R.id.corrects_text_view);

    }

    /**
     * Add a view to our container
     * @param view the desired view to add to our container
     * */
    public void addFallingWord(View view){
        mRootLayout.addView(view);
    }

    /**
     * Change the color of our container
     * @param color the desired color for the background of the container
     * */
    public void changeBackgroundColor(int color){
        mRootLayout.setBackgroundColor(color);
    }

    /**
     *Update the player name
     * @param playerName the new name to update
     * */
    public void updatePlayerName(String playerName){
        mPlayerNameTv.setText(String.format(getResources().getString(R.string.player_message), playerName));
    }

    /**
     * Update the player wrong score
     * @param wrongScore the number of errors
     * */
    public void updatePlayerWrongScore(int wrongScore){
        mWrongScoreTv.setText(String.format(getResources().getString(R.string.wrong_score), wrongScore));
    }

    /**
     * Update the player correct score
     * @param correctScore the number of success
     * */
    public void updatePlayerCorrectScore(int correctScore){
        mCorrectScoreTv.setText(String.format(getResources().getString(R.string.correct_score), correctScore));
    }

    /**
     * Clear our current word displayed
     * */
    public void clearCurrentQuestionWord(){
        mCurrentWordTv.setText("");
    }

    /**
     * Get the text displayed of the word to be answered
     * */
    public String getCurrentQuestionWord(){
        return mCurrentWordTv.getText().toString();
    }

    /**
     * Set a new word to be answered
     * @param newWord the newWord to be answered
     * */
    public void setCurrentQuestionWord(String newWord){
        mCurrentWordTv.setText(newWord);
    }

    /**
     * Start a warning countdown to prepare the player
     * */
    public void startCountDown(){
        warningCountDownTimer();
    }

    /**
     * Cancel the warning countdown
     * */
    public void cancelCountDown(){
        mWarningCountDownTimer.removeCallbacks(mCountDown);
    }

    /**
     * This runnable updates and animates the countdown
     * and when it reaches 0 it removes our number
     * and notifies that the countdown is finished
     * */
    private final Runnable mCountDown = new Runnable() {
        public void run() {
            mWarningCountDownTv.setVisibility(View.VISIBLE);
            if (mWarningSecondsLeft > 0) {
                mWarningCountDownTv.setText(String.valueOf(mWarningSecondsLeft));
                animateViewFadeAndScale(mWarningCountDownTv);
                mWarningSecondsLeft--;
            } else {
                mWarningCountDownTv.setVisibility(View.GONE);
                if(mListener != null){
                    mListener.onCountDownFinished();
                }
            }
        }
    };

    /**
     * Method to execute the countdown
     * */
    private void warningCountDownTimer(){
        for (int i = 0; i <= mWarningSecondsLeft; i++) {
            mWarningCountDownTimer.postDelayed(mCountDown, i * Constants.ONE_SECOND);
        }
    }

    /**
     * Simple animation to scale and fade a view
     * */
    private void animateViewFadeAndScale(View view){
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setDuration(Constants.ONE_SECOND).start();
    }


}
