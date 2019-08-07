package com.example.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> numbers, int colorResourceId) {
        super(context, 0, numbers);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        /*Getting the position of the current Item in the listView
        ** args currentWord;
         */
        Word currentWord = getItem(position);
        /*
        TextView containing MiWok Word
         */
        TextView miwokNumbers = listItemView.findViewById(R.id.miwok_textView);
        miwokNumbers.setText(currentWord.getMiwokWord());

        TextView englishNumbers = listItemView.findViewById(R.id.english_textView);
        englishNumbers.setText(currentWord.getEnglishWord());


        ImageView imageResource = listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageResource.setImageResource(currentWord.getImageResourceId());
            imageResource.setVisibility(View.VISIBLE);
        } else {
            imageResource.setVisibility(View.GONE);
        }

        View textViews = listItemView.findViewById(R.id.textContainer);
        textViews.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));
        return listItemView;
    }
}
