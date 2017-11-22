
/**
 * Write a description of class PlayList here.
 *
 * @author ......................
 * @version (a version number or a date)
 */

/**
 * PLAYLIST CLASS
 * The Playlist class will be used to store a list of the tracks that the user wants to play. 
 * In our simple system a playlist can have up to 100 tracks. 
 * At any time the number of tracks in a playlist can be zero (the playlist is empty) or some number between 1 and 100 (the playlist is full). 
 * Each playlist will store the following information (i.e. instance values)
 * â€¢    A String for the name of the playlist
 * â€¢    An int for the number of tracks currently in the list
 * â€¢    An array of Track objects (used to store the list) capable of storing 100 items 
 * 
 * The Playlistclass should support/provide the following operations/methods
 * â€¢    A constructor method to create an empty Playlist capable of storing up to 100 Tracks.
 * â€¢    A toString method that can be used to return the instance values in a readable format.
 * â€¢    An add method to allow a new track to be added to the list. 
 * Tracks are ALWAYS added to the end of the list. 
 * If the list is full (i.e. already has the maximum number of tracks permitted) the track should not be added and the method should return false. 
 * If the track is successfully added to the list the method should increment the number of tracks in the list and return true.
 * 
 * The add method header is overloaded as follows:
 * 
 * public boolean add(String title, String artist, int year, int duration) <------------
 * public boolean add(Track t)<----------
 * 
 * â€¢    A remove method to allow unwanted tracks be deleted from the playlist. 
 * The remove header is as follows 
 * public boolean remove(int trackPos)
 * The method is passed an integer position value.
 * If there is no track at the position specified (i.e. if the position value is negative or greater than the number of tracks currently in the list) then the 
 * method should return false and the list should be left unchanged.
 * If there is a track at the position specified then it should be removed and all the tracks in the positions above it should be moved down one position. 
 * In addition, the number of tracks in the list should be reduced by one. 
 * 
 * â€¢    A showList method that displays the playlist on the screen in sequential order (i.e. in the order that the tracks appear in the list). 
 * The showList header is as follows
 * public showList()
 * Remember, the list can have up to 100 entries but most of the time it is likely to have less than 100 entries. The method should only display the tracks 
 * currently in the list. If there are no tracks in the list the method should display the message â€œThe list is emptyâ€?. 
 *
 * â€¢    A playAll method that plays all the tracks in the list either in sequence or randomly. 
 * Passing the value false as a parameter plays the tracks sequentially (i.e. in the sequence they appear in the list).  
 * Passing the value true as a parameter plays the tracks randomly. When playing tracks randomly each track should be played only once. In addition, playing the 
 * tracks randomly should NOT alter the sequence of the tracks in the list.
 * The method header is as follows 
 * public play(boolean random)
 * 
 * â€¢    A playIf method that plays tracks in the list that satisfy specified criteria. The playIf method is overloaded as follows
 * public playIf(String artist)
 * public playIf(int year)
 * The first method will play all tracks in the list that contain the text specified (upper or lower case) in the artist name. For example, playIf(â€œeaglesâ€?) or 
 * playIf(“EAGLES”) or playIf(“THE eagles”) should play all the tracks in the list that have the specified strings somewhere/anywhere in the artist name.
 * The second method will play all tracks that were released in the specified year. 
 * The tracks should be played in the sequence they appear in the list.
 * If none of the tracks match the specified value then no output should be produced.
 * We can't actually play the tracks so for testing purposes displaying the track details on the screen will be considered equivalent to playing the track.
 * You may find it useful to develop additional methods that help simplify or improve the efficiency of some operations.

 */
public class Playlist
{
    private String playlistName;
    private int trackCount = 0;
    private Track[] playlist;

    //Constructors
    public Playlist(){       
        this.playlist = new Track[100];
    }

    //This constructor takes a string input and saves it to our playlistName String, This way we can store the name of the playlist when we construct it, instead of using a "set" later. 
    //(the "set" option is still there, just not required) 
    public Playlist(String name){
        this.playlistName = name;        
        this.playlist = new Track[100];
    }

    //Start of "add" methods
    public boolean add(String title, String artist, int year, int duration) {
        if(trackCount < this.playlist.length){
            //This method constructs the Track Object directly onto our Playlist array(If there is space on the Playlist).
            this.playlist[this.trackCount] = new Track(title, artist, year, duration);
            this.trackCount++;
            return true;
        }
        else {
            return false;
        }
    }

