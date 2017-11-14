
/**
 * Write a description of class Track here.
 *
 * @author Jonathan Ryley 17244501, Rasto
 * @version (a version number or a date)
 * 
 * (Spec)
 * The Track class will be used to store the details of each individual track. 
 * The Track class should have the following data items (i.e. instance values)  
•   A String for the track title  
•   A String for the name of the artist 
•   An int for the year the track was released
•   An int for the track duration (in seconds)
 * The Track class should provide appropriate constructor(s), toString and set/get methods for the data items stored in the class.

 */
public class Track{
    //Still wondering about the initial values of our ints here. 
    //If no value has been input for duration, does that now mean the track has no length or does it mean the length is unknown? 
    //If the latter, then a return of Zero is not correct.
    //The same question applies for year.    I think perhaps this problem can be solved by throwing in a few "if" statements into the toString() method. 

    //We initialised these ints with 4 zeroes and 3 zeroes, to remind us what the length of the expexted values should look like.
    private int year = 0000, duration = 000;

    //We initialised these strings as "<Empty>" and Unknown, 
    //because we want a title name that is unlikely to be selected when we represent an empty track space on the playlist
    //The Unknown just means we haven't been told who the artist is.
    private String title="<Empty>", artist="Unknown";                 // need to add, returnString=""; for toString()

    //Set of constructors:
    //We wanted to cover every likely combination of string(s)/int(s).  

    public Track(){
        //Empty construct for possible empty placeholders on the playlist string 
    }

    public Track(String t){
        //For the lonely track with a name but no "friends".
        this.title = t;
    }

    public Track(String t, int y){
        //This assumes the string will be the title, and guesses what the int value refers to.
        title = t;

        //This if statement set checks the int input and decides if it is a year length or a duration length.
        //A year length is assumed to be given in 4 digits eg. "2017" 
        if(y < 10000 && y > 0){
            if(y > 999){
                this.year = y;
            }
            else{
                this.duration = y;
            }
        }
    }

    public Track(String t, String a, int d){
        //This assumes that the first two strings are the Title and the Artist(In that order) and also guesses what the int value refers to.
        title = t;
        artist = a;

        //Same as previous constructor.
        if(d < 10000 && d > 0){
            if(d > 999){
                this.year = d;
            }
            else {
                this.duration = d;
            }           
        }
    }

    public Track(String t, String a, int y, int d){
        //when all information is provided (Yay)
        this.title = t;
        this.artist = a;
        year = y;
        duration = d;
    }

    //Set and Gets:
    //Set and get title.
    public String getTitle(){
        return title;
    }

    public void setTitle(String t){
        title = t;
    }

    //Set and get artist.
    public String getArtist(){
        return artist;
    }

    public void setArtist(String a){
        artist = a;
    }

    //Set and get year.
    public int getYear(){
        return year;
    }

    public void setYear(int y){
        //The year input must be 4 digits long, else no change will be made. 
        //Originally used an if nested in an if but && seems more tidy.
        if(y < 10000 && y > 999){
            year = y;
        }
    }

    //Set and get duration.
    public int getDuration(){
        return duration;
    }

    public void setDuration(int d){
        // duration must be 3 digits long or less, else no change will be made
        if(d < 1000 && d > 0){
            duration = d;
        }
    }

    //Combining the stored information into a tidy string.
    public String toString(){
        //Functions but:{Still needs work]
        return ("Title: "+title+" Artist: "+artist+"  Year: "+year+" Duration: "+duration+" seconds.");
        //String t, String a, int y, int d
    }

}

