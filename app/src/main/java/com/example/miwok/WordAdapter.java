package com.example.miwok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{
    public WordAdapter(Activity context, ArrayList<Word> numbers){
        super(context,0,numbers);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word currentWord = getItem(position);
        TextView miwokNumbers = listItemView.findViewById(R.id.miwok_textView);
        miwokNumbers.setText(currentWord.getMiwokWord());
        TextView englishNumbers = listItemView.findViewById(R.id.english_textView);
        englishNumbers.setText(currentWord.getEnglishWord());
        return listItemView;
    }
}
