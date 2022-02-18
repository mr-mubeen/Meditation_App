package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class AudioPlayer extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    ImageView img;
    TextView start,end;
    int totalDuration,currentDuration;
    SeekBar volumeBar;

    Handler myHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        int getID = getIntent().getIntExtra("points" , 1);
        int id = 1;
        if (getID >= 5)
        {
            id = 2;
        }

        img= findViewById(R.id.imageView3);

        Bundle bd = getIntent().getExtras();
//        int songId = bd.getInt("songId");
        int songId = id;


        switch (songId)
        {
            case 1:
                mediaPlayer = MediaPlayer.create(this,R.raw.happy);
                img.setImageResource(R.drawable.m1);
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this,R.raw.twinkle);
                img.setImageResource(R.drawable.m2);
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this,R.raw.mary);
                img.setImageResource(R.drawable.m3);
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this,R.raw.london);
                img.setImageResource(R.drawable.m4);
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this,R.raw.mcdonald);
                img.setImageResource(R.drawable.m5);
            case 6:
                mediaPlayer = MediaPlayer.create(this,R.raw.london);
                img.setImageResource(R.drawable.m6);
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(this,R.raw.mcdonald);
                img.setImageResource(R.drawable.m7);
                break;

        }



        volumeBar = findViewById(R.id.seekBar);

        start = findViewById(R.id.sttime);
        end = findViewById(R.id.entime);


        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

         totalDuration = mediaPlayer.getDuration();
        currentDuration = mediaPlayer.getCurrentPosition();

        int a = (int) TimeUnit.MILLISECONDS.toMinutes(totalDuration);
        int b = (int) (TimeUnit.MILLISECONDS.toSeconds(totalDuration) - TimeUnit.MINUTES.toSeconds(a));

        int c = (int) TimeUnit.MILLISECONDS.toMinutes(currentDuration);
        int d = (int) (TimeUnit.MILLISECONDS.toSeconds(currentDuration) - TimeUnit.MINUTES.toSeconds(c));

        end.setText(String.format("%d:%d",a,b));
        start.setText(String.format("%d:%d",c,d));

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeBar.setMax(maxVolume);
        volumeBar.setProgress(currentVolume);

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private Runnable UpdateAudioTime = new Runnable() {
        @Override
        public void run() {

            currentDuration = mediaPlayer.getCurrentPosition();
            int c = (int) TimeUnit.MILLISECONDS.toMinutes(currentDuration);
            int d = (int) (TimeUnit.MILLISECONDS.toSeconds(currentDuration) - TimeUnit.MINUTES.toSeconds(c));
            start.setText(String.format("%d:%d",c,d));

            myHandler.postDelayed(UpdateAudioTime,100);
        }
    };



    public void goPlay(View view)
    {
        mediaPlayer.start();
        Toast.makeText(this,"Audio Playing",Toast.LENGTH_LONG).show();

        myHandler.postDelayed(UpdateAudioTime,100);
    }

    public void goPause(View view)
    {
        mediaPlayer.pause();
        Toast.makeText(this,"Audio Paused",Toast.LENGTH_LONG).show();
    }

    public void goStop(View view)
    {
        mediaPlayer.stop();
        Toast.makeText(this,"Audio Stopped",Toast.LENGTH_LONG).show();
    }
}