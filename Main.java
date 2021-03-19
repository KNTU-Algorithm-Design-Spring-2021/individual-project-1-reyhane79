import java.util.Scanner;
public class Main {
    //baraye negahdari zoje moratab (minimum, maximum)
    static class Pair {
        int min;
        int max;
    }
    //jostoju min o max be raveshe copare in pairs
    static class MinMax {
        static Pair getMinMax(int arr[], int n) {
        Pair minmax = new Pair();
        int i;
        //agar tedad azaye array fard bashad 2 ozv ebtedaee ra min o max dar nazar migirim
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
            
        } 
        else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
        }
 
        //moghayeseye aza ba min va max
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
            i += 2;
        }
 
        return minmax;
    }
    }
 
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many points do you want to enter?:");
        int n = scanner.nextInt();
        //array baraye negahdari x noghat
        int[] x = new int[n];
        //array baraye negahdari y noghat
        int[] y = new int[n];
        for(int i=0; i< n ; i++){
            System.out.println("Point "+(i+1)+":");
            System.out.println("Enter X:");
            x[i] = scanner.nextInt();
            System.out.println("Enter Y:");
            y[i] = scanner.nextInt();
        }
        MinMax compare = new MinMax();
        Pair minmaxX = compare.getMinMax(x, x.length);
        Pair minmaxY = compare.getMinMax(y, y.length);
        System.out.println("\nRectangle:\n("+minmaxX.min+" , "+minmaxY.min+")   ("+minmaxX.min+" , "+minmaxY.max+")");
        System.out.println("("+minmaxX.max+" , "+minmaxY.min+")  ("+minmaxX.max+" , "+minmaxY.max+")");
 
    }
}
