import java.util.Arrays;
import java.util.Scanner;


public class l2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var n = in.nextInt(); // 100000
        var array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = in.nextInt();  // array[i] = n - i;
        }


        System.out.println(MaxTrio(array));
        System.out.println(Arrays.toString(array));
    }

    public static long MaxTrio(int[] array) {
        int l = array.length;
        MergeSort(array, 1, l);
        if (array[0] * array[1] > array[l - 2] * array[l - 1]) {
            return (long)array[0] * (long)array[1] * (long)array[l - 1];
        }
        return (long)array[l - 3] * (long)array[l - 2] * (long)array[l - 1];
    }

    public static void MergeSort(int[] A, int p, int r) {
        if (p < r){
            int q = (p + r) / 2;
            MergeSort(A, p, q);
            MergeSort(A, q + 1, r);
            Merge(A, p, q, r);
        }
    }
    public static void Merge(int[] A, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++){
            L[i] = A[p + i - 1];
        }
        for (int j = 0; j < n2; j++){
            R[j] = A[q + j];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p - 1; k < r; k++){
            if (L[i] <= R[j]){
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }
}