package pro12;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Vector;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Tools tool = new Tools();
        Vector<Point> v = new Vector<Point>();
        Scanner points = new Scanner(System.in);

        // Read values and write into a vector.
        System.out.println("How many points do you want to enter?:");
        int n = points.nextInt();
        Point tempPoint = new Point();
        for(int i = 0 ; i<n ; i++){
            tempPoint = new Point();
            System.out.println("Point "+ (i+1) + ":");
            System.out.print("X: ");
            tempPoint.x = points.nextInt();
            System.out.print("Y: ");
            tempPoint.y = points.nextInt();
            System.out.print("Z: ");
            tempPoint.z = points.nextInt();
            v.add(tempPoint);
        }

        Vector<Point> vx = new Vector<Point>(v);
        Collections.copy(vx, v);
        Vector<Point> vy = new Vector<Point>(v);
        Collections.copy(vy, v);

        xComparator compare_x = new xComparator();
        Collections.sort(vx, compare_x);  // Sort vx in terms of x coordinates.

        yComparator compare_y = new yComparator();
        Collections.sort(vy, compare_y);  // Sort vy in terms of y coordinates.

        //va array to copy vector
        Object[] objArray = v.toArray();
        Point[] va = Arrays.copyOf(objArray,
                objArray.length,
                Point[].class);

        //vax array to copy vector
        Object[] objArray2 = vx.toArray();
        Point[] vax = Arrays.copyOf(objArray2,
                objArray2.length,
                Point[].class);

        //vay array to copy vector
        Object[] objArray3 = vy.toArray();
        Point[] vay = Arrays.copyOf(objArray3,
                objArray3.length,
                Point[].class);

        System.out.println("The distance is : " + tool.divideandConquer(vax, vay, v.size()));
    }
}