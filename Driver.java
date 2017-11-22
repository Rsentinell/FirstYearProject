
/**
 * Write a description of class TempMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main (String[] args){
        /** Demonstration of our Track class. 
         */
        // Set up first Track with this track we can check function of Track file and
        // methods in this file.

        // Creat new variable of track
        Track firstTrack;

        // Assign values to variables firstTrack ("Title" "Artist" "year of production" "length"
        firstTrack = new Track("Power","Little Mix feat. Stormzy",2017,185);

        // Testin set/get methods of Track file
        System.out.println(firstTrack.getTitle());
        firstTrack.setTitle("Frantic");
        System.out.println(firstTrack.getTitle() + "\n");
        System.out.println(firstTrack.getArtist());
        firstTrack.setArtist("Metallica");
        System.out.println(firstTrack.getArtist() + "\n");
        System.out.println(firstTrack.getYear());
        firstTrack.setYear(2003);
        System.out.println(firstTrack.getYear() + "\n");
        System.out.println(firstTrack.getDuration());
        firstTrack.setDuration(350);
        System.out.println(firstTrack.getDuration() + "\n");
        
        // This show use of toString method
        System.out.println(firstTrack + "\n");

        /** Demonstration of our Playlist class 
         */

        // Inicilase new playlist and giving this playlist name "musicWithAMessage"
        // Also test one of constructor. The one where is name of playlist past in constructor.
        Playlist musicWithAMessage = new Playlist("musicWithAMessage"); 

        System.out.printf("Play list name is: %s \n" , musicWithAMessage.getPlaylistName());

        // Filling musicWithAMessage playlist with some tracks.
        // This also testing add song to playlist method together with creating new track.
        musicWithAMessage.add(new Track("Desperado","The Eagles",1973,255));
        musicWithAMessage.add(new Track("The Dance","Garth Brooks",1989,213));
        musicWithAMessage.add(new Track("The Living Years","Mike & The Mechanics",1988,213));
        musicWithAMessage.add(new Track("Imagine", "John Lennon",1987, 188));
        musicWithAMessage.add(new Track("The Times They are a Changin'","Bob Dylan",1964,179));
        musicWithAMessage.add(new Track("_Desperado","eagles",1973,255));
        musicWithAMessage.add(new Track("_The Dance","Garth Brooks",1989,213));
        musicWithAMessage.add(new Track("_The Living Years","Mike & The Mechanics",1988,213));
        musicWithAMessage.add(new Track("_Imagine", "John Lennon",1988, 188));
        musicWithAMessage.add(new Track("_The Times They are a Changin'","Bob Dylan",1964,179));

        System.out.print(musicWithAMessage);
        System.out.printf("\nThis playlist has: %d Tracks.\n", musicWithAMessage.getTrackCount());

        // Testing second constructor without playlist name on that case playlist wil get name 
        // -tag "Unknown".
        Playlist bestOf2017 = new Playlist();
        // Filling new playlist with 100 tracks also testing if mehod is able conatin 100 items.
        for (int i = 0; i < 10; i++){
            bestOf2017.add(new Track("Sign Of The Times","Harry Styles",2017,175));
            bestOf2017.add(new Track("Back To You","Louis Tomlinson feat. Bebe Rexha & Digital Farm Animals",2017,183));
            bestOf2017.add(firstTrack);
            bestOf2017.add(new Track("Slow Hands","Niall Horan",2017,188));
            bestOf2017.add(new Track("Touch","Little Mix",2017,191));
            bestOf2017.add(new Track("Shape Of You","Ed Sheeran",2017,202));
            bestOf2017.add(new Track("The Cure","Lady Gaga",2017,195));
            bestOf2017.add(new Track("Power","Little Mix feat. Stormzy",2017,185));
            bestOf2017.add(new Track("Dusk Till Dawn","ZAYN feat. Sia",2017,201));
            bestOf2017.add(new Track("There's Nothing Holdin' Me Back","Shawn Mendes",2017,207));
        }
        
        // Testing toString method on bestOf2017 playlist
        System.out.println(bestOf2017);
        
        
        // Testing showList mehtod and remove method.
        // Remove method is tested for both variation if position is epty or not occupy�.
        System.out.println(musicWithAMessage.showList());
        musicWithAMessage.remove(7);
        System.out.println(musicWithAMessage.remove(15) + "\n");
        System.out.println(musicWithAMessage.showList() 
             + "\nOn second showList we can see it's only 9 tracks because  No. 7 was removed");
        
        // For testing empty showList method i created new extra playliust  
        Playlist testingShowList = new Playlist();
        System.out.println("\n" + testingShowList.showList() + "\n");
        
        // Testing playAll method, with passing value "true" which should shuld shuffle
        // songs in playlist
        musicWithAMessage.playAll(true);
        
        // Testing playIf method with passing value "Eagles" it should play two songs.
        System.out.println();
        musicWithAMessage.playIf("Eagles");
        System.out.println();
        musicWithAMessage.playIf(1988);
    }
}
