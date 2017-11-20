
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

        Playlist Test = new Playlist();
        //int test2 = Test.getLength(); <-- I need to practice the syntax for this
        for(int i=0;i< 100 ;i++){
            Test.add("Track" + (i+1));

        }

        //Test.remove(99); 
        System.out.println(Test.play(false));

        System.out.println(Test.play(true));
        
        
        Playlist Dermott1 = new Playlist();
        Dermott1.add("Dermott");
        Dermott1.add("Lols");
        Dermott1.add(temp1);
        Dermott1.add(temp3);
        Dermott1.add("Dermott");
        Dermott1.add("Lols");
        Dermott1.add(temp1);
        Dermott1.add(temp3);

        //System.out.println(Dermott1.showList());
        //Dermott1.remove(9);
        //System.out.println(Dermott1.showList());

    }

}
