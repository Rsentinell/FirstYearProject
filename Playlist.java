
/**
 * Write a description of class PlayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

/**
 * PLAYLIST CLASS
 * The Playlist class will be used to store a list of the tracks that the user wants to play. In our simple system a playlist can have up to 100 tracks. 
 * At any time the number of tracks in a playlist can be zero (the playlist is empty) or some number between 1 and 100 (the playlist is full). Each playlist 
 * will store the following information (i.e. instance values)
 * •	A String for the name of the playlist
 * •	An int for the number of tracks currently in the list
 * •	An array of Track objects (used to store the list) capable of storing 100 items 
 * The Playlistclass should support/provide the following operations/methods
 * •	A constructor method to create an empty Playlist capable of storing up to 100 Tracks.
 * •	A toString method that can be used to return the instance values in a readable format.
 * •	An add method to allow a new track to be added to the list. Tracks are ALWAYS added to the end of the list. If the list is full (i.e. already has the 
 * maximum number of tracks permitted) the track should not be added and the method should return false. If the track is successfully added to the list the method 
 * should increment the number of tracks in the list and return true.
 * The add method header is overloaded as follows

 * public boolean add(String title, String artist,
                   int year, int duration)
 * public boolean add(Track t)
 * •	A remove method to allow unwanted tracks be deleted from the playlist. The remove header is as follows 
 * public boolean remove(int trackPos)
 * The method is passed an integer position value.
 * If there is no track at the position specified (i.e. if the position value is negative or greater than the number of tracks currently in the list) then the 
 * method should return false and the list should be left unchanged.
 * If there is a track at the position specified then it should be removed and all the tracks in the positions above it should be moved down one position. In 
 * addition, the number of tracks in the list should be reduced by one. 
 * •	A showList method that displays the playlist on the screen in sequential order (i.e. in the order that the tracks appear in the list). The showList header
 *  is as follows
 * public showList()
 * Remember, the list can have up to 100 entries but most of the time it is likely to have less than 100 entries. The method should only display the tracks 
 * currently in the list. If there are no tracks in the list the method should display the message “The list is empty”. 
 * •	A playAll method that plays all the tracks in the list either in sequence or randomly. 
 * Passing the value false as a parameter plays the tracks sequentially (i.e. in the sequence they appear in the list).  
 * Passing the value true as a parameter plays the tracks randomly. When playing tracks randomly each track should be played only once. In addition, playing the 
 * tracks randomly should NOT alter the sequence of the tracks in the list.
 * The method header is as follows 
 * public play(boolean random)
 * •	A playIf method that plays tracks in the list that satisfy specified criteria. The playIf method is overloaded as follows
 * public playIf(String artist)
 * public playIf(int year)
 * The first method will play all tracks in the list that contain the text specified (upper or lower case) in the artist name. For example, playIf(“eagles”) or 
 * playIf(“EAGLES”) or playIf(“THE eagles”) should play all the tracks in the list that have the specified strings somewhere/anywhere in the artist name.
 * The second method will play all tracks that were released in the specified year. 
 * The tracks should be played in the sequence they appear in the list.
 * If none of the tracks match the specified value then no output should be produced.
 * We can’t actually play the tracks so for testing purposes displaying the track details on the screen will be considered equivalent to playing the track.
 * You may find it useful to develop additional methods that help simplify or improve the efficiency of some operations.

 */
public class Playlist
{
    private String playlistName;
    private int trackCount;
    private Track[] playlist;
    
    //Constructors
    
    public Playlist(){
        this.playlist = new Track[100];
    }
    
    /**public getPlaylist(int y){
    
        return playlist [y];
    }
    **/
}
