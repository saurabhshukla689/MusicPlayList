package org.example;

import java.util.*;

public class MusicPlaylist {
    private Queue<String> recentlyPlayedSongs;
    private int capacity;

    public MusicPlaylist(int capacity) {
        this.capacity = capacity;
        this.recentlyPlayedSongs = new LinkedList<>();
    }

    public void addSong(String song) {
        if (recentlyPlayedSongs.size() >= capacity) {
            recentlyPlayedSongs.poll(); // Remove the oldest song if capacity is reached
        }
        recentlyPlayedSongs.offer(song); // Add the new song
    }

    public List<String> returnRecentSongs() {
        System.out.println("Recently Played Songs:");
        return new ArrayList<>(recentlyPlayedSongs);
    }


    public void printRecentSongs() {
        System.out.println("Recently Played Songs:");
        for (String song : recentlyPlayedSongs) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        int n = 3; // initial capacity
        MusicPlaylist playlist = new MusicPlaylist(n);



        playlist.addSong("Song 1");
        playlist.addSong("Song 2");
        playlist.addSong("Song 3");
        playlist.addSong("Song 4");

        playlist.printRecentSongs();
    }
}
