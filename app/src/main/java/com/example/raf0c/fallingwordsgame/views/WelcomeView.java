package com.example.raf0c.fallingwordsgame.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.raf0c.fallingwordsgame.R;

/**
 * Created by raf0c on 14/08/16.
 * Class for abstracting the view of our Welcome Screen
 */
public class WelcomeView extends RelativeLayout {

    private Listener mListener;

    /**
     * The interface for communication between our view and our activity
     * */
    public interface Listener {
        void onStartRequested(String name);
    }

    public WelcomeView(Context context) {
        super(context);
    }

    public WelcomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setListener(Listener listener){
        mListener = listener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Button gameStart = (Button) findViewById(R.id.start_button);

        final EditText nameEditText = (EditText) findViewById(R.id.player_name);

        gameStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){

                    if(!isEmpty(nameEditText)){ // If EditText is not empty, allow notify to the activity
                        mListener.onStartRequested(nameEditText.getText().toString());
                        nameEditText.setText("");
                    } else { // If EditText is empty, displayError
                        nameEditText.setError("Please enter your name!");
                    }
                }
            }
        });

    }

    /**
     * Method to validate if an EditText is empty
     * @param editText the EditText to validate
     * */
    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().length() == 0;
    }

}
