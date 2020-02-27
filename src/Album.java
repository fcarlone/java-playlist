import java.util.ArrayList;

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

}
