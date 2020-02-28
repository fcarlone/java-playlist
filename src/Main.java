import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

//  Array of albums
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        System.out.println("Main Class");

/*
        Test Playlist
*/

//      Create an album
        Album album = new Album("The Joshua Tree", "U2");
//      Add songs to album
        album.addSong("Where the Streets Has No Name", 5.2);
        album.addSong("I Still Haven't Found What I'm Looking For", 4.2);
        album.addSong("With or Without You", 6.21);
        album.addSong("Bullet the Blue Sky", 2.53);
        album.addSong("Running to Stand Still", 8.53);
        album.addSong("Red Hill Mining Town", 3.12);
//      Add albums to array
        albums.add(album);

//      Create an album
        album = new Album("For Those About to Rock", "AC/DC");
        //      Add songs to album
        album.addSong("I Put a Finger on You", 4.24);
        album.addSong("Lets Go", 7.53);
        album.addSong("C.O.D", 3.2);
        album.addSong("Breaking the Rules", 2.53);
        album.addSong("Inject the Venom", 5.42);
        album.addSong("Dog Eat Dog", 2.52);
//      Add albums to array
        albums.add(album);

//      Create the playlist LinkedList
        LinkedList<Song> playList = new LinkedList<Song>();

//      Add songs to the playlist
        albums.get(0).addSongToPlaylist("With or Without You", playList);
        albums.get(0).addSongToPlaylist("Red Hill Mining Town", playList);
        albums.get(0).addSongToPlaylist("I Still Haven't Found What I'm Looking For", playList);
        albums.get(0).addSongToPlaylist("Wrong Name", playList); // Does not exists
        albums.get(0).addSongToPlaylist(1, playList);
        albums.get(1).addSongToPlaylist(2, playList);
        albums.get(1).addSongToPlaylist(5, playList);
        albums.get(1).addSongToPlaylist(100, playList); // Does not exists

        play(playList);
    }
    //      Play method
    private static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing -> " + listIterator.next().toString());
        }

    }
}
