package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongList extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        list = findViewById(R.id.songlist);

        ArrayList<Song> songs =  new ArrayList<>();
        songs.add(new Song(1,R.drawable.m1,"If You're Happy and You Know It","abc"));
        songs.add(new Song(2,R.drawable.m2,"Twinkle Twinkle Little Star","abc"));
        songs.add(new Song(3,R.drawable.m3,"Mary Had A Little Lamb","abc"));
        songs.add(new Song(4,R.drawable.m4,"London Bridge is Falling Down","abc"));
        songs.add(new Song(5,R.drawable.m5,"Old McDonald Had a Farm","abc"));
        songs.add(new Song(6,R.drawable.m6,"London Bridge is Falling Down","abc"));
        songs.add(new Song(7,R.drawable.m7,"Old McDonald Had a Farm","abc"));


        SongAdapter adp = new SongAdapter(this,R.layout.item_layout,songs);
        list.setAdapter(adp);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Song clickedSong = (Song) list.getItemAtPosition(i);

                Intent intent = new Intent(SongList.this,AudioPlayer.class);
                Bundle bd = new Bundle();
                bd.putInt("songId",clickedSong.getSongId());

                intent.putExtras(bd);
                startActivity(intent);

            }
        });

    }
}