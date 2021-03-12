package pkg3dclosest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
      Tools t = new Tools();
      Vector<Point> v = new Vector<Point>();
      Scanner scanner = new Scanner(System.in);
      
      // Read values and write into a vector.
      System.out.println("How many points do you want to enter?:");
      int n = scanner.nextInt();
      Point tempPoint = new Point();
      for(int i = 0 ; i<n ; i++){
          tempPoint = new Point();
           System.out.println("Point "+ (i+1) + ":");
          System.out.print("X: ");
          tempPoint.x = scanner.nextInt();
          System.out.print("Y: ");
          tempPoint.y = scanner.nextInt();
          System.out.print("Z: ");
          tempPoint.z = scanner.nextInt();
          v.add(tempPoint);
      }
      
      Vector<Point> vx = new Vector<Point>(v);
      Collections.copy(vx, v);
      Vector<Point> vy = new Vector<Point>(v);
      Collections.copy(vy, v);
      
      xComparator compare_x = new xComparator();
      Collections.sort(vx, compare_x);  // Sort vx in terms of x coordinates. O(nlogn) sorting complexity.
      
      yComparator compare_y = new yComparator();
      Collections.sort(vy, compare_y);  // Sort vy in terms of y coordinates. O(nlogn) sorting complexity.

      // Initialize "va" array to copy vector and use it in recursive calls.
      Object[] objArray = v.toArray();
      Point[] va = Arrays.copyOf(objArray, 
                                       objArray.length, 
                                       Point[].class); 

      // Initialize "vax" array to copy vector and use it in recursive calls.
      Object[] objArray2 = vx.toArray();
      Point[] vax = Arrays.copyOf(objArray2, 
                                       objArray2.length, 
                                       Point[].class); 

       // Initialize "vay" array to copy vector and use it in recursive calls.
      Object[] objArray3 = vy.toArray();
      Point[] vay = Arrays.copyOf(objArray3, 
                                       objArray3.length, 
                                       Point[].class); 
      System.out.println( "The distance is (Bruteforce): " + t.closest(va, v.size()) );

      System.out.println( "Number of total distance calculations is (Bruteforce): "+t.distance_calc);

      t.distance_calc = 0;

      System.out.println("The distance is (Divide & Conquer): " + t.divideandConquer(vax, vay, v.size()));
      System.out.println( "Number of total distance calculations is (Divide & Conquer): "+ t.distance_calc); 
    }
}
