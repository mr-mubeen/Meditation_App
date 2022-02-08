package com.example.mediaplayerdemo;

public class Song {


    private int songId;
    private int coverImage;
    private String songTitle;
    private String songArtist;


    public Song (int id,int img, String title, String artist)
    {
        songId=id;
        coverImage = img;
        songTitle = title;
        songArtist = artist;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongTitle() {
        return songTitle;
    }
}
