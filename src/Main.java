import java.util.*;

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

//  Play method
    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;


        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            printMenu();
            System.out.println("Now playing -> " + listIterator.next().toString());
        }

//      Navigate playlist
        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

//          Switch statement
            switch(action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
//                  Advance playlist
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("You reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
//                  Descend playlist
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("You are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("You are at the start of the playlist");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("You have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }

    }
//  Print menu method
    private static void printMenu() {
        System.out.println("Available options: \npress");
        System.out.println("0 - to quit");
        System.out.println("1 - to play next song");
        System.out.println("2 - to play previous song");
        System.out.println("3 - to replay current song");
        System.out.println("4 - list songs in playlist");
        System.out.println("5 - print available options");
        System.out.println("6 - delete current song from playlist");
    }

//   Print list of songs method
    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================\n");
    }
}
