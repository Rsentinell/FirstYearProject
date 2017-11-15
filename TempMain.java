
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

        Playlist Dermott1 = new Playlist();
        Dermott1.add("Dermott");
        Dermott1.add("Lols");
        Dermott1.add(temp1);
        Dermott1.add(temp3);
        Dermott1.add("Dermott");
        Dermott1.add("Lols");
        Dermott1.add(temp1);
        Dermott1.add(temp3);

   
        System.out.println(Dermott1.showList());
        Dermott1.remove(7);
        System.out.println(Dermott1.showList());

    }
}
