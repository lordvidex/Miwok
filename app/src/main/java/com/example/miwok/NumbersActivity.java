package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word>numbers = new ArrayList<>();
        numbers.add(new Word("lutti","one"));
        numbers.add(new Word("otiiko","two"));
        numbers.add(new Word("tolookosu","three"));
        numbers.add(new Word("oyyisa","four"));
        numbers.add(new Word("massokka","five"));
        numbers.add(new Word("temmokka","six"));
        numbers.add(new Word("kenekaku","seven"));
        numbers.add(new Word("kawinta","eight"));
        numbers.add(new Word("wo'e","nine"));
        numbers.add(new Word("na'aacha","ten"));
        ListView rootView  = findViewById(R.id.rootView);
        WordAdapter itemsAdapter = new WordAdapter(this,numbers);
        rootView.setAdapter(itemsAdapter);
    }



}

