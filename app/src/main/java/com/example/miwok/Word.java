package com.example.miwok;


public class Word {
    private String mMiwokWord;
    private String mEnglishWord;
    private int mAudioResourceId;
    private int mImageResourceId = noImage;
    private static final int noImage = -1;

    public Word(String miwokWord, String englishWord,int audioResourceId) {
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
        mAudioResourceId = audioResourceId;
    }

    public Word(String miwokWord, String englishWord,int imageResourceId,int audioResourceId) {
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
        mAudioResourceId = audioResourceId;
        mImageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != noImage;
    }

    public String getMiwokWord() {
        return mMiwokWord;
    }

    public String getEnglishWord() {
        return mEnglishWord;
    }
}