    //This method adds a track to the playlist when only the title is supplied, (was created for tests and some "unusual" track constructor calls).
    public boolean add(String title){
        if(trackCount < this.playlist.length){
            //This method constructs the Track Object directly onto our Playlist array(If there is space on the Playlist).
            this.playlist[this.trackCount] = new Track(title);
            this.trackCount++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean add(Track t){
        if(trackCount < this.playlist.length){
            //This method adds an already constructed track to the Playlist array(If there is space on the Playlist)
            this.playlist[this.trackCount] = t;
            this.trackCount++;
            return true;
        } 
        else {
            return false;
        }
    }

    //Remove method
    public boolean remove(int trackPos){
        //This part checks to see if the track position requested exists within our current list of tracks. 
        //If it doesn't then it returns a "false" value.
        if (this.trackCount > 0 && trackPos < this.trackCount && trackPos > 0){
            if(trackPos != 99){ 
                //This for loop shifts all tracks that come after our input position back one position.
                //We are removing the track by overwriting it with the next track.
                //This way all tracks get shifted back a space and we are left with a continuous playlist(no gaps)
                for (int i = trackPos; i < this.trackCount; i++){

                    //this song +1 move to posintion i
                    this.playlist[i - 1] = this.playlist[i];

                }

                //This bit removes the final track in the list, 
                //We do this so that we don't get an extra version of the last track in the list.
                this.trackCount--;
                this.playlist[this.trackCount] = null;

                return true;
            }
            else{
                //This part only happens if we are at the end of the array aka position 99.
                //We don't want to try and copy something that is beyond our array parameters onto our array.
                this.trackCount--;
                this.playlist[this.trackCount] = null;

                return true;
            }
        }
        else {
            return false;
        }
    }

    //Playback methods
    /**    · A playAll method that plays all the tracks in the list either in sequence or randomly.
    Passing the value false as a parameter plays the tracks sequentially 
    (i.e. in the sequence they appear in the list).

    Passing the value true as a parameter plays the tracks randomly. 
    When playing tracks randomly each track should be played only once. 
    In addition, playing the tracks randomly should NOT alter the sequence of the tracks in the list.

    The method header is as follows 

     */
    public String play(boolean random){
        String re = "";

        //This checks the playlist to see if it is empty or not.
        if(trackCount != 0){
            if(random == true){
                int[] shuffle = new int [trackCount];
                int temp, rand1, rand2;

                //This creates an array of numbers that represent track positions
                for(int i = 0; i < trackCount; i++){
                    shuffle[i] = i;
                }

                //This shuffles up the numbers on our new array
                for(int i = 0; i < 200; i++){
                    rand1 = (int)(Math.random()*trackCount);
                    rand2 = (int)(Math.random()*trackCount);

                    temp = shuffle[rand1];  
                    shuffle[rand1] = shuffle[rand2];
                    shuffle[rand2] = temp;

                }

                //This plays all the tracks in the order that has been shuffled
                for (int i = 0; i < trackCount; i++){
                    re += (this.playlist[shuffle[i]] +"\n");
                }
            }
            else{
                //This plays all the tracks in the order they are listed (not shuffled)
                for (int i = 0; i < trackCount; i++){
                    re += (this.playlist[i] +"\n");
                }

            }
        }

        //In case the list is empty
        else{
            re = "The list is empty"; 
        }
        return re;
        //return showList();   <----would this work?
    }

    /* â€¢    A playIf method that plays tracks in the list that satisfy specified criteria. The playIf method is overloaded as follows
     * public playIf(String artist)
     * public playIf(int year)
     * The first method will play all tracks in the list that contain the text specified (upper or lower case) in the artist name. For example, playIf(â€œeaglesâ€?) or 
     * playIf(“EAGLES”) or playIf(“THE eagles”) should play all the tracks in the list that have the specified strings somewhere/anywhere in the artist name.
     * The second method will play all tracks that were released in the specified year. 
     * The tracks should be played in the sequence they appear in the list.
     * If none of the tracks match the specified value then no output should be produced.
     * We can't actually play the tracks so for testing purposes displaying the track details on the screen will be considered equivalent to playing the track.
     * You may find it useful to develop additional methods that help simplify or improve the efficiency of some operations.
     */

    public void playIf(String artist){
        artist.toLowerCase();
        String test;

        for(int i=0;i<trackCount;i++){
            test = this.playlist[i].getArtist().toLowerCase();

            if(test.contains(artist) == true || artist.contains(test) == true){
                System.out.println(playlist[i]);

            }
        }
    }

    public void playIf(int year){
        if(year > 999 && year < 10000){
            for(int i=0;i<trackCount;i++){
                if(this.playlist[i].getYear() == year){
                    System.out.println(playlist[i]);

                }
            }
        }
    }

    //This method calls every current track in our playlist and envokes the "toString()" method in our Track objects. <--- no longer accurate!!.
    //It returns the string as a list.
    //It is controled by the current "trackCount."
    public String showList(){
        String re = "";
        if(trackCount > 0){
            for (int i = 0; i < this.trackCount; i++){
                re += (this.playlist[i] +"\n");
            }
        }
        //If the playlist is empty:
        else{
            re = "The list is empty";
        }
        return re;
    }

    public String toString(){
        // needs to be modified (I'm not sure that only printing out the list of tracks here is correct).
        // There are still the trackCount values and the playlistName to consider.
        //(That said, I'm still not sure how to get the playlist name value yet. :/ )
        String re = "";;
        for (int i = 0; i < playlist.length; i++){
            re += (this.playlist[i] +"\n");
        }
        return re;
    }

    //"Set" and "Get" for playlist name.
    public void setPlaylistName(String n){
        playlistName = n;
    }

    public String getPlaylistName(){
        return playlistName;
    }
}
