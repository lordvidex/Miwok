package com.example.miwok;

import android.media.Image;

public class Word {
    private String mMiwokWord;
    private String mEnglishWord;
    private int mImageResourceId = noImage;
    private static final int noImage = -1;

    public Word(String miwokWord, String englishWord) {
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
    }
    public Word(String miwokWord, String englishWord,int imageResourceId) {
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
        mImageResourceId = imageResourceId;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId!=noImage;
    }
    public String getMiwokWord() {
        return mMiwokWord;
    }

    public String getEnglishWord() {
        return mEnglishWord;
    }
}
