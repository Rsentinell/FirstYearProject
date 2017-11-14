
/**
 * Write a description of class TempMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TempMain
{
    public static void main (String[] args){
        String playList[];
        Track aTrack;
        Track temp1= new Track("look here","jumping",1943,201);
        Track temp2= new Track();
        Track temp3= new Track("John","seeting",1977,181);
        aTrack = new Track("Slow Hands","Niall Horan",2017,188);
        
        for (int j=0;j<2;j++){
            //playList[j] = (Track temp = new Track("Rasto","jumping",1943,201));
            //Track temp + (j) = new Track("Patrick","jumping",1981,156);
        }
        
        //getString()  == "Artist: rasto      "
        
        System.out.println(temp1);
        // System.out.println(temp1.getArtist());
        // System.out.println(temp1.getYear());
        // System.out.println(temp1.getDuration());
        System.out.println();
         System.out.println(temp2.toString());
        System.out.println(aTrack);
        // System.out.println(temp2.getDuration());
    }
}
