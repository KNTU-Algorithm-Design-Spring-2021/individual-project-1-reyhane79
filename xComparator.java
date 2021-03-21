package pro12;
import java.util.Comparator;

public class xComparator implements Comparator<Point> {

    public int compare(Point fst, Point snd){
        if(fst.x > snd.x)
            return 0;
        else
            return 1;
    }

}
