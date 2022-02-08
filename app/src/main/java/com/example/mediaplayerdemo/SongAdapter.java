package com.example.mediaplayerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song>
{


    public SongAdapter(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Song song = getItem(position);

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =  layoutInflater.inflate(R.layout.item_layout,null);

        TextView name = convertView.findViewById(R.id.songName);
        TextView artist = convertView.findViewById(R.id.songArtist);
        ImageView image = convertView.findViewById(R.id.coverImg);


        name.setText(song.getSongTitle());
        artist.setText(song.getSongArtist());
        image.setImageResource(song.getCoverImage());

        return convertView;
    }
}
