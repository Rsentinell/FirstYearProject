
/**
 * Write a description of class Playlist here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Playlist
{
    private String playlistName = "Unknown";
    private int trackCount = 0;
    private Track[] playlist;

    // Constructors
    public Playlist(){       
        this.playlist = new Track[100];
    }

    // This constructor takes a string input and saves it to our playlistName String, This way we can store the name of the playlist when we construct it, instead of using a "set" later. 
    // (the "set" option is still there, just not required) 
    public Playlist(String name){
        this.playlistName = name;        
        this.playlist = new Track[100];
    }

    // Start of "add" methods
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

    // This method adds a track to the playlist when only the title is supplied, (was created for tests and some "unusual" track constructor calls).
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

    // Remove method
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

    // Playback methods
    /*    · A playAll method that plays all the tracks in the list either in sequence or randomly.
    Passing the value false as a parameter plays the tracks sequentially 
    (i.e. in the sequence they appear in the list).
    Passing the value true as a parameter plays the tracks randomly. 
    When playing tracks randomly each track should be played only once. 
    In addition, playing the tracks randomly should NOT alter the sequence of the tracks in the list.
    The method header is as follows (spec)
     */
    public void playAll(boolean random){

        // This checks the playlist to see if it is empty or not.
        if(trackCount != 0){
            if(random == true){
                int[] shuffle = new int [trackCount];
                int temp, rand1, rand2;

                // This creates an array of numbers that represent track positions
                for(int i=0;i<trackCount;i++){
                    shuffle[i] = i;
                }

                // This shuffles up the numbers on our new array
                for(int i=0;i<200;i++){
                    rand1 = (int)(Math.random()*trackCount);
                    rand2 = (int)(Math.random()*trackCount);

                    temp = shuffle[rand1];  
                    shuffle[rand1] = shuffle[rand2];
                    shuffle[rand2] = temp;

                }

                // This plays all the tracks in the order that has been shuffled
                for (int i = 0; i < trackCount; i++){
                    System.out.println(this.playlist[shuffle[i]]);
                }
            }
            else{
                // This plays all the tracks in the order they are listed (not shuffled)
                for (int i = 0; i < trackCount; i++){
                    System.out.println(this.playlist[i]);
                }

            }
        }

        //In case the list is empty
        else{
            System.out.println("The playlist is empty"); 
        }
    }

    /* â€¢    A playIf method that plays tracks in the list that satisfy specified criteria. The playIf method is overloaded as follows
     * public playIf(String artist)
     * public playIf(int year)
     * The first method will play all tracks in the list that contain the text specified (upper or lower case) in the artist name. For example, playIf("eagles") or 
     * playIf("EAGLES") or playIf("THE eagles") should play all the tracks in the list that have the specified strings somewhere/anywhere in the artist name.
     * The second method will play all tracks that were released in the specified year. 
     * The tracks should be played in the sequence they appear in the list.
     * If none of the tracks match the specified value then no output should be produced.
     * We canâ€™t actually play the tracks so for testing purposes displaying the track details on the screen will be considered equivalent to playing the track.
     * You may find it useful to develop additional methods that help simplify or improve the efficiency of some operations.
     */

    public void playIf(String artist){
        artist = artist.toLowerCase();
        String test;

        // This method takes an incoming string and compares it to the stored "Artist" string in our tracks.
        // If the track artist stored contains the same name as the artist asked for on the incoming string, the track will be "played".
        for(int i=0;i<trackCount;i++){
            test = this.playlist[i].getArtist().toLowerCase();

            if(test.contains(artist) == true || artist.contains(test) == true){
                System.out.println(playlist[i]);

            }
        }
    }

    
    // This method takes an incoming int and compares it to the stored "year" int in our tracks.
    // If the two are equal, the track will be "played". 
    public void playIf(int year){
        if(year > 999 && year < 10000){
            for(int i=0;i<trackCount;i++){
                if(this.playlist[i].getYear() == year){
                    System.out.println(playlist[i]);

                }
            }
        }
    }

    // This method calls every current track in our playlist and envokes the "toString()" method in our Track objects. 
    // It adds each one to our temporary string using a for loop, and returns the string as a list.
    // It is controled by the current "trackCount." 
    public String showList(){
        String re = "";
        if(trackCount > 0){
            for (int i = 0; i < this.trackCount; i++){
                re += ((i+1) + " "+this.playlist[i] +"\n");
            }
        }
        // If the playlist is empty the method will return:
        else{
            re = "The list is empty";
        }
        return re;
    }

    // This method creates a temporary string and adds the stored "playlistName" and "trackCount" variables to the temporary string.
    // It then calls every current track in our playlist, and envokes the "toString()" method in our Track objects. 
    // It adds each one to our temporary string using a for loop, and returns the string as a list.

    public String toString(){
        // needs to be modified (I'm not sure that only printing out the list of tracks here is correct).
        // There are still the trackCount values and the playlistName to consider.
        String re = ("\n" + "Playlist Name: " + this.playlistName + "\n" + "Number of tracks: " + this.trackCount + "\n \n");;
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

    public int getTrackCount(){
        return trackCount;
    }
}
