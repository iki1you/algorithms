import java.util.Arrays;
import java.util.Scanner;


public class l2_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var n = in.nextInt();
        var m = in.nextInt();
        var array = new Point[n * 2 + m];
        for (int i = 0; i < n * 2; i+=2){
            int a = in.nextInt();
            int b = in.nextInt();
            array[i] = new Point(Math.min(a, b), -1, -1);
            array[i + 1] = new Point(Math.max(a, b), 1, -1);
        }
        for (int i = n * 2; i < (n * 2 + m) ; i++){
            array[i] = new Point(in.nextInt(), 0, i - n * 2);
        }

        Arrays.sort(array, (Point a, Point b) -> {
            if (a.x != b.x) {
                return Integer.compare(a.x, b.x);
            } else {
                return Integer.compare(a.type, b.type);
            }
        });

        QuickSort(array, 1, array.length - 1);


        int[] result = new int[m];
        int k = 0;

        for (var i: array){
            if (i.type == -1) {
                k++;
            } else if (i.type == 1) {
                k--;
            } else {
                result[i.index] = k;
            }
        }

        for (int i = 0; i < m; i++){
            if (i != 0){
                System.out.print(' ');
            }
            System.out.print(result[i]);
        }
    }

    public static void QuickSort(Point[] arr, int p, int r){
        if (p < r) {
            int q = Partition(arr, p, r);
            QuickSort(arr, p, q - 1);
            QuickSort(arr, q + 1, r);
        }
    }

    public static int Partition(Point[] arr, int p, int r) {
        Point x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (CompareSmaller(arr[j], x)){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    public static int ComparePoints(Point a, Point b){
        if (a.x != b.x) {
            return Integer.compare(a.x, b.x);
        } else {
            return Integer.compare(a.type, b.type);
        }
    }

    public static boolean CompareSmaller(Point a, Point b) {
        if (ComparePoints(a, b) == -1) {
            return true;
        }
        return false;
    }

    public static void swap(Point[] arr, int i, int j){
        Point temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class Point {
    int x;
    int type; // -1 = left, 0 = point, 1 - right
    int index;

    Point(int cord, int t, int i){
        x = cord;
        type = t;
        index = i;
    }
}