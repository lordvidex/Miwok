package com.example.miwok;

public class Word {
    private String mMiwokWord;
    private String mEnglishWord;

    public Word(String miwokWord, String englishWord) {
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
    }

    public String getMiwokWord() {
        return mMiwokWord;
    }

    public String getEnglishWord() {
        return mEnglishWord;
    }
}
