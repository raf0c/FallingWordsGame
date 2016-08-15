package com.example.raf0c.fallingwordsgame.model;

/**
 * Created by raf0c on 14/08/16.
 * This class is the model of each word item
 */
public class Word {

    String answerLanguage;
    String questionLanguage;

    /**
     * Class constructor
     * @param answerLanguage the language of the falling word
     * @param questionLanguage the language of the middle word
     * */
    public Word(String answerLanguage, String questionLanguage) {
        this.answerLanguage = answerLanguage;
        this.questionLanguage = questionLanguage;
    }

    public String getAnswerLanguage() {
        return answerLanguage;
    }

    public void setAnswerLanguage(String answerLanguage) {
        this.answerLanguage = answerLanguage;
    }

    public String getQuestionLanguage() {
        return questionLanguage;
    }

    public void setQuestionLanguage(String questionLanguage) {
        this.questionLanguage = questionLanguage;
    }
}
