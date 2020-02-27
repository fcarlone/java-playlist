import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private String artist;
    private ArrayList<Song> songs;

//  Constructor
    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
//      Initialize array
        this.songs = new ArrayList<Song>();
    }

//  Add song
    public boolean addSong(String songName, double songDuration) {
        if(findSong(songName) == null) {
            this.songs.add(new Song(songName, songDuration));
            return true;
        }
        return false;
    }

//  Query a song
    private Song findSong(String songName) {
//      For-each loop
        for(Song checkedSong: this.songs) {
            if(checkedSong.getSongName().equals(songName)){
                return checkedSong;
            }
        }
        return null;
    }

//  Add song to playlist
    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;
        if((index >= 0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addSongToPlaylist(String songName, LinkedList<Song> playList) {
        Song checkedSong = findSong(songName);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + songName + " is not in this album");
        return false;
    }
}
