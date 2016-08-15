package com.example.raf0c.fallingwordsgame.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by raf0c on 14/08/16.
 */
public final class Utils {

    /**
     * readFileFromAssets
     * Method that retrieves the file from the Assets folder
     * and return a String object.
     * @param context the context from where this method gets called
     * @param fileName the name of the file
     * @return a string object
     * */
    public static String readFileFromAssets(Context context, String fileName){
        String result = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            result = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return result;
    }

}
