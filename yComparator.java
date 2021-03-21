package pro12;
import java.util.Comparator;

public class yComparator implements Comparator<Point> {

    public int compare(Point fst, Point snd){
        if(fst.y <= snd.y)
            return 1;
        else
            return 0;
    }
}
