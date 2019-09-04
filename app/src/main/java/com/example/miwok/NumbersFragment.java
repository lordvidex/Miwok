package com.example.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class NumbersFragment extends Fragment {
    private MediaPlayer mMediaPlayer;
    MediaPlayer.OnCompletionListener listener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    //AudioManager to effectively manage AudioFocus
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                //Pause the playback
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }else if(focusChange==AudioManager.AUDIOFOCUS_GAIN){
                //Resume the playback
                mMediaPlayer.start();
            }else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                //Stop the playback
                releaseMediaPlayer();
            }
        }

    };



    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("lutti", "one", R.drawable.number_one,R.raw.number_one));
        numbers.add(new Word("otiiko", "two", R.drawable.number_two,R.raw.number_two));
        numbers.add(new Word("tolookosu", "three", R.drawable.number_three,R.raw.number_three));
        numbers.add(new Word("oyyisa", "four", R.drawable.number_four,R.raw.number_four));
        numbers.add(new Word("massokka", "five", R.drawable.number_five,R.raw.number_five));
        numbers.add(new Word("temmokka", "six", R.drawable.number_six,R.raw.number_six));
        numbers.add(new Word("kenekaku", "seven", R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new Word("kawinta", "eight", R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new Word("wo'e", "nine", R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new Word("na'aacha", "ten", R.drawable.number_ten,R.raw.number_ten));
        ListView listView = rootView.findViewById(R.id.rootView);
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), numbers, R.color.category_numbers);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word currentWord = numbers.get(position);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        //Use the Music Stream
                        AudioManager.STREAM_MUSIC,
                        //Request permanent focus
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //We have Audio Focus now and can now Start Playback

                    mMediaPlayer = MediaPlayer.create(getActivity(), currentWord.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(listener);

                }
            }
        });

        return rootView;
    }
    private void releaseMediaPlayer(){
        if(mMediaPlayer!=null) {
            //free the space and audio resource of the mediaPlayer class
            mMediaPlayer.release();
            //set the mMediaPlayer to null..
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
