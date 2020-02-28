public class Song {
    private String songName;
    private double songDuration;

//  Constructor
    public Song(String songName, double songDuration) {
        this.songName = songName;
        this.songDuration = songDuration;
    }

    public String getSongName() {
        return songName;
    }

    @Override
    public String toString() {
        return songName + ": " + songDuration;
//        return "Song{" +
//                "songName='" + songName + '\'' +
//                ", songDuration=" + songDuration +
//                '}';
    }
}
