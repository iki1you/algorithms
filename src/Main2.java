//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Hashtable;
//import java.util.Scanner;
//
//public class Main2 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        var n = in.nextInt();
//        var k = in.nextInt();
//        var priority = new int[k];
//        for (int i = 0; i < k; i++){
//            priority[i] = in.nextInt();
//        }
//        var names = new String[n];
//        var data = new int[n][k];
//        for (int i = 0; i < n; i++){
//            names[i] = in.next();
//            for (int j = 0; j < k; j++) {
//                data[j][i] = in.nextInt();
//            }
//        }
//
//        var dataPermutations = Permutations(new ArrayList<>(), new int[n], n, n, data[priority[0] - 1]);
//        for (int[] i: dataPermutations){
//            System.out.println(Arrays.toString(i));
//        }
//
//    }
//
//    public static ArrayList<int[]> Permutations(ArrayList<int[]> result, int[] array, int n, int k, int[] sortData) {
//        if (k == 0)
//        {
//            for (int i: sortData){
//                if
//            }
//            result.add(array);
//            return result;
//        }
//        for (int i = 0; i < n; i++){
//            if (array[i] == 0) {
//                int[] temp = array.clone();
//                temp[i] = k;
//                Permutations(result, temp, n, k - 1, sortData);
//            }
//        }
//        return result;
//    }
//
//    public static void MergeSort(int[] A, int p, int r){
//        if (p < r){
//            int q = (p + r) / 2;
//            MergeSort(A, p, q);
//            MergeSort(A, q + 1, r);
//            Merge(A, p, q, r);
//        }
//    }
//    public static void Merge(int[] A, int p, int q, int r){
//        int n1 = q - p + 1;
//        int n2 = r - q;
//        int[] L = new int[n1 + 1];
//        int[] R = new int[n2 + 1];
//        for (int i = 0; i < n1; i++){
//            L[i] = A[p + i - 1];
//        }
//        for (int j = 0; j < n2; j++){
//            R[j] = A[q + j];
//        }
//        L[n1] = Integer.MAX_VALUE;
//        R[n2] = Integer.MAX_VALUE;
//        int i = 0;
//        int j = 0;
//        for (int k = p - 1; k < r; k++){
//            if (L[i] <= R[j]){
//                A[k] = L[i];
//                i++;
//            } else {
//                A[k] = R[j];
//                j++;
//            }
//        }
//    }
//}

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main2 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        var n = in.nextInt(); // 100000
//        var array = new int[n];
//        for (int i = 0; i < n; i++){
//            array[i] = in.nextInt();  // array[i] = n - i;
//        }
//        MergeSort(array, 1, n);
//        System.out.println(Arrays.toString(array));
//        System.out.println((long)array[n - 1] * (long)array[n - 2] * (long)array[n - 3]);
//    }
//
//    public static void MergeSort(int[] A, int p, int r){
//        if (p < r){
//            int q = (p + r) / 2;
//            MergeSort(A, p, q);
//            MergeSort(A, q + 1, r);
//            Merge(A, p, q, r);
//        }
//    }
//
//    public static void Merge(int[] A, int p, int q, int r){
//        int n1 = q - p + 1;
//        int n2 = r - q;
//        int[] L = new int[n1 + 1];
//        int[] R = new int[n2 + 1];
//        for (int i = 0; i < n1; i++){
//            L[i] = A[p + i - 1];
//        }
//        for (int j = 0; j < n2; j++){
//            R[j] = A[q + j];
//        }
//        L[n1] = Integer.MAX_VALUE;
//        R[n2] = Integer.MAX_VALUE;
//        int i = 0;
//        int j = 0;
//        for (int k = p - 1; k < r; k++){
//            if (L[i] <= R[j]){
//                A[k] = L[i];
//                i++;
//            } else {
//                A[k] = R[j];
//                j++;
//            }
//        }
//    }
//}